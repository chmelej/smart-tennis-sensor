package android.support.v4.media;

import android.os.Bundle;
import p000.InterfaceC1791ib;

/* JADX INFO: loaded from: classes.dex */
public interface AudioAttributesImpl extends InterfaceC1791ib {
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    Bundle toBundle();
}
