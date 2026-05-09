package androidx.media;

import android.support.v4.media.AudioAttributesImplBase;
import p000.AbstractC1788hz;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1788hz abstractC1788hz) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.mUsage = abstractC1788hz.m9753b(audioAttributesImplBase.mUsage, 1);
        audioAttributesImplBase.mContentType = abstractC1788hz.m9753b(audioAttributesImplBase.mContentType, 2);
        audioAttributesImplBase.mFlags = abstractC1788hz.m9753b(audioAttributesImplBase.mFlags, 3);
        audioAttributesImplBase.mLegacyStream = abstractC1788hz.m9753b(audioAttributesImplBase.mLegacyStream, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1788hz abstractC1788hz) {
        abstractC1788hz.m9749a(false, false);
        abstractC1788hz.m9742a(audioAttributesImplBase.mUsage, 1);
        abstractC1788hz.m9742a(audioAttributesImplBase.mContentType, 2);
        abstractC1788hz.m9742a(audioAttributesImplBase.mFlags, 3);
        abstractC1788hz.m9742a(audioAttributesImplBase.mLegacyStream, 4);
    }
}
