package com.coollang.tennis.activity;

import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;

/* JADX INFO: loaded from: classes.dex */
public class TrainSendInfoActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f7098a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_train_send_info);
        this.f7098a = (NavigateView) findViewById(R.id.navigateView);
        this.f7098a.setTitle(getString(R.string.train_info_title));
        this.f7098a.setRightHideBtn(true);
        this.f7098a.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainSendInfoActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainSendInfoActivity.this.m7733j();
            }
        });
    }
}
