package p000;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;
import p000.C2034pt;

/* JADX INFO: renamed from: ps */
/* JADX INFO: compiled from: CameraWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C2033ps {

    /* JADX INFO: renamed from: a */
    private Camera f12210a = null;

    /* JADX INFO: renamed from: b */
    private Camera.Parameters f12211b = null;

    /* JADX INFO: renamed from: a */
    public Camera m11111a() {
        return this.f12210a;
    }

    /* JADX INFO: renamed from: b */
    public void m11114b() throws C2034pt {
        this.f12210a = null;
        try {
            this.f12210a = m11121h();
            if (this.f12210a == null) {
                throw new C2034pt(C2034pt.a.NOCAMERA);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new C2034pt(C2034pt.a.INUSE);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m11116c() throws C2035pu {
        try {
            m11126m();
            m11122i();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new C2035pu();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m11117d() {
        if (m11111a() == null) {
            return;
        }
        m11123j();
    }

    /* JADX INFO: renamed from: a */
    public void m11113a(SurfaceHolder surfaceHolder) throws IOException {
        this.f12210a.setPreviewDisplay(surfaceHolder);
        this.f12210a.startPreview();
    }

    /* JADX INFO: renamed from: e */
    public void m11118e() {
        this.f12210a.stopPreview();
        this.f12210a.setPreviewCallback(null);
    }

    /* JADX INFO: renamed from: a */
    public C2038pv m11112a(int i, int i2) {
        Camera.Size sizeM11110a = m11110a(m11125l(), i, i2);
        if (sizeM11110a == null) {
            C2031pq.m11103b("VideoCapture_CameraWrapper", "Failed to find supported recording size - falling back to requested: " + i + "x" + i2);
            return new C2038pv(i, i2);
        }
        C2031pq.m11102a("VideoCapture_CameraWrapper", "Recording size: " + sizeM11110a.width + "x" + sizeM11110a.height);
        return new C2038pv(sizeM11110a.width, sizeM11110a.height);
    }

    /* JADX INFO: renamed from: f */
    public CamcorderProfile m11119f() {
        if (CamcorderProfile.hasProfile(5)) {
            return CamcorderProfile.get(5);
        }
        if (CamcorderProfile.hasProfile(4)) {
            return CamcorderProfile.get(4);
        }
        return CamcorderProfile.get(1);
    }

    /* JADX INFO: renamed from: b */
    public void m11115b(int i, int i2) {
        Camera.Parameters parametersM11124k = m11124k();
        Camera.Size sizeM11110a = m11110a(parametersM11124k.getSupportedPreviewSizes(), i, i2);
        parametersM11124k.setPreviewSize(sizeM11110a.width, sizeM11110a.height);
        parametersM11124k.setPreviewFormat(17);
        this.f12210a.setParameters(parametersM11124k);
        C2031pq.m11102a("VideoCapture_CameraWrapper", "Preview size: " + sizeM11110a.width + "x" + sizeM11110a.height);
    }

    /* JADX INFO: renamed from: g */
    public void m11120g() {
        Camera.Parameters parametersM11124k = m11124k();
        parametersM11124k.setFocusMode("continuous-video");
        this.f12210a.setParameters(parametersM11124k);
    }

    /* JADX INFO: renamed from: h */
    protected Camera m11121h() {
        return Camera.open(0);
    }

    /* JADX INFO: renamed from: i */
    protected void m11122i() {
        this.f12210a.unlock();
    }

    /* JADX INFO: renamed from: j */
    protected void m11123j() {
        this.f12210a.release();
    }

    /* JADX INFO: renamed from: k */
    protected Camera.Parameters m11124k() {
        return this.f12210a.getParameters();
    }

    /* JADX INFO: renamed from: l */
    protected List<Camera.Size> m11125l() {
        Camera.Parameters parametersM11109n = m11109n();
        if (Build.VERSION.SDK_INT >= 11) {
            return parametersM11109n.getSupportedVideoSizes();
        }
        C2031pq.m11103b("VideoCapture_CameraWrapper", "Using supportedPreviewSizes iso supportedVideoSizes due to API restriction");
        return parametersM11109n.getSupportedPreviewSizes();
    }

    /* JADX INFO: renamed from: m */
    protected void m11126m() {
        this.f12211b = m11124k();
    }

    /* JADX INFO: renamed from: n */
    private Camera.Parameters m11109n() {
        return this.f12211b;
    }

    /* JADX INFO: renamed from: a */
    public Camera.Size m11110a(List<Camera.Size> list, int i, int i2) {
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
}
