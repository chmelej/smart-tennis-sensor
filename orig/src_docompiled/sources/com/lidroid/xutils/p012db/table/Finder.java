package com.lidroid.xutils.p012db.table;

import android.database.Cursor;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.p012db.sqlite.ColumnDbType;
import com.lidroid.xutils.p012db.sqlite.FinderLazyLoader;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Finder extends Column {
    private final String targetColumnName;
    private final String valueColumnName;

    @Override // com.lidroid.xutils.p012db.table.Column
    public Object getColumnValue(Object obj) {
        return null;
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public Object getDefaultValue() {
        return null;
    }

    Finder(Class<?> cls, Field field) {
        super(cls, field);
        com.lidroid.xutils.p012db.annotation.Finder finder = (com.lidroid.xutils.p012db.annotation.Finder) field.getAnnotation(com.lidroid.xutils.p012db.annotation.Finder.class);
        this.valueColumnName = finder.valueColumn();
        this.targetColumnName = finder.targetColumn();
    }

    public Class<?> getTargetEntityType() {
        return ColumnUtils.getFinderTargetEntityType(this);
    }

    public String getTargetColumnName() {
        return this.targetColumnName;
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public void setValue2Entity(Object obj, Cursor cursor, int i) {
        Object allFromDb;
        Class<?> type = this.columnField.getType();
        Object columnValue = TableUtils.getColumnOrId(obj.getClass(), this.valueColumnName).getColumnValue(obj);
        if (type.equals(FinderLazyLoader.class)) {
            allFromDb = new FinderLazyLoader(this, columnValue);
        } else if (type.equals(List.class)) {
            try {
                allFromDb = new FinderLazyLoader(this, columnValue).getAllFromDb();
            } catch (DbException e) {
                LogUtils.m8420e(e.getMessage(), e);
                allFromDb = null;
            }
        } else {
            try {
                allFromDb = new FinderLazyLoader(this, columnValue).getFirstFromDb();
            } catch (DbException e2) {
                LogUtils.m8420e(e2.getMessage(), e2);
                allFromDb = null;
            }
        }
        if (this.setMethod != null) {
            try {
                this.setMethod.invoke(obj, allFromDb);
                return;
            } catch (Throwable th) {
                LogUtils.m8420e(th.getMessage(), th);
                return;
            }
        }
        try {
            this.columnField.setAccessible(true);
            this.columnField.set(obj, allFromDb);
        } catch (Throwable th2) {
            LogUtils.m8420e(th2.getMessage(), th2);
        }
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public ColumnDbType getColumnDbType() {
        return ColumnDbType.TEXT;
    }
}
