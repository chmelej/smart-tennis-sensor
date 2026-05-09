package p000;

import android.support.transition.R;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: cs */
/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class C1644cs {

    /* JADX INFO: renamed from: a */
    private ViewGroup f9328a;

    /* JADX INFO: renamed from: b */
    private Runnable f9329b;

    /* JADX INFO: renamed from: a */
    public void m8815a() {
        if (m8813a(this.f9328a) != this || this.f9329b == null) {
            return;
        }
        this.f9329b.run();
    }

    /* JADX INFO: renamed from: a */
    static void m8814a(View view, C1644cs c1644cs) {
        view.setTag(R.id.transition_current_scene, c1644cs);
    }

    /* JADX INFO: renamed from: a */
    static C1644cs m8813a(View view) {
        return (C1644cs) view.getTag(R.id.transition_current_scene);
    }
}
