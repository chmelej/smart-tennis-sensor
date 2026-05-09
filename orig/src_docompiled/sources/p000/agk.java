package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* JADX INFO: compiled from: UMCCPathDatabaseContext.java */
/* JADX INFO: loaded from: classes.dex */
public class agk extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private String f821a;

    public agk(Context context, String str) {
        super(context);
        this.f821a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(this.f821a + str);
        if (!file.getParentFile().exists() && !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
