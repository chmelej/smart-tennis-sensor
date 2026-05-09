package com.coollang.tennis.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.VideoCaptureView;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import p000.C1842jz;
import p000.C1900mc;
import p000.C2031pq;
import p000.C2032pr;
import p000.C2033ps;
import p000.C2042pz;
import p000.InterfaceC2044qa;
import p000.InterfaceC2046qc;

/* JADX INFO: loaded from: classes.dex */
public class VideoCaptureActivity extends BaseActivity implements InterfaceC2044qa, InterfaceC2046qc {

    /* JADX INFO: renamed from: d */
    private CaptureConfiguration f7161d;

    /* JADX INFO: renamed from: e */
    private VideoCaptureView f7162e;

    /* JADX INFO: renamed from: f */
    private C2042pz f7163f;

    /* JADX INFO: renamed from: g */
    private C1842jz f7164g;

    /* JADX INFO: renamed from: b */
    private boolean f7159b = false;

    /* JADX INFO: renamed from: c */
    private boolean f7160c = true;

    /* JADX INFO: renamed from: a */
    C2032pr f7158a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2031pq.m11101a(this);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_videocapture);
        this.f7164g = C1842jz.m10050a();
        m7542b(bundle);
        this.f7162e = (VideoCaptureView) findViewById(R.id.videocapture_videocaptureview_vcv);
        if (this.f7162e == null) {
            C1900mc.m10474b("VideoCaptureActivity", "mVideoCaptureView == null");
        } else {
            this.f7160c = true;
            m7545l();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.f7160c) {
            this.f7160c = false;
            this.f7163f = new C2042pz(this, this.f7161d, this.f7158a, new C2033ps(), this.f7162e.getPreviewSurfaceHolder());
        }
    }

    /* JADX INFO: renamed from: b */
    private void m7542b(Bundle bundle) {
        this.f7161d = m7557h();
        this.f7159b = m7544c(bundle);
        this.f7158a = m7549a(bundle);
    }

    /* JADX INFO: renamed from: l */
    private void m7545l() {
        this.f7162e.setRecordingButtonInterface(this);
        if (this.f7159b) {
            this.f7162e.m8363a(m7558i());
        } else {
            this.f7162e.m8362a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.f7163f != null) {
            this.f7163f.m11157a((String) null);
        }
        m7548o();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        m7547n();
    }

    @Override // p000.InterfaceC2046qc
    /* JADX INFO: renamed from: c */
    public void mo7552c() {
        this.f7163f.m11158b();
    }

    @Override // p000.InterfaceC2046qc
    /* JADX INFO: renamed from: d */
    public void mo7553d() {
        m7546m();
    }

    @Override // p000.InterfaceC2046qc
    /* JADX INFO: renamed from: e */
    public void mo7554e() {
        m7547n();
    }

    @Override // p000.InterfaceC2044qa
    /* JADX INFO: renamed from: f */
    public void mo7555f() {
        this.f7162e.m8364b();
    }

    @Override // p000.InterfaceC2044qa
    /* JADX INFO: renamed from: a */
    public void mo7550a(String str) {
        if (str != null) {
            Toast.makeText(this, str, 1).show();
        }
        this.f7162e.m8363a(m7558i());
        m7548o();
    }

    @Override // p000.InterfaceC2044qa
    /* JADX INFO: renamed from: g */
    public void mo7556g() {
        this.f7159b = true;
    }

    @Override // p000.InterfaceC2044qa
    /* JADX INFO: renamed from: b */
    public void mo7551b(String str) {
        m7543c(str);
    }

    /* JADX INFO: renamed from: m */
    private void m7546m() {
        Intent intent = new Intent();
        intent.putExtra("com.jmolsmobile.extraoutputfilename", this.f7158a.m11107a());
        intent.putExtra("startTime", this.f7162e.f8837b);
        intent.putExtra("endTime", this.f7162e.f8838c);
        intent.putExtra("is_synchro_data", this.f7162e.f8839d);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: renamed from: n */
    private void m7547n() {
        setResult(0);
        finish();
    }

    /* JADX INFO: renamed from: c */
    private void m7543c(String str) {
        Toast.makeText(getApplicationContext(), "Can't capture video: " + str, 1).show();
        Intent intent = new Intent();
        intent.putExtra("com.jmolsmobile.extraerrormessage", str);
        setResult(753245, intent);
        finish();
    }

    /* JADX INFO: renamed from: o */
    private void m7548o() {
        if (this.f7163f != null) {
            this.f7163f.m11162f();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.jmolsmobile.savedrecordedboolean", this.f7159b);
        bundle.putString("com.jmolsmobile.savedoutputfilename", this.f7158a.m11107a());
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: renamed from: h */
    protected CaptureConfiguration m7557h() {
        CaptureConfiguration captureConfiguration = (CaptureConfiguration) getIntent().getParcelableExtra("com.jmolsmobile.extracaptureconfiguration");
        if (captureConfiguration != null) {
            return captureConfiguration;
        }
        CaptureConfiguration captureConfiguration2 = new CaptureConfiguration();
        C2031pq.m11102a("VideoCapture_Activity", "No captureconfiguration passed - using default configuration");
        return captureConfiguration2;
    }

    /* JADX INFO: renamed from: c */
    private boolean m7544c(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("com.jmolsmobile.savedrecordedboolean", false);
    }

    /* JADX INFO: renamed from: a */
    protected C2032pr m7549a(Bundle bundle) {
        if (bundle != null) {
            return new C2032pr(bundle.getString("com.jmolsmobile.savedoutputfilename"));
        }
        return new C2032pr(getIntent().getStringExtra("com.jmolsmobile.extraoutputfilename"));
    }

    /* JADX INFO: renamed from: i */
    public Bitmap m7558i() {
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f7158a.m11107a(), 2);
        if (bitmapCreateVideoThumbnail == null) {
            C2031pq.m11102a("VideoCapture_Activity", "Failed to generate video preview");
        }
        return bitmapCreateVideoThumbnail;
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            this.f7162e.m8365c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
