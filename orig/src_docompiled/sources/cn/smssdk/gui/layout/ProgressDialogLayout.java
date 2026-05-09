package cn.smssdk.gui.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class ProgressDialogLayout {
    public static LinearLayout create(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        SizeHelper.prepare(context);
        int iFromPxWidth = SizeHelper.fromPxWidth(20);
        progressBar.setPadding(iFromPxWidth, iFromPxWidth, iFromPxWidth, iFromPxWidth);
        linearLayout.addView(progressBar);
        return linearLayout;
    }
}
