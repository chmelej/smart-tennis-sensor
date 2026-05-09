package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: UUIDTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adq extends agz {

    /* JADX INFO: renamed from: a */
    private Context f443a;

    /* JADX INFO: renamed from: b */
    private String f444b;

    /* JADX INFO: renamed from: c */
    private String f445c;

    public adq(Context context) {
        super("uuid");
        this.f443a = null;
        this.f444b = null;
        this.f445c = null;
        this.f443a = context;
        this.f444b = null;
        this.f445c = null;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        SharedPreferences sharedPreferencesM454a;
        SharedPreferences.Editor editorEdit;
        try {
            if (TextUtils.isEmpty(m396a("ro.yunos.version", "")) || this.f443a == null || (sharedPreferencesM454a = aeb.m454a(this.f443a)) == null) {
                return null;
            }
            String string = sharedPreferencesM454a.getString("yosuid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            this.f445c = m397b("23346339");
            if (!TextUtils.isEmpty(this.f445c) && this.f443a != null && sharedPreferencesM454a != null && (editorEdit = sharedPreferencesM454a.edit()) != null) {
                editorEdit.putString("yosuid", this.f445c).commit();
            }
            return this.f445c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0160  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m397b(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.adq.m397b(java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public static String m396a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
