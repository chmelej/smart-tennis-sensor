package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: er */
/* JADX INFO: compiled from: SupportMenuInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class C1699er extends MenuInflater {

    /* JADX INFO: renamed from: a */
    static final Class<?>[] f9630a = {Context.class};

    /* JADX INFO: renamed from: b */
    static final Class<?>[] f9631b = f9630a;

    /* JADX INFO: renamed from: c */
    final Object[] f9632c;

    /* JADX INFO: renamed from: d */
    final Object[] f9633d;

    /* JADX INFO: renamed from: e */
    Context f9634e;

    /* JADX INFO: renamed from: f */
    private Object f9635f;

    public C1699er(Context context) {
        super(context);
        this.f9634e = context;
        this.f9632c = new Object[]{context};
        this.f9633d = this.f9632c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) throws Throwable {
        XmlResourceParser layout;
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                layout = this.f9634e.getResources().getLayout(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (XmlPullParserException e2) {
            e = e2;
        }
        try {
            m9077a(layout, Xml.asAttributeSet(layout), menu);
            if (layout != null) {
                layout.close();
            }
        } catch (IOException e3) {
            e = e3;
            throw new InflateException("Error inflating menu XML", e);
        } catch (XmlPullParserException e4) {
            e = e4;
            throw new InflateException("Error inflating menu XML", e);
        } catch (Throwable th2) {
            th = th2;
            xmlResourceParser = layout;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9077a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (next) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals("group")) {
                            bVar.m9083a(attributeSet);
                        } else if (name2.equals("item")) {
                            bVar.m9085b(attributeSet);
                        } else if (!name2.equals("menu")) {
                            str = name2;
                            z2 = true;
                        } else {
                            m9077a(xmlPullParser, attributeSet, bVar.m9086c());
                        }
                    }
                    break;
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (z2 && name3.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name3.equals("group")) {
                        bVar.m9082a();
                    } else if (name3.equals("item")) {
                        if (!bVar.m9087d()) {
                            if (bVar.f9645a != null && bVar.f9645a.hasSubMenu()) {
                                bVar.m9086c();
                            } else {
                                bVar.m9084b();
                            }
                        }
                    } else if (name3.equals("menu")) {
                        z = true;
                    }
                    break;
            }
            next = xmlPullParser.next();
        }
    }

    /* JADX INFO: renamed from: a */
    Object m9078a() {
        if (this.f9635f == null) {
            this.f9635f = m9076a(this.f9634e);
        }
        return this.f9635f;
    }

    /* JADX INFO: renamed from: a */
    private Object m9076a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m9076a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: renamed from: er$a */
    /* JADX INFO: compiled from: SupportMenuInflater.java */
    static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a */
        private static final Class<?>[] f9636a = {MenuItem.class};

        /* JADX INFO: renamed from: b */
        private Object f9637b;

        /* JADX INFO: renamed from: c */
        private Method f9638c;

        public a(Object obj, String str) {
            this.f9637b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f9638c = cls.getMethod(str, f9636a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f9638c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f9638c.invoke(this.f9637b, menuItem)).booleanValue();
                }
                this.f9638c.invoke(this.f9637b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: er$b */
    /* JADX INFO: compiled from: SupportMenuInflater.java */
    class b {

        /* JADX INFO: renamed from: A */
        private String f9639A;

        /* JADX INFO: renamed from: B */
        private String f9640B;

        /* JADX INFO: renamed from: C */
        private CharSequence f9641C;

        /* JADX INFO: renamed from: D */
        private CharSequence f9642D;

        /* JADX INFO: renamed from: E */
        private ColorStateList f9643E = null;

        /* JADX INFO: renamed from: F */
        private PorterDuff.Mode f9644F = null;

        /* JADX INFO: renamed from: a */
        ActionProvider f9645a;

        /* JADX INFO: renamed from: c */
        private Menu f9647c;

        /* JADX INFO: renamed from: d */
        private int f9648d;

        /* JADX INFO: renamed from: e */
        private int f9649e;

        /* JADX INFO: renamed from: f */
        private int f9650f;

        /* JADX INFO: renamed from: g */
        private int f9651g;

        /* JADX INFO: renamed from: h */
        private boolean f9652h;

        /* JADX INFO: renamed from: i */
        private boolean f9653i;

        /* JADX INFO: renamed from: j */
        private boolean f9654j;

        /* JADX INFO: renamed from: k */
        private int f9655k;

        /* JADX INFO: renamed from: l */
        private int f9656l;

        /* JADX INFO: renamed from: m */
        private CharSequence f9657m;

        /* JADX INFO: renamed from: n */
        private CharSequence f9658n;

        /* JADX INFO: renamed from: o */
        private int f9659o;

        /* JADX INFO: renamed from: p */
        private char f9660p;

        /* JADX INFO: renamed from: q */
        private int f9661q;

        /* JADX INFO: renamed from: r */
        private char f9662r;

        /* JADX INFO: renamed from: s */
        private int f9663s;

        /* JADX INFO: renamed from: t */
        private int f9664t;

        /* JADX INFO: renamed from: u */
        private boolean f9665u;

        /* JADX INFO: renamed from: v */
        private boolean f9666v;

        /* JADX INFO: renamed from: w */
        private boolean f9667w;

        /* JADX INFO: renamed from: x */
        private int f9668x;

        /* JADX INFO: renamed from: y */
        private int f9669y;

        /* JADX INFO: renamed from: z */
        private String f9670z;

        public b(Menu menu) {
            this.f9647c = menu;
            m9082a();
        }

        /* JADX INFO: renamed from: a */
        public void m9082a() {
            this.f9648d = 0;
            this.f9649e = 0;
            this.f9650f = 0;
            this.f9651g = 0;
            this.f9652h = true;
            this.f9653i = true;
        }

        /* JADX INFO: renamed from: a */
        public void m9083a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C1699er.this.f9634e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f9648d = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f9649e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f9650f = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f9651g = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f9652h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f9653i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: b */
        public void m9085b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C1699er.this.f9634e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.f9655k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f9656l = (typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f9649e) & SupportMenu.CATEGORY_MASK) | (typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f9650f) & 65535);
            this.f9657m = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f9658n = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f9659o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.f9660p = m9079a(typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f9661q = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f9662r = m9079a(typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.f9663s = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.f9664t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f9664t = this.f9651g;
            }
            this.f9665u = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f9666v = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f9652h);
            this.f9667w = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f9653i);
            this.f9668x = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f9640B = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f9669y = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f9670z = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.f9639A = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.f9639A != null;
            if (z && this.f9669y == 0 && this.f9670z == null) {
                this.f9645a = (ActionProvider) m9080a(this.f9639A, C1699er.f9631b, C1699er.this.f9633d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f9645a = null;
            }
            this.f9641C = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.f9642D = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.f9644F = C1743gh.m9425a(typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_iconTintMode, -1), this.f9644F);
            } else {
                this.f9644F = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTint)) {
                this.f9643E = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.f9643E = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f9654j = false;
        }

        /* JADX INFO: renamed from: a */
        private char m9079a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* JADX INFO: renamed from: a */
        private void m9081a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f9665u).setVisible(this.f9666v).setEnabled(this.f9667w).setCheckable(this.f9664t >= 1).setTitleCondensed(this.f9658n).setIcon(this.f9659o);
            if (this.f9668x >= 0) {
                menuItem.setShowAsAction(this.f9668x);
            }
            if (this.f9640B != null) {
                if (C1699er.this.f9634e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C1699er.this.m9078a(), this.f9640B));
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
            }
            if (this.f9664t >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).m3374a(true);
                } else if (menuItem instanceof MenuItemC1710fb) {
                    ((MenuItemC1710fb) menuItem).m9144a(true);
                }
            }
            if (this.f9670z != null) {
                menuItem.setActionView((View) m9080a(this.f9670z, C1699er.f9630a, C1699er.this.f9632c));
                z = true;
            }
            if (this.f9669y > 0) {
                if (!z) {
                    menuItem.setActionView(this.f9669y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f9645a != null) {
                MenuItemCompat.setActionProvider(menuItem, this.f9645a);
            }
            MenuItemCompat.setContentDescription(menuItem, this.f9641C);
            MenuItemCompat.setTooltipText(menuItem, this.f9642D);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.f9660p, this.f9661q);
            MenuItemCompat.setNumericShortcut(menuItem, this.f9662r, this.f9663s);
            if (this.f9644F != null) {
                MenuItemCompat.setIconTintMode(menuItem, this.f9644F);
            }
            if (this.f9643E != null) {
                MenuItemCompat.setIconTintList(menuItem, this.f9643E);
            }
        }

        /* JADX INFO: renamed from: b */
        public void m9084b() {
            this.f9654j = true;
            m9081a(this.f9647c.add(this.f9648d, this.f9655k, this.f9656l, this.f9657m));
        }

        /* JADX INFO: renamed from: c */
        public SubMenu m9086c() {
            this.f9654j = true;
            SubMenu subMenuAddSubMenu = this.f9647c.addSubMenu(this.f9648d, this.f9655k, this.f9656l, this.f9657m);
            m9081a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* JADX INFO: renamed from: d */
        public boolean m9087d() {
            return this.f9654j;
        }

        /* JADX INFO: renamed from: a */
        private <T> T m9080a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = C1699er.this.f9634e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
