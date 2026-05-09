package com.coollang.tennis.activity;

import android.view.View;
import android.widget.ImageView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class MyVideo_nsg_Activity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private ImageView f6509a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_my_video_nsg_);
        this.f6509a = (ImageView) findViewById(R.id.back);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6509a.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.back) {
            return;
        }
        finish();
    }
}
