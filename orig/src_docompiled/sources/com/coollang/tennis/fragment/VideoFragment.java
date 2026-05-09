package com.coollang.tennis.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.AndroidRecorder;
import com.coollang.tennis.activity.MyVideo_msg_Activity;
import com.coollang.tennis.activity.getSearchKeys_Activity;
import com.coollang.tennis.adapter.Video_fragment_adapter;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.beans.MymsgListBean;
import com.coollang.tennis.beans.Video_LIST_Bean;
import com.google.gson.Gson;
import com.umeng.message.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import p000.C1696eo;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1902me;
import p000.akd;
import p000.asw;
import pub.devrel.easypermissions.EasyPermissions;

/* JADX INFO: loaded from: classes.dex */
public class VideoFragment extends BaseFragment implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

    /* JADX INFO: renamed from: c */
    public static List<Video_LIST_Bean.C1214d2> f7761c;

    /* JADX INFO: renamed from: a */
    TabLayout f7762a;

    /* JADX INFO: renamed from: b */
    C1874ld f7763b;

    /* JADX INFO: renamed from: d */
    private ViewPager f7764d;

    /* JADX INFO: renamed from: e */
    private List<Fragment> f7765e;

    /* JADX INFO: renamed from: f */
    private ImageView f7766f;

    /* JADX INFO: renamed from: g */
    private ImageView f7767g;

    /* JADX INFO: renamed from: h */
    private ImageView f7768h;

    /* JADX INFO: renamed from: l */
    private int f7772l;

    /* JADX INFO: renamed from: i */
    private String f7769i = "VideoFragment";

    /* JADX INFO: renamed from: j */
    private final int f7770j = 1;

    /* JADX INFO: renamed from: k */
    private String f7771k = "1";

    /* JADX INFO: renamed from: m */
    private String[] f7773m = {"android.permission.RECORD_AUDIO", "android.permission.CAMERA", MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE};

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo7922a(int i, List<String> list) {
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    /* JADX INFO: renamed from: b */
    public void mo7924b(int i, List<String> list) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean shouldShowRequestPermissionRationale(String str) {
        return false;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return layoutInflater.cloneInContext(new C1696eo(getActivity(), R.style.newsapp)).inflate(R.layout.fragment_video, (ViewGroup) null, false);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7766f = (ImageView) view.findViewById(R.id.search);
        this.f7768h = (ImageView) view.findViewById(R.id.message);
        this.f7763b = new C1874ld();
        this.f7767g = (ImageView) view.findViewById(R.id.video_recording);
        fragment_collection fragment_collectionVar = new fragment_collection();
        fragment_recommend fragment_recommendVar = new fragment_recommend();
        fragment_content3 fragment_content3Var = new fragment_content3();
        fragment_content4 fragment_content4Var = new fragment_content4();
        fragment_content5 fragment_content5Var = new fragment_content5();
        fragment_content6 fragment_content6Var = new fragment_content6();
        this.f7762a = (TabLayout) view.findViewById(R.id.tab_layout);
        this.f7764d = (ViewPager) view.findViewById(R.id.viewpager_main);
        this.f7765e = new ArrayList();
        this.f7765e.add(fragment_collectionVar);
        this.f7765e.add(fragment_recommendVar);
        this.f7765e.add(fragment_content3Var);
        this.f7765e.add(fragment_content4Var);
        this.f7765e.add(fragment_content5Var);
        this.f7765e.add(fragment_content6Var);
        akd.m1706a().m1719a(this);
        this.f7763b.m10242o(String.valueOf(this.f7771k));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11065b == 88) {
            new Handler().post(new Runnable() { // from class: com.coollang.tennis.fragment.VideoFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoFragment.this.f7764d.setCurrentItem(0);
                }
            });
        }
        if (c1873lc.f11072i == 62) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取视频列表服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取视频列表失败");
                    break;
                case 1:
                    Gson gson = new Gson();
                    f7761c = new ArrayList();
                    Video_LIST_Bean video_LIST_Bean = (Video_LIST_Bean) gson.fromJson(c1873lc.f11064a, Video_LIST_Bean.class);
                    FragmentManager fragmentManager = getFragmentManager();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList.add("收藏");
                    arrayList.add("推荐");
                    for (int i = 0; i < video_LIST_Bean.errDesc.size(); i++) {
                        arrayList2.add(video_LIST_Bean.errDesc.get(i).Name);
                    }
                    arrayList.addAll(arrayList2);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        Log.e("TAG", "list_title: " + arrayList.get(i2));
                    }
                    f7761c = video_LIST_Bean.errDesc;
                    for (int i3 = 0; i3 < video_LIST_Bean.errDesc.size(); i3++) {
                        Log.e("TAG", "遍历: " + video_LIST_Bean.errDesc.get(i3).Name);
                    }
                    Log.e("TAG", "list: " + this.f7765e.size());
                    Log.e("TAG", "list_title: " + arrayList.size());
                    Video_fragment_adapter video_fragment_adapter = new Video_fragment_adapter(fragmentManager, this.f7765e, arrayList);
                    this.f7762a.setupWithViewPager(this.f7764d);
                    this.f7762a.setTabsFromPagerAdapter(video_fragment_adapter);
                    this.f7762a.setTabMode(1);
                    this.f7764d.setAdapter(video_fragment_adapter);
                    this.f7764d.setCurrentItem(1);
                    this.f7764d.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.f7762a));
                    break;
            }
        }
        if (c1873lc.f11072i == 80) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取消息失败服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取消息失败 ");
                    break;
                case 1:
                    MymsgListBean mymsgListBean = (MymsgListBean) new Gson().fromJson(c1873lc.f11064a, MymsgListBean.class);
                    if (this.f7772l == mymsgListBean.errDesc.size()) {
                        this.f7768h.setImageResource(R.drawable.message);
                    } else {
                        this.f7768h.setImageResource(R.drawable.msg_have);
                    }
                    this.f7772l = mymsgListBean.errDesc.size();
                    break;
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        String strM10480a = C1902me.m10480a(getActivity());
        Log.e(this.f7769i, "ID: " + strM10480a);
        this.f7763b.m10241o();
        this.f7766f.setOnClickListener(this);
        this.f7767g.setOnClickListener(this);
        this.f7768h.setOnClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.message) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MyVideo_msg_Activity.class);
            getActivity().startActivity(intent);
            this.f7768h.setImageResource(R.drawable.message);
            return;
        }
        if (id != R.id.search) {
            if (id != R.id.video_recording) {
                return;
            }
            jumpVideoRecorder();
        } else {
            Intent intent2 = new Intent();
            intent2.setClass(getActivity(), getSearchKeys_Activity.class);
            getActivity().startActivity(intent2);
        }
    }

    @asw(m5376a = 1)
    public void jumpVideoRecorder() {
        if (EasyPermissions.m11138a(getContext(), this.f7773m)) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), AndroidRecorder.class);
            getActivity().startActivity(intent);
            return;
        }
        EasyPermissions.m11134a(this, "", 1, this.f7773m);
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.m11133a(i, strArr, iArr, this);
    }
}
