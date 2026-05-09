package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ColorStateListInflaterCompat;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: ee */
/* JADX INFO: compiled from: AppCompatResources.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1684ee {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<TypedValue> f9516a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b */
    private static final WeakHashMap<Context, SparseArray<a>> f9517b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c */
    private static final Object f9518c = new Object();

    /* JADX INFO: renamed from: a */
    public static ColorStateList m8972a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListM8977d = m8977d(context, i);
        if (colorStateListM8977d != null) {
            return colorStateListM8977d;
        }
        ColorStateList colorStateListM8976c = m8976c(context, i);
        if (colorStateListM8976c != null) {
            m8974a(context, i, colorStateListM8976c);
            return colorStateListM8976c;
        }
        return ContextCompat.getColorStateList(context, i);
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m8975b(Context context, int i) {
        return C1726fr.m9237a().m9256a(context, i);
    }

    /* JADX INFO: renamed from: c */
    private static ColorStateList m8976c(Context context, int i) {
        if (m8978e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static ColorStateList m8977d(Context context, int i) {
        a aVar;
        synchronized (f9518c) {
            SparseArray<a> sparseArray = f9517b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.f9520b.equals(context.getResources().getConfiguration())) {
                    return aVar.f9519a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8974a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f9518c) {
            SparseArray<a> sparseArray = f9517b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f9517b.put(context, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* JADX INFO: renamed from: e */
    private static boolean m8978e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueM8973a = m8973a();
        resources.getValue(i, typedValueM8973a, true);
        return typedValueM8973a.type >= 28 && typedValueM8973a.type <= 31;
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m8973a() {
        TypedValue typedValue = f9516a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f9516a.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: ee$a */
    /* JADX INFO: compiled from: AppCompatResources.java */
    static class a {

        /* JADX INFO: renamed from: a */
        final ColorStateList f9519a;

        /* JADX INFO: renamed from: b */
        final Configuration f9520b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f9519a = colorStateList;
            this.f9520b = configuration;
        }
    }
}
