package p000;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: na */
/* JADX INFO: compiled from: SportDataDeleteLoadingWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1929na {

    /* JADX INFO: renamed from: a */
    private Activity f11700a;

    /* JADX INFO: renamed from: b */
    private PopupWindow f11701b;

    /* JADX INFO: renamed from: c */
    private TextView f11702c;

    public C1929na(Activity activity) {
        this.f11700a = activity;
        m10713d();
    }

    /* JADX INFO: renamed from: d */
    private void m10713d() {
        View viewM10555a = C1914mm.m10555a(R.layout.layout_pop_delete_sport);
        this.f11701b = new PopupWindow(viewM10555a, -1, -1);
        this.f11701b.setBackgroundDrawable(new BitmapDrawable());
        this.f11701b.setTouchable(true);
        this.f11702c = (TextView) viewM10555a.findViewById(R.id.tv_load_content);
    }

    /* JADX INFO: renamed from: a */
    public void m10714a() {
        if (this.f11701b.isShowing()) {
            this.f11701b.dismiss();
        }
        this.f11701b.showAtLocation(this.f11700a.getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m10715b() {
        if (this.f11701b.isShowing()) {
            this.f11702c.setText(C1914mm.m10557b(R.string.delete_success));
            this.f11702c.setTextColor(C1914mm.m10559d(R.color.text_menu_checked));
            new Handler().postDelayed(new Runnable() { // from class: na.1
                @Override // java.lang.Runnable
                public void run() {
                    C1929na.this.f11701b.dismiss();
                }
            }, 500L);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10716c() {
        if (this.f11701b.isShowing()) {
            this.f11702c.setText(C1914mm.m10557b(R.string.delete_failed));
            this.f11702c.setTextColor(C1914mm.m10559d(R.color.text_menu_checked));
            new Handler().postDelayed(new Runnable() { // from class: na.2
                @Override // java.lang.Runnable
                public void run() {
                    C1929na.this.f11701b.dismiss();
                }
            }, 500L);
        }
    }
}
