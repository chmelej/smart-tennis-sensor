package p000;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: hz */
/* JADX INFO: compiled from: VersionedParcel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1788hz {
    /* JADX INFO: renamed from: a */
    protected abstract void mo9741a(int i);

    /* JADX INFO: renamed from: a */
    protected abstract void mo9743a(Parcelable parcelable);

    /* JADX INFO: renamed from: a */
    protected abstract void mo9747a(String str);

    /* JADX INFO: renamed from: a */
    public void m9749a(boolean z, boolean z2) {
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo9750a(byte[] bArr);

    /* JADX INFO: renamed from: a */
    public boolean m9752a() {
        return false;
    }

    /* JADX INFO: renamed from: b */
    protected abstract void mo9757b();

    /* JADX INFO: renamed from: b */
    protected abstract boolean mo9758b(int i);

    /* JADX INFO: renamed from: c */
    protected abstract AbstractC1788hz mo9760c();

    /* JADX INFO: renamed from: c */
    protected abstract void mo9761c(int i);

    /* JADX INFO: renamed from: d */
    protected abstract int mo9762d();

    /* JADX INFO: renamed from: e */
    protected abstract String mo9763e();

    /* JADX INFO: renamed from: f */
    protected abstract byte[] mo9764f();

    /* JADX INFO: renamed from: g */
    protected abstract <T extends Parcelable> T mo9765g();

    /* JADX INFO: renamed from: a */
    public void m9751a(byte[] bArr, int i) {
        mo9761c(i);
        mo9750a(bArr);
    }

    /* JADX INFO: renamed from: a */
    public void m9742a(int i, int i2) {
        mo9761c(i2);
        mo9741a(i);
    }

    /* JADX INFO: renamed from: a */
    public void m9748a(String str, int i) {
        mo9761c(i);
        mo9747a(str);
    }

    /* JADX INFO: renamed from: a */
    public void m9744a(Parcelable parcelable, int i) {
        mo9761c(i);
        mo9743a(parcelable);
    }

    /* JADX INFO: renamed from: b */
    public int m9753b(int i, int i2) {
        return !mo9758b(i2) ? i : mo9762d();
    }

    /* JADX INFO: renamed from: b */
    public String m9756b(String str, int i) {
        return !mo9758b(i) ? str : mo9763e();
    }

    /* JADX INFO: renamed from: b */
    public byte[] m9759b(byte[] bArr, int i) {
        return !mo9758b(i) ? bArr : mo9764f();
    }

    /* JADX INFO: renamed from: b */
    public <T extends Parcelable> T m9754b(T t, int i) {
        return !mo9758b(i) ? t : (T) mo9765g();
    }

    /* JADX INFO: renamed from: a */
    public void m9746a(InterfaceC1791ib interfaceC1791ib, int i) {
        mo9761c(i);
        m9745a(interfaceC1791ib);
    }

    /* JADX INFO: renamed from: a */
    public void m9745a(InterfaceC1791ib interfaceC1791ib) {
        if (interfaceC1791ib == null) {
            mo9747a((String) null);
            return;
        }
        m9739b(interfaceC1791ib);
        AbstractC1788hz abstractC1788hzMo9760c = mo9760c();
        m9738a(interfaceC1791ib, abstractC1788hzMo9760c);
        abstractC1788hzMo9760c.mo9757b();
    }

    /* JADX INFO: renamed from: b */
    private void m9739b(InterfaceC1791ib interfaceC1791ib) {
        try {
            mo9747a(m9737a((Class<? extends InterfaceC1791ib>) interfaceC1791ib.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(interfaceC1791ib.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public <T extends InterfaceC1791ib> T m9755b(T t, int i) {
        return !mo9758b(i) ? t : (T) m9766h();
    }

    /* JADX INFO: renamed from: h */
    public <T extends InterfaceC1791ib> T m9766h() {
        String strMo9763e = mo9763e();
        if (strMo9763e == null) {
            return null;
        }
        return (T) m9736a(strMo9763e, mo9760c());
    }

    /* JADX INFO: renamed from: a */
    protected static <T extends InterfaceC1791ib> T m9736a(String str, AbstractC1788hz abstractC1788hz) {
        try {
            return (T) Class.forName(str, true, AbstractC1788hz.class.getClassLoader()).getDeclaredMethod("read", AbstractC1788hz.class).invoke(null, abstractC1788hz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* JADX INFO: renamed from: a */
    protected static <T extends InterfaceC1791ib> void m9738a(T t, AbstractC1788hz abstractC1788hz) {
        try {
            m9740c(t).getDeclaredMethod("write", t.getClass(), AbstractC1788hz.class).invoke(null, t, abstractC1788hz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* JADX INFO: renamed from: c */
    private static <T extends InterfaceC1791ib> Class m9740c(T t) {
        return m9737a((Class<? extends InterfaceC1791ib>) t.getClass());
    }

    /* JADX INFO: renamed from: a */
    private static Class m9737a(Class<? extends InterfaceC1791ib> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
