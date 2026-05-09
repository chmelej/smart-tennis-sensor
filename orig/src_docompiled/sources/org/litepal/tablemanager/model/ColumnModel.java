package org.litepal.tablemanager.model;

import android.text.TextUtils;
import com.umeng.message.MessageStore;

/* JADX INFO: loaded from: classes.dex */
public class ColumnModel {
    private String columnName;
    private String columnType;
    private boolean isNullable = true;
    private boolean isUnique = false;
    private String defaultValue = "";

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public void setColumnType(String str) {
        this.columnType = str;
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public void setIsNullable(boolean z) {
        this.isNullable = z;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setIsUnique(boolean z) {
        this.isUnique = z;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String str) {
        if ("text".equalsIgnoreCase(this.columnType)) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.defaultValue = "'" + str + "'";
            return;
        }
        this.defaultValue = str;
    }

    public boolean isIdColumn() {
        return MessageStore.f9157Id.equalsIgnoreCase(this.columnName) || "id".equalsIgnoreCase(this.columnName);
    }
}
