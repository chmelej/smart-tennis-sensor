package com.lidroid.xutils.p012db.table;

import com.lidroid.xutils.p012db.annotation.NoAutoIncrement;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.util.HashSet;

/* JADX INFO: renamed from: com.lidroid.xutils.db.table.Id */
/* JADX INFO: loaded from: classes.dex */
public class C1534Id extends Column {
    private String columnFieldClassName;
    private boolean isAutoIncrement;
    private boolean isAutoIncrementChecked;
    private static final HashSet<String> INTEGER_TYPES = new HashSet<>(2);
    private static final HashSet<String> AUTO_INCREMENT_TYPES = new HashSet<>(4);

    C1534Id(Class<?> cls, Field field) {
        super(cls, field);
        this.isAutoIncrementChecked = false;
        this.isAutoIncrement = false;
        this.columnFieldClassName = this.columnField.getType().getName();
    }

    public boolean isAutoIncrement() {
        if (!this.isAutoIncrementChecked) {
            this.isAutoIncrementChecked = true;
            this.isAutoIncrement = this.columnField.getAnnotation(NoAutoIncrement.class) == null && AUTO_INCREMENT_TYPES.contains(this.columnFieldClassName);
        }
        return this.isAutoIncrement;
    }

    public void setAutoIncrementId(Object obj, long j) {
        Object objValueOf = Long.valueOf(j);
        if (INTEGER_TYPES.contains(this.columnFieldClassName)) {
            objValueOf = Integer.valueOf((int) j);
        }
        if (this.setMethod != null) {
            try {
                this.setMethod.invoke(obj, objValueOf);
                return;
            } catch (Throwable th) {
                LogUtils.m8420e(th.getMessage(), th);
                return;
            }
        }
        try {
            this.columnField.setAccessible(true);
            this.columnField.set(obj, objValueOf);
        } catch (Throwable th2) {
            LogUtils.m8420e(th2.getMessage(), th2);
        }
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public Object getColumnValue(Object obj) {
        Object columnValue = super.getColumnValue(obj);
        if (columnValue == null) {
            return null;
        }
        if (isAutoIncrement() && (columnValue.equals(0) || columnValue.equals(0L))) {
            return null;
        }
        return columnValue;
    }

    static {
        INTEGER_TYPES.add(Integer.TYPE.getName());
        INTEGER_TYPES.add(Integer.class.getName());
        AUTO_INCREMENT_TYPES.addAll(INTEGER_TYPES);
        AUTO_INCREMENT_TYPES.add(Long.TYPE.getName());
        AUTO_INCREMENT_TYPES.add(Long.class.getName());
    }
}
