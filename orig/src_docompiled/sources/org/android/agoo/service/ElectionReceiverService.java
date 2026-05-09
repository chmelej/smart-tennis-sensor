package org.android.agoo.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ElectionReceiverService extends IInterface {
    boolean sendElectionResult(Intent intent);

    public static abstract class Stub extends Binder implements ElectionReceiverService {
        private static final String DESCRIPTOR = "org.android.agoo.service.ElectionReceiverService";
        static final int TRANSACTION_sendElectionResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ElectionReceiverService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ElectionReceiverService)) {
                return (ElectionReceiverService) iInterfaceQueryLocalInterface;
            }
            return new C2002a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean zSendElectionResult = sendElectionResult(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zSendElectionResult ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: org.android.agoo.service.ElectionReceiverService$Stub$a */
        static class C2002a implements ElectionReceiverService {

            /* JADX INFO: renamed from: a */
            private IBinder f12043a;

            /* JADX INFO: renamed from: a */
            public String m11033a() {
                return Stub.DESCRIPTOR;
            }

            C2002a(IBinder iBinder) {
                this.f12043a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12043a;
            }

            @Override // org.android.agoo.service.ElectionReceiverService
            public boolean sendElectionResult(Intent intent) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f12043a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
