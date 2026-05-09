package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;

/* JADX INFO: renamed from: mq */
/* JADX INFO: compiled from: MovieRecorderUtil.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class C1918mq implements MediaRecorder.OnErrorListener {

    /* JADX INFO: renamed from: e */
    private SurfaceView f11536e;

    /* JADX INFO: renamed from: f */
    private SurfaceHolder f11537f;

    /* JADX INFO: renamed from: g */
    private MediaRecorder f11538g;

    /* JADX INFO: renamed from: h */
    private Camera f11539h;

    /* JADX INFO: renamed from: i */
    private Timer f11540i;

    /* JADX INFO: renamed from: l */
    private File f11543l = null;

    /* JADX INFO: renamed from: a */
    int f11532a = -1;

    /* JADX INFO: renamed from: b */
    int f11533b = -1;

    /* JADX INFO: renamed from: c */
    int f11534c = 0;

    /* JADX INFO: renamed from: d */
    Camera.Parameters f11535d = null;

    /* JADX INFO: renamed from: m */
    private int f11544m = 480;

    /* JADX INFO: renamed from: n */
    private int f11545n = 480;

    /* JADX INFO: renamed from: o */
    private int f11546o = 480;

    /* JADX INFO: renamed from: p */
    private int f11547p = 800;

    /* JADX INFO: renamed from: j */
    private int f11541j = 320;

    /* JADX INFO: renamed from: k */
    private int f11542k = 240;

    public C1918mq(Context context, SurfaceView surfaceView) {
        this.f11536e = surfaceView;
        this.f11537f = surfaceView.getHolder();
        this.f11537f.addCallback(new a());
        this.f11537f.setType(3);
    }

    /* JADX INFO: renamed from: mq$a */
    /* JADX INFO: compiled from: MovieRecorderUtil.java */
    class a implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C1918mq.this.m10591a();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            C1918mq.this.m10586f();
        }
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void m10591a() {
        if (this.f11539h != null) {
            m10586f();
        }
        try {
            this.f11539h = Camera.open();
        } catch (Exception e) {
            e.printStackTrace();
            m10586f();
        }
        if (this.f11539h == null) {
            return;
        }
        this.f11535d = this.f11539h.getParameters();
        m10585e();
        this.f11539h.setDisplayOrientation(90);
        try {
            this.f11539h.setPreviewDisplay(this.f11537f);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f11539h.startPreview();
        this.f11539h.unlock();
    }

    /* JADX INFO: renamed from: a */
    public List<Camera.Size> m10590a(Camera camera) {
        return camera.getParameters().getSupportedPreviewSizes();
    }

    /* JADX INFO: renamed from: mq$b */
    /* JADX INFO: compiled from: MovieRecorderUtil.java */
    public class b implements Comparator<Camera.Size> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            if (size.height != size2.height) {
                return size.height - size2.height;
            }
            return size.width - size2.width;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10585e() {
        Camera.Size size;
        List<Camera.Size> listM10590a = m10590a(this.f11539h);
        if (listM10590a != null && listM10590a.size() > 0) {
            Collections.sort(listM10590a, new b());
            if (this.f11533b == -1) {
                size = null;
                boolean z = false;
                for (int i = 0; i < listM10590a.size(); i++) {
                    Camera.Size size2 = listM10590a.get(i);
                    if (size2 != null && size2.width == 640 && size2.height == 480) {
                        size = size2;
                        z = true;
                    }
                }
                if (!z) {
                    int size3 = listM10590a.size() / 2;
                    if (size3 >= listM10590a.size()) {
                        size3 = listM10590a.size() - 1;
                    }
                    size = listM10590a.get(size3);
                }
            } else {
                if (this.f11533b >= listM10590a.size()) {
                    this.f11533b = listM10590a.size() - 1;
                }
                size = listM10590a.get(this.f11533b);
            }
            if (size != null) {
                this.f11544m = size.width;
                this.f11546o = size.height;
                this.f11535d.setPreviewSize(this.f11544m, this.f11546o);
            }
        }
        this.f11539h.setParameters(this.f11535d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m10586f() {
        if (this.f11539h != null) {
            this.f11539h.setPreviewCallback(null);
            this.f11539h.stopPreview();
            this.f11539h.lock();
            this.f11539h.release();
            this.f11539h = null;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m10587g() {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "zlwq/video/");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            this.f11543l = File.createTempFile(System.currentTimeMillis() + "", ".mp4", file);
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: h */
    private void m10588h() throws IOException {
        this.f11538g = new MediaRecorder();
        this.f11538g.reset();
        if (this.f11539h != null) {
            this.f11538g.setCamera(this.f11539h);
        }
        this.f11538g.setOnErrorListener(this);
        this.f11538g.setPreviewDisplay(this.f11537f.getSurface());
        this.f11538g.setVideoSource(1);
        this.f11538g.setAudioSource(1);
        this.f11538g.setOutputFormat(2);
        this.f11538g.setAudioEncoder(3);
        this.f11538g.setVideoSize(this.f11541j, this.f11542k);
        this.f11538g.setVideoEncodingBitRate(921600);
        this.f11538g.setVideoEncoder(3);
        this.f11538g.setOutputFile(this.f11543l.getAbsolutePath());
        this.f11538g.prepare();
        try {
            this.f11538g.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10592b() {
        m10587g();
        try {
            m10588h();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10593c() {
        m10594d();
        m10589i();
        m10586f();
    }

    /* JADX INFO: renamed from: d */
    public void m10594d() {
        if (this.f11540i != null) {
            this.f11540i.cancel();
            this.f11540i = null;
        }
        if (this.f11538g != null) {
            this.f11538g.setOnErrorListener(null);
            try {
                this.f11538g.stop();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f11538g.setPreviewDisplay(null);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m10589i() {
        if (this.f11538g != null) {
            this.f11538g.setOnErrorListener(null);
            try {
                this.f11538g.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f11538g = null;
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        if (mediaRecorder != null) {
            try {
                mediaRecorder.reset();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
