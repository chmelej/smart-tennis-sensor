package p000;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.hardware.Camera;
import java.util.List;

/* JADX INFO: renamed from: va */
/* JADX INFO: compiled from: FocusManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C2179va {

    /* JADX INFO: renamed from: b */
    private int f13005b;

    /* JADX INFO: renamed from: c */
    private int f13006c;

    /* JADX INFO: renamed from: g */
    private String f13010g;

    /* JADX INFO: renamed from: i */
    private List<Camera.Area> f13012i;

    /* JADX INFO: renamed from: j */
    private List<Camera.Area> f13013j;

    /* JADX INFO: renamed from: k */
    private InterfaceC2159uh f13014k;

    /* JADX INFO: renamed from: a */
    private int f13004a = 0;

    /* JADX INFO: renamed from: d */
    private boolean f13007d = false;

    /* JADX INFO: renamed from: e */
    private boolean f13008e = false;

    /* JADX INFO: renamed from: f */
    private long f13009f = 0;

    /* JADX INFO: renamed from: h */
    private Matrix f13011h = new Matrix();

    /* JADX INFO: renamed from: l */
    private final Camera.AutoFocusCallback f13015l = new Camera.AutoFocusCallback() { // from class: va.1
        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            C2201vw.f13217f.m12053c("FocusManager", "manual focus cost time: " + (System.currentTimeMillis() - C2179va.this.f13009f) + "Ms, result: " + z);
            C2179va.this.f13004a = z ? 2 : 3;
            if (C2179va.this.f13014k != null) {
                C2179va.this.f13014k.m11772a(z);
            }
            C2179va.this.m11893d();
        }
    };

    /* JADX INFO: renamed from: m */
    private final Camera.AutoFocusMoveCallback f13016m = new Camera.AutoFocusMoveCallback() { // from class: va.2
        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
            C2201vw.f13217f.m12053c("FocusManager", "auto focus move: " + z);
            if (C2179va.this.f13014k != null) {
                if (z) {
                    C2179va.this.f13014k.m11771a();
                } else {
                    C2179va.this.f13014k.m11773b();
                }
            }
        }
    };

    public C2179va(Context context, String str, int i, int i2) {
        C2201vw.f13217f.m12053c("FocusManager", "default focus mode: " + str + " preview width: " + i + " preview height: " + i2);
        this.f13010g = str;
        this.f13005b = i;
        this.f13006c = i2;
        m11890b();
        m11891c();
        m11887a(context);
    }

    /* JADX INFO: renamed from: a */
    public void m11894a(InterfaceC2159uh interfaceC2159uh) {
        this.f13014k = interfaceC2159uh;
    }

    /* JADX INFO: renamed from: a */
    private void m11887a(Context context) {
        Matrix matrix = new Matrix();
        C2176uy.m11876a(matrix, C2174uw.m11841a().m11857h(), m11888b(context), this.f13005b, this.f13006c);
        matrix.invert(this.f13011h);
    }

    /* JADX INFO: renamed from: b */
    private int m11888b(Context context) {
        int iM11878b = C2176uy.m11878b(context);
        C2201vw.f13217f.m12053c("FocusManager", "handle setting camera orientation, mCameraInfo.facing:" + C2174uw.m11841a().m11852c().facing + ",degrees:" + iM11878b + ",orientation:" + C2174uw.m11841a().m11852c().orientation);
        if (C2174uw.m11841a().m11857h()) {
            return (360 - ((C2174uw.m11841a().m11852c().orientation + iM11878b) % 360)) % 360;
        }
        return ((C2174uw.m11841a().m11852c().orientation - iM11878b) + 360) % 360;
    }

    @TargetApi(14)
    /* JADX INFO: renamed from: a */
    private void m11886a() {
        Camera.Parameters parametersM11858i = C2174uw.m11841a().m11858i();
        if (parametersM11858i == null) {
            C2201vw.f13217f.m12054d("FocusManager", "param is null while getParameters");
            return;
        }
        if (this.f13007d) {
            parametersM11858i.setFocusAreas(this.f13012i);
        }
        if (this.f13008e) {
            parametersM11858i.setMeteringAreas(this.f13013j);
        }
        parametersM11858i.setFocusMode(m11885a(parametersM11858i));
        C2174uw.m11841a().m11847a(parametersM11858i);
    }

    @TargetApi(14)
    /* JADX INFO: renamed from: b */
    private void m11890b() {
        Camera.Parameters parametersM11858i = C2174uw.m11841a().m11858i();
        if (parametersM11858i == null) {
            C2201vw.f13217f.m12054d("FocusManager", "param is null while getParameters");
        } else {
            this.f13007d = parametersM11858i.getMaxNumFocusAreas() > 0 && C2176uy.m11877a("auto", parametersM11858i.getSupportedFocusModes());
            this.f13008e = parametersM11858i.getMaxNumMeteringAreas() > 0;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11891c() {
        Camera.Parameters parametersM11858i = C2174uw.m11841a().m11858i();
        if (parametersM11858i == null) {
            C2201vw.f13217f.m12054d("FocusManager", "param is null while getParameters");
            return;
        }
        String focusMode = parametersM11858i.getFocusMode();
        if ("continuous-video".equals(focusMode) || "continuous-picture".equals(focusMode)) {
            C2174uw.m11841a().m11846a(this.f13016m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m11893d() {
        this.f13012i = null;
        this.f13013j = null;
        m11886a();
    }

    /* JADX INFO: renamed from: a */
    private String m11885a(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String focusMode = (!this.f13007d || this.f13012i == null) ? this.f13010g : "auto";
        if (!C2176uy.m11877a(focusMode, supportedFocusModes)) {
            focusMode = C2176uy.m11877a("auto", parameters.getSupportedFocusModes()) ? "auto" : parameters.getFocusMode();
        }
        C2201vw.f13217f.m12053c("FocusManager", "selected focus mode:" + focusMode);
        return focusMode;
    }
}
