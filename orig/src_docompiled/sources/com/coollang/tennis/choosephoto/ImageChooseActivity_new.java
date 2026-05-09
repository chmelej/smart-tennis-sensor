package com.coollang.tennis.choosephoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.List;
import p000.C1849kf;
import p000.C1850kg;
import p000.C1851kh;

/* JADX INFO: loaded from: classes.dex */
public class ImageChooseActivity_new extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private List<C1851kh> f7478a;

    /* JADX INFO: renamed from: b */
    private C1849kf f7479b;

    /* JADX INFO: renamed from: c */
    private GridView f7480c;

    /* JADX INFO: renamed from: d */
    private TextView f7481d;

    /* JADX INFO: renamed from: e */
    private C1850kg f7482e;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_choose);
        this.f7478a = new ArrayList();
        this.f7479b = C1849kf.m10092a(getApplicationContext());
        this.f7478a = this.f7479b.m10096a(false);
        m7772a();
    }

    /* JADX INFO: renamed from: a */
    private void m7772a() {
        this.f7481d = (TextView) findViewById(R.id.title);
        this.f7481d.setText(getString(R.string.photo));
        ((Button) findViewById(R.id.finish_btn)).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.action);
        textView.setVisibility(0);
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_return);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.f7480c = (GridView) findViewById(R.id.gridview);
        this.f7480c.setSelector(new ColorDrawable(0));
        this.f7482e = new C1850kg(this, this.f7478a);
        this.f7480c.setAdapter((ListAdapter) this.f7482e);
        this.f7480c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.choosephoto.ImageChooseActivity_new.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                intent.putExtra("pictureURI", ((C1851kh) ImageChooseActivity_new.this.f7478a.get(i)).f10911c);
                ImageChooseActivity_new.this.setResult(-1, intent);
                ImageChooseActivity_new.this.finish();
                ImageChooseActivity_new.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.action) {
            finish();
        } else {
            if (id != R.id.iv_return) {
                return;
            }
            finish();
        }
    }
}
