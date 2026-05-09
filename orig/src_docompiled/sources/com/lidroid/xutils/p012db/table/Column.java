package com.lidroid.xutils.p012db.table;

import android.database.Cursor;
import com.lidroid.xutils.p012db.converter.ColumnConverter;
import com.lidroid.xutils.p012db.converter.ColumnConverterFactory;
import com.lidroid.xutils.p012db.sqlite.ColumnDbType;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class Column {
    protected final ColumnConverter columnConverter;
    protected final Field columnField;
    protected final String columnName;
    private final Object defaultValue;
    protected final Method getMethod;
    private int index = -1;
    protected final Method setMethod;
    private Table table;

    Column(Class<?> cls, Field field) {
        this.columnField = field;
        this.columnConverter = ColumnConverterFactory.getColumnConverter(field.getType());
        this.columnName = ColumnUtils.getColumnNameByField(field);
        if (this.columnConverter != null) {
            this.defaultValue = this.columnConverter.getFieldValue(ColumnUtils.getColumnDefaultValue(field));
        } else {
            this.defaultValue = null;
        }
        this.getMethod = ColumnUtils.getColumnGetMethod(cls, field);
        this.setMethod = ColumnUtils.getColumnSetMethod(cls, field);
    }

    public void setValue2Entity(Object obj, Cursor cursor, int i) {
        this.index = i;
        Object fieldValue = this.columnConverter.getFieldValue(cursor, i);
        if (fieldValue == null && this.defaultValue == null) {
            return;
        }
        if (this.setMethod != null) {
            try {
                Method method = this.setMethod;
                Object[] objArr = new Object[1];
                if (fieldValue == null) {
                    fieldValue = this.defaultValue;
                }
                objArr[0] = fieldValue;
                method.invoke(obj, objArr);
                return;
            } catch (Throwable th) {
                LogUtils.m8420e(th.getMessage(), th);
                return;
            }
        }
        try {
            this.columnField.setAccessible(true);
            Field field = this.columnField;
            if (fieldValue == null) {
                fieldValue = this.defaultValue;
            }
            field.set(obj, fieldValue);
        } catch (Throwable th2) {
            LogUtils.m8420e(th2.getMessage(), th2);
        }
    }

    public Object getColumnValue(Object obj) {
        return this.columnConverter.fieldValue2ColumnValue(getFieldValue(obj));
    }

    public Object getFieldValue(Object obj) {
        if (obj != null) {
            if (this.getMethod != null) {
                try {
                    return this.getMethod.invoke(obj, new Object[0]);
                } catch (Throwable th) {
                    LogUtils.m8420e(th.getMessage(), th);
                }
            } else {
                try {
                    this.columnField.setAccessible(true);
                    return this.columnField.get(obj);
                } catch (Throwable th2) {
                    LogUtils.m8420e(th2.getMessage(), th2);
                }
            }
        }
        return null;
    }

    public Table getTable() {
        return this.table;
    }

    void setTable(Table table) {
        this.table = table;
    }

    public int getIndex() {
        return this.index;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public Field getColumnField() {
        return this.columnField;
    }

    public ColumnConverter getColumnConverter() {
        return this.columnConverter;
    }

    public ColumnDbType getColumnDbType() {
        return this.columnConverter.getColumnDbType();
    }
}
