package com.lidroid.xutils.p012db.sqlite;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.p012db.table.C1534Id;
import com.lidroid.xutils.p012db.table.Column;
import com.lidroid.xutils.p012db.table.ColumnUtils;
import com.lidroid.xutils.p012db.table.Finder;
import com.lidroid.xutils.p012db.table.KeyValue;
import com.lidroid.xutils.p012db.table.Table;
import com.lidroid.xutils.p012db.table.TableUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SqlInfoBuilder {
    private SqlInfoBuilder() {
    }

    public static SqlInfo buildInsertSqlInfo(DbUtils dbUtils, Object obj) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(TableUtils.getTableName(obj.getClass()));
        stringBuffer.append(" (");
        for (KeyValue keyValue : listEntity2KeyValueList) {
            stringBuffer.append(keyValue.key);
            stringBuffer.append(",");
            sqlInfo.addBindArgWithoutConverter(keyValue.value);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = listEntity2KeyValueList.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildReplaceSqlInfo(DbUtils dbUtils, Object obj) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("REPLACE INTO ");
        stringBuffer.append(TableUtils.getTableName(obj.getClass()));
        stringBuffer.append(" (");
        for (KeyValue keyValue : listEntity2KeyValueList) {
            stringBuffer.append(keyValue.key);
            stringBuffer.append(",");
            sqlInfo.addBindArgWithoutConverter(keyValue.value);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = listEntity2KeyValueList.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    private static String buildDeleteSqlByTableName(String str) {
        return "DELETE FROM " + str;
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        Table table = Table.get(dbUtils, obj.getClass());
        C1534Id c1534Id = table.f8943id;
        Object columnValue = c1534Id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
        }
        sqlInfo.setSql(buildDeleteSqlByTableName(table.tableName) + " WHERE " + WhereBuilder.m8414b(c1534Id.getColumnName(), "=", columnValue));
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Class<?> cls, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        Table table = Table.get(dbUtils, cls);
        C1534Id c1534Id = table.f8943id;
        if (obj == null) {
            throw new DbException("this entity[" + cls + "]'s id value is null");
        }
        sqlInfo.setSql(buildDeleteSqlByTableName(table.tableName) + " WHERE " + WhereBuilder.m8414b(c1534Id.getColumnName(), "=", obj));
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Class<?> cls, WhereBuilder whereBuilder) {
        StringBuilder sb = new StringBuilder(buildDeleteSqlByTableName(Table.get(dbUtils, cls).tableName));
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ");
            sb.append(whereBuilder.toString());
        }
        return new SqlInfo(sb.toString());
    }

    public static SqlInfo buildUpdateSqlInfo(DbUtils dbUtils, Object obj, String... strArr) throws DbException {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        HashSet hashSet = null;
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        Table table = Table.get(dbUtils, obj.getClass());
        C1534Id c1534Id = table.f8943id;
        Object columnValue = c1534Id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(table.tableName);
        stringBuffer.append(" SET ");
        for (KeyValue keyValue : listEntity2KeyValueList) {
            if (hashSet == null || hashSet.contains(keyValue.key)) {
                stringBuffer.append(keyValue.key);
                stringBuffer.append("=?,");
                sqlInfo.addBindArgWithoutConverter(keyValue.value);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" WHERE ");
        stringBuffer.append(WhereBuilder.m8414b(c1534Id.getColumnName(), "=", columnValue));
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(DbUtils dbUtils, Object obj, WhereBuilder whereBuilder, String... strArr) {
        List<KeyValue> listEntity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        HashSet hashSet = null;
        if (listEntity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        String tableName = TableUtils.getTableName(obj.getClass());
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(tableName);
        stringBuffer.append(" SET ");
        for (KeyValue keyValue : listEntity2KeyValueList) {
            if (hashSet == null || hashSet.contains(keyValue.key)) {
                stringBuffer.append(keyValue.key);
                stringBuffer.append("=?,");
                sqlInfo.addBindArgWithoutConverter(keyValue.value);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(whereBuilder.toString());
        }
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildCreateTableSqlInfo(DbUtils dbUtils, Class<?> cls) {
        Table table = Table.get(dbUtils, cls);
        C1534Id c1534Id = table.f8943id;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(table.tableName);
        stringBuffer.append(" ( ");
        if (c1534Id.isAutoIncrement()) {
            stringBuffer.append("\"");
            stringBuffer.append(c1534Id.getColumnName());
            stringBuffer.append("\"  ");
            stringBuffer.append("INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            stringBuffer.append("\"");
            stringBuffer.append(c1534Id.getColumnName());
            stringBuffer.append("\"  ");
            stringBuffer.append(c1534Id.getColumnDbType());
            stringBuffer.append(" PRIMARY KEY,");
        }
        for (Column column : table.columnMap.values()) {
            if (!(column instanceof Finder)) {
                stringBuffer.append("\"");
                stringBuffer.append(column.getColumnName());
                stringBuffer.append("\"  ");
                stringBuffer.append(column.getColumnDbType());
                if (ColumnUtils.isUnique(column.getColumnField())) {
                    stringBuffer.append(" UNIQUE");
                }
                if (ColumnUtils.isNotNull(column.getColumnField())) {
                    stringBuffer.append(" NOT NULL");
                }
                String check = ColumnUtils.getCheck(column.getColumnField());
                if (check != null) {
                    stringBuffer.append(" CHECK(");
                    stringBuffer.append(check);
                    stringBuffer.append(")");
                }
                stringBuffer.append(",");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return new SqlInfo(stringBuffer.toString());
    }

    private static KeyValue column2KeyValue(Object obj, Column column) {
        String columnName = column.getColumnName();
        if (columnName == null) {
            return null;
        }
        Object columnValue = column.getColumnValue(obj);
        if (columnValue == null) {
            columnValue = column.getDefaultValue();
        }
        return new KeyValue(columnName, columnValue);
    }

    public static List<KeyValue> entity2KeyValueList(DbUtils dbUtils, Object obj) {
        KeyValue keyValueColumn2KeyValue;
        ArrayList arrayList = new ArrayList();
        Table table = Table.get(dbUtils, obj.getClass());
        C1534Id c1534Id = table.f8943id;
        if (!c1534Id.isAutoIncrement()) {
            arrayList.add(new KeyValue(c1534Id.getColumnName(), c1534Id.getColumnValue(obj)));
        }
        for (Column column : table.columnMap.values()) {
            if (!(column instanceof Finder) && (keyValueColumn2KeyValue = column2KeyValue(obj, column)) != null) {
                arrayList.add(keyValueColumn2KeyValue);
            }
        }
        return arrayList;
    }
}
