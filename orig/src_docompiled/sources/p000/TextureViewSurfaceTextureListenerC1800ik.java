package p000;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import cn.jzvd.JZResizeTextureView;

/* JADX INFO: renamed from: ik */
/* JADX INFO: compiled from: JZMediaManager.java */
/* JADX INFO: loaded from: classes.dex */
public class TextureViewSurfaceTextureListenerC1800ik implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a */
    public static JZResizeTextureView f10336a;

    /* JADX INFO: renamed from: b */
    public static SurfaceTexture f10337b;

    /* JADX INFO: renamed from: c */
    public static Surface f10338c;

    /* JADX INFO: renamed from: d */
    public static TextureViewSurfaceTextureListenerC1800ik f10339d;

    /* JADX INFO: renamed from: f */
    public AbstractC1799ij f10341f;

    /* JADX INFO: renamed from: j */
    public a f10345j;

    /* JADX INFO: renamed from: k */
    public Handler f10346k;

    /* JADX INFO: renamed from: e */
    public int f10340e = -1;

    /* JADX INFO: renamed from: g */
    public int f10342g = 0;

    /* JADX INFO: renamed from: h */
    public int f10343h = 0;

    /* JADX INFO: renamed from: i */
    public HandlerThread f10344i = new HandlerThread("JiaoZiVideoPlayer");

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public TextureViewSurfaceTextureListenerC1800ik() {
        this.f10344i.start();
        this.f10345j = new a(this.f10344i.getLooper());
        this.f10346k = new Handler();
        if (this.f10341f == null) {
            this.f10341f = new C1801il();
        }
    }

    /* JADX INFO: renamed from: a */
    public static TextureViewSurfaceTextureListenerC1800ik m9788a() {
        if (f10339d == null) {
            f10339d = new TextureViewSurfaceTextureListenerC1800ik();
        }
        return f10339d;
    }

    /* JADX INFO: renamed from: a */
    public static void m9791a(Object[] objArr) {
        m9788a().f10341f.f10335b = objArr;
    }

    /* JADX INFO: renamed from: b */
    public static Object m9792b() {
        return m9788a().f10341f.f10334a;
    }

    /* JADX INFO: renamed from: a */
    public static void m9790a(Object obj) {
        m9788a().f10341f.f10334a = obj;
    }

    /* JADX INFO: renamed from: c */
    public static long m9793c() {
        return m9788a().f10341f.mo9786e();
    }

    /* JADX INFO: renamed from: d */
    public static long m9794d() {
        return m9788a().f10341f.mo9787f();
    }

    /* JADX INFO: renamed from: a */
    public static void m9789a(long j) {
        m9788a().f10341f.mo9781a(j);
    }

    /* JADX INFO: renamed from: e */
    public static void m9795e() {
        m9788a().f10341f.mo9784c();
    }

    /* JADX INFO: renamed from: f */
    public static void m9796f() {
        m9788a().f10341f.mo9780a();
    }

    /* JADX INFO: renamed from: g */
    public void m9797g() {
        Message message = new Message();
        message.what = 2;
        this.f10345j.sendMessage(message);
    }

    /* JADX INFO: renamed from: h */
    public void m9798h() {
        m9797g();
        Message message = new Message();
        message.what = 0;
        this.f10345j.sendMessage(message);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i("JiaoZiVideoPlayer", "onSurfaceTextureAvailable [" + C1804io.m9816c().hashCode() + "] ");
        if (f10337b == null) {
            f10337b = surfaceTexture;
            m9798h();
        } else {
            f10336a.setSurfaceTexture(f10337b);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return f10337b == null;
    }

    /* JADX INFO: renamed from: ik$a */
    /* JADX INFO: compiled from: JZMediaManager.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 0) {
                if (i != 2) {
                    return;
                }
                TextureViewSurfaceTextureListenerC1800ik.this.f10341f.mo9785d();
                return;
            }
            TextureViewSurfaceTextureListenerC1800ik.this.f10342g = 0;
            TextureViewSurfaceTextureListenerC1800ik.this.f10343h = 0;
            TextureViewSurfaceTextureListenerC1800ik.this.f10341f.mo9783b();
            if (TextureViewSurfaceTextureListenerC1800ik.f10337b != null) {
                if (TextureViewSurfaceTextureListenerC1800ik.f10338c != null) {
                    TextureViewSurfaceTextureListenerC1800ik.f10338c.release();
                }
                TextureViewSurfaceTextureListenerC1800ik.f10338c = new Surface(TextureViewSurfaceTextureListenerC1800ik.f10337b);
                TextureViewSurfaceTextureListenerC1800ik.this.f10341f.mo9782a(TextureViewSurfaceTextureListenerC1800ik.f10338c);
            }
        }
    }
}
