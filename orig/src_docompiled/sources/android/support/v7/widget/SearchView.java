package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p000.C1766hd;
import p000.C1768hf;
import p000.C1774hl;
import p000.InterfaceC1695en;
import p000.ViewOnClickListenerC1759gx;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements InterfaceC1695en {

    /* JADX INFO: renamed from: i */
    static final C0642a f3869i = new C0642a();

    /* JADX INFO: renamed from: A */
    private InterfaceC0644c f3870A;

    /* JADX INFO: renamed from: B */
    private InterfaceC0643b f3871B;

    /* JADX INFO: renamed from: C */
    private InterfaceC0645d f3872C;

    /* JADX INFO: renamed from: D */
    private View.OnClickListener f3873D;

    /* JADX INFO: renamed from: E */
    private boolean f3874E;

    /* JADX INFO: renamed from: F */
    private boolean f3875F;

    /* JADX INFO: renamed from: G */
    private boolean f3876G;

    /* JADX INFO: renamed from: H */
    private CharSequence f3877H;

    /* JADX INFO: renamed from: I */
    private boolean f3878I;

    /* JADX INFO: renamed from: J */
    private boolean f3879J;

    /* JADX INFO: renamed from: K */
    private int f3880K;

    /* JADX INFO: renamed from: L */
    private boolean f3881L;

    /* JADX INFO: renamed from: M */
    private CharSequence f3882M;

    /* JADX INFO: renamed from: N */
    private CharSequence f3883N;

    /* JADX INFO: renamed from: O */
    private boolean f3884O;

    /* JADX INFO: renamed from: P */
    private int f3885P;

    /* JADX INFO: renamed from: Q */
    private Bundle f3886Q;

    /* JADX INFO: renamed from: R */
    private final Runnable f3887R;

    /* JADX INFO: renamed from: S */
    private Runnable f3888S;

    /* JADX INFO: renamed from: T */
    private final WeakHashMap<String, Drawable.ConstantState> f3889T;

    /* JADX INFO: renamed from: U */
    private final View.OnClickListener f3890U;

    /* JADX INFO: renamed from: V */
    private final TextView.OnEditorActionListener f3891V;

    /* JADX INFO: renamed from: W */
    private final AdapterView.OnItemClickListener f3892W;

    /* JADX INFO: renamed from: a */
    final SearchAutoComplete f3893a;

    /* JADX INFO: renamed from: aa */
    private final AdapterView.OnItemSelectedListener f3894aa;

    /* JADX INFO: renamed from: ab */
    private TextWatcher f3895ab;

    /* JADX INFO: renamed from: b */
    final ImageView f3896b;

    /* JADX INFO: renamed from: c */
    final ImageView f3897c;

    /* JADX INFO: renamed from: d */
    final ImageView f3898d;

    /* JADX INFO: renamed from: e */
    final ImageView f3899e;

    /* JADX INFO: renamed from: f */
    View.OnFocusChangeListener f3900f;

    /* JADX INFO: renamed from: g */
    CursorAdapter f3901g;

    /* JADX INFO: renamed from: h */
    SearchableInfo f3902h;

    /* JADX INFO: renamed from: j */
    View.OnKeyListener f3903j;

    /* JADX INFO: renamed from: k */
    private final View f3904k;

    /* JADX INFO: renamed from: l */
    private final View f3905l;

    /* JADX INFO: renamed from: m */
    private final View f3906m;

    /* JADX INFO: renamed from: n */
    private final View f3907n;

    /* JADX INFO: renamed from: o */
    private C0646e f3908o;

    /* JADX INFO: renamed from: p */
    private Rect f3909p;

    /* JADX INFO: renamed from: q */
    private Rect f3910q;

    /* JADX INFO: renamed from: r */
    private int[] f3911r;

    /* JADX INFO: renamed from: s */
    private int[] f3912s;

    /* JADX INFO: renamed from: t */
    private final ImageView f3913t;

    /* JADX INFO: renamed from: u */
    private final Drawable f3914u;

    /* JADX INFO: renamed from: v */
    private final int f3915v;

    /* JADX INFO: renamed from: w */
    private final int f3916w;

    /* JADX INFO: renamed from: x */
    private final Intent f3917x;

    /* JADX INFO: renamed from: y */
    private final Intent f3918y;

    /* JADX INFO: renamed from: z */
    private final CharSequence f3919z;

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$b */
    public interface InterfaceC0643b {
        /* JADX INFO: renamed from: a */
        boolean m4214a();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$c */
    public interface InterfaceC0644c {
        /* JADX INFO: renamed from: a */
        boolean m4215a(String str);

        /* JADX INFO: renamed from: b */
        boolean m4216b(String str);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$d */
    public interface InterfaceC0645d {
        /* JADX INFO: renamed from: a */
        boolean m4217a(int i);

        /* JADX INFO: renamed from: b */
        boolean m4218b(int i);
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3909p = new Rect();
        this.f3910q = new Rect();
        this.f3911r = new int[2];
        this.f3912s = new int[2];
        this.f3887R = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.m4198d();
            }
        };
        this.f3888S = new Runnable() { // from class: android.support.v7.widget.SearchView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.f3901g == null || !(SearchView.this.f3901g instanceof ViewOnClickListenerC1759gx)) {
                    return;
                }
                SearchView.this.f3901g.changeCursor(null);
            }
        };
        this.f3889T = new WeakHashMap<>();
        this.f3890U = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.f3896b) {
                    SearchView.this.m4201g();
                    return;
                }
                if (view == SearchView.this.f3898d) {
                    SearchView.this.m4200f();
                    return;
                }
                if (view == SearchView.this.f3897c) {
                    SearchView.this.m4199e();
                } else if (view == SearchView.this.f3899e) {
                    SearchView.this.m4202h();
                } else if (view == SearchView.this.f3893a) {
                    SearchView.this.m4205l();
                }
            }
        };
        this.f3903j = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.f3902h == null) {
                    return false;
                }
                if (SearchView.this.f3893a.isPopupShowing() && SearchView.this.f3893a.getListSelection() != -1) {
                    return SearchView.this.m4194a(view, i2, keyEvent);
                }
                if (SearchView.this.f3893a.m4209a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.m4190a(0, (String) null, SearchView.this.f3893a.getText().toString());
                return true;
            }
        };
        this.f3891V = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.m4199e();
                return true;
            }
        };
        this.f3892W = new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m4193a(i2, 0, (String) null);
            }
        };
        this.f3894aa = new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m4192a(i2);
            }
        };
        this.f3895ab = new TextWatcher() { // from class: android.support.v7.widget.SearchView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.m4196b(charSequence);
            }
        };
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(c1766hdM9601a.m9619g(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        this.f3893a = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f3893a.setSearchView(this);
        this.f3904k = findViewById(R.id.search_edit_frame);
        this.f3905l = findViewById(R.id.search_plate);
        this.f3906m = findViewById(R.id.submit_area);
        this.f3896b = (ImageView) findViewById(R.id.search_button);
        this.f3897c = (ImageView) findViewById(R.id.search_go_btn);
        this.f3898d = (ImageView) findViewById(R.id.search_close_btn);
        this.f3899e = (ImageView) findViewById(R.id.search_voice_btn);
        this.f3913t = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.setBackground(this.f3905l, c1766hdM9601a.m9605a(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.f3906m, c1766hdM9601a.m9605a(R.styleable.SearchView_submitBackground));
        this.f3896b.setImageDrawable(c1766hdM9601a.m9605a(R.styleable.SearchView_searchIcon));
        this.f3897c.setImageDrawable(c1766hdM9601a.m9605a(R.styleable.SearchView_goIcon));
        this.f3898d.setImageDrawable(c1766hdM9601a.m9605a(R.styleable.SearchView_closeIcon));
        this.f3899e.setImageDrawable(c1766hdM9601a.m9605a(R.styleable.SearchView_voiceIcon));
        this.f3913t.setImageDrawable(c1766hdM9601a.m9605a(R.styleable.SearchView_searchIcon));
        this.f3914u = c1766hdM9601a.m9605a(R.styleable.SearchView_searchHintIcon);
        C1768hf.m9634a(this.f3896b, getResources().getString(R.string.abc_searchview_description_search));
        this.f3915v = c1766hdM9601a.m9619g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f3916w = c1766hdM9601a.m9619g(R.styleable.SearchView_commitIcon, 0);
        this.f3896b.setOnClickListener(this.f3890U);
        this.f3898d.setOnClickListener(this.f3890U);
        this.f3897c.setOnClickListener(this.f3890U);
        this.f3899e.setOnClickListener(this.f3890U);
        this.f3893a.setOnClickListener(this.f3890U);
        this.f3893a.addTextChangedListener(this.f3895ab);
        this.f3893a.setOnEditorActionListener(this.f3891V);
        this.f3893a.setOnItemClickListener(this.f3892W);
        this.f3893a.setOnItemSelectedListener(this.f3894aa);
        this.f3893a.setOnKeyListener(this.f3903j);
        this.f3893a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f3900f != null) {
                    SearchView.this.f3900f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(c1766hdM9601a.m9607a(R.styleable.SearchView_iconifiedByDefault, true));
        int iM9615e = c1766hdM9601a.m9615e(R.styleable.SearchView_android_maxWidth, -1);
        if (iM9615e != -1) {
            setMaxWidth(iM9615e);
        }
        this.f3919z = c1766hdM9601a.m9612c(R.styleable.SearchView_defaultQueryHint);
        this.f3877H = c1766hdM9601a.m9612c(R.styleable.SearchView_queryHint);
        int iM9603a = c1766hdM9601a.m9603a(R.styleable.SearchView_android_imeOptions, -1);
        if (iM9603a != -1) {
            setImeOptions(iM9603a);
        }
        int iM9603a2 = c1766hdM9601a.m9603a(R.styleable.SearchView_android_inputType, -1);
        if (iM9603a2 != -1) {
            setInputType(iM9603a2);
        }
        setFocusable(c1766hdM9601a.m9607a(R.styleable.SearchView_android_focusable, true));
        c1766hdM9601a.m9606a();
        this.f3917x = new Intent("android.speech.action.WEB_SEARCH");
        this.f3917x.addFlags(268435456);
        this.f3917x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f3918y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f3918y.addFlags(268435456);
        this.f3907n = findViewById(this.f3893a.getDropDownAnchor());
        if (this.f3907n != null) {
            this.f3907n.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.m4204k();
                }
            });
        }
        m4173a(this.f3874E);
        m4186r();
    }

    public int getSuggestionRowLayout() {
        return this.f3915v;
    }

    public int getSuggestionCommitIconResId() {
        return this.f3916w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f3902h = searchableInfo;
        if (this.f3902h != null) {
            m4187s();
            m4186r();
        }
        this.f3881L = m4181m();
        if (this.f3881L) {
            this.f3893a.setPrivateImeOptions("nm");
        }
        m4173a(m4197c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f3886Q = bundle;
    }

    public void setImeOptions(int i) {
        this.f3893a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f3893a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f3893a.setInputType(i);
    }

    public int getInputType() {
        return this.f3893a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f3879J || !isFocusable()) {
            return false;
        }
        if (!m4197c()) {
            boolean zRequestFocus = this.f3893a.requestFocus(i, rect);
            if (zRequestFocus) {
                m4173a(false);
            }
            return zRequestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f3879J = true;
        super.clearFocus();
        this.f3893a.clearFocus();
        this.f3893a.setImeVisibility(false);
        this.f3879J = false;
    }

    public void setOnQueryTextListener(InterfaceC0644c interfaceC0644c) {
        this.f3870A = interfaceC0644c;
    }

    public void setOnCloseListener(InterfaceC0643b interfaceC0643b) {
        this.f3871B = interfaceC0643b;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f3900f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(InterfaceC0645d interfaceC0645d) {
        this.f3872C = interfaceC0645d;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f3873D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f3893a.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f3893a.setText(charSequence);
        if (charSequence != null) {
            this.f3893a.setSelection(this.f3893a.length());
            this.f3883N = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m4199e();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f3877H = charSequence;
        m4186r();
    }

    public CharSequence getQueryHint() {
        if (this.f3877H != null) {
            return this.f3877H;
        }
        if (this.f3902h != null && this.f3902h.getHintId() != 0) {
            return getContext().getText(this.f3902h.getHintId());
        }
        return this.f3919z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f3874E == z) {
            return;
        }
        this.f3874E = z;
        m4173a(z);
        m4186r();
    }

    public void setIconified(boolean z) {
        if (z) {
            m4200f();
        } else {
            m4201g();
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m4197c() {
        return this.f3875F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f3876G = z;
        m4173a(m4197c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f3878I = z;
        if (this.f3901g instanceof ViewOnClickListenerC1759gx) {
            ((ViewOnClickListenerC1759gx) this.f3901g).m9584a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f3901g = cursorAdapter;
        this.f3893a.setAdapter(this.f3901g);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f3901g;
    }

    public void setMaxWidth(int i) {
        this.f3880K = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f3880K;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        if (m4197c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = this.f3880K > 0 ? Math.min(this.f3880K, size) : Math.min(getPreferredWidth(), size);
        } else if (mode != 0) {
            if (mode == 1073741824 && this.f3880K > 0) {
                size = Math.min(this.f3880K, size);
            }
        } else {
            size = this.f3880K > 0 ? this.f3880K : getPreferredWidth();
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m4172a(this.f3893a, this.f3909p);
            this.f3910q.set(this.f3909p.left, 0, this.f3909p.right, i4 - i2);
            if (this.f3908o == null) {
                this.f3908o = new C0646e(this.f3910q, this.f3909p, this.f3893a);
                setTouchDelegate(this.f3908o);
            } else {
                this.f3908o.m4219a(this.f3910q, this.f3909p);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4172a(View view, Rect rect) {
        view.getLocationInWindow(this.f3911r);
        getLocationInWindow(this.f3912s);
        int i = this.f3911r[1] - this.f3912s[1];
        int i2 = this.f3911r[0] - this.f3912s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    /* JADX INFO: renamed from: a */
    private void m4173a(boolean z) {
        this.f3875F = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f3893a.getText());
        this.f3896b.setVisibility(i2);
        m4176b(z2);
        this.f3904k.setVisibility(z ? 8 : 0);
        if (this.f3913t.getDrawable() != null && !this.f3874E) {
            i = 0;
        }
        this.f3913t.setVisibility(i);
        m4184p();
        m4179c(z2 ? false : true);
        m4183o();
    }

    /* JADX INFO: renamed from: m */
    private boolean m4181m() {
        if (this.f3902h != null && this.f3902h.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.f3902h.getVoiceSearchLaunchWebSearch()) {
                intent = this.f3917x;
            } else if (this.f3902h.getVoiceSearchLaunchRecognizer()) {
                intent = this.f3918y;
            }
            return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
        }
        return false;
    }

    /* JADX INFO: renamed from: n */
    private boolean m4182n() {
        return (this.f3876G || this.f3881L) && !m4197c();
    }

    /* JADX INFO: renamed from: b */
    private void m4176b(boolean z) {
        this.f3897c.setVisibility((this.f3876G && m4182n() && hasFocus() && (z || !this.f3881L)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: o */
    private void m4183o() {
        this.f3906m.setVisibility((m4182n() && (this.f3897c.getVisibility() == 0 || this.f3899e.getVisibility() == 0)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: p */
    private void m4184p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f3893a.getText());
        if (!z2 && (!this.f3874E || this.f3884O)) {
            z = false;
        }
        this.f3898d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f3898d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4185q() {
        post(this.f3887R);
    }

    /* JADX INFO: renamed from: d */
    void m4198d() {
        int[] iArr = this.f3893a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f3905l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f3906m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3887R);
        post(this.f3888S);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: renamed from: a */
    public void m4191a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* JADX INFO: renamed from: a */
    boolean m4194a(View view, int i, KeyEvent keyEvent) {
        if (this.f3902h != null && this.f3901g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return m4193a(this.f3893a.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.f3893a.setSelection(i == 21 ? 0 : this.f3893a.length());
                this.f3893a.setListSelection(0);
                this.f3893a.clearListSelection();
                f3869i.m4212a(this.f3893a, true);
                return true;
            }
            if (i != 19 || this.f3893a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private CharSequence m4178c(CharSequence charSequence) {
        if (!this.f3874E || this.f3914u == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f3893a.getTextSize()) * 1.25d);
        this.f3914u.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f3914u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: r */
    private void m4186r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f3893a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m4178c(queryHint));
    }

    /* JADX INFO: renamed from: s */
    private void m4187s() {
        this.f3893a.setThreshold(this.f3902h.getSuggestThreshold());
        this.f3893a.setImeOptions(this.f3902h.getImeOptions());
        int inputType = this.f3902h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f3902h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f3893a.setInputType(inputType);
        if (this.f3901g != null) {
            this.f3901g.changeCursor(null);
        }
        if (this.f3902h.getSuggestAuthority() != null) {
            this.f3901g = new ViewOnClickListenerC1759gx(getContext(), this, this.f3902h, this.f3889T);
            this.f3893a.setAdapter(this.f3901g);
            ((ViewOnClickListenerC1759gx) this.f3901g).m9584a(this.f3878I ? 2 : 1);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4179c(boolean z) {
        int i;
        if (this.f3881L && !m4197c() && z) {
            i = 0;
            this.f3897c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f3899e.setVisibility(i);
    }

    /* JADX INFO: renamed from: b */
    void m4196b(CharSequence charSequence) {
        Editable text = this.f3893a.getText();
        this.f3883N = text;
        boolean z = !TextUtils.isEmpty(text);
        m4176b(z);
        m4179c(z ? false : true);
        m4184p();
        m4183o();
        if (this.f3870A != null && !TextUtils.equals(charSequence, this.f3882M)) {
            this.f3870A.m4216b(charSequence.toString());
        }
        this.f3882M = charSequence.toString();
    }

    /* JADX INFO: renamed from: e */
    void m4199e() {
        Editable text = this.f3893a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f3870A == null || !this.f3870A.m4215a(text.toString())) {
            if (this.f3902h != null) {
                m4190a(0, (String) null, text.toString());
            }
            this.f3893a.setImeVisibility(false);
            m4188t();
        }
    }

    /* JADX INFO: renamed from: t */
    private void m4188t() {
        this.f3893a.dismissDropDown();
    }

    /* JADX INFO: renamed from: f */
    void m4200f() {
        if (TextUtils.isEmpty(this.f3893a.getText())) {
            if (this.f3874E) {
                if (this.f3871B == null || !this.f3871B.m4214a()) {
                    clearFocus();
                    m4173a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f3893a.setText("");
        this.f3893a.requestFocus();
        this.f3893a.setImeVisibility(true);
    }

    /* JADX INFO: renamed from: g */
    void m4201g() {
        m4173a(false);
        this.f3893a.requestFocus();
        this.f3893a.setImeVisibility(true);
        if (this.f3873D != null) {
            this.f3873D.onClick(this);
        }
    }

    /* JADX INFO: renamed from: h */
    void m4202h() {
        if (this.f3902h == null) {
            return;
        }
        SearchableInfo searchableInfo = this.f3902h;
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m4168a(this.f3917x, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m4175b(this.f3918y, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* JADX INFO: renamed from: i */
    void m4203i() {
        m4173a(m4197c());
        m4185q();
        if (this.f3893a.hasFocus()) {
            m4205l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m4185q();
    }

    @Override // p000.InterfaceC1695en
    /* JADX INFO: renamed from: b */
    public void mo4195b() {
        setQuery("", false);
        clearFocus();
        m4173a(true);
        this.f3893a.setImeOptions(this.f3885P);
        this.f3884O = false;
    }

    @Override // p000.InterfaceC1695en
    /* JADX INFO: renamed from: a */
    public void mo4189a() {
        if (this.f3884O) {
            return;
        }
        this.f3884O = true;
        this.f3885P = this.f3893a.getImeOptions();
        this.f3893a.setImeOptions(this.f3885P | 33554432);
        this.f3893a.setText("");
        setIconified(false);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        boolean f3930a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3930a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f3930a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f3930a + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3930a = m4197c();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m4173a(savedState.f3930a);
        requestLayout();
    }

    /* JADX INFO: renamed from: k */
    void m4204k() {
        int i;
        if (this.f3907n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f3905l.getPaddingLeft();
            Rect rect = new Rect();
            boolean zM9679a = C1774hl.m9679a(this);
            int dimensionPixelSize = this.f3874E ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f3893a.getDropDownBackground().getPadding(rect);
            if (zM9679a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f3893a.setDropDownHorizontalOffset(i);
            this.f3893a.setDropDownWidth((((this.f3907n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m4193a(int i, int i2, String str) {
        if (this.f3872C != null && this.f3872C.m4218b(i)) {
            return false;
        }
        m4177b(i, 0, null);
        this.f3893a.setImeVisibility(false);
        m4188t();
        return true;
    }

    /* JADX INFO: renamed from: a */
    boolean m4192a(int i) {
        if (this.f3872C != null && this.f3872C.m4217a(i)) {
            return false;
        }
        m4180e(i);
        return true;
    }

    /* JADX INFO: renamed from: e */
    private void m4180e(int i) {
        Editable text = this.f3893a.getText();
        Cursor cursor = this.f3901g.getCursor();
        if (cursor == null) {
            return;
        }
        if (cursor.moveToPosition(i)) {
            CharSequence charSequenceConvertToString = this.f3901g.convertToString(cursor);
            if (charSequenceConvertToString != null) {
                setQuery(charSequenceConvertToString);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    /* JADX INFO: renamed from: b */
    private boolean m4177b(int i, int i2, String str) {
        Cursor cursor = this.f3901g.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        m4171a(m4169a(cursor, i2, str));
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m4171a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e("SearchView", "Failed launch activity: " + intent, e);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f3893a.setText(charSequence);
        this.f3893a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* JADX INFO: renamed from: a */
    void m4190a(int i, String str, String str2) {
        getContext().startActivity(m4170a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* JADX INFO: renamed from: a */
    private Intent m4170a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f3883N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f3886Q != null) {
            intent.putExtra("app_data", this.f3886Q);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f3902h.getSearchActivity());
        return intent;
    }

    /* JADX INFO: renamed from: a */
    private Intent m4168a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* JADX INFO: renamed from: b */
    private Intent m4175b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.f3886Q != null) {
            bundle.putParcelable("app_data", this.f3886Q);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* JADX INFO: renamed from: a */
    private Intent m4169a(Cursor cursor, int i, String str) {
        int position;
        String strM9571a;
        try {
            String strM9571a2 = ViewOnClickListenerC1759gx.m9571a(cursor, "suggest_intent_action");
            if (strM9571a2 == null) {
                strM9571a2 = this.f3902h.getSuggestIntentAction();
            }
            if (strM9571a2 == null) {
                strM9571a2 = "android.intent.action.SEARCH";
            }
            String str2 = strM9571a2;
            String strM9571a3 = ViewOnClickListenerC1759gx.m9571a(cursor, "suggest_intent_data");
            if (strM9571a3 == null) {
                strM9571a3 = this.f3902h.getSuggestIntentData();
            }
            if (strM9571a3 != null && (strM9571a = ViewOnClickListenerC1759gx.m9571a(cursor, "suggest_intent_data_id")) != null) {
                strM9571a3 = strM9571a3 + "/" + Uri.encode(strM9571a);
            }
            return m4170a(str2, strM9571a3 == null ? null : Uri.parse(strM9571a3), ViewOnClickListenerC1759gx.m9571a(cursor, "suggest_intent_extra_data"), ViewOnClickListenerC1759gx.m9571a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: l */
    void m4205l() {
        f3869i.m4211a(this.f3893a);
        f3869i.m4213b(this.f3893a);
    }

    /* JADX INFO: renamed from: a */
    static boolean m4174a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$e */
    static class C0646e extends TouchDelegate {

        /* JADX INFO: renamed from: a */
        private final View f3939a;

        /* JADX INFO: renamed from: b */
        private final Rect f3940b;

        /* JADX INFO: renamed from: c */
        private final Rect f3941c;

        /* JADX INFO: renamed from: d */
        private final Rect f3942d;

        /* JADX INFO: renamed from: e */
        private final int f3943e;

        /* JADX INFO: renamed from: f */
        private boolean f3944f;

        public C0646e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f3943e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f3940b = new Rect();
            this.f3942d = new Rect();
            this.f3941c = new Rect();
            m4219a(rect, rect2);
            this.f3939a = view;
        }

        /* JADX INFO: renamed from: a */
        public void m4219a(Rect rect, Rect rect2) {
            this.f3940b.set(rect);
            this.f3942d.set(rect);
            this.f3942d.inset(-this.f3943e, -this.f3943e);
            this.f3941c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                float r0 = r7.getX()
                int r0 = (int) r0
                float r1 = r7.getY()
                int r1 = (int) r1
                int r2 = r7.getAction()
                r3 = 1
                r4 = 0
                switch(r2) {
                    case 0: goto L27;
                    case 1: goto L19;
                    case 2: goto L19;
                    case 3: goto L14;
                    default: goto L13;
                }
            L13:
                goto L33
            L14:
                boolean r2 = r6.f3944f
                r6.f3944f = r4
                goto L34
            L19:
                boolean r2 = r6.f3944f
                if (r2 == 0) goto L34
                android.graphics.Rect r5 = r6.f3942d
                boolean r5 = r5.contains(r0, r1)
                if (r5 != 0) goto L34
                r3 = 0
                goto L34
            L27:
                android.graphics.Rect r2 = r6.f3940b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L33
                r6.f3944f = r3
                r2 = 1
                goto L34
            L33:
                r2 = 0
            L34:
                if (r2 == 0) goto L6b
                if (r3 == 0) goto L56
                android.graphics.Rect r2 = r6.f3941c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L56
                android.view.View r0 = r6.f3939a
                int r0 = r0.getWidth()
                int r0 = r0 / 2
                float r0 = (float) r0
                android.view.View r1 = r6.f3939a
                int r1 = r1.getHeight()
                int r1 = r1 / 2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
                goto L65
            L56:
                android.graphics.Rect r2 = r6.f3941c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r6.f3941c
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
            L65:
                android.view.View r0 = r6.f3939a
                boolean r4 = r0.dispatchTouchEvent(r7)
            L6b:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.C0646e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: a */
        final Runnable f3931a;

        /* JADX INFO: renamed from: b */
        private int f3932b;

        /* JADX INFO: renamed from: c */
        private SearchView f3933c;

        /* JADX INFO: renamed from: d */
        private boolean f3934d;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f3931a = new Runnable() { // from class: android.support.v7.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.m4210b();
                }
            };
            this.f3932b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f3933c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f3932b = i;
        }

        /* JADX INFO: renamed from: a */
        boolean m4209a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f3933c.hasFocus() && getVisibility() == 0) {
                this.f3934d = true;
                if (SearchView.m4174a(getContext())) {
                    SearchView.f3869i.m4212a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f3933c.m4203i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f3932b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f3933c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        @Override // android.support.v7.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f3934d) {
                removeCallbacks(this.f3931a);
                post(this.f3931a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        /* JADX INFO: renamed from: b */
        void m4210b() {
            if (this.f3934d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f3934d = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f3934d = false;
                removeCallbacks(this.f3931a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f3934d = false;
                    removeCallbacks(this.f3931a);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f3934d = true;
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$a */
    static class C0642a {

        /* JADX INFO: renamed from: a */
        private Method f3936a;

        /* JADX INFO: renamed from: b */
        private Method f3937b;

        /* JADX INFO: renamed from: c */
        private Method f3938c;

        C0642a() {
            try {
                this.f3936a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f3936a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f3937b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f3937b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f3938c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f3938c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* JADX INFO: renamed from: a */
        void m4211a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f3936a != null) {
                try {
                    this.f3936a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4213b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f3937b != null) {
                try {
                    this.f3937b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4212a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f3938c != null) {
                try {
                    this.f3938c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }
}
