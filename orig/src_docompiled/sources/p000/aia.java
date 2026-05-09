package p000;

/* JADX INFO: compiled from: HexUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class aia {
    /* JADX INFO: renamed from: a */
    public static final String m1293a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
