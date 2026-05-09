package p000;

import java.util.List;
import okio.BufferedSource;

/* JADX INFO: compiled from: PushObserver.java */
/* JADX INFO: loaded from: classes.dex */
public interface aoy {

    /* JADX INFO: renamed from: a */
    public static final aoy f4555a = new aoy() { // from class: aoy.1
        @Override // p000.aoy
        /* JADX INFO: renamed from: a */
        public void mo4800a(int i, aoo aooVar) {
        }

        @Override // p000.aoy
        /* JADX INFO: renamed from: a */
        public boolean mo4801a(int i, List<aop> list) {
            return true;
        }

        @Override // p000.aoy
        /* JADX INFO: renamed from: a */
        public boolean mo4802a(int i, List<aop> list, boolean z) {
            return true;
        }

        @Override // p000.aoy
        /* JADX INFO: renamed from: a */
        public boolean mo4803a(int i, BufferedSource bufferedSource, int i2, boolean z) {
            bufferedSource.skip(i2);
            return true;
        }
    };

    /* JADX INFO: renamed from: a */
    void mo4800a(int i, aoo aooVar);

    /* JADX INFO: renamed from: a */
    boolean mo4801a(int i, List<aop> list);

    /* JADX INFO: renamed from: a */
    boolean mo4802a(int i, List<aop> list, boolean z);

    /* JADX INFO: renamed from: a */
    boolean mo4803a(int i, BufferedSource bufferedSource, int i2, boolean z);
}
