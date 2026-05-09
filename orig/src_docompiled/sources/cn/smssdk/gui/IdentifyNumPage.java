package cn.smssdk.gui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.layout.BackVerifyDialogLayout;
import cn.smssdk.gui.layout.IdentifyNumPageLayout;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.gui.layout.SendMsgDialogLayout;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IdentifyNumPage extends FakeActivity implements TextWatcher, View.OnClickListener {
    private static final int MIN_REQUEST_VOICE_VERIFY_INTERVAL = 1000;
    private static final int RETRY_INTERVAL = 60;
    private Button btnSounds;
    private Button btnSubmit;
    private String code;
    private EditText etIdentifyNum;
    private String formatedPhone;
    private EventHandler handler;
    private ImageView ivClear;
    private long lastRequestVVTime;

    /* JADX INFO: renamed from: pd */
    private Dialog f6068pd;
    private String phone;
    private BroadcastReceiver smsReceiver;
    private TextView tvIdentifyNotify;
    private TextView tvPhone;
    private TextView tvTitle;
    private TextView tvUnreceiveIdentify;
    private int time = 60;
    private int SHOWDIALOGTYPE = 1;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    static /* synthetic */ int access$410(IdentifyNumPage identifyNumPage) {
        int i = identifyNumPage.time;
        identifyNumPage.time = i - 1;
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
            this.etIdentifyNum.addTextChangedListener(this);
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
            this.btnSounds = (Button) findViewById(Res.C0975id.btn_sounds);
            this.btnSounds.setOnClickListener(this);
            this.handler = new EventHandler() { // from class: cn.smssdk.gui.IdentifyNumPage.1
                @Override // cn.smssdk.EventHandler
                public void afterEvent(int i, int i2, Object obj) {
                    if (i == 3) {
                        IdentifyNumPage.this.afterSubmit(i2, obj);
                    } else if (i == 2) {
                        IdentifyNumPage.this.afterGet(i2, obj);
                    } else if (i == 8) {
                        IdentifyNumPage.this.afterGetVoice(i2, obj);
                    }
                }
            };
            SMSSDK.registerEventHandler(this.handler);
            countDown();
        }
        try {
            if (DeviceHelper.getInstance(this.activity).checkPermission("android.permission.RECEIVE_SMS")) {
                this.smsReceiver = new SMSReceiver(new SMSSDK.VerifyCodeReadListener() { // from class: cn.smssdk.gui.IdentifyNumPage.2
                    @Override // cn.smssdk.SMSSDK.VerifyCodeReadListener
                    public void onReadVerifyCode(final String str) {
                        IdentifyNumPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IdentifyNumPage.this.etIdentifyNum.setText(str);
                            }
                        });
                    }
                });
                this.activity.registerReceiver(this.smsReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.smsReceiver = null;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        SMSSDK.unregisterEventHandler(this.handler);
        if (this.smsReceiver != null) {
            try {
                this.activity.unregisterReceiver(this.smsReceiver);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.3
            @Override // java.lang.Runnable
            public void run() {
                IdentifyNumPage.access$410(IdentifyNumPage.this);
                if (IdentifyNumPage.this.time == 0) {
                    int stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_unreceive_identify_code");
                    if (stringRes > 0) {
                        IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(IdentifyNumPage.this.getContext().getString(stringRes, Integer.valueOf(IdentifyNumPage.this.time))));
                    }
                    IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(true);
                    IdentifyNumPage.this.btnSounds.setVisibility(0);
                    IdentifyNumPage.this.time = 60;
                    return;
                }
                int stringRes2 = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_receive_msg");
                if (stringRes2 > 0) {
                    IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(IdentifyNumPage.this.getContext().getString(stringRes2, Integer.valueOf(IdentifyNumPage.this.time))));
                }
                IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(false);
                IdentifyNumPage.this.runOnUIThread(this, 1000L);
            }
        }, 1000L);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.btnSubmit.setEnabled(true);
            this.ivClear.setVisibility(0);
            int bitmapRes = C1583R.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (bitmapRes > 0) {
                this.btnSubmit.setBackgroundResource(bitmapRes);
                return;
            }
            return;
        }
        this.btnSubmit.setEnabled(false);
        this.ivClear.setVisibility(8);
        int bitmapRes2 = C1583R.getBitmapRes(this.activity, "smssdk_btn_disenable");
        if (bitmapRes2 > 0) {
            this.btnSubmit.setBackgroundResource(bitmapRes2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.4
                @Override // java.lang.Runnable
                public void run() {
                    IdentifyNumPage.this.showNotifyDialog();
                }
            });
            return;
        }
        if (id == 1881145360) {
            String strTrim = this.etIdentifyNum.getText().toString().trim();
            if (!TextUtils.isEmpty(this.code)) {
                if (this.f6068pd != null && this.f6068pd.isShowing()) {
                    this.f6068pd.dismiss();
                }
                this.f6068pd = CommonDialog.ProgressDialog(this.activity);
                if (this.f6068pd != null) {
                    this.f6068pd.show();
                }
                SMSSDK.submitVerificationCode(this.code, this.phone, strTrim);
                return;
            }
            int stringRes = C1583R.getStringRes(this.activity, "smssdk_write_identify_code");
            if (stringRes > 0) {
                Toast.makeText(getContext(), stringRes, 0).show();
                return;
            }
            return;
        }
        if (id == 1881145359) {
            this.SHOWDIALOGTYPE = 1;
            showDialog(this.SHOWDIALOGTYPE);
            return;
        }
        if (id == 117571589) {
            this.etIdentifyNum.getText().clear();
            return;
        }
        if (id == 1881145358) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastRequestVVTime > 1000) {
                this.lastRequestVVTime = jCurrentTimeMillis;
                this.SHOWDIALOGTYPE = 2;
                showDialog(this.SHOWDIALOGTYPE);
            }
        }
    }

    private void showDialog(int i) {
        int styleRes;
        int stringRes;
        if (i != 1) {
            if (i != 2 || (styleRes = C1583R.getStyleRes(this.activity, "CommonDialog")) <= 0) {
                return;
            }
            final Dialog dialog = new Dialog(getContext(), styleRes);
            LinearLayout linearLayoutCreate = SendMsgDialogLayout.create(this.activity);
            if (linearLayoutCreate != null) {
                dialog.setContentView(linearLayoutCreate);
                TextView textView = (TextView) dialog.findViewById(Res.C0975id.tv_dialog_title);
                int stringRes2 = C1583R.getStringRes(this.activity, "smssdk_make_sure_send_sounds");
                if (stringRes2 > 0) {
                    textView.setText(stringRes2);
                }
                TextView textView2 = (TextView) dialog.findViewById(Res.C0975id.tv_dialog_hint);
                int stringRes3 = C1583R.getStringRes(this.activity, "smssdk_send_sounds_identify_code");
                if (stringRes3 > 0) {
                    textView2.setText(getContext().getString(stringRes3));
                }
                ((Button) dialog.findViewById(Res.C0975id.btn_dialog_ok)).setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        SMSSDK.getVoiceVerifyCode(IdentifyNumPage.this.code, IdentifyNumPage.this.phone);
                    }
                });
                ((Button) dialog.findViewById(Res.C0975id.btn_dialog_cancel)).setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                return;
            }
            return;
        }
        int styleRes2 = C1583R.getStyleRes(this.activity, "CommonDialog");
        if (styleRes2 > 0) {
            final Dialog dialog2 = new Dialog(getContext(), styleRes2);
            TextView textView3 = new TextView(getContext());
            if (i == 1) {
                stringRes = C1583R.getStringRes(this.activity, "smssdk_resend_identify_code");
            } else {
                stringRes = C1583R.getStringRes(this.activity, "smssdk_send_sounds_identify_code");
            }
            if (stringRes > 0) {
                textView3.setText(stringRes);
            }
            textView3.setTextSize(2, 18.0f);
            int colorRes = C1583R.getColorRes(this.activity, "smssdk_white");
            if (colorRes > 0) {
                textView3.setTextColor(getContext().getResources().getColor(colorRes));
            }
            int iDipToPx = C1583R.dipToPx(getContext(), 10);
            textView3.setPadding(iDipToPx, iDipToPx, iDipToPx, iDipToPx);
            dialog2.setContentView(textView3);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog2.dismiss();
                    IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(false);
                    if (IdentifyNumPage.this.f6068pd != null && IdentifyNumPage.this.f6068pd.isShowing()) {
                        IdentifyNumPage.this.f6068pd.dismiss();
                    }
                    IdentifyNumPage.this.f6068pd = CommonDialog.ProgressDialog(IdentifyNumPage.this.activity);
                    if (IdentifyNumPage.this.f6068pd != null) {
                        IdentifyNumPage.this.f6068pd.show();
                    }
                    SMSSDK.getVerificationCode(IdentifyNumPage.this.code, IdentifyNumPage.this.phone.trim(), null);
                }
            });
            dialog2.setCanceledOnTouchOutside(true);
            dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.smssdk.gui.IdentifyNumPage.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IdentifyNumPage.this.tvUnreceiveIdentify.setEnabled(true);
                }
            });
            dialog2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterSubmit(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.9
            @Override // java.lang.Runnable
            public void run() {
                int stringRes;
                if (IdentifyNumPage.this.f6068pd != null && IdentifyNumPage.this.f6068pd.isShowing()) {
                    IdentifyNumPage.this.f6068pd.dismiss();
                }
                if (i == -1) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("res", true);
                    map.put("page", 2);
                    map.put("phone", obj);
                    IdentifyNumPage.this.setResult(map);
                    IdentifyNumPage.this.finish();
                    return;
                }
                ((Throwable) obj).printStackTrace();
                try {
                    int i2 = new JSONObject(((Throwable) obj).getMessage()).getInt(NotificationCompat.CATEGORY_STATUS);
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_detail_" + i2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    stringRes = 0;
                }
                if (stringRes == 0) {
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_virificaition_code_wrong");
                }
                if (stringRes > 0) {
                    Toast.makeText(IdentifyNumPage.this.activity, stringRes, 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterGet(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.10
            @Override // java.lang.Runnable
            public void run() {
                int iOptInt;
                int stringRes;
                String strOptString;
                if (IdentifyNumPage.this.f6068pd != null && IdentifyNumPage.this.f6068pd.isShowing()) {
                    IdentifyNumPage.this.f6068pd.dismiss();
                }
                if (i == -1) {
                    int stringRes2 = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_virificaition_code_sent");
                    if (stringRes2 > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, stringRes2, 0).show();
                    }
                    int stringRes3 = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_receive_msg");
                    if (stringRes3 > 0) {
                        IdentifyNumPage.this.tvUnreceiveIdentify.setText(Html.fromHtml(IdentifyNumPage.this.getContext().getString(stringRes3, Integer.valueOf(IdentifyNumPage.this.time))));
                    }
                    IdentifyNumPage.this.btnSounds.setVisibility(8);
                    IdentifyNumPage.this.time = 60;
                    IdentifyNumPage.this.countDown();
                    return;
                }
                ((Throwable) obj).printStackTrace();
                try {
                    JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                    strOptString = jSONObject.optString("detail");
                    iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                } catch (JSONException e) {
                    e = e;
                    iOptInt = 0;
                }
                try {
                    if (!TextUtils.isEmpty(strOptString)) {
                        Toast.makeText(IdentifyNumPage.this.activity, strOptString, 0).show();
                        return;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    SMSLog.getInstance().m8622w(e);
                }
                if (iOptInt >= 400) {
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_desc_" + iOptInt);
                } else {
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_network_error");
                }
                if (stringRes > 0) {
                    Toast.makeText(IdentifyNumPage.this.activity, stringRes, 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterGetVoice(final int i, final Object obj) {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.11
            @Override // java.lang.Runnable
            public void run() {
                int iOptInt;
                int stringRes;
                String strOptString;
                if (IdentifyNumPage.this.f6068pd != null && IdentifyNumPage.this.f6068pd.isShowing()) {
                    IdentifyNumPage.this.f6068pd.dismiss();
                }
                if (i == -1) {
                    int stringRes2 = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_send_sounds_success");
                    if (stringRes2 > 0) {
                        Toast.makeText(IdentifyNumPage.this.activity, stringRes2, 0).show();
                    }
                    IdentifyNumPage.this.btnSounds.setVisibility(8);
                    return;
                }
                ((Throwable) obj).printStackTrace();
                try {
                    JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                    strOptString = jSONObject.optString("detail");
                    iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                } catch (JSONException e) {
                    e = e;
                    iOptInt = 0;
                }
                try {
                    if (!TextUtils.isEmpty(strOptString)) {
                        Toast.makeText(IdentifyNumPage.this.activity, strOptString, 0).show();
                        return;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    SMSLog.getInstance().m8622w(e);
                }
                if (iOptInt >= 400) {
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_error_desc_" + iOptInt);
                } else {
                    stringRes = C1583R.getStringRes(IdentifyNumPage.this.activity, "smssdk_network_error");
                }
                if (stringRes > 0) {
                    Toast.makeText(IdentifyNumPage.this.activity, stringRes, 0).show();
                }
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
                button.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.12
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
                button2.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.IdentifyNumPage.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        IdentifyNumPage.this.finish();
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
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.IdentifyNumPage.14
            @Override // java.lang.Runnable
            public void run() {
                IdentifyNumPage.this.showNotifyDialog();
            }
        });
        return true;
    }
}
