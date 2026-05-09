package p000;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import p000.InterfaceC2094rx;

/* JADX INFO: renamed from: rw */
/* JADX INFO: compiled from: BaseImageDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2093rw implements InterfaceC2094rx {

    /* JADX INFO: renamed from: a */
    protected final Context f12619a;

    /* JADX INFO: renamed from: b */
    protected final int f12620b = 5000;

    /* JADX INFO: renamed from: c */
    protected final int f12621c = 20000;

    public C2093rw(Context context) {
        this.f12619a = context.getApplicationContext();
    }

    @Override // p000.InterfaceC2094rx
    /* JADX INFO: renamed from: a */
    public InputStream mo11393a(String str, Object obj) {
        switch (InterfaceC2094rx.a.m11489a(str)) {
            case HTTP:
            case HTTPS:
                return m11482b(str, obj);
            case FILE:
                return m11484d(str, obj);
            case CONTENT:
                return m11485e(str, obj);
            case ASSETS:
                return m11486f(str, obj);
            case DRAWABLE:
                return m11487g(str, obj);
            default:
                return m11488h(str, obj);
        }
    }

    /* JADX INFO: renamed from: b */
    protected InputStream m11482b(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnectionM11483c = m11483c(str, obj);
        for (int i = 0; httpURLConnectionM11483c.getResponseCode() / 100 == 3 && i < 5; i++) {
            httpURLConnectionM11483c = m11483c(httpURLConnectionM11483c.getHeaderField("Location"), obj);
        }
        try {
            return new C2075re(new BufferedInputStream(httpURLConnectionM11483c.getInputStream(), 32768), httpURLConnectionM11483c.getContentLength());
        } catch (IOException e) {
            C2105sh.m11518a(httpURLConnectionM11483c.getErrorStream());
            throw e;
        }
    }

    /* JADX INFO: renamed from: c */
    protected HttpURLConnection m11483c(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f12620b);
        httpURLConnection.setReadTimeout(this.f12621c);
        return httpURLConnection;
    }

    /* JADX INFO: renamed from: d */
    protected InputStream m11484d(String str, Object obj) {
        String strM11492c = InterfaceC2094rx.a.FILE.m11492c(str);
        return new C2075re(new BufferedInputStream(new FileInputStream(strM11492c), 32768), (int) new File(strM11492c).length());
    }

    /* JADX INFO: renamed from: e */
    protected InputStream m11485e(String str, Object obj) {
        ContentResolver contentResolver = this.f12619a.getContentResolver();
        Uri uri = Uri.parse(str);
        if (m11481a(uri)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(uri.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return contentResolver.openInputStream(uri);
    }

    /* JADX INFO: renamed from: f */
    protected InputStream m11486f(String str, Object obj) {
        return this.f12619a.getAssets().open(InterfaceC2094rx.a.ASSETS.m11492c(str));
    }

    /* JADX INFO: renamed from: g */
    protected InputStream m11487g(String str, Object obj) {
        return this.f12619a.getResources().openRawResource(Integer.parseInt(InterfaceC2094rx.a.DRAWABLE.m11492c(str)));
    }

    /* JADX INFO: renamed from: h */
    protected InputStream m11488h(String str, Object obj) {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", str));
    }

    /* JADX INFO: renamed from: a */
    private boolean m11481a(Uri uri) {
        String type = this.f12619a.getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return type.startsWith("video/");
    }
}
