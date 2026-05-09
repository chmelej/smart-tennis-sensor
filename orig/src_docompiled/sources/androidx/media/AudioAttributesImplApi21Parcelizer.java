package androidx.media;

import android.media.AudioAttributes;
import android.support.v4.media.AudioAttributesImplApi21;
import p000.AbstractC1788hz;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1788hz abstractC1788hz) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.mAudioAttributes = (AudioAttributes) abstractC1788hz.m9754b(audioAttributesImplApi21.mAudioAttributes, 1);
        audioAttributesImplApi21.mLegacyStreamType = abstractC1788hz.m9753b(audioAttributesImplApi21.mLegacyStreamType, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1788hz abstractC1788hz) {
        abstractC1788hz.m9749a(false, false);
        abstractC1788hz.m9744a(audioAttributesImplApi21.mAudioAttributes, 1);
        abstractC1788hz.m9742a(audioAttributesImplApi21.mLegacyStreamType, 2);
    }
}
