package p000;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: mo */
/* JADX INFO: compiled from: VideoPlayer_native.java */
/* JADX INFO: loaded from: classes.dex */
public class C1916mo implements InterfaceC1915mn {

    /* JADX INFO: renamed from: b */
    private static final String f11509b = "mo";

    /* JADX INFO: renamed from: c */
    private Context f11511c;

    /* JADX INFO: renamed from: d */
    private SurfaceHolder f11512d;

    /* JADX INFO: renamed from: e */
    private SeekBar f11513e;

    /* JADX INFO: renamed from: f */
    private MediaPlayer f11514f;

    /* JADX INFO: renamed from: g */
    private TextView f11515g;

    /* JADX INFO: renamed from: h */
    private TextView f11516h;

    /* JADX INFO: renamed from: i */
    private int f11517i;

    /* JADX INFO: renamed from: j */
    private int f11518j;

    /* JADX INFO: renamed from: k */
    private String f11519k;

    /* JADX INFO: renamed from: l */
    private int f11520l;

    /* JADX INFO: renamed from: m */
    private boolean f11521m = true;

    /* JADX INFO: renamed from: n */
    private Timer f11522n = new Timer();

    /* JADX INFO: renamed from: o */
    private TimerTask f11523o = new TimerTask() { // from class: mo.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C1916mo.this.f11514f == null) {
                return;
            }
            try {
                if (C1916mo.this.f11514f.isPlaying()) {
                    int currentPosition = C1916mo.this.f11514f.getCurrentPosition();
                    int max = C1916mo.this.f11513e.getMax();
                    if (currentPosition != 0) {
                        C1916mo.this.f11510a.sendMessage(C1916mo.this.f11510a.obtainMessage(8, currentPosition, max));
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: a */
    Handler f11510a = new Handler() { // from class: mo.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 8) {
                return;
            }
            int i = message.arg1;
            int i2 = message.arg2;
            int duration = C1916mo.this.f11514f.getDuration();
            C1916mo.this.f11515g.setText(C1908mg.m10518a(i));
            C1916mo.this.f11516h.setText(C1908mg.m10518a(duration));
            if (duration > 0) {
                C1916mo.this.f11513e.setProgress((i * i2) / duration);
            }
            if (C1916mo.this.f11520l == 0 || !C1916mo.this.f11521m) {
                return;
            }
            C1916mo.this.f11514f.seekTo(C1916mo.this.f11520l);
            C1916mo.this.f11513e.setProgress((i2 * C1916mo.this.f11520l) / duration);
            C1916mo.this.f11521m = false;
        }
    };

    /* JADX INFO: renamed from: p */
    private SurfaceHolder.Callback f11524p = new SurfaceHolder.Callback() { // from class: mo.3
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (C1916mo.this.f11514f == null) {
                C1916mo.this.f11514f = new MediaPlayer();
                C1916mo.this.f11514f.setDisplay(C1916mo.this.f11512d);
                C1916mo.this.f11514f.setAudioStreamType(3);
                C1916mo.this.f11514f.setOnBufferingUpdateListener(C1916mo.this.f11525q);
                C1916mo.this.f11514f.setOnPreparedListener(C1916mo.this.f11526r);
                try {
                    C1916mo.this.f11514f.reset();
                    C1916mo.this.f11514f.setDataSource(C1916mo.this.f11519k);
                    C1916mo.this.f11514f.prepareAsync();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (C1916mo.this.f11514f != null) {
                C1916mo.this.f11514f.setDisplay(C1916mo.this.f11512d);
            }
        }
    };

    /* JADX INFO: renamed from: q */
    private MediaPlayer.OnBufferingUpdateListener f11525q = new MediaPlayer.OnBufferingUpdateListener() { // from class: mo.4
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            C1916mo.this.f11513e.setSecondaryProgress(i);
        }
    };

    /* JADX INFO: renamed from: r */
    private MediaPlayer.OnPreparedListener f11526r = new MediaPlayer.OnPreparedListener() { // from class: mo.5
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            C1916mo.this.f11518j = mediaPlayer.getVideoHeight();
            C1916mo.this.f11517i = mediaPlayer.getVideoWidth();
            if (C1916mo.this.f11518j != 0 && C1916mo.this.f11517i != 0) {
                mediaPlayer.start();
            }
            C1900mc.m10474b("VideoPlayer", "OnPreparedListener");
        }
    };

    public C1916mo(SurfaceView surfaceView, SeekBar seekBar, String str, TextView textView, TextView textView2, int i, Context context) {
        Log.v(f11509b, "initialize");
        this.f11511c = context;
        this.f11513e = seekBar;
        this.f11519k = str;
        this.f11515g = textView;
        this.f11516h = textView2;
        this.f11520l = i;
        this.f11512d = surfaceView.getHolder();
        this.f11512d.addCallback(this.f11524p);
        this.f11512d.setType(3);
        this.f11522n.schedule(this.f11523o, 0L, 1000L);
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: a */
    public void mo10560a() {
        this.f11514f.start();
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: b */
    public void mo10562b() {
        this.f11514f.pause();
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: c */
    public void mo10563c() {
        if (this.f11514f != null) {
            this.f11523o.cancel();
            this.f11510a.removeMessages(8);
            this.f11514f.stop();
            this.f11514f.reset();
            this.f11514f.release();
            this.f11514f = null;
        }
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: d */
    public boolean mo10564d() {
        if (this.f11514f == null) {
            return false;
        }
        return this.f11514f.isPlaying();
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: e */
    public int mo10565e() {
        if (this.f11514f == null) {
            return 0;
        }
        return this.f11514f.getDuration();
    }

    @Override // p000.InterfaceC1915mn
    /* JADX INFO: renamed from: a */
    public void mo10561a(int i) {
        this.f11514f.seekTo(i);
    }
}
