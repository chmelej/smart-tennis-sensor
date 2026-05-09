package p000;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: xk */
/* JADX INFO: compiled from: Downloader.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC2243xk {
    /* JADX INFO: renamed from: a */
    a mo12284a(Uri uri, int i);

    /* JADX INFO: renamed from: xk$b */
    /* JADX INFO: compiled from: Downloader.java */
    public static class b extends IOException {

        /* JADX INFO: renamed from: a */
        final boolean f13520a;

        /* JADX INFO: renamed from: b */
        final int f13521b;

        public b(String str, int i, int i2) {
            super(str);
            this.f13520a = EnumC2250xr.m12300c(i);
            this.f13521b = i2;
        }
    }

    /* JADX INFO: renamed from: xk$a */
    /* JADX INFO: compiled from: Downloader.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        final InputStream f13516a;

        /* JADX INFO: renamed from: b */
        final Bitmap f13517b;

        /* JADX INFO: renamed from: c */
        final boolean f13518c;

        /* JADX INFO: renamed from: d */
        final long f13519d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f13516a = inputStream;
            this.f13517b = null;
            this.f13518c = z;
            this.f13519d = j;
        }

        /* JADX INFO: renamed from: a */
        public InputStream m12285a() {
            return this.f13516a;
        }

        @Deprecated
        /* JADX INFO: renamed from: b */
        public Bitmap m12286b() {
            return this.f13517b;
        }

        /* JADX INFO: renamed from: c */
        public long m12287c() {
            return this.f13519d;
        }
    }
}
