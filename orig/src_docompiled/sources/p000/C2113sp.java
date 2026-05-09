package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: sp */
/* JADX INFO: compiled from: ZoneInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class C2113sp {

    /* JADX INFO: renamed from: c */
    private static int f12670c = 600;

    /* JADX INFO: renamed from: a */
    public final List<String> f12671a;

    /* JADX INFO: renamed from: b */
    public final Map<String, Long> f12672b;

    /* JADX INFO: renamed from: d */
    private final int f12673d;

    public C2113sp(int i, List<String> list, Map<String, Long> map) {
        this.f12673d = i;
        this.f12671a = list;
        this.f12672b = map;
    }

    /* JADX INFO: renamed from: a */
    public static C2113sp m11566a(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("ttl");
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        JSONObject jSONObject2 = jSONObject.getJSONObject("up");
        for (String str : new String[]{"acc", "src", "old_acc", "old_src"}) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
            JSONArray jSONArray = jSONObject3.getJSONArray("main");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                arrayList.add(string);
                concurrentHashMap.put(string, 0L);
            }
            try {
                JSONArray jSONArray2 = jSONObject3.getJSONArray("backup");
                if (jSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        String string2 = jSONArray2.getString(i3);
                        arrayList.add(string2);
                        concurrentHashMap.put(string2, 0L);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return new C2113sp(i, arrayList, concurrentHashMap);
    }

    /* JADX INFO: renamed from: a */
    public void m11567a(String str) {
        this.f12672b.put(str, Long.valueOf((System.currentTimeMillis() / 1000) + ((long) f12670c)));
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("ttl", Integer.valueOf(this.f12673d));
        map.put("upDomainList", this.f12671a);
        map.put("upDomainMap", this.f12672b);
        return new JSONObject(map).toString();
    }
}
