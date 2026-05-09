package pub.devrel.easypermissions;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import p000.DialogInterfaceC1674dv;

/* JADX INFO: loaded from: classes.dex */
public class AppSettingsDialogHolderActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private DialogInterfaceC1674dv f12225a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12225a = AppSettingsDialog.m11128a(getIntent(), this).m11130a(this, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f12225a == null || !this.f12225a.isShowing()) {
            return;
        }
        this.f12225a.dismiss();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null)), 7534);
            return;
        }
        if (i == -2) {
            setResult(0);
            finish();
        } else {
            throw new IllegalStateException("Unknown button type: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }
}
