package p000;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import p000.DialogInterfaceC1674dv;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: fa */
/* JADX INFO: compiled from: MenuDialogHelper.java */
/* JADX INFO: loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1709fa implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, InterfaceC1714ff.a {

    /* JADX INFO: renamed from: a */
    C1706ey f9757a;

    /* JADX INFO: renamed from: b */
    private MenuBuilder f9758b;

    /* JADX INFO: renamed from: c */
    private DialogInterfaceC1674dv f9759c;

    /* JADX INFO: renamed from: d */
    private InterfaceC1714ff.a f9760d;

    public DialogInterfaceOnClickListenerC1709fa(MenuBuilder menuBuilder) {
        this.f9758b = menuBuilder;
    }

    /* JADX INFO: renamed from: a */
    public void m9142a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f9758b;
        DialogInterfaceC1674dv.a aVar = new DialogInterfaceC1674dv.a(menuBuilder.m3353f());
        this.f9757a = new C1706ey(aVar.m8896a(), R.layout.abc_list_menu_item_layout);
        this.f9757a.mo2440a(this);
        this.f9758b.m3330a(this.f9757a);
        aVar.m8900a(this.f9757a.m9126d(), this);
        View viewM3363p = menuBuilder.m3363p();
        if (viewM3363p != null) {
            aVar.m8899a(viewM3363p);
        } else {
            aVar.m8898a(menuBuilder.m3362o()).m8901a(menuBuilder.m3361n());
        }
        aVar.m8897a(this);
        this.f9759c = aVar.m8906b();
        this.f9759c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f9759c.getWindow().getAttributes();
        attributes.type = PointerIconCompat.TYPE_HELP;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f9759c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f9759c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f9759c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f9758b.m3340b(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f9758b.performShortcut(i, keyEvent, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m9141a() {
        if (this.f9759c != null) {
            this.f9759c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f9757a.mo2439a(this.f9758b, true);
    }

    @Override // p000.InterfaceC1714ff.a
    /* JADX INFO: renamed from: a */
    public void mo3278a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f9758b) {
            m9141a();
        }
        if (this.f9760d != null) {
            this.f9760d.mo3278a(menuBuilder, z);
        }
    }

    @Override // p000.InterfaceC1714ff.a
    /* JADX INFO: renamed from: a */
    public boolean mo3279a(MenuBuilder menuBuilder) {
        if (this.f9760d != null) {
            return this.f9760d.mo3279a(menuBuilder);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9758b.m3334a((MenuItemImpl) this.f9757a.m9126d().getItem(i), 0);
    }
}
