package com.coollang.tennis.activity;

import android.content.Intent;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.Custom.BreakPointProgressBar;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import p000.DialogC1860kq;

/* JADX INFO: loaded from: classes.dex */
public class AndroidRecorder extends BaseActivity implements MediaRecorder.OnErrorListener, View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private static final String f6246a = "AndroidRecorder";

    /* JADX INFO: renamed from: b */
    private SurfaceView f6248b;

    /* JADX INFO: renamed from: c */
    private Camera f6249c;

    /* JADX INFO: renamed from: d */
    private TextView f6250d;

    /* JADX INFO: renamed from: e */
    private ImageView f6251e;

    /* JADX INFO: renamed from: f */
    private ImageView f6252f;

    /* JADX INFO: renamed from: g */
    private ImageView f6253g;

    /* JADX INFO: renamed from: h */
    private ImageView f6254h;

    /* JADX INFO: renamed from: i */
    private ImageView f6255i;

    /* JADX INFO: renamed from: j */
    private String f6256j;

    /* JADX INFO: renamed from: k */
    private TextView f6257k;

    /* JADX INFO: renamed from: l */
    private TextView f6258l;

    /* JADX INFO: renamed from: m */
    private MediaRecorder f6259m;

    /* JADX INFO: renamed from: n */
    private boolean f6260n;

    /* JADX INFO: renamed from: o */
    private SurfaceHolder f6261o;

    /* JADX INFO: renamed from: r */
    private BreakPointProgressBar f6264r;

    /* JADX INFO: renamed from: s */
    private float f6265s;

    /* JADX INFO: renamed from: t */
    private RelativeLayout f6266t;

    /* JADX INFO: renamed from: u */
    private long f6267u;

    /* JADX INFO: renamed from: v */
    private long f6268v;

    /* JADX INFO: renamed from: w */
    private int f6269w;

    /* JADX INFO: renamed from: x */
    private int f6270x;

    /* JADX INFO: renamed from: y */
    private Camera.Size f6271y;

    /* JADX INFO: renamed from: p */
    private int f6262p = 1;

    /* JADX INFO: renamed from: q */
    private DecimalFormat f6263q = new DecimalFormat("00.0");

    /* JADX INFO: renamed from: z */
    private SurfaceHolder.Callback f6272z = new SurfaceHolder.Callback() { // from class: com.coollang.tennis.activity.AndroidRecorder.1
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (AndroidRecorder.this.f6249c == null) {
                AndroidRecorder.this.f6249c = Camera.open(0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (AndroidRecorder.this.f6249c == null) {
                return;
            }
            AndroidRecorder.this.f6269w = i2;
            AndroidRecorder.this.f6270x = i3;
            AndroidRecorder.this.f6261o = surfaceHolder;
            try {
                AndroidRecorder.this.m6868a(AndroidRecorder.this.f6249c);
                AndroidRecorder.this.f6249c.setPreviewDisplay(surfaceHolder);
                AndroidRecorder.this.f6249c.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AndroidRecorder.this.f6261o = null;
            AndroidRecorder.this.m6878f();
            AndroidRecorder.this.m6886d();
        }
    };

    /* JADX INFO: renamed from: A */
    private BreakPointProgressBar.InterfaceC0988b f6247A = new BreakPointProgressBar.InterfaceC0988b() { // from class: com.coollang.tennis.activity.AndroidRecorder.2
        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: a */
        public void mo6853a() {
        }

        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: a */
        public void mo6854a(float f) {
            AndroidRecorder.this.f6265s = f;
            if (f < 5.0f) {
                AndroidRecorder.this.f6255i.setVisibility(8);
                AndroidRecorder.this.f6257k.setVisibility(0);
                AndroidRecorder.this.f6254h.setVisibility(8);
            } else {
                AndroidRecorder.this.f6257k.setVisibility(8);
            }
            AndroidRecorder.this.f6258l.setText("00." + AndroidRecorder.this.f6263q.format(f) + "");
        }

        @Override // com.coollang.tennis.Custom.BreakPointProgressBar.InterfaceC0988b
        /* JADX INFO: renamed from: b */
        public void mo6855b() {
            AndroidRecorder.this.m6870a(false);
            AndroidRecorder.this.f6257k.setVisibility(8);
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
        setContentView(R.layout.activity_android_recorder);
        this.f6258l = (TextView) findViewById(R.id.tv_recorder_time);
        this.f6257k = (TextView) findViewById(R.id.text_msg);
        this.f6248b = (SurfaceView) findViewById(R.id.surfaceView);
        this.f6250d = (TextView) findViewById(R.id.tv_cancel);
        this.f6251e = (ImageView) findViewById(R.id.iv_switch_camera);
        this.f6252f = (ImageView) findViewById(R.id.iv_recorder_play);
        this.f6253g = (ImageView) findViewById(R.id.iv_recorder_pause);
        this.f6254h = (ImageView) findViewById(R.id.iv_delete);
        this.f6266t = (RelativeLayout) findViewById(R.id.layout_progressbar);
        this.f6255i = (ImageView) findViewById(R.id.iv_completed);
        this.f6264r = (BreakPointProgressBar) findViewById(R.id.pb_recorder);
        this.f6264r.setOnVideoRecorderProgressListener(this.f6247A);
        this.f6264r.setTotalTime(20000L);
        this.f6264r.setMinDuration(5000L);
        this.f6250d.setOnClickListener(this);
        this.f6251e.setOnClickListener(this);
        this.f6252f.setOnClickListener(this);
        this.f6253g.setOnClickListener(this);
        this.f6254h.setOnClickListener(this);
        this.f6255i.setOnClickListener(this);
        SurfaceHolder holder = this.f6248b.getHolder();
        holder.setType(3);
        holder.addCallback(this.f6272z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        this.f6254h.setVisibility(8);
        this.f6255i.setVisibility(8);
        m6870a(false);
        this.f6264r.setProgress(0.0f);
        this.f6264r.m6849b();
        this.f6266t.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m6878f() {
        if (this.f6249c != null) {
            this.f6249c.stopPreview();
            this.f6249c.release();
            this.f6249c = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private Camera.Size m6864a(List<Camera.Size> list, int i, int i2) {
        double d = ((double) i) / ((double) i2);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d && Math.abs(size2.height - i2) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < dAbs) {
                    size = size3;
                    dAbs = Math.abs(size3.height - i2);
                }
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6868a(Camera camera) {
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (getResources().getConfiguration().orientation != 2) {
            parameters.set("orientation", "portrait");
            camera.setDisplayOrientation(90);
        } else {
            parameters.set("orientation", "landscape");
            camera.setDisplayOrientation(0);
        }
        camera.enableShutterSound(false);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            parameters.setRecordingHint(true);
            if (parameters.isVideoStabilizationSupported()) {
                parameters.setVideoStabilization(true);
            }
            camera.cancelAutoFocus();
        }
        this.f6271y = m6864a(parameters.getSupportedPreviewSizes(), this.f6270x, this.f6269w);
        parameters.setPreviewSize(this.f6271y.width, this.f6271y.height);
        camera.setParameters(parameters);
    }

    /* JADX INFO: renamed from: c */
    public void m6885c() {
        Intent intent = new Intent();
        intent.putExtra("path", this.f6256j);
        Log.e(f6246a, "path: " + this.f6256j);
        intent.setClass(this, PostVideoActivity.class);
        startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_completed /* 2131296719 */:
                m6886d();
                m6885c();
                break;
            case R.id.iv_delete /* 2131296720 */:
                m6887e();
                break;
            case R.id.iv_recorder_pause /* 2131296732 */:
                if (this.f6260n) {
                    m6886d();
                    this.f6264r.m6849b();
                    if (this.f6265s < 5.0f) {
                        Toast.makeText(this, "录制时间小于5秒", 0).show();
                        m6870a(false);
                        this.f6264r.setProgress(0.0f);
                    } else {
                        this.f6249c.stopPreview();
                        this.f6254h.setVisibility(0);
                        this.f6255i.setVisibility(0);
                        this.f6266t.setVisibility(8);
                    }
                }
                m6870a(false);
                break;
            case R.id.iv_recorder_play /* 2131296733 */:
                if (!this.f6260n) {
                    m6882h();
                    this.f6260n = true;
                    this.f6264r.m6848a();
                }
                m6870a(true);
                break;
            case R.id.iv_switch_camera /* 2131296736 */:
                m6880g();
                break;
            case R.id.tv_cancel /* 2131297204 */:
                finish();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6870a(boolean z) {
        if (z) {
            this.f6253g.setVisibility(0);
            this.f6252f.setVisibility(8);
        } else {
            this.f6253g.setVisibility(8);
            this.f6252f.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m6880g() {
        if (this.f6260n) {
            Toast.makeText(this, "视频录制过程中不能切换相机", 0).show();
            return;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (this.f6262p == 1) {
                if (cameraInfo.facing == 1) {
                    this.f6249c.stopPreview();
                    this.f6249c.release();
                    this.f6249c = null;
                    this.f6249c = Camera.open(i);
                    m6868a(this.f6249c);
                    try {
                        this.f6249c.setPreviewDisplay(this.f6261o);
                        this.f6249c.startPreview();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.f6262p = 0;
                    return;
                }
            } else if (cameraInfo.facing == 0) {
                this.f6249c.stopPreview();
                this.f6249c.release();
                this.f6249c = null;
                this.f6249c = Camera.open(i);
                m6868a(this.f6249c);
                try {
                    this.f6249c.setPreviewDisplay(this.f6261o);
                    this.f6249c.startPreview();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.f6262p = 1;
                return;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m6882h() {
        if (this.f6260n) {
            return;
        }
        if (this.f6259m == null) {
            this.f6259m = new MediaRecorder();
        }
        if (this.f6249c != null) {
            this.f6249c.stopPreview();
            this.f6249c.unlock();
            this.f6259m.setCamera(this.f6249c);
        }
        this.f6259m.setOnErrorListener(this);
        this.f6259m.setPreviewDisplay(this.f6261o.getSurface());
        this.f6259m.setAudioSource(1);
        this.f6259m.setVideoSource(1);
        this.f6259m.setOutputFormat(0);
        this.f6259m.setAudioEncoder(3);
        this.f6259m.setVideoEncoder(2);
        this.f6259m.setMaxDuration(20000);
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        this.f6259m.setAudioEncodingBitRate(51200);
        if (camcorderProfile.videoBitRate > 2097152) {
            this.f6259m.setVideoEncodingBitRate(2097152);
        } else {
            this.f6259m.setVideoEncodingBitRate(1048576);
        }
        this.f6259m.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.f6259m.setOrientationHint(90);
        this.f6259m.setVideoSize(this.f6271y.width, this.f6271y.height);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (absolutePath != null) {
            try {
                File file = new File(absolutePath + "/videoRecorder");
                if (!file.exists()) {
                    file.mkdir();
                }
                String str = file + "/" + System.currentTimeMillis() + ".mp4";
                Log.d(f6246a, "startRecorder: " + str);
                this.f6259m.setOutputFile(str);
                this.f6256j = str;
                this.f6259m.prepare();
                this.f6259m.setOnErrorListener(this);
                this.f6259m.start();
                this.f6260n = true;
                m6870a(true);
                this.f6267u = System.currentTimeMillis();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6886d() {
        if (!this.f6260n || this.f6259m == null) {
            return;
        }
        this.f6268v = System.currentTimeMillis();
        if (this.f6268v - this.f6267u < 1000) {
            return;
        }
        this.f6259m.setOnErrorListener(null);
        this.f6259m.setPreviewDisplay(null);
        this.f6259m.stop();
        this.f6259m.reset();
        this.f6259m.release();
        this.f6259m = null;
        this.f6260n = false;
    }

    /* JADX INFO: renamed from: e */
    public void m6887e() {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(8, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.AndroidRecorder.3
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                File file = new File(AndroidRecorder.this.f6256j);
                if (file.exists()) {
                    file.delete();
                }
                AndroidRecorder.this.m6870a(false);
                AndroidRecorder.this.f6264r.setProgress(0.0f);
                AndroidRecorder.this.f6264r.m6849b();
                AndroidRecorder.this.f6266t.setVisibility(0);
            }
        });
        dialogC1860kq.m10130b(getString(R.string.dialog_yes_1));
        dialogC1860kq.m10131c(getString(R.string.dialog_no_1));
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        dialogC1860kq.show();
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        try {
            if (this.f6259m != null) {
                this.f6259m.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
