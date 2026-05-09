package p000;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: pa */
/* JADX INFO: compiled from: Descriptor.java */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2015pa {
    /* JADX INFO: renamed from: a */
    int[] m11080a();

    /* JADX INFO: renamed from: b */
    int m11081b() default -1;
}
