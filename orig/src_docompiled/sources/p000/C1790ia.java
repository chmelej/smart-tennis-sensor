package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX INFO: renamed from: ia */
/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
public class C1790ia extends AbstractC1788hz {

    /* JADX INFO: renamed from: a */
    private final SparseIntArray f10304a;

    /* JADX INFO: renamed from: b */
    private final Parcel f10305b;

    /* JADX INFO: renamed from: c */
    private final int f10306c;

    /* JADX INFO: renamed from: d */
    private final int f10307d;

    /* JADX INFO: renamed from: e */
    private final String f10308e;

    /* JADX INFO: renamed from: f */
    private int f10309f;

    /* JADX INFO: renamed from: g */
    private int f10310g;

    public C1790ia(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    C1790ia(Parcel parcel, int i, int i2, String str) {
        this.f10304a = new SparseIntArray();
        this.f10309f = -1;
        this.f10310g = 0;
        this.f10305b = parcel;
        this.f10306c = i;
        this.f10307d = i2;
        this.f10310g = this.f10306c;
        this.f10308e = str;
    }

    /* JADX INFO: renamed from: d */
    private int m9767d(int i) {
        while (this.f10310g < this.f10307d) {
            this.f10305b.setDataPosition(this.f10310g);
            int i2 = this.f10305b.readInt();
            int i3 = this.f10305b.readInt();
            this.f10310g += i2;
            if (i3 == i) {
                return this.f10305b.dataPosition();
            }
        }
        return -1;
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: b */
    public boolean mo9758b(int i) {
        int iM9767d = m9767d(i);
        if (iM9767d == -1) {
            return false;
        }
        this.f10305b.setDataPosition(iM9767d);
        return true;
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: c */
    public void mo9761c(int i) {
        mo9757b();
        this.f10309f = i;
        this.f10304a.put(i, this.f10305b.dataPosition());
        mo9741a(0);
        mo9741a(i);
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: b */
    public void mo9757b() {
        if (this.f10309f >= 0) {
            int i = this.f10304a.get(this.f10309f);
            int iDataPosition = this.f10305b.dataPosition();
            this.f10305b.setDataPosition(i);
            this.f10305b.writeInt(iDataPosition - i);
            this.f10305b.setDataPosition(iDataPosition);
        }
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: c */
    protected AbstractC1788hz mo9760c() {
        return new C1790ia(this.f10305b, this.f10305b.dataPosition(), this.f10310g == this.f10306c ? this.f10307d : this.f10310g, this.f10308e + "  ");
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: a */
    public void mo9750a(byte[] bArr) {
        if (bArr != null) {
            this.f10305b.writeInt(bArr.length);
            this.f10305b.writeByteArray(bArr);
        } else {
            this.f10305b.writeInt(-1);
        }
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: a */
    public void mo9741a(int i) {
        this.f10305b.writeInt(i);
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: a */
    public void mo9747a(String str) {
        this.f10305b.writeString(str);
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: a */
    public void mo9743a(Parcelable parcelable) {
        this.f10305b.writeParcelable(parcelable, 0);
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: d */
    public int mo9762d() {
        return this.f10305b.readInt();
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: e */
    public String mo9763e() {
        return this.f10305b.readString();
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: f */
    public byte[] mo9764f() {
        int i = this.f10305b.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f10305b.readByteArray(bArr);
        return bArr;
    }

    @Override // p000.AbstractC1788hz
    /* JADX INFO: renamed from: g */
    public <T extends Parcelable> T mo9765g() {
        return (T) this.f10305b.readParcelable(getClass().getClassLoader());
    }
}
