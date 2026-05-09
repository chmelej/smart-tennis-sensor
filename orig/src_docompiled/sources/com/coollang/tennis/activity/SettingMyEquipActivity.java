package com.coollang.tennis.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.PointerIconCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.MyEquipBean;
import com.coollang.tennis.choosephoto.CropImageActivity;
import com.coollang.tennis.choosephoto.ImageChooseActivity_new;
import com.coollang.tennis.fragment.PersonalMainFramgent;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.CircleImageView;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import p000.AlertDialogC1872lb;
import p000.C1808is;
import p000.C1845kb;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1912mk;
import p000.C1913ml;
import p000.C2068qy;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingMyEquipActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private static final String f6716a = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: b */
    private static final String f6717b = C1852ki.f10915b + "shoes.jpg";

    /* JADX INFO: renamed from: A */
    private String f6718A;

    /* JADX INFO: renamed from: B */
    private String f6719B;

    /* JADX INFO: renamed from: C */
    private String f6720C;

    /* JADX INFO: renamed from: D */
    private String f6721D;

    /* JADX INFO: renamed from: E */
    private int f6722E;

    /* JADX INFO: renamed from: F */
    private Bitmap f6723F;

    /* JADX INFO: renamed from: G */
    private Bitmap f6724G;

    /* JADX INFO: renamed from: H */
    private C1874ld f6725H;

    /* JADX INFO: renamed from: I */
    private Gson f6726I;

    /* JADX INFO: renamed from: J */
    private MyEquipBean f6727J;

    /* JADX INFO: renamed from: K */
    private PopupWindow f6728K;

    /* JADX INFO: renamed from: c */
    private NavigateView f6729c;

    /* JADX INFO: renamed from: d */
    private RelativeLayout f6730d;

    /* JADX INFO: renamed from: e */
    private TextView f6731e;

    /* JADX INFO: renamed from: f */
    private TextView f6732f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6733g;

    /* JADX INFO: renamed from: h */
    private BaseLineView f6734h;

    /* JADX INFO: renamed from: i */
    private BaseLineView f6735i;

    /* JADX INFO: renamed from: j */
    private BaseLineView f6736j;

    /* JADX INFO: renamed from: k */
    private BaseLineView f6737k;

    /* JADX INFO: renamed from: l */
    private RelativeLayout f6738l;

    /* JADX INFO: renamed from: m */
    private CircleImageView f6739m;

    /* JADX INFO: renamed from: n */
    private RelativeLayout f6740n;

    /* JADX INFO: renamed from: o */
    private CircleImageView f6741o;

    /* JADX INFO: renamed from: p */
    private String f6742p;

    /* JADX INFO: renamed from: q */
    private String f6743q;

    /* JADX INFO: renamed from: r */
    private String f6744r;

    /* JADX INFO: renamed from: s */
    private String f6745s;

    /* JADX INFO: renamed from: t */
    private String f6746t;

    /* JADX INFO: renamed from: u */
    private String f6747u;

    /* JADX INFO: renamed from: v */
    private String f6748v;

    /* JADX INFO: renamed from: w */
    private String f6749w;

    /* JADX INFO: renamed from: x */
    private String f6750x;

    /* JADX INFO: renamed from: y */
    private String f6751y;

    /* JADX INFO: renamed from: z */
    private String f6752z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_my_equip);
        m7149c();
        m7150d();
        m7151e();
        akd.m1706a().m1719a(this);
        m7152f();
    }

    /* JADX INFO: renamed from: c */
    private void m7149c() {
        this.f6742p = "";
        this.f6743q = "";
        this.f6744r = "";
        this.f6745s = "";
        this.f6746t = "";
        this.f6747u = "";
        this.f6748v = "";
        this.f6749w = "";
        this.f6750x = "";
        this.f6751y = "";
        this.f6752z = "";
        this.f6718A = "";
        this.f6719B = "";
        this.f6720C = "";
        this.f6721D = "";
    }

    /* JADX INFO: renamed from: d */
    private void m7150d() {
        this.f6729c = (NavigateView) findViewById(R.id.navigateView);
        this.f6730d = (RelativeLayout) findViewById(R.id.rl_racket_factory);
        this.f6731e = (TextView) findViewById(R.id.tv_factory_racket);
        this.f6732f = (TextView) findViewById(R.id.tv_type_racket);
        this.f6733g = (BaseLineView) findViewById(R.id.blv_buy_day);
        this.f6734h = (BaseLineView) findViewById(R.id.blv_hor_line);
        this.f6735i = (BaseLineView) findViewById(R.id.blv_ver_line);
        this.f6736j = (BaseLineView) findViewById(R.id.blv_shoes_name);
        this.f6737k = (BaseLineView) findViewById(R.id.blv_shoes_buy_day);
        this.f6738l = (RelativeLayout) findViewById(R.id.rl_racket_img);
        this.f6739m = (CircleImageView) findViewById(R.id.img_racket_right);
        this.f6740n = (RelativeLayout) findViewById(R.id.rl_shoes_img);
        this.f6741o = (CircleImageView) findViewById(R.id.img_shoes_right);
    }

    /* JADX INFO: renamed from: e */
    private void m7151e() {
        this.f6729c.setTitle(R.string.my_equip);
        this.f6729c.setRightButtonText(getString(R.string.right_text));
        this.f6729c.setRightButtonBackground(android.R.color.transparent);
        this.f6729c.setRightButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SettingMyEquipActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                SettingMyEquipActivity.this.m7153g();
            }
        });
    }

    /* JADX INFO: renamed from: f */
    private void m7152f() {
        this.f6730d.setOnClickListener(this);
        this.f6733g.setOnClickListener(this);
        this.f6734h.setOnClickListener(this);
        this.f6735i.setOnClickListener(this);
        this.f6736j.setOnClickListener(this);
        this.f6737k.setOnClickListener(this);
        this.f6738l.setOnClickListener(this);
        this.f6740n.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6725H = new C1874ld();
        this.f6726I = new Gson();
        this.f6725H.m10233k();
        PersonalMainFramgent.f7519b = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.blv_buy_day /* 2131296395 */:
                if (this.f6744r.isEmpty() || this.f6745s.isEmpty()) {
                    C1887lq.m10413a(this, "2015-01", 2200);
                } else {
                    C1887lq.m10413a(this, this.f6744r + "-" + this.f6745s, 2200);
                }
                break;
            case R.id.blv_hor_line /* 2131296405 */:
                C1887lq.m10411a(this, PointerIconCompat.TYPE_CELL, this.f6748v, this.f6749w, this.f6750x, this.f6751y);
                break;
            case R.id.blv_shoes_buy_day /* 2131296420 */:
                if (this.f6746t.isEmpty() || this.f6747u.isEmpty()) {
                    C1887lq.m10413a(this, "2015-01", 2201);
                } else {
                    C1887lq.m10413a(this, this.f6746t + "-" + this.f6747u, 2201);
                }
                break;
            case R.id.blv_shoes_name /* 2131296421 */:
                C1887lq.m10422c(this, 1202, this.f6721D);
                break;
            case R.id.blv_ver_line /* 2131296430 */:
                C1887lq.m10411a(this, PointerIconCompat.TYPE_CROSSHAIR, this.f6752z, this.f6718A, this.f6719B, this.f6720C);
                break;
            case R.id.rl_racket_factory /* 2131297039 */:
                if (C1902me.m10488b()) {
                    C1887lq.m10410a(this, 1005, "Head");
                } else {
                    C1887lq.m10408a(this, 1005);
                }
                break;
            case R.id.rl_racket_img /* 2131297040 */:
                m7147a(PointerIconCompat.TYPE_CONTEXT_MENU);
                break;
            case R.id.rl_shoes_img /* 2131297046 */:
                m7147a(PointerIconCompat.TYPE_HAND);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7153g() {
        if (this.f6723F != null) {
            m7162r();
        } else if (this.f6724G != null) {
            m7163s();
        } else {
            m7154h();
        }
        m7164t();
    }

    /* JADX INFO: renamed from: h */
    private void m7154h() {
        this.f6725H.m10206b(m7157m(), m7158n(), m7160p(), m7159o(), this.f6721D, m7161q());
    }

    /* JADX INFO: renamed from: a */
    private void m7147a(int i) {
        this.f6722E = i;
        AlertDialogC1872lb alertDialogC1872lb = new AlertDialogC1872lb(this, getString(R.string.dialog_set_head_tv_title), new AlertDialogC1872lb.a() { // from class: com.coollang.tennis.activity.SettingMyEquipActivity.2
            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: a */
            public void mo7024a() {
                SettingMyEquipActivity.this.startActivityForResult(new Intent(SettingMyEquipActivity.this, (Class<?>) ImageChooseActivity_new.class), 2);
                SettingMyEquipActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
            }

            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: b */
            public void mo7025b() {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "znwq.jpg")));
                }
                SettingMyEquipActivity.this.startActivityForResult(intent, 1);
                SettingMyEquipActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
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

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 31) {
            this.f6742p = c1873lc.f11067d;
            this.f6743q = c1873lc.f11064a;
            this.f6731e.setText(c1873lc.f11067d);
            this.f6732f.setText(c1873lc.f11064a);
        } else if (c1873lc.f11072i == 36) {
            this.f6748v = c1873lc.f11067d;
            this.f6749w = c1873lc.f11064a;
            this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        } else if (c1873lc.f11072i == 37) {
            this.f6752z = c1873lc.f11067d;
            this.f6718A = c1873lc.f11064a;
            this.f6735i.setRightText(String.format("%s %s", this.f6752z, this.f6719B) + String.format(" %s", this.f6720C));
            this.f6748v = c1873lc.f11067d;
            this.f6749w = c1873lc.f11064a;
            this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        } else if (c1873lc.f11072i == 33) {
            this.f6751y = c1873lc.f11064a;
            this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        } else if (c1873lc.f11072i == 32) {
            this.f6750x = c1873lc.f11064a;
        } else if (c1873lc.f11072i == 35) {
            this.f6720C = c1873lc.f11064a;
            this.f6735i.setRightText(String.format("%s %s", this.f6752z, this.f6719B) + String.format(" %s", this.f6720C));
            this.f6751y = c1873lc.f11064a;
            this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        } else if (c1873lc.f11072i == 34) {
            this.f6719B = c1873lc.f11064a;
            this.f6735i.setRightText(String.format("%s %s", this.f6752z, this.f6719B) + String.format(" %s", this.f6720C));
            this.f6750x = c1873lc.f11064a;
            this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        } else if (c1873lc.f11072i == 48) {
            C1900mc.m10474b("SHOES", c1873lc.f11064a);
            this.f6721D = c1873lc.f11064a;
            this.f6736j.setRightText(c1873lc.f11064a);
        } else if (c1873lc.f11072i == 49) {
            String[] strArrSplit = c1873lc.f11064a.split("-");
            this.f6744r = strArrSplit[0];
            this.f6745s = strArrSplit[1];
            this.f6733g.setRightText(m7146a(this.f6744r, this.f6745s));
        } else if (c1873lc.f11072i == 50) {
            String[] strArrSplit2 = c1873lc.f11064a.split("-");
            this.f6746t = strArrSplit2[0];
            this.f6747u = strArrSplit2[1];
            this.f6737k.setRightText(m7146a(this.f6746t, this.f6747u));
        }
        if (c1873lc.f11072i == 52) {
            C1900mc.m10474b("GET_EQUIP_DATA", "获取我的装备" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case 1:
                    this.f6727J = (MyEquipBean) this.f6726I.fromJson(c1873lc.f11064a, MyEquipBean.class);
                    m7155i();
                    break;
            }
        }
        if (c1873lc.f11072i == 56) {
            C1900mc.m10474b("UPLOAD_RACKET_IMG", "上传球拍图片" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    m7165u();
                    break;
                case 1:
                    if (this.f6724G != null) {
                        m7163s();
                    } else {
                        m7154h();
                    }
                    m7166v();
                    break;
            }
        }
        if (c1873lc.f11072i == 57) {
            C1900mc.m10474b("UPLOAD_SHOES_IMG", "上传球鞋图片" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    m7165u();
                    break;
                case 1:
                    m7167w();
                    m7154h();
                    break;
            }
        }
        if (c1873lc.f11072i == 51) {
            C1900mc.m10474b("SAVE_EQUIP_DATA", "上传装备数据" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    m7165u();
                    break;
                case 1:
                    C1913ml.m10553a(getString(R.string.save_success));
                    m7165u();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7155i() {
        String[] strArrSplit = this.f6727J.errDesc.Brand.split(",");
        if (strArrSplit != null && strArrSplit.length != 0) {
            this.f6742p = strArrSplit[0];
            if (strArrSplit.length == 2) {
                this.f6743q = strArrSplit[1];
            }
        }
        if (this.f6727J.errDesc.BuyTime.contains("-")) {
            String[] strArrSplit2 = this.f6727J.errDesc.BuyTime.split("-");
            this.f6744r = strArrSplit2[0];
            if (strArrSplit2.length == 2) {
                this.f6745s = strArrSplit2[1];
            }
        }
        String[] strArrSplit3 = this.f6727J.errDesc.Line.split(",");
        for (int i = 0; i < strArrSplit3.length; i++) {
            switch (i) {
                case 0:
                    this.f6748v = strArrSplit3[0];
                    break;
                case 1:
                    this.f6749w = strArrSplit3[1];
                    break;
                case 2:
                    this.f6750x = strArrSplit3[2];
                    break;
                case 3:
                    this.f6751y = strArrSplit3[3];
                    break;
            }
        }
        String[] strArrSplit4 = this.f6727J.errDesc.VerticalLine.split(",");
        for (int i2 = 0; i2 < strArrSplit4.length; i2++) {
            switch (i2) {
                case 0:
                    this.f6752z = strArrSplit4[0];
                    break;
                case 1:
                    this.f6718A = strArrSplit4[1];
                    break;
                case 2:
                    this.f6719B = strArrSplit4[2];
                    break;
                case 3:
                    this.f6720C = strArrSplit4[3];
                    break;
            }
        }
        if (this.f6727J.errDesc.ShoesBuyTime.contains("-")) {
            String[] strArrSplit5 = this.f6727J.errDesc.ShoesBuyTime.split("-");
            this.f6746t = strArrSplit5[0];
            if (strArrSplit5.length > 1) {
                this.f6747u = strArrSplit5[1];
            }
        }
        this.f6721D = this.f6727J.errDesc.ShoesName;
        m7156l();
    }

    /* JADX INFO: renamed from: l */
    private void m7156l() {
        this.f6731e.setText(this.f6742p);
        this.f6732f.setText(this.f6743q);
        C1808is.m9825a("run-setDataToView");
        this.f6734h.setRightText(String.format("%s %s", this.f6748v, this.f6750x) + String.format(" %s", this.f6751y));
        this.f6735i.setRightText(String.format("%s %s", this.f6752z, this.f6719B) + String.format(" %s", this.f6720C));
        this.f6736j.setRightText(this.f6721D);
        if (!this.f6744r.isEmpty() && !this.f6745s.isEmpty()) {
            this.f6733g.setRightText(m7146a(this.f6744r, this.f6745s));
        }
        if (!this.f6746t.isEmpty() && !this.f6747u.isEmpty()) {
            this.f6737k.setRightText(m7146a(this.f6746t, this.f6747u));
        }
        if (this.f6727J.errDesc.RacketUrl != null && !this.f6727J.errDesc.RacketUrl.isEmpty()) {
            C2068qy.m11356a().m11360a(this.f6727J.errDesc.RacketUrl, this.f6739m);
        }
        if (this.f6727J.errDesc.ShoesUrl == null || this.f6727J.errDesc.ShoesUrl.isEmpty()) {
            return;
        }
        C2068qy.m11356a().m11360a(this.f6727J.errDesc.ShoesUrl, this.f6741o);
    }

    /* JADX INFO: renamed from: m */
    private String m7157m() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6742p);
        stringBuffer.append(",");
        stringBuffer.append(this.f6743q);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: n */
    private String m7158n() {
        if (this.f6744r.isEmpty() || this.f6745s.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6744r);
        stringBuffer.append("-");
        stringBuffer.append(this.f6745s);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: o */
    private String m7159o() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6748v);
        stringBuffer.append(",");
        stringBuffer.append(this.f6749w);
        stringBuffer.append(",");
        stringBuffer.append(this.f6750x);
        stringBuffer.append(",");
        stringBuffer.append(this.f6751y);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: p */
    private String m7160p() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6752z);
        stringBuffer.append(",");
        stringBuffer.append(this.f6718A);
        stringBuffer.append(",");
        stringBuffer.append(this.f6719B);
        stringBuffer.append(",");
        stringBuffer.append(this.f6720C);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: q */
    private String m7161q() {
        if (this.f6746t.isEmpty() || this.f6747u.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6746t);
        stringBuffer.append("-");
        stringBuffer.append(this.f6747u);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    private String m7146a(String str, String str2) {
        return MyApplication.m7738a().m7747g() ? String.format("%s年%s月", str, str2) : C1912mk.m10550g(String.format("%s-%s", str, str2));
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
                    CropImageActivity.m7766a(this, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "znwq.jpg").getPath(), 3);
                }
                break;
            case 2:
                File file = new File(intent.getStringExtra("pictureURI"));
                File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "znwq.jpg");
                if (file2.exists()) {
                    file2.delete();
                }
                File fileM10082a = C1845kb.m10082a(file, file2);
                if (fileM10082a != null) {
                    CropImageActivity.m7766a(this, fileM10082a.getPath(), 3);
                }
                break;
            case 3:
                MyApplication myApplicationM7738a = MyApplication.m7738a();
                if (this.f6722E == 1001) {
                    this.f6723F = myApplicationM7738a.f7400a;
                    this.f6739m.setImageBitmap(this.f6723F);
                } else if (this.f6722E == 1002) {
                    this.f6724G = myApplicationM7738a.f7400a;
                    this.f6741o.setImageBitmap(this.f6724G);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: r */
    private void m7162r() {
        File file = new File(f6716a);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7168a(this.f6723F, file);
        this.f6725H.m10202b(file);
    }

    /* JADX INFO: renamed from: s */
    private void m7163s() {
        File file = new File(f6717b);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7168a(this.f6724G, file);
        this.f6725H.m10208c(file);
    }

    /* JADX INFO: renamed from: a */
    public void m7168a(Bitmap bitmap, File file) {
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

    /* JADX INFO: renamed from: t */
    private void m7164t() {
        this.f6728K = new PopupWindow(View.inflate(getApplicationContext(), R.layout.popupwindow_wait, null), -1, -1, true);
        this.f6728K.setTouchable(true);
        this.f6728K.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.SettingMyEquipActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6728K.setBackgroundDrawable(new BitmapDrawable());
        this.f6728K.showAtLocation(getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: renamed from: u */
    private void m7165u() {
        if (this.f6728K != null) {
            this.f6728K.dismiss();
            this.f6728K = null;
        }
    }

    /* JADX INFO: renamed from: v */
    private void m7166v() {
        if (this.f6723F == null || this.f6723F.isRecycled()) {
            return;
        }
        this.f6723F.recycle();
        this.f6723F = null;
    }

    /* JADX INFO: renamed from: w */
    private void m7167w() {
        if (this.f6724G == null || this.f6724G.isRecycled()) {
            return;
        }
        this.f6724G.recycle();
        this.f6724G = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m7166v();
        m7167w();
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }
}
