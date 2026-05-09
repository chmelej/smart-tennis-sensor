package p000;

import cn.jzvd.JZVideoPlayer;

/* JADX INFO: renamed from: io */
/* JADX INFO: compiled from: JZVideoPlayerManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1804io {

    /* JADX INFO: renamed from: a */
    public static JZVideoPlayer f10362a;

    /* JADX INFO: renamed from: b */
    public static JZVideoPlayer f10363b;

    /* JADX INFO: renamed from: a */
    public static JZVideoPlayer m9812a() {
        return f10362a;
    }

    /* JADX INFO: renamed from: a */
    public static void m9813a(JZVideoPlayer jZVideoPlayer) {
        f10362a = jZVideoPlayer;
    }

    /* JADX INFO: renamed from: b */
    public static JZVideoPlayer m9814b() {
        return f10363b;
    }

    /* JADX INFO: renamed from: b */
    public static void m9815b(JZVideoPlayer jZVideoPlayer) {
        f10363b = jZVideoPlayer;
    }

    /* JADX INFO: renamed from: c */
    public static JZVideoPlayer m9816c() {
        if (m9814b() != null) {
            return m9814b();
        }
        return m9812a();
    }

    /* JADX INFO: renamed from: d */
    public static void m9817d() {
        if (f10363b != null) {
            f10363b.mo5845o();
            f10363b = null;
        }
        if (f10362a != null) {
            f10362a.mo5845o();
            f10362a = null;
        }
    }
}
