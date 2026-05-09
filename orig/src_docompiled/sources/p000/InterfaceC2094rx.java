package p000;

import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: renamed from: rx */
/* JADX INFO: compiled from: ImageDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC2094rx {
    /* JADX INFO: renamed from: a */
    InputStream mo11393a(String str, Object obj);

    /* JADX INFO: renamed from: rx$a */
    /* JADX INFO: compiled from: ImageDownloader.java */
    public enum a {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");


        /* JADX INFO: renamed from: h */
        private String f12631h;

        /* JADX INFO: renamed from: i */
        private String f12632i;

        a(String str) {
            this.f12631h = str;
            this.f12632i = str + "://";
        }

        /* JADX INFO: renamed from: a */
        public static a m11489a(String str) {
            if (str != null) {
                for (a aVar : values()) {
                    if (aVar.m11490d(str)) {
                        return aVar;
                    }
                }
            }
            return UNKNOWN;
        }

        /* JADX INFO: renamed from: d */
        private boolean m11490d(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.f12632i);
        }

        /* JADX INFO: renamed from: b */
        public String m11491b(String str) {
            return this.f12632i + str;
        }

        /* JADX INFO: renamed from: c */
        public String m11492c(String str) {
            if (!m11490d(str)) {
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.f12631h));
            }
            return str.substring(this.f12632i.length());
        }
    }
}
