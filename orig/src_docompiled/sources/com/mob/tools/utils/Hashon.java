package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Hashon {
    public <T> HashMap<String, T> fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        try {
            if (str.startsWith("[") && str.endsWith("]")) {
                str = "{\"fakelist\":" + str + "}";
            }
            return fromJson(new JSONObject(str));
        } catch (Throwable th) {
            MobLog.getInstance().m8621w(str, new Object[0]);
            MobLog.getInstance().m8622w(th);
            return new HashMap<>();
        }
    }

    private <T> HashMap<String, T> fromJson(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = (HashMap<String, T>) new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (JSONObject.NULL.equals(objOpt)) {
                objOpt = null;
            }
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    objOpt = fromJson((JSONObject) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    objOpt = fromJson((JSONArray) objOpt);
                }
                linkedHashMap.put(next, objOpt);
            }
        }
        return linkedHashMap;
    }

    private ArrayList<Object> fromJson(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArray.opt(i);
            if (objOpt instanceof JSONObject) {
                objOpt = fromJson((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = fromJson((JSONArray) objOpt);
            }
            arrayList.add(objOpt);
        }
        return arrayList;
    }

    public <T> String fromHashMap(HashMap<String, T> map) {
        try {
            JSONObject jSONObject = getJSONObject(map);
            return jSONObject == null ? "" : jSONObject.toString();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "";
        }
    }

    private <T> JSONObject getJSONObject(HashMap<String, T> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                value = getJSONObject((HashMap) value);
            } else if (value instanceof ArrayList) {
                value = getJSONArray((ArrayList) value);
            } else if (isBasicArray(value)) {
                value = getJSONArray(arrayToList(value));
            }
            jSONObject.put(entry.getKey(), value);
        }
        return jSONObject;
    }

    private boolean isBasicArray(Object obj) {
        return (obj instanceof byte[]) || (obj instanceof short[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[]) || (obj instanceof double[]) || (obj instanceof char[]) || (obj instanceof boolean[]) || (obj instanceof String[]);
    }

    private ArrayList<?> arrayToList(Object obj) {
        int i = 0;
        if (obj instanceof byte[]) {
            ArrayList<?> arrayList = new ArrayList<>();
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            while (i < length) {
                arrayList.add(Byte.valueOf(bArr[i]));
                i++;
            }
            return arrayList;
        }
        if (obj instanceof short[]) {
            ArrayList<?> arrayList2 = new ArrayList<>();
            short[] sArr = (short[]) obj;
            int length2 = sArr.length;
            while (i < length2) {
                arrayList2.add(Short.valueOf(sArr[i]));
                i++;
            }
            return arrayList2;
        }
        if (obj instanceof int[]) {
            ArrayList<?> arrayList3 = new ArrayList<>();
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                arrayList3.add(Integer.valueOf(iArr[i]));
                i++;
            }
            return arrayList3;
        }
        if (obj instanceof long[]) {
            ArrayList<?> arrayList4 = new ArrayList<>();
            long[] jArr = (long[]) obj;
            int length4 = jArr.length;
            while (i < length4) {
                arrayList4.add(Long.valueOf(jArr[i]));
                i++;
            }
            return arrayList4;
        }
        if (obj instanceof float[]) {
            ArrayList<?> arrayList5 = new ArrayList<>();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i < length5) {
                arrayList5.add(Float.valueOf(fArr[i]));
                i++;
            }
            return arrayList5;
        }
        if (obj instanceof double[]) {
            ArrayList<?> arrayList6 = new ArrayList<>();
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i < length6) {
                arrayList6.add(Double.valueOf(dArr[i]));
                i++;
            }
            return arrayList6;
        }
        if (obj instanceof char[]) {
            ArrayList<?> arrayList7 = new ArrayList<>();
            char[] cArr = (char[]) obj;
            int length7 = cArr.length;
            while (i < length7) {
                arrayList7.add(Character.valueOf(cArr[i]));
                i++;
            }
            return arrayList7;
        }
        if (obj instanceof boolean[]) {
            ArrayList<?> arrayList8 = new ArrayList<>();
            boolean[] zArr = (boolean[]) obj;
            int length8 = zArr.length;
            while (i < length8) {
                arrayList8.add(Boolean.valueOf(zArr[i]));
                i++;
            }
            return arrayList8;
        }
        if (!(obj instanceof String[])) {
            return null;
        }
        ArrayList<?> arrayList9 = new ArrayList<>();
        String[] strArr = (String[]) obj;
        int length9 = strArr.length;
        while (i < length9) {
            arrayList9.add(strArr[i]);
            i++;
        }
        return arrayList9;
    }

    private JSONArray getJSONArray(ArrayList<Object> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object jSONArray2 : arrayList) {
            if (jSONArray2 instanceof HashMap) {
                jSONArray2 = getJSONObject((HashMap) jSONArray2);
            } else if (jSONArray2 instanceof ArrayList) {
                jSONArray2 = getJSONArray((ArrayList) jSONArray2);
            }
            jSONArray.put(jSONArray2);
        }
        return jSONArray;
    }

    public String format(String str) {
        try {
            return format("", fromJson(str));
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "";
        }
    }

    private String format(String str, HashMap<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\n");
        String str2 = str + "\t";
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (i > 0) {
                stringBuffer.append(",\n");
            }
            stringBuffer.append(str2);
            stringBuffer.append('\"');
            stringBuffer.append(entry.getKey());
            stringBuffer.append("\":");
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                stringBuffer.append(format(str2, (HashMap<String, Object>) value));
            } else if (value instanceof ArrayList) {
                stringBuffer.append(format(str2, (ArrayList<Object>) value));
            } else if (value instanceof String) {
                stringBuffer.append('\"');
                stringBuffer.append(value);
                stringBuffer.append('\"');
            } else {
                stringBuffer.append(value);
            }
            i++;
        }
        stringBuffer.append('\n');
        stringBuffer.append(str);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    private String format(String str, ArrayList<Object> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[\n");
        String str2 = str + "\t";
        int i = 0;
        for (Object obj : arrayList) {
            if (i > 0) {
                stringBuffer.append(",\n");
            }
            stringBuffer.append(str2);
            if (obj instanceof HashMap) {
                stringBuffer.append(format(str2, (HashMap<String, Object>) obj));
            } else if (obj instanceof ArrayList) {
                stringBuffer.append(format(str2, (ArrayList<Object>) obj));
            } else if (obj instanceof String) {
                stringBuffer.append('\"');
                stringBuffer.append(obj);
                stringBuffer.append('\"');
            } else {
                stringBuffer.append(obj);
            }
            i++;
        }
        stringBuffer.append('\n');
        stringBuffer.append(str);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}
