package p000;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: renamed from: du */
/* JADX INFO: compiled from: DragAndDropPermissionsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1673du {

    /* JADX INFO: renamed from: a */
    private Object f9422a;

    private C1673du(Object obj) {
        this.f9422a = obj;
    }

    /* JADX INFO: renamed from: a */
    public static C1673du m8894a(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsRequestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT < 24 || (dragAndDropPermissionsRequestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent)) == null) {
            return null;
        }
        return new C1673du(dragAndDropPermissionsRequestDragAndDropPermissions);
    }
}
