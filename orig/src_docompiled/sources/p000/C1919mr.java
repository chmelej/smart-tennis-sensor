package p000;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: mr */
/* JADX INFO: compiled from: StatusBarCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C1919mr {

    /* JADX INFO: renamed from: a */
    private static final int f11550a = Color.parseColor("#20000000");

    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    public static void m10597a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i2 = f11550a;
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
            if (i == -1) {
                i = i2;
            }
            View view = new View(activity);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, m10596a(activity));
            view.setBackgroundColor(i);
            viewGroup.addView(view, layoutParams);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m10596a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
