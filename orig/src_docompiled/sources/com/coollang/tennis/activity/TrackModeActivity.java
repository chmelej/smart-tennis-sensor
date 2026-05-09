package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.fragment.SportMainFragment;
import com.coollang.tennis.p011db.model.VideoTable;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.umeng.message.PushAgent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import p000.C1829jm;
import p000.C1839jw;
import p000.C1842jz;
import p000.C1859kp;
import p000.C1875le;
import p000.C1887lq;
import p000.C1895ly;
import p000.C1896lz;
import p000.C1901md;
import p000.C1902me;
import p000.C1914mm;
import p000.C1923mv;
import p000.C1926my;
import p000.C2039pw;
import p000.DialogC1860kq;
import p000.DialogC1867kx;
import p000.ada;

/* JADX INFO: loaded from: classes.dex */
public class TrackModeActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public List<VideoTable> f6958a;

    /* JADX INFO: renamed from: b */
    private NavigateView f6959b;

    /* JADX INFO: renamed from: c */
    private GridView f6960c;

    /* JADX INFO: renamed from: d */
    private LinearLayout f6961d;

    /* JADX INFO: renamed from: e */
    private TextView f6962e;

    /* JADX INFO: renamed from: f */
    private TextView f6963f;

    /* JADX INFO: renamed from: g */
    private String f6964g;

    /* JADX INFO: renamed from: h */
    private C1859kp f6965h;

    /* JADX INFO: renamed from: i */
    private List<String> f6966i;

    /* JADX INFO: renamed from: j */
    private C1829jm f6967j;

    /* JADX INFO: renamed from: l */
    private long f6969l;

    /* JADX INFO: renamed from: m */
    private long f6970m;

    /* JADX INFO: renamed from: n */
    private boolean f6971n;

    /* JADX INFO: renamed from: o */
    private C1842jz f6972o;

    /* JADX INFO: renamed from: q */
    private PopupWindow f6974q;

    /* JADX INFO: renamed from: k */
    private boolean f6968k = false;

    /* JADX INFO: renamed from: p */
    private boolean f6973p = false;

    /* JADX INFO: renamed from: r */
    private File f6975r = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_track_mode);
        PushAgent.getInstance(this).onAppStart();
        m7355c();
        this.f6973p = !C1902me.m10479a().equalsIgnoreCase("T0");
        this.f6965h = new C1859kp();
        this.f6958a = new ArrayList();
        this.f6966i = new ArrayList();
        this.f6972o = C1842jz.m10050a();
        this.f6962e.setOnClickListener(this);
        this.f6963f.setOnClickListener(this);
        if (MyApplication.m7738a().m7748h()) {
            this.f6959b.setRightButtonTextSize(10);
            this.f6959b.setLeftButtonTextSize(10);
            this.f6959b.setTitleTextSize(12);
        }
        this.f6959b.setTitle(C1914mm.m10557b(R.string.track_mode));
        this.f6959b.setRightButtonText(C1914mm.m10557b(R.string.select));
        this.f6959b.setRightButtonBackground((Drawable) null);
        this.f6959b.setRightButtonClicklistner(new View.OnClickListener() { // from class: com.coollang.tennis.activity.TrackModeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TrackModeActivity.this.f6968k) {
                    TrackModeActivity.this.f6959b.setRightButtonText(C1914mm.m10557b(R.string.cancel));
                    TrackModeActivity.this.f6959b.setLeftButtonText(C1914mm.m10557b(R.string.selectAll));
                    TrackModeActivity.this.f6959b.setLeftButtonBackground(0);
                    TrackModeActivity.this.f6968k = true;
                    TrackModeActivity.this.f6966i.clear();
                    TrackModeActivity.this.f6961d.setVisibility(0);
                    TrackModeActivity.this.f6962e.setEnabled(false);
                    TrackModeActivity.this.f6963f.setEnabled(false);
                } else {
                    TrackModeActivity.this.f6959b.setRightButtonText(C1914mm.m10557b(R.string.select));
                    TrackModeActivity.this.f6959b.setLeftButtonText("");
                    TrackModeActivity.this.f6959b.setLeftButtonBackground(R.drawable.ic_button_back);
                    TrackModeActivity.this.f6968k = false;
                    TrackModeActivity.this.f6961d.setVisibility(8);
                }
                TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
            }
        });
        this.f6959b.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrackModeActivity.6
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                if (TrackModeActivity.this.f6968k) {
                    if (TrackModeActivity.this.f6966i.size() < TrackModeActivity.this.f6958a.size()) {
                        TrackModeActivity.this.f6966i.clear();
                        for (int i = 0; i < TrackModeActivity.this.f6958a.size(); i++) {
                            TrackModeActivity.this.f6966i.add(TrackModeActivity.this.f6958a.get(i).getUrl());
                        }
                        TrackModeActivity.this.f6962e.setEnabled(true);
                        TrackModeActivity.this.f6963f.setEnabled(true);
                        TrackModeActivity.this.f6959b.setLeftButtonText(C1914mm.m10557b(R.string.cancelAll));
                    } else {
                        TrackModeActivity.this.f6966i.clear();
                        TrackModeActivity.this.f6962e.setEnabled(false);
                        TrackModeActivity.this.f6963f.setEnabled(false);
                        TrackModeActivity.this.f6959b.setLeftButtonText(C1914mm.m10557b(R.string.selectAll));
                    }
                    TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
                    return;
                }
                TrackModeActivity.this.m7733j();
            }
        });
        this.f6960c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.TrackModeActivity.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = TrackModeActivity.this.f6973p ? i : i - 1;
                if (TrackModeActivity.this.f6968k) {
                    if (i != 0 || TrackModeActivity.this.f6973p) {
                        if (!TrackModeActivity.this.f6966i.contains(TrackModeActivity.this.f6958a.get(i2).getUrl())) {
                            TrackModeActivity.this.f6966i.add(TrackModeActivity.this.f6958a.get(i2).getUrl());
                        } else {
                            TrackModeActivity.this.f6966i.remove(TrackModeActivity.this.f6958a.get(i2).getUrl());
                        }
                        TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
                        if (TrackModeActivity.this.f6966i.size() < TrackModeActivity.this.f6958a.size()) {
                            TrackModeActivity.this.f6959b.setLeftButtonText(C1914mm.m10557b(R.string.selectAll));
                        } else {
                            TrackModeActivity.this.f6959b.setLeftButtonText(C1914mm.m10557b(R.string.cancelAll));
                        }
                    } else {
                        Toast.makeText(TrackModeActivity.this, R.string.can_not_delete_example_video, 0).show();
                    }
                    if (TrackModeActivity.this.f6966i.size() == 0) {
                        TrackModeActivity.this.f6962e.setEnabled(false);
                        TrackModeActivity.this.f6963f.setEnabled(false);
                        return;
                    } else {
                        TrackModeActivity.this.f6962e.setEnabled(true);
                        TrackModeActivity.this.f6963f.setEnabled(true);
                        return;
                    }
                }
                if ((!TrackModeActivity.this.f6973p || i != TrackModeActivity.this.f6958a.size()) && (TrackModeActivity.this.f6973p || i != TrackModeActivity.this.f6958a.size() + 1)) {
                    if (i == 0 && (i != 0 || !TrackModeActivity.this.f6973p)) {
                        if (i != 0 || TrackModeActivity.this.f6973p) {
                            return;
                        }
                        if (C1901md.m10477a()) {
                            if (C1901md.m10478b()) {
                                DialogC1860kq dialogC1860kq = new DialogC1860kq(6, TrackModeActivity.this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.TrackModeActivity.7.1
                                    @Override // p000.DialogC1860kq.a
                                    /* JADX INFO: renamed from: b */
                                    public void mo6889b() {
                                    }

                                    @Override // p000.DialogC1860kq.a
                                    /* JADX INFO: renamed from: a */
                                    public void mo6888a() {
                                        if (C1896lz.m10463a(10001)) {
                                            return;
                                        }
                                        C1887lq.m10412a(TrackModeActivity.this, "http://tennis-10015299.video.myqcloud.com/tennis_example.mp4");
                                    }
                                });
                                dialogC1860kq.requestWindowFeature(1);
                                dialogC1860kq.show();
                                dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                                return;
                            }
                            TrackModeActivity.this.startActivity(new Intent(TrackModeActivity.this, (Class<?>) WebVideoPlayActivity.class));
                            return;
                        }
                        Toast.makeText(TrackModeActivity.this, R.string.net_fail, 0).show();
                        return;
                    }
                    if (TrackModeActivity.this.f6958a.get(i2).isSynchroData()) {
                        VideoPlayActivity.m7579a(TrackModeActivity.this, TrackModeActivity.this.f6958a.get(i2).getUrl(), TrackModeActivity.this.f6958a.get(i2).getPicture(), TrackModeActivity.this.f6958a.get(i2).getStartTime(), TrackModeActivity.this.f6958a.get(i2).getEndTime(), TrackModeActivity.this.f6958a.get(i2).getName());
                        return;
                    } else if (MyApplication.m7738a().f7401b) {
                        TrackModeActivity.this.m7344a(i2);
                        return;
                    } else {
                        Toast.makeText(TrackModeActivity.this, R.string.video_play_failed, 0).show();
                        return;
                    }
                }
                if (MyApplication.m7738a().f7401b) {
                    TrackModeActivity.this.m7364g();
                } else {
                    TrackModeActivity.this.m7360e();
                }
            }
        });
        int width = (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - C1895ly.m10460a(this, 30.0f)) / 2;
        if (this.f6973p) {
            this.f6967j = new C1829jm(this, width, this.f6958a, PointerIconCompat.TYPE_HAND);
        } else {
            this.f6967j = new C1829jm(this, width, this.f6958a, PointerIconCompat.TYPE_CONTEXT_MENU);
        }
        this.f6960c.setAdapter((ListAdapter) this.f6967j);
    }

    /* JADX INFO: renamed from: c */
    private void m7355c() {
        this.f6959b = (NavigateView) findViewById(R.id.navigateView);
        this.f6960c = (GridView) findViewById(R.id.activity_track_mode_gridview);
        this.f6961d = (LinearLayout) findViewById(R.id.activity_track_mode_ll);
        this.f6962e = (TextView) findViewById(R.id.activity_track_mode_tv_backup);
        this.f6963f = (TextView) findViewById(R.id.activity_track_mode_tv_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m7358d() {
        this.f6974q = new PopupWindow(C1914mm.m10555a(R.layout.progressbar_post_video), -1, -1, true);
        this.f6974q.setTouchable(true);
        this.f6974q.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.TrackModeActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6974q.setBackgroundDrawable(new BitmapDrawable());
        this.f6974q.showAtLocation(this.f6962e, 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.coollang.tennis.activity.TrackModeActivity$9] */
    /* JADX INFO: renamed from: a */
    public void m7344a(final int i) {
        this.f6972o.m10055b();
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.TrackModeActivity.9
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                super.onPreExecute();
                TrackModeActivity.this.m7358d();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                TrackModeActivity.this.f6972o.m10056c();
                try {
                    Thread.sleep(3000L);
                    return null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }.execute(new Void[0]);
        this.f6972o.m10054a(new C1842jz.a() { // from class: com.coollang.tennis.activity.TrackModeActivity.10
            @Override // p000.C1842jz.a
            /* JADX INFO: renamed from: a */
            public void mo7381a() {
                TrackModeActivity.this.f6971n = TrackModeActivity.this.f6972o.f10847b;
                TrackModeActivity.this.f6965h.m10125a(TrackModeActivity.this.f6958a.get(i).getId(), TrackModeActivity.this.f6971n);
                if (TrackModeActivity.this.f6974q != null) {
                    TrackModeActivity.this.f6974q.dismiss();
                    if (TrackModeActivity.this.f6972o.f10847b) {
                        VideoPlayActivity.m7579a(TrackModeActivity.this, TrackModeActivity.this.f6958a.get(i).getUrl(), TrackModeActivity.this.f6958a.get(i).getPicture(), TrackModeActivity.this.f6958a.get(i).getStartTime(), TrackModeActivity.this.f6958a.get(i).getEndTime(), TrackModeActivity.this.f6958a.get(i).getName());
                    } else {
                        Toast.makeText(TrackModeActivity.this, R.string.sync_data_fail, 0).show();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m7360e() {
        new DialogC1867kx(this, C1914mm.m10557b(R.string.link_device), "", C1914mm.m10557b(R.string.ok), "", new DialogC1867kx.a() { // from class: com.coollang.tennis.activity.TrackModeActivity.11
            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7195a() {
            }

            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7196a(String str) {
                TrackModeActivity.this.m7362f();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m7362f() {
        C1923mv c1923mv = new C1923mv(this);
        C1839jw.m10026a().m10041a(new C1875le() { // from class: com.coollang.tennis.activity.TrackModeActivity.12
            @Override // p000.C1875le
            /* JADX INFO: renamed from: a */
            public void mo7382a() {
                MyApplication.m7738a().f7401b = true;
                C1839jw.m10026a().m10044b();
                new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.TrackModeActivity.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TrackModeActivity.this.m7364g();
                    }
                }, 1500L);
            }
        });
        c1923mv.m10640a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7364g() {
        CaptureConfiguration captureConfigurationM7367i = m7367i();
        m7365h();
        Intent intent = new Intent(this, (Class<?>) VideoCaptureActivity.class);
        intent.putExtra("com.jmolsmobile.extracaptureconfiguration", captureConfigurationM7367i);
        intent.putExtra("com.jmolsmobile.extraoutputfilename", "");
        startActivityForResult(intent, 101);
    }

    /* JADX INFO: renamed from: h */
    private void m7365h() {
        this.f6964g = "";
        this.f6969l = 0L;
        this.f6970m = 0L;
        this.f6971n = false;
    }

    /* JADX INFO: renamed from: i */
    private CaptureConfiguration m7367i() {
        return new CaptureConfiguration(m7357d(0), m7352b(0), -1, -1);
    }

    /* JADX INFO: renamed from: b */
    private C2039pw.a m7352b(int i) {
        return new C2039pw.a[]{C2039pw.a.HIGH, C2039pw.a.MEDIUM, C2039pw.a.LOW}[i];
    }

    /* JADX INFO: renamed from: d */
    private C2039pw.b m7357d(int i) {
        return new C2039pw.b[]{C2039pw.b.RES_1080P, C2039pw.b.RES_720P, C2039pw.b.RES_480P}[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.TrackModeActivity$13] */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.TrackModeActivity.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                TrackModeActivity.this.f6958a = TrackModeActivity.this.f6965h.m10123a();
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r4) {
                super.onPostExecute(r4);
                TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m7345a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) TrackModeActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.coollang.tennis.activity.TrackModeActivity$2] */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.f6964g = intent.getStringExtra("com.jmolsmobile.extraoutputfilename");
            this.f6969l = intent.getLongExtra("startTime", 0L);
            this.f6970m = intent.getLongExtra("endTime", 0L);
            this.f6971n = intent.getBooleanExtra("is_synchro_data", false);
        }
        if (!TextUtils.isEmpty(this.f6964g)) {
            final Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f6964g, 2);
            new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.TrackModeActivity.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    TrackModeActivity.this.m7380a(bitmapCreateVideoThumbnail);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(Void r2) {
                    super.onPostExecute(r2);
                    if (TrackModeActivity.this.f6975r != null) {
                        TrackModeActivity.this.m7348a(TrackModeActivity.this.f6975r.getAbsolutePath());
                    }
                }
            }.execute(new Void[0]);
        }
        SportMainFragment.f7597a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.TrackModeActivity$3] */
    /* JADX INFO: renamed from: a */
    public void m7348a(final String str) {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.TrackModeActivity.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                Calendar calendar = Calendar.getInstance();
                String str2 = calendar.get(1) + "年" + (calendar.get(2) + 1) + "月" + calendar.get(5) + "日";
                String strM10480a = C1902me.m10480a(TrackModeActivity.this);
                TrackModeActivity.this.f6965h.m10127a(str2, str, "file://" + TrackModeActivity.this.f6964g, "video" + (TrackModeActivity.this.f6958a.size() + 1), TrackModeActivity.this.f6969l, TrackModeActivity.this.f6970m, TrackModeActivity.this.f6971n, strM10480a);
                TrackModeActivity.this.f6965h.m10126a(TrackModeActivity.this.f6969l, TrackModeActivity.this.f6970m, strM10480a);
                TrackModeActivity.this.f6958a.clear();
                TrackModeActivity.this.f6958a = TrackModeActivity.this.f6965h.m10123a();
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r4) {
                super.onPostExecute(r4);
                if (TrackModeActivity.this.f6958a.size() > 0) {
                    TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: a */
    public void m7380a(Bitmap bitmap) {
        String externalStorageState = Environment.getExternalStorageState();
        File file = new File(Environment.getExternalStorageDirectory() + "/zlwq/");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (externalStorageState.equals("mounted")) {
            this.f6975r = new File(Environment.getExternalStorageDirectory() + "/zlwq/", System.currentTimeMillis() + ".jpg");
            try {
                this.f6975r.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(this.f6975r);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_track_mode_tv_delete /* 2131296360 */:
                final C1926my c1926my = new C1926my(this);
                c1926my.m10697a(8);
                c1926my.m10703b(C1914mm.m10557b(R.string.delete_video_title));
                c1926my.m10704c(C1914mm.m10557b(R.string.delete));
                c1926my.m10707d(C1914mm.m10557b(R.string.cancel));
                c1926my.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.TrackModeActivity.4
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.coollang.tennis.activity.TrackModeActivity$4$1] */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.TrackModeActivity.4.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public Void doInBackground(Void... voidArr) {
                                TrackModeActivity.this.f6965h.m10128a(TrackModeActivity.this.f6966i);
                                TrackModeActivity.this.f6958a = TrackModeActivity.this.f6965h.m10123a();
                                return null;
                            }

                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onPostExecute(Void r4) {
                                super.onPostExecute(r4);
                                TrackModeActivity.this.f6966i.clear();
                                TrackModeActivity.this.f6962e.setEnabled(false);
                                TrackModeActivity.this.f6963f.setEnabled(false);
                                TrackModeActivity.this.f6967j.m9988a(TrackModeActivity.this.f6958a, TrackModeActivity.this.f6966i, TrackModeActivity.this.f6968k);
                            }
                        }.execute(new Void[0]);
                        c1926my.m10706d();
                    }
                });
                c1926my.m10702b(new View.OnClickListener() { // from class: com.coollang.tennis.activity.TrackModeActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c1926my.m10706d();
                    }
                });
                c1926my.m10701b();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ada.m301a(this);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        ada.m302b(this);
    }
}
