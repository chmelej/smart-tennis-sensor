package p000;

import android.view.SurfaceHolder;
import java.io.IOException;

/* JADX INFO: renamed from: px */
/* JADX INFO: compiled from: CapturePreview.java */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceHolderCallbackC2040px implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a */
    public final C2033ps f12251a;

    /* JADX INFO: renamed from: b */
    private boolean f12252b = false;

    /* JADX INFO: renamed from: c */
    private final InterfaceC2041py f12253c;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public SurfaceHolderCallbackC2040px(InterfaceC2041py interfaceC2041py, C2033ps c2033ps, SurfaceHolder surfaceHolder) {
        this.f12253c = interfaceC2041py;
        this.f12251a = c2033ps;
        m11147a(surfaceHolder);
    }

    /* JADX INFO: renamed from: a */
    private void m11147a(SurfaceHolder surfaceHolder) {
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
        surfaceHolder.setFormat(3);
        surfaceHolder.setFormat(4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f12252b) {
            try {
                this.f12251a.m11118e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            this.f12251a.m11115b(i2, i3);
            C2031pq.m11102a("VideoCapture_Preview", "Configured camera for preview in surface of " + i2 + " by " + i3);
            try {
                this.f12251a.m11120g();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                C2031pq.m11102a("VideoCapture_Preview", "AutoFocus not available for preview");
            }
            try {
                this.f12251a.m11113a(surfaceHolder);
                m11149a(true);
            } catch (IOException e3) {
                e3.printStackTrace();
                C2031pq.m11102a("VideoCapture_Preview", "Failed to show preview - unable to connect camera to preview (IOException)");
                this.f12253c.mo11150a();
            } catch (RuntimeException e4) {
                e4.printStackTrace();
                C2031pq.m11102a("VideoCapture_Preview", "Failed to show preview - unable to start camera preview (RuntimeException)");
                this.f12253c.mo11150a();
            }
        } catch (RuntimeException e5) {
            e5.printStackTrace();
            C2031pq.m11102a("VideoCapture_Preview", "Failed to show preview - invalid parameters set to camera preview");
            this.f12253c.mo11150a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11148a() {
        if (this.f12252b) {
            try {
                this.f12251a.m11118e();
                m11149a(false);
            } catch (Exception e) {
                e.printStackTrace();
                C2031pq.m11103b("VideoCapture_Preview", "Failed to clean up preview resources");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m11149a(boolean z) {
        this.f12252b = z;
    }
}
