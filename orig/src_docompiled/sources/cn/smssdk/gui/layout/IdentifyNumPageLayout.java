package cn.smssdk.gui.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class IdentifyNumPageLayout extends BasePageLayout {
    public IdentifyNumPageLayout(Context context) {
        super(context, false);
    }

    @Override // cn.smssdk.gui.layout.BasePageLayout
    protected void onCreateContent(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(SizeHelper.fromPxWidth(26), 0, SizeHelper.fromPxWidth(26), 0);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(this.context);
        textView.setId(Res.C0975id.tv_identify_notify);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = SizeHelper.fromPxWidth(32);
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        textView.setText(ResHelper.getStringRes(this.context, "smssdk_make_sure_mobile_detail"));
        textView.setTextColor(Res.color.smssdk_lv_title_color);
        textView.setTextSize(0, SizeHelper.fromPxWidth(24));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.context);
        textView2.setId(Res.C0975id.tv_phone);
        new LinearLayout.LayoutParams(-1, -2).topMargin = SizeHelper.fromPxWidth(50);
        textView2.setGravity(17);
        textView2.setLayoutParams(layoutParams);
        textView2.setTextColor(Res.color.smssdk_lv_tv_color);
        textView2.setTextSize(0, SizeHelper.fromPxWidth(26));
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout2.addView(textView2);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(72));
        layoutParams2.topMargin = SizeHelper.fromPxWidth(38);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_input_bg_focus"));
        linearLayout2.addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.leftMargin = SizeHelper.fromPxWidth(18);
        EditText editText = new EditText(this.context);
        editText.setLayoutParams(layoutParams3);
        editText.setId(Res.C0975id.et_put_identify);
        editText.setHint(ResHelper.getStringRes(this.context, "smssdk_write_identify_code"));
        editText.setBackgroundColor(-1);
        editText.setSingleLine(true);
        editText.setTextSize(0, SizeHelper.fromPxWidth(24));
        editText.setInputType(2);
        relativeLayout.addView(editText);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(SizeHelper.fromPxWidth(34), SizeHelper.fromPxWidth(34));
        layoutParams4.addRule(15);
        layoutParams4.addRule(7, Res.C0975id.et_put_identify);
        ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(layoutParams4);
        imageView.setId(Res.C0975id.iv_clear);
        imageView.setImageResource(ResHelper.getBitmapRes(this.context, "smssdk_clear_search"));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setVisibility(8);
        relativeLayout.addView(imageView);
        Button button = new Button(this.context);
        button.setId(Res.C0975id.btn_sounds);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, SizeHelper.fromPxWidth(54));
        layoutParams5.addRule(12);
        layoutParams5.addRule(7, Res.C0975id.et_put_identify);
        button.setLayoutParams(layoutParams5);
        button.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_btn_disenable"));
        button.setText(ResHelper.getStringRes(this.context, "smssdk_send_sounds"));
        button.setTextColor(-1);
        button.setTextSize(0, SizeHelper.fromPxWidth(20));
        int iFromPxWidth = SizeHelper.fromPxWidth(18);
        button.setPadding(iFromPxWidth, 0, iFromPxWidth, 0);
        button.setVisibility(8);
        relativeLayout.addView(button);
        TextView textView3 = new TextView(this.context);
        textView3.setId(Res.C0975id.tv_unreceive_identify);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.setMargins(0, SizeHelper.fromPxWidth(34), 0, SizeHelper.fromPxWidth(30));
        textView3.setLayoutParams(layoutParams6);
        textView3.setGravity(17);
        textView3.setText(ResHelper.getStringRes(this.context, "smssdk_receive_msg"));
        textView3.setTextColor(-10724260);
        textView3.setTextSize(0, SizeHelper.fromPxWidth(22));
        linearLayout2.addView(textView3);
        Button button2 = new Button(this.context);
        button2.setId(Res.C0975id.btn_submit);
        button2.setLayoutParams(new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(72)));
        button2.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_btn_disenable"));
        button2.setText(ResHelper.getStringRes(this.context, "smssdk_next"));
        button2.setTextColor(-1);
        button2.setTextSize(0, SizeHelper.fromPxWidth(24));
        button2.setPadding(SizeHelper.fromPxWidth(10), 0, SizeHelper.fromPxWidth(10), 0);
        linearLayout2.addView(button2);
    }
}
