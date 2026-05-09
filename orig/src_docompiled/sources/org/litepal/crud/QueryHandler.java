package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import org.litepal.util.BaseUtility;

/* JADX INFO: loaded from: classes.dex */
class QueryHandler extends DataHandler {
    QueryHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    <T> T onFind(Class<T> cls, long j, boolean z) {
        List<T> listQuery = query(cls, null, "id = ?", new String[]{String.valueOf(j)}, null, null, null, null, getForeignKeyAssociations(cls.getName(), z));
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    <T> T onFindFirst(Class<T> cls, boolean z) {
        List<T> listQuery = query(cls, null, null, null, null, null, "id", "1", getForeignKeyAssociations(cls.getName(), z));
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    <T> T onFindLast(Class<T> cls, boolean z) {
        List<T> listQuery = query(cls, null, null, null, null, null, "id desc", "1", getForeignKeyAssociations(cls.getName(), z));
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    <T> List<T> onFindAll(Class<T> cls, boolean z, long... jArr) {
        if (isAffectAllLines(jArr)) {
            return query(cls, null, null, null, null, null, "id", null, getForeignKeyAssociations(cls.getName(), z));
        }
        return query(cls, null, getWhereOfIdsWithOr(jArr), null, null, null, "id", null, getForeignKeyAssociations(cls.getName(), z));
    }

    <T> List<T> onFind(Class<T> cls, String[] strArr, String[] strArr2, String str, String str2, boolean z) {
        BaseUtility.checkConditionsCorrect(strArr2);
        return query(cls, strArr, getWhereClause(strArr2), getWhereArgs(strArr2), null, null, str, str2, getForeignKeyAssociations(cls.getName(), z));
    }

    int onCount(String str, String[] strArr) {
        return ((Integer) mathQuery(str, new String[]{"count(1)"}, strArr, Integer.TYPE)).intValue();
    }

    double onAverage(String str, String str2, String[] strArr) {
        return ((Double) mathQuery(str, new String[]{"avg(" + str2 + ")"}, strArr, Double.TYPE)).doubleValue();
    }

    <T> T onMax(String str, String str2, String[] strArr, Class<T> cls) {
        return (T) mathQuery(str, new String[]{"max(" + str2 + ")"}, strArr, cls);
    }

    <T> T onMin(String str, String str2, String[] strArr, Class<T> cls) {
        return (T) mathQuery(str, new String[]{"min(" + str2 + ")"}, strArr, cls);
    }

    <T> T onSum(String str, String str2, String[] strArr, Class<T> cls) {
        return (T) mathQuery(str, new String[]{"sum(" + str2 + ")"}, strArr, cls);
    }
}
