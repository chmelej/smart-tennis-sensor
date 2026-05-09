package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.RippleView;

/* JADX INFO: loaded from: classes.dex */
public class NavigateView extends RelativeLayout {

    /* JADX INFO: renamed from: i */
    private static boolean f8483i = false;

    /* JADX INFO: renamed from: a */
    public RippleView f8484a;

    /* JADX INFO: renamed from: b */
    public RippleView f8485b;

    /* JADX INFO: renamed from: c */
    public RelativeLayout f8486c;

    /* JADX INFO: renamed from: d */
    public Button f8487d;

    /* JADX INFO: renamed from: e */
    private TextView f8488e;

    /* JADX INFO: renamed from: f */
    private Context f8489f;

    /* JADX INFO: renamed from: g */
    private Button f8490g;

    /* JADX INFO: renamed from: h */
    private ImageView f8491h;

    public NavigateView(Context context) {
        super(context);
        this.f8488e = null;
        this.f8484a = null;
        this.f8485b = null;
        this.f8486c = null;
    }

    public NavigateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8488e = null;
        this.f8484a = null;
        this.f8485b = null;
        this.f8486c = null;
        this.f8489f = context;
        LayoutInflater.from(context).inflate(R.layout.navigate_view, (ViewGroup) this, true);
        this.f8488e = (TextView) findViewById(R.id.navigateTitle);
        this.f8484a = (RippleView) findViewById(R.id.leftBtn);
        this.f8484a.setOnRippleCompleteListener(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.widget.NavigateView.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                if (NavigateView.this.f8489f instanceof BaseActivity) {
                    ((BaseActivity) NavigateView.this.f8489f).m7733j();
                }
            }
        });
        this.f8485b = (RippleView) findViewById(R.id.rightBtn);
        this.f8487d = (Button) findViewById(R.id.bt_right);
        this.f8490g = (Button) findViewById(R.id.bt_left);
        this.f8486c = (RelativeLayout) findViewById(R.id.navigate_bg);
        this.f8491h = (ImageView) findViewById(R.id.imgv_right);
        this.f8486c.setEnabled(f8483i);
    }

    public void setLeftButtonTextblodtrue() {
        this.f8490g.getPaint().setFakeBoldText(true);
    }

    public void setLeftButtonTextSize(int i) {
        this.f8490g.setTextSize(i);
    }

    public void setLeftButtonBackground(int i) {
        this.f8490g.setBackgroundResource(i);
    }

    public void setLeftButtonText(String str) {
        this.f8490g.setText(str);
    }

    public void setLeftButtonTextColor(int i) {
        this.f8490g.setTextColor(getResources().getColor(i));
    }

    public void setRightButtonText(String str) {
        this.f8487d.setText(str);
    }

    public void setLeftButtonClicklistner(RippleView.InterfaceC1365a interfaceC1365a) {
        this.f8484a.setOnRippleCompleteListener(interfaceC1365a);
    }

    public void setRightImg(int i) {
        this.f8487d.setVisibility(8);
        this.f8491h.setVisibility(0);
        this.f8491h.setImageResource(i);
    }

    public void setRightButtonTextColor(int i) {
        this.f8487d.setTextColor(getResources().getColor(i));
    }

    public void setRightButtonTextSize(int i) {
        this.f8487d.setTextSize(i);
    }

    public void setRightButtonBackground(int i) {
        this.f8487d.setBackgroundResource(i);
    }

    public void setRightButtonBackground(Drawable drawable) {
        this.f8487d.setBackgroundDrawable(drawable);
    }

    public void setRightButtonClicklistner(RippleView.InterfaceC1365a interfaceC1365a) {
        this.f8485b.setOnRippleCompleteListener(interfaceC1365a);
    }

    public void setRightButtonClicklistner(View.OnClickListener onClickListener) {
        this.f8485b.setOnClickListener(onClickListener);
    }

    public void setTitleBackground(int i) {
        this.f8486c.setBackgroundResource(i);
    }

    public void setTitleBackgroundColor(int i) {
        this.f8486c.setBackgroundColor(i);
    }

    public void setTitle(String str) {
        this.f8488e.setText(str);
    }

    public void setTitleTextSize(int i) {
        this.f8488e.setTextSize(i);
    }

    public void setTitle(int i) {
        this.f8488e.setText(i);
    }

    public void setTitleColor(int i) {
        this.f8488e.setTextColor(i);
    }

    public void setLeftHideBtn(boolean z) {
        m8192a(this.f8484a, z);
    }

    public void setRightHideBtn(boolean z) {
        m8192a(this.f8485b, z);
    }

    /* JADX INFO: renamed from: a */
    private void m8192a(View view, boolean z) {
        if (z) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public void setEnable(boolean z) {
        this.f8486c.setEnabled(z);
        f8483i = z;
    }
}
