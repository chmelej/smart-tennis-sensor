package cn.smssdk.gui.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class BackVerifyDialogLayout {
    public static LinearLayout create(Context context) {
        SizeHelper.prepare(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setId(Res.C0975id.tv_dialog_hint);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = SizeHelper.fromPxWidth(32);
        layoutParams.bottomMargin = SizeHelper.fromPxWidth(32);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(SizeHelper.fromPxWidth(18), 0, SizeHelper.fromPxWidth(18), 0);
        textView.setLineSpacing(SizeHelper.fromPxWidth(8), 1.0f);
        textView.setText(ResHelper.getStringRes(context, "smssdk_make_sure_mobile_detail"));
        textView.setTextColor(-1);
        textView.setTextSize(0, SizeHelper.fromPxWidth(26));
        textView.setGravity(17);
        linearLayout.addView(textView);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(1)));
        view.setBackgroundColor(-9211021);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Button button = new Button(context);
        button.setId(Res.C0975id.btn_dialog_ok);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, SizeHelper.fromPxWidth(78), 1.0f);
        layoutParams2.leftMargin = SizeHelper.fromPxWidth(3);
        button.setLayoutParams(layoutParams2);
        button.setBackgroundResource(ResHelper.getBitmapRes(context, "smssdk_dialog_btn_back"));
        int iFromPxWidth = SizeHelper.fromPxWidth(8);
        button.setPadding(iFromPxWidth, iFromPxWidth, iFromPxWidth, iFromPxWidth);
        button.setText(ResHelper.getStringRes(context, "smssdk_ok"));
        button.setTextSize(0, SizeHelper.fromPxWidth(22));
        button.setTextColor(-1);
        linearLayout2.addView(button);
        View view2 = new View(context);
        view2.setLayoutParams(new LinearLayout.LayoutParams(SizeHelper.fromPxWidth(1), -1));
        view2.setBackgroundColor(-9211021);
        linearLayout2.addView(view2);
        Button button2 = new Button(context);
        button2.setId(Res.C0975id.btn_dialog_cancel);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, SizeHelper.fromPxWidth(78), 1.0f);
        layoutParams3.rightMargin = SizeHelper.fromPxWidth(3);
        button2.setLayoutParams(layoutParams3);
        button2.setBackgroundResource(ResHelper.getBitmapRes(context, "smssdk_dialog_btn_back"));
        button2.setPadding(iFromPxWidth, iFromPxWidth, iFromPxWidth, iFromPxWidth);
        button2.setText(ResHelper.getStringRes(context, "smssdk_cancel"));
        button2.setTextSize(0, SizeHelper.fromPxWidth(22));
        button2.setTextColor(-1);
        linearLayout2.addView(button2);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }
}
