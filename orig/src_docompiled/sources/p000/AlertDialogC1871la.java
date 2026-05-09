package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: la */
/* JADX INFO: compiled from: SelelctBrandDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1871la extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    int f11048a;

    /* JADX INFO: renamed from: b */
    private Button f11049b;

    /* JADX INFO: renamed from: c */
    private Button f11050c;

    /* JADX INFO: renamed from: d */
    private a f11051d;

    /* JADX INFO: renamed from: e */
    private LoopView f11052e;

    /* JADX INFO: renamed from: f */
    private String f11053f;

    /* JADX INFO: renamed from: g */
    private String f11054g;

    /* JADX INFO: renamed from: h */
    private List<String> f11055h;

    /* JADX INFO: renamed from: i */
    private String[] f11056i;

    /* JADX INFO: renamed from: j */
    private String[] f11057j;

    /* JADX INFO: renamed from: la$a */
    /* JADX INFO: compiled from: SelelctBrandDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7023a(String str);
    }

    public AlertDialogC1871la(Context context, String str, a aVar) {
        super(context, R.style.CommonDialog);
        this.f11056i = new String[]{"奥立弗", "百保力", "波力", "川崎", "邓禄普", "迪卡侬", "佛雷斯", "菲舍", "海德 ", "翰文", "红双喜", "肯尼士", "麦斯卡", "强劲", "强力", "史莱辛格", "世达", "斯力克", "泰克尼", "天龙", "王子", "伟士", "沃克", "尤尼克斯", "威尔胜", "祖迪斯", "其他"};
        this.f11057j = new String[]{"OLIVER", "BABOLAT", "BONNY", "KAWASAKI", "DUNLOP", "DECATHLON", "FLEX", "FISCHER", "FISCHER", "HEAD", "HANWEN", "DHS", "PROKENNEX", "MESUCA", "QIANGJING", "QIANGLI", "SLAZENGER", "STAR", "SILLK", "TECNIFIBRE", "TELOON", "PRINCE", "WISH", "VOLKL", "YONEX", "WILSON", "JOEREX", "OTHERS"};
        this.f11048a = 0;
        this.f11051d = aVar;
        this.f11054g = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_select_brand);
        m10180b();
        m10179a();
    }

    /* JADX INFO: renamed from: a */
    private void m10179a() {
        this.f11055h = new ArrayList();
        if (this.f11054g.equals(C1914mm.m10557b(R.string.rollselector6))) {
            if (MyApplication.m7738a().m7747g()) {
                for (int i = 0; i < this.f11056i.length; i++) {
                    this.f11055h.add(this.f11056i[i]);
                }
            } else {
                for (int i2 = 0; i2 < this.f11057j.length; i2++) {
                    this.f11055h.add(this.f11057j[i2]);
                }
            }
            this.f11052e.setArrayList(this.f11055h);
            this.f11052e.setCurrentItem(0);
            this.f11053f = this.f11055h.get(0);
        } else {
            this.f11055h.add(C1914mm.m10557b(R.string.one_year));
            this.f11055h.add(C1914mm.m10557b(R.string.one2three_year));
            this.f11055h.add(C1914mm.m10557b(R.string.three_year));
            this.f11052e.setArrayList(this.f11055h);
            this.f11052e.setMinTextSize(40);
            this.f11052e.setCurrentItem(1);
            this.f11053f = this.f11055h.get(1);
        }
        this.f11052e.setNotLoop();
        this.f11052e.setListener(new InterfaceC1792ic() { // from class: la.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i3) {
                AlertDialogC1871la.this.f11053f = (String) AlertDialogC1871la.this.f11055h.get(i3);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m10180b() {
        ((TextView) findViewById(R.id.tv_title)).setText(this.f11054g);
        this.f11052e = (LoopView) findViewById(R.id.pv_brand);
        this.f11049b = (Button) findViewById(R.id.btn_cancle);
        this.f11050c = (Button) findViewById(R.id.btn_confirm);
        this.f11049b.setOnClickListener(this);
        this.f11050c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle /* 2131296450 */:
                dismiss();
                break;
            case R.id.btn_confirm /* 2131296451 */:
                if (this.f11051d != null) {
                    this.f11051d.mo7023a(this.f11053f);
                    this.f11051d = null;
                }
                dismiss();
                break;
        }
    }
}
