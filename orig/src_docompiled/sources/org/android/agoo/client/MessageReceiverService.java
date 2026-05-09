package org.android.agoo.client;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.android.agoo.service.ElectionReceiverService;
import org.android.agoo.service.SendMessage;
import p000.aiv;

/* JADX INFO: loaded from: classes.dex */
public abstract class MessageReceiverService extends Service {

    /* JADX INFO: renamed from: a */
    SendMessage.Stub f11973a = new SendMessage.Stub() { // from class: org.android.agoo.client.MessageReceiverService.1
        @Override // org.android.agoo.service.SendMessage
        public int doSend(Intent intent) {
            BaseIntentService.m10924a(MessageReceiverService.this.getApplicationContext(), intent, MessageReceiverService.this.getIntentServiceClassName(MessageReceiverService.this.getApplicationContext()));
            return 0;
        }
    };

    /* JADX INFO: renamed from: b */
    ElectionReceiverService.Stub f11974b = new ElectionReceiverService.Stub() { // from class: org.android.agoo.client.MessageReceiverService.2
        @Override // org.android.agoo.service.ElectionReceiverService
        public boolean sendElectionResult(Intent intent) {
            try {
                BaseIntentService.m10924a(MessageReceiverService.this.getApplicationContext(), intent, MessageReceiverService.this.getIntentServiceClassName(MessageReceiverService.this.getApplicationContext()));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    };

    public abstract String getIntentServiceClassName(Context context);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        aiv.m1414a("MessageReceiverService", "Message receiver aidl was binded {}", intent.getAction());
        if ("org.android.agoo.client.ElectionReceiverService".equals(intent.getAction())) {
            return this.f11974b;
        }
        if ("org.android.agoo.client.MessageReceiverService".equals(intent.getAction())) {
            return this.f11973a;
        }
        return this.f11973a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
