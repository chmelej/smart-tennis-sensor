package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.InterfaceC1714ff;

/* JADX INFO: loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {

    /* JADX INFO: renamed from: d */
    private static final int[] f3240d = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: A */
    private boolean f3241A;

    /* JADX INFO: renamed from: a */
    CharSequence f3242a;

    /* JADX INFO: renamed from: b */
    Drawable f3243b;

    /* JADX INFO: renamed from: c */
    View f3244c;

    /* JADX INFO: renamed from: e */
    private final Context f3245e;

    /* JADX INFO: renamed from: f */
    private final Resources f3246f;

    /* JADX INFO: renamed from: g */
    private boolean f3247g;

    /* JADX INFO: renamed from: h */
    private boolean f3248h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0552a f3249i;

    /* JADX INFO: renamed from: q */
    private ContextMenu.ContextMenuInfo f3257q;

    /* JADX INFO: renamed from: y */
    private MenuItemImpl f3265y;

    /* JADX INFO: renamed from: p */
    private int f3256p = 0;

    /* JADX INFO: renamed from: r */
    private boolean f3258r = false;

    /* JADX INFO: renamed from: s */
    private boolean f3259s = false;

    /* JADX INFO: renamed from: t */
    private boolean f3260t = false;

    /* JADX INFO: renamed from: u */
    private boolean f3261u = false;

    /* JADX INFO: renamed from: v */
    private boolean f3262v = false;

    /* JADX INFO: renamed from: w */
    private ArrayList<MenuItemImpl> f3263w = new ArrayList<>();

    /* JADX INFO: renamed from: x */
    private CopyOnWriteArrayList<WeakReference<InterfaceC1714ff>> f3264x = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: z */
    private boolean f3266z = false;

    /* JADX INFO: renamed from: j */
    private ArrayList<MenuItemImpl> f3250j = new ArrayList<>();

    /* JADX INFO: renamed from: k */
    private ArrayList<MenuItemImpl> f3251k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private boolean f3252l = true;

    /* JADX INFO: renamed from: m */
    private ArrayList<MenuItemImpl> f3253m = new ArrayList<>();

    /* JADX INFO: renamed from: n */
    private ArrayList<MenuItemImpl> f3254n = new ArrayList<>();

    /* JADX INFO: renamed from: o */
    private boolean f3255o = true;

    /* JADX INFO: renamed from: android.support.v7.view.menu.MenuBuilder$a */
    public interface InterfaceC0552a {
        /* JADX INFO: renamed from: a */
        void mo2621a(MenuBuilder menuBuilder);

        /* JADX INFO: renamed from: a */
        boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem);
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.MenuBuilder$b */
    public interface InterfaceC0553b {
        /* JADX INFO: renamed from: a */
        boolean mo3303a(MenuItemImpl menuItemImpl);
    }

    /* JADX INFO: renamed from: a */
    protected String mo3325a() {
        return "android:menu:actionviewstates";
    }

    /* JADX INFO: renamed from: q */
    public MenuBuilder mo3364q() {
        return this;
    }

    public MenuBuilder(Context context) {
        this.f3245e = context;
        this.f3246f = context.getResources();
        m3316e(true);
    }

    /* JADX INFO: renamed from: a */
    public MenuBuilder m3320a(int i) {
        this.f3256p = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3330a(InterfaceC1714ff interfaceC1714ff) {
        m3331a(interfaceC1714ff, this.f3245e);
    }

    /* JADX INFO: renamed from: a */
    public void m3331a(InterfaceC1714ff interfaceC1714ff, Context context) {
        this.f3264x.add(new WeakReference<>(interfaceC1714ff));
        interfaceC1714ff.mo2436a(context, this);
        this.f3255o = true;
    }

    /* JADX INFO: renamed from: b */
    public void m3339b(InterfaceC1714ff interfaceC1714ff) {
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff2 = weakReference.get();
            if (interfaceC1714ff2 == null || interfaceC1714ff2 == interfaceC1714ff) {
                this.f3264x.remove(weakReference);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3314d(boolean z) {
        if (this.f3264x.isEmpty()) {
            return;
        }
        m3355h();
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                interfaceC1714ff.mo2441a(z);
            }
        }
        m3356i();
    }

    /* JADX INFO: renamed from: a */
    private boolean m3313a(SubMenuBuilder subMenuBuilder, InterfaceC1714ff interfaceC1714ff) {
        if (this.f3264x.isEmpty()) {
            return false;
        }
        boolean zMo2444a = interfaceC1714ff != null ? interfaceC1714ff.mo2444a(subMenuBuilder) : false;
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff2 = weakReference.get();
            if (interfaceC1714ff2 == null) {
                this.f3264x.remove(weakReference);
            } else if (!zMo2444a) {
                zMo2444a = interfaceC1714ff2.mo2444a(subMenuBuilder);
            }
        }
        return zMo2444a;
    }

    /* JADX INFO: renamed from: e */
    private void m3315e(Bundle bundle) {
        Parcelable parcelableMo2448c;
        if (this.f3264x.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                int iMo2445b = interfaceC1714ff.mo2445b();
                if (iMo2445b > 0 && (parcelableMo2448c = interfaceC1714ff.mo2448c()) != null) {
                    sparseArray.put(iMo2445b, parcelableMo2448c);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    /* JADX INFO: renamed from: f */
    private void m3318f(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f3264x.isEmpty()) {
            return;
        }
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                int iMo2445b = interfaceC1714ff.mo2445b();
                if (iMo2445b > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(iMo2445b)) != null) {
                    interfaceC1714ff.mo2437a(parcelable);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3326a(Bundle bundle) {
        m3315e(bundle);
    }

    /* JADX INFO: renamed from: b */
    public void m3337b(Bundle bundle) {
        m3318f(bundle);
    }

    /* JADX INFO: renamed from: c */
    public void m3343c(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m3343c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo3325a(), sparseArray);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m3348d(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo3325a());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m3348d(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    /* JADX INFO: renamed from: a */
    public void mo3327a(InterfaceC0552a interfaceC0552a) {
        this.f3249i = interfaceC0552a;
    }

    /* JADX INFO: renamed from: a */
    protected MenuItem mo2425a(int i, int i2, int i3, CharSequence charSequence) {
        int iM3317f = m3317f(i3);
        MenuItemImpl menuItemImplM3310a = m3310a(i, i2, i3, iM3317f, charSequence, this.f3256p);
        if (this.f3257q != null) {
            menuItemImplM3310a.m3373a(this.f3257q);
        }
        this.f3250j.add(m3309a(this.f3250j, iM3317f), menuItemImplM3310a);
        mo2458a(true);
        return menuItemImplM3310a;
    }

    /* JADX INFO: renamed from: a */
    private MenuItemImpl m3310a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return mo2425a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return mo2425a(0, 0, 0, this.f3246f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo2425a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo2425a(i, i2, i3, this.f3246f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f3246f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo2425a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f3245e, this, menuItemImpl);
        menuItemImpl.m3372a(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f3246f.getString(i4));
    }

    @Override // android.support.v4.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f3266z = z;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo3341b() {
        return this.f3266z;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f3245e.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m3312a(m3336b(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM3342c = m3342c(i);
        if (iM3342c >= 0) {
            int size = this.f3250j.size() - iM3342c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f3250j.get(iM3342c).getGroupId() != i) {
                    break;
                }
                m3312a(iM3342c, false);
                i2 = i3;
            }
            mo2458a(true);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3312a(int i, boolean z) {
        if (i < 0 || i >= this.f3250j.size()) {
            return;
        }
        this.f3250j.remove(i);
        if (z) {
            mo2458a(true);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.f3265y != null) {
            mo3350d(this.f3265y);
        }
        this.f3250j.clear();
        mo2458a(true);
    }

    /* JADX INFO: renamed from: a */
    void m3329a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f3250j.size();
        m3355h();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m3385f() && menuItemImpl.isCheckable()) {
                menuItemImpl.m3378b(menuItemImpl == menuItem);
            }
        }
        m3356i();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f3250j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m3374a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f3250j.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.m3380c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            mo2458a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f3250j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f3241A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3250j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (menuItemFindItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public int m3336b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f3250j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public int m3342c(int i) {
        return m3319a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m3319a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f3250j.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3250j.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f3250j.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3324a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f3247g = z;
        mo2458a(false);
    }

    /* JADX INFO: renamed from: f */
    private static int m3317f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f3240d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & 65535) | (f3240d[i2] << 16);
    }

    /* JADX INFO: renamed from: c */
    boolean mo3345c() {
        return this.f3247g;
    }

    /* JADX INFO: renamed from: e */
    private void m3316e(boolean z) {
        this.f3248h = z && this.f3246f.getConfiguration().keyboard != 1 && ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.f3245e), this.f3245e);
    }

    /* JADX INFO: renamed from: d */
    public boolean mo3349d() {
        return this.f3248h;
    }

    /* JADX INFO: renamed from: e */
    Resources m3351e() {
        return this.f3246f;
    }

    /* JADX INFO: renamed from: f */
    public Context m3353f() {
        return this.f3245e;
    }

    /* JADX INFO: renamed from: a */
    boolean mo3333a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f3249i != null && this.f3249i.mo2622a(menuBuilder, menuItem);
    }

    /* JADX INFO: renamed from: g */
    public void m3354g() {
        if (this.f3249i != null) {
            this.f3249i.mo2621a(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m3309a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m3376b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl menuItemImplM3324a = m3324a(i, keyEvent);
        boolean zM3334a = menuItemImplM3324a != null ? m3334a(menuItemImplM3324a, i2) : false;
        if ((i2 & 2) != 0) {
            m3340b(true);
        }
        return zM3334a;
    }

    /* JADX INFO: renamed from: a */
    void m3332a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean zMo3345c = mo3345c();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f3250j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f3250j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m3332a(list, i, keyEvent);
                }
                char alphabeticShortcut = zMo3345c ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((zMo3345c ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zMo3345c && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    MenuItemImpl m3324a(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.f3263w;
        arrayList.clear();
        m3332a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zMo3345c = mo3345c();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            if (zMo3345c) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zMo3345c && numericShortcut == '\b' && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m3334a(findItem(i), i2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3334a(MenuItem menuItem, int i) {
        return m3335a(menuItem, (InterfaceC1714ff) null, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3335a(MenuItem menuItem, InterfaceC1714ff interfaceC1714ff, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean zM3375a = menuItemImpl.m3375a();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.m3392m()) {
            zM3375a |= menuItemImpl.expandActionView();
            if (zM3375a) {
                m3340b(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m3340b(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m3372a(new SubMenuBuilder(m3353f(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            zM3375a |= m3313a(subMenuBuilder, interfaceC1714ff);
            if (!zM3375a) {
                m3340b(true);
            }
        } else if ((i & 1) == 0) {
            m3340b(true);
        }
        return zM3375a;
    }

    /* JADX INFO: renamed from: b */
    public final void m3340b(boolean z) {
        if (this.f3262v) {
            return;
        }
        this.f3262v = true;
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                interfaceC1714ff.mo2439a(this, z);
            }
        }
        this.f3262v = false;
    }

    @Override // android.view.Menu
    public void close() {
        m3340b(true);
    }

    /* JADX INFO: renamed from: a */
    public void mo2458a(boolean z) {
        if (!this.f3258r) {
            if (z) {
                this.f3252l = true;
                this.f3255o = true;
            }
            m3314d(z);
            return;
        }
        this.f3259s = true;
        if (z) {
            this.f3260t = true;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m3355h() {
        if (this.f3258r) {
            return;
        }
        this.f3258r = true;
        this.f3259s = false;
        this.f3260t = false;
    }

    /* JADX INFO: renamed from: i */
    public void m3356i() {
        this.f3258r = false;
        if (this.f3259s) {
            this.f3259s = false;
            mo2458a(this.f3260t);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3328a(MenuItemImpl menuItemImpl) {
        this.f3252l = true;
        mo2458a(true);
    }

    /* JADX INFO: renamed from: b */
    void m3338b(MenuItemImpl menuItemImpl) {
        this.f3255o = true;
        mo2458a(true);
    }

    /* JADX INFO: renamed from: j */
    public ArrayList<MenuItemImpl> m3357j() {
        if (!this.f3252l) {
            return this.f3251k;
        }
        this.f3251k.clear();
        int size = this.f3250j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f3250j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f3251k.add(menuItemImpl);
            }
        }
        this.f3252l = false;
        this.f3255o = true;
        return this.f3251k;
    }

    /* JADX INFO: renamed from: k */
    public void m3358k() {
        ArrayList<MenuItemImpl> arrayListM3357j = m3357j();
        if (this.f3255o) {
            boolean zMo2442a = false;
            for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
                InterfaceC1714ff interfaceC1714ff = weakReference.get();
                if (interfaceC1714ff == null) {
                    this.f3264x.remove(weakReference);
                } else {
                    zMo2442a |= interfaceC1714ff.mo2442a();
                }
            }
            if (zMo2442a) {
                this.f3253m.clear();
                this.f3254n.clear();
                int size = arrayListM3357j.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = arrayListM3357j.get(i);
                    if (menuItemImpl.m3388i()) {
                        this.f3253m.add(menuItemImpl);
                    } else {
                        this.f3254n.add(menuItemImpl);
                    }
                }
            } else {
                this.f3253m.clear();
                this.f3254n.clear();
                this.f3254n.addAll(m3357j());
            }
            this.f3255o = false;
        }
    }

    /* JADX INFO: renamed from: l */
    public ArrayList<MenuItemImpl> m3359l() {
        m3358k();
        return this.f3253m;
    }

    /* JADX INFO: renamed from: m */
    public ArrayList<MenuItemImpl> m3360m() {
        m3358k();
        return this.f3254n;
    }

    public void clearHeader() {
        this.f3243b = null;
        this.f3242a = null;
        this.f3244c = null;
        mo2458a(false);
    }

    /* JADX INFO: renamed from: a */
    private void m3311a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesM3351e = m3351e();
        if (view != null) {
            this.f3244c = view;
            this.f3242a = null;
            this.f3243b = null;
        } else {
            if (i > 0) {
                this.f3242a = resourcesM3351e.getText(i);
            } else if (charSequence != null) {
                this.f3242a = charSequence;
            }
            if (i2 > 0) {
                this.f3243b = ContextCompat.getDrawable(m3353f(), i2);
            } else if (drawable != null) {
                this.f3243b = drawable;
            }
            this.f3244c = null;
        }
        mo2458a(false);
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3323a(CharSequence charSequence) {
        m3311a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: d */
    protected MenuBuilder m3347d(int i) {
        m3311a(i, null, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3321a(Drawable drawable) {
        m3311a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: renamed from: e */
    protected MenuBuilder m3352e(int i) {
        m3311a(0, null, i, null, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3322a(View view) {
        m3311a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: renamed from: n */
    public CharSequence m3361n() {
        return this.f3242a;
    }

    /* JADX INFO: renamed from: o */
    public Drawable m3362o() {
        return this.f3243b;
    }

    /* JADX INFO: renamed from: p */
    public View m3363p() {
        return this.f3244c;
    }

    /* JADX INFO: renamed from: r */
    boolean m3365r() {
        return this.f3261u;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo3346c(MenuItemImpl menuItemImpl) {
        boolean zMo2443a = false;
        if (this.f3264x.isEmpty()) {
            return false;
        }
        m3355h();
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                zMo2443a = interfaceC1714ff.mo2443a(this, menuItemImpl);
                if (zMo2443a) {
                    break;
                }
            }
        }
        m3356i();
        if (zMo2443a) {
            this.f3265y = menuItemImpl;
        }
        return zMo2443a;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo3350d(MenuItemImpl menuItemImpl) {
        boolean zMo2447b = false;
        if (this.f3264x.isEmpty() || this.f3265y != menuItemImpl) {
            return false;
        }
        m3355h();
        for (WeakReference<InterfaceC1714ff> weakReference : this.f3264x) {
            InterfaceC1714ff interfaceC1714ff = weakReference.get();
            if (interfaceC1714ff == null) {
                this.f3264x.remove(weakReference);
            } else {
                zMo2447b = interfaceC1714ff.mo2447b(this, menuItemImpl);
                if (zMo2447b) {
                    break;
                }
            }
        }
        m3356i();
        if (zMo2447b) {
            this.f3265y = null;
        }
        return zMo2447b;
    }

    /* JADX INFO: renamed from: s */
    public MenuItemImpl m3366s() {
        return this.f3265y;
    }

    /* JADX INFO: renamed from: c */
    public void m3344c(boolean z) {
        this.f3241A = z;
    }
}
