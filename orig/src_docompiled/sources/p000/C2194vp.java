package p000;

import android.media.MediaFormat;
import p000.AbstractC2195vq;

/* JADX INFO: renamed from: vp */
/* JADX INFO: compiled from: HWAudioEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C2194vp extends AbstractC2195vq {

    /* JADX INFO: renamed from: f */
    private C2150tz f13177f;

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b */
    protected String mo8629b() {
        return "HWAudioEncoder";
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: e */
    protected String mo12016e() {
        return "audio/mp4a-latm";
    }

    public C2194vp(C2150tz c2150tz) {
        this.f13177f = c2150tz;
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: d */
    protected MediaFormat mo12015d() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.f13177f.m11744b(), this.f13177f.m11746c());
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("sample-rate", this.f13177f.m11744b());
        mediaFormatCreateAudioFormat.setInteger("channel-count", this.f13177f.m11746c());
        mediaFormatCreateAudioFormat.setInteger("bitrate", this.f13177f.m11748d());
        mediaFormatCreateAudioFormat.setInteger("max-input-size", 16384);
        return mediaFormatCreateAudioFormat;
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: f */
    protected AbstractC2195vq.a mo12017f() {
        return AbstractC2195vq.a.AUDIO_ENCODER;
    }
}
