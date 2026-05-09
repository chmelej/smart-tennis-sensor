package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingId.java */
/* JADX INFO: loaded from: classes.dex */
public class aer {

    /* JADX INFO: renamed from: aer$a */
    /* JADX INFO: compiled from: AdvertisingId.java */
    static final class C0066a {

        /* JADX INFO: renamed from: a */
        private final String f702a;

        /* JADX INFO: renamed from: b */
        private final boolean f703b;

        C0066a(String str, boolean z) {
            this.f702a = str;
            this.f703b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public String m698a() {
            return this.f702a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m696a(Context context) {
        try {
            C0066a c0066aM697b = m697b(context);
            if (c0066aM697b == null) {
                return null;
            }
            return c0066aM697b.m698a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static C0066a m697b(Context context) throws Exception {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC0067b serviceConnectionC0067b = new ServiceConnectionC0067b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, serviceConnectionC0067b, 1)) {
                try {
                    try {
                        C0068c c0068c = new C0068c(serviceConnectionC0067b.m700a());
                        return new C0066a(c0068c.m701a(), c0068c.m702a(true));
                    } catch (Exception e) {
                        throw e;
                    }
                } finally {
                    context.unbindService(serviceConnectionC0067b);
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: renamed from: aer$b */
    /* JADX INFO: compiled from: AdvertisingId.java */
    static final class ServiceConnectionC0067b implements ServiceConnection {

        /* JADX INFO: renamed from: a */
        boolean f704a;

        /* JADX INFO: renamed from: b */
        private final LinkedBlockingQueue<IBinder> f705b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private ServiceConnectionC0067b() {
            this.f704a = false;
            this.f705b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f705b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        /* JADX INFO: renamed from: a */
        public IBinder m700a() {
            if (this.f704a) {
                throw new IllegalStateException();
            }
            this.f704a = true;
            return this.f705b.take();
        }
    }

    /* JADX INFO: renamed from: aer$c */
    /* JADX INFO: compiled from: AdvertisingId.java */
    static final class C0068c implements IInterface {

        /* JADX INFO: renamed from: a */
        private IBinder f706a;

        public C0068c(IBinder iBinder) {
            this.f706a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f706a;
        }

        /* JADX INFO: renamed from: a */
        public String m701a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f706a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m702a(boolean z) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.f706a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
