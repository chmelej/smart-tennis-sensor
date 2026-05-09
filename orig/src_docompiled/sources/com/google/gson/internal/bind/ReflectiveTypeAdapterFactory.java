package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> getFieldNames(Field field) {
        return getFieldName(this.fieldNamingPolicy, field);
    }

    static List<String> getFieldName(FieldNamingStrategy fieldNamingStrategy, Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        LinkedList linkedList = new LinkedList();
        if (serializedName == null) {
            linkedList.add(fieldNamingStrategy.translateName(field));
        } else {
            linkedList.add(serializedName.value());
            String[] strArrAlternate = serializedName.alternate();
            for (String str : strArrAlternate) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private BoundField createBoundField(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z, boolean z2) {
        final boolean zIsPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final TypeAdapter<?> typeAdapter;

            {
                this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(gson, field, typeToken);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException {
                new TypeAdapterRuntimeTypeWrapper(gson, this.typeAdapter, typeToken.getType()).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IllegalAccessException {
                Object obj2 = this.typeAdapter.read2(jsonReader);
                if (obj2 == null && zIsPrimitive) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeAdapter<?> getFieldAdapter(Gson gson, Field field, TypeToken<?> typeToken) {
        TypeAdapter<?> typeAdapter;
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        return (jsonAdapter == null || (typeAdapter = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter)) == null) ? gson.getAdapter(typeToken) : typeAdapter;
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, z);
                if (zExcludeField || zExcludeField2) {
                    field.setAccessible(true);
                    Type typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    BoundField boundField = null;
                    int i2 = 0;
                    while (i2 < fieldNames.size()) {
                        String str = fieldNames.get(i2);
                        boolean z2 = i2 != 0 ? false : zExcludeField;
                        BoundField boundField2 = boundField;
                        int i3 = i2;
                        List<String> list = fieldNames;
                        Type type2 = typeResolve;
                        Field field2 = field;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(typeResolve), z2, zExcludeField2)) : boundField2;
                        i2 = i3 + 1;
                        zExcludeField = z2;
                        typeResolve = type2;
                        fieldNames = list;
                        field = field2;
                    }
                    BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i++;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj);

        abstract void write(JsonWriter jsonWriter, Object obj);

        abstract boolean writeField(Object obj);

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        private Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T tConstruct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, tConstruct);
                    }
                }
                jsonReader.endObject();
                return tConstruct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
