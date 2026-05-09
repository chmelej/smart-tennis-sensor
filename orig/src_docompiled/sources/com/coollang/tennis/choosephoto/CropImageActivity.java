package com.coollang.tennis.choosephoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import java.io.IOException;
import p000.C1895ly;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private CropImageView f7445a;

    /* JADX INFO: renamed from: b */
    private TextView f7446b;

    /* JADX INFO: renamed from: c */
    private TextView f7447c;

    /* JADX INFO: renamed from: d */
    private String f7448d;

    /* JADX INFO: renamed from: e */
    private Drawable f7449e = null;

    /* JADX INFO: renamed from: f */
    private int f7450f;

    /* JADX INFO: renamed from: g */
    private int f7451g;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crop_image);
        this.f7445a = (CropImageView) findViewById(R.id.activity_crop_image_crop_image_view);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_crop_image_rl);
        View viewFindViewById = findViewById(R.id.activity_crop_image_view);
        this.f7447c = (TextView) findViewById(R.id.activity_crop_image_tv_last_step);
        this.f7446b = (TextView) findViewById(R.id.activity_crop_image_tv_next_step);
        this.f7447c.setOnClickListener(this);
        this.f7446b.setOnClickListener(this);
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        this.f7450f = defaultDisplay.getWidth();
        this.f7451g = defaultDisplay.getHeight();
        relativeLayout.getLayoutParams().height = ((this.f7451g - this.f7450f) / 2) - C1895ly.m10460a(this, 11.0f);
        viewFindViewById.getLayoutParams().height = ((this.f7451g - this.f7450f) / 2) - C1895ly.m10460a(this, 11.0f);
        this.f7448d = getIntent().getStringExtra("imgURL");
        C1900mc.m10476d("========传递过来的图片路径==============", this.f7448d);
        if (this.f7448d != null) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.f7448d);
            if (m7762a(this.f7448d) != 0) {
                bitmapDecodeFile = m7763a(bitmapDecodeFile, m7762a(this.f7448d));
            }
            this.f7445a.setDrawable(new BitmapDrawable(bitmapDecodeFile), this.f7450f, this.f7450f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_crop_image_tv_last_step /* 2131296298 */:
                finish();
                break;
            case R.id.activity_crop_image_tv_next_step /* 2131296299 */:
                m7765a();
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7765a() {
        new Thread(new Runnable() { // from class: com.coollang.tennis.choosephoto.CropImageActivity.1
            @Override // java.lang.Runnable
            public void run() {
                ((MyApplication) CropImageActivity.this.getApplication()).f7400a = CropImageActivity.this.f7445a.getCropImage();
                CropImageActivity.this.setResult(-1);
                C1900mc.m10476d("=============下一步=========", "");
                CropImageActivity.this.finish();
            }
        }).start();
    }

    /* JADX INFO: renamed from: a */
    public static void m7766a(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, (Class<?>) CropImageActivity.class);
        intent.putExtra("imgURL", str);
        activity.startActivityForResult(intent, i);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: renamed from: a */
    public static int m7762a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m7763a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
