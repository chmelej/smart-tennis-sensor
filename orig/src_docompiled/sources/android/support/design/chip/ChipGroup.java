package android.support.design.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.internal.FlowLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import p000.C0751at;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: a */
    private int f2153a;

    /* JADX INFO: renamed from: b */
    private int f2154b;

    /* JADX INFO: renamed from: c */
    private boolean f2155c;

    /* JADX INFO: renamed from: d */
    private InterfaceC0237b f2156d;

    /* JADX INFO: renamed from: e */
    private final C0236a f2157e;

    /* JADX INFO: renamed from: f */
    private ViewGroupOnHierarchyChangeListenerC0238c f2158f;

    /* JADX INFO: renamed from: g */
    private int f2159g;

    /* JADX INFO: renamed from: h */
    private boolean f2160h;

    /* JADX INFO: renamed from: android.support.design.chip.ChipGroup$b */
    public interface InterfaceC0237b {
        /* JADX INFO: renamed from: a */
        void m2418a(ChipGroup chipGroup, int i);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2157e = new C0236a();
        this.f2158f = new ViewGroupOnHierarchyChangeListenerC0238c();
        this.f2159g = -1;
        this.f2160h = false;
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.ChipGroup, i, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = typedArrayM5390a.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayM5390a.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayM5390a.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayM5390a.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayM5390a.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        int resourceId = typedArrayM5390a.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.f2159g = resourceId;
        }
        typedArrayM5390a.recycle();
        super.setOnHierarchyChangeListener(this.f2158f);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2158f.f2163b = onHierarchyChangeListener;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f2159g != -1) {
            m2410a(this.f2159g, true);
            setCheckedId(this.f2159g);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                if (this.f2159g != -1 && this.f2155c) {
                    m2410a(this.f2159g, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public int getCheckedChipId() {
        if (this.f2155c) {
            return this.f2159g;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public void m2417a() {
        this.f2160h = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f2160h = false;
        setCheckedId(-1);
    }

    public void setOnCheckedChangeListener(InterfaceC0237b interfaceC0237b) {
        this.f2156d = interfaceC0237b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.f2159g = i;
        if (this.f2156d == null || !this.f2155c) {
            return;
        }
        this.f2156d.m2418a(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2410a(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof Chip) {
            this.f2160h = true;
            ((Chip) viewFindViewById).setChecked(z);
            this.f2160h = false;
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingHorizontal() {
        return this.f2153a;
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f2153a != i) {
            this.f2153a = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingVertical() {
        return this.f2154b;
    }

    public void setChipSpacingVertical(int i) {
        if (this.f2154b != i) {
            this.f2154b = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.f2155c != z) {
            this.f2155c = z;
            m2417a();
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX INFO: renamed from: android.support.design.chip.ChipGroup$a */
    class C0236a implements CompoundButton.OnCheckedChangeListener {
        private C0236a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.f2160h) {
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.f2159g != -1 && ChipGroup.this.f2159g != id && ChipGroup.this.f2155c) {
                    ChipGroup.this.m2410a(ChipGroup.this.f2159g, false);
                }
                ChipGroup.this.setCheckedId(id);
                return;
            }
            if (ChipGroup.this.f2159g == id) {
                ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.design.chip.ChipGroup$c */
    class ViewGroupOnHierarchyChangeListenerC0238c implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: b */
        private ViewGroup.OnHierarchyChangeListener f2163b;

        private ViewGroupOnHierarchyChangeListenerC0238c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            int iHashCode;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        iHashCode = View.generateViewId();
                    } else {
                        iHashCode = view2.hashCode();
                    }
                    view2.setId(iHashCode);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f2157e);
            }
            if (this.f2163b != null) {
                this.f2163b.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            if (this.f2163b != null) {
                this.f2163b.onChildViewRemoved(view, view2);
            }
        }
    }
}
