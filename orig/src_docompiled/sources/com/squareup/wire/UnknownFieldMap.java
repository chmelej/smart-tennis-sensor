package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
final class UnknownFieldMap {
    Map<Integer, List<FieldValue>> fieldMap;

    enum UnknownFieldType {
        VARINT,
        FIXED32,
        FIXED64,
        LENGTH_DELIMITED;

        /* JADX INFO: renamed from: of */
        public static UnknownFieldType m8680of(String str) {
            if ("varint".equals(str)) {
                return VARINT;
            }
            if ("fixed32".equals(str)) {
                return FIXED32;
            }
            if ("fixed64".equals(str)) {
                return FIXED64;
            }
            if ("length-delimited".equals(str)) {
                return LENGTH_DELIMITED;
            }
            throw new IllegalArgumentException("Unknown type " + str);
        }
    }

    static abstract class FieldValue {
        private final int tag;
        private final WireType wireType;

        public abstract int getSerializedSize();

        public abstract void write(int i, WireOutput wireOutput);

        public FieldValue(int i, WireType wireType) {
            this.tag = i;
            this.wireType = wireType;
        }

        public static VarintFieldValue varint(int i, Long l) {
            return new VarintFieldValue(i, l);
        }

        public static Fixed32FieldValue fixed32(int i, Integer num) {
            return new Fixed32FieldValue(i, num);
        }

        public static Fixed64FieldValue fixed64(int i, Long l) {
            return new Fixed64FieldValue(i, l);
        }

        public static LengthDelimitedFieldValue lengthDelimited(int i, ByteString byteString) {
            return new LengthDelimitedFieldValue(i, byteString);
        }

        public int getTag() {
            return this.tag;
        }

        public WireType getWireType() {
            return this.wireType;
        }

        public Integer getAsInteger() {
            throw new IllegalStateException();
        }

        public Long getAsLong() {
            throw new IllegalStateException();
        }

        public ByteString getAsBytes() {
            throw new IllegalStateException();
        }
    }

    static final class VarintFieldValue extends FieldValue {
        private final Long value;

        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return WireOutput.varint64Size(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.VARINT);
            wireOutput.writeVarint64(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }
    }

    static final class Fixed32FieldValue extends FieldValue {
        private final Integer value;

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return 4;
        }

        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.value = num;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED32);
            wireOutput.writeFixed32(this.value.intValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Integer getAsInteger() {
            return this.value;
        }
    }

    static final class Fixed64FieldValue extends FieldValue {
        private final Long value;

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return 8;
        }

        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED64);
            wireOutput.writeFixed64(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }
    }

    static final class LengthDelimitedFieldValue extends FieldValue {
        private final ByteString value;

        public LengthDelimitedFieldValue(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.value = byteString;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return WireOutput.varint32Size(this.value.size()) + this.value.size();
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(this.value.size());
            wireOutput.writeRawBytes(this.value.toByteArray());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public ByteString getAsBytes() {
            return this.value;
        }
    }

    UnknownFieldMap() {
    }

    UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }

    void addVarint(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.VARINT);
    }

    void addFixed32(int i, Integer num) throws IOException {
        addElement(ensureFieldMap(), i, num, WireType.FIXED32);
    }

    void addFixed64(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.FIXED64);
    }

    void addLengthDelimited(int i, ByteString byteString) throws IOException {
        addElement(ensureFieldMap(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        if (this.fieldMap == null) {
            this.fieldMap = new TreeMap();
        }
        return this.fieldMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) throws IOException {
        FieldValue fieldValueVarint;
        List<FieldValue> arrayList = map.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(Integer.valueOf(i), arrayList);
        }
        switch (wireType) {
            case VARINT:
                fieldValueVarint = FieldValue.varint(i, (Long) t);
                break;
            case FIXED32:
                fieldValueVarint = FieldValue.fixed32(i, (Integer) t);
                break;
            case FIXED64:
                fieldValueVarint = FieldValue.fixed64(i, (Long) t);
                break;
            case LENGTH_DELIMITED:
                fieldValueVarint = FieldValue.lengthDelimited(i, (ByteString) t);
                break;
            default:
                throw new IllegalArgumentException("Unsupported wireType = " + wireType);
        }
        if (arrayList.size() > 0 && arrayList.get(0).getWireType() != fieldValueVarint.getWireType()) {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", fieldValueVarint.getWireType(), arrayList.get(0).getWireType(), Integer.valueOf(i)));
        }
        arrayList.add(fieldValueVarint);
    }

    int getSerializedSize() {
        int iVarintTagSize = 0;
        if (this.fieldMap != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : this.fieldMap.entrySet()) {
                iVarintTagSize += WireOutput.varintTagSize(entry.getKey().intValue());
                Iterator<FieldValue> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    iVarintTagSize += it.next().getSerializedSize();
                }
            }
        }
        return iVarintTagSize;
    }

    void write(WireOutput wireOutput) {
        if (this.fieldMap != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : this.fieldMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                Iterator<FieldValue> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    it.next().write(iIntValue, wireOutput);
                }
            }
        }
    }
}
