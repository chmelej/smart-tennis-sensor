package cn.smssdk.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mob.tools.utils.DeviceHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.contact.c */
/* JADX INFO: compiled from: Querier.java */
/* JADX INFO: loaded from: classes.dex */
public class C0937c {

    /* JADX INFO: renamed from: a */
    private ContentResolver f6056a;

    /* JADX INFO: renamed from: b */
    private Context f6057b;

    public C0937c(Context context, ContentResolver contentResolver) {
        this.f6056a = contentResolver;
        this.f6057b = context;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<HashMap<String, Object>> m6722a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object blob;
        ArrayList<HashMap<String, Object>> arrayList = null;
        try {
            if (!DeviceHelper.getInstance(this.f6057b).checkPermission("android.permission.READ_CONTACTS")) {
                return null;
            }
        } catch (Throwable unused) {
        }
        Cursor cursorQuery = this.f6056a.query(uri, strArr, str, strArr2, str2);
        if (cursorQuery != null) {
            if (cursorQuery.getCount() == 0) {
                return null;
            }
            if (cursorQuery.moveToFirst()) {
                ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
                do {
                    HashMap<String, Object> map = new HashMap<>();
                    int columnCount = cursorQuery.getColumnCount();
                    for (int i = 0; i < columnCount; i++) {
                        String columnName = cursorQuery.getColumnName(i);
                        try {
                            blob = cursorQuery.getString(i);
                        } catch (Throwable unused2) {
                            blob = cursorQuery.getBlob(i);
                        }
                        map.put(columnName, blob);
                    }
                    arrayList2.add(map);
                } while (cursorQuery.moveToNext());
                arrayList = arrayList2;
            }
            cursorQuery.close();
        }
        return arrayList;
    }
}
