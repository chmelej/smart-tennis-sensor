package p000;

import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: renamed from: pr */
/* JADX INFO: compiled from: VideoFile.java */
/* JADX INFO: loaded from: classes.dex */
public class C2032pr {

    /* JADX INFO: renamed from: a */
    private final String f12208a;

    /* JADX INFO: renamed from: b */
    private Date f12209b;

    public C2032pr(String str) {
        this.f12208a = str;
    }

    /* JADX INFO: renamed from: a */
    public String m11107a() {
        return m11108b().getAbsolutePath();
    }

    /* JADX INFO: renamed from: b */
    public File m11108b() {
        String strM11104c = m11104c();
        if (strM11104c.contains("/")) {
            return new File(strM11104c);
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        externalStoragePublicDirectory.mkdirs();
        return new File(externalStoragePublicDirectory, m11104c());
    }

    /* JADX INFO: renamed from: c */
    private String m11104c() {
        if (m11105d()) {
            return this.f12208a;
        }
        return "video_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(m11106e()) + ".mp4";
    }

    /* JADX INFO: renamed from: d */
    private boolean m11105d() {
        return (this.f12208a == null || this.f12208a.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: e */
    private Date m11106e() {
        if (this.f12209b == null) {
            this.f12209b = new Date();
        }
        return this.f12209b;
    }
}
