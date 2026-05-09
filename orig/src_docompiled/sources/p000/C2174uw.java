package p000;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: uw */
/* JADX INFO: compiled from: CameraDevice.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2174uw {

    /* JADX INFO: renamed from: a */
    private Camera f12975a;

    /* JADX INFO: renamed from: c */
    private int f12977c = 0;

    /* JADX INFO: renamed from: d */
    private boolean f12978d = false;

    /* JADX INFO: renamed from: b */
    private Camera.CameraInfo f12976b = new Camera.CameraInfo();

    /* JADX INFO: renamed from: uw$a */
    /* JADX INFO: compiled from: CameraDevice.java */
    static class a {

        /* JADX INFO: renamed from: a */
        public static final C2174uw f12979a = new C2174uw();
    }

    /* JADX INFO: renamed from: a */
    public static C2174uw m11841a() {
        return a.f12979a;
    }

    /* JADX INFO: renamed from: b */
    public static int m11842b() {
        return Camera.getNumberOfCameras();
    }

    /* JADX INFO: renamed from: c */
    public Camera.CameraInfo m11852c() {
        return this.f12976b;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m11850a(int i) {
        int iM11844c = m11844c(i);
        boolean z = false;
        if (iM11844c == -1) {
            C2201vw.f13217f.m12055e("CameraDevice", "can not find the camera by faceID : " + i);
            return false;
        }
        try {
            m11853d();
            this.f12975a = Camera.open(iM11844c);
            if (this.f12975a != null) {
                if (this.f12975a.getParameters() != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            this.f12975a = null;
            C2201vw.f13217f.m12055e("CameraDevice", "failed to open camera " + iM11844c + " faceID is " + i + " : " + e.getMessage());
        }
        if (z) {
            Camera.getCameraInfo(iM11844c, this.f12976b);
            m11843b(m11858i());
            C2201vw.f13217f.m12053c("CameraDevice", "open camera " + iM11844c + " success, faceID is " + i);
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    public synchronized void m11853d() {
        if (this.f12975a != null) {
            this.f12975a.release();
            this.f12975a = null;
            C2201vw.f13217f.m12053c("CameraDevice", "release camera success");
        }
    }

    /* JADX INFO: renamed from: e */
    public int m11854e() {
        Camera.Parameters parametersM11858i = m11858i();
        if (parametersM11858i == null) {
            return 0;
        }
        return parametersM11858i.getPreviewSize().width;
    }

    /* JADX INFO: renamed from: f */
    public int m11855f() {
        Camera.Parameters parametersM11858i = m11858i();
        if (parametersM11858i == null) {
            return 0;
        }
        return parametersM11858i.getPreviewSize().height;
    }

    /* JADX INFO: renamed from: g */
    public int m11856g() {
        return this.f12977c;
    }

    /* JADX INFO: renamed from: h */
    public boolean m11857h() {
        return this.f12976b.facing == 1;
    }

    /* JADX INFO: renamed from: i */
    public synchronized Camera.Parameters m11858i() {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "getParameters failed, camera == null");
            return null;
        }
        return this.f12975a.getParameters();
    }

    /* JADX INFO: renamed from: j */
    public List<int[]> m11859j() {
        Camera.Parameters parametersM11858i = m11858i();
        if (parametersM11858i == null) {
            return null;
        }
        try {
            return parametersM11858i.getSupportedPreviewFpsRange();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            C2201vw.f13217f.m12055e("CameraDevice", "getSupportedPreviewFpsRange() failed");
            return null;
        }
    }

    /* JADX INFO: renamed from: k */
    public List<Camera.Size> m11860k() {
        Camera.Parameters parametersM11858i = m11858i();
        if (parametersM11858i == null) {
            return null;
        }
        return parametersM11858i.getSupportedPreviewSizes();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11847a(Camera.Parameters parameters) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "setParameters failed, camera == null");
            return;
        }
        try {
            this.f12975a.setParameters(parameters);
        } catch (RuntimeException e) {
            e.printStackTrace();
            C2201vw.f13217f.m12055e("CameraDevice", "setParameters failed: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11846a(Camera.AutoFocusMoveCallback autoFocusMoveCallback) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "setAutoFocusMoveCallback failed, camera == null");
        } else {
            this.f12975a.setAutoFocusMoveCallback(autoFocusMoveCallback);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m11851b(int i) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "setDisplayOrientation failed, camera == null");
            return;
        }
        this.f12975a.setDisplayOrientation(i);
        this.f12977c = i;
        C2201vw.f13217f.m12053c("CameraDevice", "setDisplayOrientation: " + i);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11849a(byte[] bArr) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "addCallbackBuffer failed, camera == null");
        } else {
            this.f12975a.addCallbackBuffer(bArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11848a(Camera.PreviewCallback previewCallback) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "setPreviewCallbackWithBuffer failed, camera == null");
        } else {
            this.f12975a.setPreviewCallbackWithBuffer(previewCallback);
        }
    }

    /* JADX INFO: renamed from: l */
    public synchronized void m11861l() {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "startPreview failed, camera == null");
        } else {
            this.f12975a.startPreview();
            C2201vw.f13217f.m12053c("CameraDevice", "startPreview");
        }
    }

    /* JADX INFO: renamed from: m */
    public synchronized void m11862m() {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "stopPreview failed, camera == null");
        } else {
            this.f12975a.stopPreview();
            C2201vw.f13217f.m12053c("CameraDevice", "stopPreview");
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11845a(SurfaceTexture surfaceTexture) {
        if (this.f12975a == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "setPreviewTexture failed, camera == null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                this.f12975a.setPreviewTexture(surfaceTexture);
            } catch (IOException e) {
                e.printStackTrace();
                C2201vw.f13217f.m12054d("CameraDevice", "setPreviewTexture failed " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private int m11844c(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    private void m11843b(Camera.Parameters parameters) {
        if (parameters == null) {
            C2201vw.f13217f.m12054d("CameraDevice", "initializeCapabilities params is null");
        } else {
            this.f12978d = parameters.getSupportedFocusModes().contains("continuous-picture");
        }
    }
}
