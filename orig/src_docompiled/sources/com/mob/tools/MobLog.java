package com.mob.tools;

import com.mob.tools.log.NLog;

/* JADX INFO: loaded from: classes.dex */
public class MobLog extends NLog {
    @Override // com.mob.tools.log.NLog
    protected String getSDKTag() {
        return "MOBTOOLS";
    }

    private MobLog() {
    }

    public static NLog getInstance() {
        return getInstanceForSDK("MOBTOOLS", true);
    }
}
