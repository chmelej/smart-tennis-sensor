package p000;

import android.widget.Toast;
import com.coollang.tennis.base.MyApplication;

/* JADX INFO: renamed from: ml */
/* JADX INFO: compiled from: ToastUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1913ml {

    /* JADX INFO: renamed from: a */
    protected static Toast f11505a;

    /* JADX INFO: renamed from: b */
    private static String f11506b;

    /* JADX INFO: renamed from: c */
    private static long f11507c;

    /* JADX INFO: renamed from: d */
    private static long f11508d;

    /* JADX INFO: renamed from: a */
    public static void m10553a(String str) {
        if (f11505a == null) {
            f11505a = Toast.makeText(MyApplication.m7738a(), str, 0);
            f11505a.show();
            f11507c = System.currentTimeMillis();
        } else {
            f11508d = System.currentTimeMillis();
            if (!str.equals(f11506b)) {
                f11506b = str;
                f11505a.setText(str);
                f11505a.show();
            } else if (f11508d - f11507c > 0) {
                f11505a.show();
            }
        }
        f11507c = f11508d;
    }

    /* JADX INFO: renamed from: a */
    public static void m10552a(int i) {
        m10553a(C1914mm.m10557b(i));
    }
}
