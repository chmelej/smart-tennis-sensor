package org.litepal.crud;

import java.util.List;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;

/* JADX INFO: loaded from: classes.dex */
public class ClusterQuery {
    String[] mColumns;
    String[] mConditions;
    String mLimit;
    String mOffset;
    String mOrderBy;

    ClusterQuery() {
    }

    public ClusterQuery select(String... strArr) {
        this.mColumns = strArr;
        return this;
    }

    public ClusterQuery where(String... strArr) {
        this.mConditions = strArr;
        return this;
    }

    public ClusterQuery order(String str) {
        this.mOrderBy = str;
        return this;
    }

    public ClusterQuery limit(int i) {
        this.mLimit = String.valueOf(i);
        return this;
    }

    public ClusterQuery offset(int i) {
        this.mOffset = String.valueOf(i);
        return this;
    }

    public <T> List<T> find(Class<T> cls) {
        return find(cls, false);
    }

    public synchronized <T> List<T> find(Class<T> cls, boolean z) {
        QueryHandler queryHandler;
        String str;
        queryHandler = new QueryHandler(Connector.getDatabase());
        if (this.mOffset == null) {
            str = this.mLimit;
        } else {
            if (this.mLimit == null) {
                this.mLimit = "0";
            }
            str = String.valueOf(this.mOffset) + "," + this.mLimit;
        }
        return queryHandler.onFind(cls, this.mColumns, this.mConditions, this.mOrderBy, str, z);
    }

    public synchronized int count(Class<?> cls) {
        return count(BaseUtility.changeCase(cls.getSimpleName()));
    }

    public synchronized int count(String str) {
        return new QueryHandler(Connector.getDatabase()).onCount(str, this.mConditions);
    }

    public synchronized double average(Class<?> cls, String str) {
        return average(BaseUtility.changeCase(cls.getSimpleName()), str);
    }

    public synchronized double average(String str, String str2) {
        return new QueryHandler(Connector.getDatabase()).onAverage(str, str2, this.mConditions);
    }

    public synchronized <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public synchronized <T> T max(String str, String str2, Class<T> cls) {
        return (T) new QueryHandler(Connector.getDatabase()).onMax(str, str2, this.mConditions, cls);
    }

    public synchronized <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public synchronized <T> T min(String str, String str2, Class<T> cls) {
        return (T) new QueryHandler(Connector.getDatabase()).onMin(str, str2, this.mConditions, cls);
    }

    public synchronized <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public synchronized <T> T sum(String str, String str2, Class<T> cls) {
        return (T) new QueryHandler(Connector.getDatabase()).onSum(str, str2, this.mConditions, cls);
    }
}
