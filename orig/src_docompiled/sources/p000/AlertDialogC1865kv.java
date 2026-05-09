package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: renamed from: kv */
/* JADX INFO: compiled from: RollSelectorDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialogC1865kv extends AlertDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private List<String> f10980A;

    /* JADX INFO: renamed from: a */
    private LoopView f10981a;

    /* JADX INFO: renamed from: b */
    private Button f10982b;

    /* JADX INFO: renamed from: c */
    private Button f10983c;

    /* JADX INFO: renamed from: d */
    private String f10984d;

    /* JADX INFO: renamed from: e */
    private String f10985e;

    /* JADX INFO: renamed from: f */
    private String f10986f;

    /* JADX INFO: renamed from: g */
    private String f10987g;

    /* JADX INFO: renamed from: h */
    private TextView f10988h;

    /* JADX INFO: renamed from: i */
    private a f10989i;

    /* JADX INFO: renamed from: j */
    private int f10990j;

    /* JADX INFO: renamed from: k */
    private RelativeLayout f10991k;

    /* JADX INFO: renamed from: l */
    private RelativeLayout f10992l;

    /* JADX INFO: renamed from: m */
    private LoopView f10993m;

    /* JADX INFO: renamed from: n */
    private LoopView f10994n;

    /* JADX INFO: renamed from: o */
    private LoopView f10995o;

    /* JADX INFO: renamed from: p */
    private TextView f10996p;

    /* JADX INFO: renamed from: q */
    private Context f10997q;

    /* JADX INFO: renamed from: r */
    private int f10998r;

    /* JADX INFO: renamed from: s */
    private int f10999s;

    /* JADX INFO: renamed from: t */
    private int f11000t;

    /* JADX INFO: renamed from: u */
    private int f11001u;

    /* JADX INFO: renamed from: v */
    private int f11002v;

    /* JADX INFO: renamed from: w */
    private int f11003w;

    /* JADX INFO: renamed from: x */
    private List<String> f11004x;

    /* JADX INFO: renamed from: y */
    private List<String> f11005y;

    /* JADX INFO: renamed from: z */
    private List<String> f11006z;

    /* JADX INFO: renamed from: kv$a */
    /* JADX INFO: compiled from: RollSelectorDialog.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7026a(String str, String str2, String str3);
    }

    public AlertDialogC1865kv(Context context, int i, a aVar, String str, String str2, String str3) {
        super(context, R.style.CommonDialog);
        this.f10998r = -1;
        this.f10999s = -1;
        this.f11000t = -1;
        this.f10989i = aVar;
        this.f10990j = i;
        this.f10997q = context;
        this.f10985e = str;
        this.f10986f = str2;
        this.f10987g = str3;
        this.f10984d = str;
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split("-");
        this.f11001u = Integer.parseInt(strArrSplit[0]);
        this.f11002v = Integer.parseInt(strArrSplit[1]);
        this.f11003w = Integer.parseInt(strArrSplit[2]);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_roll_selector);
        m10149d();
        m10147c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10141a() {
        int i = 1;
        if (Integer.parseInt(this.f10985e) == this.f11001u && Integer.parseInt(this.f10986f) == this.f11002v) {
            this.f11006z.clear();
            while (i <= this.f11003w) {
                this.f11006z.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f10987g)) {
                    this.f11000t = i - 1;
                }
                i++;
            }
            return;
        }
        if (Integer.parseInt(this.f10986f) == 2) {
            if (Integer.parseInt(this.f10985e) % 400 == 0 || (Integer.parseInt(this.f10985e) % 100 != 0 && Integer.parseInt(this.f10985e) % 4 == 0)) {
                this.f11006z.clear();
                while (i <= 29) {
                    this.f11006z.add(String.valueOf(i));
                    if (i == Integer.parseInt(this.f10987g)) {
                        this.f11000t = i - 1;
                    }
                    i++;
                }
                return;
            }
            this.f11006z.clear();
            while (i <= 28) {
                this.f11006z.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f10987g)) {
                    this.f11000t = i - 1;
                }
                i++;
            }
            return;
        }
        if (Integer.parseInt(this.f10986f) == 4 || Integer.parseInt(this.f10986f) == 6 || Integer.parseInt(this.f10986f) == 9 || Integer.parseInt(this.f10986f) == 11) {
            this.f11006z.clear();
            while (i <= 30) {
                this.f11006z.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f10987g)) {
                    this.f11000t = i - 1;
                }
                i++;
            }
            return;
        }
        this.f11006z.clear();
        while (i <= 31) {
            this.f11006z.add(String.valueOf(i));
            if (i == Integer.parseInt(this.f10987g)) {
                this.f11000t = i - 1;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10144b() {
        int i = 1;
        if (Integer.parseInt(this.f10985e) == this.f11001u) {
            this.f10999s = 0;
            this.f11005y.clear();
            while (i <= this.f11002v) {
                this.f11005y.add(String.valueOf(i));
                i++;
            }
            return;
        }
        this.f11005y.clear();
        while (i < 13) {
            this.f11005y.add(String.valueOf(i));
            if (i == Integer.parseInt(this.f10986f)) {
                this.f10999s = i - 1;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m10147c() {
        if (this.f10990j == 2) {
            this.f11004x = new ArrayList();
            this.f11005y = new ArrayList();
            this.f11006z = new ArrayList();
            for (int i = 1900; i <= this.f11001u; i++) {
                this.f11004x.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f10985e)) {
                    this.f10998r = i - 1900;
                }
            }
            m10144b();
            m10141a();
            this.f10993m.setArrayList(this.f11004x);
            this.f10994n.setArrayList(this.f11005y);
            this.f10995o.setArrayList(this.f11006z);
            if (this.f10998r != -1) {
                this.f10993m.setCurrentItem(this.f10998r);
            }
            if (this.f10999s != -1) {
                this.f10994n.setCurrentItem(this.f10999s);
            }
            if (this.f11000t != -1) {
                this.f10995o.setCurrentItem(this.f11000t);
            }
            this.f10993m.setNotLoop();
            this.f10994n.setNotLoop();
            this.f10995o.setNotLoop();
            this.f10993m.setListener(new InterfaceC1792ic() { // from class: kv.1
                @Override // p000.InterfaceC1792ic
                /* JADX INFO: renamed from: a */
                public void mo7111a(int i2) {
                    AlertDialogC1865kv.this.f10985e = (String) AlertDialogC1865kv.this.f11004x.get(i2);
                    if (Integer.parseInt(AlertDialogC1865kv.this.f10985e) == AlertDialogC1865kv.this.f11001u) {
                        AlertDialogC1865kv.this.m10144b();
                        AlertDialogC1865kv.this.f10994n.setArrayList(AlertDialogC1865kv.this.f11005y);
                        AlertDialogC1865kv.this.f10994n.setCurrentItem(0);
                        AlertDialogC1865kv.this.f10994n.invalidate();
                    } else {
                        AlertDialogC1865kv.this.m10144b();
                        AlertDialogC1865kv.this.f10994n.setArrayList(AlertDialogC1865kv.this.f11005y);
                        AlertDialogC1865kv.this.f10994n.invalidate();
                    }
                    AlertDialogC1865kv.this.m10141a();
                    AlertDialogC1865kv.this.f10995o.setArrayList(AlertDialogC1865kv.this.f11006z);
                    AlertDialogC1865kv.this.f10995o.setCurrentItem(0);
                    AlertDialogC1865kv.this.f10995o.invalidate();
                }
            });
            this.f10994n.setListener(new InterfaceC1792ic() { // from class: kv.2
                @Override // p000.InterfaceC1792ic
                /* JADX INFO: renamed from: a */
                public void mo7111a(int i2) {
                    AlertDialogC1865kv.this.f10986f = (String) AlertDialogC1865kv.this.f11005y.get(i2);
                    AlertDialogC1865kv.this.m10141a();
                    AlertDialogC1865kv.this.f10995o.setArrayList(AlertDialogC1865kv.this.f11006z);
                    AlertDialogC1865kv.this.f10995o.setCurrentItem(0);
                    AlertDialogC1865kv.this.f10995o.invalidate();
                }
            });
            this.f10995o.setListener(new InterfaceC1792ic() { // from class: kv.3
                @Override // p000.InterfaceC1792ic
                /* JADX INFO: renamed from: a */
                public void mo7111a(int i2) {
                    AlertDialogC1865kv.this.f10987g = (String) AlertDialogC1865kv.this.f11006z.get(i2);
                }
            });
            return;
        }
        this.f10980A = new ArrayList();
        for (int i2 = 0; i2 < 300; i2++) {
            this.f10980A.add(String.valueOf(i2));
            if (this.f10985e.equals(String.valueOf(i2))) {
                this.f10998r = i2;
            }
        }
        this.f10981a.setArrayList(this.f10980A);
        if (this.f10998r != -1) {
            this.f10981a.setCurrentItem(this.f10998r);
        }
        this.f10981a.setListener(new InterfaceC1792ic() { // from class: kv.4
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i3) {
                AlertDialogC1865kv.this.f10984d = (String) AlertDialogC1865kv.this.f10980A.get(i3);
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private void m10149d() {
        this.f10992l = (RelativeLayout) findViewById(R.id.rl_wh);
        this.f10981a = (LoopView) findViewById(R.id.picklerview);
        this.f10982b = (Button) findViewById(R.id.btn_cancle);
        this.f10983c = (Button) findViewById(R.id.btn_confirm);
        this.f10988h = (TextView) findViewById(R.id.tv_unit);
        this.f10991k = (RelativeLayout) findViewById(R.id.rl_birthday);
        this.f10993m = (LoopView) findViewById(R.id.pv_year);
        this.f10994n = (LoopView) findViewById(R.id.pv_month);
        this.f10995o = (LoopView) findViewById(R.id.pv_day);
        this.f10996p = (TextView) findViewById(R.id.tv_title);
        if (this.f10990j == 0) {
            this.f10988h.setText("cm");
            this.f10992l.setVisibility(0);
            this.f10991k.setVisibility(8);
            this.f10996p.setText(this.f10997q.getString(R.string.rollselector1));
        } else if (this.f10990j == 1) {
            this.f10988h.setText("kg");
            this.f10992l.setVisibility(0);
            this.f10991k.setVisibility(8);
            this.f10996p.setText(this.f10997q.getString(R.string.rollselector2));
        } else if (this.f10990j == 3) {
            this.f10988h.setText(C1914mm.m10557b(R.string.year_unit));
            this.f10992l.setVisibility(0);
            this.f10991k.setVisibility(8);
            this.f10996p.setText(this.f10997q.getString(R.string.rollselector4));
        } else {
            this.f10996p.setText(this.f10997q.getString(R.string.rollselector3));
            this.f10992l.setVisibility(8);
            this.f10991k.setVisibility(0);
        }
        this.f10982b.setOnClickListener(this);
        this.f10983c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle /* 2131296450 */:
                dismiss();
                break;
            case R.id.btn_confirm /* 2131296451 */:
                if (this.f10990j == 2) {
                    this.f10989i.mo7026a(this.f10985e, this.f10986f, this.f10987g);
                } else {
                    this.f10989i.mo7026a(this.f10984d, "", "");
                }
                dismiss();
                break;
        }
    }
}
