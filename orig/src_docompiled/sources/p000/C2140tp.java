package p000;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

/* JADX INFO: renamed from: tp */
/* JADX INFO: compiled from: FileRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2140tp implements InterfaceC2132th {

    /* JADX INFO: renamed from: a */
    public String f12858a;

    public C2140tp(String str) throws IOException {
        this.f12858a = str;
        File file = new File(str);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("mkdir failed");
            }
        } else if (!file.isDirectory()) {
            throw new IOException("does not mkdir");
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m11705c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // p000.InterfaceC2132th
    /* JADX INFO: renamed from: a */
    public void mo11660a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(this.f12858a, m11705c(str)));
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // p000.InterfaceC2132th
    /* JADX INFO: renamed from: a */
    public byte[] mo11661a(String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        int i;
        File file = new File(this.f12858a, m11705c(str));
        try {
        } catch (IOException e) {
            e = e;
            bArr = null;
            fileInputStream = null;
        }
        if (m11704a(file)) {
            file.delete();
            return null;
        }
        bArr = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        }
        try {
            i = fileInputStream.read(bArr);
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            i = 0;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (i == 0) {
            return null;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    private boolean m11704a(File file) {
        return file.lastModified() + 172800000 < new Date().getTime();
    }

    @Override // p000.InterfaceC2132th
    /* JADX INFO: renamed from: b */
    public void mo11662b(String str) {
        new File(this.f12858a, m11705c(str)).delete();
    }
}
