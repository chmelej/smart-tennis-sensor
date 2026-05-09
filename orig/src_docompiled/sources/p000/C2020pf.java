package p000;

import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: pf */
/* JADX INFO: compiled from: ObjectDescriptorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C2020pf {

    /* JADX INFO: renamed from: a */
    protected static Logger f12181a = Logger.getLogger(C2020pf.class.getName());

    /* JADX INFO: renamed from: b */
    protected static Map<Integer, Map<Integer, Class<? extends AbstractC2009ov>>> f12182b = new HashMap();

    static {
        HashSet<Class<? extends AbstractC2009ov>> hashSet = new HashSet();
        hashSet.add(C2013oz.class);
        hashSet.add(C2022ph.class);
        hashSet.add(AbstractC2009ov.class);
        hashSet.add(C2017pc.class);
        hashSet.add(AbstractC2019pe.class);
        hashSet.add(C2021pg.class);
        hashSet.add(C2008ou.class);
        hashSet.add(C2018pd.class);
        hashSet.add(C2016pb.class);
        hashSet.add(C2012oy.class);
        for (Class<? extends AbstractC2009ov> cls : hashSet) {
            InterfaceC2015pa interfaceC2015pa = (InterfaceC2015pa) cls.getAnnotation(InterfaceC2015pa.class);
            int[] iArrM11080a = interfaceC2015pa.m11080a();
            int iM11081b = interfaceC2015pa.m11081b();
            Map<Integer, Class<? extends AbstractC2009ov>> map = f12182b.get(Integer.valueOf(iM11081b));
            if (map == null) {
                map = new HashMap<>();
            }
            for (int i : iArrM11080a) {
                map.put(Integer.valueOf(i), cls);
            }
            f12182b.put(Integer.valueOf(iM11081b), map);
        }
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC2009ov m11087a(int i, ByteBuffer byteBuffer) {
        AbstractC2009ov c2023pi;
        int iM10737d = C1934nf.m10737d(byteBuffer);
        Map<Integer, Class<? extends AbstractC2009ov>> map = f12182b.get(Integer.valueOf(i));
        if (map == null) {
            map = f12182b.get(-1);
        }
        Class<? extends AbstractC2009ov> cls = map.get(Integer.valueOf(iM10737d));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            f12181a.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(iM10737d) + " found: " + cls);
            c2023pi = new C2023pi();
        } else {
            try {
                c2023pi = cls.newInstance();
            } catch (Exception e) {
                f12181a.log(Level.SEVERE, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + iM10737d, (Throwable) e);
                throw new RuntimeException(e);
            }
        }
        c2023pi.m11064a(iM10737d, byteBuffer);
        return c2023pi;
    }
}
