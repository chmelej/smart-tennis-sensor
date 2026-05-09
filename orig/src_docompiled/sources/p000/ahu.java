package p000;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ahu {
    /* JADX INFO: renamed from: a */
    public static int m1267a() {
        return Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX INFO: renamed from: a */
    public static void m1268a(Context context, String str) throws Throwable {
        FileWriter fileWriter;
        File file = new File(context.getFilesDir(), str);
        Log.w("a", file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            int iM1267a = m1267a();
            ?? r3 = 0;
            r3 = 0;
            FileWriter fileWriter2 = null;
            try {
                try {
                    try {
                        fileWriter = new FileWriter(file);
                    } catch (IOException e) {
                        r3 = "savePid";
                        Log.e("savePid", "error", e);
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(String.valueOf(iM1267a).toCharArray());
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e3) {
                e = e3;
                fileWriter2 = fileWriter;
                Log.e("savePid", "error", e);
                fileWriter2.flush();
                fileWriter2.close();
                r3 = fileWriter2;
            } catch (Throwable th2) {
                th = th2;
                r3 = fileWriter;
                try {
                    r3.flush();
                    r3.close();
                } catch (IOException e4) {
                    Log.e("savePid", "error", e4);
                }
                throw th;
            }
        } catch (IOException e5) {
            Log.e("savePidFile", "error in create file", e5);
        }
    }
}
