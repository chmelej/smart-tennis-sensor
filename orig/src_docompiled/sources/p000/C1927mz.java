package p000;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.coollang.tennis.R;
import com.coollang.tennis.widget.CircleImageView;

/* JADX INFO: renamed from: mz */
/* JADX INFO: compiled from: ShowHeadPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1927mz {

    /* JADX INFO: renamed from: a */
    View f11692a;

    /* JADX INFO: renamed from: b */
    private Activity f11693b;

    /* JADX INFO: renamed from: c */
    private PopupWindow f11694c;

    /* JADX INFO: renamed from: d */
    private FrameLayout f11695d;

    /* JADX INFO: renamed from: e */
    private CircleImageView f11696e;

    /* JADX INFO: renamed from: f */
    private String f11697f;

    public C1927mz(Activity activity, String str) {
        this.f11693b = activity;
        this.f11697f = str;
        m10709b();
    }

    /* JADX INFO: renamed from: a */
    public void m10711a(View view) {
        this.f11692a = view;
    }

    /* JADX INFO: renamed from: b */
    private void m10709b() {
        View viewM10555a = C1914mm.m10555a(R.layout.pop_show_head);
        this.f11694c = new PopupWindow(viewM10555a, -1, -1);
        this.f11694c.setFocusable(true);
        this.f11694c.setBackgroundDrawable(new BitmapDrawable());
        this.f11694c.setTouchable(true);
        this.f11695d = (FrameLayout) viewM10555a.findViewById(R.id.fl_head_pop_show);
        this.f11696e = (CircleImageView) viewM10555a.findViewById(R.id.civ_head_pop_show);
        C2068qy.m11356a().m11360a(this.f11697f, this.f11696e);
        viewM10555a.setOnClickListener(new View.OnClickListener() { // from class: mz.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1927mz.this.f11694c.isShowing()) {
                    C1927mz.this.f11694c.dismiss();
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10710a() {
        if (this.f11694c.isShowing()) {
            this.f11694c.dismiss();
        }
        this.f11694c.showAtLocation(this.f11692a, 17, 0, 0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.5f, 1, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setDuration(300L);
        this.f11695d.startAnimation(animationSet);
    }
}
