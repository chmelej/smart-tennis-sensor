package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import p000.AbstractViewOnAttachStateChangeListenerC1747gl;
import p000.C1722fn;
import p000.C1766hd;
import p000.InterfaceC1718fj;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: a */
    final C0576a f3417a;

    /* JADX INFO: renamed from: b */
    final FrameLayout f3418b;

    /* JADX INFO: renamed from: c */
    final FrameLayout f3419c;

    /* JADX INFO: renamed from: d */
    ActionProvider f3420d;

    /* JADX INFO: renamed from: e */
    final DataSetObserver f3421e;

    /* JADX INFO: renamed from: f */
    PopupWindow.OnDismissListener f3422f;

    /* JADX INFO: renamed from: g */
    boolean f3423g;

    /* JADX INFO: renamed from: h */
    int f3424h;

    /* JADX INFO: renamed from: i */
    private final ViewOnClickListenerC0577b f3425i;

    /* JADX INFO: renamed from: j */
    private final View f3426j;

    /* JADX INFO: renamed from: k */
    private final Drawable f3427k;

    /* JADX INFO: renamed from: l */
    private final ImageView f3428l;

    /* JADX INFO: renamed from: m */
    private final ImageView f3429m;

    /* JADX INFO: renamed from: n */
    private final int f3430n;

    /* JADX INFO: renamed from: o */
    private final ViewTreeObserver.OnGlobalLayoutListener f3431o;

    /* JADX INFO: renamed from: p */
    private ListPopupWindow f3432p;

    /* JADX INFO: renamed from: q */
    private boolean f3433q;

    /* JADX INFO: renamed from: r */
    private int f3434r;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3421e = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f3417a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f3417a.notifyDataSetInvalidated();
            }
        };
        this.f3431o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.m3484c()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().mo3690e();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().mo3510d();
                    if (ActivityChooserView.this.f3420d != null) {
                        ActivityChooserView.this.f3420d.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.f3424h = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.f3424h = typedArrayObtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f3425i = new ViewOnClickListenerC0577b();
        this.f3426j = findViewById(R.id.activity_chooser_view_content);
        this.f3427k = this.f3426j.getBackground();
        this.f3419c = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f3419c.setOnClickListener(this.f3425i);
        this.f3419c.setOnLongClickListener(this.f3425i);
        this.f3429m = (ImageView) this.f3419c.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.f3425i);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: android.support.v7.widget.ActivityChooserView.3
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
            }
        });
        frameLayout.setOnTouchListener(new AbstractViewOnAttachStateChangeListenerC1747gl(frameLayout) { // from class: android.support.v7.widget.ActivityChooserView.4
            @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
            /* JADX INFO: renamed from: a */
            public InterfaceC1718fj mo3300a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
            /* JADX INFO: renamed from: b */
            public boolean mo3301b() {
                ActivityChooserView.this.m3482a();
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
            /* JADX INFO: renamed from: c */
            public boolean mo3462c() {
                ActivityChooserView.this.m3483b();
                return true;
            }
        });
        this.f3418b = frameLayout;
        this.f3428l = (ImageView) frameLayout.findViewById(R.id.image);
        this.f3428l.setImageDrawable(drawable);
        this.f3417a = new C0576a();
        this.f3417a.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.m3485d();
            }
        });
        Resources resources = context.getResources();
        this.f3430n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(C1722fn c1722fn) {
        this.f3417a.m3488a(c1722fn);
        if (m3484c()) {
            m3483b();
            m3482a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f3428l.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f3428l.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f3420d = actionProvider;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3482a() {
        if (m3484c() || !this.f3433q) {
            return false;
        }
        this.f3423g = false;
        m3481a(this.f3424h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    void m3481a(int i) {
        if (this.f3417a.m3494e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f3431o);
        ?? r0 = this.f3419c.getVisibility() == 0 ? 1 : 0;
        int iM3492c = this.f3417a.m3492c();
        if (i != Integer.MAX_VALUE && iM3492c > i + r0) {
            this.f3417a.m3489a(true);
            this.f3417a.m3487a(i - 1);
        } else {
            this.f3417a.m3489a(false);
            this.f3417a.m3487a(i);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.mo3693f()) {
            return;
        }
        if (this.f3423g || r0 == 0) {
            this.f3417a.m3490a(true, r0);
        } else {
            this.f3417a.m3490a(false, false);
        }
        listPopupWindow.m3695g(Math.min(this.f3417a.m3486a(), this.f3430n));
        listPopupWindow.mo3510d();
        if (this.f3420d != null) {
            this.f3420d.subUiVisibilityChanged(true);
        }
        listPopupWindow.mo3694g().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.mo3694g().setSelector(new ColorDrawable(0));
    }

    /* JADX INFO: renamed from: b */
    public boolean m3483b() {
        if (!m3484c()) {
            return true;
        }
        getListPopupWindow().mo3690e();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f3431o);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m3484c() {
        return getListPopupWindow().mo3693f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1722fn c1722fnM3494e = this.f3417a.m3494e();
        if (c1722fnM3494e != null) {
            c1722fnM3494e.registerObserver(this.f3421e);
        }
        this.f3433q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1722fn c1722fnM3494e = this.f3417a.m3494e();
        if (c1722fnM3494e != null) {
            c1722fnM3494e.unregisterObserver(this.f3421e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f3431o);
        }
        if (m3484c()) {
            m3483b();
        }
        this.f3433q = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.f3426j;
        if (this.f3419c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f3426j.layout(0, 0, i3 - i, i4 - i2);
        if (m3484c()) {
            return;
        }
        m3483b();
    }

    public C1722fn getDataModel() {
        return this.f3417a.m3494e();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f3422f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f3424h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f3434r = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f3432p == null) {
            this.f3432p = new ListPopupWindow(getContext());
            this.f3432p.mo3506a(this.f3417a);
            this.f3432p.m3685b(this);
            this.f3432p.m3683a(true);
            this.f3432p.m3681a((AdapterView.OnItemClickListener) this.f3425i);
            this.f3432p.m3682a((PopupWindow.OnDismissListener) this.f3425i);
        }
        return this.f3432p;
    }

    /* JADX INFO: renamed from: d */
    void m3485d() {
        if (this.f3417a.getCount() > 0) {
            this.f3418b.setEnabled(true);
        } else {
            this.f3418b.setEnabled(false);
        }
        int iM3492c = this.f3417a.m3492c();
        int iM3493d = this.f3417a.m3493d();
        if (iM3492c == 1 || (iM3492c > 1 && iM3493d > 0)) {
            this.f3419c.setVisibility(0);
            ResolveInfo resolveInfoM3491b = this.f3417a.m3491b();
            PackageManager packageManager = getContext().getPackageManager();
            this.f3429m.setImageDrawable(resolveInfoM3491b.loadIcon(packageManager));
            if (this.f3434r != 0) {
                this.f3419c.setContentDescription(getContext().getString(this.f3434r, resolveInfoM3491b.loadLabel(packageManager)));
            }
        } else {
            this.f3419c.setVisibility(8);
        }
        if (this.f3419c.getVisibility() == 0) {
            this.f3426j.setBackgroundDrawable(this.f3427k);
        } else {
            this.f3426j.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActivityChooserView$b */
    class ViewOnClickListenerC0577b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        ViewOnClickListenerC0577b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0576a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.m3483b();
                    if (ActivityChooserView.this.f3423g) {
                        if (i > 0) {
                            ActivityChooserView.this.f3417a.m3494e().m9184c(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.f3417a.m3495f()) {
                        i++;
                    }
                    Intent intentM9181b = ActivityChooserView.this.f3417a.m3494e().m9181b(i);
                    if (intentM9181b != null) {
                        intentM9181b.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(intentM9181b);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.m3481a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == ActivityChooserView.this.f3419c) {
                ActivityChooserView.this.m3483b();
                Intent intentM9181b = ActivityChooserView.this.f3417a.m3494e().m9181b(ActivityChooserView.this.f3417a.m3494e().m9179a(ActivityChooserView.this.f3417a.m3491b()));
                if (intentM9181b != null) {
                    intentM9181b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(intentM9181b);
                    return;
                }
                return;
            }
            if (view == ActivityChooserView.this.f3418b) {
                ActivityChooserView.this.f3423g = false;
                ActivityChooserView.this.m3481a(ActivityChooserView.this.f3424h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f3419c) {
                if (ActivityChooserView.this.f3417a.getCount() > 0) {
                    ActivityChooserView.this.f3423g = true;
                    ActivityChooserView.this.m3481a(ActivityChooserView.this.f3424h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m3496a();
            if (ActivityChooserView.this.f3420d != null) {
                ActivityChooserView.this.f3420d.subUiVisibilityChanged(false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3496a() {
            if (ActivityChooserView.this.f3422f != null) {
                ActivityChooserView.this.f3422f.onDismiss();
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActivityChooserView$a */
    class C0576a extends BaseAdapter {

        /* JADX INFO: renamed from: b */
        private C1722fn f3442b;

        /* JADX INFO: renamed from: c */
        private int f3443c = 4;

        /* JADX INFO: renamed from: d */
        private boolean f3444d;

        /* JADX INFO: renamed from: e */
        private boolean f3445e;

        /* JADX INFO: renamed from: f */
        private boolean f3446f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        C0576a() {
        }

        /* JADX INFO: renamed from: a */
        public void m3488a(C1722fn c1722fn) {
            C1722fn c1722fnM3494e = ActivityChooserView.this.f3417a.m3494e();
            if (c1722fnM3494e != null && ActivityChooserView.this.isShown()) {
                c1722fnM3494e.unregisterObserver(ActivityChooserView.this.f3421e);
            }
            this.f3442b = c1722fn;
            if (c1722fn != null && ActivityChooserView.this.isShown()) {
                c1722fn.registerObserver(ActivityChooserView.this.f3421e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f3446f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iM9178a = this.f3442b.m9178a();
            if (!this.f3444d && this.f3442b.m9182b() != null) {
                iM9178a--;
            }
            int iMin = Math.min(iM9178a, this.f3443c);
            return this.f3446f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f3444d && this.f3442b.m9182b() != null) {
                        i++;
                    }
                    return this.f3442b.m9180a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != R.id.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f3444d && i == 0 && this.f3445e) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    return viewInflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* JADX INFO: renamed from: a */
        public int m3486a() {
            int i = this.f3443c;
            this.f3443c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f3443c = i;
            return iMax;
        }

        /* JADX INFO: renamed from: a */
        public void m3487a(int i) {
            if (this.f3443c != i) {
                this.f3443c = i;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: b */
        public ResolveInfo m3491b() {
            return this.f3442b.m9182b();
        }

        /* JADX INFO: renamed from: a */
        public void m3489a(boolean z) {
            if (this.f3446f != z) {
                this.f3446f = z;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: c */
        public int m3492c() {
            return this.f3442b.m9178a();
        }

        /* JADX INFO: renamed from: d */
        public int m3493d() {
            return this.f3442b.m9183c();
        }

        /* JADX INFO: renamed from: e */
        public C1722fn m3494e() {
            return this.f3442b;
        }

        /* JADX INFO: renamed from: a */
        public void m3490a(boolean z, boolean z2) {
            if (this.f3444d == z && this.f3445e == z2) {
                return;
            }
            this.f3444d = z;
            this.f3445e = z2;
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: f */
        public boolean m3495f() {
            return this.f3444d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a */
        private static final int[] f3440a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C1766hd c1766hdM9600a = C1766hd.m9600a(context, attributeSet, f3440a);
            setBackgroundDrawable(c1766hdM9600a.m9605a(0));
            c1766hdM9600a.m9606a();
        }
    }
}
