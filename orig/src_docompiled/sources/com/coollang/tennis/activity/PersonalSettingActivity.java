package com.coollang.tennis.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UserInfoBean;
import com.coollang.tennis.choosephoto.CropImageActivity;
import com.coollang.tennis.choosephoto.ImageChooseActivity_new;
import com.coollang.tennis.fragment.RankListFragment;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.CircleImageView;
import com.google.gson.Gson;
import com.umeng.message.PushAgent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p000.AlertDialogC1865kv;
import p000.AlertDialogC1868ky;
import p000.AlertDialogC1869kz;
import p000.AlertDialogC1871la;
import p000.AlertDialogC1872lb;
import p000.C1845kb;
import p000.C1852ki;
import p000.C1854kk;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1896lz;
import p000.C1898ma;
import p000.C1900mc;
import p000.C1902me;
import p000.C1913ml;
import p000.C1914mm;
import p000.C2068qy;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class PersonalSettingActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: F */
    private static final String f6559F = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: E */
    private Gson f6564E;

    /* JADX INFO: renamed from: G */
    private Bitmap f6565G;

    /* JADX INFO: renamed from: H */
    private PopupWindow f6566H;

    /* JADX INFO: renamed from: I */
    private HashMap<String, Integer> f6567I;

    /* JADX INFO: renamed from: J */
    private List<String> f6568J;

    /* JADX INFO: renamed from: K */
    private C1874ld f6569K;

    /* JADX INFO: renamed from: L */
    private UserInfoBean f6570L;

    /* JADX INFO: renamed from: O */
    private String f6573O;

    /* JADX INFO: renamed from: a */
    private ImageView f6574a;

    /* JADX INFO: renamed from: b */
    private ImageButton f6575b;

    /* JADX INFO: renamed from: c */
    private CircleImageView f6576c;

    /* JADX INFO: renamed from: d */
    private EditText f6577d;

    /* JADX INFO: renamed from: e */
    private EditText f6578e;

    /* JADX INFO: renamed from: f */
    private BaseLineView f6579f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6580g;

    /* JADX INFO: renamed from: h */
    private BaseLineView f6581h;

    /* JADX INFO: renamed from: i */
    private TextView f6582i;

    /* JADX INFO: renamed from: j */
    private TextView f6583j;

    /* JADX INFO: renamed from: k */
    private BaseLineView f6584k;

    /* JADX INFO: renamed from: l */
    private RelativeLayout f6585l;

    /* JADX INFO: renamed from: m */
    private ImageView f6586m;

    /* JADX INFO: renamed from: n */
    private ImageView f6587n;

    /* JADX INFO: renamed from: o */
    private RelativeLayout f6588o;

    /* JADX INFO: renamed from: p */
    private TextView f6589p;

    /* JADX INFO: renamed from: q */
    private TextView f6590q;

    /* JADX INFO: renamed from: r */
    private TextView f6591r;

    /* JADX INFO: renamed from: s */
    private RelativeLayout f6592s;

    /* JADX INFO: renamed from: t */
    private TextView f6593t;

    /* JADX INFO: renamed from: u */
    private RelativeLayout f6594u;

    /* JADX INFO: renamed from: v */
    private TextView f6595v;

    /* JADX INFO: renamed from: w */
    private String f6596w = "女";

    /* JADX INFO: renamed from: x */
    private String f6597x = "165";

    /* JADX INFO: renamed from: y */
    private String f6598y = "49";

    /* JADX INFO: renamed from: z */
    private String f6599z = "1992-5-21";

    /* JADX INFO: renamed from: A */
    private String f6560A = "广东深圳";

    /* JADX INFO: renamed from: B */
    private String f6561B = "21.3";

    /* JADX INFO: renamed from: C */
    private String f6562C = "这一路，我们都不容易，且行且珍惜";

    /* JADX INFO: renamed from: D */
    private final String f6563D = "PersonalSettingActivity";

    /* JADX INFO: renamed from: M */
    private String f6571M = "1";

    /* JADX INFO: renamed from: N */
    private String f6572N = "";

    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_peresonal_setting);
        m7039c();
        PushAgent.getInstance(this).onAppStart();
        akd.m1706a().m1719a(this);
        this.f6564E = new Gson();
        this.f6569K = new C1874ld();
        this.f6575b.setVisibility(0);
        this.f6585l.setVisibility(8);
        m7051h();
    }

    /* JADX INFO: renamed from: c */
    private void m7039c() {
        this.f6574a = (ImageView) findViewById(R.id.iv_return);
        this.f6575b = (ImageButton) findViewById(R.id.activity_person_setting_ib_save);
        this.f6576c = (CircleImageView) findViewById(R.id.activity_personal_setting_iv_head);
        this.f6577d = (EditText) findViewById(R.id.activity_personal_setting_et_name);
        this.f6578e = (EditText) findViewById(R.id.activity_personal_setting_et_signature);
        this.f6579f = (BaseLineView) findViewById(R.id.blv_setting_sex);
        this.f6580g = (BaseLineView) findViewById(R.id.blv_setting_height);
        this.f6581h = (BaseLineView) findViewById(R.id.blv_setting_weight);
        this.f6582i = (TextView) findViewById(R.id.item_person_setting_tv_data);
        this.f6583j = (TextView) findViewById(R.id.item_person_setting_tv_bmi_type);
        this.f6584k = (BaseLineView) findViewById(R.id.blv_setting_birthday);
        this.f6585l = (RelativeLayout) findViewById(R.id.rl_sex);
        this.f6586m = (ImageView) findViewById(R.id.iv_male);
        this.f6587n = (ImageView) findViewById(R.id.iv_female);
        this.f6588o = (RelativeLayout) findViewById(R.id.activity_personal_setting_rl_ball_age);
        this.f6589p = (TextView) findViewById(R.id.activity_personal_setting_tv_ball_age);
        this.f6590q = (TextView) findViewById(R.id.activity_personal_setting_tv_left);
        this.f6591r = (TextView) findViewById(R.id.activity_personal_setting_tv_right);
        this.f6592s = (RelativeLayout) findViewById(R.id.activity_personal_setting_rl_address);
        this.f6593t = (TextView) findViewById(R.id.activity_personal_setting_tv_address);
        this.f6594u = (RelativeLayout) findViewById(R.id.activity_personal_setting_rl_brand);
        this.f6595v = (TextView) findViewById(R.id.activity_personal_setting_tv_brand);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: d */
    private void m7042d() {
        C2068qy.m11356a().m11360a(this.f6570L.errDesc.Icon, this.f6576c);
        this.f6577d.setText(this.f6570L.errDesc.UserName);
        this.f6578e.setText(this.f6570L.errDesc.Signature);
        this.f6577d.clearFocus();
        this.f6578e.clearFocus();
        this.f6572N = this.f6570L.errDesc.Sex;
        if ("1".equals(this.f6572N)) {
            this.f6596w = C1914mm.m10557b(R.string.perfect_male);
        } else {
            this.f6596w = C1914mm.m10557b(R.string.perfect_female);
        }
        this.f6597x = this.f6570L.errDesc.Height;
        this.f6598y = this.f6570L.errDesc.Weight;
        this.f6599z = this.f6570L.errDesc.Birthday;
        this.f6579f.setRightText(this.f6596w);
        this.f6580g.setRightText(String.format("%s cm", this.f6570L.errDesc.Height));
        this.f6581h.setRightText(String.format("%s kg", this.f6570L.errDesc.Weight));
        this.f6584k.setRightText(this.f6570L.errDesc.Birthday);
        m7045e();
        this.f6560A = this.f6570L.errDesc.Address;
        this.f6593t.setText(this.f6560A);
        this.f6571M = this.f6570L.errDesc.Hand;
        if ("1".equals(this.f6571M)) {
            this.f6590q.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_normal_bcg_round));
            this.f6591r.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_selector_bcg_round));
        } else if ("0".equals(this.f6571M)) {
            this.f6590q.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_selector_bcg_round));
            this.f6591r.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_normal_bcg_round));
        }
        this.f6573O = this.f6570L.errDesc.SportAge;
        if ("0".equals(this.f6573O)) {
            this.f6589p.setText(C1914mm.m10557b(R.string.one_year));
        } else if ("1".equals(this.f6573O)) {
            this.f6589p.setText(C1914mm.m10557b(R.string.one2three_year));
        } else if ("2".equals(this.f6573O)) {
            this.f6589p.setText(C1914mm.m10557b(R.string.three_year));
        }
        if (TextUtils.isEmpty(this.f6570L.errDesc.Brand)) {
            return;
        }
        this.f6595v.setText(this.f6570L.errDesc.Brand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m7045e() {
        float fM7046f = m7046f();
        double d = fM7046f;
        this.f6582i.setText(C1898ma.m10471a(d));
        if (d < 18.5d) {
            this.f6583j.setText(C1914mm.m10557b(R.string.personaldate_leixing1));
            return;
        }
        if (18.5d <= d && fM7046f < 24.0f) {
            this.f6583j.setText(C1914mm.m10557b(R.string.personaldate_leixing2));
            return;
        }
        if (24.0f <= fM7046f && fM7046f < 28.0f) {
            this.f6583j.setText(C1914mm.m10557b(R.string.personaldate_leixing3));
        } else if (fM7046f >= 28.0f) {
            this.f6583j.setText(C1914mm.m10557b(R.string.personaldate_leixing4));
        }
    }

    /* JADX INFO: renamed from: f */
    private float m7046f() {
        float f = Float.parseFloat(this.f6597x) / 100.0f;
        if (f != 0.0f) {
            return (Float.parseFloat(this.f6598y) / f) / f;
        }
        return 0.0f;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.PersonalSettingActivity$1] */
    /* JADX INFO: renamed from: g */
    private void m7049g() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                C1854kk c1854kk = new C1854kk(PersonalSettingActivity.this);
                if (MyApplication.m7738a().m7747g()) {
                    PersonalSettingActivity.this.f6567I = c1854kk.m10103a();
                    PersonalSettingActivity.this.f6568J = c1854kk.m10104a("0");
                    return null;
                }
                PersonalSettingActivity.this.f6567I = c1854kk.m10105b();
                PersonalSettingActivity.this.f6568J = c1854kk.m10106b("0");
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r5) {
                super.onPostExecute(r5);
                if (PersonalSettingActivity.this.f6567I == null) {
                    PersonalSettingActivity.this.f6567I = new HashMap();
                }
                if (PersonalSettingActivity.this.f6568J == null) {
                    PersonalSettingActivity.this.f6568J = new ArrayList();
                }
                new AlertDialogC1869kz(PersonalSettingActivity.this, PersonalSettingActivity.this.f6567I, PersonalSettingActivity.this.f6568J, new AlertDialogC1869kz.a() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.1.1
                    @Override // p000.AlertDialogC1869kz.a
                    /* JADX INFO: renamed from: a */
                    public void mo7066a(String str, String str2) {
                        PersonalSettingActivity.this.f6560A = str + str2;
                        PersonalSettingActivity.this.f6593t.setText(PersonalSettingActivity.this.f6560A);
                    }
                }).show();
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: h */
    private void m7051h() {
        this.f6575b.setOnClickListener(this);
        this.f6574a.setOnClickListener(this);
        this.f6576c.setOnClickListener(this);
        this.f6585l.setOnClickListener(this);
        this.f6586m.setOnClickListener(this);
        this.f6587n.setOnClickListener(this);
        this.f6588o.setOnClickListener(this);
        this.f6590q.setOnClickListener(this);
        this.f6591r.setOnClickListener(this);
        this.f6592s.setOnClickListener(this);
        this.f6594u.setOnClickListener(this);
        this.f6584k.setOnClickListener(this);
        this.f6581h.setOnClickListener(this);
        this.f6580g.setOnClickListener(this);
        this.f6579f.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    private void m7031a(final int i, String str, String str2, String str3) {
        new AlertDialogC1865kv(this, i, new AlertDialogC1865kv.a() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.2
            @Override // p000.AlertDialogC1865kv.a
            /* JADX INFO: renamed from: a */
            public void mo7026a(String str4, String str5, String str6) {
                if (i == 0) {
                    PersonalSettingActivity.this.f6597x = str4;
                    PersonalSettingActivity.this.f6580g.setRightText(String.format("%s cm", PersonalSettingActivity.this.f6597x));
                } else if (i == 1) {
                    PersonalSettingActivity.this.f6598y = str4;
                    PersonalSettingActivity.this.f6581h.setRightText(String.format("%s kg", PersonalSettingActivity.this.f6598y));
                } else {
                    if (str5.length() < 2) {
                        str5 = "0" + str5;
                    }
                    if (str6.length() < 2) {
                        str6 = "0" + str6;
                    }
                    try {
                        PersonalSettingActivity.this.f6599z = str4 + "-" + str5 + "-" + str6;
                        PersonalSettingActivity.this.f6584k.setRightText(PersonalSettingActivity.this.f6599z);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                PersonalSettingActivity.this.m7045e();
            }
        }, str, str2, str3).show();
    }

    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6569K.m10212d();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 3) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("PersonalSettingActivity", "请求个人资料连接失败");
                    break;
                case 0:
                    C1900mc.m10475c("PersonalSettingActivity", "请求个人资料失败");
                    break;
                case 1:
                    this.f6570L = (UserInfoBean) this.f6564E.fromJson(c1873lc.f11064a, UserInfoBean.class);
                    m7042d();
                    C1900mc.m10475c("PersonalSettingActivity", "请求个人资料成功 event.msg = " + c1873lc.f11064a);
                    break;
            }
        }
        if (c1873lc.f11072i == 6) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    if (this.f6566H != null) {
                        this.f6566H.dismiss();
                        this.f6566H = null;
                    }
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    C1900mc.m10475c("PersonalSettingActivity", "上传头像失败 ， error = " + c1873lc.f11064a);
                    break;
                case 1:
                    m7053i();
                    C1900mc.m10475c("PersonalSettingActivity", "上传头像成功");
                    break;
            }
        }
        if (c1873lc.f11072i == 7) {
            if (this.f6566H != null) {
                this.f6566H.dismiss();
                this.f6566H = null;
            }
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    C1900mc.m10475c("PersonalSettingActivity", "提交个人资料连接失败");
                    break;
                case 1:
                    C1902me.m10483a(getApplicationContext(), "weight", Integer.parseInt(this.f6598y));
                    C1902me.m10481a(Integer.parseInt(this.f6571M));
                    Toast.makeText(this, C1914mm.m10557b(R.string.save_success), 0).show();
                    RankListFragment.f7569b = true;
                    C1900mc.m10475c("PersonalSettingActivity", "提交个人资料成功");
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7053i() {
        if (C1914mm.m10557b(R.string.perfect_female).equals(this.f6596w)) {
            this.f6572N = "0";
        } else {
            this.f6572N = "1";
        }
        String string = this.f6577d.getText().toString();
        if (TextUtils.isEmpty(string)) {
            if (this.f6566H != null) {
                this.f6566H.dismiss();
                this.f6566H = null;
            }
            Toast.makeText(this, R.string.nick_name_not_empty, 0).show();
            return;
        }
        this.f6562C = this.f6578e.getText().toString();
        String string2 = this.f6595v.getText().toString();
        if (string2.equals(C1914mm.m10557b(R.string.rollselector6))) {
            string2 = "";
        }
        this.f6569K.m10197a(string, this.f6572N, this.f6599z, this.f6597x, this.f6598y, this.f6562C, this.f6560A, this.f6571M, string2, this.f6573O, "", "");
    }

    /* JADX INFO: renamed from: a */
    public void m7063a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 80;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 300) {
            byteArrayOutputStream.reset();
            i -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: l */
    private void m7057l() {
        File file = new File(f6559F);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7063a(this.f6565G, file);
        this.f6569K.m10188a(file);
        RankListFragment.f7569b = true;
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NewApi"})
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.activity_person_setting_ib_save /* 2131296311 */:
                m7734k();
                if (this.f6565G != null) {
                    m7057l();
                } else {
                    m7053i();
                }
                m7033a(this.f6577d);
                break;
            case R.id.activity_personal_setting_iv_head /* 2131296314 */:
                m7734k();
                m7061n();
                break;
            case R.id.activity_personal_setting_rl_address /* 2131296315 */:
                m7734k();
                if (MyApplication.m7738a().m7747g()) {
                    m7049g();
                } else {
                    m7059m();
                }
                break;
            case R.id.activity_personal_setting_rl_ball_age /* 2131296316 */:
                m7734k();
                m7034a(C1914mm.m10557b(R.string.rollselector4));
                break;
            case R.id.activity_personal_setting_rl_brand /* 2131296317 */:
                m7734k();
                m7034a(C1914mm.m10557b(R.string.rollselector6));
                break;
            case R.id.activity_personal_setting_tv_left /* 2131296321 */:
                this.f6571M = "0";
                this.f6590q.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_selector_bcg_round));
                this.f6591r.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_normal_bcg_round));
                break;
            case R.id.activity_personal_setting_tv_right /* 2131296322 */:
                this.f6571M = "1";
                this.f6590q.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_normal_bcg_round));
                this.f6591r.setBackground(C1914mm.m10558c(R.drawable.shap_person_setting_selector_bcg_round));
                break;
            case R.id.blv_setting_birthday /* 2131296414 */:
                String[] strArrSplit = this.f6599z.split("-");
                m7031a(2, strArrSplit[0], strArrSplit[1], strArrSplit[2]);
                break;
            case R.id.blv_setting_height /* 2131296415 */:
                m7031a(0, String.valueOf(this.f6597x), "-1", "-1");
                break;
            case R.id.blv_setting_sex /* 2131296416 */:
                this.f6585l.setVisibility(0);
                break;
            case R.id.blv_setting_weight /* 2131296417 */:
                m7031a(1, String.valueOf(this.f6598y), "-1", "-1");
                break;
            case R.id.iv_female /* 2131296723 */:
                this.f6585l.setVisibility(8);
                this.f6596w = C1914mm.m10557b(R.string.perfect_female);
                this.f6579f.setRightText(this.f6596w);
                break;
            case R.id.iv_male /* 2131296729 */:
                this.f6585l.setVisibility(8);
                this.f6596w = C1914mm.m10557b(R.string.perfect_male);
                this.f6579f.setRightText(this.f6596w);
                break;
            case R.id.iv_return /* 2131296734 */:
                m7733j();
                break;
            case R.id.rl_sex /* 2131297045 */:
                m7734k();
                this.f6585l.setVisibility(8);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.PersonalSettingActivity$3] */
    /* JADX INFO: renamed from: m */
    private void m7059m() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                C1854kk c1854kk = new C1854kk(PersonalSettingActivity.this);
                PersonalSettingActivity.this.f6568J = c1854kk.m10107c();
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r4) {
                super.onPostExecute(r4);
                if (PersonalSettingActivity.this.f6568J == null) {
                    PersonalSettingActivity.this.f6568J = new ArrayList();
                }
                new AlertDialogC1868ky(PersonalSettingActivity.this, PersonalSettingActivity.this.f6568J, new AlertDialogC1868ky.a() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.3.1
                    @Override // p000.AlertDialogC1868ky.a
                    /* JADX INFO: renamed from: a */
                    public void mo7069a(String str) {
                        PersonalSettingActivity.this.f6560A = str;
                        PersonalSettingActivity.this.f6593t.setText(PersonalSettingActivity.this.f6560A);
                    }
                }).show();
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: n */
    private void m7061n() {
        AlertDialogC1872lb alertDialogC1872lb = new AlertDialogC1872lb(this, getString(R.string.dialog_set_head_tv_title), new AlertDialogC1872lb.a() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.4
            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: a */
            public void mo7024a() {
                PersonalSettingActivity.this.startActivityForResult(new Intent(PersonalSettingActivity.this, (Class<?>) ImageChooseActivity_new.class), 2);
                PersonalSettingActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
            }

            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: b */
            public void mo7025b() {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg")));
                }
                PersonalSettingActivity.this.startActivityForResult(intent, 1);
                PersonalSettingActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
            }
        });
        alertDialogC1872lb.show();
        Window window = alertDialogC1872lb.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mystyle);
        window.setGravity(80);
    }

    /* JADX INFO: renamed from: a */
    private void m7034a(final String str) {
        new AlertDialogC1871la(this, str, new AlertDialogC1871la.a() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.5
            @Override // p000.AlertDialogC1871la.a
            /* JADX INFO: renamed from: a */
            public void mo7023a(String str2) {
                if (str.equals(C1914mm.m10557b(R.string.rollselector6))) {
                    PersonalSettingActivity.this.f6595v.setText(str2);
                    return;
                }
                PersonalSettingActivity.this.f6589p.setText(str2);
                if (str2.equals(C1914mm.m10557b(R.string.one_year))) {
                    PersonalSettingActivity.this.f6573O = "0";
                } else if (str2.equals(C1914mm.m10557b(R.string.one2three_year))) {
                    PersonalSettingActivity.this.f6573O = "1";
                } else if (str2.equals(C1914mm.m10557b(R.string.three_year))) {
                    PersonalSettingActivity.this.f6573O = "2";
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
        }
        switch (i) {
            case 1:
                if (Environment.getExternalStorageState().equals("mounted")) {
                    CropImageActivity.m7766a(this, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg").getPath(), 3);
                }
                break;
            case 2:
                File file = new File(intent.getStringExtra("pictureURI"));
                File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg");
                if (file2.exists()) {
                    file2.delete();
                }
                File fileM10082a = C1845kb.m10082a(file, file2);
                if (fileM10082a != null) {
                    CropImageActivity.m7766a(this, fileM10082a.getPath(), 3);
                }
                break;
            case 3:
                this.f6565G = MyApplication.m7738a().f7400a;
                this.f6576c.setImageBitmap(this.f6565G);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7032a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) PersonalSettingActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    private void m7033a(View view) {
        this.f6566H = new PopupWindow(View.inflate(getApplicationContext(), R.layout.popupwindow_wait, null), -1, -1, true);
        this.f6566H.setTouchable(true);
        this.f6566H.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6566H.setBackgroundDrawable(new BitmapDrawable());
        this.f6566H.showAtLocation(this.f6577d, 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.PersonalSettingActivity.7
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) PersonalSettingActivity.this.getSystemService("input_method");
                inputMethodManager.hideSoftInputFromWindow(PersonalSettingActivity.this.f6577d.getWindowToken(), 0);
                inputMethodManager.hideSoftInputFromWindow(PersonalSettingActivity.this.f6578e.getWindowToken(), 0);
            }
        }, 100L);
        ada.m302b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ada.m301a(this);
    }
}
