package com.coollang.tennis.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.BallStarTeachActivity;
import com.coollang.tennis.activity.TrackModeActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.widget.NavigateView;
import com.lidroid.xutils.ViewUtils;
import p000.C1887lq;
import p000.C1914mm;
import p000.ada;

/* JADX INFO: loaded from: classes.dex */
public class TrainFragment extends BaseFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f7757a;

    /* JADX INFO: renamed from: b */
    private ImageView f7758b;

    /* JADX INFO: renamed from: c */
    private ImageView f7759c;

    /* JADX INFO: renamed from: d */
    private ImageView f7760d;

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        View viewM10555a = C1914mm.m10555a(R.layout.fragment_train);
        ViewUtils.inject(this, viewM10555a);
        return viewM10555a;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7757a = (NavigateView) view.findViewById(R.id.navigateView);
        this.f7758b = (ImageView) view.findViewById(R.id.imgv_train_mode);
        this.f7759c = (ImageView) view.findViewById(R.id.imgv_track_mode);
        this.f7760d = (ImageView) view.findViewById(R.id.imgv_video_mode);
        m7966b();
        m7967c();
    }

    /* JADX INFO: renamed from: b */
    private void m7966b() {
        this.f7757a.setTitle(C1914mm.m10557b(R.string.train_center));
        this.f7757a.setLeftHideBtn(true);
        this.f7757a.setRightButtonBackground((Drawable) null);
        this.f7757a.setRightHideBtn(true);
    }

    /* JADX INFO: renamed from: c */
    private void m7967c() {
        this.f7758b.setOnClickListener(this);
        this.f7759c.setOnClickListener(this);
        this.f7760d.setOnClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        ada.m302b(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ada.m301a(getActivity());
    }

    /* JADX INFO: renamed from: d */
    private void m7968d() {
        C1887lq.m10416b(getActivity());
    }

    /* JADX INFO: renamed from: e */
    private void m7969e() {
        TrackModeActivity.m7345a(getActivity());
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgv_track_mode /* 2131296683 */:
                m7969e();
                break;
            case R.id.imgv_train_mode /* 2131296685 */:
                m7968d();
                break;
            case R.id.imgv_video_mode /* 2131296686 */:
                startActivity(new Intent(getActivity(), (Class<?>) BallStarTeachActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                break;
        }
    }
}
