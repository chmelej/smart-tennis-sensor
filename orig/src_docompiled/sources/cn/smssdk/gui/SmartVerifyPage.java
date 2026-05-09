package cn.smssdk.gui;

import android.app.Dialog;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.BackVerifyDialogLayout;
import cn.smssdk.gui.layout.IdentifyNumPageLayout;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.gui.layout.SizeHelper;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SmartVerifyPage extends FakeActivity implements View.OnClickListener {
    private static final int RETRY_INTERVAL = 60;
    private Button btnSubmit;
    private String code;
    private EditText etIdentifyNum;
    private String formatedPhone;
    private ImageView ivClear;

    /* JADX INFO: renamed from: pd */
    private Dialog f6070pd;
    private String phone;
    private TextView tvIdentifyNotify;
    private TextView tvPhone;
    private TextView tvTitle;
    private TextView tvUnreceiveIdentify;
    private int time = 60;
    private boolean showSmart = false;

    static /* synthetic */ int access$010(SmartVerifyPage smartVerifyPage) {
        int i = smartVerifyPage.time;
        smartVerifyPage.time = i - 1;
        return i;
    }

    public void setPhone(String str, String str2, String str3) {
        this.phone = str;
        this.code = str2;
        this.formatedPhone = str3;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new IdentifyNumPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.activity.findViewById(Res.C0975id.ll_back).setOnClickListener(this);
            this.btnSubmit = (Button) this.activity.findViewById(Res.C0975id.btn_submit);
            this.btnSubmit.setOnClickListener(this);
            this.btnSubmit.setEnabled(false);
            this.tvTitle = (TextView) this.activity.findViewById(Res.C0975id.tv_title);
            int stringRes = C1583R.getStringRes(this.activity, "smssdk_write_identify_code");
            if (stringRes > 0) {
                this.tvTitle.setText(stringRes);
            }
            this.etIdentifyNum = (EditText) this.activity.findViewById(Res.C0975id.et_put_identify);
            this.tvIdentifyNotify = (TextView) this.activity.findViewById(Res.C0975id.tv_identify_notify);
            int stringRes2 = C1583R.getStringRes(this.activity, "smssdk_send_mobile_detail");
            if (stringRes2 > 0) {
                this.tvIdentifyNotify.setText(Html.fromHtml(getContext().getString(stringRes2)));
            }
            this.tvPhone = (TextView) this.activity.findViewById(Res.C0975id.tv_phone);
            this.tvPhone.setText(this.formatedPhone);
            this.tvUnreceiveIdentify = (TextView) this.activity.findViewById(Res.C0975id.tv_unreceive_identify);
            int stringRes3 = C1583R.getStringRes(this.activity, "smssdk_receive_msg");
            if (stringRes3 > 0) {
                this.tvUnreceiveIdentify.setText(Html.fromHtml(getContext().getString(stringRes3, Integer.valueOf(this.time))));
            }
            this.tvUnreceiveIdentify.setOnClickListener(this);
            this.tvUnreceiveIdentify.setEnabled(false);
            this.ivClear = (ImageView) this.activity.findViewById(Res.C0975id.iv_clear);
            this.ivClear.setOnClickListener(this);
            countDown();
        }
    }

    private void countDown() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.1
            @Override // java.lang.Runnable
            public void run() {
                SmartVerifyPage.access$010(SmartVerifyPage.this);
                if (SmartVerifyPage.this.time == 58) {
                    SmartVerifyPage.this.btnSubmit.setEnabled(true);
                    int bitmapRes = C1583R.getBitmapRes(SmartVerifyPage.this.activity, "smssdk_btn_enable");
                    if (bitmapRes > 0) {
                        SmartVerifyPage.this.btnSubmit.setBackgroundResource(bitmapRes);
                    }
                    SmartVerifyPage.this.etIdentifyNum.setText(C1583R.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_already"));
                    SmartVerifyPage.this.etIdentifyNum.setEnabled(false);
                    SmartVerifyPage.this.etIdentifyNum.setPadding(0, 0, 0, 0);
                    SmartVerifyPage.this.etIdentifyNum.setTextSize(0, SizeHelper.fromPxWidth(32));
                    SmartVerifyPage.this.etIdentifyNum.setGravity(17);
                    SmartVerifyPage.this.etIdentifyNum.invalidate();
                    SmartVerifyPage.this.tvIdentifyNotify.setText(C1583R.getStringRes(SmartVerifyPage.this.activity, "smssdk_smart_verify_tips"));
                    SmartVerifyPage.this.tvUnreceiveIdentify.setVisibility(4);
                    SmartVerifyPage.this.showSmart = true;
                    SmartVerifyPage.this.time = 60;
                    return;
                }
                int stringRes = C1583R.getStringRes(SmartVerifyPage.this.activity, "smssdk_receive_msg");
                if (stringRes > 0) {
                    SmartVerifyPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(SmartVerifyPage.this.getContext().getString(stringRes, Integer.valueOf(SmartVerifyPage.this.time))));
                }
                SmartVerifyPage.this.tvUnreceiveIdentify.setEnabled(false);
                SmartVerifyPage.this.runOnUIThread(this, 1000L);
            }
        }, 1000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            if (this.showSmart) {
                finish();
                return;
            } else {
                runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SmartVerifyPage.this.showNotifyDialog();
                    }
                });
                return;
            }
        }
        if (id != 1881145360) {
            if (id == 117571589) {
                this.etIdentifyNum.getText().clear();
            }
        } else {
            HashMap map = new HashMap();
            map.put("country", this.code);
            map.put("phone", this.phone);
            afterSubmit(map);
        }
    }

    private void afterSubmit(final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.SmartVerifyPage.3
            @Override // java.lang.Runnable
            public void run() {
                if (SmartVerifyPage.this.f6070pd != null && SmartVerifyPage.this.f6070pd.isShowing()) {
                    SmartVerifyPage.this.f6070pd.dismiss();
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("res", true);
                map.put("page", 2);
                map.put("phone", obj);
                SmartVerifyPage.this.setResult(map);
                SmartVerifyPage.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotifyDialog() {
        int styleRes = C1583R.getStyleRes(this.activity, "CommonDialog");
        if (styleRes > 0) {
            final Dialog dialog = new Dialog(getContext(), styleRes);
            LinearLayout linearLayoutCreate = BackVerifyDialogLayout.create(this.activity);
            if (linearLayoutCreate != null) {
                dialog.setContentView(linearLayoutCreate);
                TextView textView = (TextView) dialog.findViewById(Res.C0975id.tv_dialog_hint);
                int stringRes = C1583R.getStringRes(this.activity, "smssdk_close_identify_page_dialog");
                if (stringRes > 0) {
                    textView.setText(stringRes);
                }
                Button button = (Button) dialog.findViewById(Res.C0975id.btn_dialog_ok);
                int stringRes2 = C1583R.getStringRes(this.activity, "smssdk_wait");
                if (stringRes2 > 0) {
                    button.setText(stringRes2);
                }
                button.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.SmartVerifyPage.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button button2 = (Button) dialog.findViewById(Res.C0975id.btn_dialog_cancel);
                int stringRes3 = C1583R.getStringRes(this.activity, "smssdk_back");
                if (stringRes3 > 0) {
                    button2.setText(stringRes3);
                }
                button2.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.SmartVerifyPage.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        SmartVerifyPage.this.finish();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        finish();
        return true;
    }
}
