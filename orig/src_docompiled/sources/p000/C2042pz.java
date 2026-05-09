package p000;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import java.io.IOException;

/* JADX INFO: renamed from: pz */
/* JADX INFO: compiled from: VideoRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public class C2042pz implements MediaRecorder.OnInfoListener, InterfaceC2041py {

    /* JADX INFO: renamed from: a */
    private C2033ps f12254a;

    /* JADX INFO: renamed from: b */
    private final Surface f12255b;

    /* JADX INFO: renamed from: c */
    private SurfaceHolderCallbackC2040px f12256c;

    /* JADX INFO: renamed from: d */
    private final CaptureConfiguration f12257d;

    /* JADX INFO: renamed from: e */
    private final C2032pr f12258e;

    /* JADX INFO: renamed from: f */
    private MediaRecorder f12259f;

    /* JADX INFO: renamed from: g */
    private boolean f12260g = false;

    /* JADX INFO: renamed from: h */
    private final InterfaceC2044qa f12261h;

    public C2042pz(InterfaceC2044qa interfaceC2044qa, CaptureConfiguration captureConfiguration, C2032pr c2032pr, C2033ps c2033ps, SurfaceHolder surfaceHolder) {
        this.f12257d = captureConfiguration;
        this.f12261h = interfaceC2044qa;
        this.f12258e = c2032pr;
        this.f12254a = c2033ps;
        this.f12255b = surfaceHolder.getSurface();
        m11156a(surfaceHolder);
    }

    /* JADX INFO: renamed from: a */
    protected void m11156a(SurfaceHolder surfaceHolder) {
        try {
            this.f12254a.m11114b();
            this.f12256c = new SurfaceHolderCallbackC2040px(this, this.f12254a, surfaceHolder);
        } catch (C2034pt e) {
            e.printStackTrace();
            this.f12261h.mo7551b(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11158b() {
        if (m11160d()) {
            m11157a((String) null);
        } else {
            m11159c();
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m11159c() {
        this.f12260g = false;
        if (m11151g() && m11152h() && m11153i()) {
            this.f12260g = true;
            this.f12261h.mo7555f();
            C2031pq.m11102a("VideoCapture_VideoRecorder", "Successfully started recording - outputfile: " + this.f12258e.m11107a());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11157a(String str) {
        if (m11160d()) {
            try {
                m11161e().stop();
                this.f12261h.mo7556g();
                C2031pq.m11102a("VideoCapture_VideoRecorder", "Successfully stopped recording - outputfile: " + this.f12258e.m11107a());
            } catch (RuntimeException unused) {
                C2031pq.m11102a("VideoCapture_VideoRecorder", "Failed to stop recording");
            }
            this.f12260g = false;
            this.f12261h.mo7550a(str);
        }
    }

    /* JADX INFO: renamed from: g */
    private boolean m11151g() {
        try {
            this.f12254a.m11116c();
            this.f12259f = new MediaRecorder();
            m11155a(m11161e(), this.f12254a.m11111a());
            C2031pq.m11102a("VideoCapture_VideoRecorder", "MediaRecorder successfully initialized");
            return true;
        } catch (C2035pu e) {
            e.printStackTrace();
            this.f12261h.mo7551b("Unable to record video");
            C2031pq.m11103b("VideoCapture_VideoRecorder", "Failed to initialize recorder - " + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m11155a(MediaRecorder mediaRecorder, Camera camera) {
        mediaRecorder.setCamera(camera);
        mediaRecorder.setAudioSource(this.f12257d.m8403g());
        mediaRecorder.setVideoSource(this.f12257d.m8405i());
        CamcorderProfile camcorderProfileM11119f = this.f12254a.m11119f();
        camcorderProfileM11119f.fileFormat = this.f12257d.m8402f();
        camcorderProfileM11119f.duration = this.f12257d.m8400d();
        C2038pv c2038pvM11112a = this.f12254a.m11112a(this.f12257d.m8397a(), this.f12257d.m8398b());
        camcorderProfileM11119f.videoFrameWidth = c2038pvM11112a.f12232a;
        camcorderProfileM11119f.videoFrameHeight = c2038pvM11112a.f12233b;
        camcorderProfileM11119f.videoBitRate = this.f12257d.m8399c();
        camcorderProfileM11119f.audioCodec = this.f12257d.m8404h();
        camcorderProfileM11119f.videoCodec = this.f12257d.m8406j();
        mediaRecorder.setProfile(camcorderProfileM11119f);
        mediaRecorder.setOutputFile(this.f12258e.m11107a());
        try {
            mediaRecorder.setMaxFileSize(this.f12257d.m8401e());
        } catch (IllegalArgumentException unused) {
            C2031pq.m11103b("VideoCapture_VideoRecorder", "Failed to set max filesize - illegal argument: " + this.f12257d.m8401e());
        } catch (RuntimeException unused2) {
            C2031pq.m11103b("VideoCapture_VideoRecorder", "Failed to set max filesize - runtime exception");
        }
        mediaRecorder.setOnInfoListener(this);
    }

    /* JADX INFO: renamed from: h */
    private boolean m11152h() {
        try {
            m11161e().prepare();
            C2031pq.m11102a("VideoCapture_VideoRecorder", "MediaRecorder successfully prepared");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            C2031pq.m11103b("VideoCapture_VideoRecorder", "MediaRecorder preparation failed - " + e.toString());
            return false;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            C2031pq.m11103b("VideoCapture_VideoRecorder", "MediaRecorder preparation failed - " + e2.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: i */
    private boolean m11153i() {
        try {
            m11161e().start();
            C2031pq.m11102a("VideoCapture_VideoRecorder", "MediaRecorder successfully started");
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            C2031pq.m11103b("VideoCapture_VideoRecorder", "MediaRecorder start failed - " + e.toString());
            return false;
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            C2031pq.m11103b("VideoCapture_VideoRecorder", "MediaRecorder start failed - " + e2.toString());
            this.f12261h.mo7551b("Unable to record video with given settings");
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    protected boolean m11160d() {
        return this.f12260g;
    }

    /* JADX INFO: renamed from: e */
    protected MediaRecorder m11161e() {
        return this.f12259f;
    }

    /* JADX INFO: renamed from: j */
    private void m11154j() {
        MediaRecorder mediaRecorderM11161e = m11161e();
        if (mediaRecorderM11161e != null) {
            mediaRecorderM11161e.release();
        }
    }

    /* JADX INFO: renamed from: f */
    public void m11162f() {
        if (this.f12256c != null) {
            this.f12256c.m11148a();
        }
        if (this.f12254a != null) {
            this.f12254a.m11117d();
            this.f12254a = null;
        }
        m11154j();
        C2031pq.m11102a("VideoCapture_VideoRecorder", "Released all resources");
    }

    @Override // p000.InterfaceC2041py
    /* JADX INFO: renamed from: a */
    public void mo11150a() {
        this.f12261h.mo7551b("Unable to show camera preview");
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i != 1) {
            switch (i) {
                case 800:
                    C2031pq.m11102a("VideoCapture_VideoRecorder", "MediaRecorder max duration reached");
                    m11157a("Capture stopped - Max duration reached");
                    break;
                case 801:
                    C2031pq.m11102a("VideoCapture_VideoRecorder", "MediaRecorder max filesize reached");
                    m11157a("Capture stopped - Max file size reached");
                    break;
            }
        }
    }
}
