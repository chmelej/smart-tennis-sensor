package com.coollang.tennis.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.TouchImageView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import java.io.File;
import p000.AlertDialogC1866kw;
import p000.C1852ki;
import p000.C1913ml;
import p000.C2068qy;

/* JADX INFO: loaded from: classes.dex */
public class ShowImageActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private ImageView f6886a;

    /* JADX INFO: renamed from: b */
    private TouchImageView f6887b;

    /* JADX INFO: renamed from: c */
    private String f6888c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_show_image);
        m7297c();
        m7298d();
        m7299e();
        m7300f();
    }

    /* JADX INFO: renamed from: c */
    private void m7297c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6888c = extras.getString("url");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7298d() {
        this.f6886a = (ImageView) findViewById(R.id.img_left);
        this.f6887b = (TouchImageView) findViewById(R.id.imgv_show);
    }

    /* JADX INFO: renamed from: e */
    private void m7299e() {
        C2068qy.m11356a().m11360a(this.f6888c, this.f6887b);
    }

    /* JADX INFO: renamed from: f */
    private void m7300f() {
        this.f6886a.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.ShowImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShowImageActivity.this.m7733j();
            }
        });
        this.f6887b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coollang.tennis.activity.ShowImageActivity.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ShowImageActivity.this.m7301g();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7301g() {
        AlertDialogC1866kw alertDialogC1866kw = new AlertDialogC1866kw(this, getString(R.string.dialog_set_head_tv_title), new AlertDialogC1866kw.a() { // from class: com.coollang.tennis.activity.ShowImageActivity.3
            @Override // p000.AlertDialogC1866kw.a
            /* JADX INFO: renamed from: a */
            public void mo7303a() {
                ShowImageActivity.this.m7302h();
            }
        });
        alertDialogC1866kw.show();
        Window window = alertDialogC1866kw.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mystyle);
        window.setGravity(80);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7302h() {
        final File file = new File(C1852ki.f10917d + String.valueOf(System.currentTimeMillis()) + ".png");
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        new HttpUtils().download(this.f6888c, file.getPath(), new RequestCallBack<File>() { // from class: com.coollang.tennis.activity.ShowImageActivity.4
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<File> responseInfo) {
                C1913ml.m10552a(R.string.save_success);
                if (Build.VERSION.SDK_INT >= 19) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file));
                    ShowImageActivity.this.sendBroadcast(intent);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.MEDIA_MOUNTED");
                    intent2.setData(Uri.fromFile(file));
                    ShowImageActivity.this.sendBroadcast(intent2);
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                C1913ml.m10553a(ShowImageActivity.this.getString(R.string.fail_save));
            }
        });
    }
}
