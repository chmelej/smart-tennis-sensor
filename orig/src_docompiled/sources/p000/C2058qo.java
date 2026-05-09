package p000;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: qo */
/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
final class C2058qo {

    /* JADX INFO: renamed from: a */
    static final Charset f12394a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b */
    static final Charset f12395b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a */
    static void m11262a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m11262a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m11261a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
