package p000;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MtopResponseHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class are {
    /* JADX INFO: renamed from: a */
    public static arg m5251a(String str) {
        String[] strArrSplit;
        arg argVar = new arg();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ret");
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string) && (strArrSplit = string.split("::")) != null && 2 == strArrSplit.length) {
                    argVar.m5261c(strArrSplit[0]);
                    argVar.m5258b(strArrSplit[1]);
                    if (ard.f4846g.equals(strArrSplit[0])) {
                        argVar.m5255a(jSONObject.getString("data"));
                        argVar.m5257a(true);
                        break;
                    }
                    argVar.m5257a(false);
                    argVar.m5255a(jSONObject.getString("data"));
                }
                i++;
            }
            argVar.m5254a(200);
        } catch (Throwable unused) {
            argVar.m5257a(false);
            argVar.m5255a(str);
            argVar.m5254a(302);
        }
        aiv.m1418c("MtopResponseHelper", "MtopResponseHelper:[" + argVar.toString() + "]");
        return argVar;
    }
}
