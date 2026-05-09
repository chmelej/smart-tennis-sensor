package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class BaseLineView extends RelativeLayout {

    /* JADX INFO: renamed from: a */
    private ImageView f7980a;

    /* JADX INFO: renamed from: b */
    private TextView f7981b;

    /* JADX INFO: renamed from: c */
    private TextView f7982c;

    /* JADX INFO: renamed from: d */
    private ImageView f7983d;

    /* JADX INFO: renamed from: e */
    private int f7984e;

    /* JADX INFO: renamed from: f */
    private int f7985f;

    /* JADX INFO: renamed from: g */
    private int f7986g;

    /* JADX INFO: renamed from: h */
    private int f7987h;

    /* JADX INFO: renamed from: i */
    private int f7988i;

    /* JADX INFO: renamed from: j */
    private Drawable f7989j;

    /* JADX INFO: renamed from: k */
    private Drawable f7990k;

    /* JADX INFO: renamed from: l */
    private boolean f7991l;

    /* JADX INFO: renamed from: m */
    private boolean f7992m;

    /* JADX INFO: renamed from: n */
    private String f7993n;

    /* JADX INFO: renamed from: o */
    private String f7994o;

    /* JADX INFO: renamed from: p */
    private ColorStateList f7995p;

    /* JADX INFO: renamed from: q */
    private ColorStateList f7996q;

    /* JADX INFO: renamed from: r */
    private int f7997r;

    /* JADX INFO: renamed from: s */
    private int f7998s;

    /* JADX INFO: renamed from: t */
    private int f7999t;

    public BaseLineView(Context context) {
        this(context, null);
    }

    public BaseLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7984e = 24;
        this.f7985f = 48;
        this.f7986g = 14;
        this.f7987h = 8;
        this.f7988i = 16;
        m8020a(context, attributeSet, 0);
    }

    public BaseLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7984e = 24;
        this.f7985f = 48;
        this.f7986g = 14;
        this.f7987h = 8;
        this.f7988i = 16;
        m8020a(context, attributeSet, i);
    }

    @TargetApi(21)
    public BaseLineView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f7984e = 24;
        this.f7985f = 48;
        this.f7986g = 14;
        this.f7987h = 8;
        this.f7988i = 16;
        m8020a(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m8020a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.baseLineView, i, 0);
        this.f7991l = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.f7992m = typedArrayObtainStyledAttributes.getBoolean(8, true);
        this.f7989j = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f7990k = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f7993n = typedArrayObtainStyledAttributes.getString(4);
        this.f7994o = typedArrayObtainStyledAttributes.getString(9);
        this.f7995p = typedArrayObtainStyledAttributes.getColorStateList(5);
        this.f7996q = typedArrayObtainStyledAttributes.getColorStateList(10);
        this.f7997r = C1895ly.m10461b(context, typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        this.f7998s = C1895ly.m10461b(context, typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0));
        this.f7999t = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (this.f7997r == 0) {
            this.f7997r = this.f7986g;
        }
        if (this.f7998s == 0) {
            this.f7998s = this.f7986g;
        }
        if (this.f7999t == 0) {
            this.f7999t = C1895ly.m10460a(context, this.f7988i);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (this.f7993n == null) {
            this.f7993n = "";
        }
        if (this.f7994o == null) {
            this.f7994o = "";
        }
        if (this.f7995p == null) {
            this.f7995p = ColorStateList.valueOf(-16777216);
        }
        if (this.f7996q == null) {
            this.f7996q = ColorStateList.valueOf(-16777216);
        }
        int i2 = this.f7999t;
        int iM10460a = C1895ly.m10460a(context, this.f7987h);
        setPadding(i2, iM10460a, i2, iM10460a);
        m8019a();
        m8021b();
        m8022c();
        m8023d();
        addView(this.f7980a);
        addView(this.f7983d);
        addView(this.f7981b);
        addView(this.f7982c);
    }

    /* JADX INFO: renamed from: a */
    private void m8019a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C1895ly.m10460a(getContext(), this.f7984e), C1895ly.m10460a(getContext(), this.f7984e));
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        this.f7980a = new ImageView(getContext());
        this.f7980a.setLayoutParams(layoutParams);
        this.f7980a.setId(R.id.baseline_left_img);
        if (this.f7991l && this.f7989j != null) {
            this.f7980a.setImageDrawable(this.f7989j);
            this.f7980a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.f7980a.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8021b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C1895ly.m10460a(getContext(), this.f7984e), C1895ly.m10460a(getContext(), this.f7984e));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f7983d = new ImageView(getContext());
        this.f7983d.setLayoutParams(layoutParams);
        this.f7983d.setId(R.id.baseline_right_img);
        if (this.f7992m && this.f7990k != null) {
            this.f7983d.setImageDrawable(this.f7990k);
            this.f7983d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            if (this.f7992m) {
                return;
            }
            this.f7983d.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m8022c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (this.f7991l && this.f7989j != null) {
            layoutParams.addRule(1, this.f7980a.getId());
            layoutParams.setMargins(C1895ly.m10460a(getContext(), this.f7987h), 0, C1895ly.m10460a(getContext(), this.f7987h), 0);
        } else {
            layoutParams.addRule(9);
        }
        this.f7981b = new TextView(getContext());
        this.f7981b.setText(this.f7993n);
        this.f7981b.setTextColor(this.f7995p);
        this.f7981b.setTextSize(this.f7997r);
        this.f7981b.setSingleLine(true);
        this.f7981b.setLayoutParams(layoutParams);
        this.f7981b.setId(R.id.baseline_left_text);
    }

    /* JADX INFO: renamed from: d */
    private void m8023d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.f7981b.getId());
        if (this.f7992m) {
            layoutParams.addRule(0, this.f7983d.getId());
            layoutParams.setMargins(C1895ly.m10460a(getContext(), 50.0f), 0, C1895ly.m10460a(getContext(), this.f7987h), 0);
        } else {
            layoutParams.addRule(11);
            layoutParams.setMargins(C1895ly.m10460a(getContext(), 50.0f), 0, C1895ly.m10460a(getContext(), this.f7987h), 0);
        }
        this.f7982c = new TextView(getContext());
        this.f7982c.setText(this.f7994o);
        this.f7982c.setTextColor(this.f7996q);
        this.f7982c.setGravity(5);
        this.f7982c.setSingleLine(true);
        this.f7982c.setEllipsize(TextUtils.TruncateAt.END);
        this.f7982c.setTextSize(this.f7998s);
        this.f7982c.setLayoutParams(layoutParams);
        this.f7982c.setId(R.id.baseline_right_text);
    }

    public void setLeftText(String str) {
        this.f7993n = str;
        this.f7981b.setText(str);
    }

    public void setLeftTextColor(ColorStateList colorStateList) {
        this.f7995p = colorStateList;
        this.f7981b.setTextColor(colorStateList);
    }

    public void setLeftTextSize(int i) {
        this.f7997r = i;
        this.f7981b.setTextSize(i);
    }

    public void setRightText(String str) {
        this.f7994o = str;
        this.f7982c.setText(str);
    }

    public void setRightTextColor(ColorStateList colorStateList) {
        this.f7996q = colorStateList;
        this.f7982c.setTextColor(colorStateList);
    }

    public void setRightTextSize(int i) {
        this.f7998s = i;
        this.f7982c.setTextSize(i);
    }

    public void setImgLeftDrawable(Drawable drawable) {
        if (drawable != null) {
            setImgLeftVisible(0, drawable);
        } else {
            setImgLeftVisible(8, null);
        }
    }

    public void setImgLeftResource(int i) {
        this.f7991l = true;
        this.f7980a.setImageResource(i);
        m8022c();
    }

    public void setImgLeftVisible(int i, Drawable drawable) {
        if (i == 0 && drawable != null) {
            this.f7991l = true;
            this.f7989j = drawable;
            this.f7980a.setImageDrawable(drawable);
        } else {
            this.f7991l = false;
            this.f7989j = null;
            this.f7980a.setVisibility(8);
        }
        m8022c();
    }

    public void setImgRightDrawable(Drawable drawable) {
        setImgRightVisible(0, drawable);
    }

    public void setImgRightVisible(int i, Drawable drawable) {
        if (i == 0) {
            this.f7983d.setVisibility(0);
            this.f7983d.setImageDrawable(drawable);
            this.f7992m = true;
            this.f7990k = drawable;
        } else {
            this.f7983d.setVisibility(8);
            this.f7992m = false;
        }
        m8023d();
    }

    public String getRightContent() {
        String string = this.f7982c.getText().toString();
        return string != null ? string : "";
    }
}
