package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import p000.DialogInterfaceC1674dv;

/* JADX INFO: loaded from: classes.dex */
public class AppSettingsDialog implements Parcelable {
    public static final Parcelable.Creator<AppSettingsDialog> CREATOR = new Parcelable.Creator<AppSettingsDialog>() { // from class: pub.devrel.easypermissions.AppSettingsDialog.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppSettingsDialog createFromParcel(Parcel parcel) {
            return new AppSettingsDialog(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppSettingsDialog[] newArray(int i) {
            return new AppSettingsDialog[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private final int f12217a;

    /* JADX INFO: renamed from: b */
    private final String f12218b;

    /* JADX INFO: renamed from: c */
    private final String f12219c;

    /* JADX INFO: renamed from: d */
    private final String f12220d;

    /* JADX INFO: renamed from: e */
    private final String f12221e;

    /* JADX INFO: renamed from: f */
    private final int f12222f;

    /* JADX INFO: renamed from: g */
    private Object f12223g;

    /* JADX INFO: renamed from: h */
    private Context f12224h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private AppSettingsDialog(Parcel parcel) {
        this.f12217a = parcel.readInt();
        this.f12218b = parcel.readString();
        this.f12219c = parcel.readString();
        this.f12220d = parcel.readString();
        this.f12221e = parcel.readString();
        this.f12222f = parcel.readInt();
    }

    /* JADX INFO: renamed from: a */
    static AppSettingsDialog m11128a(Intent intent, Activity activity) {
        AppSettingsDialog appSettingsDialog = (AppSettingsDialog) intent.getParcelableExtra("extra_app_settings");
        appSettingsDialog.m11129a(activity);
        return appSettingsDialog;
    }

    /* JADX INFO: renamed from: a */
    private void m11129a(Object obj) {
        this.f12223g = obj;
        if (obj instanceof Activity) {
            this.f12224h = (Activity) obj;
            return;
        }
        if (obj instanceof Fragment) {
            this.f12224h = ((Fragment) obj).getContext();
        } else {
            if (obj instanceof android.app.Fragment) {
                this.f12224h = ((android.app.Fragment) obj).getActivity();
                return;
            }
            throw new IllegalStateException("Unknown object: " + obj);
        }
    }

    /* JADX INFO: renamed from: a */
    DialogInterfaceC1674dv m11130a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogInterfaceC1674dv.a aVar;
        if (this.f12217a > 0) {
            aVar = new DialogInterfaceC1674dv.a(this.f12224h, this.f12217a);
        } else {
            aVar = new DialogInterfaceC1674dv.a(this.f12224h);
        }
        return aVar.m8903a(false).m8901a(this.f12219c).m8904b(this.f12218b).m8902a(this.f12220d, onClickListener).m8905b(this.f12221e, onClickListener2).m8907c();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12217a);
        parcel.writeString(this.f12218b);
        parcel.writeString(this.f12219c);
        parcel.writeString(this.f12220d);
        parcel.writeString(this.f12221e);
        parcel.writeInt(this.f12222f);
    }
}
