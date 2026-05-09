package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.File;
import java.nio.ByteBuffer;
import p000.AbstractC2227wv;
import p000.C2201vw;

/* JADX INFO: loaded from: classes.dex */
public class FFMP4Muxer extends AbstractC2227wv {

    /* JADX INFO: renamed from: f */
    private long f9044f = 0;

    private native int addAudioStream(long j, int i, int i2, int i3, int i4, int i5);

    private native int addVideoStream(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native int closeFile(long j);

    private native long createFile(String str);

    private native int setESDSHeader(long j, ByteBuffer byteBuffer, int i);

    private native int setSPSPPSHeader(long j, ByteBuffer byteBuffer, int i);

    private native int start(long j);

    private native int writeAudioFrame(long j, ByteBuffer byteBuffer, int i, long j2, int i2);

    private native int writeVideoFrame(long j, ByteBuffer byteBuffer, int i, boolean z, long j2, long j3);

    @Override // p000.AbstractC2227wv
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo8643a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i) {
        boolean z;
        int integer;
        C2201vw.f13225n.m12053c("FFMP4Muxer", "start +");
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
            C2201vw.f13225n.m12053c("FFMP4Muxer", "delete existed file: " + str);
        }
        try {
            try {
                this.f13381a = str;
                this.f9044f = createFile(this.f13381a);
                if (this.f9044f == -1) {
                    C2201vw.f13225n.m12055e("FFMP4Muxer", "muxer create failed!");
                    C2201vw.f13225n.m12053c("FFMP4Muxer", "start -");
                    return false;
                }
                if (mediaFormat != null) {
                    C2201vw.f13225n.m12053c("FFMP4Muxer", "video format : " + mediaFormat);
                    int integer2 = mediaFormat.getInteger("width");
                    int integer3 = mediaFormat.getInteger("height");
                    int integer4 = mediaFormat.containsKey("bitrate") ? mediaFormat.getInteger("bitrate") : 1024000;
                    int integer5 = mediaFormat.containsKey("i-frame-interval") ? mediaFormat.getInteger("i-frame-interval") : 1;
                    int integer6 = mediaFormat.containsKey("frame-rate") ? mediaFormat.getInteger("frame-rate") : 30;
                    this.f13382b = addVideoStream(this.f9044f, integer2, integer3, integer4, integer5 * integer6, integer6, 0, i);
                    boolean z2 = this.f13382b >= 0;
                    C2201vw.f13225n.m12053c("FFMP4Muxer", "addTrack video track: " + this.f13382b);
                    z = z2;
                } else {
                    z = true;
                }
                if (mediaFormat2 != null) {
                    C2201vw.f13225n.m12053c("FFMP4Muxer", "audio format : " + mediaFormat2);
                    this.f13383c = addAudioStream(this.f9044f, mediaFormat2.containsKey("sample-rate") ? mediaFormat2.getInteger("sample-rate") : 44100, mediaFormat2.containsKey("channel-count") ? mediaFormat2.getInteger("channel-count") : 1, mediaFormat2.containsKey("bit-width") ? mediaFormat2.getInteger("bit-width") : 16, (!mediaFormat2.containsKey("bitrate") || (integer = mediaFormat2.getInteger("bitrate")) <= 0) ? 64000 : integer, 0);
                    if (this.f13383c < 0) {
                        z = false;
                    }
                    C2201vw.f13225n.m12053c("FFMP4Muxer", "addTrack audio track: " + this.f13383c);
                }
                if (z) {
                    start(this.f9044f);
                    if (mediaFormat != null) {
                        C2201vw.f13225n.m12053c("FFMP4Muxer", "write video csd from format: " + mediaFormat);
                        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
                        ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
                        if (byteBuffer != null && byteBuffer2 != null) {
                            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining() + byteBuffer2.remaining());
                            byteBufferAllocateDirect.put(byteBuffer);
                            byteBufferAllocateDirect.put(byteBuffer2);
                            byteBuffer.clear();
                            byteBuffer2.clear();
                            byteBufferAllocateDirect.clear();
                            setSPSPPSHeader(this.f9044f, byteBufferAllocateDirect, byteBufferAllocateDirect.capacity());
                        }
                        C2201vw c2201vw = C2201vw.f13225n;
                        StringBuilder sb = new StringBuilder();
                        sb.append("video format error : no ");
                        sb.append(byteBuffer == null ? "csd-0" : "csd-1");
                        c2201vw.m12055e("FFMP4Muxer", sb.toString());
                        C2201vw.f13225n.m12053c("FFMP4Muxer", "start -");
                        return false;
                    }
                    if (mediaFormat2 != null) {
                        C2201vw.f13225n.m12053c("FFMP4Muxer", "write audio csd from format: " + mediaFormat2);
                        ByteBuffer byteBuffer3 = mediaFormat2.getByteBuffer("csd-0");
                        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(byteBuffer3.remaining());
                        byteBufferAllocateDirect2.put(byteBuffer3);
                        byteBuffer3.clear();
                        byteBufferAllocateDirect2.clear();
                        setESDSHeader(this.f9044f, byteBufferAllocateDirect2, byteBufferAllocateDirect2.capacity());
                    }
                }
                C2201vw.f13225n.m12053c("FFMP4Muxer", "start -");
                return z;
            } catch (Exception e) {
                C2201vw.f13225n.m12055e("FFMP4Muxer", e.getMessage());
                C2201vw.f13225n.m12053c("FFMP4Muxer", "start -");
                return false;
            }
        } catch (Throwable th) {
            C2201vw.f13225n.m12053c("FFMP4Muxer", "start -");
            throw th;
        }
    }

    @Override // p000.AbstractC2227wv
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo8642a() {
        C2201vw.f13225n.m12053c("FFMP4Muxer", "stop +");
        if (this.f9044f != 0 && this.f9044f != -1) {
            closeFile(this.f9044f);
            C2201vw.f13225n.m12053c("FFMP4Muxer", "stop -");
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC2227wv
    /* JADX INFO: renamed from: a */
    public synchronized void mo8641a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f9044f != 0 && this.f9044f != -1) {
            if (this.f13382b == i) {
                this.f13384d = bufferInfo.presentationTimeUs;
                writeVideoFrame(this.f9044f, byteBuffer, bufferInfo.size, (bufferInfo.flags & 1) != 0, bufferInfo.presentationTimeUs, bufferInfo.presentationTimeUs);
            } else if (this.f13383c == i) {
                this.f13385e = bufferInfo.presentationTimeUs;
                writeAudioFrame(this.f9044f, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs, 1152);
            }
            return;
        }
        C2201vw.f13225n.m12054d("FFMP4Muxer", "write failed, mMediaMuxer == null or trackIndex < 0 !");
    }
}
