package p000;

import android.content.Context;
import com.coollang.tennis.R;
import com.shengrendan.mysweetdemo.libs.ProgressWheel;

/* JADX INFO: renamed from: wy */
/* JADX INFO: compiled from: ProgressHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C2230wy {

    /* JADX INFO: renamed from: a */
    private ProgressWheel f13399a;

    /* JADX INFO: renamed from: d */
    private int f13402d;

    /* JADX INFO: renamed from: e */
    private int f13403e;

    /* JADX INFO: renamed from: j */
    private int f13408j;

    /* JADX INFO: renamed from: b */
    private boolean f13400b = true;

    /* JADX INFO: renamed from: c */
    private float f13401c = 0.75f;

    /* JADX INFO: renamed from: f */
    private int f13404f = 0;

    /* JADX INFO: renamed from: g */
    private int f13405g = 0;

    /* JADX INFO: renamed from: h */
    private boolean f13406h = false;

    /* JADX INFO: renamed from: i */
    private float f13407i = -1.0f;

    public C2230wy(Context context) {
        this.f13402d = context.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1;
        this.f13403e = context.getResources().getColor(R.color.success_stroke_color);
        this.f13408j = context.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
    }

    /* JADX INFO: renamed from: a */
    public void m12186a(ProgressWheel progressWheel) {
        this.f13399a = progressWheel;
        m12185a();
    }

    /* JADX INFO: renamed from: a */
    private void m12185a() {
        if (this.f13399a != null) {
            if (!this.f13400b && this.f13399a.m8651a()) {
                this.f13399a.m8652b();
            } else if (this.f13400b && !this.f13399a.m8651a()) {
                this.f13399a.m8653c();
            }
            if (this.f13401c != this.f13399a.getSpinSpeed()) {
                this.f13399a.setSpinSpeed(this.f13401c);
            }
            if (this.f13402d != this.f13399a.getBarWidth()) {
                this.f13399a.setBarWidth(this.f13402d);
            }
            if (this.f13403e != this.f13399a.getBarColor()) {
                this.f13399a.setBarColor(this.f13403e);
            }
            if (this.f13404f != this.f13399a.getRimWidth()) {
                this.f13399a.setRimWidth(this.f13404f);
            }
            if (this.f13405g != this.f13399a.getRimColor()) {
                this.f13399a.setRimColor(this.f13405g);
            }
            if (this.f13407i != this.f13399a.getProgress()) {
                if (this.f13406h) {
                    this.f13399a.setInstantProgress(this.f13407i);
                } else {
                    this.f13399a.setProgress(this.f13407i);
                }
            }
            if (this.f13408j != this.f13399a.getCircleRadius()) {
                this.f13399a.setCircleRadius(this.f13408j);
            }
        }
    }
}
