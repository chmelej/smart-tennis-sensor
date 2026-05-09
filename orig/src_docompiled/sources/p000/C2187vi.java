package p000;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: vi */
/* JADX INFO: compiled from: ShortVideoCore.java */
/* JADX INFO: loaded from: classes.dex */
public class C2187vi {
    /* JADX INFO: renamed from: a */
    public static void m11968a(Context context) {
        C2201vw.f13213b.m12048a(C2204vz.m12082j(context));
        C2189vk.m11979a().m11985a(context);
    }

    /* JADX INFO: renamed from: a */
    public static String m11967a(Context context, String str) {
        File file;
        File file2 = new File(str);
        File parentFile = file2.getParentFile();
        if (parentFile.exists()) {
            return file2.getAbsolutePath();
        }
        if (parentFile.mkdirs()) {
            file = file2;
        } else {
            C2201vw.f13212a.m12055e("ShortVideoCore", "failed to mkdirs: " + parentFile + " use default: " + context.getFilesDir());
            file = new File(context.getFilesDir(), file2.getName());
        }
        return file.getAbsolutePath();
    }

    static {
        System.loadLibrary("pldroid_shortvideo_core");
    }
}
