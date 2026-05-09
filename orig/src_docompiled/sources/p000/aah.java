package p000;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aah extends aai {

    /* JADX INFO: renamed from: a */
    private String f24a;

    /* JADX INFO: renamed from: m */
    private int f25m;

    /* JADX INFO: renamed from: n */
    private int f26n;

    /* JADX INFO: renamed from: o */
    private Thread f27o;

    public aah(Context context, int i, Throwable th, ace aceVar) {
        super(context, i, aceVar);
        this.f26n = 100;
        this.f27o = null;
        m20a(99, th);
    }

    public aah(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        this.f26n = 100;
        this.f27o = null;
        m20a(2, th);
        this.f27o = thread;
    }

    /* JADX INFO: renamed from: a */
    private void m20a(int i, Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f24a = stringWriter.toString();
            this.f25m = i;
            printWriter.close();
        }
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) throws JSONException {
        abz.m134a(jSONObject, "er", this.f24a);
        jSONObject.put("ea", this.f25m);
        if (this.f25m != 2 && this.f25m != 3) {
            return true;
        }
        new abl(this.f39l).m66a(jSONObject, this.f27o);
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.ERROR;
    }
}
