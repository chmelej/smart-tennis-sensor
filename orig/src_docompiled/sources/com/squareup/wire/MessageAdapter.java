package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
final class MessageAdapter<M extends Message> {
    private static final String FULL_BLOCK = "█";
    private static final String REDACTED = "██";
    private final Class<Message.Builder<M>> builderType;
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    public static final class FieldInfo {
        private final Field builderField;
        final Message.Datatype datatype;
        EnumAdapter<? extends ProtoEnum> enumAdapter;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        MessageAdapter<? extends Message> messageAdapter;
        private final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        /* JADX WARN: Multi-variable type inference failed */
        private FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, boolean z, Class<?> cls, Field field, Field field2) {
            this.tag = i;
            this.name = str;
            this.datatype = datatype;
            this.label = label;
            this.redacted = z;
            if (datatype == Message.Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype == Message.Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderField = field2;
        }
    }

    Message.Builder<M> newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if (num == null) {
            return null;
        }
        return this.fieldInfoMap.get(num.intValue());
    }

    Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(m);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    public void setBuilderField(Message.Builder<M> builder, int i, Object obj) {
        try {
            this.fieldInfoMap.get(i).builderField.set(builder, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    MessageAdapter(Wire wire, Class<M> cls) {
        Field[] fieldArr;
        this.wire = wire;
        this.messageType = cls;
        this.builderType = getBuilderType(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int iTag = protoField.tag();
                String name = field.getName();
                this.tagMap.put(name, Integer.valueOf(iTag));
                Class messageType = null;
                Message.Datatype datatypeType = protoField.type();
                if (datatypeType == Message.Datatype.ENUM) {
                    messageType = getEnumType(field);
                } else if (datatypeType == Message.Datatype.MESSAGE) {
                    messageType = getMessageType(field);
                }
                fieldArr = declaredFields;
                linkedHashMap.put(Integer.valueOf(iTag), new FieldInfo(iTag, name, datatypeType, protoField.label(), protoField.redacted(), messageType, field, getBuilderField(name)));
            } else {
                fieldArr = declaredFields;
            }
            i++;
            declaredFields = fieldArr;
        }
        this.fieldInfoMap = TagMap.m8679of(linkedHashMap);
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            return (Class<Message.Builder<M>>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field getBuilderField(String str) {
        try {
            return this.builderType.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + this.builderType.getName() + "." + str);
        }
    }

    private Class<? extends Message> getMessageType(Field field) {
        Class type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).messageType();
        }
        return null;
    }

    private Class<? extends Enum> getEnumType(Field field) {
        Class type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).enumType();
        }
        return null;
    }

    int getSerializedSize(M m) {
        int extensionsSerializedSize = 0;
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                int i = fieldInfo.tag;
                Message.Datatype datatype = fieldInfo.datatype;
                Message.Label label = fieldInfo.label;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        extensionsSerializedSize += getPackedSize((List) fieldValue, i, datatype);
                    } else {
                        extensionsSerializedSize += getRepeatedSize((List) fieldValue, i, datatype);
                    }
                } else {
                    extensionsSerializedSize += getSerializedSize(i, fieldValue, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                extensionsSerializedSize += getExtensionsSerializedSize(extendableMessage.extensionMap);
            }
        }
        return extensionsSerializedSize + m.getUnknownFieldsSerializedSize();
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int serializedSize;
        int i = 0;
        for (int i2 = 0; i2 < extensionMap.size(); i2++) {
            Extension<T, ?> extension = extensionMap.getExtension(i2);
            Object extensionValue = extensionMap.getExtensionValue(i2);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (label.isRepeated()) {
                if (label.isPacked()) {
                    serializedSize = getPackedSize((List) extensionValue, tag, datatype);
                } else {
                    serializedSize = getRepeatedSize((List) extensionValue, tag, datatype);
                }
            } else {
                serializedSize = getSerializedSize(tag, extensionValue, datatype);
            }
            i += serializedSize;
        }
        return i;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int serializedSize = 0;
        while (it.hasNext()) {
            serializedSize += getSerializedSize(i, it.next(), datatype);
        }
        return serializedSize;
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int serializedSizeNoTag = 0;
        while (it.hasNext()) {
            serializedSizeNoTag += getSerializedSizeNoTag(it.next(), datatype);
        }
        return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(serializedSizeNoTag) + serializedSizeNoTag;
    }

    void write(M m, WireOutput wireOutput) {
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                int i = fieldInfo.tag;
                Message.Datatype datatype = fieldInfo.datatype;
                Message.Label label = fieldInfo.label;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        writePacked(wireOutput, (List) fieldValue, i, datatype);
                    } else {
                        writeRepeated(wireOutput, (List) fieldValue, i, datatype);
                    }
                } else {
                    writeValue(wireOutput, i, fieldValue, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        for (int i = 0; i < extensionMap.size(); i++) {
            Extension<T, ?> extension = extensionMap.getExtension(i);
            Object extensionValue = extensionMap.getExtensionValue(i);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (label.isRepeated()) {
                if (label.isPacked()) {
                    writePacked(wireOutput, (List) extensionValue, tag, datatype);
                } else {
                    writeRepeated(wireOutput, (List) extensionValue, tag, datatype);
                }
            } else {
                writeValue(wireOutput, tag, extensionValue, datatype);
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            writeValue(wireOutput, i, it.next(), datatype);
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        int serializedSizeNoTag = 0;
        while (it.hasNext()) {
            serializedSizeNoTag += getSerializedSizeNoTag(it.next(), datatype);
        }
        wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
        wireOutput.writeVarint32(serializedSizeNoTag);
        Iterator<?> it2 = list.iterator();
        while (it2.hasNext()) {
            writeValueNoTag(wireOutput, it2.next(), datatype);
        }
    }

    byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append("{");
        String str = "";
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                sb.append(str);
                str = ", ";
                sb.append(fieldInfo.name);
                sb.append("=");
                if (fieldInfo.redacted) {
                    fieldValue = REDACTED;
                }
                sb.append(fieldValue);
            }
        }
        if (m instanceof ExtendableMessage) {
            sb.append(str);
            sb.append("{extensions=");
            sb.append(((ExtendableMessage) m).extensionsToString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }

    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        switch (datatype) {
            case INT32:
                return WireOutput.int32Size(((Integer) obj).intValue());
            case INT64:
            case UINT64:
                return WireOutput.varint64Size(((Long) obj).longValue());
            case UINT32:
                return WireOutput.varint32Size(((Integer) obj).intValue());
            case SINT32:
                return WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
            case SINT64:
                return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
            case BOOL:
                return 1;
            case ENUM:
                return getEnumSize((ProtoEnum) obj);
            case STRING:
                int iUtf8Length = utf8Length((String) obj);
                return WireOutput.varint32Size(iUtf8Length) + iUtf8Length;
            case BYTES:
                int size = ((ByteString) obj).size();
                return WireOutput.varint32Size(size) + size;
            case MESSAGE:
                return getMessageSize((Message) obj);
            case FIXED32:
            case SFIXED32:
            case FLOAT:
                return 4;
            case FIXED64:
            case SFIXED64:
            case DOUBLE:
                return 8;
            default:
                throw new RuntimeException();
        }
    }

    private int utf8Length(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                i2++;
            } else if (cCharAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    private <M extends Message> int getMessageSize(M m) {
        int serializedSize = m.getSerializedSize();
        return WireOutput.varint32Size(serializedSize) + serializedSize;
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
                wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                return;
            case INT64:
            case UINT64:
                wireOutput.writeVarint64(((Long) obj).longValue());
                return;
            case UINT32:
                wireOutput.writeVarint32(((Integer) obj).intValue());
                return;
            case SINT32:
                wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                return;
            case SINT64:
                wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                return;
            case BOOL:
                wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case ENUM:
                writeEnum((ProtoEnum) obj, wireOutput);
                return;
            case STRING:
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                wireOutput.writeVarint32(bytes.length);
                wireOutput.writeRawBytes(bytes);
                return;
            case BYTES:
                ByteString byteString = (ByteString) obj;
                wireOutput.writeVarint32(byteString.size());
                wireOutput.writeRawBytes(byteString.toByteArray());
                return;
            case MESSAGE:
                writeMessage((Message) obj, wireOutput);
                return;
            case FIXED32:
            case SFIXED32:
                wireOutput.writeFixed32(((Integer) obj).intValue());
                return;
            case FLOAT:
                wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case FIXED64:
            case SFIXED64:
                wireOutput.writeFixed64(((Long) obj).longValue());
                return;
            case DOUBLE:
                wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    M read(WireInput wireInput) throws IOException {
        Message.Datatype datatype;
        Message.Label label;
        Extension<ExtendableMessage<?>, ?> extension;
        long j;
        try {
            Message.Builder<M> builderNewInstance = this.builderType.newInstance();
            Storage storage = new Storage();
            while (true) {
                int tag = wireInput.readTag();
                int i = tag >> 3;
                WireType wireTypeValueOf = WireType.valueOf(tag);
                if (i == 0) {
                    Iterator<Integer> it = storage.getTags().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        if (this.fieldInfoMap.containsKey(iIntValue)) {
                            setBuilderField(builderNewInstance, iIntValue, storage.get(iIntValue));
                        } else {
                            setExtension((ExtendableMessage.ExtendableBuilder) builderNewInstance, getExtension(iIntValue), storage.get(iIntValue));
                        }
                    }
                    return (M) builderNewInstance.build();
                }
                FieldInfo fieldInfo = this.fieldInfoMap.get(i);
                if (fieldInfo != null) {
                    datatype = fieldInfo.datatype;
                    label = fieldInfo.label;
                    extension = null;
                } else {
                    Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                    if (extension2 == null) {
                        readUnknownField(builderNewInstance, wireInput, i, wireTypeValueOf);
                    } else {
                        datatype = extension2.getDatatype();
                        extension = extension2;
                        label = extension2.getLabel();
                    }
                }
                if (label.isPacked() && wireTypeValueOf == WireType.LENGTH_DELIMITED) {
                    int varint32 = wireInput.readVarint32();
                    long position = wireInput.getPosition();
                    int iPushLimit = wireInput.pushLimit(varint32);
                    while (true) {
                        j = position + ((long) varint32);
                        if (wireInput.getPosition() >= j) {
                            break;
                        }
                        Object value = readValue(wireInput, i, datatype);
                        if (datatype == Message.Datatype.ENUM && (value instanceof Integer)) {
                            builderNewInstance.addVarint(i, ((Integer) value).intValue());
                        } else {
                            storage.add(i, value);
                        }
                    }
                    wireInput.popLimit(iPushLimit);
                    if (wireInput.getPosition() != j) {
                        throw new IOException("Packed data had wrong length!");
                    }
                } else {
                    Object value2 = readValue(wireInput, i, datatype);
                    if (datatype == Message.Datatype.ENUM && (value2 instanceof Integer)) {
                        builderNewInstance.addVarint(i, ((Integer) value2).intValue());
                    } else if (label.isRepeated()) {
                        storage.add(i, value2);
                    } else if (extension != null) {
                        setExtension((ExtendableMessage.ExtendableBuilder) builderNewInstance, extension, value2);
                    } else {
                        setBuilderField(builderNewInstance, i, value2);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) {
        switch (datatype) {
            case INT32:
            case UINT32:
                return Integer.valueOf(wireInput.readVarint32());
            case INT64:
            case UINT64:
                return Long.valueOf(wireInput.readVarint64());
            case SINT32:
                return Integer.valueOf(WireInput.decodeZigZag32(wireInput.readVarint32()));
            case SINT64:
                return Long.valueOf(WireInput.decodeZigZag64(wireInput.readVarint64()));
            case BOOL:
                return Boolean.valueOf(wireInput.readVarint32() != 0);
            case ENUM:
                EnumAdapter<? extends ProtoEnum> enumAdapter = getEnumAdapter(i);
                int varint32 = wireInput.readVarint32();
                try {
                    return enumAdapter.fromInt(varint32);
                } catch (IllegalArgumentException unused) {
                    return Integer.valueOf(varint32);
                }
            case STRING:
                return wireInput.readString();
            case BYTES:
                return wireInput.readBytes();
            case MESSAGE:
                return readMessage(wireInput, i);
            case FIXED32:
            case SFIXED32:
                return Integer.valueOf(wireInput.readFixed32());
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(wireInput.readFixed32()));
            case FIXED64:
            case SFIXED64:
                return Long.valueOf(wireInput.readFixed64());
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(wireInput.readFixed64()));
            default:
                throw new RuntimeException();
        }
    }

    private Message readMessage(WireInput wireInput, int i) throws IOException {
        int varint32 = wireInput.readVarint32();
        if (wireInput.recursionDepth >= 64) {
            throw new IOException("Wire recursion limit exceeded");
        }
        int iPushLimit = wireInput.pushLimit(varint32);
        wireInput.recursionDepth++;
        Message message = getMessageAdapter(i).read(wireInput);
        wireInput.checkLastTagWas(0);
        wireInput.recursionDepth--;
        wireInput.popLimit(iPushLimit);
        return message;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.messageAdapter != null) {
            return fieldInfo.messageAdapter;
        }
        MessageAdapter<? extends Message> messageAdapter = this.wire.messageAdapter(getMessageClass(i));
        if (fieldInfo != null) {
            fieldInfo.messageAdapter = messageAdapter;
        }
        return messageAdapter;
    }

    private EnumAdapter<? extends ProtoEnum> getEnumAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.enumAdapter != null) {
            return fieldInfo.enumAdapter;
        }
        EnumAdapter<? extends ProtoEnum> enumAdapter = this.wire.enumAdapter(getEnumClass(i));
        if (fieldInfo != null) {
            fieldInfo.enumAdapter = enumAdapter;
        }
        return enumAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> getMessageClass(int i) {
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        Class<Message> cls = fieldInfo == null ? 0 : fieldInfo.messageType;
        return (cls != 0 || (extension = getExtension(i)) == null) ? cls : extension.getMessageType();
    }

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
        switch (wireType) {
            case VARINT:
                builder.ensureUnknownFieldMap().addVarint(i, Long.valueOf(wireInput.readVarint64()));
                return;
            case FIXED32:
                builder.ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(wireInput.readFixed32()));
                return;
            case FIXED64:
                builder.ensureUnknownFieldMap().addFixed64(i, Long.valueOf(wireInput.readFixed64()));
                return;
            case LENGTH_DELIMITED:
                builder.ensureUnknownFieldMap().addLengthDelimited(i, wireInput.readBytes(wireInput.readVarint32()));
                return;
            case START_GROUP:
                wireInput.skipGroup();
                return;
            case END_GROUP:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    static class Storage {
        private Map<Integer, ImmutableList<Object>> map;

        private Storage() {
        }

        void add(int i, Object obj) {
            ImmutableList<Object> immutableList = this.map == null ? null : this.map.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList<>();
                if (this.map == null) {
                    this.map = new LinkedHashMap();
                }
                this.map.put(Integer.valueOf(i), immutableList);
            }
            ((ImmutableList) immutableList).list.add(obj);
        }

        Set<Integer> getTags() {
            return this.map == null ? Collections.emptySet() : this.map.keySet();
        }

        List<Object> get(int i) {
            if (this.map == null) {
                return null;
            }
            return this.map.get(Integer.valueOf(i));
        }
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        Class<? extends ProtoEnum> cls = fieldInfo == null ? null : fieldInfo.enumType;
        return (cls != null || (extension = getExtension(i)) == null) ? cls : extension.getEnumType();
    }

    static class ImmutableList<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        private final List<T> list = new ArrayList();

        public Object clone() {
            return this;
        }

        ImmutableList() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.list.get(i);
        }
    }
}
