package p000;

import android.content.Context;
import android.os.Environment;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ResUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class ajq {

    /* JADX INFO: renamed from: a */
    public static boolean f1343a = false;

    /* JADX INFO: renamed from: b */
    private static final String f1344b = "ajq";

    /* JADX INFO: renamed from: c */
    private static final Map<ImageView, String> f1345c = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: d */
    private static Thread f1346d;

    /* JADX INFO: renamed from: a */
    public static File m1598a(String str, Context context, boolean[] zArr) throws IOException {
        if (ati.m5412a()) {
            File file = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "/download/.um" + str);
            file.mkdirs();
            if (file.exists()) {
                zArr[0] = true;
                return file;
            }
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        new File(absolutePath).mkdir();
        m1603a(absolutePath, 505, -1, -1);
        String str2 = absolutePath + "/umdownload";
        new File(str2).mkdir();
        m1603a(str2, 505, -1, -1);
        File file2 = new File(str2);
        zArr[0] = false;
        return file2;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1603a(String str, int i, int i2, int i3) {
        try {
            Class.forName("android.os.FileUtils").getMethod("setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, str, Integer.valueOf(i), -1, -1);
            return true;
        } catch (ClassNotFoundException e) {
            atj.m5426b(f1344b, "error when set permissions:", e);
            return false;
        } catch (IllegalAccessException e2) {
            atj.m5426b(f1344b, "error when set permissions:", e2);
            return false;
        } catch (IllegalArgumentException e3) {
            atj.m5426b(f1344b, "error when set permissions:", e3);
            return false;
        } catch (NoSuchMethodException e4) {
            atj.m5426b(f1344b, "error when set permissions:", e4);
            return false;
        } catch (InvocationTargetException e5) {
            atj.m5426b(f1344b, "error when set permissions:", e5);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1602a(String str, int i) {
        int i2 = (i & 1) != 0 ? 436 : 432;
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        return m1603a(str, i2, -1, -1);
    }

    /* JADX INFO: renamed from: a */
    public static void m1601a(final File file, long j, final long j2) {
        if (file.exists()) {
            if (m1597a(file.getCanonicalFile()) > j) {
                if (f1346d == null) {
                    f1346d = new Thread(new Runnable() { // from class: ajq.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ajq.m1604b(file, j2);
                            Thread unused = ajq.f1346d = null;
                        }
                    });
                }
                synchronized (f1346d) {
                    f1346d.start();
                }
                return;
            }
            return;
        }
        if (file.mkdirs()) {
            return;
        }
        atj.m5425b(f1344b, "Failed to create directory" + file.getAbsolutePath() + ". Check permission. Make sure WRITE_EXTERNAL_STORAGE is added in your Manifest.xml");
    }

    /* JADX INFO: renamed from: a */
    private static long m1597a(File file) {
        long length = 0;
        if (file == null || !file.exists() || !file.isDirectory()) {
            return 0L;
        }
        Stack stack = new Stack();
        stack.clear();
        stack.push(file);
        while (!stack.isEmpty()) {
            for (File file2 : ((File) stack.pop()).listFiles()) {
                if (!file2.isDirectory()) {
                    length += file2.length();
                }
            }
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1604b(File file, long j) {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory() && new Date().getTime() - file2.lastModified() > j) {
                    file2.delete();
                }
            }
        }
    }
}
