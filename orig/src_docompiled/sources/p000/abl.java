package p000;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class abl {

    /* JADX INFO: renamed from: a */
    static abm f122a;

    /* JADX INFO: renamed from: d */
    private static abj f123d = abt.m89c();

    /* JADX INFO: renamed from: e */
    private static JSONObject f124e = new JSONObject();

    /* JADX INFO: renamed from: b */
    Integer f125b;

    /* JADX INFO: renamed from: c */
    String f126c;

    public abl(Context context) {
        this.f125b = null;
        this.f126c = null;
        try {
            m65a(context);
            this.f125b = abt.m107l(context.getApplicationContext());
            this.f126c = acf.m234a(context).m240b();
        } catch (Throwable th) {
            f123d.m54b(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private static synchronized abm m65a(Context context) {
        if (f122a == null) {
            f122a = new abm(context.getApplicationContext(), (byte) 0);
        }
        return f122a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public final void m66a(JSONObject jSONObject, Thread thread) {
        String str;
        Object string;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f122a != null) {
                f122a.m67a(jSONObject2, thread);
            }
            abz.m134a(jSONObject2, "cn", this.f126c);
            if (this.f125b != null) {
                jSONObject2.put("tn", this.f125b);
            }
            if (thread == null) {
                str = "ev";
                string = jSONObject2;
            } else {
                str = "errkv";
                string = jSONObject2.toString();
            }
            jSONObject.put(str, string);
            if (f124e == null || f124e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", f124e);
        } catch (Throwable th) {
            f123d.m54b(th);
        }
    }
}
