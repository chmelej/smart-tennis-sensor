package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import p000.AbstractC1788hz;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1788hz abstractC1788hz) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl) abstractC1788hz.m9755b(audioAttributesCompat.mImpl, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1788hz abstractC1788hz) {
        abstractC1788hz.m9749a(false, false);
        abstractC1788hz.m9746a(audioAttributesCompat.mImpl, 1);
    }
}
