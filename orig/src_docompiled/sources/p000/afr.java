package p000;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes.dex */
public class afr {

    /* JADX INFO: renamed from: a */
    public final String f801a;

    /* JADX INFO: renamed from: b */
    public final byte f802b;

    /* JADX INFO: renamed from: c */
    public final short f803c;

    public afr() {
        this("", (byte) 0, (short) 0);
    }

    public afr(String str, byte b, short s) {
        this.f801a = str;
        this.f802b = b;
        this.f803c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f801a + "' type:" + ((int) this.f802b) + " field-id:" + ((int) this.f803c) + ">";
    }
}
