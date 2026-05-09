package cn.smssdk.gui;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ContactEntry implements Map.Entry<String, HashMap<String, Object>> {
    private String key;
    private HashMap<String, Object> value;

    public ContactEntry(String str, HashMap<String, Object> map) {
        this.key = str;
        this.value = map;
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public HashMap<String, Object> getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public HashMap<String, Object> setValue(HashMap<String, Object> map) {
        this.value = map;
        return this.value;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put(this.key, this.value);
        return map.toString();
    }
}
