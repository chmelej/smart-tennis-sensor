package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a */
    final RecyclerView f3841a;

    /* JADX INFO: renamed from: b */
    final AccessibilityDelegateCompat f3842b = new ItemDelegate(this);

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f3841a = recyclerView;
    }

    /* JADX INFO: renamed from: a */
    boolean m4156a() {
        return this.f3841a.m3828v();
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (m4156a() || this.f3841a.getLayoutManager() == null) {
            return false;
        }
        return this.f3841a.getLayoutManager().m3953a(i, bundle);
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (m4156a() || this.f3841a.getLayoutManager() == null) {
            return;
        }
        this.f3841a.getLayoutManager().m3937a(accessibilityNodeInfoCompat);
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || m4156a()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().mo3628a(accessibilityEvent);
        }
    }

    /* JADX INFO: renamed from: b */
    public AccessibilityDelegateCompat m4157b() {
        return this.f3842b;
    }

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a */
        final RecyclerViewAccessibilityDelegate f3843a;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f3843a = recyclerViewAccessibilityDelegate;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (this.f3843a.m4156a() || this.f3843a.f3841a.getLayoutManager() == null) {
                return;
            }
            this.f3843a.f3841a.getLayoutManager().m3950a(view, accessibilityNodeInfoCompat);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.f3843a.m4156a() || this.f3843a.f3841a.getLayoutManager() == null) {
                return false;
            }
            return this.f3843a.f3841a.getLayoutManager().m3962a(view, i, bundle);
        }
    }
}
