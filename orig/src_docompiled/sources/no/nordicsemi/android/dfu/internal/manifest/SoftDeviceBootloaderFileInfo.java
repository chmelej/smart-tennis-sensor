package no.nordicsemi.android.dfu.internal.manifest;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class SoftDeviceBootloaderFileInfo extends FileInfo {

    @SerializedName("bl_size")
    protected int bootloaderSize;

    @SerializedName("sd_size")
    protected int softdeviceSize;

    public int getSoftdeviceSize() {
        return this.softdeviceSize;
    }

    public int getBootloaderSize() {
        return this.bootloaderSize;
    }
}
