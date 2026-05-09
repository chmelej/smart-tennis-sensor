package p000;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: StoreHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class afc {

    /* JADX INFO: renamed from: a */
    private static afc f741a;

    /* JADX INFO: renamed from: b */
    private static Context f742b;

    /* JADX INFO: renamed from: c */
    private static String f743c;

    /* JADX INFO: renamed from: d */
    private C0083a f744d;

    /* JADX INFO: renamed from: afc$b */
    /* JADX INFO: compiled from: StoreHelper.java */
    public interface InterfaceC0084b {
        /* JADX INFO: renamed from: a */
        void mo472a(File file);

        /* JADX INFO: renamed from: b */
        boolean mo473b(File file);

        /* JADX INFO: renamed from: c */
        void mo474c(File file);
    }

    public afc(Context context) {
        this.f744d = new C0083a(context);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized afc m806a(Context context) {
        f742b = context.getApplicationContext();
        f743c = context.getPackageName();
        if (f741a == null) {
            f741a = new afc(context);
        }
        return f741a;
    }

    /* JADX INFO: renamed from: a */
    public String[] m812a() {
        SharedPreferences sharedPreferencesM808i = m808i();
        String string = sharedPreferencesM808i.getString("au_p", null);
        String string2 = sharedPreferencesM808i.getString("au_u", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    /* JADX INFO: renamed from: b */
    public String m813b() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f742b);
        if (sharedPreferencesM454a != null) {
            return sharedPreferencesM454a.getString("appkey", null);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public String m814c() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f742b);
        if (sharedPreferencesM454a != null) {
            return sharedPreferencesM454a.getString("st", null);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public int m815d() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f742b);
        if (sharedPreferencesM454a != null) {
            return sharedPreferencesM454a.getInt("vt", 0);
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public void m816e() {
        f742b.deleteFile(m809j());
        f742b.deleteFile(m810k());
        agy.m991a(f742b).m1000a(true, false);
        agp.m938a(f742b).m954a(new agl() { // from class: afc.1
            @Override // p000.agl
            /* JADX INFO: renamed from: a */
            public void mo819a(Object obj, boolean z) {
                obj.equals("success");
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m811a(byte[] bArr) {
        this.f744d.m821a(bArr);
    }

    /* JADX INFO: renamed from: f */
    public boolean m817f() {
        return this.f744d.m822a();
    }

    /* JADX INFO: renamed from: g */
    public C0083a m818g() {
        return this.f744d;
    }

    /* JADX INFO: renamed from: i */
    private SharedPreferences m808i() {
        return f742b.getSharedPreferences("mobclick_agent_user_" + f743c, 0);
    }

    /* JADX INFO: renamed from: j */
    private String m809j() {
        return "mobclick_agent_header_" + f743c;
    }

    /* JADX INFO: renamed from: k */
    private String m810k() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f742b);
        if (sharedPreferencesM454a != null) {
            int i = sharedPreferencesM454a.getInt("versioncode", 0);
            int i2 = Integer.parseInt(aeu.m719a(f742b));
            if (i != 0 && i2 != i) {
                return "mobclick_agent_cached_" + f743c + i;
            }
            return "mobclick_agent_cached_" + f743c + aeu.m719a(f742b);
        }
        return "mobclick_agent_cached_" + f743c + aeu.m719a(f742b);
    }

    /* JADX INFO: renamed from: afc$a */
    /* JADX INFO: compiled from: StoreHelper.java */
    public static class C0083a {

        /* JADX INFO: renamed from: a */
        private final int f746a;

        /* JADX INFO: renamed from: b */
        private File f747b;

        /* JADX INFO: renamed from: c */
        private FilenameFilter f748c;

        public C0083a(Context context) {
            this(context, ".um");
        }

        public C0083a(Context context, String str) {
            this.f746a = 10;
            this.f748c = new FilenameFilter() { // from class: afc.a.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            this.f747b = new File(context.getFilesDir(), str);
            if (this.f747b.exists() && this.f747b.isDirectory()) {
                return;
            }
            this.f747b.mkdir();
        }

        /* JADX INFO: renamed from: a */
        public boolean m822a() {
            File[] fileArrListFiles = this.f747b.listFiles();
            return fileArrListFiles != null && fileArrListFiles.length > 0;
        }

        /* JADX INFO: renamed from: a */
        public void m820a(InterfaceC0084b interfaceC0084b) {
            File file;
            File[] fileArrListFiles = this.f747b.listFiles(this.f748c);
            if (fileArrListFiles != null && fileArrListFiles.length >= 10) {
                Arrays.sort(fileArrListFiles);
                final int length = fileArrListFiles.length - 10;
                aey.m781b(new Runnable() { // from class: afc.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (length > 0) {
                            agp.m938a(afc.f742b).m953a(length, System.currentTimeMillis(), "__evp_file_of");
                        }
                    }
                });
                for (int i = 0; i < length; i++) {
                    fileArrListFiles[i].delete();
                }
            }
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            interfaceC0084b.mo472a(this.f747b);
            int length2 = fileArrListFiles.length;
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                } catch (Throwable unused) {
                    file = fileArrListFiles[i2];
                }
                if (interfaceC0084b.mo473b(fileArrListFiles[i2])) {
                    file = fileArrListFiles[i2];
                    file.delete();
                }
            }
            interfaceC0084b.mo474c(this.f747b);
        }

        /* JADX INFO: renamed from: a */
        public void m821a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                aev.m760a(new File(this.f747b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }
}
