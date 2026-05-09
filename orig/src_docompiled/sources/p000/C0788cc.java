package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: cc */
/* JADX INFO: compiled from: MultiDex.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0788cc {

    /* JADX INFO: renamed from: a */
    private static final Set<File> f5321a = new HashSet();

    /* JADX INFO: renamed from: b */
    private static final boolean f5322b = m5751a(System.getProperty("java.vm.version"));

    /* JADX INFO: renamed from: a */
    public static void m5746a(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f5322b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        if (Build.VERSION.SDK_INT < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
        }
        try {
            ApplicationInfo applicationInfoM5752b = m5752b(context);
            if (applicationInfoM5752b == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                m5747a(context, new File(applicationInfoM5752b.sourceDir), new File(applicationInfoM5752b.dataDir), "secondary-dexes", "");
                Log.i("MultiDex", "install done");
            }
        } catch (Exception e) {
            Log.e("MultiDex", "MultiDex installation failure", e);
            throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5747a(Context context, File file, File file2, String str, String str2) {
        synchronized (f5321a) {
            if (f5321a.contains(file)) {
                return;
            }
            f5321a.add(file);
            if (Build.VERSION.SDK_INT > 20) {
                Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            }
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (classLoader == null) {
                    Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                    return;
                }
                try {
                    m5756c(context);
                } catch (Throwable th) {
                    Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                }
                File fileM5743a = m5743a(context, file2, str);
                m5749a(classLoader, fileM5743a, C0789cd.m5768a(context, file, fileM5743a, str2, false));
            } catch (RuntimeException e) {
                Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static ApplicationInfo m5752b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m5751a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int i = Integer.parseInt(matcher.group(1));
                    int i2 = Integer.parseInt(matcher.group(2));
                    if (i > 2 || (i == 2 && i2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static void m5749a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT >= 14) {
                a.m5759b(classLoader, list, file);
                return;
            } else {
                c.m5764b(classLoader, list);
                return;
            }
        }
        b.m5762b(classLoader, list, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Field m5753b(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Method m5754b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m5755b(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException {
        Field fieldM5753b = m5753b(obj, str);
        Object[] objArr2 = (Object[]) fieldM5753b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldM5753b.set(obj, objArr3);
    }

    /* JADX INFO: renamed from: c */
    private static void m5756c(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
        }
    }

    /* JADX INFO: renamed from: a */
    private static File m5743a(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            m5748a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            m5748a(file2);
        }
        File file3 = new File(file2, str);
        m5748a(file3);
        return file3;
    }

    /* JADX INFO: renamed from: a */
    private static void m5748a(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }

    /* JADX INFO: renamed from: cc$b */
    /* JADX INFO: compiled from: MultiDex.java */
    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m5762b(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalAccessException, NoSuchFieldException {
            IOException[] iOExceptionArr;
            Object obj = C0788cc.m5753b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            C0788cc.m5755b(obj, "dexElements", m5761a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field fieldM5753b = C0788cc.m5753b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) fieldM5753b.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                fieldM5753b.set(obj, iOExceptionArr);
            }
        }

        /* JADX INFO: renamed from: a */
        private static Object[] m5761a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) C0788cc.m5754b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: renamed from: cc$a */
    /* JADX INFO: compiled from: MultiDex.java */
    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m5759b(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = C0788cc.m5753b(classLoader, "pathList").get(classLoader);
            C0788cc.m5755b(obj, "dexElements", m5758a(obj, (ArrayList<File>) new ArrayList(list), file));
        }

        /* JADX INFO: renamed from: a */
        private static Object[] m5758a(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) C0788cc.m5754b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, arrayList, file);
        }
    }

    /* JADX INFO: renamed from: cc$c */
    /* JADX INFO: compiled from: MultiDex.java */
    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m5764b(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException {
            int size = list.size();
            Field fieldM5753b = C0788cc.m5753b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) fieldM5753b.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            fieldM5753b.set(classLoader, sb.toString());
            C0788cc.m5755b(classLoader, "mPaths", strArr);
            C0788cc.m5755b(classLoader, "mFiles", fileArr);
            C0788cc.m5755b(classLoader, "mZips", zipFileArr);
            C0788cc.m5755b(classLoader, "mDexs", dexFileArr);
        }
    }
}
