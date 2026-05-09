package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000.C1684ee;
import p000.C1722fn;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {

    /* JADX INFO: renamed from: a */
    final Context f3945a;

    /* JADX INFO: renamed from: b */
    String f3946b;

    /* JADX INFO: renamed from: c */
    private int f3947c;

    /* JADX INFO: renamed from: d */
    private final MenuItemOnMenuItemClickListenerC0647a f3948d;

    @Override // android.support.v4.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // android.support.v4.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f3945a);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(C1722fn.m9169a(this.f3945a, this.f3946b));
        }
        TypedValue typedValue = new TypedValue();
        this.f3945a.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(C1684ee.m8975b(this.f3945a, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // android.support.v4.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        C1722fn c1722fnM9169a = C1722fn.m9169a(this.f3945a, this.f3946b);
        PackageManager packageManager = this.f3945a.getPackageManager();
        int iM9178a = c1722fnM9169a.m9178a();
        int iMin = Math.min(iM9178a, this.f3947c);
        for (int i = 0; i < iMin; i++) {
            ResolveInfo resolveInfoM9180a = c1722fnM9169a.m9180a(i);
            subMenu.add(0, i, i, resolveInfoM9180a.loadLabel(packageManager)).setIcon(resolveInfoM9180a.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3948d);
        }
        if (iMin < iM9178a) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.f3945a.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < iM9178a; i2++) {
                ResolveInfo resolveInfoM9180a2 = c1722fnM9169a.m9180a(i2);
                subMenuAddSubMenu.add(0, i2, i2, resolveInfoM9180a2.loadLabel(packageManager)).setIcon(resolveInfoM9180a2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3948d);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ShareActionProvider$a */
    class MenuItemOnMenuItemClickListenerC0647a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ ShareActionProvider f3949a;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent intentM9181b = C1722fn.m9169a(this.f3949a.f3945a, this.f3949a.f3946b).m9181b(menuItem.getItemId());
            if (intentM9181b == null) {
                return true;
            }
            String action = intentM9181b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.f3949a.m4220a(intentM9181b);
            }
            this.f3949a.f3945a.startActivity(intentM9181b);
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4220a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
