package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import p000.C1766hd;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, InterfaceC1715fg.a {

    /* JADX INFO: renamed from: a */
    private MenuItemImpl f3222a;

    /* JADX INFO: renamed from: b */
    private ImageView f3223b;

    /* JADX INFO: renamed from: c */
    private RadioButton f3224c;

    /* JADX INFO: renamed from: d */
    private TextView f3225d;

    /* JADX INFO: renamed from: e */
    private CheckBox f3226e;

    /* JADX INFO: renamed from: f */
    private TextView f3227f;

    /* JADX INFO: renamed from: g */
    private ImageView f3228g;

    /* JADX INFO: renamed from: h */
    private ImageView f3229h;

    /* JADX INFO: renamed from: i */
    private LinearLayout f3230i;

    /* JADX INFO: renamed from: j */
    private Drawable f3231j;

    /* JADX INFO: renamed from: k */
    private int f3232k;

    /* JADX INFO: renamed from: l */
    private Context f3233l;

    /* JADX INFO: renamed from: m */
    private boolean f3234m;

    /* JADX INFO: renamed from: n */
    private Drawable f3235n;

    /* JADX INFO: renamed from: o */
    private boolean f3236o;

    /* JADX INFO: renamed from: p */
    private int f3237p;

    /* JADX INFO: renamed from: q */
    private LayoutInflater f3238q;

    /* JADX INFO: renamed from: r */
    private boolean f3239r;

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public boolean mo2424a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C1766hd c1766hdM9601a = C1766hd.m9601a(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.f3231j = c1766hdM9601a.m9605a(R.styleable.MenuView_android_itemBackground);
        this.f3232k = c1766hdM9601a.m9619g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f3234m = c1766hdM9601a.m9607a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f3233l = context;
        this.f3235n = c1766hdM9601a.m9605a(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f3236o = typedArrayObtainStyledAttributes.hasValue(0);
        c1766hdM9601a.m9606a();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.f3231j);
        this.f3225d = (TextView) findViewById(R.id.title);
        if (this.f3232k != -1) {
            this.f3225d.setTextAppearance(this.f3233l, this.f3232k);
        }
        this.f3227f = (TextView) findViewById(R.id.shortcut);
        this.f3228g = (ImageView) findViewById(R.id.submenuarrow);
        if (this.f3228g != null) {
            this.f3228g.setImageDrawable(this.f3235n);
        }
        this.f3229h = (ImageView) findViewById(R.id.group_divider);
        this.f3230i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public void mo2423a(MenuItemImpl menuItemImpl, int i) {
        this.f3222a = menuItemImpl;
        this.f3237p = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m3371a((InterfaceC1715fg.a) this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.m3384e(), menuItemImpl.m3379c());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    /* JADX INFO: renamed from: a */
    private void m3304a(View view) {
        m3305a(view, -1);
    }

    /* JADX INFO: renamed from: a */
    private void m3305a(View view, int i) {
        if (this.f3230i != null) {
            this.f3230i.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f3239r = z;
        this.f3234m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f3225d.setText(charSequence);
            if (this.f3225d.getVisibility() != 0) {
                this.f3225d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f3225d.getVisibility() != 8) {
            this.f3225d.setVisibility(8);
        }
    }

    @Override // p000.InterfaceC1715fg.a
    public MenuItemImpl getItemData() {
        return this.f3222a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f3224c == null && this.f3226e == null) {
            return;
        }
        if (this.f3222a.m3385f()) {
            if (this.f3224c == null) {
                m3307c();
            }
            compoundButton = this.f3224c;
            compoundButton2 = this.f3226e;
        } else {
            if (this.f3226e == null) {
                m3308d();
            }
            compoundButton = this.f3226e;
            compoundButton2 = this.f3224c;
        }
        if (z) {
            compoundButton.setChecked(this.f3222a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        if (this.f3226e != null) {
            this.f3226e.setVisibility(8);
        }
        if (this.f3224c != null) {
            this.f3224c.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f3222a.m3385f()) {
            if (this.f3224c == null) {
                m3307c();
            }
            compoundButton = this.f3224c;
        } else {
            if (this.f3226e == null) {
                m3308d();
            }
            compoundButton = this.f3226e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f3228g != null) {
            this.f3228g.setVisibility(z ? 0 : 8);
        }
    }

    public void setShortcut(boolean z, char c) {
        int i = (z && this.f3222a.m3384e()) ? 0 : 8;
        if (i == 0) {
            this.f3227f.setText(this.f3222a.m3381d());
        }
        if (this.f3227f.getVisibility() != i) {
            this.f3227f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f3222a.m3387h() || this.f3239r;
        if (z || this.f3234m) {
            if (this.f3223b == null && drawable == null && !this.f3234m) {
                return;
            }
            if (this.f3223b == null) {
                m3306b();
            }
            if (drawable != null || this.f3234m) {
                ImageView imageView = this.f3223b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f3223b.getVisibility() != 0) {
                    this.f3223b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f3223b.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f3223b != null && this.f3234m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3223b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: b */
    private void m3306b() {
        this.f3223b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        m3305a(this.f3223b, 0);
    }

    /* JADX INFO: renamed from: c */
    private void m3307c() {
        this.f3224c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        m3304a(this.f3224c);
    }

    /* JADX INFO: renamed from: d */
    private void m3308d() {
        this.f3226e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        m3304a(this.f3226e);
    }

    private LayoutInflater getInflater() {
        if (this.f3238q == null) {
            this.f3238q = LayoutInflater.from(getContext());
        }
        return this.f3238q;
    }

    public void setGroupDividerEnabled(boolean z) {
        if (this.f3229h != null) {
            this.f3229h.setVisibility((this.f3236o || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.f3229h == null || this.f3229h.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3229h.getLayoutParams();
        rect.top += this.f3229h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
