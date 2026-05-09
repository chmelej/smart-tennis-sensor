package p000;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p000.aqg;

/* JADX INFO: compiled from: MtopSyncClientV3.java */
/* JADX INFO: loaded from: classes.dex */
public final class arf extends aqg implements aqz {

    /* JADX INFO: renamed from: a */
    private volatile String f4849a;

    /* JADX INFO: renamed from: b */
    private volatile String f4850b;

    /* JADX INFO: renamed from: c */
    private volatile String f4851c;

    @Override // p000.aqz
    /* JADX INFO: renamed from: a */
    public final void mo5186a(String str) {
        this.f4849a = str;
    }

    @Override // p000.aqz
    /* JADX INFO: renamed from: b */
    public final void mo5188b(String str) {
        this.f4850b = str;
    }

    @Override // p000.aqz
    /* JADX INFO: renamed from: c */
    public final void mo5189c(String str) {
        this.f4851c = str;
    }

    /* JADX INFO: renamed from: b */
    private final String m5252b(String str, aqf aqfVar) {
        if (aqfVar == null) {
            return str;
        }
        return str + "?" + aqfVar.m5011a();
    }

    @Override // p000.aqz
    /* JADX INFO: renamed from: a */
    public final arg mo5185a(Context context, arb arbVar) {
        try {
            arc.m5250a(arbVar, this.f4849a, this.f4850b);
            aqf aqfVarM5247a = arc.m5247a(context, arbVar);
            m5252b(this.f4851c, aqfVarM5247a);
            aqg.C0720a c0720aA = m5014a(context, this.f4851c, aqfVarM5247a);
            String str = c0720aA.f4639c;
            if (TextUtils.isEmpty(str)) {
                arg argVar = new arg();
                argVar.m5257a(false);
                argVar.m5258b("request result is null");
                return argVar;
            }
            arg argVarM5251a = are.m5251a(str);
            argVarM5251a.m5256a(c0720aA.f4638b);
            return argVarM5251a;
        } catch (Throwable th) {
            arg argVar2 = new arg();
            argVar2.m5257a(false);
            argVar2.m5258b(th.getMessage());
            return argVar2;
        }
    }

    @Override // p000.aqz
    /* JADX INFO: renamed from: b */
    public Map mo5187b(Context context, arb arbVar) {
        String strM5252b;
        arg argVar;
        aqf aqfVarM5247a;
        aqg.C0720a c0720aA;
        String str;
        HashMap map = new HashMap();
        try {
            arc.m5250a(arbVar, this.f4849a, this.f4850b);
            aqfVarM5247a = arc.m5247a(context, arbVar);
            strM5252b = m5252b(this.f4851c, aqfVarM5247a);
        } catch (Throwable th) {
            th = th;
            strM5252b = null;
        }
        try {
            c0720aA = m5014a(context, this.f4851c, aqfVarM5247a);
            str = c0720aA.f4639c;
        } catch (Throwable th2) {
            th = th2;
            argVar = new arg();
            argVar.m5257a(false);
            argVar.m5258b(th.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            arg argVar2 = new arg();
            argVar2.m5257a(false);
            argVar2.m5258b("request result is null");
            map.put("result", argVar2);
            map.put("requestUrl", strM5252b);
            return map;
        }
        argVar = are.m5251a(str);
        argVar.m5256a(c0720aA.f4638b);
        map.put("result", argVar);
        map.put("requestUrl", strM5252b);
        return map;
    }
}
