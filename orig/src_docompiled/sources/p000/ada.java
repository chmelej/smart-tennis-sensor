package p000;

import android.content.Context;

/* JADX INFO: compiled from: MobclickAgent.java */
/* JADX INFO: loaded from: classes.dex */
public class ada {
    /* JADX INFO: renamed from: a */
    public static void m301a(Context context) {
        adc.m304a().m313b(context);
    }

    /* JADX INFO: renamed from: b */
    public static void m302b(Context context) throws Throwable {
        if (context == null) {
            aex.m776c("unexpected null context in onResume");
        } else {
            adc.m304a().m311a(context);
        }
    }

    /* JADX INFO: renamed from: ada$a */
    /* JADX INFO: compiled from: MobclickAgent.java */
    public enum EnumC0007a {
        E_UM_NORMAL(0),
        E_UM_GAME(1),
        E_UM_ANALYTICS_OEM(224),
        E_UM_GAME_OEM(225);


        /* JADX INFO: renamed from: e */
        private int f361e;

        EnumC0007a(int i) {
            this.f361e = i;
        }

        /* JADX INFO: renamed from: a */
        public int m303a() {
            return this.f361e;
        }
    }
}
