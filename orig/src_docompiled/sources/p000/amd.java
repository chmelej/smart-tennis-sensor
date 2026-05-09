package p000;

/* JADX INFO: compiled from: LegacyDfuError.java */
/* JADX INFO: loaded from: classes.dex */
public final class amd {
    /* JADX INFO: renamed from: a */
    public static String m1932a(int i) {
        switch (i & (-8193)) {
            case 2:
                return "REMOTE DFU INVALID STATE";
            case 3:
                return "REMOTE DFU NOT SUPPORTED";
            case 4:
                return "REMOTE DFU DATA SIZE EXCEEDS LIMIT";
            case 5:
                return "REMOTE DFU INVALID CRC ERROR";
            case 6:
                return "REMOTE DFU OPERATION FAILED";
            default:
                return "UNKNOWN (" + i + ")";
        }
    }
}
