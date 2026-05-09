package cn.smssdk.utils;

import android.content.Context;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

/* JADX INFO: loaded from: classes.dex */
public class SMSLog extends NLog {
    @Override // com.mob.tools.log.NLog
    protected String getSDKTag() {
        return "SMSSDK";
    }

    private SMSLog(Context context, final int i, final String str) {
        setCollector("SMSSDK", new LogsCollector(context) { // from class: cn.smssdk.utils.SMSLog.1
            @Override // com.mob.commons.logcollector.LogsCollector
            protected String getSDKTag() {
                return "SMSSDK";
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

    public static NLog prepare(Context context, int i, String str) {
        return new SMSLog(context, i, str);
    }

    public static NLog getInstance() {
        return getInstanceForSDK("SMSSDK", true);
    }
}
