package p000;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: yf */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
final class C2265yf {

    /* JADX INFO: renamed from: a */
    static final StringBuilder f13693a = new StringBuilder();

    /* JADX INFO: renamed from: a */
    static int m12380a(Bitmap bitmap) {
        int rowBytes;
        if (Build.VERSION.SDK_INT >= 12) {
            rowBytes = b.m12404a(bitmap);
        } else {
            rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (rowBytes >= 0) {
            return rowBytes;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* JADX INFO: renamed from: a */
    static <T> T m12384a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    static void m12390a() {
        if (!m12397b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* JADX INFO: renamed from: b */
    static boolean m12397b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: renamed from: a */
    static String m12385a(RunnableC2236xd runnableC2236xd) {
        return m12386a(runnableC2236xd, "");
    }

    /* JADX INFO: renamed from: a */
    static String m12386a(RunnableC2236xd runnableC2236xd, String str) {
        StringBuilder sb = new StringBuilder(str);
        AbstractC2234xb abstractC2234xbM12243i = runnableC2236xd.m12243i();
        if (abstractC2234xbM12243i != null) {
            sb.append(abstractC2234xbM12243i.f13447b.m12330a());
        }
        List<AbstractC2234xb> listM12245k = runnableC2236xd.m12245k();
        if (listM12245k != null) {
            int size = listM12245k.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || abstractC2234xbM12243i != null) {
                    sb.append(", ");
                }
                sb.append(listM12245k.get(i).f13447b.m12330a());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    static void m12393a(String str, String str2, String str3) {
        m12394a(str, str2, str3, "");
    }

    /* JADX INFO: renamed from: a */
    static void m12394a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    /* JADX INFO: renamed from: a */
    static String m12387a(C2256xx c2256xx) {
        String strM12388a = m12388a(c2256xx, f13693a);
        f13693a.setLength(0);
        return strM12388a;
    }

    /* JADX INFO: renamed from: a */
    static String m12388a(C2256xx c2256xx, StringBuilder sb) {
        if (c2256xx.f13611f != null) {
            sb.ensureCapacity(c2256xx.f13611f.length() + 50);
            sb.append(c2256xx.f13611f);
        } else if (c2256xx.f13609d != null) {
            String string = c2256xx.f13609d.toString();
            sb.ensureCapacity(string.length() + 50);
            sb.append(string);
        } else {
            sb.ensureCapacity(50);
            sb.append(c2256xx.f13610e);
        }
        sb.append('\n');
        if (c2256xx.f13618m != 0.0f) {
            sb.append("rotation:");
            sb.append(c2256xx.f13618m);
            if (c2256xx.f13621p) {
                sb.append('@');
                sb.append(c2256xx.f13619n);
                sb.append('x');
                sb.append(c2256xx.f13620o);
            }
            sb.append('\n');
        }
        if (c2256xx.m12333d()) {
            sb.append("resize:");
            sb.append(c2256xx.f13613h);
            sb.append('x');
            sb.append(c2256xx.f13614i);
            sb.append('\n');
        }
        if (c2256xx.f13615j) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (c2256xx.f13616k) {
            sb.append("centerInside");
            sb.append('\n');
        }
        if (c2256xx.f13612g != null) {
            int size = c2256xx.f13612g.size();
            for (int i = 0; i < size; i++) {
                sb.append(c2256xx.f13612g.get(i).mo10440a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    static void m12392a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m12395a(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split(" ", 2);
        if ("CACHE".equals(strArrSplit[0])) {
            return true;
        }
        if (strArrSplit.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(strArrSplit[0])) {
                return Integer.parseInt(strArrSplit[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static InterfaceC2243xk m12389a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return c.m12405a(context);
        } catch (ClassNotFoundException unused) {
            return new C2264ye(context);
        }
    }

    /* JADX INFO: renamed from: b */
    static File m12396b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: renamed from: a */
    static long m12381a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    /* JADX INFO: renamed from: c */
    static int m12400c(Context context) {
        ActivityManager activityManager = (ActivityManager) m12383a(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = a.m12403a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    /* JADX INFO: renamed from: d */
    static boolean m12402d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static <T> T m12383a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    /* JADX INFO: renamed from: b */
    static boolean m12398b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX INFO: renamed from: b */
    static byte[] m12399b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    static boolean m12401c(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    /* JADX INFO: renamed from: a */
    static int m12379a(Resources resources, C2256xx c2256xx) throws FileNotFoundException {
        if (c2256xx.f13610e != 0 || c2256xx.f13609d == null) {
            return c2256xx.f13610e;
        }
        String authority = c2256xx.f13609d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c2256xx.f13609d);
        }
        List<String> pathSegments = c2256xx.f13609d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c2256xx.f13609d);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c2256xx.f13609d);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + c2256xx.f13609d);
    }

    /* JADX INFO: renamed from: a */
    static Resources m12382a(Context context, C2256xx c2256xx) throws FileNotFoundException {
        if (c2256xx.f13610e != 0 || c2256xx.f13609d == null) {
            return context.getResources();
        }
        String authority = c2256xx.f13609d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c2256xx.f13609d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c2256xx.f13609d);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m12391a(Looper looper) {
        Handler handler = new Handler(looper) { // from class: yf.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    /* JADX INFO: renamed from: yf$a */
    /* JADX INFO: compiled from: Utils.java */
    @TargetApi(11)
    static class a {
        /* JADX INFO: renamed from: a */
        static int m12403a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* JADX INFO: renamed from: yf$e */
    /* JADX INFO: compiled from: Utils.java */
    static class e implements ThreadFactory {
        e() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new d(runnable);
        }
    }

    /* JADX INFO: renamed from: yf$d */
    /* JADX INFO: compiled from: Utils.java */
    static class d extends Thread {
        public d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* JADX INFO: renamed from: yf$b */
    /* JADX INFO: compiled from: Utils.java */
    @TargetApi(12)
    static class b {
        /* JADX INFO: renamed from: a */
        static int m12404a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* JADX INFO: renamed from: yf$c */
    /* JADX INFO: compiled from: Utils.java */
    static class c {
        /* JADX INFO: renamed from: a */
        static InterfaceC2243xk m12405a(Context context) {
            return new C2252xt(context);
        }
    }
}
