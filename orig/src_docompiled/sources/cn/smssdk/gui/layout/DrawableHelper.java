package cn.smssdk.gui.layout;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableHelper {
    public static Drawable createCornerBg(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, createCornerBgPressed(context));
        stateListDrawable.addState(new int[0], createCornerBgNormal(context));
        return stateListDrawable;
    }

    public static Drawable createCornerBgNormal(Context context) {
        SizeHelper.prepare(context);
        int iFromPxWidth = SizeHelper.fromPxWidth(1);
        int iFromPxWidth2 = SizeHelper.fromPxWidth(6);
        int color = Color.parseColor("#ffc9c9cb");
        int color2 = Color.parseColor("#ffffffff");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        gradientDrawable.setCornerRadius(iFromPxWidth2);
        gradientDrawable.setStroke(iFromPxWidth, color);
        return gradientDrawable;
    }

    public static Drawable createCornerBgPressed(Context context) {
        SizeHelper.prepare(context);
        int iFromPxWidth = SizeHelper.fromPxWidth(1);
        int iFromPxWidth2 = SizeHelper.fromPxWidth(6);
        int color = Color.parseColor("#ffc9c9cb");
        int color2 = Color.parseColor("#afc9c9cb");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        gradientDrawable.setCornerRadius(iFromPxWidth2);
        gradientDrawable.setStroke(iFromPxWidth, color);
        return gradientDrawable;
    }
}
