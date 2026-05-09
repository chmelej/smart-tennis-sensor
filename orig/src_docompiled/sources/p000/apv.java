package p000;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: IControlCallBack.java */
/* JADX INFO: loaded from: classes.dex */
public interface apv {
    Class<?> callAgooElectionReceiver();

    Class<?> callAgooMessageReceiver();

    Class<?> callAgooRegistrationReceiver();

    Class<?> callAgooService();

    Class<?> callAgooSystemReceiver();

    void callError(Context context, String str);

    void callMessage(Context context, Intent intent);

    boolean callRecoverableError(Context context, String str);

    void callRegistered(Context context, String str);

    boolean callShouldProcessMessage(Context context, Intent intent);

    void callUnregistered(Context context, String str);

    void callUserCommand(Context context, Intent intent);
}
