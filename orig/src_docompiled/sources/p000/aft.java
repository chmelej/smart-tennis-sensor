package p000;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: UMCCDBUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class aft {
    /* JADX INFO: renamed from: a */
    public static String m904a(Context context) {
        return "/data/data/" + context.getPackageName() + "/databases/cc/";
    }

    /* JADX INFO: renamed from: a */
    public static String m905a(List<String> list) {
        return TextUtils.join("!", list);
    }

    /* JADX INFO: renamed from: a */
    public static JSONArray m906a(String str) {
        String[] strArrSplit = str.split("!");
        JSONArray jSONArray = new JSONArray();
        for (String str2 : strArrSplit) {
            jSONArray.put(str2);
        }
        return jSONArray;
    }
}
