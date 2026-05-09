package com.coollang.tennis.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import java.io.UnsupportedEncodingException;
import p000.C1873lc;
import p000.C1926my;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingInputActivity extends BaseActivity {

    /* JADX INFO: renamed from: b */
    private NavigateView f6692b;

    /* JADX INFO: renamed from: c */
    private EditText f6693c;

    /* JADX INFO: renamed from: d */
    private LinearLayout f6694d;

    /* JADX INFO: renamed from: e */
    private EditText f6695e;

    /* JADX INFO: renamed from: f */
    private TextView f6696f;

    /* JADX INFO: renamed from: g */
    private int f6697g;

    /* JADX INFO: renamed from: h */
    private String f6698h;

    /* JADX INFO: renamed from: i */
    private C1926my f6699i;

    /* JADX INFO: renamed from: a */
    private final int f6691a = 15;

    /* JADX INFO: renamed from: j */
    private TextWatcher f6700j = new TextWatcher() { // from class: com.coollang.tennis.activity.SettingInputActivity.1

        /* JADX INFO: renamed from: b */
        private CharSequence f6703b;

        /* JADX INFO: renamed from: c */
        private int f6704c;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f6703b = charSequence;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SettingInputActivity.this.f6696f.setText(String.valueOf(15 - (SettingInputActivity.this.m7127a(charSequence.toString()) / 2)));
            this.f6704c = i + i3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SettingInputActivity.this.m7127a(this.f6703b.toString()) > 30) {
                editable.delete(this.f6704c - 1, this.f6704c);
                int i = this.f6704c;
                SettingInputActivity.this.f6695e.setText(editable);
                SettingInputActivity.this.f6695e.setSelection(i);
            }
        }
    };

    /* JADX INFO: renamed from: k */
    private RippleView.InterfaceC1365a f6701k = new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SettingInputActivity.2
        @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
        /* JADX INFO: renamed from: a */
        public void mo7110a(RippleView rippleView) {
            SettingInputActivity.this.m7734k();
            if (SettingInputActivity.this.f6697g == 1200) {
                if (SettingInputActivity.this.f6693c.getText().toString().trim().isEmpty()) {
                    SettingInputActivity.this.m7139g();
                    return;
                }
                akd.m1706a().m1722c(new C1873lc(SettingInputActivity.this.f6693c.getText().toString().trim(), 1, 38));
            } else if (SettingInputActivity.this.f6697g == 1201) {
                akd.m1706a().m1722c(new C1873lc(SettingInputActivity.this.f6695e.getText().toString().trim(), 1, 39));
            }
            SettingInputActivity.this.m7733j();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_input);
        m7132c();
        m7134d();
        m7135e();
        m7138f();
    }

    /* JADX INFO: renamed from: c */
    private void m7132c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6697g = extras.getInt("type");
            this.f6698h = extras.getString("content");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7134d() {
        this.f6692b = (NavigateView) findViewById(R.id.navigateView);
        this.f6693c = (EditText) findViewById(R.id.edt_nick_name_input);
        this.f6694d = (LinearLayout) findViewById(R.id.ll_input_sign);
        this.f6695e = (EditText) findViewById(R.id.edt_sign_input);
        this.f6696f = (TextView) findViewById(R.id.tv_left_count);
    }

    /* JADX INFO: renamed from: e */
    private void m7135e() {
        if (this.f6697g == 1200) {
            this.f6692b.setTitle(R.string.person_nick_name);
            this.f6693c.setVisibility(0);
            this.f6693c.setText(this.f6698h);
            this.f6693c.setSelection(this.f6698h.length());
            m7129a(this.f6693c);
            this.f6692b.setRightButtonText(getString(R.string.right_text));
            this.f6692b.setRightButtonClicklistner(this.f6701k);
            this.f6692b.setRightButtonBackground(android.R.color.transparent);
            return;
        }
        if (this.f6697g == 1201) {
            this.f6692b.setTitle(R.string.person_signature);
            this.f6694d.setVisibility(0);
            this.f6695e.setText(this.f6698h);
            this.f6695e.setSelection(this.f6698h.length());
            m7129a(this.f6695e);
            this.f6692b.setRightButtonText(getString(R.string.right_text));
            this.f6692b.setRightButtonClicklistner(this.f6701k);
            this.f6692b.setRightButtonBackground(android.R.color.transparent);
            return;
        }
        if (this.f6697g == 1202) {
            this.f6692b.setTitle(R.string.shoes);
            this.f6693c.setVisibility(0);
            this.f6693c.setText(this.f6698h);
            this.f6693c.setSelection(this.f6698h.length());
            m7129a(this.f6693c);
            this.f6692b.setRightHideBtn(true);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m7138f() {
        this.f6693c.addTextChangedListener(this.f6700j);
        this.f6695e.addTextChangedListener(this.f6700j);
        if (this.f6697g == 1201) {
            int iM7127a = 15 - (m7127a(this.f6695e.getText().toString()) / 2);
            if (iM7127a < 0) {
                this.f6695e.setText(this.f6698h);
            } else {
                this.f6696f.setText(String.valueOf(iM7127a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m7127a(String str) {
        try {
            return str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7129a(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6697g == 1202) {
            akd.m1706a().m1722c(new C1873lc(this.f6693c.getText().toString().trim(), 1, 48));
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7139g() {
        this.f6699i = new C1926my(this);
        this.f6699i.m10697a(8);
        this.f6699i.m10703b(getString(R.string.nick_name_empty));
        this.f6699i.m10696a();
        this.f6699i.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.SettingInputActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingInputActivity.this.f6699i.m10706d();
            }
        });
        this.f6699i.m10701b();
    }
}
