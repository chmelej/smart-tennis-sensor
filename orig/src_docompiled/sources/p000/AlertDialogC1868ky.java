package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import java.util.List;

/* JADX INFO: renamed from: ky */
/* JADX INFO: compiled from: SelectEnAddressDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1868ky extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    int f11024a;

    /* JADX INFO: renamed from: b */
    private Button f11025b;

    /* JADX INFO: renamed from: c */
    private Button f11026c;

    /* JADX INFO: renamed from: d */
    private a f11027d;

    /* JADX INFO: renamed from: e */
    private LoopView f11028e;

    /* JADX INFO: renamed from: f */
    private LoopView f11029f;

    /* JADX INFO: renamed from: g */
    private String f11030g;

    /* JADX INFO: renamed from: h */
    private List<String> f11031h;

    /* JADX INFO: renamed from: i */
    private C1854kk f11032i;

    /* JADX INFO: renamed from: ky$a */
    /* JADX INFO: compiled from: SelectEnAddressDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7069a(String str);
    }

    public AlertDialogC1868ky(Context context, List<String> list, a aVar) {
        super(context, R.style.CommonDialog);
        this.f11024a = 0;
        this.f11031h = list;
        this.f11027d = aVar;
        this.f11030g = list.get(0);
        this.f11032i = new C1854kk(context);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_select_address);
        m10164b();
        m10163a();
    }

    /* JADX INFO: renamed from: a */
    private void m10163a() {
        this.f11028e.setArrayList(this.f11031h);
        this.f11028e.setCurrentItem(0);
        this.f11028e.setNotLoop();
        this.f11028e.setListener(new InterfaceC1792ic() { // from class: ky.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                AlertDialogC1868ky.this.f11030g = (String) AlertDialogC1868ky.this.f11031h.get(i);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m10164b() {
        this.f11028e = (LoopView) findViewById(R.id.pv_province);
        this.f11029f = (LoopView) findViewById(R.id.pv_city);
        this.f11025b = (Button) findViewById(R.id.btn_cancle);
        this.f11026c = (Button) findViewById(R.id.btn_confirm);
        this.f11025b.setOnClickListener(this);
        this.f11026c.setOnClickListener(this);
        this.f11029f.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle /* 2131296450 */:
                dismiss();
                break;
            case R.id.btn_confirm /* 2131296451 */:
                if (this.f11027d != null) {
                    this.f11027d.mo7069a(this.f11030g);
                    this.f11027d = null;
                }
                dismiss();
                break;
        }
    }
}
