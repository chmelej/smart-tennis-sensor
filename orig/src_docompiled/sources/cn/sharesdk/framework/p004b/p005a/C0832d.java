package cn.sharesdk.framework.p004b.p005a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.sharesdk.framework.utils.C0851d;
import com.umeng.message.MessageStore;
import java.util.ArrayList;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.a.d */
/* JADX INFO: compiled from: MessageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0832d {

    /* JADX INFO: renamed from: a */
    public static int f5576a = 0;

    /* JADX INFO: renamed from: b */
    public static int f5577b = 1;

    /* JADX INFO: renamed from: c */
    public static int f5578c = 2;

    /* JADX INFO: renamed from: a */
    public static synchronized long m6021a(Context context, String str, long j) {
        if (str != null) {
            if (str.trim() != "") {
                C0830b c0830bM6016a = C0830b.m6016a(context);
                ContentValues contentValues = new ContentValues();
                contentValues.put("post_time", Long.valueOf(j));
                contentValues.put("message_data", str.toString());
                return c0830bM6016a.m6019a("message", contentValues);
            }
        }
        return -1L;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized long m6022a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 0L;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append("'");
            sb.append(arrayList.get(i));
            sb.append("'");
            sb.append(",");
        }
        String strSubstring = sb.toString().substring(0, sb.length() - 1);
        int iM6018a = C0830b.m6016a(context).m6018a("message", "_id in ( " + strSubstring + " )", null);
        C0851d.m6195a().m8615i("delete COUNT == %s", Integer.valueOf(iM6018a));
        return iM6018a;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized ArrayList<C0831c> m6024a(Context context, String str, String[] strArr) {
        ArrayList<C0831c> arrayList;
        arrayList = new ArrayList<>();
        C0831c c0831c = new C0831c();
        StringBuilder sb = new StringBuilder();
        Cursor cursorM6020a = C0830b.m6016a(context).m6020a("message", new String[]{MessageStore.f9157Id, "post_time", "message_data"}, str, strArr, null);
        while (cursorM6020a != null && cursorM6020a.moveToNext()) {
            c0831c.f5575b.add(cursorM6020a.getString(0));
            if (c0831c.f5575b.size() == 100) {
                sb.append(cursorM6020a.getString(2));
                c0831c.f5574a = sb.toString();
                arrayList.add(c0831c);
                c0831c = new C0831c();
                sb = new StringBuilder();
            } else {
                sb.append(cursorM6020a.getString(2) + "\n");
            }
        }
        cursorM6020a.close();
        if (c0831c.f5575b.size() != 0) {
            c0831c.f5574a = sb.toString().substring(0, sb.length() - 1);
            arrayList.add(c0831c);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized ArrayList<C0831c> m6023a(Context context) {
        if (C0830b.m6016a(context).m6017a("message") > 0) {
            return m6024a(context, (String) null, (String[]) null);
        }
        return new ArrayList<>();
    }
}
