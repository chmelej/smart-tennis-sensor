package p000;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IppInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface aig extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo1312a(String str);

    /* JADX INFO: renamed from: aig$a */
    /* JADX INFO: compiled from: IppInterface.java */
    public static abstract class AbstractBinderC0117a extends Binder implements aig {
        /* JADX INFO: renamed from: a */
        public static aig m1313a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.rome.android.ipp.binder.aidl.IppInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof aig)) {
                return (aig) iInterfaceQueryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("org.rome.android.ipp.binder.aidl.IppInterface");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("org.rome.android.ipp.binder.aidl.IppInterface");
            mo1312a(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: aig$a$a */
        /* JADX INFO: compiled from: IppInterface.java */
        static class a implements aig {

            /* JADX INFO: renamed from: a */
            private IBinder f1129a;

            a(IBinder iBinder) {
                this.f1129a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1129a;
            }

            @Override // p000.aig
            /* JADX INFO: renamed from: a */
            public void mo1312a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.rome.android.ipp.binder.aidl.IppInterface");
                    parcelObtain.writeString(str);
                    this.f1129a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
