package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import p000.DialogC1677dy;

/* JADX INFO: loaded from: classes.dex */
public class AlertController {

    /* JADX INFO: renamed from: A */
    private int f2973A;

    /* JADX INFO: renamed from: C */
    private CharSequence f2975C;

    /* JADX INFO: renamed from: D */
    private Drawable f2976D;

    /* JADX INFO: renamed from: E */
    private CharSequence f2977E;

    /* JADX INFO: renamed from: F */
    private Drawable f2978F;

    /* JADX INFO: renamed from: G */
    private CharSequence f2979G;

    /* JADX INFO: renamed from: H */
    private Drawable f2980H;

    /* JADX INFO: renamed from: J */
    private Drawable f2982J;

    /* JADX INFO: renamed from: K */
    private ImageView f2983K;

    /* JADX INFO: renamed from: L */
    private TextView f2984L;

    /* JADX INFO: renamed from: M */
    private TextView f2985M;

    /* JADX INFO: renamed from: N */
    private View f2986N;

    /* JADX INFO: renamed from: O */
    private int f2987O;

    /* JADX INFO: renamed from: P */
    private int f2988P;

    /* JADX INFO: renamed from: Q */
    private boolean f2989Q;

    /* JADX INFO: renamed from: a */
    final DialogC1677dy f2992a;

    /* JADX INFO: renamed from: b */
    ListView f2993b;

    /* JADX INFO: renamed from: c */
    Button f2994c;

    /* JADX INFO: renamed from: d */
    Message f2995d;

    /* JADX INFO: renamed from: e */
    Button f2996e;

    /* JADX INFO: renamed from: f */
    Message f2997f;

    /* JADX INFO: renamed from: g */
    Button f2998g;

    /* JADX INFO: renamed from: h */
    Message f2999h;

    /* JADX INFO: renamed from: i */
    NestedScrollView f3000i;

    /* JADX INFO: renamed from: j */
    ListAdapter f3001j;

    /* JADX INFO: renamed from: l */
    int f3003l;

    /* JADX INFO: renamed from: m */
    int f3004m;

    /* JADX INFO: renamed from: n */
    int f3005n;

    /* JADX INFO: renamed from: o */
    int f3006o;

    /* JADX INFO: renamed from: p */
    Handler f3007p;

    /* JADX INFO: renamed from: q */
    private final Context f3008q;

    /* JADX INFO: renamed from: r */
    private final Window f3009r;

    /* JADX INFO: renamed from: s */
    private final int f3010s;

    /* JADX INFO: renamed from: t */
    private CharSequence f3011t;

    /* JADX INFO: renamed from: u */
    private CharSequence f3012u;

    /* JADX INFO: renamed from: v */
    private View f3013v;

    /* JADX INFO: renamed from: w */
    private int f3014w;

    /* JADX INFO: renamed from: x */
    private int f3015x;

    /* JADX INFO: renamed from: y */
    private int f3016y;

    /* JADX INFO: renamed from: z */
    private int f3017z;

    /* JADX INFO: renamed from: B */
    private boolean f2974B = false;

    /* JADX INFO: renamed from: I */
    private int f2981I = 0;

    /* JADX INFO: renamed from: k */
    int f3002k = -1;

    /* JADX INFO: renamed from: R */
    private int f2990R = 0;

    /* JADX INFO: renamed from: S */
    private final View.OnClickListener f2991S = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            if (view == AlertController.this.f2994c && AlertController.this.f2995d != null) {
                messageObtain = Message.obtain(AlertController.this.f2995d);
            } else if (view == AlertController.this.f2996e && AlertController.this.f2997f != null) {
                messageObtain = Message.obtain(AlertController.this.f2997f);
            } else {
                messageObtain = (view != AlertController.this.f2998g || AlertController.this.f2999h == null) ? null : Message.obtain(AlertController.this.f2999h);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController.this.f3007p.obtainMessage(1, AlertController.this.f2992a).sendToTarget();
        }
    };

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$b */
    static final class HandlerC0533b extends Handler {

        /* JADX INFO: renamed from: a */
        private WeakReference<DialogInterface> f3087a;

        public HandlerC0533b(DialogInterface dialogInterface) {
            this.f3087a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick(this.f3087a.get(), message.what);
                        break;
                }
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3162a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, DialogC1677dy dialogC1677dy, Window window) {
        this.f3008q = context;
        this.f2992a = dialogC1677dy;
        this.f3009r = window;
        this.f3007p = new HandlerC0533b(dialogC1677dy);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f2987O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f2988P = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f3003l = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f3004m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f3005n = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f3006o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f2989Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f3010s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC1677dy.m8912a(1);
    }

    /* JADX INFO: renamed from: a */
    static boolean m3163a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m3163a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m3169a() {
        this.f2992a.setContentView(m3164b());
        m3166c();
    }

    /* JADX INFO: renamed from: b */
    private int m3164b() {
        if (this.f2988P == 0) {
            return this.f2987O;
        }
        if (this.f2990R == 1) {
            return this.f2988P;
        }
        return this.f2987O;
    }

    /* JADX INFO: renamed from: a */
    public void m3174a(CharSequence charSequence) {
        this.f3011t = charSequence;
        if (this.f2984L != null) {
            this.f2984L.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3177b(View view) {
        this.f2986N = view;
    }

    /* JADX INFO: renamed from: b */
    public void m3178b(CharSequence charSequence) {
        this.f3012u = charSequence;
        if (this.f2985M != null) {
            this.f2985M.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3170a(int i) {
        this.f3013v = null;
        this.f3014w = i;
        this.f2974B = false;
    }

    /* JADX INFO: renamed from: c */
    public void m3181c(View view) {
        this.f3013v = view;
        this.f3014w = 0;
        this.f2974B = false;
    }

    /* JADX INFO: renamed from: a */
    public void m3173a(View view, int i, int i2, int i3, int i4) {
        this.f3013v = view;
        this.f3014w = 0;
        this.f2974B = true;
        this.f3015x = i;
        this.f3016y = i2;
        this.f3017z = i3;
        this.f2973A = i4;
    }

    /* JADX INFO: renamed from: a */
    public void m3171a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f3007p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f2979G = charSequence;
                this.f2999h = message;
                this.f2980H = drawable;
                return;
            case -2:
                this.f2977E = charSequence;
                this.f2997f = message;
                this.f2978F = drawable;
                return;
            case -1:
                this.f2975C = charSequence;
                this.f2995d = message;
                this.f2976D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3176b(int i) {
        this.f2982J = null;
        this.f2981I = i;
        if (this.f2983K != null) {
            if (i != 0) {
                this.f2983K.setVisibility(0);
                this.f2983K.setImageResource(this.f2981I);
            } else {
                this.f2983K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3172a(Drawable drawable) {
        this.f2982J = drawable;
        this.f2981I = 0;
        if (this.f2983K != null) {
            if (drawable != null) {
                this.f2983K.setVisibility(0);
                this.f2983K.setImageDrawable(drawable);
            } else {
                this.f2983K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public int m3180c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f3008q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3175a(int i, KeyEvent keyEvent) {
        return this.f3000i != null && this.f3000i.executeKeyEvent(keyEvent);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3179b(int i, KeyEvent keyEvent) {
        return this.f3000i != null && this.f3000i.executeKeyEvent(keyEvent);
    }

    /* JADX INFO: renamed from: a */
    private ViewGroup m3157a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    private void m3166c() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3 = this.f3009r.findViewById(R.id.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id.customPanel);
        m3159a(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupM3157a = m3157a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM3157a2 = m3157a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM3157a3 = m3157a(viewFindViewById9, viewFindViewById6);
        m3167c(viewGroupM3157a2);
        m3168d(viewGroupM3157a3);
        m3165b(viewGroupM3157a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM3157a == null || viewGroupM3157a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupM3157a3 == null || viewGroupM3157a3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM3157a2 != null && (viewFindViewById2 = viewGroupM3157a2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            if (this.f3000i != null) {
                this.f3000i.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f3012u == null && this.f2993b == null) ? null : viewGroupM3157a.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM3157a2 != null && (viewFindViewById = viewGroupM3157a2.findViewById(R.id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (this.f2993b instanceof RecycleListView) {
            ((RecycleListView) this.f2993b).setHasDecor(z2, z3);
        }
        if (!z) {
            View view = this.f2993b != null ? this.f2993b : this.f3000i;
            if (view != null) {
                m3160a(viewGroupM3157a2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView = this.f2993b;
        if (listView == null || this.f3001j == null) {
            return;
        }
        listView.setAdapter(this.f3001j);
        int i = this.f3002k;
        if (i > -1) {
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3160a(ViewGroup viewGroup, View view, int i, int i2) {
        final View viewFindViewById = this.f3009r.findViewById(R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.f3009r.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.f3012u != null) {
            this.f3000i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: android.support.v7.app.AlertController.2
                @Override // android.support.v4.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.m3158a(nestedScrollView, viewFindViewById, view2);
                }
            });
            this.f3000i.post(new Runnable() { // from class: android.support.v7.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m3158a(AlertController.this.f3000i, viewFindViewById, view2);
                }
            });
        } else {
            if (this.f2993b != null) {
                this.f2993b.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i3) {
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                        AlertController.m3158a(absListView, viewFindViewById, view2);
                    }
                });
                this.f2993b.post(new Runnable() { // from class: android.support.v7.app.AlertController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.m3158a(AlertController.this.f2993b, viewFindViewById, view2);
                    }
                });
                return;
            }
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3159a(ViewGroup viewGroup) {
        View viewInflate;
        if (this.f3013v != null) {
            viewInflate = this.f3013v;
        } else {
            viewInflate = this.f3014w != 0 ? LayoutInflater.from(this.f3008q).inflate(this.f3014w, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !m3163a(viewInflate)) {
            this.f3009r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f3009r.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f2974B) {
                frameLayout.setPadding(this.f3015x, this.f3016y, this.f3017z, this.f2973A);
            }
            if (this.f2993b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f3547g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: b */
    private void m3165b(ViewGroup viewGroup) {
        if (this.f2986N != null) {
            viewGroup.addView(this.f2986N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f3009r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.f2983K = (ImageView) this.f3009r.findViewById(android.R.id.icon);
        if ((!TextUtils.isEmpty(this.f3011t)) && this.f2989Q) {
            this.f2984L = (TextView) this.f3009r.findViewById(R.id.alertTitle);
            this.f2984L.setText(this.f3011t);
            if (this.f2981I != 0) {
                this.f2983K.setImageResource(this.f2981I);
                return;
            } else if (this.f2982J != null) {
                this.f2983K.setImageDrawable(this.f2982J);
                return;
            } else {
                this.f2984L.setPadding(this.f2983K.getPaddingLeft(), this.f2983K.getPaddingTop(), this.f2983K.getPaddingRight(), this.f2983K.getPaddingBottom());
                this.f2983K.setVisibility(8);
                return;
            }
        }
        this.f3009r.findViewById(R.id.title_template).setVisibility(8);
        this.f2983K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    private void m3167c(ViewGroup viewGroup) {
        this.f3000i = (NestedScrollView) this.f3009r.findViewById(R.id.scrollView);
        this.f3000i.setFocusable(false);
        this.f3000i.setNestedScrollingEnabled(false);
        this.f2985M = (TextView) viewGroup.findViewById(android.R.id.message);
        if (this.f2985M == null) {
            return;
        }
        if (this.f3012u != null) {
            this.f2985M.setText(this.f3012u);
            return;
        }
        this.f2985M.setVisibility(8);
        this.f3000i.removeView(this.f2985M);
        if (this.f2993b != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f3000i.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.f3000i);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.f2993b, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    static void m3158a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3168d(ViewGroup viewGroup) {
        int i;
        this.f2994c = (Button) viewGroup.findViewById(android.R.id.button1);
        this.f2994c.setOnClickListener(this.f2991S);
        if (TextUtils.isEmpty(this.f2975C) && this.f2976D == null) {
            this.f2994c.setVisibility(8);
            i = 0;
        } else {
            this.f2994c.setText(this.f2975C);
            if (this.f2976D != null) {
                this.f2976D.setBounds(0, 0, this.f3010s, this.f3010s);
                this.f2994c.setCompoundDrawables(this.f2976D, null, null, null);
            }
            this.f2994c.setVisibility(0);
            i = 1;
        }
        this.f2996e = (Button) viewGroup.findViewById(android.R.id.button2);
        this.f2996e.setOnClickListener(this.f2991S);
        if (TextUtils.isEmpty(this.f2977E) && this.f2978F == null) {
            this.f2996e.setVisibility(8);
        } else {
            this.f2996e.setText(this.f2977E);
            if (this.f2978F != null) {
                this.f2978F.setBounds(0, 0, this.f3010s, this.f3010s);
                this.f2996e.setCompoundDrawables(this.f2978F, null, null, null);
            }
            this.f2996e.setVisibility(0);
            i |= 2;
        }
        this.f2998g = (Button) viewGroup.findViewById(android.R.id.button3);
        this.f2998g.setOnClickListener(this.f2991S);
        if (TextUtils.isEmpty(this.f2979G) && this.f2980H == null) {
            this.f2998g.setVisibility(8);
        } else {
            this.f2998g.setText(this.f2979G);
            if (this.f2976D != null) {
                this.f2976D.setBounds(0, 0, this.f3010s, this.f3010s);
                this.f2994c.setCompoundDrawables(this.f2976D, null, null, null);
            }
            this.f2998g.setVisibility(0);
            i |= 4;
        }
        if (m3162a(this.f3008q)) {
            if (i == 1) {
                m3161a(this.f2994c);
            } else if (i == 2) {
                m3161a(this.f2996e);
            } else if (i == 4) {
                m3161a(this.f2998g);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    private void m3161a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a */
        private final int f3031a;

        /* JADX INFO: renamed from: b */
        private final int f3032b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f3032b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f3031a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f3031a, getPaddingRight(), z2 ? getPaddingBottom() : this.f3032b);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$a */
    public static class C0532a {

        /* JADX INFO: renamed from: A */
        public int f3033A;

        /* JADX INFO: renamed from: B */
        public int f3034B;

        /* JADX INFO: renamed from: C */
        public int f3035C;

        /* JADX INFO: renamed from: D */
        public int f3036D;

        /* JADX INFO: renamed from: F */
        public boolean[] f3038F;

        /* JADX INFO: renamed from: G */
        public boolean f3039G;

        /* JADX INFO: renamed from: H */
        public boolean f3040H;

        /* JADX INFO: renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f3042J;

        /* JADX INFO: renamed from: K */
        public Cursor f3043K;

        /* JADX INFO: renamed from: L */
        public String f3044L;

        /* JADX INFO: renamed from: M */
        public String f3045M;

        /* JADX INFO: renamed from: N */
        public AdapterView.OnItemSelectedListener f3046N;

        /* JADX INFO: renamed from: O */
        public a f3047O;

        /* JADX INFO: renamed from: a */
        public final Context f3049a;

        /* JADX INFO: renamed from: b */
        public final LayoutInflater f3050b;

        /* JADX INFO: renamed from: d */
        public Drawable f3052d;

        /* JADX INFO: renamed from: f */
        public CharSequence f3054f;

        /* JADX INFO: renamed from: g */
        public View f3055g;

        /* JADX INFO: renamed from: h */
        public CharSequence f3056h;

        /* JADX INFO: renamed from: i */
        public CharSequence f3057i;

        /* JADX INFO: renamed from: j */
        public Drawable f3058j;

        /* JADX INFO: renamed from: k */
        public DialogInterface.OnClickListener f3059k;

        /* JADX INFO: renamed from: l */
        public CharSequence f3060l;

        /* JADX INFO: renamed from: m */
        public Drawable f3061m;

        /* JADX INFO: renamed from: n */
        public DialogInterface.OnClickListener f3062n;

        /* JADX INFO: renamed from: o */
        public CharSequence f3063o;

        /* JADX INFO: renamed from: p */
        public Drawable f3064p;

        /* JADX INFO: renamed from: q */
        public DialogInterface.OnClickListener f3065q;

        /* JADX INFO: renamed from: s */
        public DialogInterface.OnCancelListener f3067s;

        /* JADX INFO: renamed from: t */
        public DialogInterface.OnDismissListener f3068t;

        /* JADX INFO: renamed from: u */
        public DialogInterface.OnKeyListener f3069u;

        /* JADX INFO: renamed from: v */
        public CharSequence[] f3070v;

        /* JADX INFO: renamed from: w */
        public ListAdapter f3071w;

        /* JADX INFO: renamed from: x */
        public DialogInterface.OnClickListener f3072x;

        /* JADX INFO: renamed from: y */
        public int f3073y;

        /* JADX INFO: renamed from: z */
        public View f3074z;

        /* JADX INFO: renamed from: c */
        public int f3051c = 0;

        /* JADX INFO: renamed from: e */
        public int f3053e = 0;

        /* JADX INFO: renamed from: E */
        public boolean f3037E = false;

        /* JADX INFO: renamed from: I */
        public int f3041I = -1;

        /* JADX INFO: renamed from: P */
        public boolean f3048P = true;

        /* JADX INFO: renamed from: r */
        public boolean f3066r = true;

        /* JADX INFO: renamed from: android.support.v7.app.AlertController$a$a */
        public interface a {
            /* JADX INFO: renamed from: a */
            void m3184a(ListView listView);
        }

        public C0532a(Context context) {
            this.f3049a = context;
            this.f3050b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX INFO: renamed from: a */
        public void m3183a(AlertController alertController) {
            if (this.f3055g != null) {
                alertController.m3177b(this.f3055g);
            } else {
                if (this.f3054f != null) {
                    alertController.m3174a(this.f3054f);
                }
                if (this.f3052d != null) {
                    alertController.m3172a(this.f3052d);
                }
                if (this.f3051c != 0) {
                    alertController.m3176b(this.f3051c);
                }
                if (this.f3053e != 0) {
                    alertController.m3176b(alertController.m3180c(this.f3053e));
                }
            }
            if (this.f3056h != null) {
                alertController.m3178b(this.f3056h);
            }
            if (this.f3057i != null || this.f3058j != null) {
                alertController.m3171a(-1, this.f3057i, this.f3059k, (Message) null, this.f3058j);
            }
            if (this.f3060l != null || this.f3061m != null) {
                alertController.m3171a(-2, this.f3060l, this.f3062n, (Message) null, this.f3061m);
            }
            if (this.f3063o != null || this.f3064p != null) {
                alertController.m3171a(-3, this.f3063o, this.f3065q, (Message) null, this.f3064p);
            }
            if (this.f3070v != null || this.f3043K != null || this.f3071w != null) {
                m3182b(alertController);
            }
            if (this.f3074z != null) {
                if (this.f3037E) {
                    alertController.m3173a(this.f3074z, this.f3033A, this.f3034B, this.f3035C, this.f3036D);
                    return;
                } else {
                    alertController.m3181c(this.f3074z);
                    return;
                }
            }
            if (this.f3073y != 0) {
                alertController.m3170a(this.f3073y);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m3182b(final AlertController alertController) {
            int i;
            ListAdapter c0534c;
            final RecycleListView recycleListView = (RecycleListView) this.f3050b.inflate(alertController.f3003l, (ViewGroup) null);
            if (this.f3039G) {
                if (this.f3043K == null) {
                    c0534c = new ArrayAdapter<CharSequence>(this.f3049a, alertController.f3004m, android.R.id.text1, this.f3070v) { // from class: android.support.v7.app.AlertController.a.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            if (C0532a.this.f3038F != null && C0532a.this.f3038F[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    c0534c = new CursorAdapter(this.f3049a, this.f3043K, false) { // from class: android.support.v7.app.AlertController.a.2

                        /* JADX INFO: renamed from: d */
                        private final int f3080d;

                        /* JADX INFO: renamed from: e */
                        private final int f3081e;

                        {
                            Cursor cursor = getCursor();
                            this.f3080d = cursor.getColumnIndexOrThrow(C0532a.this.f3044L);
                            this.f3081e = cursor.getColumnIndexOrThrow(C0532a.this.f3045M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.f3080d));
                            recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f3081e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return C0532a.this.f3050b.inflate(alertController.f3004m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.f3040H) {
                    i = alertController.f3005n;
                } else {
                    i = alertController.f3006o;
                }
                int i2 = i;
                if (this.f3043K != null) {
                    c0534c = new SimpleCursorAdapter(this.f3049a, i2, this.f3043K, new String[]{this.f3044L}, new int[]{android.R.id.text1});
                } else if (this.f3071w != null) {
                    c0534c = this.f3071w;
                } else {
                    c0534c = new C0534c(this.f3049a, i2, android.R.id.text1, this.f3070v);
                }
            }
            if (this.f3047O != null) {
                this.f3047O.m3184a(recycleListView);
            }
            alertController.f3001j = c0534c;
            alertController.f3002k = this.f3041I;
            if (this.f3072x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.a.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        C0532a.this.f3072x.onClick(alertController.f2992a, i3);
                        if (C0532a.this.f3040H) {
                            return;
                        }
                        alertController.f2992a.dismiss();
                    }
                });
            } else if (this.f3042J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.a.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        if (C0532a.this.f3038F != null) {
                            C0532a.this.f3038F[i3] = recycleListView.isItemChecked(i3);
                        }
                        C0532a.this.f3042J.onClick(alertController.f2992a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            if (this.f3046N != null) {
                recycleListView.setOnItemSelectedListener(this.f3046N);
            }
            if (this.f3040H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f3039G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2993b = recycleListView;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$c */
    static class C0534c extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public C0534c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
