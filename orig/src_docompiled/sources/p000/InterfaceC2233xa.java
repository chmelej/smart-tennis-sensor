package p000;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: xa */
/* JADX INFO: compiled from: RemoteSSO.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC2233xa extends IInterface {
    /* JADX INFO: renamed from: a */
    String m12207a();

    /* JADX INFO: renamed from: b */
    String m12208b();

    /* JADX INFO: renamed from: xa$a */
    /* JADX INFO: compiled from: RemoteSSO.java */
    public static abstract class a extends Binder implements InterfaceC2233xa {
        public a() {
            attachInterface(this, "com.sina.sso.RemoteSSO");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.sina.sso.RemoteSSO");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String strA = m12207a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    String strB = m12208b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
