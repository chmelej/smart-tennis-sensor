package com.coollang.tennis.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.Custom.BreakPointProgressBar;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import java.text.DecimalFormat;
import p000.C1810iu;
import p000.C2150tz;
import p000.C2155ud;
import p000.C2161uj;
import p000.C2162uk;
import p000.C2164um;
import p000.C2169ur;
import p000.InterfaceC2163ul;
import p000.InterfaceC2172uu;

/* JADX INFO: loaded from: classes.dex */
public class VideoRecorderActivity extends BaseActivity implements View.OnClickListener, InterfaceC2163ul, InterfaceC2172uu {

    /* JADX INFO: renamed from: o */
    private static final String f7220o = "VideoRecorderActivity";

    /* JADX INFO: renamed from: a */
    private GLSurfaceView f7221a;

    /* JADX INFO: renamed from: b */
    private C2164um f7222b;

    /* JADX INFO: renamed from: c */
    private ImageView f7223c;

    /* JADX INFO: renamed from: d */
    private ImageView f7224d;

    /* JADX INFO: renamed from: e */
    private ImageView f7225e;

    /* JADX INFO: renamed from: f */
    private TextView f7226f;

    /* JADX INFO: renamed from: g */
    private TextView f7227g;

    /* JADX INFO: renamed from: h */
    private ImageView f7228h;

    /* JADX INFO: renamed from: i */
    private ImageView f7229i;

    /* JADX INFO: renamed from: j */
    private TextView f7230j;

    /* JADX INFO: renamed from: k */
    private TextView f7231k;

    /* JADX INFO: renamed from: m */
    private BreakPointProgressBar f7233m;

    /* JADX INFO: renamed from: q */
    private boolean f7236q;

    /* JADX INFO: renamed from: l */
    private int f7232l = 40;

    /* JADX INFO: renamed from: n */
    private DecimalFormat f7234n = new DecimalFormat("00.0");

    /* JADX INFO: renamed from: p */
    private BreakPointProgressBar.InterfaceC0988b f7235p = new BreakPointProgressBar.InterfaceC0988b() { // from class: com.coollang.tennis.activity.VideoRecorderActivity.1
        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: a */
        public void mo6853a() {
            if (VideoRecorderActivity.this.f7229i.getVisibility() != 0) {
                VideoRecorderActivity.this.f7229i.setVisibility(0);
            }
        }

        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: a */
        public void mo6854a(float f) {
            if (f < 5.0f) {
                VideoRecorderActivity.this.f7229i.setVisibility(8);
                VideoRecorderActivity.this.f7231k.setVisibility(0);
                VideoRecorderActivity.this.f7228h.setVisibility(8);
            } else {
                VideoRecorderActivity.this.f7231k.setVisibility(8);
            }
            VideoRecorderActivity.this.f7226f.setText("00." + VideoRecorderActivity.this.f7234n.format(f) + "");
        }

        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: b */
        public void mo6855b() {
            VideoRecorderActivity.this.m7635a(false);
            VideoRecorderActivity.this.f7231k.setVisibility(8);
        }
    };

    @Override // p000.InterfaceC2172uu
    /* JADX INFO: renamed from: a */
    public void mo7642a(float f) {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: a */
    public void mo7643a(int i) {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: a */
    public void mo7644a(long j, long j2, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    @Override // p000.InterfaceC2172uu
    /* JADX INFO: renamed from: b */
    public void mo7646b(int i) {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: c */
    public void mo7647c() {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: e */
    public void mo7649e() {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: f */
    public void mo7650f() {
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: g */
    public void mo7651g() {
    }

    @Override // p000.InterfaceC2172uu
    /* JADX INFO: renamed from: i */
    public void mo7653i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        this.f7222b.m11797a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f7222b.m11803b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f7222b.m11804c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_video_recorder);
        m7652h();
        this.f7221a = (GLSurfaceView) findViewById(R.id.glSurfaceView);
        this.f7223c = (ImageView) findViewById(R.id.iv_recorder_play);
        this.f7224d = (ImageView) findViewById(R.id.iv_recorder_pause);
        this.f7225e = (ImageView) findViewById(R.id.iv_switch_camera);
        this.f7226f = (TextView) findViewById(R.id.tv_recorder_time);
        this.f7227g = (TextView) findViewById(R.id.tv_import);
        this.f7228h = (ImageView) findViewById(R.id.iv_delete);
        this.f7229i = (ImageView) findViewById(R.id.iv_completed);
        this.f7230j = (TextView) findViewById(R.id.tv_cancel);
        this.f7231k = (TextView) findViewById(R.id.text_msg);
        this.f7233m = (BreakPointProgressBar) findViewById(R.id.pb_recorder);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.red_cricle);
        drawable.setBounds(0, 0, 20, 20);
        this.f7226f.setCompoundDrawables(drawable, null, null, null);
        this.f7226f.setCompoundDrawablePadding(10);
        this.f7223c.setOnClickListener(this);
        this.f7224d.setOnClickListener(this);
        this.f7225e.setOnClickListener(this);
        this.f7229i.setOnClickListener(this);
        this.f7227g.setOnClickListener(this);
        this.f7228h.setOnClickListener(this);
        this.f7230j.setOnClickListener(this);
        this.f7233m.setOnVideoRecorderProgressListener(this.f7235p);
        C2155ud c2155ud = new C2155ud();
        c2155ud.m11759a(C2155ud.a.CAMERA_FACING_BACK);
        c2155ud.m11761a(C2155ud.c.RATIO_4_3);
        c2155ud.m11760a(C2155ud.b.PREVIEW_SIZE_LEVEL_480P);
        C2161uj c2161uj = new C2161uj();
        C2169ur c2169ur = new C2169ur(this);
        c2169ur.m11826a(C2169ur.b.VIDEO_ENCODING_SIZE_LEVEL_480P_1);
        c2169ur.m11829b(1024000);
        c2169ur.m11823a(25);
        c2169ur.m11827a(true);
        C2150tz c2150tz = new C2150tz();
        c2150tz.m11742a(true);
        C2162uk c2162uk = new C2162uk();
        c2162uk.m11789a(20000L);
        c2162uk.m11791a(C1810iu.f10367a);
        c2162uk.m11794b(C1810iu.f10368b);
        this.f7233m.setTotalTime(20000L);
        this.f7233m.setMinDuration(5000L);
        this.f7222b = new C2164um();
        this.f7222b.m11799a((InterfaceC2163ul) this);
        this.f7222b.m11798a(this.f7221a, c2155ud, c2161uj, c2169ur, c2150tz, null, c2162uk);
    }

    @Override // p000.InterfaceC2163ul
    /* JADX INFO: renamed from: d */
    public void mo7648d() {
        runOnUiThread(new Runnable() { // from class: com.coollang.tennis.activity.VideoRecorderActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(VideoRecorderActivity.this, "录制时间太短", 0).show();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_completed /* 2131296719 */:
                this.f7222b.m11800a((InterfaceC2172uu) this);
                break;
            case R.id.iv_delete /* 2131296720 */:
                m7641l();
                break;
            case R.id.iv_recorder_pause /* 2131296732 */:
                this.f7228h.setVisibility(0);
                if (this.f7236q) {
                    this.f7222b.m11806e();
                    this.f7236q = false;
                    this.f7233m.m6849b();
                    this.f7231k.setVisibility(8);
                }
                if (this.f7228h.getVisibility() != 0) {
                    this.f7228h.setVisibility(0);
                }
                this.f7226f.setVisibility(0);
                m7635a(false);
                this.f7233m.m6850c();
                break;
            case R.id.iv_recorder_play /* 2131296733 */:
                if (this.f7227g.getVisibility() == 0) {
                    this.f7227g.setVisibility(8);
                }
                if (!this.f7236q && this.f7222b.m11805d()) {
                    this.f7236q = true;
                    this.f7233m.m6848a();
                }
                m7635a(true);
                if (this.f7228h.getVisibility() == 0) {
                    this.f7228h.setVisibility(8);
                }
                break;
            case R.id.iv_switch_camera /* 2131296736 */:
                if (!this.f7236q) {
                    this.f7222b.m11807f();
                } else {
                    Toast.makeText(this, "视频录制过程中不可以切换镜头", 0).show();
                }
                break;
            case R.id.tv_cancel /* 2131297204 */:
                finish();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7635a(boolean z) {
        if (z) {
            this.f7224d.setVisibility(0);
            this.f7223c.setVisibility(8);
        } else {
            this.f7224d.setVisibility(8);
            this.f7223c.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m7652h() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    @Override // p000.InterfaceC2172uu
    /* JADX INFO: renamed from: a */
    public void mo7645a(String str) {
        Intent intent = new Intent();
        intent.putExtra("path", str);
        Log.e(f7220o, "path: " + str);
        intent.setClass(this, PostVideoActivity.class);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: renamed from: l */
    private void m7641l() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.radio_bg);
        builder.setTitle("删除视频");
        builder.setMessage("确定要删除?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.coollang.tennis.activity.VideoRecorderActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                VideoRecorderActivity.this.f7233m.m6851d();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.coollang.tennis.activity.VideoRecorderActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}
