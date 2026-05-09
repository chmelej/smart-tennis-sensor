package org.litepal.tablemanager;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.litepal.LitePalBase;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

/* JADX INFO: loaded from: classes.dex */
public abstract class Generator extends LitePalBase {
    public static final String TAG = "Generator";
    private Collection<AssociationsModel> mAllRelationModels;
    private Collection<TableModel> mTableModels;

    protected abstract void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z);

    protected abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    protected Collection<TableModel> getAllTableModels() {
        if (this.mTableModels == null) {
            this.mTableModels = new ArrayList();
        }
        if (!canUseCache()) {
            this.mTableModels.clear();
            Iterator<String> it = LitePalAttr.getInstance().getClassNames().iterator();
            while (it.hasNext()) {
                this.mTableModels.add(getTableModel(it.next()));
            }
        }
        return this.mTableModels;
    }

    protected Collection<AssociationsModel> getAllAssociations() {
        if (this.mAllRelationModels == null || this.mAllRelationModels.isEmpty()) {
            this.mAllRelationModels = getAssociations(LitePalAttr.getInstance().getClassNames());
        }
        return this.mAllRelationModels;
    }

    protected void execute(String[] strArr, SQLiteDatabase sQLiteDatabase) {
        String str = "";
        if (strArr == null) {
            return;
        }
        try {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str2 = strArr[i];
                try {
                    sQLiteDatabase.execSQL(BaseUtility.changeCase(str2));
                    i++;
                    str = str2;
                } catch (SQLException unused) {
                    str = str2;
                    throw new DatabaseGenerateException(DatabaseGenerateException.SQL_ERROR + str);
                }
            }
        } catch (SQLException unused2) {
        }
    }

    private static void addAssociation(SQLiteDatabase sQLiteDatabase, boolean z) throws Throwable {
        new Creator().addOrUpdateAssociation(sQLiteDatabase, z);
    }

    private static void updateAssociations(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().addOrUpdateAssociation(sQLiteDatabase, false);
    }

    private static void upgradeTables(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().createOrUpgradeTable(sQLiteDatabase, false);
    }

    private static void create(SQLiteDatabase sQLiteDatabase, boolean z) {
        new Creator().createOrUpgradeTable(sQLiteDatabase, z);
    }

    private static void drop(SQLiteDatabase sQLiteDatabase) throws Throwable {
        new Dropper().createOrUpgradeTable(sQLiteDatabase, false);
    }

    private boolean canUseCache() {
        return this.mTableModels != null && this.mTableModels.size() == LitePalAttr.getInstance().getClassNames().size();
    }

    static void create(SQLiteDatabase sQLiteDatabase) {
        create(sQLiteDatabase, true);
        addAssociation(sQLiteDatabase, true);
    }

    static void upgrade(SQLiteDatabase sQLiteDatabase) {
        drop(sQLiteDatabase);
        create(sQLiteDatabase, false);
        updateAssociations(sQLiteDatabase);
        upgradeTables(sQLiteDatabase);
        addAssociation(sQLiteDatabase, false);
    }
}
