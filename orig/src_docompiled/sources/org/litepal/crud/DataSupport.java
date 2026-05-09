package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public class DataSupport {
    private Map<String, Set<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    private long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    public static synchronized ClusterQuery select(String... strArr) {
        ClusterQuery clusterQuery;
        clusterQuery = new ClusterQuery();
        clusterQuery.mColumns = strArr;
        return clusterQuery;
    }

    public static synchronized ClusterQuery where(String... strArr) {
        ClusterQuery clusterQuery;
        clusterQuery = new ClusterQuery();
        clusterQuery.mConditions = strArr;
        return clusterQuery;
    }

    public static synchronized ClusterQuery order(String str) {
        ClusterQuery clusterQuery;
        clusterQuery = new ClusterQuery();
        clusterQuery.mOrderBy = str;
        return clusterQuery;
    }

    public static synchronized ClusterQuery limit(int i) {
        ClusterQuery clusterQuery;
        clusterQuery = new ClusterQuery();
        clusterQuery.mLimit = String.valueOf(i);
        return clusterQuery;
    }

    public static synchronized ClusterQuery offset(int i) {
        ClusterQuery clusterQuery;
        clusterQuery = new ClusterQuery();
        clusterQuery.mOffset = String.valueOf(i);
        return clusterQuery;
    }

    public static synchronized int count(Class<?> cls) {
        return count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    public static synchronized int count(String str) {
        return new ClusterQuery().count(str);
    }

    public static synchronized double average(Class<?> cls, String str) {
        return average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    public static synchronized double average(String str, String str2) {
        return new ClusterQuery().average(str, str2);
    }

    public static synchronized <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static synchronized <T> T max(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().max(str, str2, cls);
    }

    public static synchronized <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static synchronized <T> T min(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().min(str, str2, cls);
    }

    public static synchronized <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public static synchronized <T> T sum(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().sum(str, str2, cls);
    }

    public static synchronized <T> T find(Class<T> cls, long j) {
        return (T) find(cls, j, false);
    }

    public static synchronized <T> T find(Class<T> cls, long j, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFind(cls, j, z);
    }

    public static synchronized <T> T findFirst(Class<T> cls) {
        return (T) findFirst(cls, false);
    }

    public static synchronized <T> T findFirst(Class<T> cls, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFindFirst(cls, z);
    }

    public static synchronized <T> T findLast(Class<T> cls) {
        return (T) findLast(cls, false);
    }

    public static synchronized <T> T findLast(Class<T> cls, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFindLast(cls, z);
    }

    public static synchronized <T> List<T> findAll(Class<T> cls, long... jArr) {
        return findAll(cls, false, jArr);
    }

    public static synchronized <T> List<T> findAll(Class<T> cls, boolean z, long... jArr) {
        return new QueryHandler(Connector.getDatabase()).onFindAll(cls, z, jArr);
    }

    public static synchronized Cursor findBySQL(String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        String[] strArr2 = null;
        if (strArr == null) {
            return null;
        }
        if (strArr.length <= 0) {
            return null;
        }
        if (strArr.length != 1) {
            strArr2 = new String[strArr.length - 1];
            System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        }
        return Connector.getDatabase().rawQuery(strArr[0], strArr2);
    }

    public static synchronized int delete(Class<?> cls, long j) {
        int iOnDelete;
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            iOnDelete = new DeleteHandler(database).onDelete(cls, j);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return iOnDelete;
    }

    public static synchronized int deleteAll(Class<?> cls, String... strArr) {
        return new DeleteHandler(Connector.getDatabase()).onDeleteAll(cls, strArr);
    }

    public static synchronized int deleteAll(String str, String... strArr) {
        return new DeleteHandler(Connector.getDatabase()).onDeleteAll(str, strArr);
    }

    public static synchronized int update(Class<?> cls, ContentValues contentValues, long j) {
        return new UpdateHandler(Connector.getDatabase()).onUpdate(cls, j, contentValues);
    }

    public static synchronized int updateAll(Class<?> cls, ContentValues contentValues, String... strArr) {
        return updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), contentValues, strArr);
    }

    public static synchronized int updateAll(String str, ContentValues contentValues, String... strArr) {
        return new UpdateHandler(Connector.getDatabase()).onUpdateAll(str, contentValues, strArr);
    }

    public static synchronized <T extends DataSupport> void saveAll(Collection<T> collection) {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            try {
                new SaveHandler(database).onSaveAll(collection);
                database.setTransactionSuccessful();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage());
            }
        } finally {
            database.endTransaction();
        }
    }

    public static <T extends DataSupport> void markAsDeleted(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            it.next().clearSavedState();
        }
    }

    public synchronized int delete() {
        int iOnDelete;
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            iOnDelete = new DeleteHandler(database).onDelete(this);
            this.baseObjId = 0L;
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return iOnDelete;
    }

    public synchronized int update(long j) {
        int iOnUpdate;
        try {
            iOnUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
        return iOnUpdate;
    }

    public synchronized int updateAll(String... strArr) {
        int iOnUpdateAll;
        try {
            iOnUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
        return iOnUpdateAll;
    }

    public synchronized boolean save() {
        try {
            saveThrows();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public synchronized void saveThrows() {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        try {
            try {
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
                database.setTransactionSuccessful();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage());
            }
        } finally {
            database.endTransaction();
        }
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public void assignBaseObjId(int i) {
        this.baseObjId = i;
    }

    protected DataSupport() {
    }

    protected long getBaseObjId() {
        return this.baseObjId;
    }

    protected String getClassName() {
        return getClass().getName();
    }

    protected String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
    }

    List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    void addAssociatedModelWithFK(String str, long j) {
        Set<Long> set = getAssociatedModelsMapWithFK().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j));
            this.associatedModelsMapWithFK.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j));
    }

    Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    void addAssociatedModelForJoinTable(String str, long j) {
        Set<Long> set = getAssociatedModelsMapForJoinTable().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j));
            this.associatedModelsMapForJoinTable.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j));
    }

    void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new HashSet());
        }
    }

    Map<String, Set<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    void addAssociatedModelWithoutFK(String str, long j) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j));
    }

    Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK = getListToClearSelfFK();
        if (listToClearSelfFK.contains(str)) {
            return;
        }
        listToClearSelfFK.add(str);
    }

    List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK = getListToClearAssociatedFK();
        if (listToClearAssociatedFK.contains(str)) {
            return;
        }
        listToClearAssociatedFK.add(str);
    }

    List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    private void clearIdOfModelWithFK() {
        Iterator<String> it = getAssociatedModelsMapWithFK().keySet().iterator();
        while (it.hasNext()) {
            this.associatedModelsMapWithFK.get(it.next()).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        Iterator<String> it = getAssociatedModelsMapForJoinTable().keySet().iterator();
        while (it.hasNext()) {
            this.associatedModelsMapForJoinTable.get(it.next()).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }
}
