package p000;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: vu */
/* JADX INFO: compiled from: DraftBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C2199vu {

    /* JADX INFO: renamed from: a */
    private static C2199vu f13203a;

    /* JADX INFO: renamed from: b */
    private Context f13204b;

    /* JADX INFO: renamed from: c */
    private List<C2198vt> f13205c;

    /* JADX INFO: renamed from: a */
    public static synchronized C2199vu m12032a(Context context) {
        if (f13203a == null) {
            f13203a = new C2199vu(context);
        }
        return f13203a;
    }

    /* JADX INFO: renamed from: a */
    public synchronized C2198vt m12035a(String str) {
        for (C2198vt c2198vt : this.f13205c) {
            if (c2198vt.m12022a().equals(str)) {
                return c2198vt;
            }
        }
        return null;
    }

    private C2199vu(Context context) {
        this.f13204b = context.getApplicationContext();
        if (m12033a()) {
            List<C2198vt> listM12034b = m12034b();
            if (listM12034b == null) {
                C2201vw.f13215d.m12052c("Error on construct DraftBox, parse file failed, creating empty DraftBox");
                this.f13205c = new ArrayList();
                return;
            } else {
                this.f13205c = listM12034b;
                return;
            }
        }
        this.f13205c = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    private boolean m12033a() {
        return new File(this.f13204b.getFilesDir().getPath() + "/drafts.json").exists();
    }

    /* JADX INFO: renamed from: b */
    private List<C2198vt> m12034b() {
        File file = new File(this.f13204b.getFilesDir().getPath() + "/drafts.json");
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    JSONObject jSONObject = new JSONObject(line);
                    C2198vt c2198vt = new C2198vt();
                    Stack<C2184vf> stack = new Stack<>();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next.equals("tag")) {
                            c2198vt.m12023a(jSONObject.optString("tag"));
                        }
                        if (next.equals("PLCameraSetting")) {
                            c2198vt.m12026a(C2155ud.m11755a(jSONObject.optJSONObject("PLCameraSetting")));
                        }
                        if (next.equals("PLMicrophoneSetting")) {
                            c2198vt.m12028a(C2161uj.m11775a(jSONObject.optJSONObject("PLMicrophoneSetting")));
                        }
                        if (next.equals("PLVideoEncodeSetting")) {
                            c2198vt.m12030a(C2169ur.m11821a(this.f13204b, jSONObject.optJSONObject("PLVideoEncodeSetting")));
                        }
                        if (next.equals("PLAudioEncodeSetting")) {
                            c2198vt.m12025a(C2150tz.m11740a(jSONObject.optJSONObject("PLAudioEncodeSetting")));
                        }
                        if (next.equals("PLFaceBeautySetting")) {
                            c2198vt.m12027a(C2158ug.m11765a(jSONObject.optJSONObject("PLFaceBeautySetting")));
                        }
                        if (next.equals("PLRecordSetting")) {
                            c2198vt.m12029a(C2162uk.m11787a(jSONObject.optJSONObject("PLRecordSetting")));
                        }
                        if (next.equals("sections")) {
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sections");
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                stack.push(C2184vf.m11925a(jSONArrayOptJSONArray.getJSONObject(i)));
                            }
                            c2198vt.m12024a(stack);
                        }
                    }
                    arrayList.add(c2198vt);
                } else {
                    bufferedReader.close();
                    return arrayList;
                }
            }
        } catch (IOException | JSONException unused) {
            C2201vw.f13215d.m12055e("DraftBox", "Error on recoverFromFile");
            return null;
        }
    }
}
