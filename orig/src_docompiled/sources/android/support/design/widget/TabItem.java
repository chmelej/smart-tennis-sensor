package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.util.AttributeSet;
import android.view.View;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: a */
    public final CharSequence f2541a;

    /* JADX INFO: renamed from: b */
    public final Drawable f2542b;

    /* JADX INFO: renamed from: c */
    public final int f2543c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1766hd c1766hdM9600a = C1766hd.m9600a(context, attributeSet, R.styleable.TabItem);
        this.f2541a = c1766hdM9600a.m9612c(R.styleable.TabItem_android_text);
        this.f2542b = c1766hdM9600a.m9605a(R.styleable.TabItem_android_icon);
        this.f2543c = c1766hdM9600a.m9619g(R.styleable.TabItem_android_layout, 0);
        c1766hdM9600a.m9606a();
    }
}
