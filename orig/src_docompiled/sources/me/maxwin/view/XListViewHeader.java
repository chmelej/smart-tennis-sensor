package me.maxwin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import me.maxwin.R;

/* JADX INFO: loaded from: classes.dex */
public class XListViewHeader extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private LinearLayout f11481a;

    /* JADX INFO: renamed from: b */
    private ImageView f11482b;

    /* JADX INFO: renamed from: c */
    private ProgressBar f11483c;

    /* JADX INFO: renamed from: d */
    private TextView f11484d;

    /* JADX INFO: renamed from: e */
    private int f11485e;

    /* JADX INFO: renamed from: f */
    private Animation f11486f;

    /* JADX INFO: renamed from: g */
    private Animation f11487g;

    /* JADX INFO: renamed from: h */
    private final int f11488h;

    public XListViewHeader(Context context) {
        super(context);
        this.f11485e = 0;
        this.f11488h = 180;
        m10514a(context);
    }

    public XListViewHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11485e = 0;
        this.f11488h = 180;
        m10514a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m10514a(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.f11481a = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.xlistview_header, (ViewGroup) null);
        addView(this.f11481a, layoutParams);
        setGravity(80);
        this.f11482b = (ImageView) findViewById(R.id.xlistview_header_arrow);
        this.f11484d = (TextView) findViewById(R.id.xlistview_header_hint_textview);
        this.f11483c = (ProgressBar) findViewById(R.id.xlistview_header_progressbar);
        this.f11486f = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f11486f.setDuration(180L);
        this.f11486f.setFillAfter(true);
        this.f11487g = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f11487g.setDuration(180L);
        this.f11487g.setFillAfter(true);
    }

    public void setState(int i) {
        if (i == this.f11485e) {
            return;
        }
        if (i == 2) {
            this.f11482b.clearAnimation();
            this.f11482b.setVisibility(4);
            this.f11483c.setVisibility(0);
        } else {
            this.f11482b.setVisibility(0);
            this.f11483c.setVisibility(4);
        }
        switch (i) {
            case 0:
                if (this.f11485e == 1) {
                    this.f11482b.startAnimation(this.f11487g);
                }
                if (this.f11485e == 2) {
                    this.f11482b.clearAnimation();
                }
                this.f11484d.setText(R.string.xlistview_header_hint_normal);
                break;
            case 1:
                if (this.f11485e != 1) {
                    this.f11482b.clearAnimation();
                    this.f11482b.startAnimation(this.f11486f);
                    this.f11484d.setText(R.string.xlistview_header_hint_ready);
                }
                break;
            case 2:
                this.f11484d.setText(R.string.xlistview_header_hint_loading);
                break;
        }
        this.f11485e = i;
    }

    public void setVisiableHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11481a.getLayoutParams();
        layoutParams.height = i;
        this.f11481a.setLayoutParams(layoutParams);
    }

    public int getVisiableHeight() {
        return this.f11481a.getLayoutParams().height;
    }
}
