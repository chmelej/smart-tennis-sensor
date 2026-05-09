package p000;

import android.support.transition.Transition;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: cz */
/* JADX INFO: compiled from: TransitionValues.java */
/* JADX INFO: loaded from: classes.dex */
public class C1651cz {

    /* JADX INFO: renamed from: b */
    public View f9357b;

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> f9356a = new HashMap();

    /* JADX INFO: renamed from: c */
    public final ArrayList<Transition> f9358c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof C1651cz)) {
            return false;
        }
        C1651cz c1651cz = (C1651cz) obj;
        return this.f9357b == c1651cz.f9357b && this.f9356a.equals(c1651cz.f9356a);
    }

    public int hashCode() {
        return (this.f9357b.hashCode() * 31) + this.f9356a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f9357b + "\n") + "    values:";
        for (String str2 : this.f9356a.keySet()) {
            str = str + "    " + str2 + ": " + this.f9356a.get(str2) + "\n";
        }
        return str;
    }
}
