package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DataSupportException;

/* JADX INFO: loaded from: classes.dex */
class SaveHandler extends DataHandler {
    private boolean shouldGiveModelIdValue(String str, Class<?> cls, long j) {
        return (str == null || cls == null || j <= 0) ? false : true;
    }

    SaveHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    void onSave(DataSupport dataSupport) {
        String className = dataSupport.getClassName();
        List<Field> supportedFields = getSupportedFields(className);
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(className);
        if (!dataSupport.isSaved()) {
            analyzeAssociatedModels(dataSupport, associationInfo);
            doSaveAction(dataSupport, supportedFields);
            analyzeAssociatedModels(dataSupport, associationInfo);
        } else {
            analyzeAssociatedModels(dataSupport, associationInfo);
            doUpdateAction(dataSupport, supportedFields);
        }
    }

    <T extends DataSupport> void onSaveAll(Collection<T> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        DataSupport[] dataSupportArr = (DataSupport[]) collection.toArray(new DataSupport[0]);
        String className = dataSupportArr[0].getClassName();
        List<Field> supportedFields = getSupportedFields(className);
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(className);
        for (DataSupport dataSupport : dataSupportArr) {
            if (!dataSupport.isSaved()) {
                analyzeAssociatedModels(dataSupport, associationInfo);
                doSaveAction(dataSupport, supportedFields);
                analyzeAssociatedModels(dataSupport, associationInfo);
            } else {
                analyzeAssociatedModels(dataSupport, associationInfo);
                doUpdateAction(dataSupport, supportedFields);
            }
            dataSupport.clearAssociatedData();
        }
    }

    private void doSaveAction(DataSupport dataSupport, List<Field> list) {
        ContentValues contentValues = new ContentValues();
        beforeSave(dataSupport, list, contentValues);
        afterSave(dataSupport, list, saving(dataSupport, contentValues));
    }

    private void beforeSave(DataSupport dataSupport, List<Field> list, ContentValues contentValues) {
        putFieldsValue(dataSupport, list, contentValues);
        putForeignKeyValue(contentValues, dataSupport);
    }

    private long saving(DataSupport dataSupport, ContentValues contentValues) {
        return this.mDatabase.insert(dataSupport.getTableName(), null, contentValues);
    }

    private void afterSave(DataSupport dataSupport, List<Field> list, long j) {
        throwIfSaveFailed(j);
        assignIdValue(dataSupport, getIdField(list), j);
        updateAssociatedTableWithFK(dataSupport);
        insertIntermediateJoinTableValue(dataSupport, false);
    }

    private void doUpdateAction(DataSupport dataSupport, List<Field> list) {
        ContentValues contentValues = new ContentValues();
        beforeUpdate(dataSupport, list, contentValues);
        updating(dataSupport, contentValues);
        afterUpdate(dataSupport);
    }

    private void beforeUpdate(DataSupport dataSupport, List<Field> list, ContentValues contentValues) {
        putFieldsValue(dataSupport, list, contentValues);
        putForeignKeyValue(contentValues, dataSupport);
        Iterator<String> it = dataSupport.getListToClearSelfFK().iterator();
        while (it.hasNext()) {
            contentValues.putNull(it.next());
        }
    }

    private void updating(DataSupport dataSupport, ContentValues contentValues) {
        this.mDatabase.update(dataSupport.getTableName(), contentValues, "id = ?", new String[]{String.valueOf(dataSupport.getBaseObjId())});
    }

    private void afterUpdate(DataSupport dataSupport) {
        updateAssociatedTableWithFK(dataSupport);
        insertIntermediateJoinTableValue(dataSupport, true);
        clearFKValueInAssociatedTable(dataSupport);
    }

    private Field getIdField(List<Field> list) {
        for (Field field : list) {
            if (isIdColumn(field.getName())) {
                return field;
            }
        }
        return null;
    }

    private void throwIfSaveFailed(long j) {
        if (j == -1) {
            throw new DataSupportException(DataSupportException.SAVE_FAILED);
        }
    }

    private void assignIdValue(DataSupport dataSupport, Field field, long j) {
        try {
            giveBaseObjIdValue(dataSupport, j);
            if (field != null) {
                giveModelIdValue(dataSupport, field.getName(), field.getType(), j);
            }
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    private void giveModelIdValue(DataSupport dataSupport, String str, Class<?> cls, long j) throws IllegalAccessException {
        Object objValueOf;
        if (shouldGiveModelIdValue(str, cls, j)) {
            if (cls == Integer.TYPE || cls == Integer.class) {
                objValueOf = Integer.valueOf((int) j);
            } else if (cls == Long.TYPE || cls == Long.class) {
                objValueOf = Long.valueOf(j);
            } else {
                throw new DataSupportException(DataSupportException.ID_TYPE_INVALID_EXCEPTION);
            }
            DynamicExecutor.setField(dataSupport, str, objValueOf, dataSupport.getClass());
        }
    }

    private void putForeignKeyValue(ContentValues contentValues, DataSupport dataSupport) {
        Map<String, Long> associatedModelsMapWithoutFK = dataSupport.getAssociatedModelsMapWithoutFK();
        for (String str : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(getForeignKeyColumnName(str), associatedModelsMapWithoutFK.get(str));
        }
    }

    private void updateAssociatedTableWithFK(DataSupport dataSupport) {
        Map<String, Set<Long>> associatedModelsMapWithFK = dataSupport.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(getForeignKeyColumnName(dataSupport.getTableName()), Long.valueOf(dataSupport.getBaseObjId()));
            Set<Long> set = associatedModelsMapWithFK.get(str);
            if (set != null && !set.isEmpty()) {
                this.mDatabase.update(str, contentValues, getWhereOfIdsWithOr(set), null);
            }
        }
    }

    private void clearFKValueInAssociatedTable(DataSupport dataSupport) {
        for (String str : dataSupport.getListToClearAssociatedFK()) {
            String foreignKeyColumnName = getForeignKeyColumnName(dataSupport.getTableName());
            ContentValues contentValues = new ContentValues();
            contentValues.putNull(foreignKeyColumnName);
            this.mDatabase.update(str, contentValues, String.valueOf(foreignKeyColumnName) + " = " + dataSupport.getBaseObjId(), null);
        }
    }

    private void insertIntermediateJoinTableValue(DataSupport dataSupport, boolean z) {
        Map<String, Set<Long>> associatedModelsMapForJoinTable = dataSupport.getAssociatedModelsMapForJoinTable();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapForJoinTable.keySet()) {
            String intermediateTableName = getIntermediateTableName(dataSupport, str);
            if (z) {
                this.mDatabase.delete(intermediateTableName, getWhereForJoinTableToDelete(dataSupport), new String[]{String.valueOf(dataSupport.getBaseObjId())});
            }
            Iterator<Long> it = associatedModelsMapForJoinTable.get(str).iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                contentValues.clear();
                contentValues.put(getForeignKeyColumnName(dataSupport.getTableName()), Long.valueOf(dataSupport.getBaseObjId()));
                contentValues.put(getForeignKeyColumnName(str), Long.valueOf(jLongValue));
                this.mDatabase.insert(intermediateTableName, null, contentValues);
            }
        }
    }

    private String getWhereForJoinTableToDelete(DataSupport dataSupport) {
        return getForeignKeyColumnName(dataSupport.getTableName()) + " = ?";
    }
}
