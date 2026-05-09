package p000;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: HelperUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class aev {

    /* JADX INFO: renamed from: a */
    public static final String f710a = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a */
    public static String m758a(String str, int i) throws Throwable {
        String strSubstring = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String strSubstring2 = str.substring(0, str.length() < i ? str.length() : i);
                try {
                    int length = strSubstring2.getBytes("UTF-8").length;
                    String str2 = strSubstring2;
                    int i2 = i;
                    while (length > i) {
                        i2--;
                        try {
                            strSubstring = str.substring(0, i2 > str.length() ? str.length() : i2);
                            str2 = strSubstring;
                            length = strSubstring.getBytes("UTF-8").length;
                        } catch (Exception e) {
                            e = e;
                            strSubstring = str2;
                            aex.m772a(e);
                            return strSubstring;
                        }
                    }
                    return str2;
                } catch (Exception e2) {
                    e = e2;
                    strSubstring = strSubstring2;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return strSubstring;
    }

    /* JADX INFO: renamed from: a */
    public static String m757a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m762b(String str) throws Throwable {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            aex.m775b("helper", "getMD5 error", e);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m756a(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (-1 != i) {
                stringWriter.write(cArr, 0, i);
            } else {
                return stringWriter.toString();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m763b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m760a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            m761a(fileOutputStream);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m759a(File file, String str) {
        m760a(file, str.getBytes());
    }

    /* JADX INFO: renamed from: a */
    public static String m755a(File file) throws Throwable {
        FileInputStream fileInputStream;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    String str = new String(bArr);
                    m764c(fileInputStream);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    m764c(fileInputStream);
                    throw th;
                }
            } else {
                m764c(null);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        m764c(fileInputStream);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static void m764c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m761a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
