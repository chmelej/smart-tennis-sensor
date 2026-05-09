package p000;

/* JADX INFO: compiled from: MethodSignatureImpl.java */
/* JADX INFO: loaded from: classes.dex */
class arx extends art implements arq {

    /* JADX INFO: renamed from: d */
    Class f4879d;

    arx(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.f4879d = cls2;
    }

    /* JADX INFO: renamed from: c */
    public Class m5294c() {
        if (this.f4879d == null) {
            this.f4879d = m5299c(6);
        }
        return this.f4879d;
    }

    @Override // p000.ary
    /* JADX INFO: renamed from: a */
    protected String mo5293a(asa asaVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(asaVar.m5312a(m5300d()));
        if (asaVar.f4900b) {
            stringBuffer.append(asaVar.m5313a(m5294c()));
        }
        if (asaVar.f4900b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(asaVar.m5314a(m5303f(), m5304g()));
        stringBuffer.append(".");
        stringBuffer.append(m5302e());
        asaVar.m5319b(stringBuffer, m5281a());
        asaVar.m5320c(stringBuffer, m5282b());
        return stringBuffer.toString();
    }
}
