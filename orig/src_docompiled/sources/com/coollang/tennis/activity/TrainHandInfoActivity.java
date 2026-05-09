package com.coollang.tennis.activity;

import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;

/* JADX INFO: loaded from: classes.dex */
public class TrainHandInfoActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6997a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_train_hand_info);
        m7392c();
        m7393d();
    }

    /* JADX INFO: renamed from: c */
    private void m7392c() {
        this.f6997a = (NavigateView) findViewById(R.id.navigateView);
    }

    /* JADX INFO: renamed from: d */
    private void m7393d() {
        this.f6997a.setTitle(getString(R.string.train_info_title));
        this.f6997a.setRightHideBtn(true);
        this.f6997a.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainHandInfoActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainHandInfoActivity.this.m7733j();
            }
        });
    }
}
