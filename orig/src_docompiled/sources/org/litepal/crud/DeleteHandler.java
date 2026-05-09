package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DataSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public class DeleteHandler extends DataHandler {
    private List<String> foreignKeyTableToDelete;

    DeleteHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    int onDelete(DataSupport dataSupport) {
        if (!dataSupport.isSaved()) {
            return 0;
        }
        Collection<AssociationsInfo> collectionAnalyzeAssociations = analyzeAssociations(dataSupport);
        int iDeleteCascade = deleteCascade(dataSupport) + this.mDatabase.delete(dataSupport.getTableName(), "id = " + dataSupport.getBaseObjId(), null);
        clearAssociatedModelSaveState(dataSupport, collectionAnalyzeAssociations);
        return iDeleteCascade;
    }

    int onDelete(Class<?> cls, long j) {
        analyzeAssociations(cls);
        int iDeleteCascade = deleteCascade(cls, j) + this.mDatabase.delete(getTableName(cls), "id = " + j, null);
        getForeignKeyTableToDelete().clear();
        return iDeleteCascade;
    }

    int onDeleteAll(String str, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        return this.mDatabase.delete(str, getWhereClause(strArr), getWhereArgs(strArr));
    }

    int onDeleteAll(Class<?> cls, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        analyzeAssociations(cls);
        int iDeleteAllCascade = deleteAllCascade(cls, strArr) + this.mDatabase.delete(getTableName(cls), getWhereClause(strArr), getWhereArgs(strArr));
        getForeignKeyTableToDelete().clear();
        return iDeleteAllCascade;
    }

    private void analyzeAssociations(Class<?> cls) {
        for (AssociationsInfo associationsInfo : getAssociationInfo(cls.getName())) {
            String tableNameByClassName = DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName());
            if (associationsInfo.getAssociationType() == 2 || associationsInfo.getAssociationType() == 1) {
                if (!cls.getName().equals(associationsInfo.getClassHoldsForeignKey())) {
                    getForeignKeyTableToDelete().add(tableNameByClassName);
                }
            } else if (associationsInfo.getAssociationType() == 3) {
                getForeignKeyTableToDelete().add(BaseUtility.changeCase(DBUtility.getIntermediateTableName(getTableName(cls), tableNameByClassName)));
            }
        }
    }

    private int deleteCascade(Class<?> cls, long j) {
        int iDelete = 0;
        for (String str : getForeignKeyTableToDelete()) {
            String foreignKeyColumnName = getForeignKeyColumnName(getTableName(cls));
            iDelete += this.mDatabase.delete(str, String.valueOf(foreignKeyColumnName) + " = " + j, null);
        }
        return iDelete;
    }

    private int deleteAllCascade(Class<?> cls, String... strArr) {
        int iDelete = 0;
        for (String str : getForeignKeyTableToDelete()) {
            String tableName = getTableName(cls);
            String foreignKeyColumnName = getForeignKeyColumnName(tableName);
            StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" in (select id from ");
            sb.append(tableName);
            if (strArr != null && strArr.length > 0) {
                sb.append(" where ");
                sb.append(buildConditionString(strArr));
            }
            sb.append(")");
            iDelete += this.mDatabase.delete(str, BaseUtility.changeCase(sb.toString()), null);
        }
        return iDelete;
    }

    private String buildConditionString(String... strArr) {
        int length = strArr.length - 1;
        int i = 0;
        String strReplaceFirst = strArr[0];
        while (i < length) {
            StringBuilder sb = new StringBuilder("'");
            i++;
            sb.append(strArr[i]);
            sb.append("'");
            strReplaceFirst = strReplaceFirst.replaceFirst("\\?", sb.toString());
        }
        return strReplaceFirst;
    }

    private Collection<AssociationsInfo> analyzeAssociations(DataSupport dataSupport) {
        try {
            Collection<AssociationsInfo> associationInfo = getAssociationInfo(dataSupport.getClassName());
            analyzeAssociatedModels(dataSupport, associationInfo);
            return associationInfo;
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    private void clearAssociatedModelSaveState(DataSupport dataSupport, Collection<AssociationsInfo> collection) {
        DataSupport associatedModel;
        try {
            for (AssociationsInfo associationsInfo : collection) {
                if (associationsInfo.getAssociationType() == 2 && !dataSupport.getClassName().equals(associationsInfo.getClassHoldsForeignKey())) {
                    Collection<DataSupport> associatedModels = getAssociatedModels(dataSupport, associationsInfo);
                    if (associatedModels != null && !associatedModels.isEmpty()) {
                        for (DataSupport dataSupport2 : associatedModels) {
                            if (dataSupport2 != null) {
                                dataSupport2.clearSavedState();
                            }
                        }
                    }
                } else if (associationsInfo.getAssociationType() == 1 && (associatedModel = getAssociatedModel(dataSupport, associationsInfo)) != null) {
                    associatedModel.clearSavedState();
                }
            }
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    private int deleteCascade(DataSupport dataSupport) {
        return deleteAssociatedForeignKeyRows(dataSupport) + deleteAssociatedJoinTableRows(dataSupport);
    }

    private int deleteAssociatedForeignKeyRows(DataSupport dataSupport) {
        int iDelete = 0;
        for (String str : dataSupport.getAssociatedModelsMapWithFK().keySet()) {
            String foreignKeyColumnName = getForeignKeyColumnName(dataSupport.getTableName());
            iDelete += this.mDatabase.delete(str, String.valueOf(foreignKeyColumnName) + " = " + dataSupport.getBaseObjId(), null);
        }
        return iDelete;
    }

    private int deleteAssociatedJoinTableRows(DataSupport dataSupport) {
        Iterator<String> it = dataSupport.getAssociatedModelsMapForJoinTable().keySet().iterator();
        int iDelete = 0;
        while (it.hasNext()) {
            String intermediateTableName = DBUtility.getIntermediateTableName(dataSupport.getTableName(), it.next());
            String foreignKeyColumnName = getForeignKeyColumnName(dataSupport.getTableName());
            iDelete += this.mDatabase.delete(intermediateTableName, String.valueOf(foreignKeyColumnName) + " = " + dataSupport.getBaseObjId(), null);
        }
        return iDelete;
    }

    private List<String> getForeignKeyTableToDelete() {
        if (this.foreignKeyTableToDelete == null) {
            this.foreignKeyTableToDelete = new ArrayList();
        }
        return this.foreignKeyTableToDelete;
    }
}
