package p000;

import android.content.Context;
import android.os.Environment;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: sk */
/* JADX INFO: compiled from: StorageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2108sk {
    /* JADX INFO: renamed from: a */
    public static File m11531a(Context context) {
        return m11532a(context, true);
    }

    /* JADX INFO: renamed from: a */
    public static File m11532a(Context context, boolean z) {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            externalStorageState = "";
        }
        File fileM11534c = (z && "mounted".equals(externalStorageState) && m11535d(context)) ? m11534c(context) : null;
        if (fileM11534c == null) {
            fileM11534c = context.getCacheDir();
        }
        if (fileM11534c != null) {
            return fileM11534c;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        C2106si.m11526c("Can't define system cache directory! '%s' will be used.", str);
        return new File(str);
    }

    /* JADX INFO: renamed from: b */
    public static File m11533b(Context context) {
        File fileM11531a = m11531a(context);
        File file = new File(fileM11531a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : fileM11531a;
    }

    /* JADX INFO: renamed from: c */
    private static File m11534c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                C2106si.m11526c("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                C2106si.m11525b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m11535d(Context context) {
        return context.checkCallingOrSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) == 0;
    }
}
