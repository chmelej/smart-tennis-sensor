package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class UmengIntentService extends UmengBaseIntentService {

    /* JADX INFO: renamed from: a */
    private static final String f9236a = "com.umeng.message.UmengIntentService";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.umeng.message.UmengBaseIntentService, org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: a */
    public void mo8735a(Context context, Intent intent) {
        super.mo8735a(context, intent);
        try {
            String stringExtra = intent.getStringExtra("body");
            String stringExtra2 = intent.getStringExtra("id");
            String stringExtra3 = intent.getStringExtra("task_id");
            Intent intent2 = new Intent();
            intent2.setPackage(context.getPackageName());
            intent2.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
            intent2.putExtra("body", stringExtra);
            intent2.putExtra("id", stringExtra2);
            intent2.putExtra("task_id", stringExtra3);
            context.startService(intent2);
        } catch (Exception e) {
            Log.e(f9236a, e.getMessage());
        }
    }
}
