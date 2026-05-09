package p000;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: pm */
/* JADX INFO: compiled from: JuliLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class C2027pm extends AbstractC2029po {

    /* JADX INFO: renamed from: a */
    Logger f12188a;

    public C2027pm(String str) {
        this.f12188a = Logger.getLogger(str);
    }

    @Override // p000.AbstractC2029po
    /* JADX INFO: renamed from: a */
    public void mo11091a(String str) {
        this.f12188a.log(Level.FINE, str);
    }

    @Override // p000.AbstractC2029po
    /* JADX INFO: renamed from: b */
    public void mo11092b(String str) {
        this.f12188a.log(Level.SEVERE, str);
    }
}
