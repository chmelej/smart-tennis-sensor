package p000;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.IndicatorDotSeekBar;
import org.litepal.crud.DataSupport;

/* JADX INFO: renamed from: mx */
/* JADX INFO: compiled from: SetTrainTargetPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1925mx {

    /* JADX INFO: renamed from: a */
    private Activity f11653a;

    /* JADX INFO: renamed from: b */
    private View f11654b;

    /* JADX INFO: renamed from: c */
    private RadioGroup f11655c;

    /* JADX INFO: renamed from: d */
    private IndicatorDotSeekBar f11656d;

    /* JADX INFO: renamed from: e */
    private IndicatorDotSeekBar f11657e;

    /* JADX INFO: renamed from: f */
    private IndicatorDotSeekBar f11658f;

    /* JADX INFO: renamed from: g */
    private IndicatorDotSeekBar f11659g;

    /* JADX INFO: renamed from: h */
    private TextView f11660h;

    /* JADX INFO: renamed from: i */
    private TextView f11661i;

    /* JADX INFO: renamed from: j */
    private int f11662j;

    /* JADX INFO: renamed from: k */
    private int f11663k;

    /* JADX INFO: renamed from: l */
    private int f11664l;

    /* JADX INFO: renamed from: m */
    private int f11665m;

    /* JADX INFO: renamed from: n */
    private int f11666n;

    /* JADX INFO: renamed from: o */
    private int f11667o;

    /* JADX INFO: renamed from: p */
    private int f11668p;

    /* JADX INFO: renamed from: q */
    private int f11669q;

    /* JADX INFO: renamed from: r */
    private a f11670r;

    /* JADX INFO: renamed from: s */
    private PopupWindow f11671s;

    /* JADX INFO: renamed from: mx$a */
    /* JADX INFO: compiled from: SetTrainTargetPopWindow.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo10330a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    /* JADX INFO: renamed from: b */
    private int m10664b(int i) {
        int i2 = (int) (((i / 2.4f) / 10.0f) * 10.0f);
        if (i2 < 20) {
            i2 = 20;
        }
        if (i2 > 300) {
            return 300;
        }
        return i2;
    }

    public C1925mx(Activity activity) {
        this.f11653a = activity;
        m10670c();
    }

    /* JADX INFO: renamed from: c */
    private void m10670c() {
        View viewInflate = LayoutInflater.from(this.f11653a).inflate(R.layout.layout_pop_set_target, (ViewGroup) new LinearLayout(this.f11653a), false);
        this.f11671s = new PopupWindow(viewInflate, -1, -1);
        this.f11671s.setOutsideTouchable(true);
        this.f11671s.setFocusable(true);
        this.f11671s.setBackgroundDrawable(new BitmapDrawable());
        m10662a(viewInflate);
        m10673d();
        m10676e();
        m10679f();
        m10682g();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: mx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1896lz.m10463a(view.getId())) {
                    return;
                }
                C1925mx.this.m10693b();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private void m10662a(View view) {
        this.f11654b = view.findViewById(R.id.ll_root_target);
        this.f11655c = (RadioGroup) view.findViewById(R.id.rg_target);
        this.f11656d = (IndicatorDotSeekBar) view.findViewById(R.id.ids_xuan);
        this.f11658f = (IndicatorDotSeekBar) view.findViewById(R.id.ids_ping_target);
        this.f11657e = (IndicatorDotSeekBar) view.findViewById(R.id.ids_xiao_target);
        this.f11659g = (IndicatorDotSeekBar) view.findViewById(R.id.ids_speed_target);
        this.f11660h = (TextView) view.findViewById(R.id.tv_target_sure);
        this.f11661i = (TextView) view.findViewById(R.id.tv_target_suggest);
    }

    /* JADX INFO: renamed from: d */
    private void m10673d() {
        this.f11656d.setColor(Color.parseColor("#f071a4"));
        this.f11658f.setColor(Color.parseColor("#a38bd6"));
        this.f11657e.setColor(Color.parseColor("#f78460"));
        this.f11659g.setColor(this.f11653a.getResources().getColor(R.color.text_menu_checked));
        this.f11656d.setMin(20);
        this.f11656d.setMax(300);
        this.f11656d.setDivider(10);
        this.f11658f.setMin(20);
        this.f11658f.setMax(300);
        this.f11658f.setDivider(10);
        this.f11657e.setMin(20);
        this.f11657e.setMax(300);
        this.f11657e.setDivider(10);
        this.f11659g.setMin(20);
        this.f11659g.setMax(140);
        this.f11659g.setDivider(5);
    }

    /* JADX INFO: renamed from: e */
    private void m10676e() {
        this.f11666n = 50;
        this.f11668p = 50;
        this.f11667o = 50;
        this.f11662j = 50;
        this.f11664l = 50;
        this.f11663k = 50;
        this.f11669q = 50;
        this.f11665m = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m10679f() {
        if (this.f11655c.getCheckedRadioButtonId() == R.id.rb_fore_hand_target) {
            this.f11656d.setProgress(this.f11662j);
            this.f11658f.setProgress(this.f11663k);
            this.f11657e.setProgress(this.f11664l);
            this.f11659g.setProgress(this.f11665m);
            return;
        }
        this.f11656d.setProgress(this.f11666n);
        this.f11658f.setProgress(this.f11667o);
        this.f11657e.setProgress(this.f11668p);
        this.f11659g.setProgress(this.f11669q);
    }

    /* JADX INFO: renamed from: g */
    private void m10682g() {
        this.f11654b.setOnClickListener(new View.OnClickListener() { // from class: mx.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.f11661i.setOnClickListener(new View.OnClickListener() { // from class: mx.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1925mx.this.m10661a(1);
            }
        });
        this.f11660h.setOnClickListener(new View.OnClickListener() { // from class: mx.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1925mx.this.f11670r != null) {
                    C1925mx.this.f11670r.mo10330a(C1925mx.this.f11662j, C1925mx.this.f11663k, C1925mx.this.f11664l, C1925mx.this.f11665m, C1925mx.this.f11666n, C1925mx.this.f11667o, C1925mx.this.f11668p, C1925mx.this.f11669q);
                }
                C1925mx.this.m10693b();
            }
        });
        this.f11655c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: mx.6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                C1925mx.this.m10679f();
            }
        });
        this.f11656d.setOnSeekbarChangedListener(new IndicatorDotSeekBar.InterfaceC1337a() { // from class: mx.7
            @Override // com.coollang.tennis.widget.IndicatorDotSeekBar.InterfaceC1337a
            /* JADX INFO: renamed from: a */
            public void mo8151a(int i) {
                C1900mc.m10474b(NotificationCompat.CATEGORY_PROGRESS, " == " + i);
                if (C1925mx.this.f11655c.getCheckedRadioButtonId() == R.id.rb_fore_hand_target) {
                    C1925mx.this.f11662j = i;
                } else {
                    C1925mx.this.f11666n = i;
                }
            }
        });
        this.f11658f.setOnSeekbarChangedListener(new IndicatorDotSeekBar.InterfaceC1337a() { // from class: mx.8
            @Override // com.coollang.tennis.widget.IndicatorDotSeekBar.InterfaceC1337a
            /* JADX INFO: renamed from: a */
            public void mo8151a(int i) {
                if (C1925mx.this.f11655c.getCheckedRadioButtonId() == R.id.rb_fore_hand_target) {
                    C1925mx.this.f11663k = i;
                } else {
                    C1925mx.this.f11667o = i;
                }
            }
        });
        this.f11657e.setOnSeekbarChangedListener(new IndicatorDotSeekBar.InterfaceC1337a() { // from class: mx.9
            @Override // com.coollang.tennis.widget.IndicatorDotSeekBar.InterfaceC1337a
            /* JADX INFO: renamed from: a */
            public void mo8151a(int i) {
                if (C1925mx.this.f11655c.getCheckedRadioButtonId() == R.id.rb_fore_hand_target) {
                    C1925mx.this.f11664l = i;
                } else {
                    C1925mx.this.f11668p = i;
                }
            }
        });
        this.f11659g.setOnSeekbarChangedListener(new IndicatorDotSeekBar.InterfaceC1337a() { // from class: mx.10
            @Override // com.coollang.tennis.widget.IndicatorDotSeekBar.InterfaceC1337a
            /* JADX INFO: renamed from: a */
            public void mo8151a(int i) {
                if (C1925mx.this.f11655c.getCheckedRadioButtonId() == R.id.rb_fore_hand_target) {
                    C1925mx.this.f11665m = i;
                } else {
                    C1925mx.this.f11669q = i;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10661a(int i) {
        if (DataSupport.where("userid = ? And endTimeStemp != 0 ", C1902me.m10480a(this.f11653a)).count(OnTimeMainTable.class) == 0) {
            m10676e();
        } else {
            int iM10110a = C1856km.m10109a().m10110a(i, Integer.parseInt(C1902me.m10480a(this.f11653a)));
            if (iM10110a == -1) {
                m10676e();
                m10679f();
                return;
            }
            this.f11665m = m10659a(String.valueOf(iM10110a));
            this.f11669q = m10665b(String.valueOf(iM10110a));
            if (this.f11665m == 0 || this.f11669q == 0) {
                m10661a(i + 1);
                return;
            }
            int foreTargetSpeed = ((OnTimeMainTable) DataSupport.where("id = ?", String.valueOf(iM10110a)).find(OnTimeMainTable.class).get(0)).getForeTargetSpeed();
            int backTargetSpeed = ((OnTimeMainTable) DataSupport.where("id = ?", String.valueOf(iM10110a)).find(OnTimeMainTable.class).get(0)).getBackTargetSpeed();
            int i2 = foreTargetSpeed - 1;
            this.f11662j = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "4", "0", String.valueOf(i2), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11662j = m10664b(this.f11662j);
            this.f11663k = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "5", "0", String.valueOf(i2), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11663k = m10664b(this.f11663k);
            this.f11664l = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "3", "0", String.valueOf(i2), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11664l = m10664b(this.f11664l);
            int i3 = backTargetSpeed - 1;
            this.f11666n = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "4", "1", String.valueOf(i3), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11666n = m10664b(this.f11666n);
            this.f11667o = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "5", "1", String.valueOf(i3), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11667o = m10664b(this.f11667o);
            this.f11668p = DataSupport.where("actionType = ? And handType = ? And hitSpeed > ? And trainId = ? ", "3", "1", String.valueOf(i3), String.valueOf(iM10110a)).count(OnTimeDetailTable.class);
            this.f11668p = m10664b(this.f11668p);
        }
        m10679f();
    }

    /* JADX INFO: renamed from: a */
    public void m10691a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f11663k = i;
        this.f11664l = i2;
        this.f11662j = i3;
        this.f11667o = i4;
        this.f11668p = i5;
        this.f11666n = i6;
        this.f11665m = i7;
        this.f11669q = i8;
        m10679f();
    }

    /* JADX INFO: renamed from: a */
    private int m10659a(String str) {
        int i = 0;
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * From OnTimeDetailTable Where handType = ? And trainId = ? ", "0", str);
        if (cursorFindBySQL.getCount() != 0) {
            while (cursorFindBySQL.moveToNext()) {
                i += cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"));
            }
            int count = (int) ((((i / cursorFindBySQL.getCount()) / 0.8f) / 5.0f) * 5.0f);
            cursorFindBySQL.close();
            int i2 = count <= 140 ? count : 140;
            if (i2 != 0 && i2 < 20) {
                return 20;
            }
            return i2;
        }
        cursorFindBySQL.close();
        return 0;
    }

    /* JADX INFO: renamed from: b */
    private int m10665b(String str) {
        int i = 0;
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * From OnTimeDetailTable Where handType = ? And trainId = ? ", "1", str);
        if (cursorFindBySQL.getCount() != 0) {
            while (cursorFindBySQL.moveToNext()) {
                i += cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"));
            }
            int count = (int) ((((i / cursorFindBySQL.getCount()) / 0.8f) / 5.0f) * 5.0f);
            if (count > 140) {
                count = 140;
            }
            if (count == 0) {
                return count;
            }
            if (count < 20) {
                count = 20;
            }
            cursorFindBySQL.close();
            return count;
        }
        cursorFindBySQL.close();
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public void m10690a() {
        if (this.f11671s.isShowing()) {
            this.f11671s.dismiss();
        }
        this.f11671s.showAtLocation(this.f11653a.getWindow().getDecorView(), 17, 0, 0);
        this.f11654b.startAnimation(AnimationUtils.loadAnimation(this.f11653a, R.anim.target_show_anim));
    }

    /* JADX INFO: renamed from: b */
    public void m10693b() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f11653a, R.anim.target_hide_anim);
        this.f11654b.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: mx.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C1925mx.this.f11671s.isShowing()) {
                    C1925mx.this.f11671s.dismiss();
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10692a(a aVar) {
        this.f11670r = aVar;
    }
}
