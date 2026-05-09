package p000;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: renamed from: mu */
/* JADX INFO: compiled from: RollSelectYearPopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1922mu {

    /* JADX INFO: renamed from: a */
    private PopupWindow f11597a;

    /* JADX INFO: renamed from: b */
    private Activity f11598b;

    /* JADX INFO: renamed from: c */
    private LoopView f11599c;

    /* JADX INFO: renamed from: d */
    private List<String> f11600d;

    /* JADX INFO: renamed from: e */
    private String f11601e;

    /* JADX INFO: renamed from: f */
    private int f11602f;

    /* JADX INFO: renamed from: g */
    private int f11603g = -1;

    public C1922mu(Activity activity, String str) {
        this.f11598b = activity;
        this.f11601e = str;
        m10616b();
    }

    /* JADX INFO: renamed from: b */
    private void m10616b() {
        View viewInflate = LayoutInflater.from(this.f11598b).inflate(R.layout.pop_roll_select_year, (ViewGroup) null);
        this.f11597a = new PopupWindow(viewInflate, -1, -2);
        this.f11597a.setOutsideTouchable(true);
        this.f11597a.setFocusable(true);
        this.f11597a.setBackgroundDrawable(new BitmapDrawable());
        this.f11599c = (LoopView) viewInflate.findViewById(R.id.loop_view);
        m10617c();
    }

    /* JADX INFO: renamed from: c */
    private void m10617c() {
        this.f11600d = new ArrayList();
        this.f11602f = Calendar.getInstance().get(1);
        for (int i = 1970; i <= this.f11602f; i++) {
            this.f11600d.add(String.valueOf(i));
            if (this.f11601e.equals(String.valueOf(i))) {
                this.f11603g = i - 1970;
            }
        }
        this.f11599c.setNotLoop();
        this.f11599c.setMiddleLineVisible(false);
        this.f11599c.setArrayList(this.f11600d);
        if (this.f11603g != -1) {
            this.f11599c.setCurrentItem(this.f11603g);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10619a(InterfaceC1792ic interfaceC1792ic) {
        this.f11599c.setListener(interfaceC1792ic);
    }

    /* JADX INFO: renamed from: a */
    public void m10618a() {
        if (this.f11597a.isShowing()) {
            this.f11597a.dismiss();
        }
        this.f11597a.showAtLocation(this.f11598b.getWindow().getDecorView(), 80, 0, 0);
    }
}
