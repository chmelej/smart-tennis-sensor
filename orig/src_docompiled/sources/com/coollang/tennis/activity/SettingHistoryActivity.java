package com.coollang.tennis.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.MyCareerListBean;
import com.coollang.tennis.beans.SettingHistoryItemBean;
import com.coollang.tennis.beans.UploadCareerResultBean;
import com.coollang.tennis.fragment.PersonalMainFramgent;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p000.C1808is;
import p000.C1826jj;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1913ml;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingHistoryActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: b */
    private NavigateView f6676b;

    /* JADX INFO: renamed from: c */
    private ListView f6677c;

    /* JADX INFO: renamed from: d */
    private View f6678d;

    /* JADX INFO: renamed from: e */
    private LinearLayout f6679e;

    /* JADX INFO: renamed from: f */
    private View f6680f;

    /* JADX INFO: renamed from: h */
    private C1826jj f6682h;

    /* JADX INFO: renamed from: i */
    private C1874ld f6683i;

    /* JADX INFO: renamed from: j */
    private Gson f6684j;

    /* JADX INFO: renamed from: k */
    private MyCareerListBean f6685k;

    /* JADX INFO: renamed from: l */
    private int f6686l;

    /* JADX INFO: renamed from: g */
    private List<SettingHistoryItemBean> f6681g = new ArrayList();

    /* JADX INFO: renamed from: a */
    Comparator f6675a = new Comparator<SettingHistoryItemBean>() { // from class: com.coollang.tennis.activity.SettingHistoryActivity.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SettingHistoryItemBean settingHistoryItemBean, SettingHistoryItemBean settingHistoryItemBean2) {
            return settingHistoryItemBean.Year.compareTo(settingHistoryItemBean2.Year);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_history);
        m7116d();
        m7118e();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: d */
    private void m7116d() {
        this.f6676b = (NavigateView) findViewById(R.id.navigateView);
        this.f6677c = (ListView) findViewById(R.id.lv_setting_history);
        this.f6679e = (LinearLayout) findViewById(R.id.ll_delete_archieve);
        this.f6678d = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
        this.f6680f = LayoutInflater.from(this).inflate(R.layout.layout_setting_his_add, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: e */
    private void m7118e() {
        this.f6676b.setTitle(R.string.my_tennis_history);
        this.f6676b.setRightButtonBackground(android.R.color.transparent);
        this.f6676b.setRightButtonText(getString(R.string.edit));
        this.f6676b.setRightButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SettingHistoryActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                if (SettingHistoryActivity.this.f6686l == 1200) {
                    SettingHistoryActivity.this.m7123i();
                } else {
                    SettingHistoryActivity.this.m7122h();
                }
            }
        });
        this.f6678d.findViewById(R.id.top_line).setVisibility(8);
        this.f6677c.addHeaderView(this.f6678d);
        this.f6677c.addFooterView(this.f6680f);
        this.f6682h = new C1826jj(this.f6681g, this);
        this.f6677c.setAdapter((ListAdapter) this.f6682h);
        m7122h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6686l = 1200;
        this.f6683i = new C1874ld();
        this.f6684j = new Gson();
        this.f6683i.m10235l();
        PersonalMainFramgent.f7520c = true;
        m7120f();
    }

    /* JADX INFO: renamed from: f */
    private void m7120f() {
        this.f6679e.setOnClickListener(this);
        this.f6677c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.SettingHistoryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i - 1;
                if (SettingHistoryActivity.this.f6686l == 1200) {
                    C1887lq.m10415a(SettingHistoryActivity.this, ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).Year, ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).Career, i2);
                    return;
                }
                ImageView imageView = (ImageView) SettingHistoryActivity.this.f6677c.findViewWithTag(Integer.valueOf(i2));
                if (imageView != null) {
                    if (((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked) {
                        imageView.setImageResource(R.drawable.img_no_ck_archieve);
                        ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked = false;
                        return;
                    } else {
                        imageView.setImageResource(R.drawable.img_ck_archieve);
                        ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked = true;
                        return;
                    }
                }
                if (((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked) {
                    ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked = false;
                } else {
                    ((SettingHistoryItemBean) SettingHistoryActivity.this.f6681g.get(i2)).isChecked = true;
                }
                SettingHistoryActivity.this.f6682h.notifyDataSetChanged();
            }
        });
        this.f6680f.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.SettingHistoryActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1887lq.m10415a(SettingHistoryActivity.this, null, null, SettingHistoryActivity.this.f6681g.size() + 2);
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 48) {
            C1900mc.m10474b("result", "position == " + c1873lc.f11064a);
            int i = Integer.parseInt(c1873lc.f11064a);
            if (c1873lc.f11071h == null || c1873lc.f11071h.isEmpty()) {
                return;
            }
            if (i + 1 > this.f6681g.size()) {
                SettingHistoryItemBean settingHistoryItemBean = new SettingHistoryItemBean(c1873lc.f11070g, c1873lc.f11071h, false);
                this.f6681g.add(settingHistoryItemBean);
                this.f6683i.m10211c(null, settingHistoryItemBean.Year, settingHistoryItemBean.Career);
                return;
            } else {
                if (c1873lc.f11070g.equals(this.f6681g.get(i).Year) && c1873lc.f11071h.equals(this.f6681g.get(i).Career)) {
                    return;
                }
                this.f6681g.get(i).Year = c1873lc.f11070g;
                this.f6681g.get(i).Career = c1873lc.f11071h;
                this.f6683i.m10211c(this.f6681g.get(i).f7419ID, this.f6681g.get(i).Year, this.f6681g.get(i).Career);
                Collections.sort(this.f6681g, this.f6675a);
                this.f6682h.notifyDataSetChanged();
                return;
            }
        }
        if (c1873lc.f11072i == 53) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10474b("履历列表", c1873lc.f11064a);
                    this.f6685k = (MyCareerListBean) this.f6684j.fromJson(c1873lc.f11064a, MyCareerListBean.class);
                    this.f6681g.clear();
                    this.f6681g.addAll(this.f6685k.errDesc);
                    Collections.sort(this.f6681g, this.f6675a);
                    this.f6682h.notifyDataSetChanged();
                    break;
            }
        }
        if (c1873lc.f11072i == 54) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    Collections.sort(this.f6681g, this.f6675a);
                    this.f6682h.notifyDataSetChanged();
                    C1913ml.m10553a("上传失败");
                    break;
                case 1:
                    C1900mc.m10474b("上传生涯", c1873lc.f11064a);
                    if (c1873lc.f11067d == null && !this.f6681g.isEmpty()) {
                        this.f6681g.get(this.f6681g.size() - 1).f7419ID = ((UploadCareerResultBean) this.f6684j.fromJson(c1873lc.f11064a, UploadCareerResultBean.class)).errDesc.f7432ID;
                        Collections.sort(this.f6681g, this.f6675a);
                        this.f6682h.notifyDataSetChanged();
                        break;
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 55) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a("上传失败");
                    break;
                case 1:
                    C1900mc.m10474b("删除数据", c1873lc.f11064a);
                    m7121g();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7121g() {
        for (int size = this.f6681g.size() - 1; size >= 0; size--) {
            if (this.f6681g.get(size).isChecked) {
                this.f6681g.remove(size);
            }
        }
        m7122h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId()) || view.getId() != R.id.ll_delete_archieve || m7124c().equals("") || m7124c() == null) {
            return;
        }
        String strM7124c = m7124c();
        this.f6683i.m10223g(strM7124c);
        if (strM7124c.isEmpty()) {
            return;
        }
        m7121g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7122h() {
        this.f6686l = 1200;
        this.f6676b.setRightButtonText(getString(R.string.edit));
        this.f6679e.setVisibility(8);
        this.f6682h.m9921b(this.f6686l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m7123i() {
        this.f6686l = 1201;
        this.f6676b.setRightButtonText(getString(R.string.cancel));
        this.f6679e.setVisibility(0);
        this.f6682h.m9921b(this.f6686l);
    }

    /* JADX INFO: renamed from: c */
    public String m7124c() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.f6681g.size(); i++) {
            if (this.f6681g.get(i).isChecked && this.f6681g.get(i).f7419ID != null) {
                stringBuffer.append(this.f6681g.get(i).f7419ID);
                stringBuffer.append(",");
            }
        }
        C1808is.m9826b(stringBuffer);
        if (stringBuffer == null) {
            return null;
        }
        String string = stringBuffer.toString();
        if (string == null || string.equals("")) {
            return string;
        }
        C1900mc.m10474b("before ids", string);
        String strSubstring = string.substring(0, string.length() - 1);
        C1900mc.m10474b("after ids", strSubstring);
        return strSubstring;
    }
}
