package p000;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p000.InterfaceC2243xk;

/* JADX INFO: renamed from: xt */
/* JADX INFO: compiled from: OkHttpDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2252xt implements InterfaceC2243xk {

    /* JADX INFO: renamed from: a */
    private final OkHttpClient f13554a;

    /* JADX INFO: renamed from: a */
    private static OkHttpClient m12304a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000L, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000L, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000L, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public C2252xt(Context context) {
        this(C2265yf.m12396b(context));
    }

    public C2252xt(File file) {
        this(file, C2265yf.m12381a(file));
    }

    public C2252xt(File file, long j) {
        this(m12304a());
        try {
            this.f13554a.setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }

    public C2252xt(OkHttpClient okHttpClient) {
        this.f13554a = okHttpClient;
    }

    @Override // p000.InterfaceC2243xk
    /* JADX INFO: renamed from: a */
    public InterfaceC2243xk.a mo12284a(Uri uri, int i) throws InterfaceC2243xk.b {
        CacheControl cacheControlBuild;
        if (i == 0) {
            cacheControlBuild = null;
        } else if (EnumC2250xr.m12300c(i)) {
            cacheControlBuild = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!EnumC2250xr.m12298a(i)) {
                builder.noCache();
            }
            if (!EnumC2250xr.m12299b(i)) {
                builder.noStore();
            }
            cacheControlBuild = builder.build();
        }
        Request.Builder builderUrl = new Request.Builder().url(uri.toString());
        if (cacheControlBuild != null) {
            builderUrl.cacheControl(cacheControlBuild);
        }
        Response responseExecute = this.f13554a.newCall(builderUrl.build()).execute();
        int iCode = responseExecute.code();
        if (iCode >= 300) {
            responseExecute.body().close();
            throw new InterfaceC2243xk.b(iCode + " " + responseExecute.message(), i, iCode);
        }
        boolean z = responseExecute.cacheResponse() != null;
        ResponseBody responseBodyBody = responseExecute.body();
        return new InterfaceC2243xk.a(responseBodyBody.byteStream(), z, responseBodyBody.contentLength());
    }
}
