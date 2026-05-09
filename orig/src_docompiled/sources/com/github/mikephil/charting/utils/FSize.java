package com.github.mikephil.charting.utils;

/* JADX INFO: loaded from: classes.dex */
public final class FSize {
    public final float height;
    public final float width;

    public FSize(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        return this.width == fSize.width && this.height == fSize.height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }
}
