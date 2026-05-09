package cn.smssdk.gui.layout;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailPageLayout extends BasePageLayout {
    public ContactDetailPageLayout(Context context) {
        super(context, false);
    }

    @Override // cn.smssdk.gui.layout.BasePageLayout
    protected void onCreateContent(LinearLayout linearLayout) {
        SizeHelper.prepare(this.context);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(SizeHelper.fromPxWidth(25), SizeHelper.fromPxWidth(30), SizeHelper.fromPxWidth(25), 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundDrawable(DrawableHelper.createCornerBgNormal(this.context));
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(this.context);
        imageView.setId(Res.C0975id.iv_contact_icon);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(SizeHelper.fromPxWidth(88), SizeHelper.fromPxWidth(88));
        int iFromPxWidth = SizeHelper.fromPxWidth(16);
        layoutParams2.setMargins(iFromPxWidth, iFromPxWidth, iFromPxWidth, iFromPxWidth);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_default_avatar"));
        linearLayout2.addView(imageView);
        LinearLayout linearLayout3 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(SizeHelper.fromPxWidth(4), SizeHelper.fromPxWidth(10), 0, SizeHelper.fromPxWidth(15));
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setOrientation(1);
        linearLayout2.addView(linearLayout3);
        TextView textView = new TextView(this.context);
        textView.setId(Res.C0975id.tv_contact_name);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = SizeHelper.fromPxWidth(10);
        textView.setLayoutParams(layoutParams4);
        textView.setTextColor(-16777216);
        textView.setTextSize(0, SizeHelper.fromPxWidth(24));
        linearLayout3.addView(textView);
        LinearLayout linearLayout4 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(0, SizeHelper.fromPxWidth(10), SizeHelper.fromPxWidth(15), 0);
        linearLayout4.setLayoutParams(layoutParams5);
        linearLayout4.setOrientation(0);
        linearLayout3.addView(linearLayout4);
        TextView textView2 = new TextView(this.context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText(ResHelper.getStringRes(this.context, "smssdk_contacts_phones"));
        textView2.setTextColor(-16777216);
        textView2.setTextSize(0, SizeHelper.fromPxWidth(20));
        linearLayout4.addView(textView2);
        TextView textView3 = new TextView(this.context);
        textView3.setId(Res.C0975id.tv_contact_phones);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = SizeHelper.fromPxWidth(10);
        textView3.setLayoutParams(layoutParams6);
        textView3.setTextColor(-16777216);
        textView3.setTextSize(0, SizeHelper.fromPxWidth(20));
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(this.context);
        textView4.setId(Res.C0975id.tv_invite_hint);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.setMargins(SizeHelper.fromPxWidth(26), SizeHelper.fromPxWidth(24), SizeHelper.fromPxWidth(26), 0);
        layoutParams7.gravity = 1;
        textView4.setLayoutParams(layoutParams7);
        textView4.setTextColor(-10724260);
        textView4.setTextSize(0, SizeHelper.fromPxWidth(28));
        linearLayout.addView(textView4);
        Button button = new Button(this.context);
        button.setId(Res.C0975id.btn_invite);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, SizeHelper.fromPxWidth(72));
        layoutParams8.setMargins(SizeHelper.fromPxWidth(26), SizeHelper.fromPxWidth(22), SizeHelper.fromPxWidth(26), 0);
        button.setLayoutParams(layoutParams8);
        button.setBackgroundResource(ResHelper.getBitmapRes(this.context, "smssdk_btn_enable"));
        button.setText(ResHelper.getStringRes(this.context, "smssdk_send_invitation"));
        button.setTextColor(-1);
        button.setTextSize(0, SizeHelper.fromPxWidth(28));
        button.setPadding(0, 0, 0, 0);
        linearLayout.addView(button);
    }
}
