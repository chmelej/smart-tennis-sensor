package com.lidroid.xutils.p012db.sqlite;

import android.text.TextUtils;
import com.lidroid.xutils.p012db.converter.ColumnConverterFactory;
import com.lidroid.xutils.p012db.table.ColumnUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WhereBuilder {
    private final List<String> whereItems = new ArrayList();

    private WhereBuilder() {
    }

    /* JADX INFO: renamed from: b */
    public static WhereBuilder m8413b() {
        return new WhereBuilder();
    }

    /* JADX INFO: renamed from: b */
    public static WhereBuilder m8414b(String str, String str2, Object obj) {
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.appendCondition(null, str, str2, obj);
        return whereBuilder;
    }

    public WhereBuilder and(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    /* JADX INFO: renamed from: or */
    public WhereBuilder m8415or(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "OR", str, str2, obj);
        return this;
    }

    public WhereBuilder expr(String str) {
        this.whereItems.add(" " + str);
        return this;
    }

    public WhereBuilder expr(String str, String str2, Object obj) {
        appendCondition(null, str, str2, obj);
        return this;
    }

    public int getWhereItemSize() {
        return this.whereItems.size();
    }

    public String toString() {
        if (this.whereItems.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.whereItems.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    private void appendCondition(String str, String str2, String str3, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (this.whereItems.size() > 0) {
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(String.valueOf(str) + " ");
        }
        sb.append(str2);
        if ("!=".equals(str3)) {
            str3 = "<>";
        } else if ("==".equals(str3)) {
            str3 = "=";
        }
        if (obj == null) {
            if ("=".equals(str3)) {
                sb.append(" IS NULL");
            } else if ("<>".equals(str3)) {
                sb.append(" IS NOT NULL");
            } else {
                sb.append(" " + str3 + " NULL");
            }
        } else {
            sb.append(" " + str3 + " ");
            int i = 0;
            Iterable iterable = null;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    ArrayList arrayList = new ArrayList();
                    int length = Array.getLength(obj);
                    while (i < length) {
                        arrayList.add(Array.get(obj, i));
                        i++;
                    }
                    iterable = arrayList;
                }
                if (iterable != null) {
                    StringBuffer stringBuffer = new StringBuffer("(");
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        Object objConvert2DbColumnValueIfNeeded = ColumnUtils.convert2DbColumnValueIfNeeded(it.next());
                        if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(objConvert2DbColumnValueIfNeeded.getClass()))) {
                            String string = objConvert2DbColumnValueIfNeeded.toString();
                            if (string.indexOf(39) != -1) {
                                string = string.replace("'", "''");
                            }
                            stringBuffer.append("'" + string + "'");
                        } else {
                            stringBuffer.append(objConvert2DbColumnValueIfNeeded);
                        }
                        stringBuffer.append(",");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    stringBuffer.append(")");
                    sb.append(stringBuffer.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = Array.getLength(obj);
                    while (i < length2) {
                        arrayList2.add(Array.get(obj, i));
                        i++;
                    }
                    iterable = arrayList2;
                }
                if (iterable != null) {
                    Iterator it2 = iterable.iterator();
                    if (!it2.hasNext()) {
                        throw new IllegalArgumentException("value must have tow items.");
                    }
                    Object next = it2.next();
                    if (!it2.hasNext()) {
                        throw new IllegalArgumentException("value must have tow items.");
                    }
                    Object next2 = it2.next();
                    Object objConvert2DbColumnValueIfNeeded2 = ColumnUtils.convert2DbColumnValueIfNeeded(next);
                    Object objConvert2DbColumnValueIfNeeded3 = ColumnUtils.convert2DbColumnValueIfNeeded(next2);
                    if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(objConvert2DbColumnValueIfNeeded2.getClass()))) {
                        String string2 = objConvert2DbColumnValueIfNeeded2.toString();
                        if (string2.indexOf(39) != -1) {
                            string2 = string2.replace("'", "''");
                        }
                        String string3 = objConvert2DbColumnValueIfNeeded3.toString();
                        if (string3.indexOf(39) != -1) {
                            string3 = string3.replace("'", "''");
                        }
                        sb.append("'" + string2 + "'");
                        sb.append(" AND ");
                        sb.append("'" + string3 + "'");
                    } else {
                        sb.append(objConvert2DbColumnValueIfNeeded2);
                        sb.append(" AND ");
                        sb.append(objConvert2DbColumnValueIfNeeded3);
                    }
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                Object objConvert2DbColumnValueIfNeeded4 = ColumnUtils.convert2DbColumnValueIfNeeded(obj);
                if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(objConvert2DbColumnValueIfNeeded4.getClass()))) {
                    String string4 = objConvert2DbColumnValueIfNeeded4.toString();
                    if (string4.indexOf(39) != -1) {
                        string4 = string4.replace("'", "''");
                    }
                    sb.append("'" + string4 + "'");
                } else {
                    sb.append(objConvert2DbColumnValueIfNeeded4);
                }
            }
        }
        this.whereItems.add(sb.toString());
    }
}
