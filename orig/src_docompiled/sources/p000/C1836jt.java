package p000;

import android.annotation.SuppressLint;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.fragment.PersonalMainFramgent;
import com.coollang.tennis.fragment.RankListFragment;
import com.coollang.tennis.fragment.SportMainFragment;
import com.coollang.tennis.fragment.TrainFragment;
import java.util.HashMap;

/* JADX INFO: renamed from: jt */
/* JADX INFO: compiled from: FragmentFactory.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UseSparseArrays"})
public class C1836jt {

    /* JADX INFO: renamed from: a */
    public static HashMap<Integer, BaseFragment> f10804a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private static BaseFragment f10805b;

    /* JADX INFO: renamed from: a */
    public static BaseFragment m10014a(int i) {
        f10805b = f10804a.get(Integer.valueOf(i));
        if (f10805b == null) {
            switch (i) {
                case 0:
                    C1900mc.m10474b("mainActivity", "create  === " + f10804a.size());
                    f10805b = new SportMainFragment();
                    break;
                case 1:
                    f10805b = new TrainFragment();
                    break;
                case 2:
                    f10805b = new RankListFragment();
                    break;
                case 3:
                    f10805b = new PersonalMainFramgent();
                    break;
            }
            f10804a.put(Integer.valueOf(i), f10805b);
        }
        return f10805b;
    }
}
