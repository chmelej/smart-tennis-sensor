package p000;

/* JADX INFO: compiled from: ErrorCode.java */
/* JADX INFO: loaded from: classes.dex */
public enum aoo {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* JADX INFO: renamed from: l */
    public final int f4389l;

    aoo(int i) {
        this.f4389l = i;
    }

    /* JADX INFO: renamed from: a */
    public static aoo m4659a(int i) {
        for (aoo aooVar : values()) {
            if (aooVar.f4389l == i) {
                return aooVar;
            }
        }
        return null;
    }
}
