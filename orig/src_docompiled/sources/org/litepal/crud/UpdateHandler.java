package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.exceptions.DataSupportException;
import org.litepal.util.BaseUtility;

/* JADX INFO: loaded from: classes.dex */
class UpdateHandler extends DataHandler {
    UpdateHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    int onUpdate(DataSupport dataSupport, long j) {
        List<Field> supportedFields = getSupportedFields(dataSupport.getClassName());
        ContentValues contentValues = new ContentValues();
        putFieldsValue(dataSupport, supportedFields, contentValues);
        putFieldsToDefaultValue(dataSupport, contentValues);
        if (contentValues.size() <= 0) {
            return 0;
        }
        return this.mDatabase.update(dataSupport.getTableName(), contentValues, "id = " + j, null);
    }

    int onUpdate(Class<?> cls, long j, ContentValues contentValues) {
        if (contentValues.size() <= 0) {
            return 0;
        }
        return this.mDatabase.update(getTableName(cls), contentValues, "id = " + j, null);
    }

    int onUpdateAll(DataSupport dataSupport, String... strArr) {
        List<Field> supportedFields = getSupportedFields(dataSupport.getClassName());
        ContentValues contentValues = new ContentValues();
        putFieldsValue(dataSupport, supportedFields, contentValues);
        putFieldsToDefaultValue(dataSupport, contentValues);
        return doUpdateAllAction(dataSupport.getTableName(), contentValues, strArr);
    }

    int onUpdateAll(String str, ContentValues contentValues, String... strArr) {
        return doUpdateAllAction(str, contentValues, strArr);
    }

    private int doUpdateAllAction(String str, ContentValues contentValues, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (contentValues.size() > 0) {
            return this.mDatabase.update(str, contentValues, getWhereClause(strArr), getWhereArgs(strArr));
        }
        return 0;
    }

    private void putFieldsToDefaultValue(DataSupport dataSupport, ContentValues contentValues) {
        String str = null;
        try {
            try {
                DataSupport emptyModel = getEmptyModel(dataSupport);
                Class<?> cls = emptyModel.getClass();
                for (String str2 : dataSupport.getFieldsToSetToDefault()) {
                    if (!isIdColumn(str2)) {
                        try {
                            putContentValues(emptyModel, cls.getDeclaredField(str2), contentValues);
                            str = str2;
                        } catch (NoSuchFieldException unused) {
                            str = str2;
                            throw new DataSupportException(DataSupportException.noSuchFieldExceptioin(dataSupport.getClassName(), str));
                        }
                    }
                }
            } catch (NoSuchFieldException unused2) {
            }
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    private int doUpdateAssociations(DataSupport dataSupport, long j, ContentValues contentValues) {
        analyzeAssociations(dataSupport);
        updateSelfTableForeignKey(dataSupport, contentValues);
        return updateAssociatedTableForeignKey(dataSupport, j) + 0;
    }

    private void analyzeAssociations(DataSupport dataSupport) {
        try {
            analyzeAssociatedModels(dataSupport, getAssociationInfo(dataSupport.getClassName()));
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    private void updateSelfTableForeignKey(DataSupport dataSupport, ContentValues contentValues) {
        Map<String, Long> associatedModelsMapWithoutFK = dataSupport.getAssociatedModelsMapWithoutFK();
        for (String str : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(getForeignKeyColumnName(str), associatedModelsMapWithoutFK.get(str));
        }
    }

    private int updateAssociatedTableForeignKey(DataSupport dataSupport, long j) {
        Map<String, Set<Long>> associatedModelsMapWithFK = dataSupport.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(getForeignKeyColumnName(dataSupport.getTableName()), Long.valueOf(j));
            Set<Long> set = associatedModelsMapWithFK.get(str);
            if (set != null && !set.isEmpty()) {
                return this.mDatabase.update(str, contentValues, getWhereOfIdsWithOr(set), null);
            }
        }
        return 0;
    }
}
