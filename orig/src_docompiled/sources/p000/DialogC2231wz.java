package p000;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.shengrendan.mysweetdemo.libs.ProgressWheel;
import com.shengrendan.mysweetdemo.libs.SuccessTickView;
import java.util.List;

/* JADX INFO: renamed from: wz */
/* JADX INFO: compiled from: SweetAlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC2231wz extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private Button f13409A;

    /* JADX INFO: renamed from: B */
    private Button f13410B;

    /* JADX INFO: renamed from: C */
    private C2230wy f13411C;

    /* JADX INFO: renamed from: D */
    private FrameLayout f13412D;

    /* JADX INFO: renamed from: E */
    private a f13413E;

    /* JADX INFO: renamed from: F */
    private a f13414F;

    /* JADX INFO: renamed from: G */
    private boolean f13415G;

    /* JADX INFO: renamed from: a */
    private View f13416a;

    /* JADX INFO: renamed from: b */
    private AnimationSet f13417b;

    /* JADX INFO: renamed from: c */
    private AnimationSet f13418c;

    /* JADX INFO: renamed from: d */
    private Animation f13419d;

    /* JADX INFO: renamed from: e */
    private Animation f13420e;

    /* JADX INFO: renamed from: f */
    private AnimationSet f13421f;

    /* JADX INFO: renamed from: g */
    private AnimationSet f13422g;

    /* JADX INFO: renamed from: h */
    private Animation f13423h;

    /* JADX INFO: renamed from: i */
    private TextView f13424i;

    /* JADX INFO: renamed from: j */
    private TextView f13425j;

    /* JADX INFO: renamed from: k */
    private String f13426k;

    /* JADX INFO: renamed from: l */
    private String f13427l;

    /* JADX INFO: renamed from: m */
    private boolean f13428m;

    /* JADX INFO: renamed from: n */
    private boolean f13429n;

    /* JADX INFO: renamed from: o */
    private String f13430o;

    /* JADX INFO: renamed from: p */
    private String f13431p;

    /* JADX INFO: renamed from: q */
    private int f13432q;

    /* JADX INFO: renamed from: r */
    private FrameLayout f13433r;

    /* JADX INFO: renamed from: s */
    private FrameLayout f13434s;

    /* JADX INFO: renamed from: t */
    private FrameLayout f13435t;

    /* JADX INFO: renamed from: u */
    private SuccessTickView f13436u;

    /* JADX INFO: renamed from: v */
    private ImageView f13437v;

    /* JADX INFO: renamed from: w */
    private View f13438w;

    /* JADX INFO: renamed from: x */
    private View f13439x;

    /* JADX INFO: renamed from: y */
    private Drawable f13440y;

    /* JADX INFO: renamed from: z */
    private ImageView f13441z;

    /* JADX INFO: renamed from: wz$a */
    /* JADX INFO: compiled from: SweetAlertDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void m12204a(DialogC2231wz dialogC2231wz);
    }

    public DialogC2231wz(Context context, int i) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        int i2 = 0;
        setCanceledOnTouchOutside(false);
        this.f13411C = new C2230wy(context);
        this.f13432q = i;
        this.f13420e = C2229wx.m12182a(getContext(), R.anim.error_frame_in);
        this.f13421f = (AnimationSet) C2229wx.m12182a(getContext(), R.anim.error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.f13421f.getAnimations();
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.f13423h = C2229wx.m12182a(getContext(), R.anim.success_bow_roate);
        this.f13422g = (AnimationSet) C2229wx.m12182a(getContext(), R.anim.success_mask_layout);
        this.f13417b = (AnimationSet) C2229wx.m12182a(getContext(), R.anim.modal_in);
        this.f13418c = (AnimationSet) C2229wx.m12182a(getContext(), R.anim.modal_out);
        this.f13418c.setAnimationListener(new Animation.AnimationListener() { // from class: wz.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DialogC2231wz.this.f13416a.setVisibility(8);
                DialogC2231wz.this.f13416a.post(new Runnable() { // from class: wz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DialogC2231wz.this.f13415G) {
                            DialogC2231wz.super.cancel();
                        } else {
                            DialogC2231wz.super.dismiss();
                        }
                    }
                });
            }
        });
        this.f13419d = new Animation() { // from class: wz.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = DialogC2231wz.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                DialogC2231wz.this.getWindow().setAttributes(attributes);
            }
        };
        this.f13419d.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alert_dialog);
        this.f13416a = getWindow().getDecorView().findViewById(android.R.id.content);
        this.f13424i = (TextView) findViewById(R.id.title_text);
        this.f13425j = (TextView) findViewById(R.id.content_text);
        this.f13433r = (FrameLayout) findViewById(R.id.error_frame);
        this.f13437v = (ImageView) this.f13433r.findViewById(R.id.error_x);
        this.f13434s = (FrameLayout) findViewById(R.id.success_frame);
        this.f13435t = (FrameLayout) findViewById(R.id.progress_dialog);
        this.f13436u = (SuccessTickView) this.f13434s.findViewById(R.id.success_tick);
        this.f13438w = this.f13434s.findViewById(R.id.mask_left);
        this.f13439x = this.f13434s.findViewById(R.id.mask_right);
        this.f13441z = (ImageView) findViewById(R.id.custom_image);
        this.f13412D = (FrameLayout) findViewById(R.id.warning_frame);
        this.f13409A = (Button) findViewById(R.id.confirm_button);
        this.f13410B = (Button) findViewById(R.id.cancel_button);
        this.f13411C.m12186a((ProgressWheel) findViewById(R.id.progressWheel));
        this.f13409A.setOnClickListener(this);
        this.f13410B.setOnClickListener(this);
        m12196a(this.f13426k);
        m12200b(this.f13427l);
        m12202c(this.f13430o);
        m12203d(this.f13431p);
        m12188a(this.f13432q, true);
    }

    /* JADX INFO: renamed from: b */
    private void m12189b() {
        this.f13441z.setVisibility(8);
        this.f13433r.setVisibility(8);
        this.f13434s.setVisibility(8);
        this.f13412D.setVisibility(8);
        this.f13435t.setVisibility(8);
        this.f13409A.setVisibility(0);
        this.f13409A.setBackgroundResource(R.drawable.blue_button_background);
        this.f13433r.clearAnimation();
        this.f13437v.clearAnimation();
        this.f13436u.clearAnimation();
        this.f13438w.clearAnimation();
        this.f13439x.clearAnimation();
    }

    /* JADX INFO: renamed from: c */
    private void m12191c() {
        if (this.f13432q == 1) {
            this.f13433r.startAnimation(this.f13420e);
            this.f13437v.startAnimation(this.f13421f);
        } else if (this.f13432q == 2) {
            this.f13436u.m8670a();
            this.f13439x.startAnimation(this.f13423h);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m12188a(int i, boolean z) {
        this.f13432q = i;
        if (this.f13416a != null) {
            if (!z) {
                m12189b();
            }
            switch (this.f13432q) {
                case 1:
                    this.f13433r.setVisibility(0);
                    break;
                case 2:
                    this.f13434s.setVisibility(0);
                    this.f13438w.startAnimation(this.f13422g.getAnimations().get(0));
                    this.f13439x.startAnimation(this.f13422g.getAnimations().get(1));
                    this.f13409A.setVisibility(8);
                    break;
                case 3:
                    this.f13409A.setBackgroundResource(R.drawable.red_button_background);
                    this.f13412D.setVisibility(0);
                    break;
                case 4:
                    m12195a(this.f13440y);
                    break;
                case 5:
                    this.f13435t.setVisibility(0);
                    this.f13409A.setVisibility(8);
                    break;
            }
            if (z) {
                return;
            }
            m12191c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12199a(int i) {
        m12188a(i, false);
    }

    /* JADX INFO: renamed from: a */
    public DialogC2231wz m12196a(String str) {
        this.f13426k = str;
        if (this.f13424i != null && this.f13426k != null) {
            this.f13424i.setText(this.f13426k);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public DialogC2231wz m12195a(Drawable drawable) {
        this.f13440y = drawable;
        if (this.f13441z != null && this.f13440y != null) {
            this.f13441z.setVisibility(0);
            this.f13441z.setImageDrawable(this.f13440y);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public DialogC2231wz m12200b(String str) {
        this.f13427l = str;
        if (this.f13425j != null && this.f13427l != null) {
            m12201b(true);
            this.f13425j.setText(this.f13427l);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public DialogC2231wz m12197a(boolean z) {
        this.f13428m = z;
        if (this.f13410B != null) {
            this.f13410B.setVisibility(this.f13428m ? 0 : 8);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public DialogC2231wz m12201b(boolean z) {
        this.f13429n = z;
        if (this.f13425j != null) {
            this.f13425j.setVisibility(this.f13429n ? 0 : 8);
        }
        return this;
    }

    /* JADX INFO: renamed from: c */
    public DialogC2231wz m12202c(String str) {
        this.f13430o = str;
        if (this.f13410B != null && this.f13430o != null) {
            m12197a(true);
            this.f13410B.setText(this.f13430o);
        }
        return this;
    }

    /* JADX INFO: renamed from: d */
    public DialogC2231wz m12203d(String str) {
        this.f13431p = str;
        if (this.f13409A != null && this.f13431p != null) {
            this.f13409A.setText(this.f13431p);
        }
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.f13416a.startAnimation(this.f13417b);
        m12191c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        m12193c(true);
    }

    /* JADX INFO: renamed from: a */
    public void m12198a() {
        m12193c(false);
    }

    /* JADX INFO: renamed from: c */
    private void m12193c(boolean z) {
        this.f13415G = z;
        this.f13409A.startAnimation(this.f13419d);
        this.f13416a.startAnimation(this.f13418c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.cancel_button) {
            if (this.f13413E != null) {
                this.f13413E.m12204a(this);
                return;
            } else {
                m12198a();
                return;
            }
        }
        if (view.getId() == R.id.confirm_button) {
            if (this.f13414F != null) {
                this.f13414F.m12204a(this);
            } else {
                m12198a();
            }
        }
    }
}
