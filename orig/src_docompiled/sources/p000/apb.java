package p000;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: FileSystem.java */
/* JADX INFO: loaded from: classes.dex */
public interface apb {

    /* JADX INFO: renamed from: a */
    public static final apb f4559a = new apb() { // from class: apb.1
        @Override // p000.apb
        /* JADX INFO: renamed from: a */
        public void mo4814a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // p000.apb
        /* JADX INFO: renamed from: b */
        public boolean mo4816b(File file) {
            return file.exists();
        }

        @Override // p000.apb
        /* JADX INFO: renamed from: c */
        public long mo4817c(File file) {
            return file.length();
        }

        @Override // p000.apb
        /* JADX INFO: renamed from: a */
        public void mo4815a(File file, File file2) throws IOException {
            mo4814a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    /* JADX INFO: renamed from: a */
    void mo4814a(File file);

    /* JADX INFO: renamed from: a */
    void mo4815a(File file, File file2);

    /* JADX INFO: renamed from: b */
    boolean mo4816b(File file);

    /* JADX INFO: renamed from: c */
    long mo4817c(File file);
}
