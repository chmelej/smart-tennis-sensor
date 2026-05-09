package p000;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.widget.EditText;
import com.umeng.message.MessageStore;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: mb */
/* JADX INFO: compiled from: GetSmsContentUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1899mb extends ContentObserver {

    /* JADX INFO: renamed from: a */
    private Activity f11445a;

    /* JADX INFO: renamed from: b */
    private String f11446b;

    /* JADX INFO: renamed from: c */
    private EditText f11447c;

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        Cursor cursorManagedQuery = this.f11445a.managedQuery(Uri.parse("content://sms/inbox"), new String[]{MessageStore.f9157Id, "address", "body", "read"}, "read=?", new String[]{"0"}, "date desc");
        if (cursorManagedQuery != null) {
            cursorManagedQuery.moveToFirst();
            if (cursorManagedQuery.moveToFirst()) {
                String string = cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("address"));
                if ("10657120610111".equals(string) || "106900321100".equals(string)) {
                    this.f11446b = Pattern.compile("[^0-9]").matcher(cursorManagedQuery.getString(cursorManagedQuery.getColumnIndex("body")).toString()).replaceAll("").trim().toString();
                    if (this.f11446b.length() == 5) {
                        this.f11446b = this.f11446b.substring(1, this.f11446b.length());
                    }
                    this.f11447c.setText(this.f11446b);
                }
            }
        }
    }
}
