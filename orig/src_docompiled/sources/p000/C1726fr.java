package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: fr */
/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1726fr {

    /* JADX INFO: renamed from: b */
    private static C1726fr f9855b;

    /* JADX INFO: renamed from: j */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f9863j;

    /* JADX INFO: renamed from: k */
    private ArrayMap<String, d> f9864k;

    /* JADX INFO: renamed from: l */
    private SparseArrayCompat<String> f9865l;

    /* JADX INFO: renamed from: m */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f9866m = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: n */
    private TypedValue f9867n;

    /* JADX INFO: renamed from: o */
    private boolean f9868o;

    /* JADX INFO: renamed from: a */
    private static final PorterDuff.Mode f9854a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    private static final c f9856c = new c(6);

    /* JADX INFO: renamed from: d */
    private static final int[] f9857d = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* JADX INFO: renamed from: e */
    private static final int[] f9858e = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* JADX INFO: renamed from: f */
    private static final int[] f9859f = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

    /* JADX INFO: renamed from: g */
    private static final int[] f9860g = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* JADX INFO: renamed from: h */
    private static final int[] f9861h = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* JADX INFO: renamed from: i */
    private static final int[] f9862i = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* JADX INFO: renamed from: fr$d */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    interface d {
        /* JADX INFO: renamed from: a */
        Drawable mo9261a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C1726fr m9237a() {
        if (f9855b == null) {
            f9855b = new C1726fr();
            m9241a(f9855b);
        }
        return f9855b;
    }

    /* JADX INFO: renamed from: a */
    private static void m9241a(C1726fr c1726fr) {
        if (Build.VERSION.SDK_INT < 24) {
            c1726fr.m9242a("vector", new e());
            c1726fr.m9242a("animated-vector", new b());
            c1726fr.m9242a("animated-selector", new a());
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized Drawable m9256a(Context context, int i) {
        return m9257a(context, i, false);
    }

    /* JADX INFO: renamed from: a */
    synchronized Drawable m9257a(Context context, int i, boolean z) {
        Drawable drawableM9251d;
        m9255f(context);
        drawableM9251d = m9251d(context, i);
        if (drawableM9251d == null) {
            drawableM9251d = m9249c(context, i);
        }
        if (drawableM9251d == null) {
            drawableM9251d = ContextCompat.getDrawable(context, i);
        }
        if (drawableM9251d != null) {
            drawableM9251d = m9235a(context, i, z, drawableM9251d);
        }
        if (drawableM9251d != null) {
            C1743gh.m9427b(drawableM9251d);
        }
        return drawableM9251d;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m9259a(Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f9866m.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    private static long m9231a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* JADX INFO: renamed from: c */
    private Drawable m9249c(Context context, int i) {
        if (this.f9867n == null) {
            this.f9867n = new TypedValue();
        }
        TypedValue typedValue = this.f9867n;
        context.getResources().getValue(i, typedValue, true);
        long jM9231a = m9231a(typedValue);
        Drawable drawableM9236a = m9236a(context, jM9231a);
        if (drawableM9236a != null) {
            return drawableM9236a;
        }
        if (i == R.drawable.abc_cab_background_top_material) {
            drawableM9236a = new LayerDrawable(new Drawable[]{m9256a(context, R.drawable.abc_cab_background_internal_bg), m9256a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawableM9236a != null) {
            drawableM9236a.setChangingConfigurations(typedValue.changingConfigurations);
            m9244a(context, jM9231a, drawableM9236a);
        }
        return drawableM9236a;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m9235a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListM9260b = m9260b(context, i);
        if (colorStateListM9260b != null) {
            if (C1743gh.m9428c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(drawableWrap, colorStateListM9260b);
            PorterDuff.Mode modeM9232a = m9232a(i);
            if (modeM9232a == null) {
                return drawableWrap;
            }
            DrawableCompat.setTintMode(drawableWrap, modeM9232a);
            return drawableWrap;
        }
        if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m9239a(layerDrawable.findDrawableByLayerId(android.R.id.background), C1760gy.m9585a(context, R.attr.colorControlNormal), f9854a);
            m9239a(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), C1760gy.m9585a(context, R.attr.colorControlNormal), f9854a);
            m9239a(layerDrawable.findDrawableByLayerId(android.R.id.progress), C1760gy.m9585a(context, R.attr.colorControlActivated), f9854a);
            return drawable;
        }
        if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m9239a(layerDrawable2.findDrawableByLayerId(android.R.id.background), C1760gy.m9589c(context, R.attr.colorControlNormal), f9854a);
            m9239a(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), C1760gy.m9585a(context, R.attr.colorControlActivated), f9854a);
            m9239a(layerDrawable2.findDrawableByLayerId(android.R.id.progress), C1760gy.m9585a(context, R.attr.colorControlActivated), f9854a);
            return drawable;
        }
        if (m9243a(context, i, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    private Drawable m9251d(Context context, int i) {
        int next;
        if (this.f9864k == null || this.f9864k.isEmpty()) {
            return null;
        }
        if (this.f9865l != null) {
            String str = this.f9865l.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f9864k.get(str) == null)) {
                return null;
            }
        } else {
            this.f9865l = new SparseArrayCompat<>();
        }
        if (this.f9867n == null) {
            this.f9867n = new TypedValue();
        }
        TypedValue typedValue = this.f9867n;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jM9231a = m9231a(typedValue);
        Drawable drawableM9236a = m9236a(context, jM9231a);
        if (drawableM9236a != null) {
            return drawableM9236a;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f9865l.append(i, name);
                d dVar = this.f9864k.get(name);
                if (dVar != null) {
                    drawableM9236a = dVar.mo9261a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM9236a != null) {
                    drawableM9236a.setChangingConfigurations(typedValue.changingConfigurations);
                    m9244a(context, jM9231a, drawableM9236a);
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (drawableM9236a == null) {
            this.f9865l.append(i, "appcompat_skip_skip");
        }
        return drawableM9236a;
    }

    /* JADX INFO: renamed from: a */
    private synchronized Drawable m9236a(Context context, long j) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f9866m.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.delete(j);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private synchronized boolean m9244a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f9866m.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.f9866m.put(context, longSparseArray);
        }
        longSparseArray.put(j, new WeakReference<>(constantState));
        return true;
    }

    /* JADX INFO: renamed from: a */
    synchronized Drawable m9258a(Context context, C1771hi c1771hi, int i) {
        Drawable drawableM9251d = m9251d(context, i);
        if (drawableM9251d == null) {
            drawableM9251d = c1771hi.m9650a(i);
        }
        if (drawableM9251d == null) {
            return null;
        }
        return m9235a(context, i, false, drawableM9251d);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean m9243a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = p000.C1726fr.f9854a
            int[] r1 = p000.C1726fr.f9857d
            boolean r1 = m9246a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = android.support.v7.appcompat.R.attr.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = p000.C1726fr.f9859f
            boolean r1 = m9246a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = android.support.v7.appcompat.R.attr.colorControlActivated
            goto L12
        L20:
            int[] r1 = p000.C1726fr.f9860g
            boolean r1 = m9246a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = android.support.v7.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = android.support.v7.appcompat.R.drawable.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = p000.C1743gh.m9428c(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = p000.C1760gy.m9585a(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = m9233a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1726fr.m9243a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    /* JADX INFO: renamed from: a */
    private void m9242a(String str, d dVar) {
        if (this.f9864k == null) {
            this.f9864k = new ArrayMap<>();
        }
        this.f9864k.put(str, dVar);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9246a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static PorterDuff.Mode m9232a(int i) {
        if (i == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    synchronized ColorStateList m9260b(Context context, int i) {
        ColorStateList colorStateListM9253e;
        colorStateListM9253e = m9253e(context, i);
        if (colorStateListM9253e == null) {
            if (i == R.drawable.abc_edit_text_material) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                colorStateListM9253e = m9252e(context);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                colorStateListM9253e = m9247b(context);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                colorStateListM9253e = m9248c(context);
            } else if (i == R.drawable.abc_btn_colored_material) {
                colorStateListM9253e = m9250d(context);
            } else if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_spinner);
            } else if (m9246a(f9858e, i)) {
                colorStateListM9253e = C1760gy.m9588b(context, R.attr.colorControlNormal);
            } else if (m9246a(f9861h, i)) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_default);
            } else if (m9246a(f9862i, i)) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_btn_checkable);
            } else if (i == R.drawable.abc_seekbar_thumb_material) {
                colorStateListM9253e = C1684ee.m8972a(context, R.color.abc_tint_seek_thumb);
            }
            if (colorStateListM9253e != null) {
                m9238a(context, i, colorStateListM9253e);
            }
        }
        return colorStateListM9253e;
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m9253e(Context context, int i) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        if (this.f9863j == null || (sparseArrayCompat = this.f9863j.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i);
    }

    /* JADX INFO: renamed from: a */
    private void m9238a(Context context, int i, ColorStateList colorStateList) {
        if (this.f9863j == null) {
            this.f9863j = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f9863j.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f9863j.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i, colorStateList);
    }

    /* JADX INFO: renamed from: b */
    private ColorStateList m9247b(Context context) {
        return m9254f(context, C1760gy.m9585a(context, R.attr.colorButtonNormal));
    }

    /* JADX INFO: renamed from: c */
    private ColorStateList m9248c(Context context) {
        return m9254f(context, 0);
    }

    /* JADX INFO: renamed from: d */
    private ColorStateList m9250d(Context context) {
        return m9254f(context, C1760gy.m9585a(context, R.attr.colorAccent));
    }

    /* JADX INFO: renamed from: f */
    private ColorStateList m9254f(Context context, int i) {
        int iM9585a = C1760gy.m9585a(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{C1760gy.f10118a, C1760gy.f10121d, C1760gy.f10119b, C1760gy.f10125h}, new int[]{C1760gy.m9589c(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(iM9585a, i), ColorUtils.compositeColors(iM9585a, i), i});
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m9252e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM9588b = C1760gy.m9588b(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListM9588b != null && colorStateListM9588b.isStateful()) {
            iArr[0] = C1760gy.f10118a;
            iArr2[0] = colorStateListM9588b.getColorForState(iArr[0], 0);
            iArr[1] = C1760gy.f10122e;
            iArr2[1] = C1760gy.m9585a(context, R.attr.colorControlActivated);
            iArr[2] = C1760gy.f10125h;
            iArr2[2] = colorStateListM9588b.getDefaultColor();
        } else {
            iArr[0] = C1760gy.f10118a;
            iArr2[0] = C1760gy.m9589c(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = C1760gy.f10122e;
            iArr2[1] = C1760gy.m9585a(context, R.attr.colorControlActivated);
            iArr[2] = C1760gy.f10125h;
            iArr2[2] = C1760gy.m9585a(context, R.attr.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX INFO: renamed from: fr$c */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    static class c extends LruCache<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m9263a(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(m9262b(i, mode)));
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m9264a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(m9262b(i, mode)), porterDuffColorFilter);
        }

        /* JADX INFO: renamed from: b */
        private static int m9262b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9240a(Drawable drawable, C1764hb c1764hb, int[] iArr) {
        if (C1743gh.m9428c(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (c1764hb.f10141d || c1764hb.f10140c) {
            drawable.setColorFilter(m9234a(c1764hb.f10141d ? c1764hb.f10138a : null, c1764hb.f10140c ? c1764hb.f10139b : f9854a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuffColorFilter m9234a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m9233a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized PorterDuffColorFilter m9233a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM9263a;
        porterDuffColorFilterM9263a = f9856c.m9263a(i, mode);
        if (porterDuffColorFilterM9263a == null) {
            porterDuffColorFilterM9263a = new PorterDuffColorFilter(i, mode);
            f9856c.m9264a(i, mode, porterDuffColorFilterM9263a);
        }
        return porterDuffColorFilterM9263a;
    }

    /* JADX INFO: renamed from: a */
    private static void m9239a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (C1743gh.m9428c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f9854a;
        }
        drawable.setColorFilter(m9233a(i, mode));
    }

    /* JADX INFO: renamed from: f */
    private void m9255f(Context context) {
        if (this.f9868o) {
            return;
        }
        this.f9868o = true;
        Drawable drawableM9256a = m9256a(context, R.drawable.abc_vector_test);
        if (drawableM9256a == null || !m9245a(drawableM9256a)) {
            this.f9868o = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9245a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX INFO: renamed from: fr$e */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    static class e implements d {
        e() {
        }

        @Override // p000.C1726fr.d
        /* JADX INFO: renamed from: a */
        public Drawable mo9261a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.m2935a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: fr$b */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    static class b implements d {
        b() {
        }

        @Override // p000.C1726fr.d
        /* JADX INFO: renamed from: a */
        public Drawable mo9261a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.m2928a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: fr$a */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    static class a implements d {
        a() {
        }

        @Override // p000.C1726fr.d
        /* JADX INFO: renamed from: a */
        public Drawable mo9261a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C1685ef.m8979a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }
}
