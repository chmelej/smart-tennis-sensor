package p000;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: renamed from: fs */
/* JADX INFO: compiled from: AppCompatHintHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1727fs {
    /* JADX INFO: renamed from: a */
    public static InputConnection m9265a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof InterfaceC1775hm) {
                    editorInfo.hintText = ((InterfaceC1775hm) parent).m9681a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
