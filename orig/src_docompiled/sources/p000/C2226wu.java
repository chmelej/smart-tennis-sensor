package p000;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.muxer.FFMP4Muxer;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: wu */
/* JADX INFO: compiled from: MP4Muxer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2226wu {

    /* JADX INFO: renamed from: a */
    private AbstractC2227wv f13380a = new FFMP4Muxer();

    /* JADX INFO: renamed from: a */
    public synchronized boolean m12168a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        return m12169a(str, mediaFormat, mediaFormat2, 0);
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m12169a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i) {
        return this.f13380a.mo8643a(str, mediaFormat, mediaFormat2, i);
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m12167a() {
        return this.f13380a.mo8642a();
    }

    /* JADX INFO: renamed from: b */
    public int m12170b() {
        return this.f13380a.m12173b();
    }

    /* JADX INFO: renamed from: c */
    public int m12172c() {
        return this.f13380a.m12174c();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m12165a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.f13380a.mo8641a(i, byteBuffer, bufferInfo);
    }

    /* JADX INFO: renamed from: a */
    public void m12166a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m12165a(m12170b(), byteBuffer, bufferInfo);
    }

    /* JADX INFO: renamed from: b */
    public void m12171b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m12165a(m12172c(), byteBuffer, bufferInfo);
    }
}
