package com.coollang.tennis.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.Custom.CompletedView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1894lx;
import p000.C1898ma;
import p000.C1900mc;
import p000.C1908mg;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class Video_recording extends BaseActivity implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a */
    SurfaceHolder f7322a;

    /* JADX INFO: renamed from: c */
    File f7324c;

    /* JADX INFO: renamed from: e */
    private SurfaceView f7326e;

    /* JADX INFO: renamed from: f */
    private ImageView f7327f;

    /* JADX INFO: renamed from: g */
    private ImageView f7328g;

    /* JADX INFO: renamed from: j */
    private MediaRecorder f7331j;

    /* JADX INFO: renamed from: k */
    private SurfaceHolder f7332k;

    /* JADX INFO: renamed from: l */
    private Camera f7333l;

    /* JADX INFO: renamed from: m */
    private MediaPlayer f7334m;

    /* JADX INFO: renamed from: n */
    private String f7335n;

    /* JADX INFO: renamed from: o */
    private TextView f7336o;

    /* JADX INFO: renamed from: q */
    private FrameLayout f7338q;

    /* JADX INFO: renamed from: r */
    private CompletedView f7339r;

    /* JADX INFO: renamed from: s */
    private ImageView f7340s;

    /* JADX INFO: renamed from: t */
    private ImageView f7341t;

    /* JADX INFO: renamed from: u */
    private ImageView f7342u;

    /* JADX INFO: renamed from: v */
    private PopupWindow f7343v;

    /* JADX INFO: renamed from: w */
    private TextView f7344w;

    /* JADX INFO: renamed from: x */
    private C1874ld f7345x;

    /* JADX INFO: renamed from: h */
    private boolean f7329h = false;

    /* JADX INFO: renamed from: i */
    private boolean f7330i = false;

    /* JADX INFO: renamed from: p */
    private int f7337p = 0;

    /* JADX INFO: renamed from: b */
    int f7323b = 0;

    /* JADX INFO: renamed from: y */
    private Handler f7346y = new Handler();

    /* JADX INFO: renamed from: z */
    private Runnable f7347z = new Runnable() { // from class: com.coollang.tennis.activity.Video_recording.1
        @Override // java.lang.Runnable
        public void run() {
            Video_recording.m7678a(Video_recording.this);
            Video_recording.this.f7336o.setText(Video_recording.this.f7337p + "");
            Video_recording.this.f7339r.setProgress(Video_recording.this.f7337p);
            Video_recording.this.f7346y.postDelayed(this, 1000L);
        }
    };

    /* JADX INFO: renamed from: d */
    MediaPlayer.OnPreparedListener f7325d = new MediaPlayer.OnPreparedListener() { // from class: com.coollang.tennis.activity.Video_recording.2
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Video_recording.this.f7334m.start();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m7678a(Video_recording video_recording) {
        int i = video_recording.f7337p;
        video_recording.f7337p = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: c */
    public void m7708c() {
        this.f7341t.setVisibility(0);
        this.f7340s.setVisibility(0);
        this.f7328g.setVisibility(0);
    }

    /* JADX INFO: renamed from: d */
    public void m7709d() {
        this.f7341t.setVisibility(8);
        this.f7340s.setVisibility(8);
        this.f7328g.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    public void m7707a(int i) {
        this.f7343v = new PopupWindow(this);
        View viewInflate = getLayoutInflater().inflate(i, (ViewGroup) null);
        this.f7343v.setWidth(-1);
        this.f7343v.setHeight(-2);
        this.f7343v.setBackgroundDrawable(new BitmapDrawable());
        this.f7343v.setFocusable(true);
        this.f7343v.setOutsideTouchable(true);
        this.f7343v.setContentView(viewInflate);
        this.f7343v.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.video_msg);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.video_size);
        if (this.f7335n != null) {
            if (this.f7334m == null) {
                if (this.f7334m == null) {
                    this.f7334m = m7680a((Context) this);
                }
                this.f7334m = MediaPlayer.create(this, Uri.parse(this.f7335n));
            }
            long duration = this.f7334m.getDuration();
            Log.e("MainActivity", "getDuration: " + duration);
            String strM10472a = C1898ma.m10472a(duration);
            Log.e("MainActivity", "getDuration-----: " + strM10472a);
            textView.setText(strM10472a);
            try {
                this.f7324c = new File(this.f7335n);
                long jM10517a = C1908mg.m10517a(this.f7324c);
                String strM10520b = C1908mg.m10520b(jM10517a);
                Log.e("MainActivity", "~~~~~~~~~~~~~~~videosize~~~~~~~: " + jM10517a);
                Log.e("MainActivity", "~~~~~~~~~~~~~~~videosize~~~~~~~: " + strM10520b);
                textView2.setText(strM10520b);
                this.f7334m.release();
                this.f7334m = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ((ImageView) viewInflate.findViewById(R.id.back_recoding)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_recording.this.f7343v.dismiss();
            }
        });
        ((RelativeLayout) viewInflate.findViewById(R.id.post_video)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_recording.this.f7345x.m10245q();
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public void m7710e() {
        this.f7337p = 0;
        this.f7339r.setProgress(this.f7337p);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 78) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取token服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取token失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "获取token和key成功");
                    System.out.println(this.f7335n);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m7695h() {
        this.f7345x = new C1874ld();
        akd.m1706a().m1719a(this);
        this.f7326e = (SurfaceView) findViewById(R.id.surfaceview);
        this.f7342u = (ImageView) findViewById(R.id.camera_false);
        this.f7327f = (ImageView) findViewById(R.id.start_video);
        this.f7339r = (CompletedView) findViewById(R.id.tasks_view);
        this.f7340s = (ImageView) findViewById(R.id.recod_delete);
        this.f7341t = (ImageView) findViewById(R.id.finsh_recoding);
        this.f7341t.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_recording.this.m7707a(R.layout.complete_pop_layout);
            }
        });
        this.f7340s.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1894lx.m10457a(Video_recording.this.f7335n);
                Video_recording.this.f7335n = "";
                Video_recording.this.m7709d();
                Video_recording.this.m7710e();
                Log.e("MainActivity", "DeleteFileUtil  : " + Video_recording.this.f7335n);
                if (Video_recording.this.f7333l == null) {
                    Video_recording.this.f7333l = Camera.open(0);
                    Log.e("MainActivity", "camera: 重新打开摄像头！！");
                }
                try {
                    Video_recording.this.f7333l.setPreviewDisplay(Video_recording.this.f7322a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Video_recording.this.f7333l.setDisplayOrientation(90);
                Video_recording.this.f7333l.startPreview();
            }
        });
        this.f7342u.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Video_recording.this.f7329h || Video_recording.this.f7330i) {
                    return;
                }
                Log.e("MainActivity", "镜头切换: ");
                if (Video_recording.this.f7323b == 0) {
                    if (Video_recording.this.f7333l == null || Video_recording.this.f7329h || Video_recording.this.f7330i) {
                        return;
                    }
                    Video_recording.this.f7333l.stopPreview();
                    Video_recording.this.f7333l.release();
                    Video_recording.this.f7333l = null;
                    Video_recording.this.f7323b = 1;
                    Video_recording.this.f7333l = Camera.open(Video_recording.this.f7323b);
                    try {
                        Video_recording.this.f7333l.setPreviewDisplay(Video_recording.this.f7322a);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Video_recording.this.f7333l.setDisplayOrientation(90);
                    Video_recording.this.f7333l.startPreview();
                    return;
                }
                if (Video_recording.this.f7323b != 1 || Video_recording.this.f7333l == null || Video_recording.this.f7329h || Video_recording.this.f7330i) {
                    return;
                }
                Video_recording.this.f7333l.stopPreview();
                Video_recording.this.f7333l.release();
                Video_recording.this.f7333l = null;
                Video_recording.this.f7323b = 0;
                Video_recording.this.f7333l = Camera.open(Video_recording.this.f7323b);
                try {
                    Video_recording.this.f7333l.setPreviewDisplay(Video_recording.this.f7322a);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Video_recording.this.f7333l.setDisplayOrientation(90);
                Video_recording.this.f7333l.startPreview();
            }
        });
        this.f7344w = (TextView) findViewById(R.id.cancel_recording);
        this.f7344w.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_recording.this.finish();
            }
        });
        this.f7328g = (ImageView) findViewById(R.id.btnPlayVideo);
        this.f7336o = (TextView) findViewById(R.id.text);
        if (this.f7333l == null) {
            this.f7333l = Camera.open(0);
        }
        this.f7338q = (FrameLayout) findViewById(R.id.layout_start_video);
        this.f7338q.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Video_recording.this.f7330i && Video_recording.this.f7334m != null) {
                    Video_recording.this.f7330i = false;
                    Video_recording.this.f7334m.stop();
                    Video_recording.this.f7334m.reset();
                    Video_recording.this.f7334m.release();
                    Video_recording.this.f7334m = null;
                }
                if (Video_recording.this.f7329h) {
                    if (Video_recording.this.f7329h) {
                        try {
                            Video_recording.this.f7346y.removeCallbacks(Video_recording.this.f7347z);
                            Video_recording.this.f7331j.stop();
                            Video_recording.this.f7331j.reset();
                            Video_recording.this.f7331j.release();
                            Video_recording.this.f7331j = null;
                            Video_recording.this.f7327f.setImageResource(R.drawable.start_recoding_);
                            if (Video_recording.this.f7337p >= 5) {
                                Video_recording.this.m7708c();
                            } else {
                                Toast.makeText(Video_recording.this, "录制时间小于5s,删除视频", 0).show();
                                C1894lx.m10457a(Video_recording.this.f7335n);
                                Video_recording.this.f7335n = "";
                                Video_recording.this.m7709d();
                                Video_recording.this.m7710e();
                                Log.e("MainActivity", "DeleteFileUtil  : " + Video_recording.this.f7335n);
                                if (Video_recording.this.f7333l == null) {
                                    Video_recording.this.f7333l = Camera.open(0);
                                    Log.e("MainActivity", "camera: 重新打开摄像头！！");
                                }
                                try {
                                    Video_recording.this.f7333l.setPreviewDisplay(Video_recording.this.f7322a);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Video_recording.this.f7333l.setDisplayOrientation(90);
                                Video_recording.this.f7333l.startPreview();
                            }
                            if (Video_recording.this.f7333l != null) {
                                Video_recording.this.f7333l.stopPreview();
                                Video_recording.this.f7333l.release();
                                Video_recording.this.f7333l = null;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    Video_recording.this.f7329h = false;
                    return;
                }
                Video_recording.this.m7710e();
                Video_recording.this.f7346y.postDelayed(Video_recording.this.f7347z, 1000L);
                try {
                    if (Video_recording.this.f7333l == null) {
                        Video_recording.this.f7333l = Camera.open(0);
                        Log.e("MainActivity", "camera: 重新打开摄像头！！");
                        Video_recording.this.f7333l.setPreviewDisplay(Video_recording.this.f7322a);
                        Video_recording.this.f7333l.startPreview();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                if (Video_recording.this.f7331j == null) {
                    Video_recording.this.f7331j = new MediaRecorder();
                }
                if (Video_recording.this.f7333l != null) {
                    Video_recording.this.f7333l.setDisplayOrientation(90);
                    Video_recording.this.f7333l.unlock();
                    Video_recording.this.f7331j.setCamera(Video_recording.this.f7333l);
                }
                try {
                    Video_recording.this.f7331j.setAudioSource(5);
                    Video_recording.this.f7331j.setVideoSource(1);
                    Video_recording.this.f7331j.setOutputFormat(2);
                    Video_recording.this.f7331j.setAudioEncoder(1);
                    Video_recording.this.f7331j.setVideoEncoder(3);
                    Video_recording.this.f7331j.setVideoSize(1080, 1240);
                    Video_recording.this.f7331j.setVideoFrameRate(30);
                    Video_recording.this.f7331j.setVideoEncodingBitRate(3145728);
                    Video_recording.this.f7331j.setOrientationHint(90);
                    Video_recording.this.f7331j.setMaxDuration(20000);
                    Video_recording.this.f7331j.setPreviewDisplay(Video_recording.this.f7332k.getSurface());
                    Video_recording.this.f7335n = Video_recording.this.m7711g();
                    if (Video_recording.this.f7335n != null) {
                        File file = new File(Video_recording.this.f7335n + "/recordtest");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        Video_recording.this.f7335n = file + "/" + Video_recording.m7692f() + ".mp4";
                        Video_recording.this.f7331j.setOutputFile(Video_recording.this.f7335n);
                        Video_recording.this.f7331j.prepare();
                        Video_recording.this.f7331j.start();
                        Video_recording.this.f7329h = true;
                        Video_recording.this.f7327f.setImageResource(R.drawable.stop_recording_);
                        Video_recording.this.m7709d();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        this.f7328g.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_recording.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_recording.this.f7330i = true;
                Video_recording.this.m7697i();
                if (Video_recording.this.f7334m == null) {
                    Video_recording.this.f7334m = Video_recording.this.m7680a((Context) Video_recording.this);
                }
                Video_recording.this.f7334m.reset();
                Uri uri = Uri.parse(Video_recording.this.f7335n);
                Video_recording.this.f7334m = MediaPlayer.create(Video_recording.this, uri);
                Video_recording.this.f7334m.setAudioStreamType(3);
                Video_recording.this.f7334m.setDisplay(Video_recording.this.f7332k);
                try {
                    if (Video_recording.this.f7334m != null) {
                        Log.e("MainActivity", "onClick: zzzzzzzzzz!");
                        Video_recording.this.f7334m.stop();
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                try {
                    Video_recording.this.f7334m.prepare();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Video_recording.this.f7334m.start();
            }
        });
        this.f7322a = this.f7326e.getHolder();
        this.f7322a.addCallback(this);
        this.f7322a.setType(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.luzhi_layout);
        m7695h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        boolean z = this.f7329h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m7697i() {
        if (this.f7334m != null) {
            this.f7334m.stop();
            this.f7334m.release();
            this.f7334m = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m7692f() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        int i4 = calendar.get(12);
        String str = "" + i + (i2 + 1) + i3 + calendar.get(10) + i4 + calendar.get(13);
        Log.d("MainActivity", "date:" + str);
        return str;
    }

    /* JADX INFO: renamed from: g */
    public String m7711g() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        m7701l();
        this.f7332k = surfaceHolder;
        try {
            this.f7333l.setPreviewDisplay(this.f7322a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f7333l.startPreview();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f7332k = surfaceHolder;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f7326e = null;
        this.f7332k = null;
        this.f7346y.removeCallbacks(this.f7347z);
        if (this.f7331j != null) {
            this.f7331j.release();
            this.f7331j = null;
            Log.d("MainActivity", "surfaceDestroyed release mRecorder");
        }
        if (this.f7333l != null) {
            this.f7333l.stopPreview();
            this.f7333l.release();
            this.f7333l = null;
        }
        if (this.f7334m != null) {
            this.f7334m.release();
            this.f7334m = null;
        }
    }

    /* JADX INFO: renamed from: l */
    private void m7701l() {
        int i;
        getWindowManager().getDefaultDisplay();
        Camera.Parameters parameters = this.f7333l.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        int i2 = 0;
        if (supportedPreviewSizes.size() > 1) {
            for (Camera.Size size : supportedPreviewSizes) {
                if (size.width >= 0 && size.height >= 0) {
                    i2 = size.width;
                    i = size.height;
                    break;
                }
            }
            i = 0;
        } else {
            i = 0;
        }
        parameters.setPreviewSize(i2, i);
        this.f7333l.setParameters(parameters);
        this.f7333l.startPreview();
        this.f7333l.setDisplayOrientation(90);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public MediaPlayer m7680a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (Build.VERSION.SDK_INT < 19) {
            return mediaPlayer;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(context, null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (IllegalAccessException unused) {
                declaredField.setAccessible(false);
                return mediaPlayer;
            } catch (Throwable th) {
                declaredField.setAccessible(false);
                throw th;
            }
        } catch (Exception unused2) {
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy: ");
        this.f7326e = null;
        this.f7332k = null;
        this.f7346y.removeCallbacks(this.f7347z);
        if (this.f7331j != null) {
            this.f7331j.release();
            this.f7331j = null;
            Log.d("MainActivity", "surfaceDestroyed release mRecorder");
        }
        if (this.f7333l != null) {
            this.f7333l.setPreviewCallback(null);
            this.f7333l.stopPreview();
            this.f7333l.release();
            this.f7333l = null;
        }
        if (this.f7334m != null) {
            this.f7334m.release();
            this.f7334m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }
}
