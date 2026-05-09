package com.umeng.update;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.io.File;
import p000.ajd;
import p000.ajg;
import p000.ati;
import p000.atk;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDialogActivity extends Activity {

    /* JADX INFO: renamed from: b */
    ajg f9261b;

    /* JADX INFO: renamed from: a */
    int f9260a = 6;

    /* JADX INFO: renamed from: c */
    boolean f9262c = false;

    /* JADX INFO: renamed from: d */
    File f9263d = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        try {
            requestWindowFeature(1);
            setContentView(atk.m5432a(this).m5435c("umeng_update_dialog"));
            this.f9261b = (ajg) getIntent().getExtras().getSerializable("response");
            String string = getIntent().getExtras().getString("file");
            boolean z2 = getIntent().getExtras().getBoolean("force");
            if (string == null) {
                z = false;
            }
            if (z) {
                this.f9263d = new File(string);
            }
            int iM5433a = atk.m5432a(this).m5433a("umeng_update_content");
            int iM5433a2 = atk.m5432a(this).m5433a("umeng_update_wifi_indicator");
            final int iM5433a3 = atk.m5432a(this).m5433a("umeng_update_id_ok");
            int iM5433a4 = atk.m5432a(this).m5433a("umeng_update_id_cancel");
            final int iM5433a5 = atk.m5432a(this).m5433a("umeng_update_id_ignore");
            int iM5433a6 = atk.m5432a(this).m5433a("umeng_update_id_close");
            int iM5433a7 = atk.m5432a(this).m5433a("umeng_update_id_check");
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.umeng.update.UpdateDialogActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (iM5433a3 == view.getId()) {
                        UpdateDialogActivity.this.f9260a = 5;
                    } else if (iM5433a5 == view.getId() || UpdateDialogActivity.this.f9262c) {
                        UpdateDialogActivity.this.f9260a = 7;
                    }
                    UpdateDialogActivity.this.finish();
                }
            };
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.umeng.update.UpdateDialogActivity.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    UpdateDialogActivity.this.f9262c = z3;
                }
            };
            if (iM5433a2 > 0) {
                findViewById(iM5433a2).setVisibility(ati.m5416d(this) ? 8 : 0);
            }
            if (z2) {
                findViewById(iM5433a7).setVisibility(8);
            }
            findViewById(iM5433a3).setOnClickListener(onClickListener);
            findViewById(iM5433a4).setOnClickListener(onClickListener);
            findViewById(iM5433a5).setOnClickListener(onClickListener);
            findViewById(iM5433a6).setOnClickListener(onClickListener);
            ((CheckBox) findViewById(iM5433a7)).setOnCheckedChangeListener(onCheckedChangeListener);
            String strM1515a = this.f9261b.m1515a(this, z);
            TextView textView = (TextView) findViewById(iM5433a);
            textView.requestFocus();
            textView.setText(strM1515a);
        } catch (Exception e) {
            Log.d("UpdateDialogActivity", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ajd.m1479a(this.f9260a, this, this.f9261b, this.f9263d);
    }
}
