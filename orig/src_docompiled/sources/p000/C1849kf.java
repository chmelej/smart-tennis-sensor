package p000;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.umeng.message.MessageStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: kf */
/* JADX INFO: compiled from: ImageFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class C1849kf {

    /* JADX INFO: renamed from: b */
    private static C1849kf f10898b;

    /* JADX INFO: renamed from: c */
    private Context f10900c;

    /* JADX INFO: renamed from: d */
    private HashMap<String, C1847kd> f10901d = new HashMap<>();

    /* JADX INFO: renamed from: e */
    private HashMap<String, String> f10902e = new HashMap<>();

    /* JADX INFO: renamed from: f */
    private List<C1851kh> f10903f = new ArrayList();

    /* JADX INFO: renamed from: a */
    boolean f10899a = false;

    private C1849kf(Context context) {
        this.f10900c = context;
    }

    /* JADX INFO: renamed from: a */
    public static C1849kf m10092a(Context context) {
        if (f10898b == null) {
            synchronized (C1849kf.class) {
                f10898b = new C1849kf(context);
            }
        }
        return f10898b;
    }

    /* JADX INFO: renamed from: a */
    public List<C1851kh> m10096a(boolean z) throws Throwable {
        if (z || (!z && !this.f10899a)) {
            m10093a();
        }
        ArrayList arrayList = new ArrayList();
        for (int size = this.f10903f.size() - 1; size >= 0; size--) {
            C1851kh c1851kh = this.f10903f.get(size);
            C1851kh c1851kh2 = new C1851kh();
            c1851kh2.f10912d = c1851kh.f10912d;
            c1851kh2.f10911c = c1851kh.f10911c;
            c1851kh2.f10910b = c1851kh.f10910b;
            c1851kh2.f10909a = c1851kh.f10909a;
            arrayList.add(c1851kh2);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m10093a() throws Throwable {
        Cursor cursorQuery;
        try {
            m10095b();
            cursorQuery = this.f10900c.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MessageStore.f9157Id, "bucket_id", "_data", "bucket_display_name", "date_added"}, null, null, "date_added");
            try {
                if (cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(MessageStore.f9157Id);
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("_data");
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("bucket_display_name");
                    int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("bucket_id");
                    int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("date_added");
                    do {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.getString(columnIndexOrThrow3);
                        String string4 = cursorQuery.getString(columnIndexOrThrow4);
                        long j = cursorQuery.getLong(columnIndexOrThrow5);
                        C1847kd c1847kd = this.f10901d.get(string4);
                        if (c1847kd == null) {
                            c1847kd = new C1847kd();
                            this.f10901d.put(string4, c1847kd);
                            c1847kd.f10881c = new ArrayList();
                            c1847kd.f10880b = string3;
                        }
                        c1847kd.f10879a++;
                        C1851kh c1851kh = new C1851kh();
                        c1851kh.f10909a = string;
                        c1851kh.f10911c = string2;
                        c1851kh.f10910b = this.f10902e.get(string);
                        c1851kh.f10913e = j;
                        c1847kd.f10881c.add(c1851kh);
                        this.f10903f.add(c1851kh);
                    } while (cursorQuery.moveToNext());
                }
                this.f10899a = true;
                System.currentTimeMillis();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                    throw th2;
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10095b() throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = this.f10900c.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"image_id", "_data"}, null, null, null);
            try {
                m10094a(cursorQuery);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                cursor = cursorQuery;
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10094a(Cursor cursor) {
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("image_id");
            int columnIndex2 = cursor.getColumnIndex("_data");
            do {
                int i = cursor.getInt(columnIndex);
                String string = cursor.getString(columnIndex2);
                this.f10902e.put("" + i, string);
            } while (cursor.moveToNext());
        }
    }
}
