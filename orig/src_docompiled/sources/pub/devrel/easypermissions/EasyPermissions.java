package pub.devrel.easypermissions;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import p000.asw;
import p000.asx;

/* JADX INFO: loaded from: classes.dex */
public class EasyPermissions {

    public interface PermissionCallbacks extends ActivityCompat.OnRequestPermissionsResultCallback {
        /* JADX INFO: renamed from: a */
        void mo7922a(int i, List<String> list);

        /* JADX INFO: renamed from: b */
        void mo7924b(int i, List<String> list);
    }

    /* JADX INFO: renamed from: pub.devrel.easypermissions.EasyPermissions$a */
    public interface InterfaceC2037a {
        /* JADX INFO: renamed from: a */
        void m11140a(int i);

        /* JADX INFO: renamed from: b */
        void m11141b(int i);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11138a(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
            return true;
        }
        if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m11134a(Fragment fragment, String str, int i, String... strArr) {
        m11135a(new asx.C0750a(fragment, i, strArr).m5384a(str).m5385a());
    }

    /* JADX INFO: renamed from: a */
    public static void m11135a(asx asxVar) {
        if (m11138a(asxVar.m5377a().mo5402b(), asxVar.m5378b())) {
            m11137a(asxVar.m5377a().m5410c(), asxVar.m5379c(), asxVar.m5378b());
        } else {
            asxVar.m5377a().m5409b(asxVar.m5380d(), asxVar.m5381e(), asxVar.m5382f(), asxVar.m5383g(), asxVar.m5379c(), asxVar.m5378b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11133a(int i, String[] strArr, int[] iArr, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        for (Object obj : objArr) {
            if (!arrayList.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).mo7922a(i, arrayList);
            }
            if (!arrayList2.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).mo7924b(i, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                m11136a(obj, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11137a(Object obj, int i, String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = 0;
        }
        m11133a(i, strArr, iArr, obj);
    }

    /* JADX INFO: renamed from: a */
    private static void m11136a(Object obj, int i) {
        Class<?> superclass = obj.getClass();
        if (m11139a(obj)) {
            superclass = superclass.getSuperclass();
        }
        while (superclass != null) {
            for (Method method : superclass.getDeclaredMethods()) {
                asw aswVar = (asw) method.getAnnotation(asw.class);
                if (aswVar != null && aswVar.m5376a() == i) {
                    if (method.getParameterTypes().length > 0) {
                        throw new RuntimeException("Cannot execute method " + method.getName() + " because it is non-void method and/or has input parameters.");
                    }
                    try {
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(obj, new Object[0]);
                    } catch (IllegalAccessException e) {
                        Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", e2);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m11139a(Object obj) {
        if (!obj.getClass().getSimpleName().endsWith("_")) {
            return false;
        }
        try {
            return Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
