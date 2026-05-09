package com.github.mikephil.charting.matrix;

/* JADX INFO: loaded from: classes.dex */
public final class Vector3 {

    /* JADX INFO: renamed from: x */
    public float f8919x;

    /* JADX INFO: renamed from: y */
    public float f8920y;

    /* JADX INFO: renamed from: z */
    public float f8921z;
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);

    public Vector3() {
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }

    public final void add(Vector3 vector3) {
        this.f8919x += vector3.f8919x;
        this.f8920y += vector3.f8920y;
        this.f8921z += vector3.f8921z;
    }

    public final void add(float f, float f2, float f3) {
        this.f8919x += f;
        this.f8920y += f2;
        this.f8921z += f3;
    }

    public final void subtract(Vector3 vector3) {
        this.f8919x -= vector3.f8919x;
        this.f8920y -= vector3.f8920y;
        this.f8921z -= vector3.f8921z;
    }

    public final void subtractMultiple(Vector3 vector3, float f) {
        this.f8919x -= vector3.f8919x * f;
        this.f8920y -= vector3.f8920y * f;
        this.f8921z -= vector3.f8921z * f;
    }

    public final void multiply(float f) {
        this.f8919x *= f;
        this.f8920y *= f;
        this.f8921z *= f;
    }

    public final void multiply(Vector3 vector3) {
        this.f8919x *= vector3.f8919x;
        this.f8920y *= vector3.f8920y;
        this.f8921z *= vector3.f8921z;
    }

    public final void divide(float f) {
        if (f != 0.0f) {
            this.f8919x /= f;
            this.f8920y /= f;
            this.f8921z /= f;
        }
    }

    public final void set(Vector3 vector3) {
        this.f8919x = vector3.f8919x;
        this.f8920y = vector3.f8920y;
        this.f8921z = vector3.f8921z;
    }

    public final void set(float f, float f2, float f3) {
        this.f8919x = f;
        this.f8920y = f2;
        this.f8921z = f3;
    }

    public final float dot(Vector3 vector3) {
        return (this.f8919x * vector3.f8919x) + (this.f8920y * vector3.f8920y) + (this.f8921z * vector3.f8921z);
    }

    public final Vector3 cross(Vector3 vector3) {
        return new Vector3((this.f8920y * vector3.f8921z) - (this.f8921z * vector3.f8920y), (this.f8921z * vector3.f8919x) - (this.f8919x * vector3.f8921z), (this.f8919x * vector3.f8920y) - (this.f8920y * vector3.f8919x));
    }

    public final float length() {
        return (float) Math.sqrt(length2());
    }

    public final float length2() {
        return (this.f8919x * this.f8919x) + (this.f8920y * this.f8920y) + (this.f8921z * this.f8921z);
    }

    public final float distance2(Vector3 vector3) {
        float f = this.f8919x - vector3.f8919x;
        float f2 = this.f8920y - vector3.f8920y;
        float f3 = this.f8921z - vector3.f8921z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f8919x /= length;
            this.f8920y /= length;
            this.f8921z /= length;
        }
        return length;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }
}
