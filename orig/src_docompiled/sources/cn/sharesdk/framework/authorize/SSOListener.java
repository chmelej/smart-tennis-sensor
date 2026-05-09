package cn.sharesdk.framework.authorize;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface SSOListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onFailed(Throwable th);
}
