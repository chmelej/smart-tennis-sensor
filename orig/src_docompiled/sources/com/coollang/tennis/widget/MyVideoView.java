package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.coollang.tennis.R;
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class MyVideoView extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private VideoView f8475a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f8476b;

    /* JADX INFO: renamed from: c */
    private TextView f8477c;

    /* JADX INFO: renamed from: d */
    private TextView f8478d;

    /* JADX INFO: renamed from: e */
    private SeekBar f8479e;

    /* JADX INFO: renamed from: f */
    private Context f8480f;

    /* JADX INFO: renamed from: g */
    private int f8481g;

    public MyVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8480f = context;
        m8190a();
    }

    public MyVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8480f = context;
        m8190a();
    }

    public MyVideoView(Context context) {
        super(context);
        this.f8480f = context;
        m8190a();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: a */
    private void m8190a() {
        View viewM10555a = C1914mm.m10555a(R.layout.my_video_view);
        this.f8476b = (LinearLayout) viewM10555a.findViewById(R.id.my_video_view_ll_control);
        this.f8478d = (TextView) viewM10555a.findViewById(R.id.my_video_view_tv_time);
        this.f8479e = (SeekBar) viewM10555a.findViewById(R.id.my_video_view_sb);
        this.f8479e.setProgress(0);
        this.f8479e.setOnTouchListener(this);
        this.f8477c.setOnClickListener(this);
        MediaController mediaController = new MediaController(this.f8480f);
        mediaController.setMediaPlayer(this.f8475a);
        mediaController.setVisibility(4);
        this.f8475a.setMediaController(mediaController);
        this.f8475a.setOnTouchListener(new View.OnTouchListener() { // from class: com.coollang.tennis.widget.MyVideoView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MyVideoView.this.f8476b.getVisibility() == 0) {
                    MyVideoView.this.f8476b.setVisibility(8);
                    return true;
                }
                MyVideoView.this.f8476b.setVisibility(0);
                return true;
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.f8481g = this.f8479e.getProgress();
                if (this.f8475a.isPlaying()) {
                    this.f8475a.seekTo(this.f8481g);
                }
                break;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }
}
