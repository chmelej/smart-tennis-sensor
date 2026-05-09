package p000;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.widget.VerticalProgress;
import org.litepal.crud.DataSupport;

/* JADX INFO: renamed from: mw */
/* JADX INFO: compiled from: SetTrainSendTargetPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1924mw {

    /* JADX INFO: renamed from: a */
    private Activity f11637a;

    /* JADX INFO: renamed from: b */
    private View f11638b;

    /* JADX INFO: renamed from: c */
    private TextView f11639c;

    /* JADX INFO: renamed from: d */
    private TextView f11640d;

    /* JADX INFO: renamed from: e */
    private TextView f11641e;

    /* JADX INFO: renamed from: f */
    private VerticalProgress f11642f;

    /* JADX INFO: renamed from: g */
    private PopupWindow f11643g;

    /* JADX INFO: renamed from: h */
    private int f11644h;

    /* JADX INFO: renamed from: i */
    private a f11645i;

    /* JADX INFO: renamed from: mw$a */
    /* JADX INFO: compiled from: SetTrainSendTargetPopWindow.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo10374a(int i);
    }

    public C1924mw(Activity activity) {
        this.f11637a = activity;
        m10651c();
    }

    /* JADX INFO: renamed from: c */
    private void m10651c() {
        View viewInflate = LayoutInflater.from(this.f11637a).inflate(R.layout.layout_pop_set_send_target, (ViewGroup) new LinearLayout(this.f11637a), false);
        this.f11643g = new PopupWindow(viewInflate, -1, -1);
        this.f11643g.setOutsideTouchable(true);
        this.f11643g.setFocusable(true);
        this.f11643g.setBackgroundDrawable(new BitmapDrawable());
        m10645a(viewInflate);
        m10653d();
        m10654e();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: mw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1896lz.m10463a(view.getId())) {
                    return;
                }
                C1924mw.this.m10658b();
            }
        });
        this.f11638b.setOnClickListener(new View.OnClickListener() { // from class: mw.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private void m10645a(View view) {
        this.f11638b = view.findViewById(R.id.ll_root_target);
        this.f11639c = (TextView) view.findViewById(R.id.tv_target_send_speed);
        this.f11640d = (TextView) view.findViewById(R.id.tv_target_suggest);
        this.f11641e = (TextView) view.findViewById(R.id.tv_target_sure);
        this.f11642f = (VerticalProgress) view.findViewById(R.id.vp_send_target);
    }

    /* JADX INFO: renamed from: d */
    private void m10653d() {
        this.f11644h = 100;
        this.f11642f.setProgress(this.f11644h);
    }

    /* JADX INFO: renamed from: e */
    private void m10654e() {
        this.f11641e.setOnClickListener(new View.OnClickListener() { // from class: mw.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1924mw.this.f11645i.mo10374a(C1924mw.this.f11644h);
                C1924mw.this.m10658b();
            }
        });
        this.f11640d.setOnClickListener(new View.OnClickListener() { // from class: mw.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1924mw.this.m10649b(1);
            }
        });
        this.f11642f.setOnProgressChangeListener(new VerticalProgress.InterfaceC1385a() { // from class: mw.5
            @Override // com.coollang.tennis.widget.VerticalProgress.InterfaceC1385a
            /* JADX INFO: renamed from: a */
            public void mo8327a(int i) {
                C1924mw.this.f11644h = (i / 5) * 5;
                C1924mw.this.f11639c.setText(C1910mi.m10523a(String.valueOf(i), i + " km/h", 23));
            }
        });
        this.f11645i = new a() { // from class: mw.6
            @Override // p000.C1924mw.a
            /* JADX INFO: renamed from: a */
            public void mo10374a(int i) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10649b(int i) {
        int iM10116b = C1856km.m10109a().m10116b(i, Integer.parseInt(C1902me.m10480a(this.f11637a)));
        if (iM10116b != -1) {
            int i2 = 0;
            Cursor cursorFindBySQL = DataSupport.findBySQL("Select * From OnTimeDetailTable Where trainId = ? ", String.valueOf(iM10116b));
            while (cursorFindBySQL.moveToNext()) {
                i2 += cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"));
            }
            if (cursorFindBySQL.getCount() == 0 || i2 == 0) {
                m10649b(i + 1);
                return;
            }
            this.f11644h = (int) ((((i2 / 0.8f) / cursorFindBySQL.getCount()) / 5.0f) * 5.0f);
            if (this.f11644h > 200) {
                this.f11644h = 200;
            } else if (this.f11644h <= 0) {
                this.f11644h = 100;
            }
            cursorFindBySQL.close();
        } else {
            this.f11644h = 100;
        }
        this.f11642f.setProgress(this.f11644h);
    }

    /* JADX INFO: renamed from: a */
    public void m10657a(a aVar) {
        this.f11645i = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m10655a() {
        if (this.f11643g.isShowing()) {
            this.f11643g.dismiss();
        }
        this.f11643g.showAtLocation(this.f11637a.getWindow().getDecorView(), 17, 0, 0);
        this.f11638b.startAnimation(AnimationUtils.loadAnimation(this.f11637a, R.anim.target_show_anim));
    }

    /* JADX INFO: renamed from: b */
    public void m10658b() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f11637a, R.anim.target_hide_anim);
        this.f11638b.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: mw.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C1924mw.this.f11643g.isShowing()) {
                    C1924mw.this.f11643g.dismiss();
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10656a(int i) {
        this.f11644h = i;
        this.f11642f.setProgress(this.f11644h);
    }
}
