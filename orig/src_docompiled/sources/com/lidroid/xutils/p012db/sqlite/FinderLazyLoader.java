package com.lidroid.xutils.p012db.sqlite;

import com.lidroid.xutils.p012db.table.ColumnUtils;
import com.lidroid.xutils.p012db.table.Finder;
import com.lidroid.xutils.p012db.table.Table;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FinderLazyLoader<T> {
    private final Finder finderColumn;
    private final Object finderValue;

    public FinderLazyLoader(Finder finder, Object obj) {
        this.finderColumn = finder;
        this.finderValue = ColumnUtils.convert2DbColumnValueIfNeeded(obj);
    }

    public List<T> getAllFromDb() {
        Table table = this.finderColumn.getTable();
        if (table != null) {
            return table.f8942db.findAll(Selector.from(this.finderColumn.getTargetEntityType()).where(this.finderColumn.getTargetColumnName(), "=", this.finderValue));
        }
        return null;
    }

    public T getFirstFromDb() {
        Table table = this.finderColumn.getTable();
        if (table != null) {
            return (T) table.f8942db.findFirst(Selector.from(this.finderColumn.getTargetEntityType()).where(this.finderColumn.getTargetColumnName(), "=", this.finderValue));
        }
        return null;
    }
}
