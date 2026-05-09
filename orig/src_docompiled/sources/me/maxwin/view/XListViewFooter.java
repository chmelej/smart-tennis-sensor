package me.maxwin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import me.maxwin.R;

/* JADX INFO: loaded from: classes.dex */
public class XListViewFooter extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private Context f11478a;

    /* JADX INFO: renamed from: b */
    private View f11479b;

    /* JADX INFO: renamed from: c */
    private View f11480c;

    public XListViewFooter(Context context) {
        super(context);
        m10513a(context);
    }

    public XListViewFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10513a(context);
    }

    public void setState(int i) {
        this.f11480c.setVisibility(4);
        if (i != 1 && i == 2) {
            this.f11480c.setVisibility(0);
        }
    }

    public void setBottomMargin(int i) {
        if (i < 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11479b.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.f11479b.setLayoutParams(layoutParams);
    }

    public int getBottomMargin() {
        return ((LinearLayout.LayoutParams) this.f11479b.getLayoutParams()).bottomMargin;
    }

    /* JADX INFO: renamed from: a */
    private void m10513a(Context context) {
        this.f11478a = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f11478a).inflate(R.layout.xlistview_footer, (ViewGroup) null);
        addView(linearLayout);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f11479b = linearLayout.findViewById(R.id.xlistview_footer_content);
        this.f11480c = linearLayout.findViewById(R.id.xlistview_footer_progressbar);
    }
}
