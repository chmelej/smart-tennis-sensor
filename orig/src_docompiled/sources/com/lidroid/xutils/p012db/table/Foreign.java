package com.lidroid.xutils.p012db.table;

import com.lidroid.xutils.p012db.converter.ColumnConverter;
import com.lidroid.xutils.p012db.converter.ColumnConverterFactory;
import com.lidroid.xutils.p012db.sqlite.ColumnDbType;
import com.lidroid.xutils.p012db.sqlite.ForeignLazyLoader;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Foreign extends Column {
    private final ColumnConverter foreignColumnConverter;
    private final String foreignColumnName;

    @Override // com.lidroid.xutils.p012db.table.Column
    public Object getDefaultValue() {
        return null;
    }

    Foreign(Class<?> cls, Field field) {
        super(cls, field);
        this.foreignColumnName = ColumnUtils.getForeignColumnNameByField(field);
        this.foreignColumnConverter = ColumnConverterFactory.getColumnConverter(TableUtils.getColumnOrId(getForeignEntityType(), this.foreignColumnName).columnField.getType());
    }

    public String getForeignColumnName() {
        return this.foreignColumnName;
    }

    public Class<?> getForeignEntityType() {
        return ColumnUtils.getForeignEntityType(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.lidroid.xutils.p012db.table.Column
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setValue2Entity(java.lang.Object r3, android.database.Cursor r4, int r5) {
        /*
            r2 = this;
            com.lidroid.xutils.db.converter.ColumnConverter r0 = r2.foreignColumnConverter
            java.lang.Object r4 = r0.getFieldValue(r4, r5)
            if (r4 != 0) goto L9
            return
        L9:
            r5 = 0
            java.lang.reflect.Field r0 = r2.columnField
            java.lang.Class r0 = r0.getType()
            java.lang.Class<com.lidroid.xutils.db.sqlite.ForeignLazyLoader> r1 = com.lidroid.xutils.p012db.sqlite.ForeignLazyLoader.class
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L1f
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r5 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader
            r5.<init>(r2, r4)
        L1d:
            r4 = r5
            goto L4d
        L1f:
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r0 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader     // Catch: com.lidroid.xutils.exception.DbException -> L31
            r0.<init>(r2, r4)     // Catch: com.lidroid.xutils.exception.DbException -> L31
            java.util.List r4 = r0.getAllFromDb()     // Catch: com.lidroid.xutils.exception.DbException -> L31
            goto L4d
        L31:
            r4 = move-exception
            java.lang.String r0 = r4.getMessage()
            com.lidroid.xutils.util.LogUtils.m8420e(r0, r4)
            goto L1d
        L3a:
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r0 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader     // Catch: com.lidroid.xutils.exception.DbException -> L44
            r0.<init>(r2, r4)     // Catch: com.lidroid.xutils.exception.DbException -> L44
            java.lang.Object r4 = r0.getFirstFromDb()     // Catch: com.lidroid.xutils.exception.DbException -> L44
            goto L4d
        L44:
            r4 = move-exception
            java.lang.String r0 = r4.getMessage()
            com.lidroid.xutils.util.LogUtils.m8420e(r0, r4)
            goto L1d
        L4d:
            java.lang.reflect.Method r5 = r2.setMethod
            r0 = 1
            if (r5 == 0) goto L66
            java.lang.reflect.Method r5 = r2.setMethod     // Catch: java.lang.Throwable -> L5d
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5d
            r1 = 0
            r0[r1] = r4     // Catch: java.lang.Throwable -> L5d
            r5.invoke(r3, r0)     // Catch: java.lang.Throwable -> L5d
            goto L79
        L5d:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.lidroid.xutils.util.LogUtils.m8420e(r4, r3)
            goto L79
        L66:
            java.lang.reflect.Field r5 = r2.columnField     // Catch: java.lang.Throwable -> L71
            r5.setAccessible(r0)     // Catch: java.lang.Throwable -> L71
            java.lang.reflect.Field r5 = r2.columnField     // Catch: java.lang.Throwable -> L71
            r5.set(r3, r4)     // Catch: java.lang.Throwable -> L71
            goto L79
        L71:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.lidroid.xutils.util.LogUtils.m8420e(r4, r3)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.p012db.table.Foreign.setValue2Entity(java.lang.Object, android.database.Cursor, int):void");
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public Object getColumnValue(Object obj) {
        Object fieldValue = getFieldValue(obj);
        Object obj2 = null;
        if (fieldValue == null) {
            return null;
        }
        Class<?> type = this.columnField.getType();
        if (type.equals(ForeignLazyLoader.class)) {
            return ((ForeignLazyLoader) fieldValue).getColumnValue();
        }
        if (type.equals(List.class)) {
            try {
                List list = (List) fieldValue;
                if (list.size() <= 0) {
                    return null;
                }
                Column columnOrId = TableUtils.getColumnOrId(ColumnUtils.getForeignEntityType(this), this.foreignColumnName);
                Object columnValue = columnOrId.getColumnValue(list.get(0));
                try {
                    Table table = getTable();
                    if (table != null && (columnOrId instanceof C1534Id)) {
                        for (Object obj3 : list) {
                            if (columnOrId.getColumnValue(obj3) == null) {
                                table.f8942db.saveOrUpdate(obj3);
                            }
                        }
                    }
                    return columnOrId.getColumnValue(list.get(0));
                } catch (Throwable th) {
                    th = th;
                    obj2 = columnValue;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            LogUtils.m8420e(th.getMessage(), th);
            return obj2;
        }
        try {
            Column columnOrId2 = TableUtils.getColumnOrId(type, this.foreignColumnName);
            Object columnValue2 = columnOrId2.getColumnValue(fieldValue);
            try {
                Table table2 = getTable();
                if (table2 != null && columnValue2 == null && (columnOrId2 instanceof C1534Id)) {
                    table2.f8942db.saveOrUpdate(fieldValue);
                }
                return columnOrId2.getColumnValue(fieldValue);
            } catch (Throwable th3) {
                th = th3;
                obj2 = columnValue2;
                LogUtils.m8420e(th.getMessage(), th);
                return obj2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.lidroid.xutils.p012db.table.Column
    public ColumnDbType getColumnDbType() {
        return this.foreignColumnConverter.getColumnDbType();
    }
}
