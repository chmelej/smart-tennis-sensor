package p000;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.MyEquipBean;
import com.coollang.tennis.widget.CircleImageView;
import java.util.Calendar;

/* JADX INFO: renamed from: lp */
/* JADX INFO: compiled from: PersonEquipManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1886lp implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private String f11390A;

    /* JADX INFO: renamed from: B */
    private String f11391B;

    /* JADX INFO: renamed from: C */
    private String f11392C;

    /* JADX INFO: renamed from: D */
    private String f11393D;

    /* JADX INFO: renamed from: E */
    private String f11394E;

    /* JADX INFO: renamed from: F */
    private String f11395F;

    /* JADX INFO: renamed from: G */
    private String f11396G;

    /* JADX INFO: renamed from: H */
    private String f11397H;

    /* JADX INFO: renamed from: a */
    private View f11398a;

    /* JADX INFO: renamed from: b */
    private Activity f11399b;

    /* JADX INFO: renamed from: c */
    private CircleImageView f11400c;

    /* JADX INFO: renamed from: d */
    private TextView f11401d;

    /* JADX INFO: renamed from: e */
    private TextView f11402e;

    /* JADX INFO: renamed from: f */
    private TextView f11403f;

    /* JADX INFO: renamed from: g */
    private TextView f11404g;

    /* JADX INFO: renamed from: h */
    private View f11405h;

    /* JADX INFO: renamed from: i */
    private View f11406i;

    /* JADX INFO: renamed from: j */
    private CircleImageView f11407j;

    /* JADX INFO: renamed from: k */
    private TextView f11408k;

    /* JADX INFO: renamed from: l */
    private TextView f11409l;

    /* JADX INFO: renamed from: m */
    private TextView f11410m;

    /* JADX INFO: renamed from: n */
    private a f11411n;

    /* JADX INFO: renamed from: o */
    private a f11412o;

    /* JADX INFO: renamed from: p */
    private LinearLayout f11413p;

    /* JADX INFO: renamed from: q */
    private LinearLayout f11414q;

    /* JADX INFO: renamed from: r */
    private String f11415r;

    /* JADX INFO: renamed from: s */
    private String f11416s;

    /* JADX INFO: renamed from: t */
    private String f11417t;

    /* JADX INFO: renamed from: u */
    private String f11418u;

    /* JADX INFO: renamed from: v */
    private String f11419v;

    /* JADX INFO: renamed from: w */
    private String f11420w;

    /* JADX INFO: renamed from: x */
    private String f11421x;

    /* JADX INFO: renamed from: y */
    private String f11422y;

    /* JADX INFO: renamed from: z */
    private String f11423z;

    public ViewOnClickListenerC1886lp(View view, Activity activity) {
        this.f11398a = view;
        this.f11399b = activity;
        m10392c();
        m10393d();
        m10394e();
    }

    /* JADX INFO: renamed from: c */
    private void m10392c() {
        this.f11400c = (CircleImageView) this.f11398a.findViewById(R.id.imgv_person_rocket);
        this.f11401d = (TextView) this.f11398a.findViewById(R.id.not_set_racket);
        this.f11402e = (TextView) this.f11398a.findViewById(R.id.tv_equip_factory);
        this.f11403f = (TextView) this.f11398a.findViewById(R.id.tv_type_equip);
        this.f11404g = (TextView) this.f11398a.findViewById(R.id.tv_type_equip_age);
        this.f11405h = this.f11398a.findViewById(R.id.rl_person_equip_hor_line);
        this.f11406i = this.f11398a.findViewById(R.id.rl_person_equip_vertical_line);
        this.f11407j = (CircleImageView) this.f11398a.findViewById(R.id.img_person_shoes);
        this.f11408k = (TextView) this.f11398a.findViewById(R.id.tv_equip_shoes_factory);
        this.f11409l = (TextView) this.f11398a.findViewById(R.id.tv_type_shoes_equip_age);
        this.f11410m = (TextView) this.f11398a.findViewById(R.id.not_set_shoes);
        this.f11413p = (LinearLayout) this.f11398a.findViewById(R.id.ll_racket_data);
        this.f11414q = (LinearLayout) this.f11398a.findViewById(R.id.ll_shoes_data);
    }

    /* JADX INFO: renamed from: d */
    private void m10393d() {
        this.f11411n = new a(this.f11405h);
        this.f11411n.m10406a(false);
        this.f11412o = new a(this.f11406i);
        this.f11412o.m10406a(false);
        m10390a(false);
        m10391b(false);
        this.f11400c.setOnClickListener(this);
        this.f11407j.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: e */
    private void m10394e() {
        this.f11415r = "";
        this.f11416s = "";
        this.f11417t = "";
        this.f11418u = "";
        this.f11419v = "";
        this.f11420w = "";
        this.f11421x = "";
        this.f11422y = "";
        this.f11423z = "";
        this.f11390A = "";
        this.f11391B = "";
        this.f11392C = "";
        this.f11393D = "";
        this.f11394E = "";
        this.f11395F = "";
    }

    /* JADX INFO: renamed from: a */
    public void m10399a(MyEquipBean myEquipBean) {
        m10394e();
        this.f11396G = myEquipBean.errDesc.ShoesUrl;
        if (myEquipBean.errDesc.ShoesUrl != null && !myEquipBean.errDesc.ShoesUrl.isEmpty()) {
            C2068qy.m11356a().m11360a(myEquipBean.errDesc.ShoesUrl, this.f11407j);
        }
        this.f11397H = myEquipBean.errDesc.RacketUrl;
        if (myEquipBean.errDesc.RacketUrl != null && !myEquipBean.errDesc.RacketUrl.isEmpty()) {
            C2068qy.m11356a().m11360a(myEquipBean.errDesc.RacketUrl, this.f11400c);
        }
        String[] strArrSplit = myEquipBean.errDesc.Brand.split(",");
        if (strArrSplit != null && strArrSplit.length != 0) {
            this.f11415r = strArrSplit[0];
            if (strArrSplit.length == 2) {
                this.f11416s = strArrSplit[1];
            }
        }
        if (myEquipBean.errDesc.BuyTime.contains("-")) {
            String[] strArrSplit2 = myEquipBean.errDesc.BuyTime.split("-");
            this.f11417t = strArrSplit2[0];
            if (strArrSplit2.length == 2) {
                this.f11418u = strArrSplit2[1];
            }
        }
        String[] strArrSplit3 = myEquipBean.errDesc.Line.split(",");
        for (int i = 0; i < strArrSplit3.length; i++) {
            switch (i) {
                case 0:
                    this.f11421x = strArrSplit3[0];
                    break;
                case 1:
                    this.f11422y = strArrSplit3[1];
                    break;
                case 2:
                    this.f11423z = strArrSplit3[2];
                    break;
                case 3:
                    this.f11390A = strArrSplit3[3];
                    break;
            }
        }
        String[] strArrSplit4 = myEquipBean.errDesc.VerticalLine.split(",");
        for (int i2 = 0; i2 < strArrSplit4.length; i2++) {
            switch (i2) {
                case 0:
                    this.f11391B = strArrSplit4[0];
                    break;
                case 1:
                    this.f11392C = strArrSplit4[1];
                    break;
                case 2:
                    this.f11393D = strArrSplit4[2];
                    break;
                case 3:
                    this.f11394E = strArrSplit4[3];
                    break;
            }
        }
        if (myEquipBean.errDesc.ShoesBuyTime.contains("-")) {
            String[] strArrSplit5 = myEquipBean.errDesc.ShoesBuyTime.split("-");
            this.f11419v = strArrSplit5[0];
            if (strArrSplit5.length > 1) {
                this.f11420w = strArrSplit5[1];
            }
        }
        this.f11395F = myEquipBean.errDesc.ShoesName;
        m10395f();
    }

    /* JADX INFO: renamed from: f */
    private void m10395f() {
        if (this.f11415r.isEmpty() && this.f11416s.isEmpty() && (this.f11417t.isEmpty() || this.f11418u.isEmpty())) {
            m10390a(false);
        } else {
            m10390a(true);
        }
        this.f11402e.setText(this.f11415r);
        this.f11403f.setText(this.f11416s);
        if (this.f11417t.isEmpty() || this.f11418u.isEmpty()) {
            this.f11404g.setVisibility(8);
        } else {
            this.f11404g.setVisibility(0);
            this.f11404g.setText(String.format(this.f11399b.getString(R.string.racket_age), m10389a(this.f11417t, this.f11418u)));
        }
        m10396g();
        m10397h();
        if (this.f11395F.isEmpty() && (this.f11419v.isEmpty() || this.f11420w.isEmpty())) {
            m10391b(false);
        } else {
            m10391b(true);
        }
        this.f11408k.setText(this.f11395F);
        if (this.f11419v.isEmpty() || this.f11420w.isEmpty()) {
            this.f11409l.setVisibility(8);
        } else {
            this.f11409l.setText(String.format(this.f11399b.getString(R.string.shoes_age), m10389a(this.f11419v, this.f11420w)));
        }
    }

    /* JADX INFO: renamed from: a */
    private String m10389a(String str, String str2) {
        int i = Integer.parseInt(str);
        int i2 = Integer.parseInt(str2);
        int i3 = Calendar.getInstance().get(1);
        int i4 = Calendar.getInstance().get(2) + 1;
        return (i >= i3 || i2 > i4) ? i < i3 ? String.format(this.f11399b.getString(R.string.equip_buy_month_unit), Integer.valueOf((12 - i2) + i4)) : i2 == i4 ? String.format(this.f11399b.getString(R.string.equip_buy_month_unit), 1) : String.format(this.f11399b.getString(R.string.equip_buy_month_unit), Integer.valueOf(i4 - i2)) : String.format(this.f11399b.getString(R.string.equip_buy_year_unit), Integer.valueOf(i3 - i));
    }

    /* JADX INFO: renamed from: g */
    private void m10396g() {
        if (this.f11421x.isEmpty() && this.f11422y.isEmpty() && this.f11423z.isEmpty() && this.f11422y.isEmpty()) {
            this.f11411n.m10406a(false);
            return;
        }
        this.f11411n.m10406a(true);
        this.f11411n.f11429f.setText(this.f11421x);
        this.f11411n.f11426c.setText(this.f11422y);
        this.f11411n.f11427d.setText(this.f11423z);
        this.f11411n.f11428e.setText(this.f11390A);
        if (this.f11421x.isEmpty()) {
            this.f11411n.f11429f.setVisibility(8);
        } else {
            this.f11411n.f11429f.setVisibility(0);
        }
        if (this.f11422y.isEmpty()) {
            this.f11411n.f11426c.setVisibility(8);
        } else {
            this.f11411n.f11426c.setVisibility(0);
        }
        if (this.f11423z.isEmpty()) {
            this.f11411n.f11427d.setVisibility(8);
        } else {
            this.f11411n.f11427d.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m10397h() {
        this.f11412o.f11425b.setText(R.string.ver_line);
        if (this.f11391B.isEmpty() && this.f11392C.isEmpty() && this.f11393D.isEmpty() && this.f11394E.isEmpty()) {
            this.f11412o.m10406a(false);
            return;
        }
        this.f11412o.m10406a(true);
        if (this.f11391B.isEmpty()) {
            this.f11412o.f11429f.setVisibility(8);
        } else {
            this.f11412o.f11429f.setVisibility(0);
        }
        if (this.f11392C.isEmpty()) {
            this.f11412o.f11426c.setVisibility(8);
        } else {
            this.f11412o.f11426c.setVisibility(0);
        }
        if (this.f11393D.isEmpty()) {
            this.f11412o.f11427d.setVisibility(8);
        } else {
            this.f11412o.f11427d.setVisibility(0);
        }
        this.f11412o.f11429f.setText(this.f11391B);
        this.f11412o.f11426c.setText(this.f11392C);
        this.f11412o.f11427d.setText(this.f11393D);
        this.f11412o.f11428e.setText(this.f11394E);
    }

    /* JADX INFO: renamed from: a */
    private void m10390a(boolean z) {
        if (z) {
            this.f11401d.setVisibility(8);
            this.f11413p.setVisibility(0);
        } else {
            this.f11401d.setVisibility(0);
            this.f11413p.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10391b(boolean z) {
        if (z) {
            this.f11414q.setVisibility(0);
            this.f11410m.setVisibility(8);
        } else {
            this.f11414q.setVisibility(8);
            this.f11410m.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10398a() {
        this.f11400c.setImageBitmap(MyApplication.m7738a().f7400a);
    }

    /* JADX INFO: renamed from: b */
    public void m10400b() {
        this.f11407j.setImageBitmap(MyApplication.m7738a().f7400a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id != R.id.img_person_shoes) {
            if (id != R.id.imgv_person_rocket || this.f11397H == null || this.f11397H.isEmpty()) {
                return;
            }
            C1887lq.m10426d(this.f11399b, this.f11397H);
            return;
        }
        if (this.f11396G == null || this.f11396G.isEmpty()) {
            return;
        }
        C1887lq.m10426d(this.f11399b, this.f11396G);
    }

    /* JADX INFO: renamed from: lp$a */
    /* JADX INFO: compiled from: PersonEquipManager.java */
    class a {

        /* JADX INFO: renamed from: b */
        private TextView f11425b;

        /* JADX INFO: renamed from: c */
        private TextView f11426c;

        /* JADX INFO: renamed from: d */
        private TextView f11427d;

        /* JADX INFO: renamed from: e */
        private TextView f11428e;

        /* JADX INFO: renamed from: f */
        private TextView f11429f;

        /* JADX INFO: renamed from: g */
        private TextView f11430g;

        /* JADX INFO: renamed from: h */
        private LinearLayout f11431h;

        public a(View view) {
            this.f11425b = (TextView) view.findViewById(R.id.tv_line_orientation);
            this.f11426c = (TextView) view.findViewById(R.id.tv_line_type);
            this.f11427d = (TextView) view.findViewById(R.id.tv_line_width);
            this.f11428e = (TextView) view.findViewById(R.id.tv_line_pound);
            this.f11429f = (TextView) view.findViewById(R.id.tv_line_name);
            this.f11430g = (TextView) view.findViewById(R.id.not_set_line);
            this.f11431h = (LinearLayout) view.findViewById(R.id.ll_has_equip_data);
        }

        /* JADX INFO: renamed from: a */
        public void m10406a(boolean z) {
            if (z) {
                this.f11431h.setVisibility(0);
                this.f11430g.setVisibility(8);
            } else {
                this.f11431h.setVisibility(8);
                this.f11430g.setVisibility(0);
            }
        }
    }
}
