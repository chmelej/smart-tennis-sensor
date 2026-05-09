package com.coollang.tennis.fragment;

import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.getSearchKeys_Activity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.beans.getSearchKeysBean;
import com.google.gson.Gson;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import p000.C1814iy;
import p000.C1831jo;
import p000.C1857kn;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1914mm;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class fragment_search_1 extends BaseFragment {

    /* JADX INFO: renamed from: a */
    LayoutInflater f7881a;

    /* JADX INFO: renamed from: b */
    String[] f7882b;

    /* JADX INFO: renamed from: c */
    private TagFlowLayout f7883c;

    /* JADX INFO: renamed from: d */
    private ListView f7884d;

    /* JADX INFO: renamed from: e */
    private C1874ld f7885e;

    /* JADX INFO: renamed from: f */
    private String f7886f = "fragment_search_1";

    /* JADX INFO: renamed from: b */
    public static fragment_search_1 m7992b() {
        return new fragment_search_1();
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return C1914mm.m10555a(R.layout.fragment_video_search_1);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        akd.m1706a().m1719a(this);
        this.f7884d = (ListView) view.findViewById(R.id.listview);
        this.f7885e = new C1874ld();
        this.f7885e.m10243p();
        this.f7883c = (TagFlowLayout) view.findViewById(R.id.flowlayout);
        this.f7881a = LayoutInflater.from(getActivity());
        getActivity().getSharedPreferences("history", 0).getString("history", "");
        List<String> listM10119a = new C1857kn(getActivity()).m10119a();
        if (listM10119a != null) {
            this.f7884d.setAdapter((ListAdapter) new C1831jo(getActivity(), m7993a(listM10119a)));
        }
        this.f7884d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.fragment.fragment_search_1.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                String str = (String) adapterView.getAdapter().getItem(i);
                getSearchKeys_Activity getsearchkeys_activity = (getSearchKeys_Activity) fragment_search_1.this.getActivity();
                getsearchkeys_activity.f7382a.setText(str);
                FragmentTransaction fragmentTransactionBeginTransaction = getsearchkeys_activity.getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.hide(fragment_search_1.this);
                fragmentTransactionBeginTransaction.add(R.id.fl_container, new fragment_search_2());
                fragmentTransactionBeginTransaction.addToBackStack(null);
                fragmentTransactionBeginTransaction.commit();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public List<String> m7993a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                arrayList.add(list.get(size));
            }
        }
        return arrayList;
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
                    getSearchKeysBean getsearchkeysbean = (getSearchKeysBean) new Gson().fromJson(c1873lc.f11064a, getSearchKeysBean.class);
                    this.f7882b = getsearchkeysbean.errDesc;
                    this.f7883c.setAdapter(new C1814iy(getActivity(), this.f7882b, this.f7883c));
                    C1900mc.m10475c("TAG", "搜索关键词成功" + getsearchkeysbean.errDesc.length);
                    break;
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        this.f7883c.setOnTagClickListener(new TagFlowLayout.InterfaceC1640b() { // from class: com.coollang.tennis.fragment.fragment_search_1.2
            @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC1640b
            /* JADX INFO: renamed from: a */
            public boolean mo7994a(View view, int i, FlowLayout flowLayout) {
                fragment_search_1.this.f7885e.m10218e("1", fragment_search_1.this.f7882b[i]);
                C1857kn c1857kn = new C1857kn(fragment_search_1.this.getActivity());
                List<String> listM10122c = c1857kn.m10122c(fragment_search_1.this.f7882b[i]);
                if (!listM10122c.isEmpty()) {
                    for (int i2 = 0; i2 < listM10122c.size(); i2++) {
                        if (listM10122c.get(i2).equals(fragment_search_1.this.f7882b[i])) {
                            c1857kn.m10121b(fragment_search_1.this.f7882b[i]);
                        }
                    }
                }
                c1857kn.m10120a(fragment_search_1.this.f7882b[i]);
                getSearchKeys_Activity getsearchkeys_activity = (getSearchKeys_Activity) fragment_search_1.this.getActivity();
                getsearchkeys_activity.f7382a.setText(fragment_search_1.this.f7882b[i]);
                FragmentTransaction fragmentTransactionBeginTransaction = getsearchkeys_activity.getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.hide(fragment_search_1.this);
                fragmentTransactionBeginTransaction.add(R.id.fl_container, new fragment_search_2());
                fragmentTransactionBeginTransaction.addToBackStack(null);
                fragmentTransactionBeginTransaction.commit();
                return false;
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        Log.e("TAG", "onPause: ");
        JZVideoPlayer.m5818d();
        JZVideoPlayer.m5813a();
        super.onPause();
        akd.m1706a().m1721b(this);
    }
}
