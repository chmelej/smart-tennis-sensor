package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.umeng.message.MessageStore;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePalBase;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DataSupportException;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
abstract class DataHandler extends LitePalBase {
    public static final String TAG = "DataHandler";
    private List<AssociationsInfo> fkInCurrentModel;
    private List<AssociationsInfo> fkInOtherModel;
    SQLiteDatabase mDatabase;
    private DataSupport tempEmptyModel;

    protected boolean shouldGetOrSet(DataSupport dataSupport, Field field) {
        return (dataSupport == null || field == null) ? false : true;
    }

    DataHandler() {
    }

    protected <T> List<T> query(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, List<AssociationsInfo> list) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Exception exc;
        List<Field> supportedFields;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                supportedFields = getSupportedFields(cls.getName());
                cursorQuery = this.mDatabase.query(getTableName(cls), getCustomizedColumns(strArr, list), str, strArr2, str2, str3, str4, str5);
            } catch (Exception e) {
                exc = e;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = cursor;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                do {
                    Object objCreateInstanceFromClass = createInstanceFromClass(cls);
                    giveBaseObjIdValue((DataSupport) objCreateInstanceFromClass, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("id")));
                    setValueToModel(objCreateInstanceFromClass, supportedFields, list, cursorQuery);
                    if (list != null) {
                        setAssociatedModel((DataSupport) objCreateInstanceFromClass);
                    }
                    arrayList.add(objCreateInstanceFromClass);
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Exception e2) {
            exc = e2;
            cursor = cursorQuery;
            exc.printStackTrace();
            throw new DataSupportException(exc.getMessage());
        } catch (Throwable th3) {
            th = th3;
            if (cursorQuery != null) {
                cursorQuery.close();
                throw th;
            }
            throw th;
        }
    }

    protected <T> T mathQuery(String str, String[] strArr, String[] strArr2, Class<T> cls) throws Throwable {
        Cursor cursorQuery;
        BaseUtility.checkConditionsCorrect(strArr2);
        Cursor cursor = (T) null;
        try {
            try {
                cursorQuery = this.mDatabase.query(str, strArr, getWhereClause(strArr2), getWhereArgs(strArr2), null, null, null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            cursorQuery = cursor;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                cursor = (T) cursorQuery.getClass().getMethod(genGetColumnMethod((Class<?>) cls), Integer.TYPE).invoke(cursorQuery, 0);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return (T) cursor;
        } catch (Exception e2) {
            e = e2;
            cursor = (T) cursorQuery;
            throw new DataSupportException(e.getMessage());
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    protected void giveBaseObjIdValue(DataSupport dataSupport, long j) throws IllegalAccessException {
        if (j > 0) {
            DynamicExecutor.setField(dataSupport, "baseObjId", Long.valueOf(j), DataSupport.class);
        }
    }

    protected void putFieldsValue(DataSupport dataSupport, List<Field> list, ContentValues contentValues) {
        for (Field field : list) {
            if (!isIdColumn(field.getName())) {
                putFieldsValueDependsOnSaveOrUpdate(dataSupport, field, contentValues);
            }
        }
    }

    protected void putContentValues(DataSupport dataSupport, Field field, ContentValues contentValues) {
        Object objTakeGetMethodValueByField = takeGetMethodValueByField(dataSupport, field);
        if ("java.util.Date".equals(field.getType().getName()) && objTakeGetMethodValueByField != null) {
            objTakeGetMethodValueByField = Long.valueOf(((Date) objTakeGetMethodValueByField).getTime());
        }
        Object[] objArr = {BaseUtility.changeCase(field.getName()), objTakeGetMethodValueByField};
        DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), getParameterTypes(field, objTakeGetMethodValueByField, objArr));
    }

    protected Object takeGetMethodValueByField(DataSupport dataSupport, Field field) {
        if (shouldGetOrSet(dataSupport, field)) {
            return DynamicExecutor.send(dataSupport, makeGetterMethodName(field), null, dataSupport.getClass(), null);
        }
        return null;
    }

    protected void putSetMethodValueByField(DataSupport dataSupport, Field field, Object obj) {
        if (shouldGetOrSet(dataSupport, field)) {
            DynamicExecutor.send(dataSupport, makeSetterMethodName(field), new Object[]{obj}, dataSupport.getClass(), new Class[]{field.getType()});
        }
    }

    protected void analyzeAssociatedModels(DataSupport dataSupport, Collection<AssociationsInfo> collection) {
        try {
            for (AssociationsInfo associationsInfo : collection) {
                if (associationsInfo.getAssociationType() == 2) {
                    new Many2OneAnalyzer().analyze(dataSupport, associationsInfo);
                } else if (associationsInfo.getAssociationType() == 1) {
                    new One2OneAnalyzer().analyze(dataSupport, associationsInfo);
                } else if (associationsInfo.getAssociationType() == 3) {
                    new Many2ManyAnalyzer().analyze(dataSupport, associationsInfo);
                }
            }
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage());
        }
    }

    protected DataSupport getAssociatedModel(DataSupport dataSupport, AssociationsInfo associationsInfo) {
        return (DataSupport) takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    protected Collection<DataSupport> getAssociatedModels(DataSupport dataSupport, AssociationsInfo associationsInfo) {
        return (Collection) takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    protected DataSupport getEmptyModel(DataSupport dataSupport) {
        String className;
        if (this.tempEmptyModel != null) {
            return this.tempEmptyModel;
        }
        try {
            try {
                className = dataSupport.getClassName();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage());
            }
        } catch (ClassNotFoundException unused) {
            className = null;
        } catch (InstantiationException unused2) {
            className = null;
        }
        try {
            this.tempEmptyModel = (DataSupport) Class.forName(className).newInstance();
            return this.tempEmptyModel;
        } catch (ClassNotFoundException unused3) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + className);
        } catch (InstantiationException unused4) {
            throw new DataSupportException(String.valueOf(className) + DataSupportException.INSTANTIATION_EXCEPTION);
        }
    }

    protected String getWhereClause(String... strArr) {
        if (isAffectAllLines(strArr) || strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    protected String[] getWhereArgs(String... strArr) {
        if (isAffectAllLines(strArr) || strArr == null || strArr.length <= 1) {
            return null;
        }
        String[] strArr2 = new String[strArr.length - 1];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        return strArr2;
    }

    protected boolean isAffectAllLines(Object... objArr) {
        return objArr != null && objArr.length == 0;
    }

    protected String getWhereOfIdsWithOr(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (z) {
                sb.append(" or ");
            }
            z = true;
            sb.append("id = ");
            sb.append(jLongValue);
        }
        return BaseUtility.changeCase(sb.toString());
    }

    protected String getWhereOfIdsWithOr(long... jArr) {
        StringBuilder sb = new StringBuilder();
        int length = jArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            long j = jArr[i];
            if (z) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(j);
            i++;
            z = true;
        }
        return BaseUtility.changeCase(sb.toString());
    }

    @Deprecated
    protected Class<?> findDataSupportClass(DataSupport dataSupport) {
        Class<? super Object> superclass;
        do {
            superclass = dataSupport.getClass().getSuperclass();
            if (superclass == null) {
                break;
            }
        } while (DataSupport.class != superclass);
        if (superclass != null) {
            return superclass;
        }
        throw new DataSupportException(String.valueOf(dataSupport.getClass().getName()) + DataSupportException.MODEL_IS_NOT_AN_INSTANCE_OF_DATA_SUPPORT);
    }

    protected String getIntermediateTableName(DataSupport dataSupport, String str) {
        return BaseUtility.changeCase(DBUtility.getIntermediateTableName(dataSupport.getTableName(), str));
    }

    protected String getTableName(Class<?> cls) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName()));
    }

    protected Object createInstanceFromClass(Class<?> cls) {
        try {
            Constructor<?> constructorFindBestSuitConstructor = findBestSuitConstructor(cls);
            return constructorFindBestSuitConstructor.newInstance(getConstructorParams(cls, constructorFindBestSuitConstructor));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSupportException(e.getMessage());
        }
    }

    protected Constructor<?> findBestSuitConstructor(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        SparseArray sparseArray = new SparseArray();
        int i = Integer.MAX_VALUE;
        for (Constructor<?> constructor : declaredConstructors) {
            int length = constructor.getParameterTypes().length;
            int i2 = length;
            for (Class<?> cls2 : constructor.getParameterTypes()) {
                if (cls2 == cls) {
                    i2 += 10000;
                }
            }
            if (sparseArray.get(i2) == null) {
                sparseArray.put(i2, constructor);
            }
            if (i2 < i) {
                i = i2;
            }
        }
        Constructor<?> constructor2 = (Constructor) sparseArray.get(i);
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
        return constructor2;
    }

    protected Object[] getConstructorParams(Class<?> cls, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getInitParamValue(cls, parameterTypes[i]);
        }
        return objArr;
    }

    protected void setValueToModel(Object obj, List<Field> list, List<AssociationsInfo> list2, Cursor cursor) throws IllegalAccessException, InvocationTargetException {
        for (Field field : list) {
            String strGenGetColumnMethod = genGetColumnMethod(field);
            int columnIndex = cursor.getColumnIndex(BaseUtility.changeCase(isIdColumn(field.getName()) ? "id" : field.getName()));
            if (columnIndex != -1) {
                Object objInvoke = cursor.getClass().getMethod(strGenGetColumnMethod, Integer.TYPE).invoke(cursor, Integer.valueOf(columnIndex));
                if (isIdColumn(field.getName())) {
                    DynamicExecutor.setField(obj, field.getName(), objInvoke, obj.getClass());
                } else {
                    if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
                        if ("0".equals(String.valueOf(objInvoke))) {
                            objInvoke = false;
                        } else if ("1".equals(String.valueOf(objInvoke))) {
                            objInvoke = true;
                        }
                    } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
                        objInvoke = Character.valueOf(((String) objInvoke).charAt(0));
                    } else if (field.getType() == Date.class) {
                        long jLongValue = ((Long) objInvoke).longValue();
                        objInvoke = jLongValue <= 0 ? null : new Date(jLongValue);
                    }
                    putSetMethodValueByField((DataSupport) obj, field, objInvoke);
                }
            }
        }
        if (list2 != null) {
            for (AssociationsInfo associationsInfo : list2) {
                int columnIndex2 = cursor.getColumnIndex(getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName())));
                if (columnIndex2 != -1) {
                    try {
                        DataSupport dataSupport = (DataSupport) DataSupport.find(Class.forName(associationsInfo.getAssociatedClassName()), cursor.getLong(columnIndex2));
                        if (dataSupport != null) {
                            putSetMethodValueByField((DataSupport) obj, associationsInfo.getAssociateOtherModelFromSelf(), dataSupport);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    protected List<AssociationsInfo> getForeignKeyAssociations(String str, boolean z) {
        if (!z) {
            return null;
        }
        analyzeAssociations(str);
        return this.fkInCurrentModel;
    }

    private Class<?>[] getParameterTypes(Field field, Object obj, Object[] objArr) {
        Class<?>[] clsArr;
        if (isCharType(field)) {
            objArr[1] = String.valueOf(obj);
            return new Class[]{String.class, String.class};
        }
        if (field.getType().isPrimitive()) {
            clsArr = new Class[]{String.class, getObjectType(field.getType())};
        } else {
            if ("java.util.Date".equals(field.getType().getName())) {
                return new Class[]{String.class, Long.class};
            }
            clsArr = new Class[]{String.class, field.getType()};
        }
        return clsArr;
    }

    private Class<?> getObjectType(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return null;
        }
        String name = cls.getName();
        if ("int".equals(name)) {
            return Integer.class;
        }
        if ("short".equals(name)) {
            return Short.class;
        }
        if ("long".equals(name)) {
            return Long.class;
        }
        if ("float".equals(name)) {
            return Float.class;
        }
        if ("double".equals(name)) {
            return Double.class;
        }
        if ("boolean".equals(name)) {
            return Boolean.class;
        }
        if ("char".equals(name)) {
            return Character.class;
        }
        return null;
    }

    private Object getInitParamValue(Class<?> cls, Class<?> cls2) {
        String name = cls2.getName();
        if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
            return false;
        }
        if ("float".equals(name) || "java.lang.Float".equals(name)) {
            return Float.valueOf(0.0f);
        }
        if ("double".equals(name) || "java.lang.Double".equals(name)) {
            return Double.valueOf(0.0d);
        }
        if ("int".equals(name) || "java.lang.Integer".equals(name)) {
            return 0;
        }
        if ("long".equals(name) || "java.lang.Long".equals(name)) {
            return 0L;
        }
        if ("short".equals(name) || "java.lang.Short".equals(name)) {
            return 0;
        }
        if ("char".equals(name) || "java.lang.Character".equals(name)) {
            return ' ';
        }
        if ("java.lang.String".equals(name)) {
            return "";
        }
        if (cls == cls2) {
            return null;
        }
        return createInstanceFromClass(cls2);
    }

    private boolean isCharType(Field field) {
        String name = field.getType().getName();
        return name.equals("char") || name.endsWith("Character");
    }

    private boolean isPrimitiveBooleanType(Field field) {
        return "boolean".equals(field.getType().getName());
    }

    private void putFieldsValueDependsOnSaveOrUpdate(DataSupport dataSupport, Field field, ContentValues contentValues) {
        if (isUpdating()) {
            if (isFieldWithDefaultValue(dataSupport, field)) {
                return;
            }
            putContentValues(dataSupport, field, contentValues);
        } else {
            if (!isSaving() || takeGetMethodValueByField(dataSupport, field) == null) {
                return;
            }
            putContentValues(dataSupport, field, contentValues);
        }
    }

    private boolean isUpdating() {
        return UpdateHandler.class.getName().equals(getClass().getName());
    }

    private boolean isSaving() {
        return SaveHandler.class.getName().equals(getClass().getName());
    }

    private boolean isFieldWithDefaultValue(DataSupport dataSupport, Field field) {
        DataSupport emptyModel = getEmptyModel(dataSupport);
        Object objTakeGetMethodValueByField = takeGetMethodValueByField(dataSupport, field);
        Object objTakeGetMethodValueByField2 = takeGetMethodValueByField(emptyModel, field);
        if (objTakeGetMethodValueByField == null || objTakeGetMethodValueByField2 == null) {
            return objTakeGetMethodValueByField == objTakeGetMethodValueByField2;
        }
        return takeGetMethodValueByField(dataSupport, field).toString().equals(takeGetMethodValueByField(emptyModel, field).toString());
    }

    private String makeGetterMethodName(Field field) {
        String str;
        String name = field.getName();
        if (isPrimitiveBooleanType(field)) {
            if (name.matches("^is[A-Z]{1}.*$")) {
                name = name.substring(2);
            }
            str = "is";
        } else {
            str = "get";
        }
        if (name.matches("^[a-z]{1}[A-Z]{1}.*")) {
            return String.valueOf(str) + name;
        }
        return String.valueOf(str) + BaseUtility.capitalize(name);
    }

    private String makeSetterMethodName(Field field) {
        if (isPrimitiveBooleanType(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            return String.valueOf("set") + field.getName().substring(2);
        }
        if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            return String.valueOf("set") + field.getName();
        }
        return String.valueOf("set") + BaseUtility.capitalize(field.getName());
    }

    private String genGetColumnMethod(Field field) {
        return genGetColumnMethod(field.getType());
    }

    private String genGetColumnMethod(Class<?> cls) {
        String simpleName;
        if (cls.isPrimitive()) {
            simpleName = BaseUtility.capitalize(cls.getName());
        } else {
            simpleName = cls.getSimpleName();
        }
        String str = "get" + simpleName;
        return "getBoolean".equals(str) ? "getInt" : ("getChar".equals(str) || "getCharacter".equals(str)) ? "getString" : "getDate".equals(str) ? "getLong" : "getInteger".equals(str) ? "getInt" : str;
    }

    private String[] getCustomizedColumns(String[] strArr, List<AssociationsInfo> list) {
        if (strArr == null) {
            return null;
        }
        if (list != null && list.size() > 0) {
            String[] strArr2 = new String[strArr.length + list.size()];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            for (int i = 0; i < list.size(); i++) {
                strArr2[strArr.length + i] = getForeignKeyColumnName(DBUtility.getTableNameByClassName(list.get(i).getAssociatedClassName()));
            }
            strArr = strArr2;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (isIdColumn(str)) {
                if (MessageStore.f9157Id.equalsIgnoreCase(str)) {
                    strArr[i2] = BaseUtility.changeCase("id");
                }
                return strArr;
            }
        }
        String[] strArr3 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        strArr3[strArr.length] = BaseUtility.changeCase("id");
        return strArr3;
    }

    private void analyzeAssociations(String str) {
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(str);
        if (this.fkInCurrentModel == null) {
            this.fkInCurrentModel = new ArrayList();
        } else {
            this.fkInCurrentModel.clear();
        }
        if (this.fkInOtherModel == null) {
            this.fkInOtherModel = new ArrayList();
        } else {
            this.fkInOtherModel.clear();
        }
        for (AssociationsInfo associationsInfo : associationInfo) {
            if (associationsInfo.getAssociationType() == 2 || associationsInfo.getAssociationType() == 1) {
                if (associationsInfo.getClassHoldsForeignKey().equals(str)) {
                    this.fkInCurrentModel.add(associationsInfo);
                } else {
                    this.fkInOtherModel.add(associationsInfo);
                }
            } else if (associationsInfo.getAssociationType() == 3) {
                this.fkInOtherModel.add(associationsInfo);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setAssociatedModel(org.litepal.crud.DataSupport r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.crud.DataHandler.setAssociatedModel(org.litepal.crud.DataSupport):void");
    }
}
