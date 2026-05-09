package p000;

import java.io.IOException;

/* JADX INFO: compiled from: StreamResetException.java */
/* JADX INFO: loaded from: classes.dex */
public final class apa extends IOException {

    /* JADX INFO: renamed from: a */
    public final aoo f4558a;

    public apa(aoo aooVar) {
        super("stream was reset: " + aooVar);
        this.f4558a = aooVar;
    }
}
