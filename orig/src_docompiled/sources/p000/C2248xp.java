package p000;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: xp */
/* JADX INFO: compiled from: MediaStoreRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2248xp extends C2240xh {

    /* JADX INFO: renamed from: b */
    private static final String[] f13535b = {"orientation"};

    C2248xp(Context context) {
        super(context);
    }

    @Override // p000.C2240xh, p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        Uri uri = c2256xx.f13609d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // p000.C2240xh, p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) throws Throwable {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f13492a.getContentResolver();
        int iM12294a = m12294a(contentResolver, c2256xx.f13609d);
        String type = contentResolver.getType(c2256xx.f13609d);
        boolean z = type != null && type.startsWith("video/");
        if (c2256xx.m12333d()) {
            a aVarM12295a = m12295a(c2256xx.f13613h, c2256xx.f13614i);
            if (!z && aVarM12295a == a.FULL) {
                return new AbstractC2258xz.a(null, m12258b(c2256xx), C2253xu.d.DISK, iM12294a);
            }
            long id = ContentUris.parseId(c2256xx.f13609d);
            BitmapFactory.Options optionsC = m12353c(c2256xx);
            optionsC.inJustDecodeBounds = true;
            m12350a(c2256xx.f13613h, c2256xx.f13614i, aVarM12295a.f13541e, aVarM12295a.f13542f, optionsC, c2256xx);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, aVarM12295a == a.FULL ? 1 : aVarM12295a.f13540d, optionsC);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, aVarM12295a.f13540d, optionsC);
            }
            if (thumbnail != null) {
                return new AbstractC2258xz.a(thumbnail, null, C2253xu.d.DISK, iM12294a);
            }
        }
        return new AbstractC2258xz.a(null, m12258b(c2256xx), C2253xu.d.DISK, iM12294a);
    }

    /* JADX INFO: renamed from: a */
    static a m12295a(int i, int i2) {
        if (i <= a.MICRO.f13541e && i2 <= a.MICRO.f13542f) {
            return a.MICRO;
        }
        if (i <= a.MINI.f13541e && i2 <= a.MINI.f13542f) {
            return a.MINI;
        }
        return a.FULL;
    }

    /* JADX INFO: renamed from: a */
    static int m12294a(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = contentResolver.query(uri, f13535b, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(0);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return i;
                    }
                } catch (RuntimeException unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (RuntimeException unused2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX INFO: renamed from: xp$a */
    /* JADX INFO: compiled from: MediaStoreRequestHandler.java */
    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);


        /* JADX INFO: renamed from: d */
        final int f13540d;

        /* JADX INFO: renamed from: e */
        final int f13541e;

        /* JADX INFO: renamed from: f */
        final int f13542f;

        a(int i, int i2, int i3) {
            this.f13540d = i;
            this.f13541e = i2;
            this.f13542f = i3;
        }
    }
}
