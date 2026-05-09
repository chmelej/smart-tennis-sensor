package com.coollang.tennis.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.TrainHandResultBean;
import com.coollang.tennis.beans.TrainSendResultBean;
import com.coollang.tennis.beans.TrainUploadBean;
import com.coollang.tennis.fragment.SportMainFragment;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.p011db.model.TimeSignTable;
import com.coollang.tennis.widget.NoScrollViewPager;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.AbstractC1838jv;
import p000.C1808is;
import p000.C1839jw;
import p000.C1853kj;
import p000.C1856km;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1875le;
import p000.C1887lq;
import p000.C1893lw;
import p000.C1900mc;
import p000.C1902me;
import p000.C1913ml;
import p000.C1914mm;
import p000.C1923mv;
import p000.DialogC1860kq;
import p000.ViewOnClickListenerC1883lm;
import p000.ViewOnClickListenerC1884ln;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class TrainOnTimeActivity extends BaseActivity implements View.OnClickListener, AbstractC1838jv.a {

    /* JADX INFO: renamed from: b */
    private RippleView f7049b;

    /* JADX INFO: renamed from: c */
    private RadioGroup f7050c;

    /* JADX INFO: renamed from: d */
    private RippleView f7051d;

    /* JADX INFO: renamed from: e */
    private ImageView f7052e;

    /* JADX INFO: renamed from: f */
    private TextView f7053f;

    /* JADX INFO: renamed from: g */
    private NoScrollViewPager f7054g;

    /* JADX INFO: renamed from: h */
    private View f7055h;

    /* JADX INFO: renamed from: i */
    private ViewOnClickListenerC1883lm f7056i;

    /* JADX INFO: renamed from: j */
    private View f7057j;

    /* JADX INFO: renamed from: k */
    private ViewOnClickListenerC1884ln f7058k;

    /* JADX INFO: renamed from: l */
    private List<View> f7059l;

    /* JADX INFO: renamed from: m */
    private AnimationDrawable f7060m;

    /* JADX INFO: renamed from: o */
    private RunnableC1140a f7062o;

    /* JADX INFO: renamed from: p */
    private Thread f7063p;

    /* JADX INFO: renamed from: q */
    private long f7064q;

    /* JADX INFO: renamed from: r */
    private int f7065r;

    /* JADX INFO: renamed from: s */
    private C1874ld f7066s;

    /* JADX INFO: renamed from: t */
    private Gson f7067t;

    /* JADX INFO: renamed from: u */
    private String f7068u;

    /* JADX INFO: renamed from: v */
    private long f7069v;

    /* JADX INFO: renamed from: w */
    private int f7070w;

    /* JADX INFO: renamed from: x */
    private PopupWindow f7071x;

    /* JADX INFO: renamed from: a */
    private final int f7048a = PointerIconCompat.TYPE_CELL;

    /* JADX INFO: renamed from: n */
    private boolean f7061n = false;

    /* JADX INFO: renamed from: y */
    private Handler f7072y = new Handler() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    if (TrainOnTimeActivity.this.f7071x != null && TrainOnTimeActivity.this.f7071x.isShowing()) {
                        TrainOnTimeActivity.this.f7071x.dismiss();
                    }
                    if (TrainOnTimeActivity.this.f7070w != 1 && TrainOnTimeActivity.this.f7070w != 4) {
                        if (TrainOnTimeActivity.this.f7070w == 2) {
                            ((RadioButton) TrainOnTimeActivity.this.f7050c.findViewById(R.id.rb_send_train)).setChecked(true);
                        } else if (TrainOnTimeActivity.this.f7070w == 3) {
                            ((RadioButton) TrainOnTimeActivity.this.f7050c.findViewById(R.id.rb_hand_train)).setChecked(true);
                        }
                    } else {
                        TrainOnTimeActivity.this.m7733j();
                    }
                    break;
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    byte[] bArr = (byte[]) message.obj;
                    if (bArr != null) {
                        C1893lw.m10456d(bArr);
                        if (bArr[0] == -88 && bArr[1] == 36 && bArr[2] == 1 && C1893lw.m10442a(bArr)) {
                            if (TrainOnTimeActivity.this.f7056i == null || TrainOnTimeActivity.this.f7050c.getCheckedRadioButtonId() != R.id.rb_hand_train) {
                                if (TrainOnTimeActivity.this.f7058k != null && TrainOnTimeActivity.this.f7050c.getCheckedRadioButtonId() == R.id.rb_send_train) {
                                    TrainOnTimeActivity.this.f7058k.m10370a(bArr);
                                    break;
                                }
                            } else {
                                TrainOnTimeActivity.this.f7056i.m10326a(bArr);
                                break;
                            }
                        }
                    }
                    break;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    TrainOnTimeActivity.this.f7066s.m10220f(String.valueOf(TrainOnTimeActivity.this.f7069v));
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_ontime_train);
        m7464g();
        m7465h();
        m7488x();
        m7473m();
    }

    /* JADX INFO: renamed from: g */
    private void m7464g() {
        this.f7049b = (RippleView) findViewById(R.id.leftBtn);
        this.f7050c = (RadioGroup) findViewById(R.id.rg_sport_detail);
        this.f7051d = (RippleView) findViewById(R.id.rightImage);
        this.f7052e = (ImageView) findViewById(R.id.img_connect_on_time);
        this.f7053f = (TextView) findViewById(R.id.tv_re_connecting);
        this.f7054g = (NoScrollViewPager) findViewById(R.id.vp_train_sport);
        this.f7055h = LayoutInflater.from(this).inflate(R.layout.fragment_ontime_hand, (ViewGroup) null);
        this.f7057j = LayoutInflater.from(this).inflate(R.layout.fragment_ontime_send, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: h */
    private void m7465h() {
        if (MyApplication.m7738a().f7401b) {
            m7484t();
        } else {
            m7483s();
        }
        m7485u();
        m7486v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7066s = new C1874ld();
        this.f7067t = new Gson();
        this.f7068u = C1902me.m10480a(this);
        akd.m1706a().m1719a(this);
        m7481q();
        if (C1839jw.f10820a != null) {
            C1839jw.f10820a.m10019a(this);
            C1839jw.m10026a().m10042a(36);
        }
        m7468i();
    }

    /* JADX INFO: renamed from: i */
    private void m7468i() {
        List listFind = DataSupport.where("userid = ?", this.f7068u).find(TimeSignTable.class);
        if (listFind != null && !listFind.isEmpty()) {
            TimeSignTable timeSignTable = (TimeSignTable) listFind.get(0);
            long trainHandTime = timeSignTable.getTrainHandTime();
            this.f7069v = timeSignTable.getTrainSendTime();
            C1900mc.m10474b("timeStemp", "trainTime = " + trainHandTime);
            this.f7066s.m10217e(String.valueOf(trainHandTime));
            return;
        }
        TimeSignTable timeSignTable2 = new TimeSignTable();
        timeSignTable2.setTrainHandTime(0L);
        timeSignTable2.setTrainSendTime(0L);
        timeSignTable2.setUserID(Integer.parseInt(this.f7068u));
        timeSignTable2.save();
        this.f7069v = 0L;
        this.f7066s.m10217e("0");
    }

    /* JADX INFO: renamed from: l */
    private void m7471l() {
        if (this.f7056i != null && this.f7056i.m10328c()) {
            m7489a(1);
        } else if (this.f7058k != null && this.f7058k.m10372c()) {
            m7489a(4);
        } else {
            m7733j();
        }
    }

    /* JADX INFO: renamed from: m */
    private void m7473m() {
        this.f7049b.setOnClickListener(this);
        this.f7051d.setOnClickListener(this);
        this.f7050c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (TrainOnTimeActivity.this.m7487w() || TrainOnTimeActivity.this.f7058k.m10372c() || TrainOnTimeActivity.this.f7056i.m10328c()) {
                    if (TrainOnTimeActivity.this.f7065r == 0) {
                        TrainOnTimeActivity.this.f7065r = 1;
                        if (i == R.id.rb_hand_train) {
                            if (TrainOnTimeActivity.this.f7058k.m10372c()) {
                                TrainOnTimeActivity.this.m7489a(3);
                                ((RadioButton) radioGroup.findViewById(R.id.rb_send_train)).setChecked(true);
                            }
                            ((RadioButton) radioGroup.findViewById(R.id.rb_send_train)).setChecked(true);
                        } else {
                            if (TrainOnTimeActivity.this.f7056i.m10328c()) {
                                TrainOnTimeActivity.this.m7489a(2);
                                ((RadioButton) radioGroup.findViewById(R.id.rb_hand_train)).setChecked(true);
                            }
                            ((RadioButton) radioGroup.findViewById(R.id.rb_hand_train)).setChecked(true);
                        }
                        TrainOnTimeActivity.this.f7065r = 0;
                        return;
                    }
                    return;
                }
                TrainOnTimeActivity.this.f7065r = 0;
                if (i == R.id.rb_hand_train) {
                    if (TrainOnTimeActivity.this.f7058k == null || !TrainOnTimeActivity.this.f7058k.m10372c()) {
                        TrainOnTimeActivity.this.f7054g.setCurrentItem(0);
                        return;
                    } else {
                        TrainOnTimeActivity.this.m7489a(3);
                        ((RadioButton) radioGroup.findViewById(R.id.rb_send_train)).setChecked(true);
                        return;
                    }
                }
                if (TrainOnTimeActivity.this.f7056i == null || !TrainOnTimeActivity.this.f7056i.m10328c()) {
                    TrainOnTimeActivity.this.f7054g.setCurrentItem(1);
                } else {
                    TrainOnTimeActivity.this.m7489a(2);
                    ((RadioButton) radioGroup.findViewById(R.id.rb_hand_train)).setChecked(true);
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.leftBtn) {
            m7471l();
        } else {
            if (id != R.id.rightImage) {
                return;
            }
            if (MyApplication.m7738a().f7401b) {
                m7478o();
            } else {
                m7476n();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7489a(final int i) {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(7, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.5
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
                TrainOnTimeActivity.this.f7070w = i;
                if ((i == 1 || i == 2 || i == 5) && TrainOnTimeActivity.this.f7056i != null && TrainOnTimeActivity.this.f7056i.m10328c()) {
                    TrainOnTimeActivity.this.f7056i.m10329d();
                }
                if ((i == 3 || i == 4 || i == 6) && TrainOnTimeActivity.this.f7058k != null && TrainOnTimeActivity.this.f7058k.m10372c()) {
                    TrainOnTimeActivity.this.f7058k.m10373d();
                }
                if (i == 5 || i == 6) {
                    TrainOnTimeActivity.this.f7072y.sendEmptyMessage(PointerIconCompat.TYPE_CELL);
                    C1902me.m10485a((Context) TrainOnTimeActivity.this, "trainHis", false);
                    C1887lq.m10407a(TrainOnTimeActivity.this);
                }
            }
        });
        dialogC1860kq.m10129a(getString(R.string.train_not_finish));
        dialogC1860kq.m10130b(getString(R.string.continue_train));
        dialogC1860kq.m10131c(getString(R.string.sure_stop_train));
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: n */
    private void m7476n() {
        C1923mv c1923mv = new C1923mv(this);
        c1923mv.m10641a(this);
        C1839jw.m10026a().m10041a(new C1875le() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.6
            @Override // p000.C1875le
            /* JADX INFO: renamed from: a */
            public void mo7382a() {
                MyApplication.m7738a().f7401b = true;
                TrainOnTimeActivity.this.m7484t();
                C1839jw.m10026a().m10044b();
            }
        });
        c1923mv.m10640a();
    }

    /* JADX INFO: renamed from: o */
    private void m7478o() {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(7, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.7
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                C1839jw.f10820a.m10016a();
                C1839jw.f10820a = null;
                MyApplication.m7738a().f7401b = false;
                TrainOnTimeActivity.this.f7061n = true;
                TrainOnTimeActivity.this.m7483s();
            }
        });
        dialogC1860kq.m10129a(getString(R.string.break_connect));
        dialogC1860kq.m10130b(getString(R.string.yes));
        dialogC1860kq.m10131c(getString(R.string.no));
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: p */
    private void m7480p() {
        if (this.f7071x == null || !this.f7071x.isShowing()) {
            View viewM10555a = C1914mm.m10555a(R.layout.progressbar_post_video);
            this.f7071x = new PopupWindow(viewM10555a, -1, -1, true);
            this.f7071x.setTouchable(true);
            this.f7071x.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            ((TextView) viewM10555a.findViewById(R.id.tv_progress)).setText(R.string.saving_data);
            this.f7071x.setBackgroundDrawable(new BitmapDrawable());
            this.f7071x.showAtLocation(getWindow().getDecorView(), 17, 0, 0);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m7491c() {
        this.f7072y.sendEmptyMessage(PointerIconCompat.TYPE_CELL);
    }

    /* JADX INFO: renamed from: q */
    private void m7481q() {
        this.f7062o = new RunnableC1140a();
        this.f7063p = new Thread(this.f7062o);
        this.f7063p.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7454b(int i) {
        Message message = new Message();
        message.what = 1105;
        message.arg1 = i;
        this.f7062o.f7087a.sendMessage(message);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.TrainOnTimeActivity$a */
    public class RunnableC1140a implements MediaPlayer.OnCompletionListener, Runnable {

        /* JADX INFO: renamed from: a */
        public Handler f7087a;

        /* JADX INFO: renamed from: d */
        private MediaPlayer f7090d;

        /* JADX INFO: renamed from: e */
        private ArrayList<Integer> f7091e;

        /* JADX INFO: renamed from: f */
        private ArrayList<Integer> f7092f;

        /* JADX INFO: renamed from: c */
        private String f7089c = "";

        /* JADX INFO: renamed from: g */
        private boolean f7093g = true;

        /* JADX INFO: renamed from: h */
        private List<Integer> f7094h = new ArrayList();

        /* JADX INFO: renamed from: i */
        private int f7095i = 0;

        public RunnableC1140a() {
        }

        /* JADX INFO: renamed from: d */
        static /* synthetic */ int m7507d(RunnableC1140a runnableC1140a) {
            int i = runnableC1140a.f7095i;
            runnableC1140a.f7095i = i + 1;
            return i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            m7504b();
            this.f7087a = new Handler() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 8) {
                        if (i != 1105) {
                            return;
                        }
                        RunnableC1140a.this.f7093g = false;
                        RunnableC1140a.this.f7089c = String.valueOf(message.arg1);
                        RunnableC1140a.this.f7095i = 0;
                        if (!MyApplication.m7738a().m7747g()) {
                            RunnableC1140a.this.m7509e();
                            RunnableC1140a.this.m7500a(RunnableC1140a.this.f7090d, 0);
                            return;
                        } else {
                            RunnableC1140a.this.m7511a();
                            RunnableC1140a.this.m7500a(RunnableC1140a.this.f7090d, 13);
                            return;
                        }
                    }
                    if (MyApplication.m7738a().m7747g()) {
                        if (RunnableC1140a.this.f7095i < RunnableC1140a.this.f7094h.size()) {
                            RunnableC1140a.this.m7500a(RunnableC1140a.this.f7090d, ((Integer) RunnableC1140a.this.f7094h.get(RunnableC1140a.this.f7095i)).intValue());
                            RunnableC1140a.m7507d(RunnableC1140a.this);
                            return;
                        } else {
                            RunnableC1140a.this.f7095i = 0;
                            RunnableC1140a.this.f7093g = true;
                            RunnableC1140a.this.m7500a(RunnableC1140a.this.f7090d, 12);
                            return;
                        }
                    }
                    if (RunnableC1140a.this.f7095i < RunnableC1140a.this.f7094h.size()) {
                        RunnableC1140a.this.m7500a(RunnableC1140a.this.f7090d, ((Integer) RunnableC1140a.this.f7094h.get(0)).intValue());
                        RunnableC1140a.m7507d(RunnableC1140a.this);
                    } else {
                        RunnableC1140a.this.f7095i = 0;
                        RunnableC1140a.this.f7093g = true;
                    }
                }
            };
            Looper.loop();
        }

        /* JADX INFO: renamed from: b */
        private void m7504b() {
            if (MyApplication.m7738a().m7747g()) {
                m7506c();
            } else {
                m7508d();
            }
        }

        /* JADX INFO: renamed from: c */
        private void m7506c() {
            this.f7091e = new ArrayList<>();
            this.f7091e.add(Integer.valueOf(R.raw.zero));
            this.f7091e.add(Integer.valueOf(R.raw.one));
            this.f7091e.add(Integer.valueOf(R.raw.two));
            this.f7091e.add(Integer.valueOf(R.raw.three));
            this.f7091e.add(Integer.valueOf(R.raw.four));
            this.f7091e.add(Integer.valueOf(R.raw.five));
            this.f7091e.add(Integer.valueOf(R.raw.six));
            this.f7091e.add(Integer.valueOf(R.raw.seven));
            this.f7091e.add(Integer.valueOf(R.raw.eight));
            this.f7091e.add(Integer.valueOf(R.raw.nine));
            this.f7091e.add(Integer.valueOf(R.raw.ten));
            this.f7091e.add(Integer.valueOf(R.raw.hundred));
            this.f7091e.add(Integer.valueOf(R.raw.km));
            this.f7091e.add(Integer.valueOf(R.raw.shisu));
            this.f7090d = new MediaPlayer();
            this.f7090d.setOnCompletionListener(this);
        }

        /* JADX INFO: renamed from: d */
        private void m7508d() {
            this.f7092f = new ArrayList<>();
            String packageName = TrainOnTimeActivity.this.getPackageName();
            this.f7092f.add(Integer.valueOf(R.raw.speed));
            for (int i = 1; i < 331; i++) {
                this.f7092f.add(Integer.valueOf(TrainOnTimeActivity.this.getResources().getIdentifier("s_" + i, "raw", packageName)));
            }
            this.f7090d = new MediaPlayer();
            this.f7090d.setOnCompletionListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m7500a(MediaPlayer mediaPlayer, int i) {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd;
            mediaPlayer.reset();
            if (MyApplication.m7738a().m7747g()) {
                assetFileDescriptorOpenRawResourceFd = C1914mm.m10556b().openRawResourceFd(this.f7091e.get(i).intValue());
            } else {
                assetFileDescriptorOpenRawResourceFd = C1914mm.m10556b().openRawResourceFd(this.f7092f.get(i).intValue());
            }
            if (assetFileDescriptorOpenRawResourceFd != null) {
                try {
                    mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    assetFileDescriptorOpenRawResourceFd.close();
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                }
                mediaPlayer.start();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.f7093g) {
                return;
            }
            this.f7087a.sendEmptyMessage(8);
        }

        /* JADX INFO: renamed from: a */
        public void m7511a() {
            this.f7094h.clear();
            if (Integer.parseInt(this.f7089c) > 100 && Integer.parseInt(this.f7089c) % 100 != 0) {
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(0, 1))));
                this.f7094h.add(11);
                if (Integer.parseInt(this.f7089c.substring(1, 2)) != 0) {
                    this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(1, 2))));
                    this.f7094h.add(10);
                } else {
                    this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(1, 2))));
                }
                if (Integer.parseInt(this.f7089c.substring(2)) != 0) {
                    this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(2))));
                    return;
                }
                return;
            }
            if (Integer.parseInt(this.f7089c) % 100 == 0 && Integer.parseInt(this.f7089c) > 99) {
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(0, 1))));
                this.f7094h.add(11);
                return;
            }
            if (Integer.parseInt(this.f7089c) < 100 && Integer.parseInt(this.f7089c) > 10 && Integer.parseInt(this.f7089c) % 10 != 0) {
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(0, 1))));
                this.f7094h.add(10);
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(1))));
            } else if (Integer.parseInt(this.f7089c) % 10 == 0 && Integer.parseInt(this.f7089c) < 100 && Integer.parseInt(this.f7089c) > 9) {
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(0, 1))));
                this.f7094h.add(10);
            } else {
                this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c.substring(0))));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: e */
        public void m7509e() {
            this.f7094h.clear();
            this.f7094h.add(Integer.valueOf(Integer.parseInt(this.f7089c)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        if (C1839jw.f10820a != null) {
            C1839jw.f10820a.m10019a(this);
        }
        this.f7056i.m10327b();
        this.f7058k.m10371b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SportMainFragment.f7597a = true;
        akd.m1706a().m1721b(this);
        C1839jw.m10026a().m10042a(36, 2);
        if (this.f7063p != null) {
            this.f7063p.interrupt();
            this.f7063p = null;
        }
        super.onDestroy();
    }

    @Override // p000.AbstractC1838jv.a
    /* JADX INFO: renamed from: a */
    public void mo7490a(Context context, Intent intent, String str, String str2) {
        String action = intent.getAction();
        if ("com.rfstar.kevin.service.ACTION_GATT_CONNECTED".equals(action)) {
            C1900mc.m10474b("ble", "ACTION_GATT_CONNECTED");
            String strM10480a = C1902me.m10480a(this);
            String strM10487b = C1902me.m10487b(context, C1902me.f11454e, "-1");
            if (strM10487b.startsWith(strM10480a) && strM10487b.endsWith("1")) {
                return;
            }
            new C1874ld().m10228i();
            C1902me.m10484a(context, C1902me.f11454e, strM10480a + "_1");
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED".equals(action)) {
            C1900mc.m10474b("ble", "ACTION_GATT_DISCONNECTED");
            MyApplication.m7738a().f7401b = false;
            if (this.f7061n) {
                m7483s();
                return;
            } else {
                m7482r();
                return;
            }
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
            C1900mc.m10474b("ble", "ACTION_GATT_SERVICES_DISCOVERED");
            if (C1839jw.f10820a != null) {
                TextUtils.isEmpty(C1839jw.f10820a.f10812c.trim());
            }
            if (C1839jw.f10820a != null) {
                C1839jw.f10820a.m10046a(C1853kj.f10919a, C1853kj.f10920b, true);
            }
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    C1839jw.m10026a().m10042a(36);
                }
            }, 1000L);
            m7484t();
            MyApplication.m7738a().f7401b = true;
            C1839jw.m10026a().m10044b();
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE".equals(action)) {
            C1900mc.m10474b("ble", "ACTION_DATA_AVAILABLE");
            if (intent.getStringExtra("com.rfstar.kevin.service.characteristic").contains(C1853kj.f10921c)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("com.rfstar.kevin.service.EXTRA_DATA");
                if (byteArrayExtra.length > 3) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = PointerIconCompat.TYPE_CROSSHAIR;
                    messageObtain.obj = byteArrayExtra;
                    this.f7072y.sendMessage(messageObtain);
                }
            }
        }
    }

    /* JADX INFO: renamed from: r */
    private void m7482r() {
        this.f7052e.setImageResource(R.drawable.device_unconnect_anim);
        this.f7060m = (AnimationDrawable) this.f7052e.getDrawable();
        this.f7060m.start();
        this.f7053f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m7483s() {
        this.f7052e.setImageResource(R.drawable.device_unconnect_anim);
        this.f7060m = (AnimationDrawable) this.f7052e.getDrawable();
        this.f7060m.start();
        this.f7053f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m7484t() {
        this.f7052e.setImageResource(R.drawable.devoice_checked);
        if (this.f7060m != null) {
            this.f7060m.stop();
        }
        this.f7053f.setVisibility(8);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            m7471l();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: renamed from: d */
    public void m7492d() {
        if (MyApplication.m7738a().f7401b) {
            return;
        }
        C1913ml.m10553a(getString(R.string.pls_con_device));
    }

    /* JADX INFO: renamed from: u */
    private void m7485u() {
        this.f7056i = new ViewOnClickListenerC1883lm(this, this.f7055h);
        this.f7056i.m10325a(new ViewOnClickListenerC1883lm.a() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.10
            @Override // p000.ViewOnClickListenerC1883lm.a
            /* JADX INFO: renamed from: a */
            public void mo7495a(int i) {
                TrainOnTimeActivity.this.m7454b(i);
            }
        });
    }

    /* JADX INFO: renamed from: v */
    private void m7486v() {
        this.f7058k = new ViewOnClickListenerC1884ln(this, this.f7057j);
        this.f7058k.m10369a(new ViewOnClickListenerC1884ln.a() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.11
            @Override // p000.ViewOnClickListenerC1884ln.a
            /* JADX INFO: renamed from: a */
            public void mo7496a(int i) {
                TrainOnTimeActivity.this.m7454b(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: w */
    public boolean m7487w() {
        if (System.currentTimeMillis() - this.f7064q < 600) {
            return true;
        }
        this.f7064q = System.currentTimeMillis();
        return false;
    }

    /* JADX INFO: renamed from: x */
    private void m7488x() {
        this.f7059l = new ArrayList();
        this.f7059l.add(this.f7055h);
        this.f7059l.add(this.f7057j);
        this.f7054g.setAdapter(new C1141b());
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.TrainOnTimeActivity$b */
    class C1141b extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private C1141b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return TrainOnTimeActivity.this.f7059l.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) TrainOnTimeActivity.this.f7059l.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) TrainOnTimeActivity.this.f7059l.get(i));
            return TrainOnTimeActivity.this.f7059l.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m7493e() {
        List listFind;
        m7480p();
        if (DataSupport.where("upServer = 0 AND endTimeStemp != 0 AND userId = ? AND type = 0", this.f7068u).count(OnTimeMainTable.class) == 0 || (listFind = DataSupport.where("upServer = 0 AND endTimeStemp != 0 AND userId = ? AND type = 0", this.f7068u).find(OnTimeMainTable.class)) == null || listFind.isEmpty()) {
            return true;
        }
        if (DataSupport.where("trainid = ?", String.valueOf(((OnTimeMainTable) listFind.get(0)).getId())).count(OnTimeDetailTable.class) == 0) {
            DataSupport.delete(OnTimeMainTable.class, ((OnTimeMainTable) listFind.get(0)).getId());
            return m7493e();
        }
        this.f7066s.m10198a(((OnTimeMainTable) listFind.get(0)).getDate(), String.valueOf(((OnTimeMainTable) listFind.get(0)).getStartTimeStemp()), String.valueOf(((OnTimeMainTable) listFind.get(0)).getEndTimeStemp()), String.valueOf(((OnTimeMainTable) listFind.get(0)).getForeTargetSpeed()), String.valueOf(((OnTimeMainTable) listFind.get(0)).getBackTargetSpeed()), String.format("%.02f", Float.valueOf(((OnTimeMainTable) listFind.get(0)).getMaxProgress() / 100.0f)), m7459d(((OnTimeMainTable) listFind.get(0)).getId()), ((OnTimeMainTable) listFind.get(0)).getId());
        return false;
    }

    /* JADX INFO: renamed from: d */
    private ArrayList<String[]> m7459d(int i) {
        Cursor cursorFindBySQL = DataSupport.findBySQL("SELECT * from ontimedetailtable where trainId = ?", String.valueOf(i));
        ArrayList<String[]> arrayList = new ArrayList<>();
        while (cursorFindBySQL.moveToNext()) {
            arrayList.add(new String[]{cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("actiontype")), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("handtype")), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("hitspeed")), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("shottimestemp"))});
        }
        cursorFindBySQL.close();
        return arrayList;
    }

    /* JADX INFO: renamed from: f */
    public boolean m7494f() {
        m7480p();
        if (DataSupport.where("upServer = 0 AND endTimeStemp != 0 AND userId = ? AND type = 1", this.f7068u).count(OnTimeMainTable.class) == 0) {
            return true;
        }
        List listFind = DataSupport.where("upServer = 0 AND endTimeStemp != 0 AND userId = ? AND type = 1", this.f7068u).find(OnTimeMainTable.class);
        if (listFind != null && !listFind.isEmpty()) {
            if (DataSupport.where("trainid = ?", String.valueOf(((OnTimeMainTable) listFind.get(0)).getId())).count(OnTimeDetailTable.class) == 0) {
                DataSupport.delete(OnTimeMainTable.class, ((OnTimeMainTable) listFind.get(0)).getId());
                return m7494f();
            }
            this.f7066s.m10199a(((OnTimeMainTable) listFind.get(0)).getDate(), String.valueOf(((OnTimeMainTable) listFind.get(0)).getStartTimeStemp()), String.valueOf(((OnTimeMainTable) listFind.get(0)).getEndTimeStemp()), String.valueOf(((OnTimeMainTable) listFind.get(0)).getForeTargetSpeed()), m7460e(((OnTimeMainTable) listFind.get(0)).getId()), ((OnTimeMainTable) listFind.get(0)).getId());
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    private List<String[]> m7460e(int i) {
        Cursor cursorFindBySQL = DataSupport.findBySQL("SELECT * from ontimedetailtable where trainId = ?", String.valueOf(i));
        ArrayList arrayList = new ArrayList();
        while (cursorFindBySQL.moveToNext()) {
            arrayList.add(new String[]{cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("actiontype")), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("hitspeed")), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("shottimestemp"))});
        }
        cursorFindBySQL.close();
        return arrayList;
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 26) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7072y.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 1000L);
                    break;
                case 1:
                    C1900mc.m10474b("trainHis", "handTrainUp == " + c1873lc.f11064a);
                    TrainUploadBean trainUploadBean = (TrainUploadBean) this.f7067t.fromJson(c1873lc.f11064a, TrainUploadBean.class);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("trainhandtime", Long.valueOf(trainUploadBean.errDesc.UploadTime));
                    DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues, "userid = ?", this.f7068u);
                    m7449a(c1873lc.f11066c, trainUploadBean.errDesc.f7430ID);
                    if (m7493e()) {
                        this.f7072y.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 1000L);
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 27) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7072y.sendEmptyMessage(PointerIconCompat.TYPE_TEXT);
                    break;
                case 1:
                    C1900mc.m10474b("trainHis", "handTrainGet == " + c1873lc.f11064a);
                    if (c1873lc.f11064a.contains("\"errDesc\":[]")) {
                        this.f7072y.sendEmptyMessage(PointerIconCompat.TYPE_TEXT);
                    } else {
                        C1808is.m9827c(c1873lc.f11064a);
                        if (c1873lc.f11064a.contains("\"Detail\":\"[]\"")) {
                            c1873lc.f11064a = c1873lc.f11064a.replace("\"Detail\":\"[]\"", "\"Detail\":\"[{\"T\":\"0\",\"F\":\"0\",\"D\":\"0\",\"S\":\"0\"}]\"");
                            C1808is.m9827c(c1873lc.f11064a);
                        }
                        c1873lc.f11064a = c1873lc.f11064a.replace("\\\"", "\"");
                        C1808is.m9827c(c1873lc.f11064a);
                        m7450a(c1873lc.f11064a);
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 28) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7072y.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 1000L);
                    break;
                case 1:
                    C1900mc.m10474b("trainHis", "sendTrainUp == " + c1873lc.f11064a);
                    TrainUploadBean trainUploadBean2 = (TrainUploadBean) this.f7067t.fromJson(c1873lc.f11064a, TrainUploadBean.class);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("trainsendtime", Long.valueOf(trainUploadBean2.errDesc.UploadTime));
                    DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues2, "userid = ?", this.f7068u);
                    m7449a(c1873lc.f11066c, trainUploadBean2.errDesc.f7430ID);
                    if (m7494f()) {
                        this.f7072y.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CELL, 1000L);
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 29) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10474b("trainHis", "sendTrainGet == " + c1873lc.f11064a);
                    if (!c1873lc.f11064a.contains("\"errDesc\":[]")) {
                        m7455b(c1873lc.f11064a);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7449a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("upserver", (Integer) 1);
        contentValues.put("serverid", str);
        DataSupport.update(OnTimeMainTable.class, contentValues, i);
    }

    /* JADX INFO: renamed from: a */
    private void m7450a(final String str) {
        new Thread(new Runnable() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TrainHandResultBean trainHandResultBean = (TrainHandResultBean) TrainOnTimeActivity.this.f7067t.fromJson(str, TrainHandResultBean.class);
                if (trainHandResultBean.errDesc != null && !trainHandResultBean.errDesc.isEmpty()) {
                    for (int i = 0; i < trainHandResultBean.errDesc.size(); i++) {
                        int i2 = 1;
                        if (i == trainHandResultBean.errDesc.size() - 1) {
                            long j = trainHandResultBean.errDesc.get(i).UploadTime;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("trainhandtime", Long.valueOf(j));
                            DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues, "userid = ?", TrainOnTimeActivity.this.f7068u);
                        }
                        OnTimeMainTable onTimeMainTable = new OnTimeMainTable(trainHandResultBean.errDesc.get(i).StartTime, trainHandResultBean.errDesc.get(i).EndTime, 0, Integer.parseInt(TrainOnTimeActivity.this.f7068u), trainHandResultBean.errDesc.get(i).Date, trainHandResultBean.errDesc.get(i).ForceTargetTimes, trainHandResultBean.errDesc.get(i).BackTargetTimes, 1, trainHandResultBean.errDesc.get(i).f7421ID);
                        int i3 = (int) (trainHandResultBean.errDesc.get(i).Frequency * 100.0f);
                        if (i3 > 100) {
                            i3 = 100;
                        }
                        onTimeMainTable.setMaxProgress(i3);
                        onTimeMainTable.save();
                        int id = onTimeMainTable.getId();
                        if (trainHandResultBean.errDesc.get(i).Detail == null || trainHandResultBean.errDesc.get(i).Detail.size() <= 0) {
                            i2 = 0;
                        } else {
                            C1856km.m10109a().m10114a(trainHandResultBean.errDesc.get(i).Detail, String.valueOf(id));
                            int size = trainHandResultBean.errDesc.get(i).Detail.size();
                            int i4 = (size * 60) / ((int) (trainHandResultBean.errDesc.get(i).EndTime - trainHandResultBean.errDesc.get(i).StartTime));
                            if (i4 != 0 || size < 1) {
                                i2 = i4;
                            }
                        }
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("hitRate", Integer.valueOf(i2));
                        DataSupport.update(OnTimeMainTable.class, contentValues2, id);
                    }
                }
                TrainOnTimeActivity.this.f7072y.sendEmptyMessage(PointerIconCompat.TYPE_TEXT);
            }
        }).start();
    }

    /* JADX INFO: renamed from: b */
    private void m7455b(final String str) {
        new Thread(new Runnable() { // from class: com.coollang.tennis.activity.TrainOnTimeActivity.3
            @Override // java.lang.Runnable
            public void run() {
                TrainSendResultBean trainSendResultBean = (TrainSendResultBean) TrainOnTimeActivity.this.f7067t.fromJson(str, TrainSendResultBean.class);
                if (trainSendResultBean.errDesc == null || trainSendResultBean.errDesc.isEmpty()) {
                    return;
                }
                for (int i = 0; i < trainSendResultBean.errDesc.size(); i++) {
                    if (i == trainSendResultBean.errDesc.size() - 1) {
                        long j = trainSendResultBean.errDesc.get(i).UploadTime;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("trainsendtime", Long.valueOf(j));
                        DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues, "userid = ?", TrainOnTimeActivity.this.f7068u);
                    }
                    OnTimeMainTable onTimeMainTable = new OnTimeMainTable(trainSendResultBean.errDesc.get(i).StartTime, trainSendResultBean.errDesc.get(i).EndTime, 1, Integer.parseInt(TrainOnTimeActivity.this.f7068u), trainSendResultBean.errDesc.get(i).Date, trainSendResultBean.errDesc.get(i).TargetSpeed, trainSendResultBean.errDesc.get(i).TargetSpeed, 1, trainSendResultBean.errDesc.get(i).f7426ID);
                    onTimeMainTable.save();
                    if (trainSendResultBean.errDesc.get(i).Detail != null && !trainSendResultBean.errDesc.get(i).Detail.isEmpty()) {
                        C1856km.m10109a().m10118b(trainSendResultBean.errDesc.get(i).Detail, String.valueOf(onTimeMainTable.getId()));
                    }
                }
            }
        }).start();
    }
}
