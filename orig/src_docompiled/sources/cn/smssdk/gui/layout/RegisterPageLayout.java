package cn.smssdk.gui.layout;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class RegisterPageLayout extends BasePageLayout {
    public RegisterPageLayout(Context context) {
        super(context, false);
    }

    @Override // cn.smssdk.gui.layout.BasePageLayout
    protected void onCreateContent(LinearLayout linearLayout) {
        SizeHelper.prepare(this.context);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(96));
        layoutParams.setMargins(SizeHelper.fromPx(26), SizeHelper.fromPxWidth(32), SizeHelper.fromPxWidth(26), 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setId(Res.C0975id.rl_country);
        TextView textView = new TextView(this.context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        textView.setLayoutParams(layoutParams2);
        textView.setPadding(SizeHelper.fromPxWidth(14), 0, SizeHelper.fromPxWidth(14), 0);
        textView.setText(ResHelper.getStringRes(this.context, "smssdk_country"));
        textView.setTextColor(-16777216);
        textView.setTextSize(0, SizeHelper.fromPxWidth(25));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.context);
        textView2.setId(Res.C0975id.tv_country);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        layoutParams3.rightMargin = SizeHelper.fromPxWidth(14);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(5);
        textView2.setPadding(SizeHelper.fromPxWidth(14), 0, SizeHelper.fromPxWidth(14), 0);
        textView2.setTextColor(-12206054);
        textView2.setTextSize(0, SizeHelper.fromPxWidth(25));
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        View view = new View(this.context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SizeHelper.fromPxWidth(1));
        layoutParams4.leftMargin = SizeHelper.fromPxWidth(26);
        layoutParams4.rightMargin = SizeHelper.fromPxWidth(26);
        view.setLayoutParams(layoutParams4);
        view.setBackgroundColor(Res.color.smssdk_gray_press);
        linearLayout.addView(view);
        LinearLayout linearLayout3 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(70));
        layoutParams5.setMargins(SizeHelper.fromPxWidth(26), SizeHelper.fromPxWidth(30), SizeHelper.fromPxWidth(26), 0);
        linearLayout3.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(this.context);
        textView3.setId(Res.C0975id.tv_country_num);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(SizeHelper.fromPxWidth(104), -1));
        textView3.setGravity(17);
        textView3.setTextColor(Res.color.smssdk_lv_tv_color);
        textView3.setTextSize(0, SizeHelper.fromPxWidth(25));
        textView3.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_input_bg_focus"));
        linearLayout3.addView(textView3);
        LinearLayout linearLayout4 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.weight = 1.0f;
        linearLayout4.setLayoutParams(layoutParams6);
        linearLayout4.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_input_bg_special_focus"));
        EditText editText = new EditText(this.context);
        editText.setId(Res.C0975id.et_write_phone);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.gravity = 16;
        layoutParams7.setMargins(SizeHelper.fromPxWidth(10), 0, SizeHelper.fromPxWidth(10), 0);
        layoutParams7.weight = 1.0f;
        editText.setLayoutParams(layoutParams7);
        editText.setBackgroundDrawable(null);
        editText.setHint(ResHelper.getStringRes(this.context, "smssdk_write_mobile_phone"));
        editText.setInputType(3);
        editText.setTextColor(Res.color.smssdk_lv_tv_color);
        editText.setTextSize(0, SizeHelper.fromPxWidth(25));
        linearLayout4.addView(editText);
        ImageView imageView = new ImageView(this.context);
        imageView.setId(Res.C0975id.iv_clear);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(SizeHelper.fromPxWidth(24), SizeHelper.fromPxWidth(24));
        layoutParams8.gravity = 16;
        layoutParams8.rightMargin = SizeHelper.fromPxWidth(20);
        imageView.setLayoutParams(layoutParams8);
        imageView.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_clear_search"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setVisibility(8);
        linearLayout4.addView(imageView);
        linearLayout3.addView(linearLayout4);
        linearLayout.addView(linearLayout3);
        Button button = new Button(this.context);
        button.setId(Res.C0975id.btn_next);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(72));
        layoutParams9.setMargins(SizeHelper.fromPxWidth(26), SizeHelper.fromPxWidth(36), SizeHelper.fromPxWidth(26), 0);
        button.setLayoutParams(layoutParams9);
        button.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_btn_disenable"));
        button.setText(ResHelper.getStringRes(this.context, "smssdk_next"));
        button.setTextColor(-1);
        button.setTextSize(0, SizeHelper.fromPxWidth(25));
        button.setPadding(0, 0, 0, 0);
        linearLayout.addView(button);
    }
}
