package p000;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p000.C2155ud;

/* JADX INFO: renamed from: ux */
/* JADX INFO: compiled from: CameraManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2175ux implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {

    /* JADX INFO: renamed from: a */
    private Context f12980a;

    /* JADX INFO: renamed from: b */
    private InterfaceC2154uc f12981b;

    /* JADX INFO: renamed from: c */
    private InterfaceC2153ub f12982c;

    /* JADX INFO: renamed from: d */
    private C2155ud f12983d;

    /* JADX INFO: renamed from: e */
    private int f12984e = -1;

    /* JADX INFO: renamed from: f */
    private int f12985f;

    /* JADX INFO: renamed from: g */
    private int f12986g;

    /* JADX INFO: renamed from: h */
    private int f12987h;

    /* JADX INFO: renamed from: i */
    private int f12988i;

    /* JADX INFO: renamed from: j */
    private int f12989j;

    /* JADX INFO: renamed from: k */
    private C2179va f12990k;

    /* JADX INFO: renamed from: l */
    private a f12991l;

    /* JADX INFO: renamed from: m */
    private InterfaceC2159uh f12992m;

    /* JADX INFO: renamed from: n */
    private List<Float> f12993n;

    /* JADX INFO: renamed from: ux$a */
    /* JADX INFO: compiled from: CameraManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11874a(int i, int i2, int i3, int i4);
    }

    public C2175ux(Context context, C2155ud c2155ud) {
        this.f12985f = 1;
        this.f12980a = context;
        this.f12983d = c2155ud;
        this.f12985f = this.f12983d.m11758a().ordinal();
        C2201vw.f13217f.m12053c("CameraManager", "CameraManager created !");
    }

    /* JADX INFO: renamed from: a */
    public void m11869a(a aVar) {
        this.f12991l = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m11868a(InterfaceC2159uh interfaceC2159uh) {
        this.f12992m = interfaceC2159uh;
        if (this.f12990k != null) {
            this.f12990k.m11894a(interfaceC2159uh);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m11870a(SurfaceTexture surfaceTexture) {
        C2201vw.f13217f.m12053c("CameraManager", "resume +");
        if (!m11865d()) {
            return false;
        }
        surfaceTexture.setOnFrameAvailableListener(this);
        C2174uw.m11841a().m11845a(surfaceTexture);
        C2174uw.m11841a().m11861l();
        C2201vw.f13217f.m12053c("CameraManager", "resume -");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m11867a(int i, int i2) {
        Camera.Parameters parametersM11858i = C2174uw.m11841a().m11858i();
        if (parametersM11858i != null) {
            this.f12990k = new C2179va(this.f12980a, parametersM11858i.getFocusMode(), i, i2);
            this.f12990k.m11894a(this.f12992m);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11866a() {
        C2201vw.f13217f.m12053c("CameraManager", "pause +");
        C2174uw.m11841a().m11862m();
        C2174uw.m11841a().m11853d();
        C2201vw.f13217f.m12053c("CameraManager", "pause -");
    }

    /* JADX INFO: renamed from: b */
    public void m11871b() {
        C2201vw.f13217f.m12053c("CameraManager", "destroy");
    }

    /* JADX INFO: renamed from: c */
    public void m11872c() {
        C2155ud.a aVar;
        C2201vw.f13217f.m12053c("CameraManager", "switchCameraId +");
        int iM11842b = C2174uw.m11842b();
        if (iM11842b < 2) {
            C2201vw.f13217f.m12055e("CameraManager", "failed to switch camera, the phone only has one camera !");
            return;
        }
        this.f12985f = (this.f12985f + 1) % iM11842b;
        if (this.f12985f == 0) {
            aVar = C2155ud.a.CAMERA_FACING_BACK;
        } else if (this.f12985f == 1) {
            aVar = C2155ud.a.CAMERA_FACING_FRONT;
        } else {
            aVar = C2155ud.a.CAMERA_FACING_3RD;
        }
        this.f12983d.m11759a(aVar);
        this.f12993n = null;
        C2201vw.f13217f.m12053c("CameraManager", "switchCameraId -");
    }

    /* JADX INFO: renamed from: d */
    private boolean m11865d() {
        Camera.Size size;
        int i;
        C2201vw.f13217f.m12053c("CameraManager", "setupCamera +");
        if (!C2204vz.m12071a(this.f12980a)) {
            C2201vw.f13217f.m12055e("CameraManager", "failed, No camera hardware !");
            return false;
        }
        if (!C2174uw.m11841a().m11850a(this.f12985f)) {
            return false;
        }
        Camera.Parameters parametersM11858i = C2174uw.m11841a().m11858i();
        if (parametersM11858i == null) {
            C2201vw.f13217f.m12055e("CameraManager", "failed to get camera params");
            return false;
        }
        List<Integer> supportedPreviewFormats = parametersM11858i.getSupportedPreviewFormats();
        C2201vw.f13217f.m12053c("CameraManager", "supported camera preview formats: " + supportedPreviewFormats.size());
        Iterator<Integer> it = supportedPreviewFormats.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().intValue() == 17) {
                parametersM11858i.setPreviewFormat(17);
                C2201vw.f13217f.m12053c("CameraManager", "set camera preview format NV21");
                this.f12984e = C2160ui.f12901b;
                break;
            }
        }
        List<int[]> listM11859j = C2174uw.m11841a().m11859j();
        String str = null;
        int[] iArrM11752b = (listM11859j == null || this.f12982c == null) ? null : this.f12982c.m11752b(listM11859j);
        if (iArrM11752b != null && iArrM11752b.length == 2) {
            parametersM11858i.setPreviewFpsRange(iArrM11752b[0], iArrM11752b[1]);
            C2201vw.f13217f.m12053c("CameraManager", "set camera preview fps: " + iArrM11752b[0] + "~" + iArrM11752b[1]);
        }
        List<Camera.Size> listM11863a = m11863a(m11864a(C2174uw.m11841a().m11860k(), this.f12983d.m11762b(), this.f12983d.m11763c()));
        if (listM11863a == null || listM11863a.isEmpty()) {
            size = null;
        } else {
            Camera.Size sizeM11751a = this.f12982c != null ? this.f12982c.m11751a(listM11863a) : null;
            size = sizeM11751a == null ? listM11863a.get(listM11863a.size() / 2) : sizeM11751a;
            parametersM11858i.setPreviewSize(size.width, size.height);
            C2201vw.f13217f.m12053c("CameraManager", "set camera preview size: " + size.width + "x" + size.height);
        }
        this.f12986g = size.width;
        this.f12987h = size.height;
        List<String> supportedFocusModes = parametersM11858i.getSupportedFocusModes();
        if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
            if (this.f12982c != null) {
                String strM11753c = this.f12982c.m11753c(supportedFocusModes);
                if (supportedFocusModes.contains(strM11753c)) {
                    str = strM11753c;
                } else {
                    C2201vw.f13217f.m12053c("CameraManager", "no such focus mode exists in this camera");
                }
            }
            if (str == null) {
                str = supportedFocusModes.contains("continuous-video") ? "continuous-video" : supportedFocusModes.get(0);
            }
            parametersM11858i.setFocusMode(str);
            C2201vw.f13217f.m12053c("CameraManager", "set focus mode: " + str);
        }
        int iM12074c = C2204vz.m12074c(this.f12980a);
        Camera.CameraInfo cameraInfoM11852c = C2174uw.m11841a().m11852c();
        if (this.f12985f == 1) {
            i = (360 - ((cameraInfoM11852c.orientation + iM12074c) % 360)) % 360;
        } else {
            i = ((cameraInfoM11852c.orientation - iM12074c) + 360) % 360;
        }
        C2174uw.m11841a().m11851b(i);
        C2201vw.f13217f.m12053c("CameraManager", "set camera display orientation: " + i);
        C2174uw.m11841a().m11847a(parametersM11858i);
        if (this.f12981b != null) {
            int iM11854e = ((C2174uw.m11841a().m11854e() * C2174uw.m11841a().m11855f()) * ImageFormat.getBitsPerPixel(parametersM11858i.getPreviewFormat())) / 8;
            for (int i2 = 0; i2 < 2; i2++) {
                C2174uw.m11841a().m11849a(new byte[iM11854e]);
            }
            C2174uw.m11841a().m11848a(this);
        }
        if (i == 90 || i == 270) {
            this.f12988i = size.height;
            this.f12989j = size.width;
        } else {
            this.f12988i = size.width;
            this.f12989j = size.height;
        }
        C2201vw.f13217f.m12053c("CameraManager", "setupCamera -");
        return true;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (camera == null || bArr == null) {
            return;
        }
        int iM11854e = C2174uw.m11841a().m11854e();
        int iM11855f = C2174uw.m11841a().m11855f();
        if (this.f12981b != null && iM11854e != 0 && iM11855f != 0) {
            this.f12981b.m11754a(bArr, iM11854e, iM11855f, C2174uw.m11841a().m11857h() ? (360 - C2174uw.m11841a().m11856g()) % 360 : C2174uw.m11841a().m11856g(), this.f12984e, System.nanoTime());
        }
        camera.addCallbackBuffer(bArr);
    }

    /* JADX INFO: renamed from: a */
    private List<Camera.Size> m11864a(List<Camera.Size> list, C2155ud.c cVar, C2155ud.b bVar) {
        if (list == null) {
            return null;
        }
        double dM11756b = C2155ud.m11756b(cVar);
        Iterator<Camera.Size> it = list.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            C2201vw.f13217f.m12053c("CameraManager", "size.width:" + next.width + ",size.height:" + next.height);
            if (Math.abs((((double) next.width) / ((double) next.height)) - dM11756b) > 0.05d) {
                it.remove();
            }
        }
        ArrayList arrayList = new ArrayList();
        int iM11757b = C2155ud.m11757b(bVar);
        Iterator<Camera.Size> it2 = list.iterator();
        while (it2.hasNext()) {
            Camera.Size next2 = it2.next();
            if (next2.height != iM11757b) {
                arrayList.add(next2);
                it2.remove();
            }
        }
        for (Camera.Size size : list) {
            C2201vw.f13217f.m12053c("CameraManager", "after filter size.w:" + size.width + ", size.h:" + size.height);
        }
        return list.isEmpty() ? arrayList : list;
    }

    /* JADX INFO: renamed from: a */
    private static List<Camera.Size> m11863a(List<Camera.Size> list) {
        Collections.sort(list, new Comparator<Camera.Size>() { // from class: ux.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Camera.Size size, Camera.Size size2) {
                return (size.width * size.height) - (size2.width * size2.height);
            }
        });
        return list;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        C2201vw.f13217f.m12049a("CameraManager", "onFrameAvailable");
        if (this.f12991l != null) {
            this.f12991l.mo11874a(this.f12986g, this.f12987h, this.f12988i, this.f12989j);
        }
    }
}
