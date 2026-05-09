package com.coollang.tennis.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.widget.CircularSeekBar;
import com.coollang.tennis.widget.FullScreenVideoView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import com.umeng.message.PushAgent;
import java.util.ArrayList;
import java.util.List;
import p000.C1842jz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1911mj;
import p000.C2068qy;
import p000.ada;

/* JADX INFO: loaded from: classes.dex */
public class VideoPlayActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: C */
    private int f7167C;

    /* JADX INFO: renamed from: D */
    private int f7168D;

    /* JADX INFO: renamed from: E */
    private int f7169E;

    /* JADX INFO: renamed from: F */
    private int f7170F;

    /* JADX INFO: renamed from: G */
    private int f7171G;

    /* JADX INFO: renamed from: H */
    private int f7172H;

    /* JADX INFO: renamed from: K */
    private ImageView f7175K;

    /* JADX INFO: renamed from: L */
    private RippleView f7176L;

    /* JADX INFO: renamed from: M */
    private ImageButton f7177M;

    /* JADX INFO: renamed from: N */
    private TextView f7178N;

    /* JADX INFO: renamed from: O */
    private SeekBar f7179O;

    /* JADX INFO: renamed from: P */
    private int f7180P;

    /* JADX INFO: renamed from: Q */
    private MediaPlayer f7181Q;

    /* JADX INFO: renamed from: S */
    private TextView f7183S;

    /* JADX INFO: renamed from: d */
    public LinearLayout f7187d;

    /* JADX INFO: renamed from: h */
    private TextView f7191h;

    /* JADX INFO: renamed from: i */
    private CircularSeekBar f7192i;

    /* JADX INFO: renamed from: j */
    private TextView f7193j;

    /* JADX INFO: renamed from: k */
    private CircularSeekBar f7194k;

    /* JADX INFO: renamed from: l */
    private TextView f7195l;

    /* JADX INFO: renamed from: m */
    private CircularSeekBar f7196m;

    /* JADX INFO: renamed from: n */
    private FullScreenVideoView f7197n;

    /* JADX INFO: renamed from: o */
    private RelativeLayout f7198o;

    /* JADX INFO: renamed from: p */
    private View f7199p;

    /* JADX INFO: renamed from: q */
    private ImageButton f7200q;

    /* JADX INFO: renamed from: r */
    private TextView f7201r;

    /* JADX INFO: renamed from: s */
    private C1842jz f7202s;

    /* JADX INFO: renamed from: t */
    private long f7203t;

    /* JADX INFO: renamed from: u */
    private long f7204u;

    /* JADX INFO: renamed from: v */
    private List<MyDetailTable> f7205v;

    /* JADX INFO: renamed from: w */
    private List<Long> f7206w;

    /* JADX INFO: renamed from: x */
    private List<Long> f7207x;

    /* JADX INFO: renamed from: e */
    private final float f7188e = 200.0f;

    /* JADX INFO: renamed from: f */
    private final float f7189f = 30.0f;

    /* JADX INFO: renamed from: g */
    private final float f7190g = 360.0f;

    /* JADX INFO: renamed from: y */
    private int f7208y = 0;

    /* JADX INFO: renamed from: z */
    private int f7209z = 0;

    /* JADX INFO: renamed from: A */
    private int f7165A = 0;

    /* JADX INFO: renamed from: B */
    private int f7166B = 0;

    /* JADX INFO: renamed from: I */
    private int f7173I = 0;

    /* JADX INFO: renamed from: J */
    private int f7174J = 0;

    /* JADX INFO: renamed from: a */
    Handler f7184a = new Handler() { // from class: com.coollang.tennis.activity.VideoPlayActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                VideoPlayActivity.this.f7191h.setText(String.valueOf(((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getSpeed()));
                VideoPlayActivity.this.f7193j.setText(String.valueOf(Math.round(((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getForce() * 0.11f)));
                VideoPlayActivity.this.f7195l.setText(String.valueOf(((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getRadian()));
                VideoPlayActivity.this.f7167C = ((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getSpeed();
                VideoPlayActivity.this.f7168D = ((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getForce();
                VideoPlayActivity.this.f7169E = ((MyDetailTable) VideoPlayActivity.this.f7205v.get(VideoPlayActivity.this.f7208y)).getRadian();
                VideoPlayActivity.this.f7170F = Math.abs(VideoPlayActivity.this.f7167C - VideoPlayActivity.this.f7209z);
                VideoPlayActivity.this.f7171G = Math.abs(VideoPlayActivity.this.f7168D - VideoPlayActivity.this.f7165A);
                VideoPlayActivity.this.f7172H = Math.abs(VideoPlayActivity.this.f7169E - VideoPlayActivity.this.f7166B);
                VideoPlayActivity.this.f7173I = 0;
                VideoPlayActivity.this.f7174J = Math.max(Math.max(VideoPlayActivity.this.f7170F, VideoPlayActivity.this.f7171G), Math.max(VideoPlayActivity.this.f7171G, VideoPlayActivity.this.f7172H));
                VideoPlayActivity.this.f7184a.post(VideoPlayActivity.this.f7186c);
                VideoPlayActivity.m7619o(VideoPlayActivity.this);
                if (VideoPlayActivity.this.f7208y < VideoPlayActivity.this.f7206w.size()) {
                    VideoPlayActivity.this.f7184a.sendEmptyMessageDelayed(0, ((Long) VideoPlayActivity.this.f7206w.get(VideoPlayActivity.this.f7208y)).longValue() * 1000);
                    return;
                }
                return;
            }
            if (message.what == 1) {
                VideoPlayActivity.this.f7179O.setMax(VideoPlayActivity.this.f7197n.getDuration());
                VideoPlayActivity.this.f7179O.setProgress(VideoPlayActivity.this.f7197n.getCurrentPosition());
                String strValueOf = String.valueOf(C1911mj.m10528b(VideoPlayActivity.this.f7197n.getCurrentPosition()));
                VideoPlayActivity.this.f7178N.setText(C1910mi.m10525b(strValueOf, strValueOf + "/" + C1911mj.m10528b(VideoPlayActivity.this.f7197n.getDuration()), VideoPlayActivity.this.getResources().getColor(R.color.bg_black_90)));
                VideoPlayActivity.this.f7184a.postDelayed(VideoPlayActivity.this.f7185b, 1000L);
                return;
            }
            if (message.what == 2) {
                VideoPlayActivity.this.f7180P = 0;
                VideoPlayActivity.this.f7179O.setProgress(VideoPlayActivity.this.f7180P);
                VideoPlayActivity.this.f7178N.setText(C1910mi.m10525b("00:00", "00:00/" + C1911mj.m10528b(VideoPlayActivity.this.f7197n.getDuration()), VideoPlayActivity.this.getResources().getColor(R.color.bg_black_90)));
                VideoPlayActivity.this.f7184a.removeCallbacks(VideoPlayActivity.this.f7185b, null);
                VideoPlayActivity.this.f7184a.removeMessages(0);
                VideoPlayActivity.this.f7177M.setImageResource(R.drawable.img_play_video);
                VideoPlayActivity.this.f7192i.setProgress(0);
                VideoPlayActivity.this.f7194k.setProgress(0);
                VideoPlayActivity.this.f7196m.setProgress(0);
                VideoPlayActivity.this.f7192i.setRingBlue();
                VideoPlayActivity.this.f7194k.setRingRed();
                VideoPlayActivity.this.f7196m.setRingYello();
                VideoPlayActivity.this.f7191h.setText("0");
                VideoPlayActivity.this.f7193j.setText("0");
                VideoPlayActivity.this.f7195l.setText("0");
                VideoPlayActivity.this.f7208y = 0;
                return;
            }
            if (message.what == 1003 && VideoPlayActivity.this.f7198o.getVisibility() == 0) {
                VideoPlayActivity.this.m7602h();
            }
        }
    };

    /* JADX INFO: renamed from: b */
    Runnable f7185b = new Runnable() { // from class: com.coollang.tennis.activity.VideoPlayActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayActivity.this.f7179O.getProgress() < VideoPlayActivity.this.f7197n.getCurrentPosition()) {
                VideoPlayActivity.this.f7179O.setProgress(VideoPlayActivity.this.f7197n.getCurrentPosition());
                String strValueOf = String.valueOf(C1911mj.m10528b(VideoPlayActivity.this.f7197n.getCurrentPosition()));
                VideoPlayActivity.this.f7178N.setText(C1910mi.m10525b(strValueOf, strValueOf + "/" + C1911mj.m10528b(VideoPlayActivity.this.f7197n.getDuration()), VideoPlayActivity.this.getResources().getColor(R.color.bg_black_90)));
            }
            VideoPlayActivity.this.f7184a.postDelayed(VideoPlayActivity.this.f7185b, 1000L);
        }
    };

    /* JADX INFO: renamed from: c */
    Runnable f7186c = new Runnable() { // from class: com.coollang.tennis.activity.VideoPlayActivity.4
        @Override // java.lang.Runnable
        public void run() {
            VideoPlayActivity.this.f7209z = VideoPlayActivity.this.m7571a(VideoPlayActivity.this.f7209z, VideoPlayActivity.this.f7167C);
            VideoPlayActivity.this.f7165A = VideoPlayActivity.this.m7571a(VideoPlayActivity.this.f7165A, VideoPlayActivity.this.f7168D);
            VideoPlayActivity.this.f7166B = VideoPlayActivity.this.m7571a(VideoPlayActivity.this.f7166B, VideoPlayActivity.this.f7169E);
            VideoPlayActivity.this.f7192i.setProgress(VideoPlayActivity.this.m7570a(VideoPlayActivity.this.f7209z, 200.0f));
            VideoPlayActivity.this.f7194k.setProgress(VideoPlayActivity.this.m7580b(VideoPlayActivity.this.f7165A));
            VideoPlayActivity.this.f7196m.setProgress(VideoPlayActivity.this.m7570a(VideoPlayActivity.this.f7166B, 360.0f));
            VideoPlayActivity.m7559A(VideoPlayActivity.this);
            if (VideoPlayActivity.this.f7173I < VideoPlayActivity.this.f7174J) {
                VideoPlayActivity.this.f7184a.postDelayed(VideoPlayActivity.this.f7186c, 1L);
            }
        }
    };

    /* JADX INFO: renamed from: R */
    private boolean f7182R = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m7570a(int i, float f) {
        int i2 = (int) ((i * 100) / f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public int m7580b(int i) {
        int i2 = (int) ((i * 11) / 30.0f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: renamed from: A */
    static /* synthetic */ int m7559A(VideoPlayActivity videoPlayActivity) {
        int i = videoPlayActivity.f7173I;
        videoPlayActivity.f7173I = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: o */
    static /* synthetic */ int m7619o(VideoPlayActivity videoPlayActivity) {
        int i = videoPlayActivity.f7208y;
        videoPlayActivity.f7208y = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m7571a(int i, int i2) {
        int i3 = i - i2;
        int i4 = 1;
        if (Math.abs(i3) > 5) {
            i4 = 5;
        } else if (Math.abs(i3) > 3) {
            i4 = 3;
        } else if (Math.abs(i3) <= 1) {
            i4 = 0;
        }
        return i > i2 ? i - i4 : i + i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_video_play);
        PushAgent.getInstance(this).onAppStart();
        this.f7202s = C1842jz.m10050a();
        m7587c();
        m7590d();
        m7593e();
        m7596f();
    }

    /* JADX INFO: renamed from: c */
    private void m7587c() {
        this.f7201r = (TextView) findViewById(R.id.tv_title_video_play);
        this.f7197n = (FullScreenVideoView) findViewById(R.id.videoview);
        this.f7175K = (ImageView) findViewById(R.id.activity_video_play_iv_picture);
        this.f7176L = (RippleView) findViewById(R.id.leftBtn);
        this.f7191h = (TextView) findViewById(R.id.videocapture_tv_rate);
        this.f7192i = (CircularSeekBar) findViewById(R.id.videocapture_pb_rate);
        this.f7193j = (TextView) findViewById(R.id.videocapture_tv_strenth);
        this.f7194k = (CircularSeekBar) findViewById(R.id.videocapture_pb_strength);
        this.f7195l = (TextView) findViewById(R.id.videocapture_tv_angle);
        this.f7196m = (CircularSeekBar) findViewById(R.id.videocapture_pb_angle);
        this.f7187d = (LinearLayout) findViewById(R.id.my_video_view_ll_control);
        this.f7177M = (ImageButton) findViewById(R.id.my_video_view_ib_start);
        this.f7178N = (TextView) findViewById(R.id.my_video_view_tv_time);
        this.f7200q = (ImageButton) findViewById(R.id.my_video_view_ib_voice);
        this.f7179O = (SeekBar) findViewById(R.id.my_video_view_sb);
        this.f7198o = (RelativeLayout) findViewById(R.id.ll_title_video_play);
        this.f7199p = findViewById(R.id.ll_layout_manager_video_play);
        this.f7183S = (TextView) findViewById(R.id.tv_play_speedunit);
    }

    /* JADX INFO: renamed from: d */
    private void m7590d() {
        this.f7192i.setProgress(0);
        this.f7194k.setProgress(0);
        this.f7196m.setProgress(0);
        this.f7192i.setRingBlue();
        this.f7194k.setRingRed();
        this.f7196m.setRingYello();
        this.f7201r.setText(getIntent().getStringExtra("videoname"));
    }

    /* JADX INFO: renamed from: e */
    private void m7593e() {
        String stringExtra = getIntent().getStringExtra("fileName");
        this.f7203t = getIntent().getLongExtra("startTime", 0L);
        this.f7204u = getIntent().getLongExtra("endTime", 0L);
        String stringExtra2 = getIntent().getStringExtra("picture");
        if (stringExtra2 != null && !stringExtra2.startsWith("file://")) {
            stringExtra2 = "file://" + stringExtra2;
        }
        C2068qy.m11356a().m11360a(stringExtra2, this.f7175K);
        Uri uri = Uri.parse(stringExtra);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(this.f7197n);
        mediaController.setVisibility(4);
        this.f7197n.setMediaController(mediaController);
        this.f7197n.setVideoURI(uri);
        this.f7197n.requestFocus();
    }

    /* JADX INFO: renamed from: f */
    private void m7596f() {
        this.f7176L.setOnClickListener(this);
        this.f7197n.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoPlayActivity.this.f7181Q = mediaPlayer;
            }
        });
        this.f7197n.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.6
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoPlayActivity.this.f7179O.setProgress(VideoPlayActivity.this.f7197n.getDuration());
                VideoPlayActivity.this.f7184a.sendEmptyMessageDelayed(2, 1000L);
            }
        });
        this.f7197n.setOnTouchListener(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (VideoPlayActivity.this.f7198o.getVisibility() == 0) {
                    VideoPlayActivity.this.m7602h();
                    return true;
                }
                VideoPlayActivity.this.m7605i();
                return true;
            }
        });
        this.f7200q.setOnClickListener(this);
        this.f7177M.setOnClickListener(this);
        this.f7179O.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoPlayActivity.this.f7180P = seekBar.getProgress();
                VideoPlayActivity.this.m7612l();
                VideoPlayActivity.this.m7618n();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoPlayActivity.this.f7184a.removeCallbacks(VideoPlayActivity.this.f7185b);
                VideoPlayActivity.this.f7184a.removeMessages(0);
                VideoPlayActivity.this.f7197n.pause();
                VideoPlayActivity.this.f7184a.removeMessages(PointerIconCompat.TYPE_HELP);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                String strValueOf = String.valueOf(C1911mj.m10528b(i));
                VideoPlayActivity.this.f7178N.setText(C1910mi.m10525b(strValueOf, strValueOf + "/" + C1911mj.m10528b(VideoPlayActivity.this.f7197n.getDuration()), VideoPlayActivity.this.getResources().getColor(R.color.bg_black_90)));
            }
        });
        this.f7198o.setOnTouchListener(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                VideoPlayActivity.this.m7618n();
                return false;
            }
        });
        this.f7199p.setOnTouchListener(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.VideoPlayActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                VideoPlayActivity.this.m7618n();
                return false;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private void m7578a(int i) {
        int iLongValue;
        if (this.f7207x == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f7207x.size()) {
                iLongValue = 0;
                break;
            }
            long j = i;
            if (j < this.f7207x.get(i2).longValue() * 1000) {
                this.f7208y = i2;
                iLongValue = (int) ((this.f7207x.get(i2).longValue() * 1000) - j);
                break;
            }
            i2++;
        }
        this.f7184a.sendEmptyMessageDelayed(0, iLongValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        m7599g();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.VideoPlayActivity$2] */
    /* JADX INFO: renamed from: g */
    private void m7599g() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.VideoPlayActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                VideoPlayActivity.this.f7205v = VideoPlayActivity.this.f7202s.m10052a(VideoPlayActivity.this.f7203t, VideoPlayActivity.this.f7204u, C1902me.m10487b(VideoPlayActivity.this, "UserID", "-1"));
                C1900mc.m10474b("mMyDetailTableList", new Gson().toJson(VideoPlayActivity.this.f7205v));
                if (VideoPlayActivity.this.f7205v == null || VideoPlayActivity.this.f7205v.size() <= 0) {
                    return null;
                }
                VideoPlayActivity.this.f7206w = VideoPlayActivity.this.f7202s.m10053a(VideoPlayActivity.this.f7205v, VideoPlayActivity.this.f7203t);
                VideoPlayActivity.this.f7207x = new ArrayList();
                long j = 0;
                int i = 0;
                while (i < VideoPlayActivity.this.f7206w.size()) {
                    long jLongValue = j + ((Long) VideoPlayActivity.this.f7206w.get(i)).longValue();
                    VideoPlayActivity.this.f7207x.add(Long.valueOf(jLongValue));
                    i++;
                    j = jLongValue;
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r6) {
                super.onPostExecute(r6);
                VideoPlayActivity.this.f7175K.setVisibility(8);
                VideoPlayActivity.this.f7197n.start();
                VideoPlayActivity.this.f7184a.sendEmptyMessageDelayed(1, 1000L);
                if (VideoPlayActivity.this.f7206w == null || VideoPlayActivity.this.f7208y >= VideoPlayActivity.this.f7206w.size()) {
                    return;
                }
                VideoPlayActivity.this.f7184a.sendEmptyMessageDelayed(0, ((Long) VideoPlayActivity.this.f7206w.get(VideoPlayActivity.this.f7208y)).longValue() * 1000);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m7579a(Activity activity, String str, String str2, long j, long j2, String str3) {
        C1900mc.m10474b("litpal", j + " ==== " + j2);
        Intent intent = new Intent(activity, (Class<?>) VideoPlayActivity.class);
        intent.putExtra("fileName", str);
        intent.putExtra("startTime", j);
        intent.putExtra("endTime", j2);
        intent.putExtra("picture", str2);
        intent.putExtra("videoname", str3);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f7184a.removeMessages(0);
        this.f7184a.removeCallbacks(this.f7185b, null);
        this.f7184a.removeCallbacks(this.f7186c, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.leftBtn /* 2131296780 */:
                finish();
                break;
            case R.id.my_video_view_ib_start /* 2131296889 */:
                m7618n();
                if (this.f7197n.isPlaying()) {
                    m7615m();
                } else {
                    m7612l();
                }
                break;
            case R.id.my_video_view_ib_voice /* 2131296890 */:
                m7618n();
                if (!this.f7182R) {
                    this.f7200q.setImageResource(R.drawable.img_sound_close);
                    this.f7182R = true;
                    if (this.f7181Q != null) {
                        this.f7181Q.setVolume(0.0f, 0.0f);
                    }
                } else {
                    this.f7182R = false;
                    if (this.f7181Q != null) {
                        this.f7181Q.setVolume(0.5f, 0.5f);
                    }
                    this.f7200q.setImageResource(R.drawable.img_sound_open);
                }
                break;
            case R.id.videoview /* 2131297474 */:
                if (this.f7198o.getVisibility() == 0) {
                    m7602h();
                } else {
                    m7605i();
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7602h() {
        this.f7198o.startAnimation(AnimationUtils.loadAnimation(this, R.anim.video_controller_top_hide));
        this.f7198o.setVisibility(8);
        this.f7199p.startAnimation(AnimationUtils.loadAnimation(this, R.anim.video_controller_bottom_hide));
        this.f7199p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m7605i() {
        this.f7198o.setVisibility(0);
        this.f7198o.startAnimation(AnimationUtils.loadAnimation(this, R.anim.video_controller_top_show));
        this.f7199p.setVisibility(0);
        this.f7199p.startAnimation(AnimationUtils.loadAnimation(this, R.anim.video_controller_bottom_show));
        m7618n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m7612l() {
        this.f7197n.start();
        this.f7197n.seekTo(this.f7180P);
        this.f7184a.post(this.f7185b);
        m7578a(this.f7180P);
        this.f7177M.setImageResource(R.drawable.img_pause_video);
    }

    /* JADX INFO: renamed from: m */
    private void m7615m() {
        this.f7197n.pause();
        this.f7180P = this.f7197n.getCurrentPosition();
        this.f7184a.removeCallbacks(this.f7185b);
        this.f7184a.removeMessages(0);
        this.f7177M.setImageResource(R.drawable.img_play_video);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ada.m301a(this);
        if (this.f7181Q.isPlaying()) {
            m7615m();
        }
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        ada.m302b(this);
        if (this.f7180P > 0) {
            this.f7180P--;
            m7612l();
            m7615m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public void m7618n() {
        this.f7184a.removeMessages(PointerIconCompat.TYPE_HELP);
        this.f7184a.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, 3000L);
    }
}
