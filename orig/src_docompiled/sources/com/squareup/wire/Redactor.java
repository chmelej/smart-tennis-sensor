package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Redactor<T extends Message> {
    private static final Redactor<?> NOOP_REDACTOR = new Redactor<Message>(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0) { // from class: com.squareup.wire.Redactor.1
        @Override // com.squareup.wire.Redactor
        public Message redact(Message message) {
            return message;
        }
    };
    private static final Map<Class<? extends Message>, Redactor> redactors = new LinkedHashMap();
    private final Constructor<?> builderConstructor;
    private final List<Field> messageFields;
    private final List<Redactor<?>> messageRedactors;
    private final List<Field> redactedFields;

    Redactor(Constructor<?> constructor, List<Field> list, List<Field> list2, List<Redactor<?>> list3) {
        this.builderConstructor = constructor;
        this.redactedFields = list;
        this.messageFields = list2;
        this.messageRedactors = list3;
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] com.squareup.wire.Redactor.class) */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T extends Message> Redactor<T> get(Class<T> cls) {
        Redactor redactor;
        synchronized (Redactor.class) {
            Redactor<T> redactor2 = redactors.get(cls);
            if (redactor2 != null) {
                return redactor2;
            }
            FutureRedactor futureRedactor = new FutureRedactor();
            redactors.put((Class<? extends Message>) cls, futureRedactor);
            try {
                Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                        if (protoField != null && protoField.redacted()) {
                            if (protoField.label() == Message.Label.REQUIRED) {
                                throw new IllegalArgumentException(String.format("Field %s is REQUIRED and cannot be redacted.", field));
                            }
                            arrayList.add(cls2.getDeclaredField(field.getName()));
                        } else if (Message.class.isAssignableFrom(field.getType())) {
                            Field declaredField = cls2.getDeclaredField(field.getName());
                            Redactor<?> redactor3 = get(declaredField.getType());
                            if (redactor3 != NOOP_REDACTOR) {
                                arrayList2.add(declaredField);
                                arrayList3.add(redactor3);
                            }
                        }
                    }
                }
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    redactor = NOOP_REDACTOR;
                } else {
                    redactor = new Redactor(cls2.getConstructor(cls), arrayList, arrayList2, arrayList3);
                }
                futureRedactor.setDelegate(redactor);
                redactors.put(cls, redactor);
                return redactor;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public T redact(T t) {
        if (t == null) {
            return null;
        }
        try {
            Message.Builder builder = (Message.Builder) this.builderConstructor.newInstance(t);
            Iterator<Field> it = this.redactedFields.iterator();
            while (it.hasNext()) {
                it.next().set(builder, null);
            }
            for (int i = 0; i < this.messageFields.size(); i++) {
                Field field = this.messageFields.get(i);
                field.set(builder, this.messageRedactors.get(i).redact((Message) field.get(builder)));
            }
            return (T) builder.build();
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    static class FutureRedactor<T extends Message> extends Redactor<T> {
        private Redactor<T> delegate;

        public FutureRedactor() {
            super(null, null, null, null);
        }

        public void setDelegate(Redactor<T> redactor) {
            this.delegate = redactor;
        }

        @Override // com.squareup.wire.Redactor
        public T redact(T t) {
            if (this.delegate == null) {
                throw new IllegalStateException("Delegate was not set.");
            }
            return (T) this.delegate.redact(t);
        }
    }
}
