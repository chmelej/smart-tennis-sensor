package org.litepal;

import com.umeng.message.MessageStore;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.litepal.annotation.Column;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.tablemanager.typechange.BooleanOrm;
import org.litepal.tablemanager.typechange.DateOrm;
import org.litepal.tablemanager.typechange.DecimalOrm;
import org.litepal.tablemanager.typechange.NumericOrm;
import org.litepal.tablemanager.typechange.OrmChange;
import org.litepal.tablemanager.typechange.TextOrm;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public abstract class LitePalBase {
    private static final int GET_ASSOCIATIONS_ACTION = 1;
    private static final int GET_ASSOCIATION_INFO_ACTION = 2;
    public static final String TAG = "LitePalBase";
    private Collection<AssociationsInfo> mAssociationInfos;
    private Collection<AssociationsModel> mAssociationModels;
    private OrmChange[] typeChangeRules = {new NumericOrm(), new TextOrm(), new BooleanOrm(), new DecimalOrm(), new DateOrm()};

    protected TableModel getTableModel(String str) {
        String tableNameByClassName = DBUtility.getTableNameByClassName(str);
        TableModel tableModel = new TableModel();
        tableModel.setTableName(tableNameByClassName);
        tableModel.setClassName(str);
        Iterator<Field> it = getSupportedFields(str).iterator();
        while (it.hasNext()) {
            tableModel.addColumnModel(convertFieldToColumnModel(it.next()));
        }
        return tableModel;
    }

    protected Collection<AssociationsModel> getAssociations(List<String> list) {
        if (this.mAssociationModels == null) {
            this.mAssociationModels = new HashSet();
        }
        this.mAssociationModels.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            analyzeClassFields(it.next(), 1);
        }
        return this.mAssociationModels;
    }

    protected Collection<AssociationsInfo> getAssociationInfo(String str) {
        if (this.mAssociationInfos == null) {
            this.mAssociationInfos = new HashSet();
        }
        this.mAssociationInfos.clear();
        analyzeClassFields(str, 2);
        return this.mAssociationInfos;
    }

    protected List<Field> getSupportedFields(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Field[] declaredFields = Class.forName(str).getDeclaredFields();
            for (Field field : declaredFields) {
                Column column = (Column) field.getAnnotation(Column.class);
                if ((column == null || !column.ignore()) && !Modifier.isStatic(field.getModifiers()) && BaseUtility.isFieldTypeSupported(field.getType().getName())) {
                    arrayList.add(field);
                }
            }
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        }
    }

    protected boolean isCollection(Class<?> cls) {
        return isList(cls) || isSet(cls);
    }

    protected boolean isList(Class<?> cls) {
        return List.class.isAssignableFrom(cls);
    }

    protected boolean isSet(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }

    protected boolean isIdColumn(String str) {
        return MessageStore.f9157Id.equalsIgnoreCase(str) || "id".equalsIgnoreCase(str);
    }

    protected String getForeignKeyColumnName(String str) {
        return BaseUtility.changeCase(String.valueOf(str) + MessageStore.f9157Id);
    }

    private void analyzeClassFields(String str, int i) {
        try {
            for (Field field : Class.forName(str).getDeclaredFields()) {
                if (isPrivateAndNonPrimitive(field)) {
                    oneToAnyConditions(str, field, i);
                    manyToAnyConditions(str, field, i);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        }
    }

    private boolean isPrivateAndNonPrimitive(Field field) {
        return Modifier.isPrivate(field.getModifiers()) && !field.getType().isPrimitive();
    }

    private void oneToAnyConditions(String str, Field field, int i) {
        Class<?> type = field.getType();
        if (LitePalAttr.getInstance().getClassNames().contains(type.getName())) {
            boolean z = false;
            for (Field field2 : Class.forName(type.getName()).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type2 = field2.getType();
                    if (str.equals(type2.getName())) {
                        if (i == 1) {
                            addIntoAssociationModelCollection(str, type.getName(), type.getName(), 1);
                        } else if (i == 2) {
                            addIntoAssociationInfoCollection(str, type.getName(), type.getName(), field, field2, 1);
                        }
                    } else if (isCollection(type2) && str.equals(getGenericTypeName(field2))) {
                        if (i == 1) {
                            addIntoAssociationModelCollection(str, type.getName(), str, 2);
                        } else if (i == 2) {
                            addIntoAssociationInfoCollection(str, type.getName(), str, field, field2, 2);
                        }
                    }
                    z = true;
                }
            }
            if (z) {
                return;
            }
            if (i == 1) {
                addIntoAssociationModelCollection(str, type.getName(), type.getName(), 1);
            } else if (i == 2) {
                addIntoAssociationInfoCollection(str, type.getName(), type.getName(), field, null, 1);
            }
        }
    }

    private void manyToAnyConditions(String str, Field field, int i) {
        if (isCollection(field.getType())) {
            String genericTypeName = getGenericTypeName(field);
            if (LitePalAttr.getInstance().getClassNames().contains(genericTypeName)) {
                boolean z = false;
                for (Field field2 : Class.forName(genericTypeName).getDeclaredFields()) {
                    if (!Modifier.isStatic(field2.getModifiers())) {
                        Class<?> type = field2.getType();
                        if (str.equals(type.getName())) {
                            if (i == 1) {
                                addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
                            } else if (i == 2) {
                                addIntoAssociationInfoCollection(str, genericTypeName, genericTypeName, field, field2, 2);
                            }
                        } else if (isCollection(type) && str.equals(getGenericTypeName(field2))) {
                            if (i == 1) {
                                addIntoAssociationModelCollection(str, genericTypeName, null, 3);
                            } else if (i == 2) {
                                addIntoAssociationInfoCollection(str, genericTypeName, null, field, field2, 3);
                            }
                        }
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                if (i == 1) {
                    addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
                } else if (i == 2) {
                    addIntoAssociationInfoCollection(str, genericTypeName, genericTypeName, field, null, 2);
                }
            }
        }
    }

    private void addIntoAssociationModelCollection(String str, String str2, String str3, int i) {
        AssociationsModel associationsModel = new AssociationsModel();
        associationsModel.setTableName(DBUtility.getTableNameByClassName(str));
        associationsModel.setAssociatedTableName(DBUtility.getTableNameByClassName(str2));
        associationsModel.setTableHoldsForeignKey(DBUtility.getTableNameByClassName(str3));
        associationsModel.setAssociationType(i);
        this.mAssociationModels.add(associationsModel);
    }

    private void addIntoAssociationInfoCollection(String str, String str2, String str3, Field field, Field field2, int i) {
        AssociationsInfo associationsInfo = new AssociationsInfo();
        associationsInfo.setSelfClassName(str);
        associationsInfo.setAssociatedClassName(str2);
        associationsInfo.setClassHoldsForeignKey(str3);
        associationsInfo.setAssociateOtherModelFromSelf(field);
        associationsInfo.setAssociateSelfFromOtherModel(field2);
        associationsInfo.setAssociationType(i);
        this.mAssociationInfos.add(associationsInfo);
    }

    private String getGenericTypeName(Field field) {
        Type genericType = field.getGenericType();
        if (genericType == null || !(genericType instanceof ParameterizedType)) {
            return null;
        }
        return ((Class) ((ParameterizedType) genericType).getActualTypeArguments()[0]).getName();
    }

    private ColumnModel convertFieldToColumnModel(Field field) {
        String strDefaultValue;
        boolean zNullable;
        String name = field.getType().getName();
        boolean zUnique = false;
        String strObject2Relation = null;
        for (OrmChange ormChange : this.typeChangeRules) {
            strObject2Relation = ormChange.object2Relation(name);
            if (strObject2Relation != null) {
                break;
            }
        }
        Column column = (Column) field.getAnnotation(Column.class);
        if (column != null) {
            zNullable = column.nullable();
            zUnique = column.unique();
            strDefaultValue = column.defaultValue();
        } else {
            strDefaultValue = "";
            zNullable = true;
        }
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(field.getName());
        columnModel.setColumnType(strObject2Relation);
        columnModel.setIsNullable(zNullable);
        columnModel.setIsUnique(zUnique);
        columnModel.setDefaultValue(strDefaultValue);
        return columnModel;
    }
}
