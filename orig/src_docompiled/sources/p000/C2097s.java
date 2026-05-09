package p000;

/* JADX INFO: renamed from: s */
/* JADX INFO: compiled from: ViewModelProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class C2097s {

    /* JADX INFO: renamed from: a */
    private final a f12633a;

    /* JADX INFO: renamed from: b */
    private final C2124t f12634b;

    /* JADX INFO: renamed from: s$a */
    /* JADX INFO: compiled from: ViewModelProvider.java */
    public interface a {
        <T extends AbstractC2070r> T create(Class<T> cls);
    }

    public C2097s(C2124t c2124t, a aVar) {
        this.f12633a = aVar;
        this.f12634b = c2124t;
    }

    /* JADX INFO: renamed from: a */
    public <T extends AbstractC2070r> T m11505a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) m11506a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
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
    public <T extends AbstractC2070r> T m11506a(String str, Class<T> cls) {
        T t = (T) this.f12634b.m11606a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f12633a.create(cls);
        this.f12634b.m11608a(str, t2);
        return t2;
    }
}
