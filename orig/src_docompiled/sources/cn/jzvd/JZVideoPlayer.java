package cn.jzvd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import p000.AbstractC1799ij;
import p000.C1803in;
import p000.C1804io;
import p000.InterfaceC1802im;
import p000.TextureViewSurfaceTextureListenerC1800ik;

/* JADX INFO: loaded from: classes.dex */
public abstract class JZVideoPlayer extends FrameLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a */
    public static boolean f5389a = true;

    /* JADX INFO: renamed from: b */
    public static boolean f5390b = true;

    /* JADX INFO: renamed from: c */
    public static int f5391c = 4;

    /* JADX INFO: renamed from: d */
    public static int f5392d = 1;

    /* JADX INFO: renamed from: e */
    public static boolean f5393e = true;

    /* JADX INFO: renamed from: f */
    public static boolean f5394f = false;

    /* JADX INFO: renamed from: g */
    public static int f5395g;

    /* JADX INFO: renamed from: h */
    public static long f5396h;

    /* JADX INFO: renamed from: i */
    public static long f5397i;

    /* JADX INFO: renamed from: k */
    public static AudioManager.OnAudioFocusChangeListener f5398k = new AudioManager.OnAudioFocusChangeListener() { // from class: cn.jzvd.JZVideoPlayer.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i != 1) {
                switch (i) {
                    case -2:
                        try {
                            if (C1804io.m9816c().f5422n == 3) {
                                C1804io.m9816c().f5426r.performClick();
                            }
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        }
                        Log.d("JiaoZiVideoPlayer", "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]");
                        break;
                    case -1:
                        JZVideoPlayer.m5813a();
                        Log.d("JiaoZiVideoPlayer", "AUDIOFOCUS_LOSS [" + hashCode() + "]");
                        break;
                }
            }
        }
    };

    /* JADX INFO: renamed from: l */
    protected static InterfaceC1802im f5399l;

    /* JADX INFO: renamed from: m */
    protected static Timer f5400m;

    /* JADX INFO: renamed from: A */
    public int f5401A;

    /* JADX INFO: renamed from: B */
    public Object[] f5402B;

    /* JADX INFO: renamed from: C */
    public int f5403C;

    /* JADX INFO: renamed from: D */
    public int f5404D;

    /* JADX INFO: renamed from: E */
    public int f5405E;

    /* JADX INFO: renamed from: F */
    protected int f5406F;

    /* JADX INFO: renamed from: G */
    protected int f5407G;

    /* JADX INFO: renamed from: H */
    protected AudioManager f5408H;

    /* JADX INFO: renamed from: I */
    protected C0802a f5409I;

    /* JADX INFO: renamed from: J */
    protected boolean f5410J;

    /* JADX INFO: renamed from: K */
    protected float f5411K;

    /* JADX INFO: renamed from: L */
    protected float f5412L;

    /* JADX INFO: renamed from: M */
    protected boolean f5413M;

    /* JADX INFO: renamed from: N */
    protected boolean f5414N;

    /* JADX INFO: renamed from: O */
    protected boolean f5415O;

    /* JADX INFO: renamed from: P */
    protected long f5416P;

    /* JADX INFO: renamed from: Q */
    protected int f5417Q;

    /* JADX INFO: renamed from: R */
    protected float f5418R;

    /* JADX INFO: renamed from: S */
    protected long f5419S;

    /* JADX INFO: renamed from: T */
    boolean f5420T;

    /* JADX INFO: renamed from: j */
    Context f5421j;

    /* JADX INFO: renamed from: n */
    public int f5422n;

    /* JADX INFO: renamed from: o */
    public int f5423o;

    /* JADX INFO: renamed from: p */
    public Object[] f5424p;

    /* JADX INFO: renamed from: q */
    public long f5425q;

    /* JADX INFO: renamed from: r */
    public ImageView f5426r;

    /* JADX INFO: renamed from: s */
    public SeekBar f5427s;

    /* JADX INFO: renamed from: t */
    public ImageView f5428t;

    /* JADX INFO: renamed from: u */
    public TextView f5429u;

    /* JADX INFO: renamed from: v */
    public TextView f5430v;

    /* JADX INFO: renamed from: w */
    public ViewGroup f5431w;

    /* JADX INFO: renamed from: x */
    public ViewGroup f5432x;

    /* JADX INFO: renamed from: y */
    public ViewGroup f5433y;

    /* JADX INFO: renamed from: z */
    public int f5434z;

    /* JADX INFO: renamed from: D */
    public void m5822D() {
    }

    /* JADX INFO: renamed from: E */
    public void mo5823E() {
    }

    /* JADX INFO: renamed from: F */
    public void mo5824F() {
    }

    /* JADX INFO: renamed from: G */
    public void mo5825G() {
    }

    /* JADX INFO: renamed from: H */
    public void mo5826H() {
    }

    /* JADX INFO: renamed from: a */
    public void mo5827a(float f, int i) {
    }

    /* JADX INFO: renamed from: a */
    public void mo5828a(float f, String str, long j, String str2, long j2) {
    }

    /* JADX INFO: renamed from: b */
    public void mo5832b(int i) {
    }

    public abstract int getLayoutId();

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public JZVideoPlayer(Context context) {
        super(context);
        this.f5422n = -1;
        this.f5423o = -1;
        this.f5424p = null;
        this.f5425q = 0L;
        this.f5434z = 0;
        this.f5401A = 0;
        this.f5403C = 0;
        this.f5404D = -1;
        this.f5405E = 0;
        this.f5420T = false;
        mo5834c(context);
    }

    public JZVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5422n = -1;
        this.f5423o = -1;
        this.f5424p = null;
        this.f5425q = 0L;
        this.f5434z = 0;
        this.f5401A = 0;
        this.f5403C = 0;
        this.f5404D = -1;
        this.f5405E = 0;
        this.f5420T = false;
        mo5834c(context);
    }

    /* JADX INFO: renamed from: a */
    public static void m5813a() {
        if (System.currentTimeMillis() - f5396h > 300) {
            Log.d("JiaoZiVideoPlayer", "releaseAllVideos");
            C1804io.m9817d();
            TextureViewSurfaceTextureListenerC1800ik.m9788a().f10340e = -1;
            TextureViewSurfaceTextureListenerC1800ik.m9788a().m9797g();
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m5816b() {
        Log.i("JiaoZiVideoPlayer", "backPress");
        if (System.currentTimeMillis() - f5396h < 300) {
            return false;
        }
        if (C1804io.m9814b() != null) {
            f5396h = System.currentTimeMillis();
            if (C1803in.m9807a(C1804io.m9812a().f5402B, TextureViewSurfaceTextureListenerC1800ik.m9792b())) {
                JZVideoPlayer jZVideoPlayerM9814b = C1804io.m9814b();
                jZVideoPlayerM9814b.m5829a(jZVideoPlayerM9814b.f5423o == 2 ? 8 : 10);
                C1804io.m9812a().m5821C();
            } else {
                m5817c();
            }
            return true;
        }
        if (C1804io.m9812a() == null || !(C1804io.m9812a().f5423o == 2 || C1804io.m9812a().f5423o == 3)) {
            return false;
        }
        f5396h = System.currentTimeMillis();
        m5817c();
        return true;
    }

    /* JADX INFO: renamed from: c */
    public static void m5817c() {
        C1804io.m9812a().m5850t();
        TextureViewSurfaceTextureListenerC1800ik.m9788a().m9797g();
        C1804io.m9817d();
    }

    @SuppressLint({"RestrictedApi"})
    /* JADX INFO: renamed from: a */
    public static void m5814a(Context context) {
        ActionBar actionBarM3186a;
        if (f5389a && C1803in.m9810c(context) != null && (actionBarM3186a = C1803in.m9810c(context).m3186a()) != null) {
            actionBarM3186a.mo3141d(false);
            actionBarM3186a.mo3136b();
        }
        if (f5390b) {
            C1803in.m9811d(context).clearFlags(1024);
        }
    }

    @SuppressLint({"RestrictedApi"})
    /* JADX INFO: renamed from: b */
    public static void m5815b(Context context) {
        ActionBar actionBarM3186a;
        if (f5389a && C1803in.m9810c(context) != null && (actionBarM3186a = C1803in.m9810c(context).m3186a()) != null) {
            actionBarM3186a.mo3141d(false);
            actionBarM3186a.mo3138c();
        }
        if (f5390b) {
            C1803in.m9811d(context).setFlags(1024, 1024);
        }
    }

    public static void setJzUserAction(InterfaceC1802im interfaceC1802im) {
        f5399l = interfaceC1802im;
    }

    /* JADX INFO: renamed from: d */
    public static void m5818d() {
        if (C1804io.m9816c() != null) {
            JZVideoPlayer jZVideoPlayerM9816c = C1804io.m9816c();
            if (jZVideoPlayerM9816c.f5422n == 6 || jZVideoPlayerM9816c.f5422n == 0 || jZVideoPlayerM9816c.f5422n == 7) {
                return;
            }
            jZVideoPlayerM9816c.mo5841k();
            TextureViewSurfaceTextureListenerC1800ik.m9795e();
        }
    }

    public static void setTextureViewRotation(int i) {
        if (TextureViewSurfaceTextureListenerC1800ik.f10336a != null) {
            TextureViewSurfaceTextureListenerC1800ik.f10336a.setRotation(i);
        }
    }

    public static void setVideoImageDisplayType(int i) {
        f5395g = i;
        if (TextureViewSurfaceTextureListenerC1800ik.f10336a != null) {
            TextureViewSurfaceTextureListenerC1800ik.f10336a.requestLayout();
        }
    }

    public Object getCurrentUrl() {
        return C1803in.m9802a(this.f5402B, this.f5403C);
    }

    /* JADX INFO: renamed from: c */
    public void mo5834c(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f5421j = context;
        this.f5426r = (ImageView) findViewById(R.id.start);
        this.f5428t = (ImageView) findViewById(R.id.fullscreen);
        this.f5427s = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.f5429u = (TextView) findViewById(R.id.current);
        this.f5430v = (TextView) findViewById(R.id.total);
        this.f5433y = (ViewGroup) findViewById(R.id.layout_bottom);
        this.f5431w = (ViewGroup) findViewById(R.id.surface_container);
        this.f5432x = (ViewGroup) findViewById(R.id.layout_top);
        this.f5426r.setOnClickListener(this);
        this.f5428t.setOnClickListener(this);
        this.f5427s.setOnSeekBarChangeListener(this);
        this.f5433y.setOnClickListener(this);
        this.f5431w.setOnClickListener(this);
        this.f5431w.setOnTouchListener(this);
        this.f5406F = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f5407G = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f5408H = (AudioManager) getContext().getSystemService("audio");
        try {
            if (m5819A()) {
                f5392d = ((AppCompatActivity) context).getRequestedOrientation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUp(String str, int i, Object... objArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("URL_KEY_DEFAULT", str);
        setUp(new Object[]{linkedHashMap}, 0, i, objArr);
    }

    public void setUp(Object[] objArr, int i, int i2, Object... objArr2) {
        long jM9793c;
        if (this.f5402B == null || C1803in.m9802a(objArr, this.f5403C) == null || !C1803in.m9802a(this.f5402B, this.f5403C).equals(C1803in.m9802a(objArr, this.f5403C))) {
            if (m5820B() && C1803in.m9807a(objArr, TextureViewSurfaceTextureListenerC1800ik.m9792b())) {
                try {
                    jM9793c = TextureViewSurfaceTextureListenerC1800ik.m9793c();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    jM9793c = 0;
                }
                if (jM9793c != 0) {
                    C1803in.m9805a(getContext(), TextureViewSurfaceTextureListenerC1800ik.m9792b(), jM9793c);
                }
                TextureViewSurfaceTextureListenerC1800ik.m9788a().m9797g();
            } else if (m5820B() && !C1803in.m9807a(objArr, TextureViewSurfaceTextureListenerC1800ik.m9792b())) {
                m5856z();
            } else if (!m5820B() && C1803in.m9807a(objArr, TextureViewSurfaceTextureListenerC1800ik.m9792b())) {
                if (C1804io.m9816c() != null && C1804io.m9816c().f5423o == 3) {
                    this.f5420T = true;
                }
            } else if (!m5820B()) {
                C1803in.m9807a(objArr, TextureViewSurfaceTextureListenerC1800ik.m9792b());
            }
            this.f5402B = objArr;
            this.f5403C = i;
            this.f5423o = i2;
            this.f5424p = objArr2;
            mo5837g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.start) {
            Log.i("JiaoZiVideoPlayer", "onClick start [" + hashCode() + "] ");
            if (this.f5402B == null || C1803in.m9802a(this.f5402B, this.f5403C) == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            if (this.f5422n == 0) {
                if (!C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("file") && !C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("/") && !C1803in.m9806a(getContext()) && !f5394f) {
                    mo5823E();
                    return;
                } else {
                    m5835e();
                    m5829a(0);
                    return;
                }
            }
            if (this.f5422n == 3) {
                m5829a(3);
                Log.d("JiaoZiVideoPlayer", "pauseVideo [" + hashCode() + "] ");
                TextureViewSurfaceTextureListenerC1800ik.m9795e();
                mo5841k();
                return;
            }
            if (this.f5422n == 5) {
                m5829a(4);
                TextureViewSurfaceTextureListenerC1800ik.m9796f();
                mo5840j();
                return;
            } else {
                if (this.f5422n == 6) {
                    m5829a(2);
                    m5835e();
                    return;
                }
                return;
            }
        }
        if (id == R.id.fullscreen) {
            Log.i("JiaoZiVideoPlayer", "onClick fullscreen [" + hashCode() + "] ");
            if (this.f5422n == 6) {
                return;
            }
            if (this.f5423o == 2) {
                m5816b();
                return;
            }
            Log.d("JiaoZiVideoPlayer", "toFullscreenActivity [" + hashCode() + "] ");
            m5829a(7);
            m5855y();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == R.id.surface_container) {
            switch (motionEvent.getAction()) {
                case 0:
                    Log.i("JiaoZiVideoPlayer", "onTouch surfaceContainer actionDown [" + hashCode() + "] ");
                    this.f5410J = true;
                    this.f5411K = x;
                    this.f5412L = y;
                    this.f5413M = false;
                    this.f5414N = false;
                    this.f5415O = false;
                    break;
                case 1:
                    Log.i("JiaoZiVideoPlayer", "onTouch surfaceContainer actionUp [" + hashCode() + "] ");
                    this.f5410J = false;
                    mo5824F();
                    mo5825G();
                    mo5826H();
                    if (this.f5414N) {
                        m5829a(12);
                        TextureViewSurfaceTextureListenerC1800ik.m9789a(this.f5419S);
                        long duration = getDuration();
                        long j = this.f5419S * 100;
                        if (duration == 0) {
                            duration = 1;
                        }
                        this.f5427s.setProgress((int) (j / duration));
                    }
                    if (this.f5413M) {
                        m5829a(11);
                    }
                    m5852v();
                    break;
                case 2:
                    Log.i("JiaoZiVideoPlayer", "onTouch surfaceContainer actionMove [" + hashCode() + "] ");
                    float f = x - this.f5411K;
                    float f2 = y - this.f5412L;
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    if (this.f5423o == 2 && !this.f5414N && !this.f5413M && !this.f5415O && (fAbs > 80.0f || fAbs2 > 80.0f)) {
                        m5853w();
                        if (fAbs >= 80.0f) {
                            if (this.f5422n != 7) {
                                this.f5414N = true;
                                this.f5416P = getCurrentPositionWhenPlaying();
                            }
                        } else if (this.f5411K < this.f5406F * 0.5f) {
                            this.f5415O = true;
                            WindowManager.LayoutParams attributes = C1803in.m9811d(getContext()).getAttributes();
                            if (attributes.screenBrightness < 0.0f) {
                                try {
                                    this.f5418R = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                    Log.i("JiaoZiVideoPlayer", "current system brightness: " + this.f5418R);
                                } catch (Settings.SettingNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                this.f5418R = attributes.screenBrightness * 255.0f;
                                Log.i("JiaoZiVideoPlayer", "current activity brightness: " + this.f5418R);
                            }
                        } else {
                            this.f5413M = true;
                            this.f5417Q = this.f5408H.getStreamVolume(3);
                        }
                    }
                    if (this.f5414N) {
                        long duration2 = getDuration();
                        this.f5419S = (int) (this.f5416P + ((duration2 * f) / this.f5406F));
                        if (this.f5419S > duration2) {
                            this.f5419S = duration2;
                        }
                        mo5828a(f, C1803in.m9803a(this.f5419S), this.f5419S, C1803in.m9803a(duration2), duration2);
                    }
                    if (this.f5413M) {
                        f2 = -f2;
                        this.f5408H.setStreamVolume(3, this.f5417Q + ((int) (((this.f5408H.getStreamMaxVolume(3) * f2) * 3.0f) / this.f5407G)), 0);
                        mo5827a(-f2, (int) (((this.f5417Q * 100) / r1) + (((f2 * 3.0f) * 100.0f) / this.f5407G)));
                    }
                    if (this.f5415O) {
                        float f3 = -f2;
                        WindowManager.LayoutParams attributes2 = C1803in.m9811d(getContext()).getAttributes();
                        float f4 = (int) (((f3 * 255.0f) * 3.0f) / this.f5407G);
                        if ((this.f5418R + f4) / 255.0f >= 1.0f) {
                            attributes2.screenBrightness = 1.0f;
                        } else if ((this.f5418R + f4) / 255.0f <= 0.0f) {
                            attributes2.screenBrightness = 0.01f;
                        } else {
                            attributes2.screenBrightness = (this.f5418R + f4) / 255.0f;
                        }
                        C1803in.m9811d(getContext()).setAttributes(attributes2);
                        mo5832b((int) (((this.f5418R * 100.0f) / 255.0f) + (((f3 * 3.0f) * 100.0f) / this.f5407G)));
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m5835e() {
        C1804io.m9817d();
        Log.d("JiaoZiVideoPlayer", "startVideo [" + hashCode() + "] ");
        m5846p();
        m5847q();
        ((AudioManager) getContext().getSystemService("audio")).requestAudioFocus(f5398k, 3, 2);
        C1803in.m9808b(getContext()).getWindow().addFlags(128);
        TextureViewSurfaceTextureListenerC1800ik.m9791a(this.f5402B);
        TextureViewSurfaceTextureListenerC1800ik.m9790a(C1803in.m9802a(this.f5402B, this.f5403C));
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10340e = this.f5404D;
        mo5838h();
        C1804io.m9813a(this);
    }

    /* JADX INFO: renamed from: f */
    public void m5836f() {
        Log.i("JiaoZiVideoPlayer", "onPrepared  [" + hashCode() + "] ");
        m5839i();
        mo5840j();
    }

    public void setState(int i) {
        setState(i, 0, 0);
    }

    public void setState(int i, int i2, int i3) {
        switch (i) {
            case 0:
                mo5837g();
                break;
            case 1:
                mo5838h();
                break;
            case 2:
                mo5831a(i2, i3);
                break;
            case 3:
                mo5840j();
                break;
            case 5:
                mo5841k();
                break;
            case 6:
                mo5843m();
                break;
            case 7:
                mo5842l();
                break;
        }
    }

    /* JADX INFO: renamed from: g */
    public void mo5837g() {
        Log.i("JiaoZiVideoPlayer", "onStateNormal  [" + hashCode() + "] ");
        this.f5422n = 0;
        m5853w();
    }

    /* JADX INFO: renamed from: h */
    public void mo5838h() {
        Log.i("JiaoZiVideoPlayer", "onStatePreparing  [" + hashCode() + "] ");
        this.f5422n = 1;
        mo5854x();
    }

    /* JADX INFO: renamed from: a */
    public void mo5831a(int i, long j) {
        this.f5422n = 2;
        this.f5403C = i;
        this.f5425q = j;
        TextureViewSurfaceTextureListenerC1800ik.m9791a(this.f5402B);
        TextureViewSurfaceTextureListenerC1800ik.m9790a(C1803in.m9802a(this.f5402B, this.f5403C));
        TextureViewSurfaceTextureListenerC1800ik.m9788a().m9798h();
    }

    /* JADX INFO: renamed from: i */
    public void m5839i() {
        if (this.f5425q != 0) {
            TextureViewSurfaceTextureListenerC1800ik.m9789a(this.f5425q);
            this.f5425q = 0L;
        } else {
            long jM9800a = C1803in.m9800a(getContext(), C1803in.m9802a(this.f5402B, this.f5403C));
            if (jM9800a != 0) {
                TextureViewSurfaceTextureListenerC1800ik.m9789a(jM9800a);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void mo5840j() {
        Log.i("JiaoZiVideoPlayer", "onStatePlaying  [" + hashCode() + "] ");
        this.f5422n = 3;
        m5852v();
    }

    /* JADX INFO: renamed from: k */
    public void mo5841k() {
        Log.i("JiaoZiVideoPlayer", "onStatePause  [" + hashCode() + "] ");
        this.f5422n = 5;
        m5852v();
    }

    /* JADX INFO: renamed from: l */
    public void mo5842l() {
        Log.i("JiaoZiVideoPlayer", "onStateError  [" + hashCode() + "] ");
        this.f5422n = 7;
        m5853w();
    }

    /* JADX INFO: renamed from: m */
    public void mo5843m() {
        Log.i("JiaoZiVideoPlayer", "onStateAutoComplete  [" + hashCode() + "] ");
        this.f5422n = 6;
        m5853w();
        this.f5427s.setProgress(100);
        this.f5429u.setText(this.f5430v.getText());
    }

    /* JADX INFO: renamed from: a */
    public void m5830a(int i, int i2) {
        Log.d("JiaoZiVideoPlayer", "onInfo what - " + i + " extra - " + i2);
    }

    /* JADX INFO: renamed from: b */
    public void m5833b(int i, int i2) {
        Log.e("JiaoZiVideoPlayer", "onError " + i + " - " + i2 + " [" + hashCode() + "] ");
        if (i == 38 || i2 == -38 || i == -38 || i2 == 38 || i2 == -19) {
            return;
        }
        mo5842l();
        if (m5819A()) {
            TextureViewSurfaceTextureListenerC1800ik.m9788a().m9797g();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f5423o == 2 || this.f5423o == 3) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f5434z != 0 && this.f5401A != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) ((size * this.f5401A) / this.f5434z);
            setMeasuredDimension(size, i3);
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: n */
    public void mo5844n() {
        Log.e("JiaoZiVideoPlayer", "监听: onAutoCompletion");
        Runtime.getRuntime().gc();
        Log.i("JiaoZiVideoPlayer", "onAutoCompletion  [" + hashCode() + "] ");
        m5829a(6);
        mo5825G();
        mo5824F();
        mo5826H();
        mo5843m();
        if (this.f5423o == 2 || this.f5423o == 3) {
            m5816b();
        }
        TextureViewSurfaceTextureListenerC1800ik.m9788a().m9797g();
        C1803in.m9805a(getContext(), C1803in.m9802a(this.f5402B, this.f5403C), 0L);
    }

    /* JADX INFO: renamed from: o */
    public void mo5845o() {
        Log.e("JiaoZiVideoPlayer", "监听: onCompletion");
        Log.i("JiaoZiVideoPlayer", "onCompletion  [" + hashCode() + "] ");
        if (this.f5422n == 3 || this.f5422n == 5) {
            C1803in.m9805a(getContext(), C1803in.m9802a(this.f5402B, this.f5403C), getCurrentPositionWhenPlaying());
        }
        m5853w();
        mo5837g();
        this.f5431w.removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10342g = 0;
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10343h = 0;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(f5398k);
        C1803in.m9808b(getContext()).getWindow().clearFlags(128);
        m5849s();
        C1803in.m9804a(getContext(), f5392d);
        if (TextureViewSurfaceTextureListenerC1800ik.f10338c != null) {
            TextureViewSurfaceTextureListenerC1800ik.f10338c.release();
        }
        if (TextureViewSurfaceTextureListenerC1800ik.f10337b != null) {
            TextureViewSurfaceTextureListenerC1800ik.f10337b.release();
        }
        TextureViewSurfaceTextureListenerC1800ik.f10336a = null;
        TextureViewSurfaceTextureListenerC1800ik.f10337b = null;
    }

    /* JADX INFO: renamed from: p */
    public void m5846p() {
        m5848r();
        TextureViewSurfaceTextureListenerC1800ik.f10336a = new JZResizeTextureView(getContext());
        TextureViewSurfaceTextureListenerC1800ik.f10336a.setSurfaceTextureListener(TextureViewSurfaceTextureListenerC1800ik.m9788a());
    }

    /* JADX INFO: renamed from: q */
    public void m5847q() {
        Log.d("JiaoZiVideoPlayer", "addTextureView [" + hashCode() + "] ");
        this.f5431w.addView(TextureViewSurfaceTextureListenerC1800ik.f10336a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX INFO: renamed from: r */
    public void m5848r() {
        TextureViewSurfaceTextureListenerC1800ik.f10337b = null;
        if (TextureViewSurfaceTextureListenerC1800ik.f10336a == null || TextureViewSurfaceTextureListenerC1800ik.f10336a.getParent() == null) {
            return;
        }
        ((ViewGroup) TextureViewSurfaceTextureListenerC1800ik.f10336a.getParent()).removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
    }

    /* JADX INFO: renamed from: s */
    public void m5849s() {
        ViewGroup viewGroup = (ViewGroup) C1803in.m9808b(getContext()).findViewById(android.R.id.content);
        View viewFindViewById = viewGroup.findViewById(R.id.jz_fullscreen_id);
        View viewFindViewById2 = viewGroup.findViewById(R.id.jz_tiny_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
        m5814a(getContext());
    }

    /* JADX INFO: renamed from: t */
    public void m5850t() {
        C1803in.m9804a(getContext(), f5392d);
        m5814a(getContext());
        ViewGroup viewGroup = (ViewGroup) C1803in.m9808b(getContext()).findViewById(android.R.id.content);
        JZVideoPlayer jZVideoPlayer = (JZVideoPlayer) viewGroup.findViewById(R.id.jz_fullscreen_id);
        JZVideoPlayer jZVideoPlayer2 = (JZVideoPlayer) viewGroup.findViewById(R.id.jz_tiny_id);
        if (jZVideoPlayer != null) {
            viewGroup.removeView(jZVideoPlayer);
            if (jZVideoPlayer.f5431w != null) {
                jZVideoPlayer.f5431w.removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
            }
        }
        if (jZVideoPlayer2 != null) {
            viewGroup.removeView(jZVideoPlayer2);
            if (jZVideoPlayer2.f5431w != null) {
                jZVideoPlayer2.f5431w.removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
            }
        }
        C1804io.m9815b(null);
    }

    /* JADX INFO: renamed from: u */
    public void m5851u() {
        Log.i("JiaoZiVideoPlayer", "onVideoSizeChanged  [" + hashCode() + "] ");
        if (TextureViewSurfaceTextureListenerC1800ik.f10336a != null) {
            if (this.f5405E != 0) {
                TextureViewSurfaceTextureListenerC1800ik.f10336a.setRotation(this.f5405E);
            }
            TextureViewSurfaceTextureListenerC1800ik.f10336a.setVideoSize(TextureViewSurfaceTextureListenerC1800ik.m9788a().f10342g, TextureViewSurfaceTextureListenerC1800ik.m9788a().f10343h);
        }
    }

    /* JADX INFO: renamed from: v */
    public void m5852v() {
        Log.i("JiaoZiVideoPlayer", "startProgressTimer:  [" + hashCode() + "] ");
        m5853w();
        f5400m = new Timer();
        this.f5409I = new C0802a();
        f5400m.schedule(this.f5409I, 0L, 300L);
    }

    /* JADX INFO: renamed from: w */
    public void m5853w() {
        if (f5400m != null) {
            f5400m.cancel();
        }
        if (this.f5409I != null) {
            this.f5409I.cancel();
        }
    }

    public void setProgressAndText(int i, long j, long j2) {
        if (!this.f5410J && i != 0) {
            this.f5427s.setProgress(i);
        }
        if (j != 0) {
            this.f5429u.setText(C1803in.m9803a(j));
        }
        this.f5430v.setText(C1803in.m9803a(j2));
    }

    public void setBufferProgress(int i) {
        if (i != 0) {
            this.f5427s.setSecondaryProgress(i);
        }
    }

    /* JADX INFO: renamed from: x */
    public void mo5854x() {
        this.f5427s.setProgress(0);
        this.f5427s.setSecondaryProgress(0);
        this.f5429u.setText(C1803in.m9803a(0L));
        this.f5430v.setText(C1803in.m9803a(0L));
    }

    public long getCurrentPositionWhenPlaying() {
        if (this.f5422n != 3 && this.f5422n != 5) {
            return 0L;
        }
        try {
            return TextureViewSurfaceTextureListenerC1800ik.m9793c();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return TextureViewSurfaceTextureListenerC1800ik.m9794d();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.i("JiaoZiVideoPlayer", "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        m5853w();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.i("JiaoZiVideoPlayer", "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        m5829a(5);
        m5852v();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        if (this.f5422n == 3 || this.f5422n == 5) {
            long progress = (((long) seekBar.getProgress()) * getDuration()) / 100;
            TextureViewSurfaceTextureListenerC1800ik.m9789a(progress);
            Log.i("JiaoZiVideoPlayer", "seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    /* JADX INFO: renamed from: y */
    public void m5855y() {
        Log.i("JiaoZiVideoPlayer", "startWindowFullscreen  [" + hashCode() + "] ");
        m5815b(getContext());
        C1803in.m9804a(getContext(), f5391c);
        ViewGroup viewGroup = (ViewGroup) C1803in.m9808b(getContext()).findViewById(android.R.id.content);
        View viewFindViewById = viewGroup.findViewById(R.id.jz_fullscreen_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        this.f5431w.removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
        try {
            JZVideoPlayer jZVideoPlayer = (JZVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jZVideoPlayer.setId(R.id.jz_fullscreen_id);
            viewGroup.addView(jZVideoPlayer, new FrameLayout.LayoutParams(-1, -1));
            jZVideoPlayer.setSystemUiVisibility(4102);
            jZVideoPlayer.setUp(this.f5402B, this.f5403C, 2, this.f5424p);
            jZVideoPlayer.setState(this.f5422n);
            jZVideoPlayer.m5847q();
            C1804io.m9815b(jZVideoPlayer);
            mo5837g();
            jZVideoPlayer.f5427s.setSecondaryProgress(this.f5427s.getSecondaryProgress());
            jZVideoPlayer.m5852v();
            f5396h = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: z */
    public void m5856z() {
        Log.i("JiaoZiVideoPlayer", "startWindowTiny  [" + hashCode() + "] ");
        m5829a(9);
        if (this.f5422n == 0 || this.f5422n == 7 || this.f5422n == 6) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) C1803in.m9808b(getContext()).findViewById(android.R.id.content);
        View viewFindViewById = viewGroup.findViewById(R.id.jz_tiny_id);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        this.f5431w.removeView(TextureViewSurfaceTextureListenerC1800ik.f10336a);
        try {
            JZVideoPlayer jZVideoPlayer = (JZVideoPlayer) getClass().getConstructor(Context.class).newInstance(getContext());
            jZVideoPlayer.setId(R.id.jz_tiny_id);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400, 400);
            layoutParams.gravity = 85;
            viewGroup.addView(jZVideoPlayer, layoutParams);
            jZVideoPlayer.setUp(this.f5402B, this.f5403C, 3, this.f5424p);
            jZVideoPlayer.setState(this.f5422n);
            jZVideoPlayer.m5847q();
            C1804io.m9815b(jZVideoPlayer);
            mo5837g();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: A */
    public boolean m5819A() {
        return m5820B() && C1803in.m9807a(this.f5402B, TextureViewSurfaceTextureListenerC1800ik.m9792b());
    }

    /* JADX INFO: renamed from: B */
    public boolean m5820B() {
        return C1804io.m9816c() != null && C1804io.m9816c() == this;
    }

    /* JADX INFO: renamed from: C */
    public void m5821C() {
        Log.i("JiaoZiVideoPlayer", "playOnThisJzvd  [" + hashCode() + "] ");
        this.f5422n = C1804io.m9814b().f5422n;
        this.f5403C = C1804io.m9814b().f5403C;
        m5850t();
        setState(this.f5422n);
        m5847q();
    }

    /* JADX INFO: renamed from: a */
    public void m5829a(int i) {
        if (f5399l == null || !m5819A() || this.f5402B == null) {
            return;
        }
        f5399l.m9799a(i, C1803in.m9802a(this.f5402B, this.f5403C), this.f5423o, this.f5424p);
    }

    public static void setMediaInterface(AbstractC1799ij abstractC1799ij) {
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10341f = abstractC1799ij;
    }

    /* JADX INFO: renamed from: cn.jzvd.JZVideoPlayer$a */
    public class C0802a extends TimerTask {
        public C0802a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (JZVideoPlayer.this.f5422n == 3 || JZVideoPlayer.this.f5422n == 5) {
                JZVideoPlayer.this.post(new Runnable() { // from class: cn.jzvd.JZVideoPlayer.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentPositionWhenPlaying = JZVideoPlayer.this.getCurrentPositionWhenPlaying();
                        long duration = JZVideoPlayer.this.getDuration();
                        JZVideoPlayer.this.setProgressAndText((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
                    }
                });
            }
        }
    }
}
