package p000;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: Http2.java */
/* JADX INFO: loaded from: classes.dex */
public final class aor {

    /* JADX INFO: renamed from: a */
    static final ByteString f4419a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: d */
    private static final String[] f4422d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b */
    static final String[] f4420b = new String[64];

    /* JADX INFO: renamed from: c */
    static final String[] f4421c = new String[256];

    static {
        for (int i = 0; i < f4421c.length; i++) {
            f4421c[i] = anm.m4498a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        f4420b[0] = "";
        f4420b[1] = "END_STREAM";
        int[] iArr = {1};
        f4420b[8] = "PADDED";
        for (int i2 : iArr) {
            f4420b[i2 | 8] = f4420b[i2] + "|PADDED";
        }
        f4420b[4] = "END_HEADERS";
        f4420b[32] = "PRIORITY";
        f4420b[36] = "END_HEADERS|PRIORITY";
        for (int i3 : new int[]{4, 32, 36}) {
            for (int i4 : iArr) {
                int i5 = i4 | i3;
                f4420b[i5] = f4420b[i4] + '|' + f4420b[i3];
                f4420b[i5 | 8] = f4420b[i4] + '|' + f4420b[i3] + "|PADDED";
            }
        }
        for (int i6 = 0; i6 < f4420b.length; i6++) {
            if (f4420b[i6] == null) {
                f4420b[i6] = f4421c[i6];
            }
        }
    }

    private aor() {
    }

    /* JADX INFO: renamed from: a */
    static IllegalArgumentException m4687a(String str, Object... objArr) {
        throw new IllegalArgumentException(anm.m4498a(str, objArr));
    }

    /* JADX INFO: renamed from: b */
    static IOException m4690b(String str, Object... objArr) throws IOException {
        throw new IOException(anm.m4498a(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    static String m4689a(boolean z, int i, int i2, byte b, byte b2) {
        String strM4498a = b < f4422d.length ? f4422d[b] : anm.m4498a("0x%02x", Byte.valueOf(b));
        String strM4688a = m4688a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strM4498a;
        objArr[4] = strM4688a;
        return anm.m4498a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* JADX INFO: renamed from: a */
    static String m4688a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            case 2:
            case 3:
            case 7:
            case 8:
                return f4421c[b2];
            case 4:
            case 6:
                return b2 == 1 ? "ACK" : f4421c[b2];
            case 5:
            default:
                String str = b2 < f4420b.length ? f4420b[b2] : f4421c[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
        }
    }
}
