package p000;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import java.io.InputStream;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: xg */
/* JADX INFO: compiled from: ContactsPhotoRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2239xg extends AbstractC2258xz {

    /* JADX INFO: renamed from: a */
    private static final UriMatcher f13490a = new UriMatcher(-1);

    /* JADX INFO: renamed from: b */
    private final Context f13491b;

    static {
        f13490a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f13490a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f13490a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f13490a.addURI("com.android.contacts", "contacts/#", 3);
        f13490a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C2239xg(Context context) {
        this.f13491b = context;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        Uri uri = c2256xx.f13609d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f13490a.match(c2256xx.f13609d) != -1;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) {
        InputStream inputStreamM12256b = m12256b(c2256xx);
        if (inputStreamM12256b != null) {
            return new AbstractC2258xz.a(inputStreamM12256b, C2253xu.d.DISK);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private InputStream m12256b(C2256xx c2256xx) {
        ContentResolver contentResolver = this.f13491b.getContentResolver();
        Uri uriLookupContact = c2256xx.f13609d;
        switch (f13490a.match(uriLookupContact)) {
            case 1:
                uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
                if (uriLookupContact == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uriLookupContact);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uriLookupContact);
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact);
        }
        return a.m12257a(contentResolver, uriLookupContact);
    }

    /* JADX INFO: renamed from: xg$a */
    /* JADX INFO: compiled from: ContactsPhotoRequestHandler.java */
    @TargetApi(14)
    static class a {
        /* JADX INFO: renamed from: a */
        static InputStream m12257a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }
}
