package com.coollang.tennis.activity;

import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.umeng.message.PushAgent;
import p000.C1896lz;
import p000.C1911mj;
import p000.C1918mq;

/* JADX INFO: loaded from: classes.dex */
public class RecordVideoActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private SurfaceView f6637a;

    /* JADX INFO: renamed from: b */
    private ImageButton f6638b;

    /* JADX INFO: renamed from: c */
    private ImageButton f6639c;

    /* JADX INFO: renamed from: d */
    private TextView f6640d;

    /* JADX INFO: renamed from: e */
    private C1918mq f6641e;

    /* JADX INFO: renamed from: f */
    private C1911mj f6642f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_record_video);
        m7088c();
        PushAgent.getInstance(this).onAppStart();
        this.f6641e = new C1918mq(this, this.f6637a);
        this.f6642f = new C1911mj();
        this.f6638b.setOnClickListener(this);
        this.f6639c.setOnClickListener(this);
        this.f6642f.m10530a(new C1911mj.a() { // from class: com.coollang.tennis.activity.RecordVideoActivity.1
            @Override // p000.C1911mj.a
            /* JADX INFO: renamed from: a */
            public void mo7089a() {
                TextView textView = RecordVideoActivity.this.f6640d;
                C1911mj unused = RecordVideoActivity.this.f6642f;
                textView.setText(C1911mj.m10526a(RecordVideoActivity.this.f6642f.f11495a));
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m7088c() {
        this.f6637a = (SurfaceView) findViewById(R.id.activity_record_video_surfaceview);
        this.f6638b = (ImageButton) findViewById(R.id.activity_record_video_ib_start);
        this.f6639c = (ImageButton) findViewById(R.id.activity_record_video_ib_delete);
        this.f6640d = (TextView) findViewById(R.id.activity_record_video_tv_time);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.activity_record_video_ib_delete /* 2131296324 */:
                finish();
                break;
            case R.id.activity_record_video_ib_start /* 2131296325 */:
                if (!this.f6642f.f11499e) {
                    this.f6642f.f11499e = true;
                    this.f6641e.m10592b();
                    this.f6642f.m10529a();
                    this.f6638b.setImageResource(R.drawable.ic_record_video_stop);
                } else {
                    this.f6642f.m10531b();
                    this.f6641e.m10593c();
                }
                break;
        }
    }
}
