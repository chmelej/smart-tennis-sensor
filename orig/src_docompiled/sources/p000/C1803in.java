package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import cn.jzvd.JZVideoPlayer;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: renamed from: in */
/* JADX INFO: compiled from: JZUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1803in {
    /* JADX INFO: renamed from: a */
    public static String m9803a(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        int i = (int) (j2 % 60);
        int i2 = (int) ((j2 / 60) % 60);
        int i3 = (int) (j2 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i)).toString();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m9806a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    /* JADX INFO: renamed from: b */
    public static Activity m9808b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m9808b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static AppCompatActivity m9810c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof C1696eo) {
            return m9810c(((C1696eo) context).getBaseContext());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static void m9804a(Context context, int i) {
        if (m9810c(context) != null) {
            m9810c(context).setRequestedOrientation(i);
        } else {
            m9808b(context).setRequestedOrientation(i);
        }
    }

    /* JADX INFO: renamed from: d */
    public static Window m9811d(Context context) {
        if (m9810c(context) != null) {
            return m9810c(context).getWindow();
        }
        return m9808b(context).getWindow();
    }

    /* JADX INFO: renamed from: a */
    public static void m9805a(Context context, Object obj, long j) {
        if (JZVideoPlayer.f5393e) {
            Log.i("JiaoZiVideoPlayer", "saveProgress: " + j);
            if (j < 5000) {
                j = 0;
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("JZVD_PROGRESS", 0).edit();
            editorEdit.putLong("newVersion:" + obj.toString(), j);
            editorEdit.apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public static long m9800a(Context context, Object obj) {
        if (!JZVideoPlayer.f5393e) {
            return 0L;
        }
        return context.getSharedPreferences("JZVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
    }

    /* JADX INFO: renamed from: a */
    public static Object m9802a(Object[] objArr, int i) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) objArr[0];
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return m9801a((LinkedHashMap<String, Object>) linkedHashMap, i);
    }

    /* JADX INFO: renamed from: a */
    public static Object m9801a(LinkedHashMap<String, Object> linkedHashMap, int i) {
        int i2 = 0;
        for (String str : linkedHashMap.keySet()) {
            if (i2 == i) {
                return linkedHashMap.get(str);
            }
            i2++;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m9807a(Object[] objArr, Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) objArr[0];
        if (linkedHashMap != null) {
            return linkedHashMap.containsValue(obj);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static String m9809b(Object[] objArr, int i) {
        int i2 = 0;
        for (Object obj : ((LinkedHashMap) objArr[0]).keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }
}
