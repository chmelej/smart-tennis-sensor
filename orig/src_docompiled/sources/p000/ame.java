package p000;

/* JADX INFO: compiled from: SecureDfuError.java */
/* JADX INFO: loaded from: classes.dex */
public final class ame {
    /* JADX INFO: renamed from: b */
    public static String m1934b(int i) {
        switch (i) {
            case 2:
                return "Wrong command format";
            case 3:
                return "Unknown command";
            case 4:
                return "Init command invalid";
            case 5:
                return "FW version failure";
            case 6:
                return "HW version failure";
            case 7:
                return "SD version failure";
            case 8:
                return "Signature mismatch";
            case 9:
                return "Wrong hash type";
            case 10:
                return "Hash failed";
            case 11:
                return "Wring signature type";
            case 12:
                return "Verification failed";
            case 13:
                return "Insufficient space";
            default:
                return "Reserved for future use";
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m1933a(int i) {
        switch (i & (-8193)) {
            case 2:
                return "REMOTE DFU OP CODE NOT SUPPORTED";
            case 3:
                return "REMOTE DFU INVALID PARAM";
            case 4:
                return "REMOTE DFU INSUFFICIENT RESOURCES";
            case 5:
                return "REMOTE DFU INVALID OBJECT";
            case 6:
            case 9:
            default:
                return "UNKNOWN (" + i + ")";
            case 7:
                return "REMOTE DFU UNSUPPORTED TYPE";
            case 8:
                return "REMOTE DFU OPERATION NOT PERMITTED";
            case 10:
                return "REMOTE DFU OPERATION FAILED";
            case 11:
                return "REMOTE DFU EXTENDED ERROR";
        }
    }
}
