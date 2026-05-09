package com.lidroid.xutils.p012db.table;

import android.text.TextUtils;
import com.lidroid.xutils.DbUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Table {
    private static final HashMap<String, Table> tableMap = new HashMap<>();
    private boolean checkedDatabase;
    public final HashMap<String, Column> columnMap;

    /* JADX INFO: renamed from: db */
    public final DbUtils f8942db;
    public final HashMap<String, Finder> finderMap = new HashMap<>();

    /* JADX INFO: renamed from: id */
    public final C1534Id f8943id;
    public final String tableName;

    private Table(DbUtils dbUtils, Class<?> cls) {
        this.f8942db = dbUtils;
        this.tableName = TableUtils.getTableName(cls);
        this.f8943id = TableUtils.getId(cls);
        this.columnMap = TableUtils.getColumnMap(cls);
        for (Column column : this.columnMap.values()) {
            column.setTable(this);
            if (column instanceof Finder) {
                this.finderMap.put(column.getColumnName(), (Finder) column);
            }
        }
    }

    public static synchronized Table get(DbUtils dbUtils, Class<?> cls) {
        Table table;
        String str = String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#" + cls.getName();
        table = tableMap.get(str);
        if (table == null) {
            table = new Table(dbUtils, cls);
            tableMap.put(str, table);
        }
        return table;
    }

    public static synchronized void remove(DbUtils dbUtils, Class<?> cls) {
        tableMap.remove(String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#" + cls.getName());
    }

    public static synchronized void remove(DbUtils dbUtils, String str) {
        if (tableMap.size() > 0) {
            String key = null;
            for (Map.Entry<String, Table> entry : tableMap.entrySet()) {
                Table value = entry.getValue();
                if (value != null && value.tableName.equals(str)) {
                    key = entry.getKey();
                    if (key.startsWith(String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#")) {
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(key)) {
                tableMap.remove(key);
            }
        }
    }

    public boolean isCheckedDatabase() {
        return this.checkedDatabase;
    }

    public void setCheckedDatabase(boolean z) {
        this.checkedDatabase = z;
    }
}
