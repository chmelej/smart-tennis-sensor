package no.nordicsemi.android.dfu.internal.manifest;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class Manifest {
    protected FileInfo application;
    protected FileInfo bootloader;

    @SerializedName("bootloader_application")
    protected SoftDeviceBootloaderFileInfo bootloaderApplication;
    protected FileInfo softdevice;

    @SerializedName("softdevice_application")
    protected SoftDeviceBootloaderFileInfo softdeviceApplication;

    @SerializedName("softdevice_bootloader")
    protected SoftDeviceBootloaderFileInfo softdeviceBootloader;

    @SerializedName("softdevice_bootloader_application")
    protected SoftDeviceBootloaderFileInfo softdeviceBootloaderApplication;

    public FileInfo getApplicationInfo() {
        if (this.application != null) {
            return this.application;
        }
        if (this.softdeviceApplication != null) {
            return this.softdeviceApplication;
        }
        if (this.bootloaderApplication != null) {
            return this.bootloaderApplication;
        }
        return this.softdeviceBootloaderApplication;
    }

    public FileInfo getBootloaderInfo() {
        return this.bootloader;
    }

    public FileInfo getSoftdeviceInfo() {
        return this.softdevice;
    }

    public SoftDeviceBootloaderFileInfo getSoftdeviceBootloaderInfo() {
        return this.softdeviceBootloader;
    }

    public boolean isSecureDfuRequired() {
        return (this.bootloaderApplication == null && this.softdeviceApplication == null && this.softdeviceBootloaderApplication == null) ? false : true;
    }
}
