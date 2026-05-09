package p000;

/* JADX INFO: compiled from: TProtocolUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class afy {

    /* JADX INFO: renamed from: a */
    private static int f811a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a */
    public static void m908a(afv afvVar, byte b) {
        m909a(afvVar, b, f811a);
    }

    /* JADX INFO: renamed from: a */
    public static void m909a(afv afvVar, byte b, int i) throws afi {
        if (i <= 0) {
            throw new afi("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                afvVar.mo873p();
                return;
            case 3:
                afvVar.mo874q();
                return;
            case 4:
                afvVar.mo878u();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                afvVar.mo875r();
                return;
            case 8:
                afvVar.mo876s();
                return;
            case 10:
                afvVar.mo877t();
                return;
            case 11:
                afvVar.mo880w();
                return;
            case 12:
                afvVar.mo863f();
                while (true) {
                    afr afrVarMo865h = afvVar.mo865h();
                    if (afrVarMo865h.f802b != 0) {
                        m909a(afvVar, afrVarMo865h.f802b, i - 1);
                        afvVar.mo866i();
                    } else {
                        afvVar.mo864g();
                        return;
                    }
                }
                break;
            case 13:
                afu afuVarMo867j = afvVar.mo867j();
                while (i2 < afuVarMo867j.f808c) {
                    int i3 = i - 1;
                    m909a(afvVar, afuVarMo867j.f806a, i3);
                    m909a(afvVar, afuVarMo867j.f807b, i3);
                    i2++;
                }
                afvVar.mo868k();
                return;
            case 14:
                afz afzVarMo871n = afvVar.mo871n();
                while (i2 < afzVarMo871n.f813b) {
                    m909a(afvVar, afzVarMo871n.f812a, i - 1);
                    i2++;
                }
                afvVar.mo872o();
                return;
            case 15:
                afs afsVarMo869l = afvVar.mo869l();
                while (i2 < afsVarMo869l.f805b) {
                    m909a(afvVar, afsVarMo869l.f804a, i - 1);
                    i2++;
                }
                afvVar.mo870m();
                return;
        }
    }
}
