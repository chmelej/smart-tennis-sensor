package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.design.R;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: be */
/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC0763be extends DialogC1677dy {

    /* JADX INFO: renamed from: a */
    boolean f5113a;

    /* JADX INFO: renamed from: b */
    private BottomSheetBehavior<FrameLayout> f5114b;

    /* JADX INFO: renamed from: c */
    private boolean f5115c;

    /* JADX INFO: renamed from: d */
    private boolean f5116d;

    /* JADX INFO: renamed from: e */
    private BottomSheetBehavior.AbstractC0279a f5117e;

    public DialogC0763be(Context context, int i) {
        super(context, m5511a(context, i));
        this.f5113a = true;
        this.f5115c = true;
        this.f5117e = new BottomSheetBehavior.AbstractC0279a() { // from class: be.4
            @Override // android.support.design.widget.BottomSheetBehavior.AbstractC0279a
            /* JADX INFO: renamed from: a */
            public void mo2653a(View view, float f) {
            }

            @Override // android.support.design.widget.BottomSheetBehavior.AbstractC0279a
            /* JADX INFO: renamed from: a */
            public void mo2654a(View view, int i2) {
                if (i2 == 5) {
                    DialogC0763be.this.cancel();
                }
            }
        };
        m8912a(1);
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(m5512a(i, null, null));
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(ExploreByTouchHelper.INVALID_ID);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(m5512a(0, view, null));
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m5512a(0, view, layoutParams));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f5113a != z) {
            this.f5113a = z;
            if (this.f5114b != null) {
                this.f5114b.m2646b(z);
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.f5114b == null || this.f5114b.m2637a() != 5) {
            return;
        }
        this.f5114b.m2645b(4);
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f5113a) {
            this.f5113a = true;
        }
        this.f5115c = z;
        this.f5116d = true;
    }

    /* JADX INFO: renamed from: a */
    private View m5512a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.f5114b = BottomSheetBehavior.m2631b(frameLayout2);
        this.f5114b.m2640a(this.f5117e);
        this.f5114b.m2646b(this.f5113a);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: be.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (DialogC0763be.this.f5113a && DialogC0763be.this.isShowing() && DialogC0763be.this.m5513a()) {
                    DialogC0763be.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(frameLayout2, new AccessibilityDelegateCompat() { // from class: be.2
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                if (DialogC0763be.this.f5113a) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                } else {
                    accessibilityNodeInfoCompat.setDismissable(false);
                }
            }

            @Override // android.support.v4.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view2, int i2, Bundle bundle) {
                if (i2 == 1048576 && DialogC0763be.this.f5113a) {
                    DialogC0763be.this.cancel();
                    return true;
                }
                return super.performAccessibilityAction(view2, i2, bundle);
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: be.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    /* JADX INFO: renamed from: a */
    boolean m5513a() {
        if (!this.f5116d) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f5115c = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f5116d = true;
        }
        return this.f5115c;
    }

    /* JADX INFO: renamed from: a */
    private static int m5511a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }
}
