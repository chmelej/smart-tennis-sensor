package p000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: kl */
/* JADX INFO: compiled from: CityHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1855kl extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private Context f10925a;

    public C1855kl(Context context) {
        super(context, "city.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f10925a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws Throwable {
        m10108a(sQLiteDatabase, "countrycityprovince.sql");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        if (i2 != 3) {
            return;
        }
        m10108a(sQLiteDatabase, "countrycityprovince.sql");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0065 -> B:34:0x006e). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a */
    private void m10108a(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        ?? bufferedReader;
        ?? line = 0;
        line = 0;
        line = 0;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(this.f10925a.getAssets().open(str)));
                    String str2 = "";
                    while (true) {
                        try {
                            line = bufferedReader.readLine();
                            if (line == 0) {
                                break;
                            }
                            str2 = str2 + line;
                            if (line.trim().endsWith(";")) {
                                sQLiteDatabase.execSQL(str2.replace(";", ""));
                                str2 = "";
                            }
                        } catch (IOException e) {
                            e = e;
                            line = bufferedReader;
                            Log.e("db-error", e.toString());
                            if (line != 0) {
                                line.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != 0) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    Log.e("db-error", e2.toString());
                                }
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != 0) {
                        bufferedReader.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = line;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            Log.e("db-error", e4.toString());
        }
    }
}
