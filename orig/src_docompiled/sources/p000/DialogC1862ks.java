package p000;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;

/* JADX INFO: renamed from: ks */
/* JADX INFO: compiled from: GetMedalDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1862ks extends Dialog {

    /* JADX INFO: renamed from: a */
    private Context f10941a;

    /* JADX INFO: renamed from: b */
    private RelativeLayout f10942b;

    /* JADX INFO: renamed from: c */
    private ImageView f10943c;

    /* JADX INFO: renamed from: d */
    private TextView f10944d;

    /* JADX INFO: renamed from: e */
    private ImageView f10945e;

    /* JADX INFO: renamed from: f */
    private int f10946f;

    public DialogC1862ks(Context context, int i) {
        super(context, R.style.base_dialog);
        this.f10941a = context;
        this.f10946f = i;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_pop_get_medal);
        this.f10942b = (RelativeLayout) findViewById(R.id.rl_medal_root);
        this.f10943c = (ImageView) findViewById(R.id.imgv_medal_close);
        this.f10945e = (ImageView) findViewById(R.id.imgv_medal_type);
        this.f10944d = (TextView) findViewById(R.id.tv_medal_desc);
        this.f10943c.setOnClickListener(new View.OnClickListener() { // from class: ks.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1862ks.this.dismiss();
            }
        });
        m10132a();
    }

    /* JADX INFO: renamed from: a */
    private void m10132a() {
        switch (this.f10946f) {
            case 0:
                this.f10945e.setImageResource(R.drawable.ic_model_select_1);
                this.f10944d.setText(R.string.medal_get_str_01);
                break;
            case 1:
                this.f10945e.setImageResource(R.drawable.ic_model_select_3);
                this.f10944d.setText(R.string.medal_get_str_02);
                break;
            case 2:
                this.f10945e.setImageResource(R.drawable.ic_model_select_2);
                this.f10944d.setText(R.string.medal_get_str_03);
                break;
            case 3:
                this.f10945e.setImageResource(R.drawable.ic_model_select_5);
                this.f10944d.setText(R.string.medal_get_str_04);
                break;
            case 4:
                this.f10945e.setImageResource(R.drawable.ic_model_select_4);
                this.f10944d.setText(R.string.medal_get_str_05);
                break;
            case 5:
                this.f10945e.setImageResource(R.drawable.ic_model_select_6);
                this.f10944d.setText(R.string.medal_get_str_06);
                break;
            case 6:
                this.f10945e.setImageResource(R.drawable.ic_model_select_7);
                this.f10944d.setText(R.string.medal_get_str_07);
                break;
            case 7:
                this.f10945e.setImageResource(R.drawable.ic_model_select_8);
                this.f10944d.setText(R.string.medal_get_str_08);
                break;
            case 8:
                this.f10945e.setImageResource(R.drawable.ic_model_select_9);
                this.f10944d.setText(R.string.medal_get_str_09);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10133a(DialogInterface.OnDismissListener onDismissListener) {
        setOnDismissListener(onDismissListener);
    }

    @Override // android.app.Dialog
    public void show() {
        if (MyApplication.m7738a().m7747g()) {
            super.show();
            this.f10942b.startAnimation(AnimationUtils.loadAnimation(this.f10941a, R.anim.medal_get_show_anim));
        }
    }
}
