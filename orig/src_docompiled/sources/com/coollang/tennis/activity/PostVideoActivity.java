package com.coollang.tennis.activity;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.VideoUPtokenBean;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1888lr;
import p000.C1900mc;
import p000.C1908mg;
import p000.C1912mk;
import p000.C2165un;
import p000.C2168uq;
import p000.DialogC1860kq;
import p000.InterfaceC2166uo;
import p000.InterfaceC2167up;
import p000.ProgressDialogC1809it;
import p000.ajz;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class PostVideoActivity extends BaseActivity implements MediaPlayer.OnCompletionListener, View.OnClickListener, InterfaceC2166uo, InterfaceC2167up {

    /* JADX INFO: renamed from: a */
    C1874ld f6611a;

    /* JADX INFO: renamed from: b */
    C2165un f6612b;

    /* JADX INFO: renamed from: d */
    SurfaceView f6614d;

    /* JADX INFO: renamed from: e */
    MediaPlayer f6615e;

    /* JADX INFO: renamed from: f */
    int f6616f;

    /* JADX INFO: renamed from: g */
    private String f6617g;

    /* JADX INFO: renamed from: h */
    private ImageView f6618h;

    /* JADX INFO: renamed from: i */
    private TextView f6619i;

    /* JADX INFO: renamed from: j */
    private TextView f6620j;

    /* JADX INFO: renamed from: k */
    private TextView f6621k;

    /* JADX INFO: renamed from: l */
    private ProgressDialogC1809it f6622l;

    /* JADX INFO: renamed from: o */
    private String f6625o;

    /* JADX INFO: renamed from: p */
    private String f6626p;

    /* JADX INFO: renamed from: q */
    private EditText f6627q;

    /* JADX INFO: renamed from: r */
    private ImageView f6628r;

    /* JADX INFO: renamed from: s */
    private ImageView f6629s;

    /* JADX INFO: renamed from: t */
    private String f6630t;

    /* JADX INFO: renamed from: u */
    private String f6631u;

    /* JADX INFO: renamed from: v */
    private boolean f6632v;

    /* JADX INFO: renamed from: m */
    private String f6623m = "PostVideoActivity";

    /* JADX INFO: renamed from: n */
    private String f6624n = "http://staticapp.coollang.com";

    /* JADX INFO: renamed from: c */
    long f6613c = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() throws IOException {
        setContentView(R.layout.acitivity_postvideo);
        this.f6617g = getIntent().getExtras().getString("path");
        akd.m1706a().m1719a(this);
        m7075g();
        this.f6611a = new C1874ld();
        this.f6622l = new ProgressDialogC1809it(this, true);
        this.f6627q = (EditText) findViewById(R.id.edittext);
        this.f6620j = (TextView) findViewById(R.id.video_msg);
        this.f6619i = (TextView) findViewById(R.id.video_size);
        this.f6621k = (TextView) findViewById(R.id.post_video);
        this.f6618h = (ImageView) findViewById(R.id.back_recoding);
        this.f6629s = (ImageView) findViewById(R.id.Video_Thumb);
        this.f6628r = (ImageView) findViewById(R.id.paly_video);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f6617g);
        this.f6629s.setImageBitmap(mediaMetadataRetriever.getFrameAtTime());
        this.f6615e = new MediaPlayer();
        this.f6614d = (SurfaceView) findViewById(R.id.surfaceView);
        try {
            this.f6615e.setDataSource(this.f6617g);
            this.f6615e.prepare();
            int duration = this.f6615e.getDuration();
            this.f6620j.setText(C1912mk.m10544d(duration / 1000));
            this.f6615e.reset();
            Log.e(this.f6623m, "time: " + duration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f6614d.getHolder().setType(3);
        this.f6614d.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.coollang.tennis.activity.PostVideoActivity.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
        C1888lr.m10433a(this, new C1888lr.a() { // from class: com.coollang.tennis.activity.PostVideoActivity.2
            @Override // p000.C1888lr.a
            /* JADX INFO: renamed from: a */
            public void mo7084a() {
                PostVideoActivity.this.f6614d.setEnabled(true);
                PostVideoActivity.this.f6628r.setEnabled(true);
            }

            @Override // p000.C1888lr.a
            /* JADX INFO: renamed from: b */
            public void mo7085b() {
                if (PostVideoActivity.this.f6615e != null && PostVideoActivity.this.f6615e.isPlaying()) {
                    PostVideoActivity.this.f6615e.stop();
                    PostVideoActivity.this.f6628r.setVisibility(0);
                }
                PostVideoActivity.this.f6614d.setEnabled(false);
                PostVideoActivity.this.f6628r.setEnabled(false);
            }
        });
        long jM10517a = 0;
        try {
            jM10517a = C1908mg.m10517a(new File(this.f6617g));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f6619i.setText(C1908mg.m10520b(jM10517a));
        this.f6611a.m10245q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6618h.setOnClickListener(this);
        this.f6621k.setOnClickListener(this);
        this.f6627q.setOnClickListener(this);
        this.f6628r.setOnClickListener(this);
        this.f6615e.setOnCompletionListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
    }

    /* JADX INFO: renamed from: g */
    private void m7075g() {
        this.f6612b = new C2165un(this, new C2168uq());
        this.f6612b.m11812a((InterfaceC2166uo) this);
        this.f6612b.m11813a((InterfaceC2167up) this);
    }

    /* JADX INFO: renamed from: c */
    public void m7080c() {
        this.f6622l.show();
    }

    /* JADX INFO: renamed from: d */
    public void m7081d() {
        this.f6622l.dismiss();
    }

    /* JADX INFO: renamed from: h */
    private void m7076h() {
        try {
            this.f6615e.reset();
            this.f6615e.setAudioStreamType(3);
            this.f6615e.setDataSource(this.f6617g);
            this.f6615e.setDisplay(this.f6614d.getHolder());
            this.f6615e.prepare();
            this.f6615e.start();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_recoding) {
            m7082e();
            return;
        }
        if (id == R.id.paly_video) {
            m7076h();
            this.f6628r.setVisibility(8);
            this.f6629s.setVisibility(8);
        } else {
            if (id != R.id.post_video) {
                return;
            }
            if (!String.valueOf(this.f6627q.getText()).equals("")) {
                m7080c();
                m7083f();
            } else {
                Toast.makeText(this, "请输入标题", 0).show();
            }
        }
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 78) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取token服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取token失败");
                    break;
                case 1:
                    VideoUPtokenBean videoUPtokenBean = (VideoUPtokenBean) new Gson().fromJson(c1873lc.f11064a, VideoUPtokenBean.class);
                    C1900mc.m10475c("TAG", "获取token和key成功");
                    if (!this.f6622l.isShowing()) {
                        m7081d();
                    }
                    this.f6631u = videoUPtokenBean.errDesc.token;
                    this.f6630t = videoUPtokenBean.errDesc.key;
                    System.out.println(this.f6617g);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m7082e() {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(9, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.PostVideoActivity.3
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                File file = new File(PostVideoActivity.this.f6617g);
                if (file.exists()) {
                    file.delete();
                }
                PostVideoActivity.this.finish();
            }
        });
        dialogC1860kq.m10130b(getString(R.string.dialog_yes_1));
        dialogC1860kq.m10131c(getString(R.string.dialog_no_1));
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        dialogC1860kq.show();
    }

    /* JADX INFO: renamed from: f */
    public void m7083f() {
        String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/videoRecorder") + "/compressvideo.mp4";
        Log.e(this.f6623m, "path: " + this.f6617g);
        Log.e(this.f6623m, "newpath: " + str);
        ajz.m1684a(this.f6617g, str, new ajz.InterfaceC0173a() { // from class: com.coollang.tennis.activity.PostVideoActivity.4
            @Override // p000.ajz.InterfaceC0173a
            /* JADX INFO: renamed from: c */
            public void mo1688c() {
            }

            @Override // p000.ajz.InterfaceC0173a
            /* JADX INFO: renamed from: a */
            public void mo1685a() {
                Log.e(PostVideoActivity.this.f6623m, "开始压缩");
            }

            @Override // p000.ajz.InterfaceC0173a
            /* JADX INFO: renamed from: b */
            public void mo1687b() {
                PostVideoActivity.this.m7081d();
                PostVideoActivity.this.f6612b.m11811a(PostVideoActivity.this.f6617g, PostVideoActivity.this.f6630t, PostVideoActivity.this.f6631u);
                PostVideoActivity.this.f6614d.setEnabled(false);
                PostVideoActivity.this.m7080c();
            }

            @Override // p000.ajz.InterfaceC0173a
            /* JADX INFO: renamed from: a */
            public void mo1686a(float f) {
                ProgressDialogC1809it.f10365a.setText(((int) f) + "%");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f6615e.isPlaying()) {
            this.f6616f = this.f6615e.getCurrentPosition();
            this.f6615e.stop();
        }
        akd.m1706a().m1721b(this);
    }

    @Override // p000.InterfaceC2166uo
    /* JADX INFO: renamed from: a */
    public void mo7078a(String str, double d) {
        ProgressDialogC1809it.f10365a.setText(((int) (d * 100.0d)) + "%");
        this.f6626p = str;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (JZVideoPlayer.m5816b()) {
            Log.e("TAG", "onBackPressed: ");
        } else {
            super.onBackPressed();
        }
    }

    @Override // p000.InterfaceC2167up
    /* JADX INFO: renamed from: a */
    public void mo7079a(JSONObject jSONObject) {
        Log.e(this.f6623m, "上传成功: " + jSONObject);
        this.f6625o = this.f6624n + "/" + this.f6626p;
        String strValueOf = String.valueOf(this.f6627q.getText());
        Log.e(this.f6623m, "title: " + strValueOf);
        Log.e(this.f6623m, "url: " + this.f6625o);
        this.f6611a.m10230i(strValueOf, this.f6625o);
        this.f6621k.setEnabled(true);
        m7081d();
        Toast.makeText(this, "上传成功", 0).show();
        akd.m1706a().m1722c(new C1873lc("", 88, 0));
        m7732c(2);
    }

    @Override // p000.InterfaceC2167up
    /* JADX INFO: renamed from: a */
    public void mo7077a(int i, String str) {
        Toast.makeText(this, "上传失败", 0).show();
        this.f6621k.setEnabled(true);
        Log.e(this.f6623m, "上传失败i: " + i);
        Log.e(this.f6623m, "上传失败s: " + str);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f6628r.setVisibility(0);
        this.f6632v = false;
    }
}
