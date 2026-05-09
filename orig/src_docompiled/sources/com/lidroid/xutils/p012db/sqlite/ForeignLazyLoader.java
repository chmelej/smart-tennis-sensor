package com.lidroid.xutils.p012db.sqlite;

import com.lidroid.xutils.p012db.table.ColumnUtils;
import com.lidroid.xutils.p012db.table.Foreign;
import com.lidroid.xutils.p012db.table.Table;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ForeignLazyLoader<T> {
    private Object columnValue;
    private final Foreign foreignColumn;

    public ForeignLazyLoader(Foreign foreign, Object obj) {
        this.foreignColumn = foreign;
        this.columnValue = ColumnUtils.convert2DbColumnValueIfNeeded(obj);
    }

    public List<T> getAllFromDb() {
        Table table = this.foreignColumn.getTable();
        if (table != null) {
            return table.f8942db.findAll(Selector.from(this.foreignColumn.getForeignEntityType()).where(this.foreignColumn.getForeignColumnName(), "=", this.columnValue));
        }
        return null;
    }

    public T getFirstFromDb() {
        Table table = this.foreignColumn.getTable();
        if (table != null) {
            return (T) table.f8942db.findFirst(Selector.from(this.foreignColumn.getForeignEntityType()).where(this.foreignColumn.getForeignColumnName(), "=", this.columnValue));
        }
        return null;
    }

    public void setColumnValue(Object obj) {
        this.columnValue = ColumnUtils.convert2DbColumnValueIfNeeded(obj);
    }

    public Object getColumnValue() {
        return this.columnValue;
    }
}
