package org.android.spdy;

/* JADX INFO: loaded from: classes.dex */
public class NetSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public NetSparseArray() {
        this(10);
    }

    public NetSparseArray(int i) {
        this.mGarbage = false;
        this.mKeys = new int[i];
        this.mValues = new Object[i];
        this.mSize = 0;
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        return (iBinarySearch < 0 || this.mValues[iBinarySearch] == DELETED) ? e : (E) this.mValues[iBinarySearch];
    }

    public void delete(int i) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (iBinarySearch < 0 || this.mValues[iBinarySearch] == DELETED) {
            return;
        }
        this.mValues[iBinarySearch] = DELETED;
        this.mGarbage = true;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    /* JADX INFO: renamed from: gc */
    private void m11036gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(int i, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = e;
            return;
        }
        int iBinarySearch2 = iBinarySearch ^ (-1);
        if (iBinarySearch2 < this.mSize && this.mValues[iBinarySearch2] == DELETED) {
            this.mKeys[iBinarySearch2] = i;
            this.mValues[iBinarySearch2] = e;
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m11036gc();
            iBinarySearch2 = binarySearch(this.mKeys, 0, this.mSize, i) ^ (-1);
        }
        if (this.mSize >= this.mKeys.length) {
            int i2 = this.mSize + 20;
            int[] iArr = new int[i2];
            Object[] objArr = new Object[i2];
            System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        if (this.mSize - iBinarySearch2 != 0) {
            int i3 = iBinarySearch2 + 1;
            System.arraycopy(this.mKeys, iBinarySearch2, this.mKeys, i3, this.mSize - iBinarySearch2);
            System.arraycopy(this.mValues, iBinarySearch2, this.mValues, i3, this.mSize - iBinarySearch2);
        }
        this.mKeys[iBinarySearch2] = i;
        this.mValues[iBinarySearch2] = e;
        this.mSize++;
    }

    public void toArray(E[] eArr) {
        for (int i = 0; i < eArr.length; i++) {
            eArr[i] = this.mValues[i];
        }
    }

    public int size() {
        if (this.mGarbage) {
            m11036gc();
        }
        return this.mSize;
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            m11036gc();
        }
        return this.mKeys[i];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            m11036gc();
        }
        return (E) this.mValues[i];
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            m11036gc();
        }
        this.mValues[i] = e;
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            m11036gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            m11036gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int i, E e) {
        if (this.mSize != 0 && i <= this.mKeys[this.mSize - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m11036gc();
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int i3 = i2 + 1;
            int[] iArr = new int[i3];
            Object[] objArr = new Object[i3];
            System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i2] = i;
        this.mValues[i2] = e;
        this.mSize = i2 + 1;
    }

    private static int binarySearch(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        int i5 = i - 1;
        int i6 = i4;
        while (i6 - i5 > 1) {
            int i7 = (i6 + i5) / 2;
            if (iArr[i7] < i3) {
                i5 = i7;
            } else {
                i6 = i7;
            }
        }
        return i6 == i4 ? i4 ^ (-1) : iArr[i6] == i3 ? i6 : i6 ^ (-1);
    }
}
