package cn.smssdk.gui;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.UserInterruptException;
import cn.smssdk.gui.layout.RegisterPageLayout;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.gui.layout.SendMsgDialogLayout;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RegisterPage extends FakeActivity implements TextWatcher, View.OnClickListener {
    private static final String DEFAULT_COUNTRY_ID = "42";
    private Button btnNext;
    private EventHandler callback;
    private String currentCode;
    private String currentId;
    private EditText etPhoneNum;
    private EventHandler handler;
    private ImageView ivClear;
    private OnSendMessageHandler osmHandler;

    /* JADX INFO: renamed from: pd */
    private Dialog f6069pd;
    private TextView tvCountry;
    private TextView tvCountryNum;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setRegisterCallback(EventHandler eventHandler) {
        this.callback = eventHandler;
    }

    public void setOnSendMessageHandler(OnSendMessageHandler onSendMessageHandler) {
        this.osmHandler = onSendMessageHandler;
    }

    public void show(Context context) {
        super.show(context, null);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new RegisterPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.currentId = DEFAULT_COUNTRY_ID;
            View viewFindViewById = this.activity.findViewById(Res.C0975id.ll_back);
            TextView textView = (TextView) this.activity.findViewById(Res.C0975id.tv_title);
            int stringRes = C1583R.getStringRes(this.activity, "smssdk_regist");
            if (stringRes > 0) {
                textView.setText(stringRes);
            }
            View viewFindViewById2 = this.activity.findViewById(Res.C0975id.rl_country);
            this.btnNext = (Button) this.activity.findViewById(Res.C0975id.btn_next);
            this.tvCountry = (TextView) this.activity.findViewById(Res.C0975id.tv_country);
            String[] currentCountry = getCurrentCountry();
            if (currentCountry != null) {
                this.currentCode = currentCountry[1];
                this.tvCountry.setText(currentCountry[0]);
            }
            this.tvCountryNum = (TextView) this.activity.findViewById(Res.C0975id.tv_country_num);
            this.tvCountryNum.setText("+" + this.currentCode);
            this.etPhoneNum = (EditText) this.activity.findViewById(Res.C0975id.et_write_phone);
            this.etPhoneNum.setText("");
            this.etPhoneNum.addTextChangedListener(this);
            this.etPhoneNum.requestFocus();
            if (this.etPhoneNum.getText().length() > 0) {
                this.btnNext.setEnabled(true);
                this.ivClear = (ImageView) this.activity.findViewById(Res.C0975id.iv_clear);
                this.ivClear.setVisibility(0);
                int bitmapRes = C1583R.getBitmapRes(this.activity, "smssdk_btn_enable");
                if (bitmapRes > 0) {
                    this.btnNext.setBackgroundResource(bitmapRes);
                }
            }
            this.ivClear = (ImageView) this.activity.findViewById(Res.C0975id.iv_clear);
            viewFindViewById.setOnClickListener(this);
            this.btnNext.setOnClickListener(this);
            this.ivClear.setOnClickListener(this);
            viewFindViewById2.setOnClickListener(this);
            this.handler = new EventHandler() { // from class: cn.smssdk.gui.RegisterPage.1
                @Override // cn.smssdk.EventHandler
                public void afterEvent(final int i, final int i2, final Object obj) {
                    RegisterPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.RegisterPage.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int iOptInt;
                            int stringRes2;
                            String strOptString;
                            if (RegisterPage.this.f6069pd != null && RegisterPage.this.f6069pd.isShowing()) {
                                RegisterPage.this.f6069pd.dismiss();
                            }
                            if (i2 == -1) {
                                if (i == 2) {
                                    RegisterPage.this.afterVerificationCodeRequested(((Boolean) obj).booleanValue());
                                    return;
                                }
                                return;
                            }
                            if (i == 2 && obj != null && (obj instanceof UserInterruptException)) {
                                return;
                            }
                            try {
                                ((Throwable) obj).printStackTrace();
                                JSONObject jSONObject = new JSONObject(((Throwable) obj).getMessage());
                                strOptString = jSONObject.optString("detail");
                                iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                            } catch (Exception e) {
                                e = e;
                                iOptInt = 0;
                            }
                            try {
                                if (!TextUtils.isEmpty(strOptString)) {
                                    Toast.makeText(RegisterPage.this.activity, strOptString, 0).show();
                                    return;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                SMSLog.getInstance().m8622w(e);
                            }
                            if (iOptInt >= 400) {
                                stringRes2 = C1583R.getStringRes(RegisterPage.this.activity, "smssdk_error_desc_" + iOptInt);
                            } else {
                                stringRes2 = C1583R.getStringRes(RegisterPage.this.activity, "smssdk_network_error");
                            }
                            if (stringRes2 > 0) {
                                Toast.makeText(RegisterPage.this.activity, stringRes2, 0).show();
                            }
                        }
                    });
                }
            };
        }
    }

    private String[] getCurrentCountry() {
        String mcc = getMCC();
        String[] countryByMCC = !TextUtils.isEmpty(mcc) ? SMSSDK.getCountryByMCC(mcc) : null;
        if (countryByMCC != null) {
            return countryByMCC;
        }
        Log.w("SMSSDK", "no country found by MCC: " + mcc);
        return SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
    }

    private String getMCC() {
        TelephonyManager telephonyManager = (TelephonyManager) this.activity.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        return !TextUtils.isEmpty(networkOperator) ? networkOperator : telephonyManager.getSimOperator();
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        SMSSDK.registerEventHandler(this.handler);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.btnNext.setEnabled(true);
            this.ivClear.setVisibility(0);
            int bitmapRes = C1583R.getBitmapRes(this.activity, "smssdk_btn_enable");
            if (bitmapRes > 0) {
                this.btnNext.setBackgroundResource(bitmapRes);
                return;
            }
            return;
        }
        this.btnNext.setEnabled(false);
        this.ivClear.setVisibility(8);
        int bitmapRes2 = C1583R.getBitmapRes(this.activity, "smssdk_btn_disenable");
        if (bitmapRes2 > 0) {
            this.btnNext.setBackgroundResource(bitmapRes2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            finish();
            return;
        }
        if (id == 117571585) {
            CountryPage countryPage = new CountryPage();
            countryPage.setCountryId(this.currentId);
            countryPage.showForResult(this.activity, null, this);
        } else if (id == 117571590) {
            showDialog(this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", ""), this.tvCountryNum.getText().toString().trim());
        } else if (id == 117571589) {
            this.etPhoneNum.getText().clear();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResult(HashMap<String, Object> map) {
        if (map != null) {
            int iIntValue = ((Integer) map.get("page")).intValue();
            if (iIntValue == 1) {
                this.currentId = (String) map.get("id");
                String[] country = SMSSDK.getCountry(this.currentId);
                if (country != null) {
                    this.currentCode = country[1];
                    this.tvCountryNum.setText("+" + this.currentCode);
                    this.tvCountry.setText(country[0]);
                    return;
                }
                return;
            }
            if (iIntValue == 2) {
                Object obj = map.get("res");
                HashMap map2 = (HashMap) map.get("phone");
                if (obj == null || map2 == null) {
                    return;
                }
                int stringRes = C1583R.getStringRes(this.activity, "smssdk_your_ccount_is_verified");
                if (stringRes > 0) {
                    Toast.makeText(this.activity, stringRes, 0).show();
                }
                if (this.callback != null) {
                    this.callback.afterEvent(3, -1, map2);
                }
                finish();
            }
        }
    }

    private String splitPhoneNum(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int length = sb.length();
        for (int i = 4; i < length; i += 5) {
            sb.insert(i, ' ');
        }
        sb.reverse();
        return sb.toString();
    }

    public void showDialog(final String str, final String str2) {
        int styleRes = C1583R.getStyleRes(this.activity, "CommonDialog");
        if (styleRes > 0) {
            String str3 = str2 + " " + splitPhoneNum(str);
            final Dialog dialog = new Dialog(getContext(), styleRes);
            LinearLayout linearLayoutCreate = SendMsgDialogLayout.create(getContext());
            if (linearLayoutCreate != null) {
                dialog.setContentView(linearLayoutCreate);
                ((TextView) dialog.findViewById(Res.C0975id.tv_phone)).setText(str3);
                TextView textView = (TextView) dialog.findViewById(Res.C0975id.tv_dialog_hint);
                int stringRes = C1583R.getStringRes(this.activity, "smssdk_make_sure_mobile_detail");
                if (stringRes > 0) {
                    textView.setText(Html.fromHtml(getContext().getString(stringRes)));
                }
                ((Button) dialog.findViewById(Res.C0975id.btn_dialog_ok)).setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                        if (RegisterPage.this.f6069pd != null && RegisterPage.this.f6069pd.isShowing()) {
                            RegisterPage.this.f6069pd.dismiss();
                        }
                        RegisterPage.this.f6069pd = CommonDialog.ProgressDialog(RegisterPage.this.activity);
                        if (RegisterPage.this.f6069pd != null) {
                            RegisterPage.this.f6069pd.show();
                        }
                        Log.e("verification phone ==>>", str);
                        SMSSDK.getVerificationCode(str2, str.trim(), RegisterPage.this.osmHandler);
                    }
                });
                ((Button) dialog.findViewById(Res.C0975id.btn_dialog_cancel)).setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.RegisterPage.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterVerificationCodeRequested(boolean z) {
        String strReplaceAll = this.etPhoneNum.getText().toString().trim().replaceAll("\\s*", "");
        String strTrim = this.tvCountryNum.getText().toString().trim();
        if (strTrim.startsWith("+")) {
            strTrim = strTrim.substring(1);
        }
        String str = "+" + strTrim + " " + splitPhoneNum(strReplaceAll);
        if (z) {
            SmartVerifyPage smartVerifyPage = new SmartVerifyPage();
            smartVerifyPage.setPhone(strReplaceAll, strTrim, str);
            smartVerifyPage.showForResult(this.activity, null, this);
        } else {
            IdentifyNumPage identifyNumPage = new IdentifyNumPage();
            identifyNumPage.setPhone(strReplaceAll, strTrim, str);
            identifyNumPage.showForResult(this.activity, null, this);
        }
    }
}
