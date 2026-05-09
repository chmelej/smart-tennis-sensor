package com.coollang.tennis.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.coollang.tennis.R;
import p000.C1916mo;
import p000.InterfaceC1915mn;

/* JADX INFO: loaded from: classes.dex */
public class WebVideoPlayActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private static final String f7358a = "WebVideoPlayActivity";

    /* JADX INFO: renamed from: b */
    private SurfaceView f7359b;

    /* JADX INFO: renamed from: c */
    private SeekBar f7360c;

    /* JADX INFO: renamed from: d */
    private TextView f7361d;

    /* JADX INFO: renamed from: e */
    private TextView f7362e;

    /* JADX INFO: renamed from: f */
    private ImageButton f7363f;

    /* JADX INFO: renamed from: g */
    private InterfaceC1915mn f7364g;

    /* JADX INFO: renamed from: h */
    private FrameLayout f7365h;

    /* JADX INFO: renamed from: i */
    private ImageButton f7366i;

    /* JADX INFO: renamed from: j */
    private Handler f7367j = new Handler() { // from class: com.coollang.tennis.activity.WebVideoPlayActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1005 && WebVideoPlayActivity.this.f7365h.getVisibility() == 0) {
                WebVideoPlayActivity.this.m7723f();
            }
        }
    };

    /* JADX INFO: renamed from: k */
    private SeekBar.OnSeekBarChangeListener f7368k = new SeekBar.OnSeekBarChangeListener() { // from class: com.coollang.tennis.activity.WebVideoPlayActivity.3

        /* JADX INFO: renamed from: a */
        int f7373a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f7373a = (i * WebVideoPlayActivity.this.f7364g.mo10565e()) / seekBar.getMax();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            WebVideoPlayActivity.this.f7367j.removeMessages(1005);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            WebVideoPlayActivity.this.f7364g.mo10561a(this.f7373a);
            WebVideoPlayActivity.this.m7724g();
        }
    };

    /* JADX INFO: renamed from: l */
    private View.OnClickListener f7369l = new View.OnClickListener() { // from class: com.coollang.tennis.activity.WebVideoPlayActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.activity_video_play_ib_return) {
                WebVideoPlayActivity.this.m7726h();
                WebVideoPlayActivity.this.finish();
                return;
            }
            if (id != R.id.ib_play_pause) {
                if (id != R.id.main_surface_view) {
                    return;
                }
                if (WebVideoPlayActivity.this.f7365h.getVisibility() == 0) {
                    WebVideoPlayActivity.this.m7723f();
                    return;
                } else {
                    WebVideoPlayActivity.this.m7721e();
                    return;
                }
            }
            WebVideoPlayActivity.this.m7724g();
            if (!WebVideoPlayActivity.this.f7364g.mo10564d()) {
                WebVideoPlayActivity.this.f7364g.mo10560a();
                WebVideoPlayActivity.this.f7363f.setImageResource(R.drawable.ic_video_play_start);
            } else {
                WebVideoPlayActivity.this.f7364g.mo10562b();
                WebVideoPlayActivity.this.f7363f.setImageResource(R.drawable.ic_video_play_stop);
            }
        }
    };

    /* JADX INFO: renamed from: m */
    private View.OnFocusChangeListener f7370m = new View.OnFocusChangeListener() { // from class: com.coollang.tennis.activity.WebVideoPlayActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                view.setBackgroundColor(-7829368);
                Log.v(WebVideoPlayActivity.f7358a + " >focus changed", "has focus");
                return;
            }
            view.setBackgroundColor(0);
            Log.v(WebVideoPlayActivity.f7358a + " >focus changed", "lose focus");
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(0);
        setContentView(R.layout.activity_videoplay);
        m7716c();
        m7719d();
        m7721e();
        m7714b();
    }

    /* JADX INFO: renamed from: b */
    private void m7714b() {
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("videourl") : "http://tennis-10015299.video.myqcloud.com/tennis_example.mp4";
        if (this.f7364g == null) {
            this.f7364g = new C1916mo(this.f7359b, this.f7360c, string, this.f7361d, this.f7362e, 0, this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f7364g == null || !this.f7364g.mo10564d()) {
            return;
        }
        this.f7364g.mo10562b();
        this.f7363f.setImageResource(R.drawable.ic_video_play_stop);
    }

    /* JADX INFO: renamed from: c */
    private void m7716c() {
        this.f7359b = (SurfaceView) findViewById(R.id.main_surface_view);
        this.f7360c = (SeekBar) findViewById(R.id.sb_video_player);
        this.f7361d = (TextView) findViewById(R.id.tv_video_player_time);
        this.f7362e = (TextView) findViewById(R.id.tv_video_player_length);
        this.f7363f = (ImageButton) findViewById(R.id.ib_play_pause);
        this.f7365h = (FrameLayout) findViewById(R.id.video_player_overlay);
        this.f7366i = (ImageButton) findViewById(R.id.activity_video_play_ib_return);
        this.f7363f.requestFocus();
        this.f7363f.setImageResource(R.drawable.ic_video_play_start);
    }

    /* JADX INFO: renamed from: d */
    private void m7719d() {
        this.f7360c.setOnSeekBarChangeListener(this.f7368k);
        this.f7363f.setOnClickListener(this.f7369l);
        this.f7363f.setOnFocusChangeListener(this.f7370m);
        this.f7366i.setOnClickListener(this.f7369l);
        this.f7359b.setOnClickListener(this.f7369l);
        this.f7365h.setOnTouchListener(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.WebVideoPlayActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                WebVideoPlayActivity.this.m7724g();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m7721e() {
        this.f7365h.setVisibility(0);
        m7724g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m7723f() {
        this.f7365h.startAnimation(AnimationUtils.loadAnimation(this, R.anim.video_controller_bottom_hide));
        this.f7365h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7724g() {
        this.f7367j.removeMessages(1005);
        this.f7367j.sendEmptyMessageDelayed(1005, 3000L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m7726h();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7726h() {
        if (this.f7364g != null) {
            this.f7364g.mo10563c();
        }
    }
}
