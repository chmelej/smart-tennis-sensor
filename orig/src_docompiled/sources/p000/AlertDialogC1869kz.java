package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kz */
/* JADX INFO: compiled from: SelelctAddressDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1869kz extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    int f11034a;

    /* JADX INFO: renamed from: b */
    private Button f11035b;

    /* JADX INFO: renamed from: c */
    private Button f11036c;

    /* JADX INFO: renamed from: d */
    private a f11037d;

    /* JADX INFO: renamed from: e */
    private LoopView f11038e;

    /* JADX INFO: renamed from: f */
    private LoopView f11039f;

    /* JADX INFO: renamed from: g */
    private String f11040g;

    /* JADX INFO: renamed from: h */
    private String f11041h;

    /* JADX INFO: renamed from: i */
    private HashMap<String, Integer> f11042i;

    /* JADX INFO: renamed from: j */
    private List<String> f11043j;

    /* JADX INFO: renamed from: k */
    private List<String> f11044k;

    /* JADX INFO: renamed from: l */
    private C1854kk f11045l;

    /* JADX INFO: renamed from: kz$a */
    /* JADX INFO: compiled from: SelelctAddressDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7066a(String str, String str2);
    }

    public AlertDialogC1869kz(Context context, HashMap<String, Integer> map, List<String> list, a aVar) {
        super(context, R.style.CommonDialog);
        this.f11034a = 0;
        this.f11042i = map;
        this.f11043j = list;
        this.f11037d = aVar;
        this.f11044k = new ArrayList();
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f11044k.add(it.next().getKey());
        }
        this.f11040g = this.f11044k.get(0);
        this.f11041h = list.get(0);
        this.f11045l = new C1854kk(context);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_select_address);
        m10171b();
        m10168a();
    }

    /* JADX INFO: renamed from: a */
    private void m10168a() {
        this.f11038e.setArrayList(this.f11044k);
        this.f11039f.setArrayList(this.f11043j);
        this.f11038e.setCurrentItem(0);
        this.f11039f.setCurrentItem(0);
        this.f11038e.setNotLoop();
        this.f11039f.setNotLoop();
        this.f11038e.setListener(new InterfaceC1792ic() { // from class: kz.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                AlertDialogC1869kz.this.f11040g = (String) AlertDialogC1869kz.this.f11044k.get(i);
                AlertDialogC1869kz.this.f11034a = ((Integer) AlertDialogC1869kz.this.f11042i.get(AlertDialogC1869kz.this.f11040g)).intValue();
                if (MyApplication.m7738a().m7747g()) {
                    AlertDialogC1869kz.this.f11043j = AlertDialogC1869kz.this.f11045l.m10104a(String.valueOf(AlertDialogC1869kz.this.f11034a));
                } else {
                    AlertDialogC1869kz.this.f11043j = AlertDialogC1869kz.this.f11045l.m10106b(String.valueOf(AlertDialogC1869kz.this.f11034a));
                }
                AlertDialogC1869kz.this.f11041h = (String) AlertDialogC1869kz.this.f11043j.get(0);
                AlertDialogC1869kz.this.f11039f.setArrayList(AlertDialogC1869kz.this.f11043j);
                AlertDialogC1869kz.this.f11039f.setCurrentItem(0);
                AlertDialogC1869kz.this.f11039f.invalidate();
            }
        });
        this.f11039f.setListener(new InterfaceC1792ic() { // from class: kz.2
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                AlertDialogC1869kz.this.f11041h = (String) AlertDialogC1869kz.this.f11043j.get(i);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m10171b() {
        this.f11038e = (LoopView) findViewById(R.id.pv_province);
        this.f11039f = (LoopView) findViewById(R.id.pv_city);
        this.f11035b = (Button) findViewById(R.id.btn_cancle);
        this.f11036c = (Button) findViewById(R.id.btn_confirm);
        this.f11035b.setOnClickListener(this);
        this.f11036c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle /* 2131296450 */:
                dismiss();
                break;
            case R.id.btn_confirm /* 2131296451 */:
                if (this.f11037d != null) {
                    this.f11037d.mo7066a(this.f11040g, this.f11041h);
                    this.f11037d = null;
                }
                dismiss();
                break;
        }
    }
}
