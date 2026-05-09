package com.coollang.tennis.activity;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.fragment.fragment_search_1;
import java.util.List;
import java.util.Map;
import p000.C1857kn;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class getSearchKeys_Activity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: d */
    public static boolean f7381d = false;

    /* JADX INFO: renamed from: a */
    public EditText f7382a;

    /* JADX INFO: renamed from: b */
    public String f7383b;

    /* JADX INFO: renamed from: c */
    SharedPreferences.Editor f7384c;

    /* JADX INFO: renamed from: e */
    private C1874ld f7385e;

    /* JADX INFO: renamed from: f */
    private ImageView f7386f;

    /* JADX INFO: renamed from: g */
    private TextView f7387g;

    /* JADX INFO: renamed from: h */
    private ImageView f7388h;

    /* JADX INFO: renamed from: i */
    private ImageView f7389i;

    /* JADX INFO: renamed from: j */
    private SharedPreferences f7390j;

    /* JADX INFO: renamed from: k */
    private String f7391k = "MapMapMap";

    /* JADX INFO: renamed from: l */
    private fragment_search_1 f7392l;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_video_search);
        this.f7390j = getSharedPreferences("history", 0);
        this.f7384c = this.f7390j.edit();
        Map<String, ?> all = this.f7390j.getAll();
        Log.e(this.f7391k, "ms: " + all);
        this.f7385e = new C1874ld();
        akd.m1706a().m1719a(this);
        this.f7386f = (ImageView) findViewById(R.id.search);
        this.f7382a = (EditText) findViewById(R.id.edt_search);
        this.f7387g = (TextView) findViewById(R.id.search_video);
        this.f7385e.m10243p();
        this.f7388h = (ImageView) findViewById(R.id.delete);
        this.f7389i = (ImageView) findViewById(R.id.back);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.fl_container);
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        if (fragmentFindFragmentById == null) {
            this.f7392l = fragment_search_1.m7992b();
            fragmentTransactionBeginTransaction.add(R.id.fl_container, this.f7392l);
            fragmentTransactionBeginTransaction.commit();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m7729c() {
        this.f7387g.setTextColor(getResources().getColor(R.color.huise));
        this.f7387g.setEnabled(false);
    }

    /* JADX INFO: renamed from: d */
    public void m7730d() {
        this.f7387g.setTextColor(getResources().getColor(R.color.white));
        this.f7387g.setEnabled(true);
    }

    /* JADX INFO: renamed from: e */
    public String m7731e() {
        return this.f7383b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7388h.setOnClickListener(this);
        this.f7386f.setOnClickListener(this);
        this.f7389i.setOnClickListener(this);
        this.f7387g.setOnClickListener(this);
        this.f7382a.addTextChangedListener(new TextWatcher() { // from class: com.coollang.tennis.activity.getSearchKeys_Activity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Log.e("TAG", "afterTextChanged: " + ((Object) editable));
                if (editable != null && !editable.toString().equals("")) {
                    getSearchKeys_Activity.this.f7388h.setVisibility(0);
                    getSearchKeys_Activity.this.m7730d();
                    getSearchKeys_Activity.this.f7383b = editable.toString();
                    return;
                }
                getSearchKeys_Activity.this.m7729c();
                getSearchKeys_Activity.this.f7388h.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131296373 */:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    finish();
                }
                break;
            case R.id.delete /* 2131296518 */:
                this.f7382a.setText("");
                break;
            case R.id.search_video /* 2131297078 */:
                String strValueOf = String.valueOf(this.f7382a.getText());
                if (!strValueOf.equals("") && strValueOf != null) {
                    this.f7383b = strValueOf;
                    f7381d = true;
                    Log.e("TAG", "search_video: " + strValueOf);
                    this.f7385e.m10218e("1", strValueOf);
                    this.f7384c.putString("history", strValueOf);
                    this.f7384c.commit();
                    C1857kn c1857kn = new C1857kn(this);
                    List<String> listM10122c = c1857kn.m10122c(strValueOf);
                    if (!listM10122c.isEmpty()) {
                        for (int i = 0; i < listM10122c.size(); i++) {
                            if (listM10122c.get(i).equals(strValueOf)) {
                                c1857kn.m10121b(strValueOf);
                            }
                        }
                    }
                    c1857kn.m10120a(strValueOf);
                } else {
                    Toast.makeText(this, "请输入内容", 0).show();
                }
                break;
        }
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 64) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "搜索关键词服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "搜索关键词失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "搜索关键词成功");
                    break;
            }
        }
        if (c1873lc.f11072i == 123) {
            switch (c1873lc.f11065b) {
                case 1:
                    this.f7383b = c1873lc.f11064a;
                    this.f7385e.m10218e("1", this.f7383b);
                    break;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        if (JZVideoPlayer.m5816b()) {
            Log.e("TAG", "onBackPressed: ");
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
        JZVideoPlayer.m5818d();
        JZVideoPlayer.m5813a();
    }
}
