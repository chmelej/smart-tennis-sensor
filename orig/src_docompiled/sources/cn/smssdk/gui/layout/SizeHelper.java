package cn.smssdk.gui.layout;

import android.content.Context;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class SizeHelper {
    private static Context context = null;
    public static float designedDensity = 1.5f;
    public static int designedScreenWidth = 540;
    protected static SizeHelper helper;

    private SizeHelper() {
    }

    public static void prepare(Context context2) {
        if (context == null || context != context2.getApplicationContext()) {
            context = context2;
        }
    }

    public static int fromPx(int i) {
        return ResHelper.designToDevice(context, designedDensity, i);
    }

    public static int fromPxWidth(int i) {
        return ResHelper.designToDevice(context, designedScreenWidth, i);
    }

    public static int fromDp(int i) {
        return ResHelper.designToDevice(context, designedDensity, ResHelper.dipToPx(context, i));
    }
}
