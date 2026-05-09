package com.umeng.message;

import android.R;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import p000.ahb;
import p000.ahe;
import p000.ahf;
import p000.ail;
import p000.aim;

/* JADX INFO: loaded from: classes.dex */
public class UmengMessageHandler implements UHandler {

    /* JADX INFO: renamed from: a */
    private static int f9243a = 64;

    /* JADX INFO: renamed from: b */
    private static final String f9244b = "com.umeng.message.UmengMessageHandler";

    /* JADX INFO: renamed from: c */
    private static Date f9245c = null;

    /* JADX INFO: renamed from: d */
    private static String f9246d = "9999999999999";

    /* JADX INFO: renamed from: e */
    private ahf f9247e = null;

    public void dealWithCustomMessage(Context context, ahf ahfVar) {
    }

    public Notification getNotification(Context context, ahf ahfVar) {
        return null;
    }

    public void setPrevMessage(ahf ahfVar) {
        this.f9247e = ahfVar;
    }

    @Override // com.umeng.message.UHandler
    public void handleMessage(Context context, ahf ahfVar) {
        if ("notification".equals(ahfVar.f978d)) {
            dealWithNotificationMessage(context, ahfVar);
        } else if ("custom".equals(ahfVar.f978d)) {
            UTrack.getInstance(context).setClearPrevMessage(false);
            dealWithCustomMessage(context, ahfVar);
        }
    }

    public void dealWithNotificationMessage(Context context, ahf ahfVar) {
        String strSubstring;
        ahb.m1043c(f9244b, "notify: " + ahfVar.m1090a().toString());
        if (ahfVar.m1091b() && !MessageSharedPrefs.getInstance(context).m8692b(ahfVar.f975a) && startDownloadResourceService(context, ahfVar)) {
            return;
        }
        String strM8703j = MessageSharedPrefs.getInstance(context).m8703j();
        String strSubstring2 = "".equals(strM8703j) ? "" : strM8703j.substring(7, 20);
        if (ahfVar.f975a != null && 22 == ahfVar.f975a.length() && ahfVar.f975a.startsWith("u")) {
            MessageSharedPrefs.getInstance(context).m8698e(ahfVar.f975a);
            strSubstring = ahfVar.f975a.substring(7, 20);
        } else {
            strSubstring = f9246d;
        }
        boolean z = "".equals(strSubstring2) || strSubstring.compareToIgnoreCase(strSubstring2) >= 0;
        MessageSharedPrefs.getInstance(context).m8696d(ahfVar.f975a);
        Notification notification = getNotification(context, ahfVar);
        if (notification != null) {
            int i = notification.icon;
        }
        if (notification == null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            if (!m8751a(context, builder, ahfVar)) {
                return;
            }
            builder.setContentTitle(ahfVar.f981g).setContentText(ahfVar.f982h).setTicker(ahfVar.f980f).setAutoCancel(true);
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setBigContentTitle(ahfVar.f981g);
            bigTextStyle.bigText(ahfVar.f982h);
            builder.setStyle(bigTextStyle);
            notification = builder.build();
        }
        PendingIntent clickPendingIntent = getClickPendingIntent(context, ahfVar);
        notification.deleteIntent = getDismissPendingIntent(context, ahfVar);
        notification.contentIntent = clickPendingIntent;
        int notificationDefaults = getNotificationDefaults(context, ahfVar);
        if ((notificationDefaults & 1) != 0) {
            Uri sound = getSound(context, ahfVar);
            if (sound != null) {
                notification.sound = getSound(context, ahfVar);
            }
            if (sound != null) {
                notificationDefaults ^= 1;
            }
        }
        notification.defaults = notificationDefaults;
        m8750a(context, notification, z, ahfVar);
    }

    /* JADX INFO: renamed from: a */
    private void m8750a(Context context, Notification notification, boolean z, ahf ahfVar) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int iNextInt = MsgConstant.NOTIFICATION_MERGE_ID;
            try {
                if (!PushAgent.getInstance(context).getMergeNotificaiton()) {
                    iNextInt = new Random().nextInt();
                } else if (true == z) {
                    if (!ail.m1348b(context) || !ail.m1342a(context) || PushAgent.getInstance(context).getNotificationOnForeground()) {
                        notificationManager.cancel(MsgConstant.NOTIFICATION_MERGE_ID);
                        ahb.m1043c(f9244b, "prevMessage=" + this.f9247e);
                        UTrack.getInstance(context).setClearPrevMessage(false);
                        UTrack.getInstance(context).trackMsgDismissed(this.f9247e);
                        this.f9247e = ahfVar;
                    }
                } else {
                    UTrack.getInstance(context).setClearPrevMessage(false);
                    UTrack.getInstance(context).trackMsgDismissed(ahfVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((true == z || !PushAgent.getInstance(context).getMergeNotificaiton()) && (!ail.m1348b(context) || !ail.m1342a(context) || PushAgent.getInstance(context).getNotificationOnForeground())) {
                notificationManager.notify(iNextInt, notification);
            }
            if ((true == z || !PushAgent.getInstance(context).getMergeNotificaiton()) && ail.m1348b(context) && ail.m1342a(context) && !PushAgent.getInstance(context).getNotificationOnForeground()) {
                UTrack.getInstance(context).setClearPrevMessage(false);
                UTrack.getInstance(context).trackMsgDismissed(ahfVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.umeng.message.UmengMessageHandler$1] */
    @SuppressLint({"NewApi", "Wakelock"})
    /* JADX INFO: renamed from: a */
    private void m8749a(Context context) {
        try {
            final PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean zM8752a = false;
            if (Build.VERSION.SDK_INT >= 7) {
                zM8752a = new Object() { // from class: com.umeng.message.UmengMessageHandler.1
                    /* JADX INFO: renamed from: a */
                    boolean m8752a() {
                        return powerManager.isScreenOn();
                    }
                }.m8752a();
            } else {
                ahb.m1043c(f9244b, "android os version < 7, skip checking screen on status");
            }
            ahb.m1043c(f9244b, "screen on................................." + zM8752a);
            if (zM8752a) {
                return;
            }
            powerManager.newWakeLock(805306374, "MyLock").acquire(10000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PendingIntent getClickPendingIntent(Context context, ahf ahfVar) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, ahfVar.m1090a().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 10);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, ahfVar.f976b);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, ahfVar.f977c);
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 268435456);
    }

    public PendingIntent getDismissPendingIntent(Context context, ahf ahfVar) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, ahfVar.m1090a().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 11);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, ahfVar.f976b);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, ahfVar.f977c);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, 268435456);
    }

    public boolean isInNoDisturbTime(Context context) {
        int i = (Calendar.getInstance().get(11) * 60) + Calendar.getInstance().get(12);
        boolean z = i >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = i <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        if ((PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute()) {
            if (!z || !z2) {
                return false;
            }
        } else if (!z && !z2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getNotificationDefaults(android.content.Context r11, p000.ahf r12) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getNotificationDefaults(android.content.Context, ahf):int");
    }

    public boolean startDownloadResourceService(Context context, ahf ahfVar) {
        try {
            Intent intent = new Intent(context, (Class<?>) UmengDownloadResourceService.class);
            intent.putExtra("body", ahfVar.m1090a().toString());
            intent.putExtra("id", ahfVar.f976b);
            intent.putExtra("task_id", ahfVar.f977c);
            context.startService(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m8751a(Context context, NotificationCompat.Builder builder, ahf ahfVar) {
        int smallIconId = getSmallIconId(context, ahfVar);
        Bitmap largeIcon = getLargeIcon(context, ahfVar);
        if (smallIconId < 0) {
            return false;
        }
        builder.setSmallIcon(smallIconId);
        builder.setLargeIcon(largeIcon);
        return true;
    }

    public int getSmallIconId(Context context, ahf ahfVar) {
        int iM1088a;
        try {
            iM1088a = TextUtils.isEmpty(ahfVar.f992r) ? -1 : ahe.m1087a(context).m1088a(ahfVar.f992r);
            if (iM1088a < 0) {
                if (Build.VERSION.SDK_INT < 20) {
                    iM1088a = ahe.m1087a(context).m1088a("umeng_push_notification_default_small_below5");
                } else {
                    iM1088a = ahe.m1087a(context).m1088a("umeng_push_notification_default_small_icon");
                }
                iM1088a = iM1088a;
            }
            if (iM1088a < 0) {
                ahb.m1043c(f9244b, "no custom notificaiton icon, fail back to app icon.");
                iM1088a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
            }
            if (iM1088a < 0) {
                ahb.m1041b(f9244b, "Cann't find appropriate icon for notification, please make sure you have specified an icon for this notification or the app has defined an icon.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iM1088a;
    }

    public Bitmap getLargeIcon(Context context, ahf ahfVar) {
        Bitmap bitmapDecodeResource;
        int iM1351a;
        try {
            if (ahfVar.m1092c()) {
                bitmapDecodeResource = BitmapFactory.decodeFile(UmengDownloadResourceService.getMessageResourceFolder(context, ahfVar) + ahfVar.f991q.hashCode());
            } else {
                bitmapDecodeResource = null;
            }
            if (bitmapDecodeResource == null) {
                int iM1088a = TextUtils.isEmpty(ahfVar.f996v) ? -1 : ahe.m1087a(context).m1088a(ahfVar.f996v);
                if (iM1088a < 0) {
                    iM1088a = ahe.m1087a(context).m1088a("umeng_push_notification_default_large_icon");
                }
                if (iM1088a > 0) {
                    bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), iM1088a);
                }
            }
            if (bitmapDecodeResource != null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    iM1351a = (int) context.getResources().getDimension(R.dimen.notification_large_icon_height);
                } else {
                    iM1351a = aim.m1351a(f9243a);
                }
                return Bitmap.createScaledBitmap(bitmapDecodeResource, iM1351a, iM1351a, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri getSound(android.content.Context r5, p000.ahf r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.m1093d()     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = com.umeng.message.UmengDownloadResourceService.getMessageResourceFolder(r5, r6)     // Catch: java.lang.Throwable -> L73
            r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = r6.f990p     // Catch: java.lang.Throwable -> L73
            int r2 = r2.hashCode()     // Catch: java.lang.Throwable -> L73
            r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L73
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L73
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L73
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L73
            if (r2 != 0) goto L2c
        L2b:
            r1 = r0
        L2c:
            if (r1 != 0) goto L6c
            r2 = -1
            java.lang.String r3 = r6.f990p     // Catch: java.lang.Throwable -> L73
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto L41
            ahe r2 = p000.ahe.m1087a(r5)     // Catch: java.lang.Throwable -> L73
            java.lang.String r6 = r6.f990p     // Catch: java.lang.Throwable -> L73
            int r2 = r2.m1089b(r6)     // Catch: java.lang.Throwable -> L73
        L41:
            if (r2 >= 0) goto L4d
            ahe r6 = p000.ahe.m1087a(r5)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = "umeng_push_notification_default_sound"
            int r2 = r6.m1089b(r2)     // Catch: java.lang.Throwable -> L73
        L4d:
            if (r2 <= 0) goto L6c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r6.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = "android.resource://"
            r6.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L73
            r6.append(r5)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = "/"
            r6.append(r5)     // Catch: java.lang.Throwable -> L73
            r6.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L73
        L6c:
            if (r1 == 0) goto L73
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L73
            return r5
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, ahf):android.net.Uri");
    }
}
