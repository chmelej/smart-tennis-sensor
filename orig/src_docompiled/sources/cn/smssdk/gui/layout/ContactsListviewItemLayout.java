package cn.smssdk.gui.layout;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class ContactsListviewItemLayout {
    public static RelativeLayout create(Context context) {
        SizeHelper.prepare(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(Res.C0975id.rl_lv_item_bg);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, SizeHelper.fromPxWidth(95)));
        int iFromPxWidth = SizeHelper.fromPxWidth(14);
        relativeLayout.setPadding(iFromPxWidth, iFromPxWidth, iFromPxWidth, iFromPxWidth);
        relativeLayout.setGravity(16);
        relativeLayout.setBackgroundColor(-1);
        AsyncImageView asyncImageView = new AsyncImageView(context);
        asyncImageView.setId(Res.C0975id.iv_contact);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SizeHelper.fromPxWidth(64), SizeHelper.fromPxWidth(64));
        layoutParams.addRule(9);
        asyncImageView.setLayoutParams(layoutParams);
        asyncImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        relativeLayout.addView(asyncImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, Res.C0975id.iv_contact);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = SizeHelper.fromPxWidth(12);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(context);
        textView.setId(Res.C0975id.tv_name);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(-13421773);
        textView.setTextSize(0, SizeHelper.fromPxWidth(28));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(Res.C0975id.tv_contact);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setTextColor(Res.color.smssdk_lv_title_color);
        textView2.setTextSize(0, SizeHelper.fromPxWidth(22));
        linearLayout.addView(textView2);
        Button button = new Button(context);
        button.setId(Res.C0975id.btn_add);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(SizeHelper.fromPxWidth(92), SizeHelper.fromPxWidth(46));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        button.setLayoutParams(layoutParams3);
        button.setText(ResHelper.getStringRes(context, "smssdk_add_contact"));
        button.setTextSize(0, SizeHelper.fromPxWidth(22));
        button.setTextColor(-8816263);
        button.setBackgroundDrawable(DrawableHelper.createCornerBg(context));
        button.setPadding(0, 0, 0, 0);
        relativeLayout.addView(button);
        return relativeLayout;
    }
}
