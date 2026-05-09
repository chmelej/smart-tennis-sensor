package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.Iterator;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
class Creator extends AssociationCreator {
    public static final String TAG = "Creator";

    Creator() {
    }

    @Override // org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        Iterator<TableModel> it = getAllTableModels().iterator();
        while (it.hasNext()) {
            createOrUpgradeTable(it.next(), sQLiteDatabase, z);
        }
    }

    protected void createOrUpgradeTable(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        execute(getCreateTableSQLs(tableModel, sQLiteDatabase, z), sQLiteDatabase);
        giveTableSchemaACopy(tableModel.getTableName(), 0, sQLiteDatabase);
    }

    protected String[] getCreateTableSQLs(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        if (z) {
            return new String[]{generateDropTableSQL(tableModel), generateCreateTableSQL(tableModel)};
        }
        if (DBUtility.isTableExists(tableModel.getTableName(), sQLiteDatabase)) {
            return null;
        }
        return new String[]{generateCreateTableSQL(tableModel)};
    }

    protected String generateDropTableSQL(TableModel tableModel) {
        return generateDropTableSQL(tableModel.getTableName());
    }

    protected String generateCreateTableSQL(TableModel tableModel) {
        return generateCreateTableSQL(tableModel.getTableName(), tableModel.getColumnModels(), true);
    }
}
