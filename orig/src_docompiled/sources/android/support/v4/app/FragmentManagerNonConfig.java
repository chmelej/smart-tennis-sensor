package android.support.v4.app;

import java.util.List;
import p000.C2124t;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManagerNonConfig {
    private final List<FragmentManagerNonConfig> mChildNonConfigs;
    private final List<Fragment> mFragments;
    private final List<C2124t> mViewModelStores;

    FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2, List<C2124t> list3) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
        this.mViewModelStores = list3;
    }

    List<Fragment> getFragments() {
        return this.mFragments;
    }

    List<FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    List<C2124t> getViewModelStores() {
        return this.mViewModelStores;
    }
}
