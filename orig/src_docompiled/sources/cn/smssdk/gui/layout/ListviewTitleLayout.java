package cn.smssdk.gui.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class ListviewTitleLayout {
    static RelativeLayout create(Context context) {
        SizeHelper.prepare(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(Res.C0975id.tv_title);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, SizeHelper.fromPxWidth(40));
        layoutParams.topMargin = SizeHelper.fromPxWidth(-20);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(SizeHelper.fromPxWidth(20), 0, 0, 0);
        textView.setLineSpacing(SizeHelper.fromPxWidth(8), 1.0f);
        textView.setText(ResHelper.getStringRes(context, "smssdk_regist"));
        textView.setTextColor(Res.color.smssdk_lv_title_color);
        textView.setTextSize(0, SizeHelper.fromPxWidth(26));
        textView.setGravity(16);
        textView.setBackgroundColor(-1382162);
        relativeLayout.addView(textView);
        return relativeLayout;
    }
}
