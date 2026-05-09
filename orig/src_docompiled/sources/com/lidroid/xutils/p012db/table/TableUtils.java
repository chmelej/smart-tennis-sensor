package com.lidroid.xutils.p012db.table;

import android.text.TextUtils;
import com.lidroid.xutils.p012db.annotation.InterfaceC1533Id;
import com.lidroid.xutils.p012db.annotation.Table;
import com.lidroid.xutils.p012db.converter.ColumnConverterFactory;
import com.lidroid.xutils.util.LogUtils;
import com.umeng.message.MessageStore;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class TableUtils {
    private static ConcurrentHashMap<String, HashMap<String, Column>> entityColumnsMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C1534Id> entityIdMap = new ConcurrentHashMap<>();

    private TableUtils() {
    }

    public static String getTableName(Class<?> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        if (table == null || TextUtils.isEmpty(table.name())) {
            return cls.getName().replace('.', '_');
        }
        return table.name();
    }

    public static String getExecAfterTableCreated(Class<?> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        if (table != null) {
            return table.execAfterTableCreated();
        }
        return null;
    }

    static synchronized HashMap<String, Column> getColumnMap(Class<?> cls) {
        if (entityColumnsMap.containsKey(cls.getName())) {
            return entityColumnsMap.get(cls.getName());
        }
        HashMap<String, Column> map = new HashMap<>();
        addColumns2Map(cls, getPrimaryKeyFieldName(cls), map);
        entityColumnsMap.put(cls.getName(), map);
        return map;
    }

    private static void addColumns2Map(Class<?> cls, String str, HashMap<String, Column> map) {
        if (Object.class.equals(cls)) {
            return;
        }
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!ColumnUtils.isTransient(field) && !Modifier.isStatic(field.getModifiers())) {
                    if (ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                        if (!field.getName().equals(str)) {
                            Column column = new Column(cls, field);
                            if (!map.containsKey(column.getColumnName())) {
                                map.put(column.getColumnName(), column);
                            }
                        }
                    } else if (ColumnUtils.isForeign(field)) {
                        Foreign foreign = new Foreign(cls, field);
                        if (!map.containsKey(foreign.getColumnName())) {
                            map.put(foreign.getColumnName(), foreign);
                        }
                    } else if (ColumnUtils.isFinder(field)) {
                        Finder finder = new Finder(cls, field);
                        if (!map.containsKey(finder.getColumnName())) {
                            map.put(finder.getColumnName(), finder);
                        }
                    }
                }
            }
            if (Object.class.equals(cls.getSuperclass())) {
                return;
            }
            addColumns2Map(cls.getSuperclass(), str, map);
        } catch (Throwable th) {
            LogUtils.m8420e(th.getMessage(), th);
        }
    }

    static Column getColumnOrId(Class<?> cls, String str) {
        if (getPrimaryKeyColumnName(cls).equals(str)) {
            return getId(cls);
        }
        return getColumnMap(cls).get(str);
    }

    static synchronized C1534Id getId(Class<?> cls) {
        if (Object.class.equals(cls)) {
            throw new RuntimeException("field 'id' not found");
        }
        if (entityIdMap.containsKey(cls.getName())) {
            return entityIdMap.get(cls.getName());
        }
        Field field = null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null) {
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Field field2 = declaredFields[i];
                if (field2.getAnnotation(InterfaceC1533Id.class) != null) {
                    field = field2;
                    break;
                }
                i++;
            }
            if (field == null) {
                for (Field field3 : declaredFields) {
                    if (!"id".equals(field3.getName()) && !MessageStore.f9157Id.equals(field3.getName())) {
                    }
                    field = field3;
                    break;
                }
            }
        }
        if (field == null) {
            return getId(cls.getSuperclass());
        }
        C1534Id c1534Id = new C1534Id(cls, field);
        entityIdMap.put(cls.getName(), c1534Id);
        return c1534Id;
    }

    private static String getPrimaryKeyFieldName(Class<?> cls) {
        C1534Id id = getId(cls);
        if (id == null) {
            return null;
        }
        return id.getColumnField().getName();
    }

    private static String getPrimaryKeyColumnName(Class<?> cls) {
        C1534Id id = getId(cls);
        if (id == null) {
            return null;
        }
        return id.getColumnName();
    }
}
