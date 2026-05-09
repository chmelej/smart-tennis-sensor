package p000;

import p000.ark;

/* JADX INFO: compiled from: JoinPointImpl.java */
/* JADX INFO: loaded from: classes.dex */
class arv implements arm {

    /* JADX INFO: renamed from: a */
    Object f4871a;

    /* JADX INFO: renamed from: b */
    Object f4872b;

    /* JADX INFO: renamed from: c */
    Object[] f4873c;

    /* JADX INFO: renamed from: d */
    ark.InterfaceC0740a f4874d;

    /* JADX INFO: renamed from: arv$a */
    /* JADX INFO: compiled from: JoinPointImpl.java */
    static class C0741a implements ark.InterfaceC0740a {

        /* JADX INFO: renamed from: a */
        String f4875a;

        /* JADX INFO: renamed from: b */
        arn f4876b;

        /* JADX INFO: renamed from: c */
        arr f4877c;

        /* JADX INFO: renamed from: d */
        private int f4878d;

        public C0741a(int i, String str, arn arnVar, arr arrVar) {
            this.f4875a = str;
            this.f4876b = arnVar;
            this.f4877c = arrVar;
            this.f4878d = i;
        }

        /* JADX INFO: renamed from: a */
        public String m5290a() {
            return this.f4875a;
        }

        /* JADX INFO: renamed from: b */
        public arn m5292b() {
            return this.f4876b;
        }

        /* JADX INFO: renamed from: a */
        String m5291a(asa asaVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(asaVar.m5316a(m5290a()));
            stringBuffer.append("(");
            stringBuffer.append(((ary) m5292b()).m5298b(asaVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return m5291a(asa.f4897k);
        }
    }

    public arv(ark.InterfaceC0740a interfaceC0740a, Object obj, Object obj2, Object[] objArr) {
        this.f4874d = interfaceC0740a;
        this.f4871a = obj;
        this.f4872b = obj2;
        this.f4873c = objArr;
    }

    @Override // p000.ark
    /* JADX INFO: renamed from: a */
    public Object mo5275a() {
        return this.f4872b;
    }

    public final String toString() {
        return this.f4874d.toString();
    }
}
