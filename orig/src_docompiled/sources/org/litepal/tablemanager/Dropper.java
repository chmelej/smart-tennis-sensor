package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

/* JADX INFO: loaded from: classes.dex */
public class Dropper extends AssociationUpdater {
    private Collection<TableModel> mTableModels;

    @Override // org.litepal.tablemanager.AssociationUpdater, org.litepal.tablemanager.Creator, org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) throws Throwable {
        this.mTableModels = getAllTableModels();
        this.mDb = sQLiteDatabase;
        dropTables();
    }

    private void dropTables() throws Throwable {
        List<String> listFindTablesToDrop = findTablesToDrop();
        dropTables(listFindTablesToDrop, this.mDb);
        clearCopyInTableSchema(listFindTablesToDrop);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[PHI: r2
      0x0061: PHI (r2v5 android.database.Cursor) = (r2v4 android.database.Cursor), (r2v7 android.database.Cursor) binds: [B:20:0x005f, B:11:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.String> findTablesToDrop() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.mDb     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.String r3 = "table_schema"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            if (r1 == 0) goto L50
        L1a:
            java.lang.String r1 = "name"
            int r1 = r2.getColumnIndexOrThrow(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            java.lang.String r3 = "type"
            int r3 = r2.getColumnIndexOrThrow(r3)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            int r3 = r2.getInt(r3)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            boolean r3 = r11.shouldDropThisTable(r1, r3)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            if (r3 == 0) goto L4a
            java.lang.String r3 = "AssociationUpdater"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            java.lang.String r5 = "need to drop "
            r4.<init>(r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            r4.append(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            org.litepal.util.LogUtil.m11042d(r3, r4)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            r0.add(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
        L4a:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L65
            if (r1 != 0) goto L1a
        L50:
            if (r2 == 0) goto L64
            goto L61
        L53:
            r1 = move-exception
            goto L5c
        L55:
            r0 = move-exception
            r2 = r1
            goto L66
        L58:
            r2 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L5c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L64
        L61:
            r2.close()
        L64:
            return r0
        L65:
            r0 = move-exception
        L66:
            if (r2 == 0) goto L6b
            r2.close()
        L6b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.tablemanager.Dropper.findTablesToDrop():java.util.List");
    }

    private List<String> pickTableNamesFromTableModels() {
        ArrayList arrayList = new ArrayList();
        Iterator<TableModel> it = this.mTableModels.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTableName());
        }
        return arrayList;
    }

    private boolean shouldDropThisTable(String str, int i) {
        return !BaseUtility.containsIgnoreCases(pickTableNamesFromTableModels(), str) && i == 0;
    }
}
