package com.coollang.tennis.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.fragment.SportMainFragment;
import com.coollang.tennis.p011db.model.MyDetailTable;
import java.text.SimpleDateFormat;
import p000.AbstractC1838jv;
import p000.C1839jw;
import p000.C1842jz;
import p000.C1853kj;
import p000.C1875le;
import p000.C1893lw;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1912mk;
import p000.C1914mm;
import p000.C2045qb;
import p000.DialogC1867kx;
import p000.InterfaceC2046qc;

/* JADX INFO: loaded from: classes.dex */
public class VideoCaptureView extends FrameLayout implements View.OnClickListener, AbstractC1838jv.a {

    /* JADX INFO: renamed from: A */
    private DialogC1867kx f8823A;

    /* JADX INFO: renamed from: B */
    private int f8824B;

    /* JADX INFO: renamed from: C */
    private int f8825C;

    /* JADX INFO: renamed from: D */
    private int f8826D;

    /* JADX INFO: renamed from: E */
    private int f8827E;

    /* JADX INFO: renamed from: F */
    private int f8828F;

    /* JADX INFO: renamed from: G */
    private int f8829G;

    /* JADX INFO: renamed from: H */
    private int f8830H;

    /* JADX INFO: renamed from: I */
    private int f8831I;

    /* JADX INFO: renamed from: J */
    private int f8832J;

    /* JADX INFO: renamed from: K */
    private int f8833K;

    /* JADX INFO: renamed from: L */
    private int f8834L;

    /* JADX INFO: renamed from: M */
    private MyDetailTable f8835M;

    /* JADX INFO: renamed from: a */
    public TextView f8836a;

    /* JADX INFO: renamed from: b */
    public long f8837b;

    /* JADX INFO: renamed from: c */
    public long f8838c;

    /* JADX INFO: renamed from: d */
    public boolean f8839d;

    /* JADX INFO: renamed from: e */
    Runnable f8840e;

    /* JADX INFO: renamed from: f */
    private final float f8841f;

    /* JADX INFO: renamed from: g */
    private final float f8842g;

    /* JADX INFO: renamed from: h */
    private final float f8843h;

    /* JADX INFO: renamed from: i */
    private ImageView f8844i;

    /* JADX INFO: renamed from: j */
    private SurfaceView f8845j;

    /* JADX INFO: renamed from: k */
    private ImageView f8846k;

    /* JADX INFO: renamed from: l */
    private TextView f8847l;

    /* JADX INFO: renamed from: m */
    private ImageButton f8848m;

    /* JADX INFO: renamed from: n */
    private TextView f8849n;

    /* JADX INFO: renamed from: o */
    private CircularSeekBar f8850o;

    /* JADX INFO: renamed from: p */
    private TextView f8851p;

    /* JADX INFO: renamed from: q */
    private CircularSeekBar f8852q;

    /* JADX INFO: renamed from: r */
    private TextView f8853r;

    /* JADX INFO: renamed from: s */
    private CircularSeekBar f8854s;

    /* JADX INFO: renamed from: t */
    private C2045qb f8855t;

    /* JADX INFO: renamed from: u */
    private Context f8856u;

    /* JADX INFO: renamed from: v */
    private PopupWindow f8857v;

    /* JADX INFO: renamed from: w */
    private InterfaceC2046qc f8858w;

    /* JADX INFO: renamed from: x */
    private String f8859x;

    /* JADX INFO: renamed from: y */
    private Handler f8860y;

    /* JADX INFO: renamed from: z */
    private C1842jz f8861z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m8328a(int i) {
        int i2 = (int) ((i * 11) / 30.0f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m8329a(int i, float f) {
        int i2 = (int) ((i / f) * 100.0f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: renamed from: q */
    static /* synthetic */ int m8358q(VideoCaptureView videoCaptureView) {
        int i = videoCaptureView.f8833K;
        videoCaptureView.f8833K = i + 1;
        return i;
    }

    public VideoCaptureView(Context context) {
        super(context);
        this.f8841f = 200.0f;
        this.f8842g = 30.0f;
        this.f8843h = 360.0f;
        this.f8837b = -1L;
        this.f8839d = false;
        this.f8859x = "";
        this.f8860y = new Handler() { // from class: com.coollang.tennis.widget.VideoCaptureView.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null) {
                    C1893lw.m10456d(bArr);
                    if (bArr[0] == -88 && bArr[1] == 36 && bArr[2] == 1 && C1893lw.m10442a(bArr)) {
                        VideoCaptureView.this.m8337a(bArr);
                        C1893lw.m10456d(bArr);
                    }
                }
            }
        };
        this.f8824B = 0;
        this.f8825C = 0;
        this.f8826D = 0;
        this.f8833K = 0;
        this.f8834L = 0;
        this.f8840e = new Runnable() { // from class: com.coollang.tennis.widget.VideoCaptureView.6
            @Override // java.lang.Runnable
            public void run() {
                VideoCaptureView.this.f8824B = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8824B, VideoCaptureView.this.f8827E);
                VideoCaptureView.this.f8825C = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8825C, VideoCaptureView.this.f8828F);
                VideoCaptureView.this.f8826D = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8826D, VideoCaptureView.this.f8829G);
                VideoCaptureView.this.f8850o.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8824B, 200.0f));
                VideoCaptureView.this.f8852q.setProgress(VideoCaptureView.this.m8328a(VideoCaptureView.this.f8825C));
                VideoCaptureView.this.f8854s.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8826D, 360.0f));
                VideoCaptureView.m8358q(VideoCaptureView.this);
                if (VideoCaptureView.this.f8833K < VideoCaptureView.this.f8834L) {
                    VideoCaptureView.this.f8860y.postDelayed(VideoCaptureView.this.f8840e, 1L);
                }
            }
        };
        m8335a(context);
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8841f = 200.0f;
        this.f8842g = 30.0f;
        this.f8843h = 360.0f;
        this.f8837b = -1L;
        this.f8839d = false;
        this.f8859x = "";
        this.f8860y = new Handler() { // from class: com.coollang.tennis.widget.VideoCaptureView.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null) {
                    C1893lw.m10456d(bArr);
                    if (bArr[0] == -88 && bArr[1] == 36 && bArr[2] == 1 && C1893lw.m10442a(bArr)) {
                        VideoCaptureView.this.m8337a(bArr);
                        C1893lw.m10456d(bArr);
                    }
                }
            }
        };
        this.f8824B = 0;
        this.f8825C = 0;
        this.f8826D = 0;
        this.f8833K = 0;
        this.f8834L = 0;
        this.f8840e = new Runnable() { // from class: com.coollang.tennis.widget.VideoCaptureView.6
            @Override // java.lang.Runnable
            public void run() {
                VideoCaptureView.this.f8824B = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8824B, VideoCaptureView.this.f8827E);
                VideoCaptureView.this.f8825C = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8825C, VideoCaptureView.this.f8828F);
                VideoCaptureView.this.f8826D = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8826D, VideoCaptureView.this.f8829G);
                VideoCaptureView.this.f8850o.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8824B, 200.0f));
                VideoCaptureView.this.f8852q.setProgress(VideoCaptureView.this.m8328a(VideoCaptureView.this.f8825C));
                VideoCaptureView.this.f8854s.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8826D, 360.0f));
                VideoCaptureView.m8358q(VideoCaptureView.this);
                if (VideoCaptureView.this.f8833K < VideoCaptureView.this.f8834L) {
                    VideoCaptureView.this.f8860y.postDelayed(VideoCaptureView.this.f8840e, 1L);
                }
            }
        };
        m8335a(context);
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8841f = 200.0f;
        this.f8842g = 30.0f;
        this.f8843h = 360.0f;
        this.f8837b = -1L;
        this.f8839d = false;
        this.f8859x = "";
        this.f8860y = new Handler() { // from class: com.coollang.tennis.widget.VideoCaptureView.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null) {
                    C1893lw.m10456d(bArr);
                    if (bArr[0] == -88 && bArr[1] == 36 && bArr[2] == 1 && C1893lw.m10442a(bArr)) {
                        VideoCaptureView.this.m8337a(bArr);
                        C1893lw.m10456d(bArr);
                    }
                }
            }
        };
        this.f8824B = 0;
        this.f8825C = 0;
        this.f8826D = 0;
        this.f8833K = 0;
        this.f8834L = 0;
        this.f8840e = new Runnable() { // from class: com.coollang.tennis.widget.VideoCaptureView.6
            @Override // java.lang.Runnable
            public void run() {
                VideoCaptureView.this.f8824B = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8824B, VideoCaptureView.this.f8827E);
                VideoCaptureView.this.f8825C = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8825C, VideoCaptureView.this.f8828F);
                VideoCaptureView.this.f8826D = VideoCaptureView.this.m8330a(VideoCaptureView.this.f8826D, VideoCaptureView.this.f8829G);
                VideoCaptureView.this.f8850o.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8824B, 200.0f));
                VideoCaptureView.this.f8852q.setProgress(VideoCaptureView.this.m8328a(VideoCaptureView.this.f8825C));
                VideoCaptureView.this.f8854s.setProgress(VideoCaptureView.this.m8329a(VideoCaptureView.this.f8826D, 360.0f));
                VideoCaptureView.m8358q(VideoCaptureView.this);
                if (VideoCaptureView.this.f8833K < VideoCaptureView.this.f8834L) {
                    VideoCaptureView.this.f8860y.postDelayed(VideoCaptureView.this.f8840e, 1L);
                }
            }
        };
        m8335a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m8335a(Context context) {
        this.f8856u = context;
        View viewInflate = View.inflate(context, R.layout.view_videocapture, this);
        this.f8859x = C1902me.m10480a(C1914mm.m10554a());
        this.f8844i = (ImageView) viewInflate.findViewById(R.id.videocapture_recordbtn_iv);
        this.f8847l = (TextView) viewInflate.findViewById(R.id.videocapture_recordbtn_tv_time);
        this.f8848m = (ImageButton) viewInflate.findViewById(R.id.videocapture_declinebtn_iv_delete);
        this.f8849n = (TextView) viewInflate.findViewById(R.id.videocapture_tv_rate);
        this.f8850o = (CircularSeekBar) viewInflate.findViewById(R.id.videocapture_pb_rate);
        this.f8851p = (TextView) viewInflate.findViewById(R.id.videocapture_tv_strenth);
        this.f8852q = (CircularSeekBar) viewInflate.findViewById(R.id.videocapture_pb_strength);
        this.f8853r = (TextView) viewInflate.findViewById(R.id.videocapture_tv_angle);
        this.f8854s = (CircularSeekBar) viewInflate.findViewById(R.id.videocapture_pb_angle);
        this.f8836a = (TextView) viewInflate.findViewById(R.id.videocapture_preview_tv_conn);
        this.f8836a.setVisibility(8);
        this.f8850o.setProgress(0);
        this.f8852q.setProgress(0);
        this.f8854s.setProgress(0);
        this.f8850o.setRingBlue();
        this.f8852q.setRingRed();
        this.f8854s.setRingYello();
        this.f8844i.setOnClickListener(this);
        this.f8848m.setOnClickListener(this);
        this.f8846k = (ImageView) viewInflate.findViewById(R.id.videocapture_preview_iv);
        this.f8845j = (SurfaceView) viewInflate.findViewById(R.id.videocapture_preview_sv);
        this.f8855t = new C2045qb();
        this.f8855t.m11167a(new C2045qb.a() { // from class: com.coollang.tennis.widget.VideoCaptureView.1
            @Override // p000.C2045qb.a
            /* JADX INFO: renamed from: a */
            public void mo8366a() {
                VideoCaptureView.this.f8847l.setText(VideoCaptureView.this.f8855t.m11165a(VideoCaptureView.this.f8855t.f12262a));
            }
        });
        this.f8861z = C1842jz.m10050a();
    }

    public void setRecordingButtonInterface(InterfaceC2046qc interfaceC2046qc) {
        this.f8858w = interfaceC2046qc;
    }

    public SurfaceHolder getPreviewSurfaceHolder() {
        return this.f8845j.getHolder();
    }

    public void setSurfaceTranslate() {
        this.f8845j.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    /* JADX INFO: renamed from: a */
    public void m8362a() {
        this.f8844i.setSelected(false);
        this.f8844i.setVisibility(0);
        this.f8846k.setVisibility(8);
        this.f8845j.setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    public void m8364b() {
        this.f8844i.setSelected(true);
        this.f8844i.setVisibility(0);
        this.f8846k.setVisibility(8);
        this.f8845j.setVisibility(0);
    }

    /* JADX INFO: renamed from: a */
    public void m8363a(Bitmap bitmap) {
        this.f8844i.setVisibility(0);
        this.f8845j.setVisibility(0);
        if (bitmap != null) {
            this.f8846k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f8846k.setImageBitmap(bitmap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8858w == null || C1896lz.m10463a(view.getId())) {
            return;
        }
        if (view.getId() == this.f8844i.getId()) {
            this.f8858w.mo7552c();
            if (!this.f8855t.f12266e) {
                MyApplication.m7738a().f7407h = true;
                this.f8855t.f12266e = true;
                this.f8855t.m11166a();
                this.f8837b = System.currentTimeMillis() / 1000;
                C1900mc.m10474b("startTime", this.f8837b + "  =========");
                if (C1839jw.f10820a != null) {
                    C1839jw.f10820a.m10019a(this);
                    C1839jw.m10026a().m10041a(new C1875le());
                    C1839jw.m10026a().m10042a(36);
                    return;
                }
                return;
            }
            m8343d();
            return;
        }
        if (view.getId() == this.f8848m.getId()) {
            m8365c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m8365c() {
        if (this.f8855t.f12262a > 0) {
            m8343d();
            this.f8855t.m11168b();
        } else {
            this.f8858w.mo7554e();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m8343d() {
        this.f8823A = new DialogC1867kx(this.f8856u, C1914mm.m10557b(R.string.isSaveVideo), C1914mm.m10557b(R.string.video_content), C1914mm.m10557b(R.string.save), C1914mm.m10557b(R.string.delete), new DialogC1867kx.a() { // from class: com.coollang.tennis.widget.VideoCaptureView.2
            /* JADX WARN: Type inference failed for: r2v2, types: [com.coollang.tennis.widget.VideoCaptureView$2$1] */
            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7196a(String str) {
                SportMainFragment.f7598b = true;
                new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.widget.VideoCaptureView.2.1
                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        super.onPreExecute();
                        VideoCaptureView.this.f8838c = System.currentTimeMillis() / 1000;
                        VideoCaptureView.this.f8855t.m11168b();
                        MyApplication.m7738a().f7407h = false;
                        if (VideoCaptureView.this.f8823A != null) {
                            VideoCaptureView.this.f8823A.dismiss();
                        }
                        VideoCaptureView.this.m8346e();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Void doInBackground(Void... voidArr) {
                        if (!MyApplication.m7738a().f7401b) {
                            return null;
                        }
                        VideoCaptureView.this.f8861z.m10055b();
                        VideoCaptureView.this.f8861z.m10056c();
                        try {
                            Thread.sleep(3000L);
                            return null;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.execute(new Void[0]);
            }

            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7195a() {
                VideoCaptureView.this.f8858w.mo7554e();
            }
        });
        this.f8823A.setCancelable(false);
        this.f8823A.show();
        this.f8861z.m10054a(new C1842jz.a() { // from class: com.coollang.tennis.widget.VideoCaptureView.3
            @Override // p000.C1842jz.a
            /* JADX INFO: renamed from: a */
            public void mo7381a() {
                VideoCaptureView.this.f8839d = VideoCaptureView.this.f8861z.f10847b;
                if (VideoCaptureView.this.f8857v != null && VideoCaptureView.this.f8857v.isShowing()) {
                    VideoCaptureView.this.f8857v.dismiss();
                }
                VideoCaptureView.this.f8858w.mo7553d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m8346e() {
        this.f8857v = new PopupWindow(C1914mm.m10555a(R.layout.progressbar_post_video), -1, -1, true);
        this.f8857v.setTouchable(true);
        this.f8857v.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.widget.VideoCaptureView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f8857v.setBackgroundDrawable(new BitmapDrawable());
        this.f8857v.showAtLocation(this.f8844i, 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m8330a(int i, int i2) {
        int i3 = i - i2;
        int i4 = 1;
        if (Math.abs(i3) > 5) {
            i4 = 5;
        } else if (Math.abs(i3) > 3) {
            i4 = 3;
        } else if (Math.abs(i3) <= 1) {
            i4 = 0;
        }
        return i > i2 ? i - i4 : i + i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8337a(byte[] bArr) {
        if (bArr[10] != 0) {
            this.f8835M = new MyDetailTable();
            C1900mc.m10473a("Timestamp", "Timestamp=" + (System.currentTimeMillis() / 1000));
            this.f8827E = C1893lw.m10453b(bArr[4], bArr[5]);
            this.f8828F = C1893lw.m10453b(bArr[6], bArr[7]);
            this.f8829G = C1893lw.m10453b(bArr[8], bArr[9]);
            C1900mc.m10475c("VideoCaptureView", "挥拍速度=" + this.f8827E + "   挥拍力度=" + this.f8828F + "  挥拍弧度=" + this.f8829G);
            String strM10537a = C1912mk.m10537a(new SimpleDateFormat("yyyy-MM-dd"));
            this.f8835M.setUserID(Integer.parseInt(this.f8859x));
            this.f8835M.setSign1(0);
            this.f8835M.setSign2(strM10537a);
            this.f8835M.setTimestamp(System.currentTimeMillis() / 1000);
            this.f8835M.setActionType(Integer.parseInt(String.format("%02X", Byte.valueOf(bArr[3]))));
            this.f8835M.setForce(this.f8828F);
            this.f8835M.setSpeed(this.f8827E);
            this.f8835M.setRadian(this.f8829G);
            this.f8835M.setHandType(C1893lw.m10452b(bArr[12]));
            this.f8835M.setIstarget(Integer.parseInt(bArr[11] == 1 ? "1" : "0"));
            this.f8835M.save();
            if (this.f8837b != -1) {
                this.f8849n.setText(String.valueOf(this.f8827E));
                this.f8851p.setText(String.valueOf(Math.round(this.f8828F * 0.11f)));
                this.f8853r.setText(String.valueOf(this.f8829G));
                this.f8830H = Math.abs(this.f8827E - this.f8824B);
                this.f8831I = Math.abs(this.f8828F - this.f8825C);
                this.f8832J = Math.abs(this.f8829G - this.f8826D);
                this.f8833K = 0;
                this.f8834L = Math.max(Math.max(this.f8830H, this.f8831I), Math.max(this.f8831I, this.f8832J));
                this.f8860y.post(this.f8840e);
                return;
            }
            Toast.makeText(this.f8856u, R.string.not_start_video_capture, 0).show();
        }
    }

    @Override // p000.AbstractC1838jv.a
    /* JADX INFO: renamed from: a */
    public void mo7490a(Context context, Intent intent, String str, String str2) {
        String action = intent.getAction();
        if ("com.rfstar.kevin.service.ACTION_GATT_CONNECTED".equals(action)) {
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED".equals(action)) {
            MyApplication.m7738a().f7401b = false;
            this.f8836a.setVisibility(0);
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
            this.f8836a.setVisibility(8);
            MyApplication.m7738a().f7401b = true;
            if (C1839jw.f10820a != null) {
                TextUtils.isEmpty(C1839jw.f10820a.f10812c.trim());
            }
            if (C1839jw.f10820a != null) {
                C1839jw.f10820a.m10046a(C1853kj.f10919a, C1853kj.f10920b, true);
            }
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.widget.VideoCaptureView.7
                @Override // java.lang.Runnable
                public void run() {
                    C1839jw.m10026a().m10042a(36);
                }
            }, 1000L);
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE".equals(action) && intent.getStringExtra("com.rfstar.kevin.service.characteristic").contains(C1853kj.f10921c)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("com.rfstar.kevin.service.EXTRA_DATA");
            if (byteArrayExtra.length > 3) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = byteArrayExtra;
                this.f8860y.sendMessage(messageObtain);
            }
        }
    }
}
