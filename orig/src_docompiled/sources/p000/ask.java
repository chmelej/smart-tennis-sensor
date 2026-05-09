package p000;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Subscribe.java */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ask {
    /* JADX INFO: renamed from: a */
    asp m5346a() default asp.POSTING;

    /* JADX INFO: renamed from: b */
    boolean m5347b() default false;

    /* JADX INFO: renamed from: c */
    int m5348c() default 0;
}
