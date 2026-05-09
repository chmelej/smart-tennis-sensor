package p000;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: renamed from: il */
/* JADX INFO: compiled from: JZMediaSystem.java */
/* JADX INFO: loaded from: classes.dex */
public class C1801il extends AbstractC1799ij implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* JADX INFO: renamed from: c */
    public MediaPlayer f10348c;

    /* JADX INFO: renamed from: d */
    private String f10349d = "JZMediaSystem";

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: a */
    public void mo9780a() {
        Log.e(this.f10349d, "start: ");
        this.f10348c.start();
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: b */
    public void mo9783b() {
        try {
            this.f10348c = new MediaPlayer();
            this.f10348c.setAudioStreamType(3);
            if (this.f10335b.length > 1) {
                this.f10348c.setLooping(((Boolean) this.f10335b[1]).booleanValue());
            }
            this.f10348c.setOnPreparedListener(this);
            this.f10348c.setOnCompletionListener(this);
            this.f10348c.setOnBufferingUpdateListener(this);
            this.f10348c.setScreenOnWhilePlaying(true);
            this.f10348c.setOnSeekCompleteListener(this);
            this.f10348c.setOnErrorListener(this);
            this.f10348c.setOnInfoListener(this);
            this.f10348c.setOnVideoSizeChangedListener(this);
            Method declaredMethod = MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class);
            if (this.f10335b.length > 2) {
                declaredMethod.invoke(this.f10348c, this.f10334a.toString(), this.f10335b[2]);
            } else {
                declaredMethod.invoke(this.f10348c, this.f10334a.toString(), null);
            }
            this.f10348c.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: c */
    public void mo9784c() {
        this.f10348c.pause();
        Log.e(this.f10349d, "pause: ");
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: a */
    public void mo9781a(long j) {
        Log.e(this.f10349d, "seekTo: ");
        this.f10348c.seekTo((int) j);
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: d */
    public void mo9785d() {
        Log.e(this.f10349d, "release");
        if (this.f10348c != null) {
            this.f10348c.release();
        }
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: e */
    public long mo9786e() {
        return this.f10348c.getCurrentPosition();
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: f */
    public long mo9787f() {
        return this.f10348c.getDuration();
    }

    @Override // p000.AbstractC1799ij
    /* JADX INFO: renamed from: a */
    public void mo9782a(Surface surface) {
        Log.e(this.f10349d, "setSurface: ");
        this.f10348c.setSurface(surface);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        Log.e(this.f10349d, "onPrepared: ");
        if (this.f10334a.toString().toLowerCase().contains("mp3")) {
            TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C1804io.m9816c() != null) {
                        C1804io.m9816c().m5836f();
                    }
                }
            });
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Log.e(this.f10349d, "onCompletion: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.2
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    C1804io.m9816c().mo5844n();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
        Log.e(this.f10349d, "onBufferingUpdate: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.3
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    C1804io.m9816c().setBufferProgress(i);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Log.e(this.f10349d, "onSeekComplete: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.4
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    C1804io.m9816c().m5822D();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
        Log.e(this.f10349d, "onError: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.5
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    C1804io.m9816c().m5833b(i, i2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
        Log.e(this.f10349d, "onInfo: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.6
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    if (i == 3) {
                        C1804io.m9816c().m5836f();
                    } else {
                        C1804io.m9816c().m5830a(i, i2);
                    }
                }
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Log.e(this.f10349d, "onVideoSizeChanged: ");
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10342g = i;
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10343h = i2;
        TextureViewSurfaceTextureListenerC1800ik.m9788a().f10346k.post(new Runnable() { // from class: il.7
            @Override // java.lang.Runnable
            public void run() {
                if (C1804io.m9816c() != null) {
                    C1804io.m9816c().m5851u();
                }
            }
        });
    }
}
