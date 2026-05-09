package p000;

import android.support.design.R;
import android.util.Property;
import android.view.ViewGroup;

/* JADX INFO: renamed from: y */
/* JADX INFO: compiled from: ChildrenAlphaProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class C2259y extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a */
    public static final Property<ViewGroup, Float> f13656a = new C2259y("childrenAlpha");

    private C2259y(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ViewGroup viewGroup, Float f) {
        float fFloatValue = f.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(fFloatValue);
        }
    }
}
