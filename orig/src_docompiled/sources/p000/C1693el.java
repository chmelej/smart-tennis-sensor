package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: el */
/* JADX INFO: compiled from: ActionBarPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class C1693el {

    /* JADX INFO: renamed from: a */
    private Context f9609a;

    /* JADX INFO: renamed from: a */
    public static C1693el m9059a(Context context) {
        return new C1693el(context);
    }

    private C1693el(Context context) {
        this.f9609a = context;
    }

    /* JADX INFO: renamed from: a */
    public int m9060a() {
        Configuration configuration = this.f9609a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* JADX INFO: renamed from: b */
    public boolean m9061b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f9609a).hasPermanentMenuKey();
    }

    /* JADX INFO: renamed from: c */
    public int m9062c() {
        return this.f9609a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* JADX INFO: renamed from: d */
    public boolean m9063d() {
        return this.f9609a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    /* JADX INFO: renamed from: e */
    public int m9064e() {
        TypedArray typedArrayObtainStyledAttributes = this.f9609a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f9609a.getResources();
        if (!m9063d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* JADX INFO: renamed from: f */
    public boolean m9065f() {
        return this.f9609a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* JADX INFO: renamed from: g */
    public int m9066g() {
        return this.f9609a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
