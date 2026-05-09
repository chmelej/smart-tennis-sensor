package org.litepal.tablemanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.message.MessageStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AssociationCreator extends Generator {
    @Override // org.litepal.tablemanager.Generator
    protected abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    @Override // org.litepal.tablemanager.Generator
    protected void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z) throws Throwable {
        addAssociations(getAllAssociations(), sQLiteDatabase, z);
    }

    protected String generateCreateTableSQL(String str, List<ColumnModel> list, boolean z) {
        StringBuilder sb = new StringBuilder("create table ");
        sb.append(str);
        sb.append(" (");
        if (z) {
            sb.append("id integer primary key autoincrement,");
        }
        if (list.size() == 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean z2 = false;
        for (ColumnModel columnModel : list) {
            if (!columnModel.isIdColumn()) {
                if (z2) {
                    sb.append(", ");
                }
                sb.append(columnModel.getColumnName());
                sb.append(" ");
                sb.append(columnModel.getColumnType());
                if (!columnModel.isNullable()) {
                    sb.append(" not null");
                }
                if (columnModel.isUnique()) {
                    sb.append(" unique");
                }
                String defaultValue = columnModel.getDefaultValue();
                if (!TextUtils.isEmpty(defaultValue)) {
                    sb.append(" default ");
                    sb.append(defaultValue);
                }
                z2 = true;
            }
        }
        sb.append(")");
        LogUtil.m11042d(Generator.TAG, "create table sql is >> " + ((Object) sb));
        return sb.toString();
    }

    protected String generateDropTableSQL(String str) {
        return "drop table if exists " + str;
    }

    protected String generateAddColumnSQL(String str, ColumnModel columnModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("alter table ");
        sb.append(str);
        sb.append(" add column ");
        sb.append(columnModel.getColumnName());
        sb.append(" ");
        sb.append(columnModel.getColumnType());
        if (!columnModel.isNullable()) {
            sb.append(" not null");
        }
        if (columnModel.isUnique()) {
            sb.append(" unique");
        }
        String defaultValue = columnModel.getDefaultValue();
        if (!TextUtils.isEmpty(defaultValue)) {
            sb.append(" default ");
            sb.append(defaultValue);
        } else if (!columnModel.isNullable()) {
            if ("integer".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0";
            } else if ("text".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "''";
            } else if ("real".equalsIgnoreCase(columnModel.getColumnType())) {
                defaultValue = "0.0";
            }
            sb.append(" default ");
            sb.append(defaultValue);
        }
        LogUtil.m11042d(Generator.TAG, "add column sql is >> " + ((Object) sb));
        return sb.toString();
    }

    protected boolean isForeignKeyColumnFormat(String str) {
        return (TextUtils.isEmpty(str) || !str.toLowerCase().endsWith(MessageStore.f9157Id) || str.equalsIgnoreCase(MessageStore.f9157Id)) ? false : true;
    }

    protected void giveTableSchemaACopy(String str, int i, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        StringBuilder sb = new StringBuilder("select * from ");
        sb.append(Const.TableSchema.TABLE_NAME);
        LogUtil.m11042d(Generator.TAG, "giveTableSchemaACopy SQL is >> " + ((Object) sb));
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = cursor;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isNeedtoGiveACopy(cursorRawQuery, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Const.TableSchema.COLUMN_NAME, BaseUtility.changeCase(str));
                contentValues.put("type", Integer.valueOf(i));
                sQLiteDatabase.insert(Const.TableSchema.TABLE_NAME, null, contentValues);
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private boolean isNeedtoGiveACopy(Cursor cursor, String str) {
        return (isValueExists(cursor, str) || isSpecialTable(str)) ? false : true;
    }

    private boolean isValueExists(Cursor cursor, String str) {
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow(Const.TableSchema.COLUMN_NAME)).equalsIgnoreCase(str)) {
                if (!cursor.moveToNext()) {
                }
            }
            return true;
        }
        return false;
    }

    private boolean isSpecialTable(String str) {
        return Const.TableSchema.TABLE_NAME.equalsIgnoreCase(str);
    }

    private void addAssociations(Collection<AssociationsModel> collection, SQLiteDatabase sQLiteDatabase, boolean z) throws Throwable {
        for (AssociationsModel associationsModel : collection) {
            if (2 == associationsModel.getAssociationType() || 1 == associationsModel.getAssociationType()) {
                addForeignKeyColumn(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), associationsModel.getTableHoldsForeignKey(), sQLiteDatabase);
            } else if (3 == associationsModel.getAssociationType()) {
                createIntermediateTable(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), sQLiteDatabase, z);
            }
        }
    }

    private void createIntermediateTable(String str, String str2, SQLiteDatabase sQLiteDatabase, boolean z) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(String.valueOf(str) + MessageStore.f9157Id);
        columnModel.setColumnType("integer");
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(String.valueOf(str2) + MessageStore.f9157Id);
        columnModel2.setColumnType("integer");
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        String intermediateTableName = DBUtility.getIntermediateTableName(str, str2);
        ArrayList arrayList2 = new ArrayList();
        if (!DBUtility.isTableExists(intermediateTableName, sQLiteDatabase)) {
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        } else if (z) {
            arrayList2.add(generateDropTableSQL(intermediateTableName));
            arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        }
        execute((String[]) arrayList2.toArray(new String[0]), sQLiteDatabase);
        giveTableSchemaACopy(intermediateTableName, 1, sQLiteDatabase);
    }

    protected void addForeignKeyColumn(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (DBUtility.isTableExists(str, sQLiteDatabase)) {
            if (DBUtility.isTableExists(str2, sQLiteDatabase)) {
                String foreignKeyColumnName = null;
                if (str.equals(str3)) {
                    foreignKeyColumnName = getForeignKeyColumnName(str2);
                } else if (str2.equals(str3)) {
                    foreignKeyColumnName = getForeignKeyColumnName(str);
                }
                if (!DBUtility.isColumnExists(foreignKeyColumnName, str3, sQLiteDatabase)) {
                    ColumnModel columnModel = new ColumnModel();
                    columnModel.setColumnName(foreignKeyColumnName);
                    columnModel.setColumnType("integer");
                    execute(new String[]{generateAddColumnSQL(str3, columnModel)}, sQLiteDatabase);
                    return;
                }
                LogUtil.m11042d(Generator.TAG, "column " + foreignKeyColumnName + " is already exist, no need to add one");
                return;
            }
            throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str2);
        }
        throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST + str);
    }
}
