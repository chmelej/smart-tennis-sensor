package cn.sharesdk.framework.authorize;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface AuthorizeListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onError(Throwable th);
}
