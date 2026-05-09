package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements InterfaceC1715fg {
    @Override // p000.InterfaceC1715fg
    /* JADX INFO: renamed from: a */
    public void mo2430a(MenuBuilder menuBuilder) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
