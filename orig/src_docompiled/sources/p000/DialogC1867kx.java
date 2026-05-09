package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kx */
/* JADX INFO: compiled from: SaveTargetDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1867kx extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private a f11015a;

    /* JADX INFO: renamed from: b */
    private String f11016b;

    /* JADX INFO: renamed from: c */
    private String f11017c;

    /* JADX INFO: renamed from: d */
    private String f11018d;

    /* JADX INFO: renamed from: e */
    private String f11019e;

    /* JADX INFO: renamed from: f */
    private EditText f11020f;

    /* JADX INFO: renamed from: g */
    private Context f11021g;

    /* JADX INFO: renamed from: h */
    private int f11022h;

    /* JADX INFO: renamed from: kx$a */
    /* JADX INFO: compiled from: SaveTargetDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7195a();

        /* JADX INFO: renamed from: a */
        void mo7196a(String str);
    }

    public DialogC1867kx(Context context, String str, String str2, String str3, String str4, a aVar) {
        super(context, R.style.dialog);
        this.f11016b = "";
        this.f11017c = "";
        this.f11022h = 500;
        this.f11015a = aVar;
        this.f11016b = str;
        this.f11017c = str2;
        this.f11018d = str3;
        this.f11019e = str4;
        this.f11021g = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_save_target);
        TextView textView = (TextView) findViewById(R.id.dialog_save_target_tv_title);
        TextView textView2 = (TextView) findViewById(R.id.dialog_save_target_tv_content);
        Button button = (Button) findViewById(R.id.dialog_save_target_btn_cancel);
        Button button2 = (Button) findViewById(R.id.dialog_save_target_btn_confirm);
        this.f11020f = (EditText) findViewById(R.id.dialog_save_target_et_name);
        textView.setText(this.f11016b);
        if (!TextUtils.isEmpty(this.f11017c)) {
            textView2.setText(this.f11017c);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f11019e)) {
            button.setText(this.f11019e);
        } else {
            button.setVisibility(8);
        }
        if (this.f11016b.equals(C1914mm.m10557b(R.string.update_name))) {
            this.f11020f.setVisibility(0);
            m10158a();
        } else {
            this.f11020f.setVisibility(8);
        }
        this.f11020f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f11022h)});
        button2.setText(this.f11018d);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    public void m10160a(int i) {
        this.f11022h = i;
    }

    /* JADX INFO: renamed from: a */
    private void m10158a() {
        new Handler().postDelayed(new Runnable() { // from class: kx.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) DialogC1867kx.this.f11021g.getSystemService("input_method")).showSoftInput(DialogC1867kx.this.f11020f, 0);
            }
        }, 1000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_save_target_btn_cancel /* 2131296528 */:
                dismiss();
                if (this.f11015a != null) {
                    this.f11015a.mo7195a();
                }
                break;
            case R.id.dialog_save_target_btn_confirm /* 2131296529 */:
                dismiss();
                if (this.f11015a != null) {
                    if (this.f11016b.equals(C1914mm.m10557b(R.string.update_name))) {
                        this.f11015a.mo7196a(this.f11020f.getText().toString());
                    } else {
                        this.f11015a.mo7196a("");
                    }
                }
                break;
        }
    }
}
