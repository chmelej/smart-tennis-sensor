package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import com.lidroid.xutils.util.CharsetUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class anm {

    /* JADX INFO: renamed from: r */
    private static final Method f4224r;

    /* JADX INFO: renamed from: s */
    private static final Pattern f4225s;

    /* JADX INFO: renamed from: a */
    public static final byte[] f4207a = new byte[0];

    /* JADX INFO: renamed from: b */
    public static final String[] f4208b = new String[0];

    /* JADX INFO: renamed from: c */
    public static final anh f4209c = anh.m4478a(null, f4207a);

    /* JADX INFO: renamed from: d */
    public static final anf f4210d = anf.m4443a((ana) null, f4207a);

    /* JADX INFO: renamed from: i */
    private static final ByteString f4215i = ByteString.decodeHex("efbbbf");

    /* JADX INFO: renamed from: j */
    private static final ByteString f4216j = ByteString.decodeHex("feff");

    /* JADX INFO: renamed from: k */
    private static final ByteString f4217k = ByteString.decodeHex("fffe");

    /* JADX INFO: renamed from: l */
    private static final ByteString f4218l = ByteString.decodeHex("0000ffff");

    /* JADX INFO: renamed from: m */
    private static final ByteString f4219m = ByteString.decodeHex("ffff0000");

    /* JADX INFO: renamed from: e */
    public static final Charset f4211e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f */
    public static final Charset f4212f = Charset.forName(CharsetUtils.DEFAULT_ENCODING_CHARSET);

    /* JADX INFO: renamed from: n */
    private static final Charset f4220n = Charset.forName("UTF-16BE");

    /* JADX INFO: renamed from: o */
    private static final Charset f4221o = Charset.forName("UTF-16LE");

    /* JADX INFO: renamed from: p */
    private static final Charset f4222p = Charset.forName("UTF-32BE");

    /* JADX INFO: renamed from: q */
    private static final Charset f4223q = Charset.forName("UTF-32LE");

    /* JADX INFO: renamed from: g */
    public static final TimeZone f4213g = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: h */
    public static final Comparator<String> f4214h = new Comparator<String>() { // from class: anm.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* JADX INFO: renamed from: a */
    public static int m4489a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f4224r = declaredMethod;
        f4225s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* JADX INFO: renamed from: a */
    public static void m4507a(Throwable th, Throwable th2) {
        if (f4224r != null) {
            try {
                f4224r.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4505a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4510a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    public static void m4506a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4508a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m4509a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4512a(Source source, int i, TimeUnit timeUnit) {
        try {
            return m4518b(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4518b(Source source, int i, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(jNanoTime + Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)));
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> List<T> m4500a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* JADX INFO: renamed from: a */
    public static <K, V> Map<K, V> m4502a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* JADX INFO: renamed from: a */
    public static <T> List<T> m4501a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* JADX INFO: renamed from: a */
    public static ThreadFactory m4503a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: anm.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static String[] m4513a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4517b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static String m4496a(amy amyVar, boolean z) {
        String strM2085f;
        if (amyVar.m2085f().contains(":")) {
            strM2085f = "[" + amyVar.m2085f() + "]";
        } else {
            strM2085f = amyVar.m2085f();
        }
        if (!z && amyVar.m2086g() == amy.m2065a(amyVar.m2079b())) {
            return strM2085f;
        }
        return strM2085f + ":" + amyVar.m2086g();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4509a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static int m4494a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static String[] m4514a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* JADX INFO: renamed from: a */
    public static int m4490a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                    break;
                default:
                    return i;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: b */
    public static int m4516b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: c */
    public static String m4519c(String str, int i, int i2) {
        int iM4490a = m4490a(str, i, i2);
        return str.substring(iM4490a, m4516b(str, iM4490a, i2));
    }

    /* JADX INFO: renamed from: a */
    public static int m4492a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static int m4491a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static String m4497a(String str) {
        InetAddress inetAddressM4521d;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressM4521d = m4521d(str, 1, str.length() - 1);
            } else {
                inetAddressM4521d = m4521d(str, 0, str.length());
            }
            if (inetAddressM4521d == null) {
                return null;
            }
            byte[] address = inetAddressM4521d.getAddress();
            if (address.length == 16) {
                return m4499a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (m4522d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m4522d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static int m4515b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4520c(String str) {
        return f4225s.matcher(str).matches();
    }

    /* JADX INFO: renamed from: a */
    public static String m4498a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public static int m4493a(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    /* JADX INFO: renamed from: a */
    public static AssertionError m4495a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        if (r3 == r0.length) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        if (r4 != (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
    
        r11 = r3 - r4;
        java.lang.System.arraycopy(r0, r4, r0, r0.length - r11, r11);
        java.util.Arrays.fill(r0, r4, (r0.length - r3) + r4, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        return java.net.InetAddress.getByAddress(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    @javax.annotation.Nullable
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress m4521d(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L9:
            r6 = 0
            if (r11 >= r12) goto L7c
            int r7 = r0.length
            if (r3 != r7) goto L10
            return r6
        L10:
            int r7 = r11 + 2
            if (r7 > r12) goto L29
            java.lang.String r8 = "::"
            r9 = 2
            boolean r8 = r10.regionMatches(r11, r8, r2, r9)
            if (r8 == 0) goto L29
            if (r4 == r1) goto L20
            return r6
        L20:
            int r3 = r3 + 2
            if (r7 != r12) goto L26
            r4 = r3
            goto L7c
        L26:
            r4 = r3
            r5 = r7
            goto L4d
        L29:
            if (r3 == 0) goto L4c
            java.lang.String r7 = ":"
            r8 = 1
            boolean r7 = r10.regionMatches(r11, r7, r2, r8)
            if (r7 == 0) goto L37
            int r11 = r11 + 1
            goto L4c
        L37:
            java.lang.String r7 = "."
            boolean r11 = r10.regionMatches(r11, r7, r2, r8)
            if (r11 == 0) goto L4b
            int r11 = r3 + (-2)
            boolean r10 = m4511a(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L48
            return r6
        L48:
            int r3 = r3 + 2
            goto L7c
        L4b:
            return r6
        L4c:
            r5 = r11
        L4d:
            r11 = r5
            r7 = 0
        L4f:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = m4489a(r8)
            if (r8 != r1) goto L5c
            goto L62
        L5c:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L4f
        L62:
            int r8 = r11 - r5
            if (r8 == 0) goto L7b
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7b
        L6a:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L9
        L7b:
            return r6
        L7c:
            int r10 = r0.length
            if (r3 == r10) goto L8f
            if (r4 != r1) goto L82
            return r6
        L82:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L8f:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L94
            return r10
        L94:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.anm.m4521d(java.lang.String, int, int):java.net.InetAddress");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4511a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX INFO: renamed from: a */
    private static String m4499a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i3 && i6 >= 4) {
                i4 = i2;
                i3 = i6;
            }
            i2 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i4) {
                buffer.writeByte(58);
                i += i3;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return buffer.readUtf8();
    }

    /* JADX INFO: renamed from: a */
    public static X509TrustManager m4504a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw m4495a("No System TLS", (Exception) e);
        }
    }
}
