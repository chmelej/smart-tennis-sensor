package p000;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: lr */
/* JADX INFO: compiled from: AndroidAdjustResizeBugFix.java */
/* JADX INFO: loaded from: classes.dex */
public class C1888lr {

    /* JADX INFO: renamed from: a */
    private View f11432a;

    /* JADX INFO: renamed from: b */
    private int f11433b;

    /* JADX INFO: renamed from: c */
    private int f11434c = m10436c();

    /* JADX INFO: renamed from: d */
    private FrameLayout.LayoutParams f11435d;

    /* JADX INFO: renamed from: e */
    private Activity f11436e;

    /* JADX INFO: renamed from: f */
    private a f11437f;

    /* JADX INFO: renamed from: lr$a */
    /* JADX INFO: compiled from: AndroidAdjustResizeBugFix.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7084a();

        /* JADX INFO: renamed from: b */
        void mo7085b();
    }

    private C1888lr(Activity activity, a aVar) {
        this.f11436e = activity;
        this.f11432a = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f11432a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: lr.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                C1888lr.this.m10432a();
            }
        });
        this.f11435d = (FrameLayout.LayoutParams) this.f11432a.getLayoutParams();
        this.f11437f = aVar;
    }

    /* JADX INFO: renamed from: a */
    public static void m10433a(Activity activity, a aVar) {
        new C1888lr(activity, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10432a() {
        int iM10435b = m10435b();
        if (iM10435b != this.f11433b) {
            int height = this.f11432a.getRootView().getHeight();
            if (height - iM10435b > height / 4) {
                this.f11435d.height = height - 1;
                if (this.f11437f != null) {
                    this.f11437f.mo7085b();
                }
            } else {
                this.f11435d.height = height;
                this.f11437f.mo7084a();
            }
            this.f11432a.requestLayout();
            this.f11433b = iM10435b;
        }
    }

    /* JADX INFO: renamed from: b */
    private int m10435b() {
        Rect rect = new Rect();
        this.f11432a.getWindowVisibleDisplayFrame(rect);
        return (rect.bottom - rect.top) + this.f11434c;
    }

    /* JADX INFO: renamed from: c */
    private int m10436c() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return this.f11436e.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
