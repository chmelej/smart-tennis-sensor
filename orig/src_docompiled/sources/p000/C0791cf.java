package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: renamed from: cf */
/* JADX INFO: compiled from: AnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0791cf {

    /* JADX INFO: renamed from: cf$a */
    /* JADX INFO: compiled from: AnimatorUtils.java */
    public interface a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* JADX INFO: renamed from: a */
    public static void m5780a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5779a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m5781b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
