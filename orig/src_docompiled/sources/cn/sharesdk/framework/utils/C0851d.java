package cn.sharesdk.framework.utils;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

/* JADX INFO: renamed from: cn.sharesdk.framework.utils.d */
/* JADX INFO: compiled from: SSDKLog.java */
/* JADX INFO: loaded from: classes.dex */
public class C0851d extends NLog {
    @Override // com.mob.tools.log.NLog
    protected String getSDKTag() {
        return ShareSDK.SDK_TAG;
    }

    private C0851d(Context context, final int i, final String str) {
        setCollector(ShareSDK.SDK_TAG, new LogsCollector(context) { // from class: cn.sharesdk.framework.utils.d.1
            @Override // com.mob.commons.logcollector.LogsCollector
            protected String getSDKTag() {
                return ShareSDK.SDK_TAG;
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            protected int getSDKVersion() {
                return i;
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            protected String getAppkey() {
                return str;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static NLog m6196a(Context context, int i, String str) {
        return new C0851d(context, i, str);
    }

    /* JADX INFO: renamed from: a */
    public static NLog m6195a() {
        return getInstanceForSDK(ShareSDK.SDK_TAG, true);
    }
}
