package com.coollang.tennis.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.choosephoto.CropImageActivity;
import com.coollang.tennis.choosephoto.ImageChooseActivity_new;
import com.coollang.tennis.widget.CircleImageView;
import com.coollang.tennis.widget.NavigateView;
import com.umeng.message.PushAgent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import p000.AlertDialogC1865kv;
import p000.AlertDialogC1871la;
import p000.AlertDialogC1872lb;
import p000.C1845kb;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1896lz;
import p000.C1910mi;
import p000.C1914mm;
import p000.C2068qy;
import p000.DialogC1860kq;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class PerfectInformationActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: w */
    private static final String f6510w = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: A */
    private RadioGroup f6511A;

    /* JADX INFO: renamed from: D */
    private String f6514D;

    /* JADX INFO: renamed from: E */
    private String f6515E;

    /* JADX INFO: renamed from: a */
    private NavigateView f6516a;

    /* JADX INFO: renamed from: b */
    private TextView f6517b;

    /* JADX INFO: renamed from: c */
    private TextView f6518c;

    /* JADX INFO: renamed from: d */
    private TextView f6519d;

    /* JADX INFO: renamed from: e */
    private TextView f6520e;

    /* JADX INFO: renamed from: f */
    private TextView f6521f;

    /* JADX INFO: renamed from: g */
    private TextView f6522g;

    /* JADX INFO: renamed from: h */
    private TextView f6523h;

    /* JADX INFO: renamed from: i */
    private TextView f6524i;

    /* JADX INFO: renamed from: j */
    private FrameLayout f6525j;

    /* JADX INFO: renamed from: k */
    private View f6526k;

    /* JADX INFO: renamed from: l */
    private View f6527l;

    /* JADX INFO: renamed from: m */
    private RelativeLayout f6528m;

    /* JADX INFO: renamed from: n */
    private Bitmap f6529n;

    /* JADX INFO: renamed from: o */
    private CircleImageView f6530o;

    /* JADX INFO: renamed from: p */
    private LinearLayout f6531p;

    /* JADX INFO: renamed from: q */
    private TextView f6532q;

    /* JADX INFO: renamed from: r */
    private TextView f6533r;

    /* JADX INFO: renamed from: s */
    private TextView f6534s;

    /* JADX INFO: renamed from: t */
    private String f6535t;

    /* JADX INFO: renamed from: x */
    private PopupWindow f6538x;

    /* JADX INFO: renamed from: y */
    private EditText f6539y;

    /* JADX INFO: renamed from: z */
    private C1874ld f6540z;

    /* JADX INFO: renamed from: u */
    private String f6536u = "1";

    /* JADX INFO: renamed from: v */
    private String f6537v = "1";

    /* JADX INFO: renamed from: B */
    private String f6512B = "0";

    /* JADX INFO: renamed from: C */
    private String f6513C = "0";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_perfectinformation);
        PushAgent.getInstance(this).onAppStart();
        akd.m1706a().m1719a(this);
        this.f6514D = getIntent().getStringExtra("headurl");
        this.f6515E = getIntent().getStringExtra("nickname");
        m7007c();
        m7010d();
        m7012e();
        this.f6540z = new C1874ld();
        this.f6535t = "1990-07-16";
    }

    /* JADX INFO: renamed from: c */
    private void m7007c() {
        this.f6516a = (NavigateView) findViewById(R.id.navigateView);
        this.f6525j = (FrameLayout) findViewById(R.id.detail_person);
        this.f6528m = (RelativeLayout) findViewById(R.id.img_bg);
        this.f6530o = (CircleImageView) findViewById(R.id.camera);
        this.f6539y = (EditText) findViewById(R.id.et_name);
        this.f6511A = (RadioGroup) findViewById(R.id.rg_sex);
        this.f6526k = View.inflate(getApplicationContext(), R.layout.turnmain_view, null);
        this.f6527l = View.inflate(getApplicationContext(), R.layout.turndetail_view, null);
        this.f6517b = (TextView) this.f6526k.findViewById(R.id.text2);
        this.f6518c = (TextView) this.f6526k.findViewById(R.id.text3);
        this.f6525j.addView(this.f6526k);
        this.f6531p = (LinearLayout) this.f6527l.findViewById(R.id.setBirthdayd);
        this.f6519d = (TextView) this.f6527l.findViewById(R.id.year);
        this.f6520e = (TextView) this.f6527l.findViewById(R.id.month);
        this.f6521f = (TextView) this.f6527l.findViewById(R.id.day);
        this.f6522g = (TextView) this.f6527l.findViewById(R.id.year_unit);
        this.f6522g.setText(C1914mm.m10557b(R.string.perfect_text11));
        this.f6523h = (TextView) this.f6527l.findViewById(R.id.month_unit);
        this.f6524i = (TextView) this.f6527l.findViewById(R.id.day_unit);
        this.f6532q = (TextView) this.f6527l.findViewById(R.id.setHeight);
        this.f6533r = (TextView) this.f6527l.findViewById(R.id.setWeight);
        this.f6534s = (TextView) this.f6527l.findViewById(R.id.setYear);
        ((Button) this.f6527l.findViewById(R.id.save)).setOnClickListener(this);
        ((RadioGroup) this.f6527l.findViewById(R.id.rg_hand)).setOnCheckedChangeListener(this);
        this.f6525j.addView(this.f6527l);
    }

    /* JADX INFO: renamed from: d */
    private void m7010d() {
        this.f6516a.setTitle(getString(R.string.perfect_title));
        this.f6516a.setRightButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6516a.setLeftButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6517b.getPaint().setFlags(8);
        this.f6517b.getPaint().setAntiAlias(true);
        this.f6518c.getPaint().setFlags(8);
        this.f6518c.getPaint().setAntiAlias(true);
        this.f6526k.setVisibility(4);
        if (this.f6514D != null && !this.f6514D.isEmpty()) {
            C2068qy.m11356a().m11360a(this.f6514D, this.f6530o);
        }
        this.f6539y.addTextChangedListener(new TextWatcher() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.1

            /* JADX INFO: renamed from: b */
            private int f6542b;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f6542b = i + i3;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (PerfectInformationActivity.this.m6998a(editable.toString()) > 15) {
                    editable.delete(this.f6542b - 1, this.f6542b);
                    int i = this.f6542b;
                    PerfectInformationActivity.this.f6539y.setText(editable);
                    PerfectInformationActivity.this.f6539y.setSelection(i);
                }
            }
        });
        if (this.f6515E == null || this.f6515E.isEmpty()) {
            return;
        }
        this.f6539y.setText(this.f6515E);
        this.f6539y.setSelection(this.f6539y.getText().length());
    }

    /* JADX INFO: renamed from: e */
    private void m7012e() {
        this.f6511A.setOnCheckedChangeListener(this);
        this.f6528m.setOnClickListener(this);
        this.f6517b.setOnClickListener(this);
        this.f6518c.setOnClickListener(this);
        this.f6531p.setOnClickListener(this);
        this.f6532q.setOnClickListener(this);
        this.f6533r.setOnClickListener(this);
        this.f6534s.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.img_bg) {
            m7734k();
            m7018h();
            overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
            return;
        }
        if (id != R.id.save) {
            switch (id) {
                case R.id.setBirthdayd /* 2131297085 */:
                    m7734k();
                    m7000a(2, this.f6519d.getText().toString(), this.f6520e.getText().toString(), this.f6521f.getText().toString());
                    break;
                case R.id.setHeight /* 2131297086 */:
                    m7734k();
                    m7000a(0, "170", "-1", "-1");
                    break;
                case R.id.setWeight /* 2131297087 */:
                    m7734k();
                    m7000a(1, "72", "-1", "-1");
                    break;
                case R.id.setYear /* 2131297088 */:
                    m7734k();
                    new AlertDialogC1871la(this, C1914mm.m10557b(R.string.rollselector4), new AlertDialogC1871la.a() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.2
                        @Override // p000.AlertDialogC1871la.a
                        /* JADX INFO: renamed from: a */
                        public void mo7023a(String str) {
                            PerfectInformationActivity.this.f6534s.setText(C1910mi.m10525b(str.split("年")[0], str, Color.parseColor("#ff8560")));
                        }
                    }).show();
                    break;
                default:
                    switch (id) {
                        case R.id.text2 /* 2131297140 */:
                            this.f6527l.setVisibility(0);
                            this.f6527l.setVisibility(4);
                            break;
                        case R.id.text3 /* 2131297141 */:
                            startActivity(new Intent(this, (Class<?>) MainActivity.class));
                            overridePendingTransition(R.anim.scale_alpha_in, R.anim.scale_alpha_out);
                            break;
                    }
                    break;
            }
            return;
        }
        m7734k();
        m7001a(this.f6539y);
        if (this.f6529n != null) {
            m7014f();
        } else {
            m7016g();
        }
    }

    /* JADX INFO: renamed from: f */
    private void m7014f() {
        File file = new File(f6510w);
        if (file.exists()) {
            file.delete();
        } else {
            file.mkdirs();
        }
        m7022a(this.f6529n, file);
        this.f6540z.m10188a(file);
    }

    /* JADX INFO: renamed from: a */
    public void m7022a(Bitmap bitmap, File file) {
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

    public void onEventMainThread(C1873lc c1873lc) {
        if (this.f6538x != null) {
            this.f6538x.dismiss();
            this.f6538x = null;
        }
        if (c1873lc.f11072i == 7) {
            switch (c1873lc.f11065b) {
                case 1:
                    MainActivity.m6983a(this);
                    finish();
                    break;
            }
        }
        if (c1873lc.f11072i == 6) {
            switch (c1873lc.f11065b) {
                case 1:
                    m7016g();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7016g() {
        String string = this.f6539y.getText().toString();
        if (this.f6538x != null) {
            this.f6538x.dismiss();
            this.f6538x = null;
        }
        if (TextUtils.isEmpty(string)) {
            Toast.makeText(this, R.string.nick_name_not_empty, 0).show();
            return;
        }
        if ("1990-07-16".equals(this.f6535t)) {
            Toast.makeText(this, R.string.Birtyday_can_not_Empty, 0).show();
            return;
        }
        if (C1914mm.m10557b(R.string.perfect_text11).equals(this.f6532q.getText().toString())) {
            Toast.makeText(this, R.string.height_empty, 0).show();
            return;
        }
        if (C1914mm.m10557b(R.string.perfect_text11).equals(this.f6533r.getText().toString())) {
            Toast.makeText(this, R.string.weight_empty, 0).show();
        } else if (this.f6537v.contentEquals("1")) {
            m7002a(string, this.f6536u, this.f6535t, this.f6512B, this.f6513C, "", "", this.f6537v, "", "0");
        } else {
            this.f6540z.m10197a(string, this.f6536u, this.f6535t, this.f6512B, this.f6513C, "", "", this.f6537v, "", "0", "", "");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7002a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10) {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(5, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.3
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                PerfectInformationActivity.this.f6540z.m10197a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", "");
            }
        });
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: h */
    private void m7018h() {
        AlertDialogC1872lb alertDialogC1872lb = new AlertDialogC1872lb(this, getString(R.string.dialog_set_head_tv_title), new AlertDialogC1872lb.a() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.4
            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: a */
            public void mo7024a() {
                Intent intent = new Intent(PerfectInformationActivity.this, (Class<?>) ImageChooseActivity_new.class);
                intent.putExtra("classtype", "PersonaldataActivity");
                PerfectInformationActivity.this.startActivityForResult(intent, 0);
            }

            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: b */
            public void mo7025b() {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Environment.getExternalStorageState().equals("mounted")) {
                    intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "image.jpg")));
                }
                PerfectInformationActivity.this.startActivityForResult(intent, 1);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        if (i2 != 0) {
            switch (i) {
                case 0:
                    if (i2 == -1) {
                        File fileM10082a = C1845kb.m10082a(new File(intent.getStringExtra("pictureURI")), new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "kulangxiaoyu.jpg"));
                        if (fileM10082a != null) {
                            CropImageActivity.m7766a(this, fileM10082a.getPath(), 2);
                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.personaldate_text3), 0).show();
                        }
                    }
                    break;
                case 1:
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        CropImageActivity.m7766a(this, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "image.jpg").getPath(), 2);
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.personaldate_text4), 0).show();
                    }
                    break;
                case 2:
                    if (i2 == -1) {
                        this.f6529n = ((MyApplication) getApplication()).f7400a;
                        this.f6530o.setImageBitmap(this.f6529n);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7000a(final int i, String str, String str2, String str3) {
        AlertDialogC1865kv alertDialogC1865kv = new AlertDialogC1865kv(this, i, new AlertDialogC1865kv.a() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.5
            @Override // p000.AlertDialogC1865kv.a
            /* JADX INFO: renamed from: a */
            public void mo7026a(String str4, String str5, String str6) {
                if (i == 0) {
                    PerfectInformationActivity.this.f6532q.setText(C1910mi.m10525b(String.valueOf(str4), str4 + "  cm", Color.parseColor("#ff8560")));
                    PerfectInformationActivity.this.f6512B = str4;
                    return;
                }
                if (i == 1) {
                    PerfectInformationActivity.this.f6533r.setText(C1910mi.m10525b(String.valueOf(str4), str4 + "  kg", Color.parseColor("#ff8560")));
                    PerfectInformationActivity.this.f6513C = str4;
                    return;
                }
                if (i == 3) {
                    return;
                }
                PerfectInformationActivity.this.f6535t = str4 + "-" + str5 + "-" + str6;
                PerfectInformationActivity.this.f6519d.setText(str4);
                PerfectInformationActivity.this.f6520e.setText(str5);
                PerfectInformationActivity.this.f6521f.setText(str6);
                PerfectInformationActivity.this.f6522g.setText(C1914mm.m10557b(R.string.perfect_text4_year));
                PerfectInformationActivity.this.f6519d.setVisibility(0);
                PerfectInformationActivity.this.f6520e.setVisibility(0);
                PerfectInformationActivity.this.f6521f.setVisibility(0);
                PerfectInformationActivity.this.f6523h.setVisibility(0);
                PerfectInformationActivity.this.f6524i.setVisibility(0);
            }
        }, str, str2, str3);
        alertDialogC1865kv.requestWindowFeature(1);
        alertDialogC1865kv.show();
        alertDialogC1865kv.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }

    /* JADX INFO: renamed from: a */
    private void m7001a(View view) {
        this.f6538x = new PopupWindow(View.inflate(getApplicationContext(), R.layout.popupwindow_wait, null), -1, -1, true);
        this.f6538x.setTouchable(true);
        this.f6538x.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.PerfectInformationActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6538x.setBackgroundDrawable(new BitmapDrawable());
        this.f6538x.showAtLocation(this.f6539y, 17, 0, 0);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.female) {
            this.f6536u = "0";
            return;
        }
        if (i == R.id.lefthand) {
            this.f6537v = "0";
        } else if (i == R.id.male) {
            this.f6536u = "1";
        } else {
            if (i != R.id.righthand) {
                return;
            }
            this.f6537v = "1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m6998a(String str) {
        try {
            return str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
