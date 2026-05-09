package cn.sharesdk.system.email;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface ActionListener {
    void onComplete(HashMap<String, Object> map);

    void onError(Throwable th);

    void onStart(HashMap<String, Object> map);
}
