package com.coollang.tennis.activity;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.umeng.message.PushAgent;

/* JADX INFO: loaded from: classes.dex */
public class AdvoiceActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6243a;

    /* JADX INFO: renamed from: b */
    private EditText f6244b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_advoice);
        PushAgent.getInstance(this).onAppStart();
        this.f6243a = (NavigateView) findViewById(R.id.navigateView);
        this.f6243a.setTitle(getResources().getString(R.string.activity_setting_text9));
        this.f6243a.setRightButtonBackground(R.color.tranlete);
        this.f6243a.setRightButtonText(getResources().getString(R.string.activity_setting_text9_t));
        this.f6243a.setRightButtonTextColor(R.color.white);
        this.f6243a.setRightButtonTextSize(16);
        this.f6244b = (EditText) findViewById(R.id.advoice);
        this.f6244b.setFocusable(true);
        this.f6244b.setFocusableInTouchMode(true);
        this.f6244b.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
        this.f6243a.setRightButtonClicklistner(new View.OnClickListener() { // from class: com.coollang.tennis.activity.AdvoiceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdvoiceActivity.this.finish();
            }
        });
    }
}
