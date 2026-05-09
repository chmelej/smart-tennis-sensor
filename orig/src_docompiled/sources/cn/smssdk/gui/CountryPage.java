package cn.smssdk.gui;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.GroupListView;
import cn.smssdk.gui.layout.CountryListPageLayout;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class CountryPage extends FakeActivity implements TextWatcher, View.OnClickListener, GroupListView.OnItemClickListener {
    private HashMap<String, String> countryRules;
    private EditText etSearch;
    private EventHandler handler;

    /* JADX INFO: renamed from: id */
    private String f6065id;
    private CountryListView listView;

    /* JADX INFO: renamed from: pd */
    private Dialog f6066pd;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setCountryId(String str) {
        this.f6065id = str;
    }

    public void setCountryRuls(HashMap<String, String> map) {
        this.countryRules = map;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        if (this.f6066pd != null && this.f6066pd.isShowing()) {
            this.f6066pd.dismiss();
        }
        this.f6066pd = CommonDialog.ProgressDialog(this.activity);
        if (this.f6066pd != null) {
            this.f6066pd.show();
        }
        SearchEngine.prepare(this.activity, new Runnable() { // from class: cn.smssdk.gui.CountryPage.1
            @Override // java.lang.Runnable
            public void run() {
                CountryPage.this.afterPrepare();
            }
        });
    }

    /* JADX INFO: renamed from: cn.smssdk.gui.CountryPage$2 */
    class RunnableC09472 implements Runnable {
        RunnableC09472() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout layout = new CountryListPageLayout(CountryPage.this.activity).getLayout();
            if (layout != null) {
                CountryPage.this.activity.setContentView(layout);
            }
            if (CountryPage.this.countryRules != null && CountryPage.this.countryRules.size() > 0) {
                if (CountryPage.this.f6066pd != null && CountryPage.this.f6066pd.isShowing()) {
                    CountryPage.this.f6066pd.dismiss();
                }
                CountryPage.this.initPage();
                return;
            }
            CountryPage.this.handler = new EventHandler() { // from class: cn.smssdk.gui.CountryPage.2.1
                @Override // cn.smssdk.EventHandler
                public void afterEvent(int i, final int i2, final Object obj) {
                    if (i == 1) {
                        CountryPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.CountryPage.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CountryPage.this.f6066pd != null && CountryPage.this.f6066pd.isShowing()) {
                                    CountryPage.this.f6066pd.dismiss();
                                }
                                if (i2 == -1) {
                                    CountryPage.this.onCountryListGot((ArrayList) obj);
                                    return;
                                }
                                ((Throwable) obj).printStackTrace();
                                int stringRes = C1583R.getStringRes(CountryPage.this.activity, "smssdk_network_error");
                                if (stringRes > 0) {
                                    Toast.makeText(CountryPage.this.activity, stringRes, 0).show();
                                }
                                CountryPage.this.finish();
                            }
                        });
                    }
                }
            };
            SMSSDK.registerEventHandler(CountryPage.this.handler);
            SMSSDK.getSupportedCountries();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterPrepare() {
        runOnUIThread(new RunnableC09472());
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPage() {
        this.activity.findViewById(Res.C0975id.ll_back).setOnClickListener(this);
        this.activity.findViewById(Res.C0975id.ivSearch).setOnClickListener(this);
        this.activity.findViewById(Res.C0975id.iv_clear).setOnClickListener(this);
        this.listView = (CountryListView) this.activity.findViewById(Res.C0975id.clCountry);
        this.listView.setOnItemClickListener(this);
        this.etSearch = (EditText) this.activity.findViewById(Res.C0975id.et_put_identify);
        this.etSearch.addTextChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCountryListGot(ArrayList<HashMap<String, Object>> arrayList) {
        for (HashMap<String, Object> map : arrayList) {
            String str = (String) map.get("zone");
            String str2 = (String) map.get("rule");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.countryRules == null) {
                    this.countryRules = new HashMap<>();
                }
                this.countryRules.put(str, str2);
            }
        }
        initPage();
    }

    @Override // cn.smssdk.gui.GroupListView.OnItemClickListener
    public void onItemClick(GroupListView groupListView, View view, int i, int i2) {
        if (i2 >= 0) {
            String[] country = this.listView.getCountry(i, i2);
            if (this.countryRules != null && this.countryRules.containsKey(country[1])) {
                this.f6065id = country[2];
                finish();
            } else {
                int stringRes = C1583R.getStringRes(this.activity, "smssdk_country_not_support_currently");
                if (stringRes > 0) {
                    Toast.makeText(this.activity, stringRes, 0).show();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            finish();
            return;
        }
        if (id != 117506052) {
            if (id == 117571589) {
                this.etSearch.getText().clear();
            }
        } else {
            this.activity.findViewById(Res.C0975id.llTitle).setVisibility(8);
            this.activity.findViewById(Res.C0975id.llSearch).setVisibility(0);
            this.etSearch.getText().clear();
            this.etSearch.requestFocus();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (keyEvent.getAction() == 0 && this.activity.findViewById(Res.C0975id.llSearch).getVisibility() == 0) {
                    this.activity.findViewById(Res.C0975id.llSearch).setVisibility(8);
                    this.activity.findViewById(Res.C0975id.llTitle).setVisibility(0);
                    this.etSearch.setText("");
                    return true;
                }
            } catch (Throwable th) {
                SMSLog.getInstance().m8622w(th);
            }
        }
        return super.onKeyEvent(i, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        SMSSDK.unregisterEventHandler(this.handler);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.f6065id);
        map.put("page", 1);
        setResult(map);
        return super.onFinish();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.listView.onSearch(charSequence.toString().toLowerCase());
    }
}
