package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import p000.C1803in;
import p000.C1804io;
import p000.InterfaceC1805ip;
import p000.TextureViewSurfaceTextureListenerC1800ik;

/* JADX INFO: loaded from: classes.dex */
public class JZVideoPlayerStandard extends JZVideoPlayer {

    /* JADX INFO: renamed from: U */
    protected static Timer f5437U;

    /* JADX INFO: renamed from: V */
    public ImageView f5438V;

    /* JADX INFO: renamed from: W */
    public ProgressBar f5439W;

    /* JADX INFO: renamed from: aA */
    InterfaceC1805ip f5440aA;

    /* JADX INFO: renamed from: aB */
    private boolean f5441aB;

    /* JADX INFO: renamed from: aC */
    private BroadcastReceiver f5442aC;

    /* JADX INFO: renamed from: aa */
    public ProgressBar f5443aa;

    /* JADX INFO: renamed from: ab */
    public TextView f5444ab;

    /* JADX INFO: renamed from: ac */
    public ImageView f5445ac;

    /* JADX INFO: renamed from: ad */
    public ImageView f5446ad;

    /* JADX INFO: renamed from: ae */
    public LinearLayout f5447ae;

    /* JADX INFO: renamed from: af */
    public ImageView f5448af;

    /* JADX INFO: renamed from: ag */
    public TextView f5449ag;

    /* JADX INFO: renamed from: ah */
    public TextView f5450ah;

    /* JADX INFO: renamed from: ai */
    public TextView f5451ai;

    /* JADX INFO: renamed from: aj */
    public PopupWindow f5452aj;

    /* JADX INFO: renamed from: ak */
    public TextView f5453ak;

    /* JADX INFO: renamed from: al */
    public LinearLayout f5454al;

    /* JADX INFO: renamed from: am */
    protected C0809a f5455am;

    /* JADX INFO: renamed from: an */
    protected Dialog f5456an;

    /* JADX INFO: renamed from: ao */
    protected ProgressBar f5457ao;

    /* JADX INFO: renamed from: ap */
    protected TextView f5458ap;

    /* JADX INFO: renamed from: aq */
    protected TextView f5459aq;

    /* JADX INFO: renamed from: ar */
    protected ImageView f5460ar;

    /* JADX INFO: renamed from: as */
    protected Dialog f5461as;

    /* JADX INFO: renamed from: at */
    protected ProgressBar f5462at;

    /* JADX INFO: renamed from: au */
    protected TextView f5463au;

    /* JADX INFO: renamed from: av */
    protected ImageView f5464av;

    /* JADX INFO: renamed from: aw */
    protected Dialog f5465aw;

    /* JADX INFO: renamed from: ax */
    protected ProgressBar f5466ax;

    /* JADX INFO: renamed from: ay */
    protected TextView f5467ay;

    /* JADX INFO: renamed from: az */
    public ImageView f5468az;

    public JZVideoPlayerStandard(Context context) {
        super(context);
        this.f5441aB = false;
        this.f5442aC = new BroadcastReceiver() { // from class: cn.jzvd.JZVideoPlayerStandard.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                    if (intExtra < 15) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_10);
                    } else if (intExtra >= 15 && intExtra < 40) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_30);
                    } else if (intExtra >= 40 && intExtra < 60) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_50);
                    } else if (intExtra >= 60 && intExtra < 80) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_70);
                    } else if (intExtra >= 80 && intExtra < 95) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_90);
                    } else if (intExtra >= 95 && intExtra <= 100) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_100);
                    }
                    JZVideoPlayerStandard.this.getContext().unregisterReceiver(JZVideoPlayerStandard.this.f5442aC);
                    JZVideoPlayerStandard.this.f5441aB = false;
                }
            }
        };
    }

    public JZVideoPlayerStandard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5441aB = false;
        this.f5442aC = new BroadcastReceiver() { // from class: cn.jzvd.JZVideoPlayerStandard.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                    if (intExtra < 15) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_10);
                    } else if (intExtra >= 15 && intExtra < 40) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_30);
                    } else if (intExtra >= 40 && intExtra < 60) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_50);
                    } else if (intExtra >= 60 && intExtra < 80) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_70);
                    } else if (intExtra >= 80 && intExtra < 95) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_90);
                    } else if (intExtra >= 95 && intExtra <= 100) {
                        JZVideoPlayerStandard.this.f5448af.setBackgroundResource(R.drawable.jz_battery_level_100);
                    }
                    JZVideoPlayerStandard.this.getContext().unregisterReceiver(JZVideoPlayerStandard.this.f5442aC);
                    JZVideoPlayerStandard.this.f5441aB = false;
                }
            }
        };
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: c */
    public void mo5834c(Context context) {
        super.mo5834c(context);
        this.f5447ae = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.f5439W = (ProgressBar) findViewById(R.id.bottom_progress);
        this.f5444ab = (TextView) findViewById(R.id.title);
        this.f5438V = (ImageView) findViewById(R.id.back);
        this.f5445ac = (ImageView) findViewById(R.id.thumb);
        this.f5443aa = (ProgressBar) findViewById(R.id.loading);
        this.f5446ad = (ImageView) findViewById(R.id.back_tiny);
        this.f5448af = (ImageView) findViewById(R.id.battery_level);
        this.f5449ag = (TextView) findViewById(R.id.video_current_time);
        this.f5450ah = (TextView) findViewById(R.id.replay_text);
        this.f5451ai = (TextView) findViewById(R.id.clarity);
        this.f5453ak = (TextView) findViewById(R.id.retry_btn);
        this.f5454al = (LinearLayout) findViewById(R.id.retry_layout);
        this.f5468az = (ImageView) findViewById(R.id.video_parent_img);
        this.f5445ac.setOnClickListener(this);
        this.f5438V.setOnClickListener(this);
        this.f5446ad.setOnClickListener(this);
        this.f5451ai.setOnClickListener(this);
        this.f5453ak.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: I */
    public void m5859I() {
        m5835e();
    }

    @Override // cn.jzvd.JZVideoPlayer
    public void setUp(Object[] objArr, int i, int i2, Object... objArr2) {
        super.setUp(objArr, i, i2, objArr2);
        if (objArr2.length != 0) {
            this.f5444ab.setText(objArr2[0].toString());
        }
        if (this.f5423o == 2) {
            this.f5428t.setImageResource(R.drawable.jz_shrink);
            this.f5438V.setVisibility(0);
            this.f5446ad.setVisibility(4);
            this.f5447ae.setVisibility(0);
            if (((LinkedHashMap) objArr[0]).size() == 1) {
                this.f5451ai.setVisibility(8);
            } else {
                this.f5451ai.setText(C1803in.m9809b(objArr, this.f5403C));
                this.f5451ai.setVisibility(0);
            }
            m5875c((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        } else if (this.f5423o == 0 || this.f5423o == 1) {
            this.f5428t.setImageResource(R.drawable.jz_enlarge);
            this.f5438V.setVisibility(8);
            this.f5446ad.setVisibility(4);
            m5875c((int) getResources().getDimension(R.dimen.jz_start_button_w_h_normal));
            this.f5447ae.setVisibility(8);
            this.f5451ai.setVisibility(8);
        } else if (this.f5423o == 3) {
            this.f5446ad.setVisibility(0);
            setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
            this.f5447ae.setVisibility(8);
            this.f5451ai.setVisibility(8);
        }
        setSystemTimeAndBattery();
        if (this.f5420T) {
            this.f5420T = false;
            C1804io.m9813a(this);
            m5816b();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5875c(int i) {
        ViewGroup.LayoutParams layoutParams = this.f5426r.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        ViewGroup.LayoutParams layoutParams2 = this.f5443aa.getLayoutParams();
        layoutParams2.height = i;
        layoutParams2.width = i;
    }

    @Override // cn.jzvd.JZVideoPlayer
    public int getLayoutId() {
        return R.layout.jz_layout_standard;
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: g */
    public void mo5837g() {
        super.mo5837g();
        m5862L();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: h */
    public void mo5838h() {
        super.mo5838h();
        Log.e("JiaoZiVideoPlayer", "onStatePreparing: ");
        m5863M();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: a */
    public void mo5831a(int i, long j) {
        super.mo5831a(i, j);
        this.f5443aa.setVisibility(0);
        this.f5426r.setVisibility(4);
    }

    public void setJZpalyinglistenr(InterfaceC1805ip interfaceC1805ip) {
        this.f5440aA = interfaceC1805ip;
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: j */
    public void mo5840j() {
        super.mo5840j();
        if (this.f5440aA != null) {
            this.f5440aA.mo7675a();
        }
        Log.e("JiaoZiVideoPlayer", "onStatePlaying: ");
        m5865O();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: k */
    public void mo5841k() {
        super.mo5841k();
        if (this.f5440aA != null) {
            this.f5440aA.mo7676b();
        }
        Log.e("JiaoZiVideoPlayer", "onStatePause: ");
        m5866P();
        m5872V();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: l */
    public void mo5842l() {
        super.mo5842l();
        Log.e("JiaoZiVideoPlayer", "onStateError: ");
        m5869S();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: m */
    public void mo5843m() {
        super.mo5843m();
        m5868R();
        m5872V();
        this.f5439W.setProgress(100);
        if (this.f5440aA != null) {
            this.f5440aA.mo7677c();
        }
        Log.e("JiaoZiVideoPlayer", "onStateAutoComplete: ");
        Log.e("JiaoZiVideoPlayer", "onStateAutoComplete: 发送广播");
    }

    @Override // cn.jzvd.JZVideoPlayer, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.surface_container) {
            switch (motionEvent.getAction()) {
                case 1:
                    m5871U();
                    if (this.f5414N) {
                        long duration = getDuration();
                        long j = this.f5419S * 100;
                        if (duration == 0) {
                            duration = 1;
                        }
                        this.f5439W.setProgress((int) (j / duration));
                    }
                    if (!this.f5414N && !this.f5413M) {
                        m5829a(102);
                        m5860J();
                    }
                    break;
            }
        } else if (id == R.id.bottom_seek_progress) {
            switch (motionEvent.getAction()) {
                case 0:
                    m5872V();
                    break;
                case 1:
                    m5871U();
                    break;
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // cn.jzvd.JZVideoPlayer, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.thumb) {
            if (this.f5402B == null || C1803in.m9802a(this.f5402B, this.f5403C) == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            if (this.f5422n == 0) {
                if (!C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("file") && !C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("/") && !C1803in.m9806a(getContext()) && !f5394f) {
                    mo5823E();
                    return;
                } else {
                    m5829a(101);
                    m5835e();
                    return;
                }
            }
            if (this.f5422n == 6) {
                m5860J();
                return;
            }
            return;
        }
        if (id == R.id.surface_container) {
            m5871U();
            return;
        }
        if (id == R.id.back) {
            m5816b();
            return;
        }
        if (id == R.id.back_tiny) {
            if (C1804io.m9812a().f5423o == 1) {
                m5817c();
                return;
            } else {
                m5816b();
                return;
            }
        }
        if (id == R.id.clarity) {
            final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.jz_layout_clarity, (ViewGroup) null);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.jzvd.JZVideoPlayerStandard.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    JZVideoPlayerStandard.this.mo5831a(((Integer) view2.getTag()).intValue(), JZVideoPlayerStandard.this.getCurrentPositionWhenPlaying());
                    JZVideoPlayerStandard.this.f5451ai.setText(C1803in.m9809b(JZVideoPlayerStandard.this.f5402B, JZVideoPlayerStandard.this.f5403C));
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        if (i == JZVideoPlayerStandard.this.f5403C) {
                            ((TextView) linearLayout.getChildAt(i)).setTextColor(Color.parseColor("#fff85959"));
                        } else {
                            ((TextView) linearLayout.getChildAt(i)).setTextColor(Color.parseColor("#ffffff"));
                        }
                    }
                    if (JZVideoPlayerStandard.this.f5452aj != null) {
                        JZVideoPlayerStandard.this.f5452aj.dismiss();
                    }
                }
            };
            for (int i = 0; i < ((LinkedHashMap) this.f5402B[0]).size(); i++) {
                String strM9809b = C1803in.m9809b(this.f5402B, i);
                TextView textView = (TextView) View.inflate(getContext(), R.layout.jz_layout_clarity_item, null);
                textView.setText(strM9809b);
                textView.setTag(Integer.valueOf(i));
                linearLayout.addView(textView, i);
                textView.setOnClickListener(onClickListener);
                if (i == this.f5403C) {
                    textView.setTextColor(Color.parseColor("#fff85959"));
                }
            }
            this.f5452aj = new PopupWindow((View) linearLayout, -2, -2, true);
            this.f5452aj.setContentView(linearLayout);
            this.f5452aj.showAsDropDown(this.f5451ai);
            linearLayout.measure(0, 0);
            this.f5452aj.update(this.f5451ai, -40, 46, Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
            return;
        }
        if (id == R.id.retry_btn) {
            if (this.f5402B == null || C1803in.m9802a(this.f5402B, this.f5403C) == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            if (!C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("file") && !C1803in.m9802a(this.f5402B, this.f5403C).toString().startsWith("/") && !C1803in.m9806a(getContext()) && !f5394f) {
                mo5823E();
                return;
            }
            m5846p();
            m5847q();
            TextureViewSurfaceTextureListenerC1800ik.m9791a(this.f5402B);
            TextureViewSurfaceTextureListenerC1800ik.m9790a(C1803in.m9802a(this.f5402B, this.f5403C));
            mo5838h();
            m5829a(1);
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: E */
    public void mo5823E() {
        super.mo5823E();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: cn.jzvd.JZVideoPlayerStandard.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                JZVideoPlayerStandard.this.m5829a(103);
                JZVideoPlayerStandard.this.m5835e();
                JZVideoPlayer.f5394f = true;
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: cn.jzvd.JZVideoPlayerStandard.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                JZVideoPlayerStandard.this.m5850t();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.jzvd.JZVideoPlayerStandard.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // cn.jzvd.JZVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        m5872V();
        Log.e("JiaoZiVideoPlayer", "onStartTrackingTouch: ");
    }

    @Override // cn.jzvd.JZVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        if (this.f5422n == 3) {
            m5873W();
        } else {
            m5871U();
        }
        Log.e("JiaoZiVideoPlayer", "onStopTrackingTouch: ");
    }

    /* JADX INFO: renamed from: J */
    public void m5860J() {
        if (this.f5433y.getVisibility() != 0) {
            setSystemTimeAndBattery();
            this.f5451ai.setText(C1803in.m9809b(this.f5402B, this.f5403C));
        }
        if (this.f5422n == 1) {
            m5863M();
            if (this.f5433y.getVisibility() == 0) {
                return;
            }
            setSystemTimeAndBattery();
            return;
        }
        if (this.f5422n == 3) {
            if (this.f5433y.getVisibility() == 0) {
                m5865O();
                return;
            } else {
                m5864N();
                return;
            }
        }
        if (this.f5422n == 5) {
            if (this.f5433y.getVisibility() == 0) {
                m5867Q();
            } else {
                m5866P();
            }
        }
    }

    public void setSystemTimeAndBattery() {
        this.f5449ag.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (this.f5441aB) {
            return;
        }
        getContext().registerReceiver(this.f5442aC, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* JADX INFO: renamed from: K */
    public void m5861K() {
        if (this.f5422n == 1) {
            if (this.f5433y.getVisibility() == 0) {
                m5863M();
            }
        } else if (this.f5422n == 3) {
            if (this.f5433y.getVisibility() == 0) {
                m5865O();
            }
        } else if (this.f5422n == 5) {
            if (this.f5433y.getVisibility() == 0) {
                m5867Q();
            }
        } else if (this.f5422n == 6 && this.f5433y.getVisibility() == 0) {
            m5868R();
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    public void setProgressAndText(int i, long j, long j2) {
        super.setProgressAndText(i, j, j2);
        if (i != 0) {
            this.f5439W.setProgress(i);
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    public void setBufferProgress(int i) {
        super.setBufferProgress(i);
        if (i != 0) {
            this.f5439W.setSecondaryProgress(i);
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: x */
    public void mo5854x() {
        super.mo5854x();
        this.f5439W.setProgress(0);
        this.f5439W.setSecondaryProgress(0);
    }

    /* JADX INFO: renamed from: L */
    public void m5862L() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
                m5870T();
                break;
        }
    }

    /* JADX INFO: renamed from: M */
    public void m5863M() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
                m5870T();
                break;
        }
    }

    /* JADX INFO: renamed from: N */
    public void m5864N() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
                m5870T();
                break;
        }
    }

    /* JADX INFO: renamed from: O */
    public void m5865O() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
                break;
            case 2:
                setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
                break;
        }
    }

    /* JADX INFO: renamed from: P */
    public void m5866P() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
                m5870T();
                break;
        }
    }

    /* JADX INFO: renamed from: Q */
    public void m5867Q() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
                break;
            case 2:
                setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
                break;
        }
    }

    /* JADX INFO: renamed from: R */
    public void m5868R() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
                m5870T();
                break;
        }
    }

    /* JADX INFO: renamed from: S */
    public void m5869S() {
        switch (this.f5423o) {
            case 0:
            case 1:
                setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
                m5870T();
                break;
            case 2:
                setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
                m5870T();
                break;
        }
    }

    public void setAllControlsVisiblity(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f5432x.setVisibility(i);
        this.f5433y.setVisibility(i2);
        this.f5426r.setVisibility(i3);
        this.f5443aa.setVisibility(i4);
        this.f5445ac.setVisibility(i5);
        this.f5439W.setVisibility(i6);
        this.f5454al.setVisibility(i7);
    }

    /* JADX INFO: renamed from: T */
    public void m5870T() {
        if (this.f5422n == 3) {
            this.f5426r.setVisibility(0);
            this.f5426r.setImageResource(R.drawable.jz_click_pause_selector);
            this.f5450ah.setVisibility(4);
        } else if (this.f5422n == 7) {
            this.f5426r.setVisibility(4);
            this.f5450ah.setVisibility(4);
        } else if (this.f5422n == 6) {
            Log.e("JiaoZiVideoPlayer", "updateStartImage: 111111111111");
            this.f5426r.setVisibility(8);
        } else {
            this.f5426r.setImageResource(R.drawable.jz_click_play_selector);
            this.f5450ah.setVisibility(4);
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: a */
    public void mo5828a(float f, String str, long j, String str2, long j2) {
        super.mo5828a(f, str, j, str2, j2);
        if (this.f5456an == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.f5457ao = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.f5458ap = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.f5459aq = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.f5460ar = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.f5456an = m5874a(viewInflate);
        }
        if (!this.f5456an.isShowing()) {
            this.f5456an.show();
        }
        this.f5458ap.setText(str);
        this.f5459aq.setText(" / " + str2);
        this.f5457ao.setProgress(j2 <= 0 ? 0 : (int) ((j * 100) / j2));
        if (f > 0.0f) {
            this.f5460ar.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.f5460ar.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        m5861K();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: F */
    public void mo5824F() {
        super.mo5824F();
        if (this.f5456an != null) {
            this.f5456an.dismiss();
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: a */
    public void mo5827a(float f, int i) {
        super.mo5827a(f, i);
        if (this.f5461as == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.f5464av = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.f5463au = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.f5462at = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.f5461as = m5874a(viewInflate);
        }
        if (!this.f5461as.isShowing()) {
            this.f5461as.show();
        }
        if (i <= 0) {
            this.f5464av.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.f5464av.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.f5463au.setText(i + "%");
        this.f5462at.setProgress(i);
        m5861K();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: G */
    public void mo5825G() {
        super.mo5825G();
        if (this.f5461as != null) {
            this.f5461as.dismiss();
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: b */
    public void mo5832b(int i) {
        super.mo5832b(i);
        if (this.f5465aw == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.f5467ay = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.f5466ax = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.f5465aw = m5874a(viewInflate);
        }
        if (!this.f5465aw.isShowing()) {
            this.f5465aw.show();
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.f5467ay.setText(i + "%");
        this.f5466ax.setProgress(i);
        m5861K();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: H */
    public void mo5826H() {
        super.mo5826H();
        if (this.f5465aw != null) {
            this.f5465aw.dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    public Dialog m5874a(View view) {
        Dialog dialog = new Dialog(getContext(), R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    /* JADX INFO: renamed from: U */
    public void m5871U() {
        m5872V();
        f5437U = new Timer();
        this.f5455am = new C0809a();
        f5437U.schedule(this.f5455am, 2500L);
    }

    /* JADX INFO: renamed from: V */
    public void m5872V() {
        if (f5437U != null) {
            f5437U.cancel();
        }
        if (this.f5455am != null) {
            this.f5455am.cancel();
        }
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: n */
    public void mo5844n() {
        super.mo5844n();
        Log.e("JiaoZiVideoPlayer", "onAutoCompletion: ");
        m5872V();
    }

    @Override // cn.jzvd.JZVideoPlayer
    /* JADX INFO: renamed from: o */
    public void mo5845o() {
        super.mo5845o();
        m5872V();
        Log.e("JiaoZiVideoPlayer", "onCompletion: ");
        if (this.f5452aj != null) {
            this.f5452aj.dismiss();
        }
    }

    /* JADX INFO: renamed from: W */
    public void m5873W() {
        if (this.f5422n == 0 || this.f5422n == 7 || this.f5422n == 6) {
            return;
        }
        post(new Runnable() { // from class: cn.jzvd.JZVideoPlayerStandard.6
            @Override // java.lang.Runnable
            public void run() {
                JZVideoPlayerStandard.this.f5433y.setVisibility(4);
                JZVideoPlayerStandard.this.f5432x.setVisibility(4);
                JZVideoPlayerStandard.this.f5426r.setVisibility(4);
                if (JZVideoPlayerStandard.this.f5452aj != null) {
                    JZVideoPlayerStandard.this.f5452aj.dismiss();
                }
                if (JZVideoPlayerStandard.this.f5423o != 3) {
                    JZVideoPlayerStandard.this.f5439W.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: renamed from: cn.jzvd.JZVideoPlayerStandard$a */
    public class C0809a extends TimerTask {
        public C0809a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JZVideoPlayerStandard.this.m5873W();
        }
    }
}
