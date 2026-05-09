package com.mob.tools.utils;

import com.mob.tools.gui.CachePool;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ReflectHelper {
    private static CachePool<String, Constructor<?>> cachedConstr;
    private static CachePool<String, Method> cachedMethod;
    private static HashMap<String, Class<?>> classMap;
    private static HashMap<Class<?>, String> nameMap;
    private static HashSet<String> packageSet = new HashSet<>();

    public interface ReflectRunnable {
        Object run(Object obj);
    }

    static {
        packageSet.add("java.lang");
        packageSet.add("java.io");
        packageSet.add("java.nio");
        packageSet.add("java.net");
        packageSet.add("java.util");
        packageSet.add("com.mob.tools");
        packageSet.add("com.mob.tools.gui");
        packageSet.add("com.mob.tools.log");
        packageSet.add("com.mob.tools.network");
        packageSet.add("com.mob.tools.utils");
        classMap = new HashMap<>();
        classMap.put("double", Double.TYPE);
        classMap.put("float", Float.TYPE);
        classMap.put("long", Long.TYPE);
        classMap.put("int", Integer.TYPE);
        classMap.put("short", Short.TYPE);
        classMap.put("byte", Byte.TYPE);
        classMap.put("char", Character.TYPE);
        classMap.put("boolean", Boolean.TYPE);
        classMap.put("Object", Object.class);
        classMap.put("String", String.class);
        classMap.put("Thread", Thread.class);
        classMap.put("Runnable", Runnable.class);
        classMap.put("System", System.class);
        classMap.put("double", Double.class);
        classMap.put("Float", Float.class);
        classMap.put("Long", Long.class);
        classMap.put("Integer", Integer.class);
        classMap.put("Short", Short.class);
        classMap.put("Byte", Byte.class);
        classMap.put("Character", Character.class);
        classMap.put("Boolean", Boolean.class);
        nameMap = new HashMap<>();
        for (Map.Entry<String, Class<?>> entry : classMap.entrySet()) {
            nameMap.put(entry.getValue(), entry.getKey());
        }
        cachedMethod = new CachePool<>(25);
        cachedConstr = new CachePool<>(5);
    }

    public static String importClass(String str) {
        return importClass(null, str);
    }

    public static synchronized String importClass(String str, String str2) {
        if (str2.endsWith(".*")) {
            packageSet.add(str2.substring(0, str2.length() - 2));
            return "*";
        }
        Class<?> cls = Class.forName(str2);
        if (str == null) {
            str = cls.getSimpleName();
        }
        classMap.put(str, cls);
        nameMap.put(cls, str);
        return str;
    }

    private static synchronized Class<?> getImportedClass(String str) {
        Class<?> cls;
        cls = classMap.get(str);
        if (cls == null) {
            Iterator<String> it = packageSet.iterator();
            while (it.hasNext()) {
                try {
                    importClass(it.next() + "." + str);
                } catch (Throwable unused) {
                }
                cls = classMap.get(str);
                if (cls != null) {
                    break;
                }
            }
        }
        return cls;
    }

    private static Class<?>[] getTypes(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    private static boolean primitiveEquals(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    private static boolean matchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != null && !primitiveEquals(clsArr[i], clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tryMatchParams(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length != 1) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= clsArr2.length) {
                z = true;
                break;
            }
            if (clsArr2[i] != null && !primitiveEquals(clsArr[i], clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                z = false;
                break;
            }
            i++;
        }
        return z && clsArr[clsArr.length - 1].isArray();
    }

    public static Object newInstance(String str, Object... objArr) throws Throwable {
        try {
            return onNewInstance(str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: <init>", th);
        }
    }

    private static Object onNewInstance(String str, Object... objArr) throws NoSuchMethodException {
        boolean z;
        if (str.startsWith("[")) {
            return newArray(str, objArr);
        }
        String str2 = str + "#" + objArr.length;
        Constructor<?> constructor = cachedConstr.get(str2);
        Class<?>[] types = getTypes(objArr);
        if (constructor != null && matchParams(constructor.getParameterTypes(), types)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = getImportedClass(str).getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (matchParams(parameterTypes, types)) {
                cachedConstr.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && types.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            Class[] clsArr = (Class[]) arrayList2.get(i);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (tryMatchParams(clsArr, types)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= types.length) {
                    z = true;
                    break;
                }
                if (!types[length].equals(componentType)) {
                    z = false;
                    break;
                }
                length++;
            }
            if (z) {
                int length2 = (types.length - clsArr.length) + 1;
                Object objNewInstance = Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    Array.set(objNewInstance, i2, objArr[(clsArr.length - 1) + i2]);
                }
                Object[] objArr3 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = objNewInstance;
                Constructor constructor4 = (Constructor) arrayList.get(i);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    private static Object newArray(String str, Object... objArr) throws NoSuchMethodException {
        Class<?> importedClass;
        String strSubstring = str;
        int i = 0;
        while (strSubstring.startsWith("[")) {
            i++;
            strSubstring = strSubstring.substring(1);
        }
        int[] iArr = null;
        if (i == objArr.length) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr2[i2] = Integer.parseInt(String.valueOf(objArr[i2]));
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            if ("B".equals(strSubstring)) {
                importedClass = Byte.TYPE;
            } else if ("S".equals(strSubstring)) {
                importedClass = Short.TYPE;
            } else if ("I".equals(strSubstring)) {
                importedClass = Integer.TYPE;
            } else if ("J".equals(strSubstring)) {
                importedClass = Long.TYPE;
            } else if ("F".equals(strSubstring)) {
                importedClass = Float.TYPE;
            } else if ("D".equals(strSubstring)) {
                importedClass = Double.TYPE;
            } else if ("Z".equals(strSubstring)) {
                importedClass = Boolean.TYPE;
            } else if ("C".equals(strSubstring)) {
                importedClass = Character.TYPE;
            } else {
                importedClass = getImportedClass(strSubstring);
            }
            if (importedClass != null) {
                return Array.newInstance(importedClass, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) throws Throwable {
        try {
            return (T) invokeMethod(str, null, str2, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: " + str2, th);
        }
    }

    private static <T> T invokeMethod(String str, Object obj, String str2, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> superclass;
        boolean z;
        if (obj == null) {
            superclass = getImportedClass(str);
        } else {
            superclass = obj.getClass();
        }
        String str3 = superclass.getName() + "#" + str2 + "#" + objArr.length;
        Method method = cachedMethod.get(str3);
        Class<?>[] types = getTypes(objArr);
        T t = null;
        if (method != null) {
            boolean zIsStatic = Modifier.isStatic(method.getModifiers());
            if (obj != null) {
                zIsStatic = !zIsStatic;
            }
            if (zIsStatic && matchParams(method.getParameterTypes(), types)) {
                method.setAccessible(true);
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return null;
                }
                return (T) method.invoke(obj, objArr);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (superclass != null) {
            arrayList.add(superclass);
            superclass = superclass.getSuperclass();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Method[] declaredMethods = ((Class) it.next()).getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (i < length) {
                Method method2 = declaredMethods[i];
                boolean zIsStatic2 = Modifier.isStatic(method2.getModifiers());
                if (obj != null) {
                    zIsStatic2 = !zIsStatic2;
                }
                if (method2.getName().equals(str2) && zIsStatic2) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (matchParams(parameterTypes, types)) {
                        cachedMethod.put(str3, method2);
                        method2.setAccessible(true);
                        if (method2.getReturnType() == Void.TYPE) {
                            method2.invoke(obj, objArr);
                            return t;
                        }
                        return (T) method2.invoke(obj, objArr);
                    }
                    if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && types.length >= parameterTypes.length - 1) {
                        arrayList2.add(method2);
                        arrayList3.add(parameterTypes);
                    }
                }
                i++;
                t = null;
            }
        }
        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
            Class[] clsArr = (Class[]) arrayList3.get(i2);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (tryMatchParams(clsArr, types)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Method method3 = (Method) arrayList2.get(i2);
                method3.setAccessible(true);
                if (method3.getReturnType() == Void.TYPE) {
                    method3.invoke(obj, objArr2);
                    return null;
                }
                return (T) method3.invoke(obj, objArr2);
            }
            int length2 = clsArr.length - 1;
            while (true) {
                if (length2 >= types.length) {
                    z = true;
                    break;
                }
                if (!types[length2].equals(componentType)) {
                    z = false;
                    break;
                }
                length2++;
            }
            if (z) {
                int length3 = (types.length - clsArr.length) + 1;
                Object objNewInstance = Array.newInstance(componentType, length3);
                for (int i3 = 0; i3 < length3; i3++) {
                    Array.set(objNewInstance, i3, objArr[(clsArr.length - 1) + i3]);
                }
                Object[] objArr3 = new Object[clsArr.length];
                System.arraycopy(objArr, 0, objArr3, 0, clsArr.length - 1);
                objArr3[clsArr.length - 1] = objNewInstance;
                Method method4 = (Method) arrayList2.get(i2);
                method4.setAccessible(true);
                if (method4.getReturnType() == Void.TYPE) {
                    method4.invoke(obj, objArr3);
                    return null;
                }
                return (T) method4.invoke(obj, objArr3);
            }
        }
        throw new NoSuchMethodException("className: " + obj.getClass() + ", methodName: " + str2);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return (T) invokeMethod(null, obj, str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
        }
    }

    public static <T> T getStaticField(String str, String str2) throws Throwable {
        try {
            return (T) onGetStaticField(str, str2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    private static <T> T onGetStaticField(String str, String str2) throws NoSuchFieldException {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        try {
            onSetStaticField(str, str2, obj);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th);
        }
    }

    private static void onSetStaticField(String str, String str2, Object obj) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> importedClass = getImportedClass(str); importedClass != null; importedClass = importedClass.getSuperclass()) {
            arrayList.add(importedClass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    public static <T> T getInstanceField(Object obj, String str) throws Throwable {
        try {
            return (T) onGetInstanceField(obj, str);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    private static <T> T onGetInstanceField(Object obj, String str) throws NoSuchFieldException {
        Field declaredField;
        if (obj.getClass().isArray()) {
            return (T) onGetElement(obj, str);
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(obj);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static Object onGetElement(Object obj, String str) throws NoSuchFieldException {
        int i;
        if ("length".equals(str)) {
            return Integer.valueOf(Array.getLength(obj));
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused) {
                i = -1;
            }
            if (i != -1) {
                return Array.get(obj, i);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        try {
            onSetInstanceField(obj, str, obj2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
        }
    }

    private static void onSetInstanceField(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField;
        if (obj.getClass().isArray()) {
            onSetElement(obj, str, obj2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static void onSetElement(Object obj, String str, Object obj2) throws NoSuchFieldException {
        int i;
        Object objValueOf;
        Object objValueOf2;
        Object objValueOf3;
        Object objValueOf4;
        Object objValueOf5;
        if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused) {
                i = -1;
            }
            if (i != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if ("B".equals(name)) {
                    if (cls == Byte.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if ("S".equals(name)) {
                    if (cls == Short.class) {
                        objValueOf5 = obj2;
                    } else {
                        objValueOf5 = cls == Byte.class ? Short.valueOf(((Byte) obj2).byteValue()) : null;
                    }
                    if (objValueOf5 != null) {
                        Array.set(obj, i, objValueOf5);
                        return;
                    }
                } else if ("I".equals(name)) {
                    if (cls == Integer.class) {
                        objValueOf4 = obj2;
                    } else if (cls == Short.class) {
                        objValueOf4 = Integer.valueOf(((Short) obj2).shortValue());
                    } else {
                        objValueOf4 = cls == Byte.class ? Integer.valueOf(((Byte) obj2).byteValue()) : null;
                    }
                    if (objValueOf4 != null) {
                        Array.set(obj, i, objValueOf4);
                        return;
                    }
                } else if ("J".equals(name)) {
                    if (cls == Long.class) {
                        objValueOf3 = obj2;
                    } else if (cls == Integer.class) {
                        objValueOf3 = Long.valueOf(((Integer) obj2).intValue());
                    } else if (cls == Short.class) {
                        objValueOf3 = Long.valueOf(((Short) obj2).shortValue());
                    } else {
                        objValueOf3 = cls == Byte.class ? Long.valueOf(((Byte) obj2).byteValue()) : null;
                    }
                    if (objValueOf3 != null) {
                        Array.set(obj, i, objValueOf3);
                        return;
                    }
                } else if ("F".equals(name)) {
                    if (cls == Float.class) {
                        objValueOf2 = obj2;
                    } else if (cls == Long.class) {
                        objValueOf2 = Float.valueOf(((Long) obj2).longValue());
                    } else if (cls == Integer.class) {
                        objValueOf2 = Float.valueOf(((Integer) obj2).intValue());
                    } else if (cls == Short.class) {
                        objValueOf2 = Float.valueOf(((Short) obj2).shortValue());
                    } else {
                        objValueOf2 = cls == Byte.class ? Float.valueOf(((Byte) obj2).byteValue()) : null;
                    }
                    if (objValueOf2 != null) {
                        Array.set(obj, i, objValueOf2);
                        return;
                    }
                } else if ("D".equals(name)) {
                    if (cls == Double.class) {
                        objValueOf = obj2;
                    } else if (cls == Float.class) {
                        objValueOf = Double.valueOf(((Float) obj2).floatValue());
                    } else if (cls == Long.class) {
                        objValueOf = Double.valueOf(((Long) obj2).longValue());
                    } else if (cls == Integer.class) {
                        objValueOf = Double.valueOf(((Integer) obj2).intValue());
                    } else if (cls == Short.class) {
                        objValueOf = Double.valueOf(((Short) obj2).shortValue());
                    } else {
                        objValueOf = cls == Byte.class ? Double.valueOf(((Byte) obj2).byteValue()) : null;
                    }
                    if (objValueOf != null) {
                        Array.set(obj, i, objValueOf);
                        return;
                    }
                } else if ("Z".equals(name)) {
                    if (cls == Boolean.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if ("C".equals(name)) {
                    if (cls == Character.class) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if (name.equals(cls.getName())) {
                    Array.set(obj, i, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    public static Class<?> getClass(String str) {
        Class<?> importedClass = getImportedClass(str);
        if (importedClass != null) {
            return importedClass;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                try {
                    classMap.put(str, cls);
                } catch (Throwable unused) {
                }
            }
            return cls;
        } catch (Throwable unused2) {
            return importedClass;
        }
    }

    public static String getName(Class<?> cls) {
        String str = nameMap.get(cls);
        if (str != null) {
            return str;
        }
        String simpleName = cls.getSimpleName();
        if (classMap.containsKey(simpleName)) {
            return null;
        }
        classMap.put(simpleName, cls);
        nameMap.put(cls, simpleName);
        return simpleName;
    }

    public static Object createProxy(final HashMap<String, ReflectRunnable> map, Class<?>... clsArr) {
        return Proxy.newProxyInstance(map.getClass().getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.tools.utils.ReflectHelper.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws NoSuchMethodException {
                ReflectRunnable reflectRunnable = (ReflectRunnable) map.get(method.getName());
                if (reflectRunnable != null) {
                    return reflectRunnable.run(objArr);
                }
                throw new NoSuchMethodException();
            }
        });
    }
}
