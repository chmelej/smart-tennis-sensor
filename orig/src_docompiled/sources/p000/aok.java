package p000;

import java.net.ProtocolException;

/* JADX INFO: compiled from: StatusLine.java */
/* JADX INFO: loaded from: classes.dex */
public final class aok {

    /* JADX INFO: renamed from: a */
    public final anc f4349a;

    /* JADX INFO: renamed from: b */
    public final int f4350b;

    /* JADX INFO: renamed from: c */
    public final String f4351c;

    public aok(anc ancVar, int i, String str) {
        this.f4349a = ancVar;
        this.f4350b = i;
        this.f4351c = str;
    }

    /* JADX INFO: renamed from: a */
    public static aok m4647a(String str) throws ProtocolException {
        anc ancVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                ancVar = anc.HTTP_1_0;
            } else if (iCharAt == 1) {
                ancVar = anc.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            ancVar = anc.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            String strSubstring = "";
            if (str.length() > i2) {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new aok(ancVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4349a == anc.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4350b);
        if (this.f4351c != null) {
            sb.append(' ');
            sb.append(this.f4351c);
        }
        return sb.toString();
    }
}
