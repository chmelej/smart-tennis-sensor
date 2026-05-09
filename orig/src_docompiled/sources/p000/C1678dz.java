package p000;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: renamed from: dz */
/* JADX INFO: compiled from: ResourcesFlusher.java */
/* JADX INFO: loaded from: classes.dex */
public class C1678dz {

    /* JADX INFO: renamed from: a */
    private static Field f9430a;

    /* JADX INFO: renamed from: b */
    private static boolean f9431b;

    /* JADX INFO: renamed from: c */
    private static Class f9432c;

    /* JADX INFO: renamed from: d */
    private static boolean f9433d;

    /* JADX INFO: renamed from: e */
    private static Field f9434e;

    /* JADX INFO: renamed from: f */
    private static boolean f9435f;

    /* JADX INFO: renamed from: g */
    private static Field f9436g;

    /* JADX INFO: renamed from: h */
    private static boolean f9437h;

    /* JADX INFO: renamed from: a */
    public static void m8915a(Resources resources) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            m8919d(resources);
        } else if (Build.VERSION.SDK_INT >= 23) {
            m8918c(resources);
        } else if (Build.VERSION.SDK_INT >= 21) {
            m8917b(resources);
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m8917b(Resources resources) {
        Map map;
        if (!f9431b) {
            try {
                f9430a = Resources.class.getDeclaredField("mDrawableCache");
                f9430a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f9431b = true;
        }
        if (f9430a != null) {
            try {
                map = (Map) f9430a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m8918c(Resources resources) {
        Object obj;
        if (!f9431b) {
            try {
                f9430a = Resources.class.getDeclaredField("mDrawableCache");
                f9430a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f9431b = true;
        }
        if (f9430a != null) {
            try {
                obj = f9430a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        m8916a(obj);
    }

    /* JADX INFO: renamed from: d */
    private static void m8919d(Resources resources) {
        Object obj;
        Object obj2;
        if (!f9437h) {
            try {
                f9436g = Resources.class.getDeclaredField("mResourcesImpl");
                f9436g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f9437h = true;
        }
        if (f9436g == null) {
            return;
        }
        try {
            obj = f9436g.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f9431b) {
            try {
                f9430a = obj.getClass().getDeclaredField("mDrawableCache");
                f9430a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f9431b = true;
        }
        if (f9430a != null) {
            try {
                obj2 = f9430a.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            m8916a(obj2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8916a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f9433d) {
            try {
                f9432c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f9433d = true;
        }
        if (f9432c == null) {
            return;
        }
        if (!f9435f) {
            try {
                f9434e = f9432c.getDeclaredField("mUnthemedEntries");
                f9434e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f9435f = true;
        }
        if (f9434e == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) f9434e.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
