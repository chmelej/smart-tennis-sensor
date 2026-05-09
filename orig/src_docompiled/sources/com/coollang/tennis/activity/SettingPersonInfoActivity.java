package com.coollang.tennis.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
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
import com.coollang.tennis.widget.GetMoveScrollView;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import p000.AlertDialogC1872lb;
import p000.C1845kb;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1895ly;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1912mk;
import p000.C1913ml;
import p000.C1914mm;
import p000.C1919mr;
import p000.C2049qf;
import p000.C2068qy;
import p000.DialogC1867kx;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingPersonInfoActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private static final String f6756a = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: H */
    private int f6764H;

    /* JADX INFO: renamed from: b */
    private RelativeLayout f6766b;

    /* JADX INFO: renamed from: c */
    private View f6767c;

    /* JADX INFO: renamed from: d */
    private ImageView f6768d;

    /* JADX INFO: renamed from: e */
    private ImageView f6769e;

    /* JADX INFO: renamed from: f */
    private GetMoveScrollView f6770f;

    /* JADX INFO: renamed from: g */
    private CircleImageView f6771g;

    /* JADX INFO: renamed from: h */
    private BaseLineView f6772h;

    /* JADX INFO: renamed from: i */
    private BaseLineView f6773i;

    /* JADX INFO: renamed from: j */
    private BaseLineView f6774j;

    /* JADX INFO: renamed from: k */
    private BaseLineView f6775k;

    /* JADX INFO: renamed from: l */
    private BaseLineView f6776l;

    /* JADX INFO: renamed from: m */
    private BaseLineView f6777m;

    /* JADX INFO: renamed from: n */
    private BaseLineView f6778n;

    /* JADX INFO: renamed from: o */
    private BaseLineView f6779o;

    /* JADX INFO: renamed from: p */
    private BaseLineView f6780p;

    /* JADX INFO: renamed from: q */
    private BaseLineView f6781q;

    /* JADX INFO: renamed from: r */
    private C1874ld f6782r;

    /* JADX INFO: renamed from: s */
    private Gson f6783s;

    /* JADX INFO: renamed from: t */
    private PopupWindow f6784t;

    /* JADX INFO: renamed from: u */
    private UserInfoBean f6785u;

    /* JADX INFO: renamed from: v */
    private Bitmap f6786v;

    /* JADX INFO: renamed from: w */
    private String f6787w = "";

    /* JADX INFO: renamed from: x */
    private String f6788x = "女";

    /* JADX INFO: renamed from: y */
    private String f6789y = "165";

    /* JADX INFO: renamed from: z */
    private String f6790z = "49";

    /* JADX INFO: renamed from: A */
    private String f6757A = "1992-5-21";

    /* JADX INFO: renamed from: B */
    private String f6758B = "";

    /* JADX INFO: renamed from: C */
    private String f6759C = "";

    /* JADX INFO: renamed from: D */
    private String f6760D = "1";

    /* JADX INFO: renamed from: E */
    private String f6761E = "";

    /* JADX INFO: renamed from: F */
    private String f6762F = "";

    /* JADX INFO: renamed from: G */
    private String f6763G = "1.5";

    /* JADX INFO: renamed from: I */
    private boolean f6765I = false;

    /* JADX INFO: renamed from: d */
    private void m7176d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_person_info);
        m7173c();
        m7176d();
        C1919mr.m10597a(this, getResources().getColor(R.color.black));
        m7180f();
    }

    /* JADX INFO: renamed from: c */
    private void m7173c() {
        this.f6767c = findViewById(R.id.topbar_bg);
        this.f6766b = (RelativeLayout) findViewById(R.id.rl_head);
        this.f6768d = (ImageView) findViewById(R.id.iv_return);
        this.f6769e = (ImageView) findViewById(R.id.activity_person_setting_ib_save);
        this.f6770f = (GetMoveScrollView) findViewById(R.id.scroll_person_info);
        this.f6771g = (CircleImageView) findViewById(R.id.item_fragment_ranking_iv_head);
        this.f6772h = (BaseLineView) findViewById(R.id.blv_nick_name_person);
        this.f6773i = (BaseLineView) findViewById(R.id.blv_sex_person);
        this.f6774j = (BaseLineView) findViewById(R.id.blv_city_person);
        this.f6775k = (BaseLineView) findViewById(R.id.blv_birthday_person);
        this.f6776l = (BaseLineView) findViewById(R.id.blv_sign_person);
        this.f6777m = (BaseLineView) findViewById(R.id.blv_height_person);
        this.f6778n = (BaseLineView) findViewById(R.id.blv_weight_person);
        this.f6779o = (BaseLineView) findViewById(R.id.blv_hand_person);
        this.f6780p = (BaseLineView) findViewById(R.id.blv_ball_age);
        this.f6781q = (BaseLineView) findViewById(R.id.blv_tennis_level);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        akd.m1706a().m1719a(this);
        this.f6783s = new Gson();
        this.f6782r = new C1874ld();
        this.f6764H = C1895ly.m10460a(this, 40.0f);
        this.f6782r.m10212d();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 3) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("SettingPersonInfoActivity", "请求个人资料连接失败");
                    break;
                case 0:
                    C1900mc.m10475c("SettingPersonInfoActivity", "请求个人资料失败");
                    break;
                case 1:
                    this.f6785u = (UserInfoBean) this.f6783s.fromJson(c1873lc.f11064a, UserInfoBean.class);
                    m7178e();
                    C1900mc.m10475c("SettingPersonInfoActivity", "请求个人资料成功 event.msg = " + c1873lc.f11064a);
                    break;
            }
        }
        if (c1873lc.f11072i == 6) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    if (this.f6784t != null) {
                        this.f6784t.dismiss();
                        this.f6784t = null;
                    }
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    C1900mc.m10475c("SettingPersonInfoActivity", "上传头像失败 ， error = " + c1873lc.f11064a);
                    break;
                case 1:
                    MyApplication.m7738a().m7746f();
                    m7184h();
                    C1900mc.m10475c("SettingPersonInfoActivity", "上传头像成功");
                    break;
            }
        }
        if (c1873lc.f11072i == 7) {
            if (this.f6784t != null) {
                this.f6784t.dismiss();
                this.f6784t = null;
            }
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    C1900mc.m10475c("SettingPersonInfoActivity", "提交个人资料连接失败");
                    break;
                case 1:
                    C1902me.m10483a(getApplicationContext(), "weight", Integer.parseInt(this.f6790z));
                    C1902me.m10481a(Integer.parseInt(this.f6760D));
                    Toast.makeText(this, C1914mm.m10557b(R.string.save_success), 0).show();
                    RankListFragment.f7569b = true;
                    this.f6765I = false;
                    C1900mc.m10475c("SettingPersonInfoActivity", "提交个人资料成功");
                    m7733j();
                    break;
            }
        }
        if (c1873lc.f11072i == 38) {
            if (c1873lc.f11064a.isEmpty() || this.f6787w.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7170a(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 40) {
            if (this.f6761E.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7172b(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 39) {
            if (this.f6759C.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7175c(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 41) {
            if (this.f6790z.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7179e(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 42) {
            if (this.f6789y.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7177d(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 43) {
            if (this.f6760D.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7181f(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 44) {
            if (this.f6762F.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7183g(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 45) {
            if (this.f6757A.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7185h(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i == 46) {
            if (this.f6758B.equals(c1873lc.f11064a)) {
                return;
            }
            this.f6765I = true;
            m7187i(c1873lc.f11064a);
            return;
        }
        if (c1873lc.f11072i != 47 || this.f6763G.equals(c1873lc.f11064a)) {
            return;
        }
        this.f6765I = true;
        m7188j(c1873lc.f11064a);
    }

    /* JADX INFO: renamed from: e */
    private void m7178e() {
        m7170a(this.f6785u.errDesc.UserName);
        m7172b(this.f6785u.errDesc.Sex);
        m7175c(this.f6785u.errDesc.Signature);
        m7179e(this.f6785u.errDesc.Weight);
        m7177d(this.f6785u.errDesc.Height);
        m7181f(this.f6785u.errDesc.Hand);
        m7183g(this.f6785u.errDesc.StartTennisYear);
        m7185h(this.f6785u.errDesc.Birthday);
        m7187i(this.f6785u.errDesc.Address);
        m7188j(this.f6785u.errDesc.Level);
        C2068qy.m11356a().m11360a(this.f6785u.errDesc.Icon, this.f6771g);
    }

    /* JADX INFO: renamed from: a */
    private void m7170a(String str) {
        this.f6787w = str;
        this.f6772h.setRightText(str);
    }

    /* JADX INFO: renamed from: b */
    private void m7172b(String str) {
        this.f6761E = str;
        if ("1".equals(this.f6761E)) {
            this.f6788x = C1914mm.m10557b(R.string.perfect_male);
        } else {
            this.f6788x = C1914mm.m10557b(R.string.perfect_female);
        }
        this.f6773i.setRightText(this.f6788x);
    }

    /* JADX INFO: renamed from: c */
    private void m7175c(String str) {
        this.f6759C = str;
        this.f6776l.setRightText(this.f6759C);
    }

    /* JADX INFO: renamed from: d */
    private void m7177d(String str) {
        this.f6789y = str;
        this.f6777m.setRightText(String.format("%s cm", str));
    }

    /* JADX INFO: renamed from: e */
    private void m7179e(String str) {
        this.f6790z = str;
        this.f6778n.setRightText(String.format("%s kg", str));
    }

    /* JADX INFO: renamed from: f */
    private void m7181f(String str) {
        this.f6760D = str;
        if ("1".equals(str)) {
            this.f6779o.setRightText(getString(R.string.first_hand_right));
        } else if ("0".equals(str)) {
            this.f6779o.setRightText(getString(R.string.first_hand_left));
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7183g(String str) {
        this.f6762F = str;
        if (this.f6762F == null || "".equals(this.f6762F) || "0".equals(this.f6762F)) {
            this.f6762F = "";
            this.f6780p.setRightText("");
        } else {
            this.f6780p.setRightText(String.format(getString(R.string.sport_exp_year_unit), this.f6762F));
        }
    }

    /* JADX INFO: renamed from: h */
    private void m7185h(String str) {
        this.f6757A = str;
        if (MyApplication.m7738a().m7747g()) {
            this.f6775k.setRightText(C1912mk.m10551h(str));
        } else {
            this.f6775k.setRightText(C1912mk.m10549f(str));
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7187i(String str) {
        this.f6758B = str;
        this.f6774j.setRightText(str);
    }

    /* JADX INFO: renamed from: j */
    private void m7188j(String str) {
        this.f6763G = str;
        if (this.f6763G == null || "".equals(this.f6763G)) {
            this.f6763G = "";
        }
        this.f6781q.setRightText(this.f6763G);
    }

    /* JADX INFO: renamed from: f */
    private void m7180f() {
        this.f6768d.setOnClickListener(this);
        this.f6769e.setOnClickListener(this);
        this.f6771g.setOnClickListener(this);
        this.f6772h.setOnClickListener(this);
        this.f6773i.setOnClickListener(this);
        this.f6774j.setOnClickListener(this);
        this.f6775k.setOnClickListener(this);
        this.f6776l.setOnClickListener(this);
        this.f6777m.setOnClickListener(this);
        this.f6778n.setOnClickListener(this);
        this.f6779o.setOnClickListener(this);
        this.f6780p.setOnClickListener(this);
        this.f6781q.setOnClickListener(this);
        this.f6770f.setScrollViewListener(new GetMoveScrollView.InterfaceC1336a() { // from class: com.coollang.tennis.activity.SettingPersonInfoActivity.1
            @Override // com.coollang.tennis.widget.GetMoveScrollView.InterfaceC1336a
            /* JADX INFO: renamed from: a */
            public void mo7194a(int i, int i2, int i3, int i4) {
                if (i2 <= 0) {
                    SettingPersonInfoActivity.this.f6767c.setAlpha(0.0f);
                } else if (i2 >= SettingPersonInfoActivity.this.f6764H) {
                    SettingPersonInfoActivity.this.f6767c.setAlpha(1.0f);
                } else {
                    C2049qf.m11183a(SettingPersonInfoActivity.this.f6767c, i2 / SettingPersonInfoActivity.this.f6764H);
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.activity_person_setting_ib_save /* 2131296311 */:
                m7182g();
                break;
            case R.id.blv_ball_age /* 2131296393 */:
                C1887lq.m10418b(this, 1106, this.f6762F.isEmpty() ? "0" : this.f6762F);
                break;
            case R.id.blv_birthday_person /* 2131296394 */:
                C1887lq.m10419b(this, this.f6757A);
                break;
            case R.id.blv_city_person /* 2131296398 */:
                if (MyApplication.m7738a().m7747g()) {
                    C1887lq.m10408a(this, PointerIconCompat.TYPE_TEXT);
                } else {
                    C1887lq.m10408a(this, PointerIconCompat.TYPE_VERTICAL_TEXT);
                }
                break;
            case R.id.blv_hand_person /* 2131296403 */:
                C1887lq.m10425d(this, 2102, this.f6760D);
                break;
            case R.id.blv_height_person /* 2131296404 */:
                C1887lq.m10418b(this, 1105, this.f6789y);
                break;
            case R.id.blv_nick_name_person /* 2131296408 */:
                C1887lq.m10422c(this, 1200, this.f6787w);
                break;
            case R.id.blv_sex_person /* 2131296418 */:
                C1887lq.m10425d(this, 2101, this.f6761E);
                break;
            case R.id.blv_sign_person /* 2131296422 */:
                C1887lq.m10422c(this, 1201, this.f6759C);
                break;
            case R.id.blv_tennis_level /* 2131296425 */:
                C1887lq.m10423c(this, this.f6763G.isEmpty() ? "1.0" : this.f6763G);
                break;
            case R.id.blv_weight_person /* 2131296432 */:
                C1887lq.m10418b(this, 1104, this.f6790z);
                break;
            case R.id.item_fragment_ranking_iv_head /* 2131296692 */:
                m7189l();
                break;
            case R.id.iv_return /* 2131296734 */:
                if (this.f6765I) {
                    m7191n();
                } else {
                    m7733j();
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7182g() {
        if (this.f6786v != null) {
            m7190m();
        } else {
            m7184h();
        }
        m7192o();
    }

    /* JADX INFO: renamed from: h */
    private void m7184h() {
        if (C1914mm.m10557b(R.string.perfect_female).equals(this.f6788x)) {
            this.f6761E = "0";
        } else {
            this.f6761E = "1";
        }
        if (TextUtils.isEmpty(this.f6787w)) {
            if (this.f6784t != null) {
                this.f6784t.dismiss();
                this.f6784t = null;
            }
            Toast.makeText(this, R.string.nick_name_not_empty, 0).show();
            return;
        }
        this.f6782r.m10197a(this.f6787w, this.f6761E, this.f6757A, this.f6789y, this.f6790z, this.f6759C, this.f6758B, this.f6760D, "", this.f6762F, m7186i(), this.f6763G);
    }

    /* JADX INFO: renamed from: i */
    private String m7186i() {
        if (this.f6762F == null || this.f6762F.isEmpty()) {
            return String.valueOf(Calendar.getInstance().get(1));
        }
        return String.valueOf(Calendar.getInstance().get(1) - Integer.parseInt(this.f6762F));
    }

    /* JADX INFO: renamed from: a */
    public void m7193a(Bitmap bitmap, File file) {
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
    private void m7189l() {
        AlertDialogC1872lb alertDialogC1872lb = new AlertDialogC1872lb(this, getString(R.string.dialog_set_head_tv_title), new AlertDialogC1872lb.a() { // from class: com.coollang.tennis.activity.SettingPersonInfoActivity.2
            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: a */
            public void mo7024a() {
                SettingPersonInfoActivity.this.startActivityForResult(new Intent(SettingPersonInfoActivity.this, (Class<?>) ImageChooseActivity_new.class), 2);
                SettingPersonInfoActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
            }

            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: b */
            public void mo7025b() {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "zhinenglunhua.jpg")));
                }
                SettingPersonInfoActivity.this.startActivityForResult(intent, 1);
                SettingPersonInfoActivity.this.overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
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

    /* JADX INFO: renamed from: m */
    private void m7190m() {
        File file = new File(f6756a);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7193a(this.f6786v, file);
        this.f6782r.m10188a(file);
        RankListFragment.f7569b = true;
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
                this.f6786v = MyApplication.m7738a().f7400a;
                this.f6771g.setImageBitmap(this.f6786v);
                this.f6765I = true;
                break;
        }
    }

    /* JADX INFO: renamed from: n */
    private void m7191n() {
        new DialogC1867kx(this, getString(R.string.is_save_person_info), "", C1914mm.m10557b(R.string.save), C1914mm.m10557b(R.string.unSave), new DialogC1867kx.a() { // from class: com.coollang.tennis.activity.SettingPersonInfoActivity.3
            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7196a(String str) {
                SettingPersonInfoActivity.this.m7182g();
            }

            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7195a() {
                SettingPersonInfoActivity.this.m7733j();
            }
        }).show();
    }

    /* JADX INFO: renamed from: o */
    private void m7192o() {
        this.f6784t = new PopupWindow(View.inflate(getApplicationContext(), R.layout.popupwindow_wait, null), -1, -1, true);
        this.f6784t.setTouchable(true);
        this.f6784t.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.SettingPersonInfoActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6784t.setBackgroundDrawable(new BitmapDrawable());
        this.f6784t.showAtLocation(getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6786v != null && !this.f6786v.isRecycled()) {
            this.f6786v.recycle();
            this.f6786v = null;
        }
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }
}
