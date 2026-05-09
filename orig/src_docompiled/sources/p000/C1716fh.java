package p000;

import android.content.Context;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: renamed from: fh */
/* JADX INFO: compiled from: MenuWrapperFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1716fh {
    /* JADX INFO: renamed from: a */
    public static Menu m9164a(Context context, SupportMenu supportMenu) {
        return new MenuC1717fi(context, supportMenu);
    }

    /* JADX INFO: renamed from: a */
    public static MenuItem m9165a(Context context, SupportMenuItem supportMenuItem) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new C1711fc(context, supportMenuItem);
        }
        return new MenuItemC1710fb(context, supportMenuItem);
    }

    /* JADX INFO: renamed from: a */
    public static SubMenu m9166a(Context context, SupportSubMenu supportSubMenu) {
        return new SubMenuC1720fl(context, supportSubMenu);
    }
}
