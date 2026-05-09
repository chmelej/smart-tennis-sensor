package p000;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: wv */
/* JADX INFO: compiled from: MP4MuxerCore.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2227wv {

    /* JADX INFO: renamed from: a */
    protected String f13381a;

    /* JADX INFO: renamed from: b */
    protected int f13382b = -1;

    /* JADX INFO: renamed from: c */
    protected int f13383c = -1;

    /* JADX INFO: renamed from: d */
    protected long f13384d = -1;

    /* JADX INFO: renamed from: e */
    protected long f13385e = -1;

    /* JADX INFO: renamed from: a */
    public abstract void mo8641a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo8642a();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo8643a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i);

    /* JADX INFO: renamed from: b */
    public int m12173b() {
        return this.f13382b;
    }

    /* JADX INFO: renamed from: c */
    public int m12174c() {
        return this.f13383c;
    }
}
