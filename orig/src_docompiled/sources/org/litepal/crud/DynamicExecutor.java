package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.litepal.exceptions.DataSupportException;

/* JADX INFO: loaded from: classes.dex */
class DynamicExecutor {
    private DynamicExecutor() {
    }

    static Object send(Object obj, String str, Object[] objArr, Class<?> cls, Class<?>[] clsArr) {
        if (objArr == null) {
            try {
                objArr = new Object[0];
            } catch (NoSuchMethodException unused) {
                throw new DataSupportException(DataSupportException.noSuchMethodException(cls.getSimpleName(), str));
            }
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    static void setField(Object obj, String str, Object obj2, Class<?> cls) throws IllegalAccessException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (NoSuchFieldException unused) {
            throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(cls.getSimpleName(), str));
        }
    }

    static Object getField(Object obj, String str, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException unused) {
            throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(cls.getSimpleName(), str));
        }
    }
}
