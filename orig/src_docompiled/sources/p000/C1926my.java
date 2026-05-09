package p000;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: my */
/* JADX INFO: compiled from: ShowContentInfoPopView.java */
/* JADX INFO: loaded from: classes.dex */
public class C1926my {

    /* JADX INFO: renamed from: a */
    private Activity f11682a;

    /* JADX INFO: renamed from: b */
    private View f11683b;

    /* JADX INFO: renamed from: c */
    private TextView f11684c;

    /* JADX INFO: renamed from: d */
    private TextView f11685d;

    /* JADX INFO: renamed from: e */
    private TextView f11686e;

    /* JADX INFO: renamed from: f */
    private TextView f11687f;

    /* JADX INFO: renamed from: g */
    private RelativeLayout f11688g;

    /* JADX INFO: renamed from: h */
    private LinearLayout f11689h;

    /* JADX INFO: renamed from: i */
    private PopupWindow f11690i;

    public C1926my(Activity activity) {
        this.f11682a = activity;
        m10695e();
    }

    /* JADX INFO: renamed from: e */
    private void m10695e() {
        View viewInflate = LayoutInflater.from(this.f11682a).inflate(R.layout.layout_pop_show_info, (ViewGroup) new LinearLayout(this.f11682a), false);
        this.f11690i = new PopupWindow(viewInflate, -1, -1);
        this.f11690i.setOutsideTouchable(true);
        this.f11690i.setFocusable(true);
        this.f11690i.setBackgroundDrawable(new BitmapDrawable());
        this.f11683b = viewInflate.findViewById(R.id.rl_parent_show_info);
        this.f11686e = (TextView) viewInflate.findViewById(R.id.tv_title_pop_show_info);
        this.f11687f = (TextView) viewInflate.findViewById(R.id.tv_content_pop_show_info);
        this.f11684c = (TextView) viewInflate.findViewById(R.id.tv_sure_charge_pop_show_info);
        this.f11685d = (TextView) viewInflate.findViewById(R.id.tv_cancle_charge_pop_show_info);
        this.f11688g = (RelativeLayout) viewInflate.findViewById(R.id.rl_sure_charge_pop_show);
        this.f11689h = (LinearLayout) viewInflate.findViewById(R.id.ll_bottom_btn);
        this.f11685d.setOnClickListener(new View.OnClickListener() { // from class: my.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1926my.this.f11690i.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10700a(String str) {
        if (str != null) {
            this.f11686e.setText(str);
        } else {
            this.f11686e.setText("");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10703b(String str) {
        if (str != null) {
            this.f11687f.setText(str);
        } else {
            this.f11687f.setText("");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10697a(int i) {
        this.f11686e.setVisibility(i);
        if (i != 0) {
            ViewGroup.LayoutParams layoutParams = this.f11683b.getLayoutParams();
            layoutParams.height = C1895ly.m10460a(this.f11682a, 146.0f);
            this.f11683b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            layoutParams2.addRule(2, this.f11689h.getId());
            layoutParams2.setMargins(C1895ly.m10460a(this.f11682a, 30.0f), 0, C1895ly.m10460a(this.f11682a, 30.0f), 0);
            this.f11687f.setLayoutParams(layoutParams2);
            this.f11687f.setTextSize(16.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10696a() {
        this.f11685d.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    public void m10698a(View.OnClickListener onClickListener) {
        this.f11688g.setOnClickListener(onClickListener);
    }

    /* JADX INFO: renamed from: b */
    public void m10702b(View.OnClickListener onClickListener) {
        this.f11685d.setOnClickListener(onClickListener);
    }

    /* JADX INFO: renamed from: c */
    public void m10704c(String str) {
        this.f11684c.setText(str);
    }

    /* JADX INFO: renamed from: d */
    public void m10707d(String str) {
        this.f11685d.setText(str);
    }

    /* JADX INFO: renamed from: b */
    public void m10701b() {
        if (this.f11690i.isShowing()) {
            this.f11690i.dismiss();
        }
        this.f11690i.showAtLocation(this.f11682a.getWindow().getDecorView(), 17, 0, 0);
        this.f11683b.startAnimation(AnimationUtils.loadAnimation(this.f11682a, R.anim.show_window_anim));
    }

    /* JADX INFO: renamed from: c */
    public boolean m10705c() {
        return this.f11690i.isShowing();
    }

    /* JADX INFO: renamed from: d */
    public void m10706d() {
        if (this.f11690i.isShowing()) {
            this.f11690i.dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10699a(PopupWindow.OnDismissListener onDismissListener) {
        this.f11690i.setOnDismissListener(onDismissListener);
    }
}
