package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;
import p000.ahb;
import p000.ahf;

/* JADX INFO: loaded from: classes.dex */
public class UmengDownloadResourceService extends Service {
    public static final String TAG = "UmengDownloadResourceService";

    /* JADX INFO: renamed from: d */
    private static Thread f9226d;

    /* JADX INFO: renamed from: a */
    ScheduledThreadPoolExecutor f9227a;

    /* JADX INFO: renamed from: b */
    Context f9228b;

    /* JADX INFO: renamed from: c */
    ArrayList<String> f9229c;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f9227a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
        this.f9228b = this;
        this.f9229c = new ArrayList<>();
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int i, int i2) {
        ahf ahfVar;
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        int intExtra = intent.getIntExtra("OPERATIOIN", 2);
        int intExtra2 = intent.getIntExtra("RETRY_TIME", 3);
        try {
            ahfVar = new ahf(new JSONObject(intent.getStringExtra("body")));
            ahfVar.f976b = intent.getStringExtra("id");
            ahfVar.f977c = intent.getStringExtra("task_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f9229c.contains(ahfVar.f975a)) {
            return super.onStartCommand(intent, i, i2);
        }
        this.f9229c.add(ahfVar.f975a);
        switch (intExtra) {
            case 1:
                deleteAlarm(ahfVar, intExtra2);
                ahb.m1039a(TAG, "Show Notification After Downloaded Resource");
                notification(ahfVar);
                this.f9229c.remove(ahfVar.f975a);
                if (this.f9229c.size() == 0) {
                    stopSelf();
                }
                break;
            case 2:
                ahb.m1039a(TAG, "Start Download Resource");
                int i3 = intExtra2 - 1;
                setAlarm(ahfVar, i3);
                checkCache();
                downloadResource(ahfVar, i3);
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void notification(ahf ahfVar) {
        UHandler messageHandler = PushAgent.getInstance(this).getMessageHandler();
        if (messageHandler != null) {
            if (TextUtils.equals("autoupdate", ahfVar.f978d)) {
                UmengMessageHandler umengMessageHandler = (UmengMessageHandler) PushAgent.getInstance(this.f9228b).getMessageHandler();
                if (umengMessageHandler != null) {
                    umengMessageHandler.dealWithNotificationMessage(this.f9228b, ahfVar);
                    return;
                }
                return;
            }
            messageHandler.handleMessage(this, ahfVar);
        }
    }

    @SuppressLint({"NewApi"})
    public void downloadResource(ahf ahfVar, int i) {
        DownloadResourceTask downloadResourceTask = new DownloadResourceTask(ahfVar, i);
        if (Build.VERSION.SDK_INT >= 11) {
            downloadResourceTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            downloadResourceTask.execute(new Void[0]);
        }
    }

    public void setAlarm(ahf ahfVar, int i) {
        ahb.m1039a(TAG, "setAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 300000, m8740a(ahfVar, i));
    }

    public void deleteAlarm(ahf ahfVar, int i) {
        ahb.m1039a(TAG, "deleteAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(m8740a(ahfVar, i));
    }

    /* JADX INFO: renamed from: a */
    private PendingIntent m8740a(ahf ahfVar, int i) {
        String string = ahfVar.m1090a().toString();
        int iHashCode = ahfVar.f975a.hashCode();
        Intent intent = new Intent(this.f9228b, (Class<?>) UmengDownloadResourceService.class);
        intent.putExtra("body", string);
        intent.putExtra("id", ahfVar.f976b);
        intent.putExtra("task_id", ahfVar.f977c);
        intent.putExtra("OPERATIOIN", 2);
        intent.putExtra("RETRY_TIME", i);
        PendingIntent service = PendingIntent.getService(this.f9228b, iHashCode, intent, 134217728);
        ahb.m1039a(TAG, "PendingIntent: msgId:" + ahfVar.f975a + ",requestCode:" + iHashCode + ",retryTime:" + i);
        return service;
    }

    public class DownloadResourceTask extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a */
        ahf f9232a;

        /* JADX INFO: renamed from: b */
        ArrayList<String> f9233b = new ArrayList<>();

        /* JADX INFO: renamed from: c */
        int f9234c;

        public DownloadResourceTask(ahf ahfVar, int i) {
            this.f9232a = ahfVar;
            if (ahfVar.m1092c()) {
                this.f9233b.add(ahfVar.f991q);
            }
            if (ahfVar.m1093d()) {
                this.f9233b.add(ahfVar.f990p);
            }
            this.f9234c = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            Iterator<String> it = this.f9233b.iterator();
            boolean zDownload = true;
            while (it.hasNext()) {
                zDownload &= download(it.next());
            }
            return Boolean.valueOf(zDownload);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            UmengDownloadResourceService.this.f9229c.remove(this.f9232a.f975a);
            if (bool.booleanValue() || this.f9234c <= 0) {
                MessageSharedPrefs.getInstance(UmengDownloadResourceService.this.f9228b).m8694c(this.f9232a.f975a);
                String string = this.f9232a.m1090a().toString();
                Intent intent = new Intent(UmengDownloadResourceService.this.f9228b, (Class<?>) UmengDownloadResourceService.class);
                intent.putExtra("body", string);
                intent.putExtra("id", this.f9232a.f976b);
                intent.putExtra("task_id", this.f9232a.f977c);
                intent.putExtra("OPERATIOIN", 1);
                intent.putExtra("RETRY_TIME", this.f9234c);
                UmengDownloadResourceService.this.startService(intent);
                return;
            }
            if (UmengDownloadResourceService.this.f9229c.size() == 0) {
                UmengDownloadResourceService.this.stopSelf();
            }
        }

        public boolean download(String str) throws Throwable {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                String str2 = str.hashCode() + "";
                String messageResourceFolder = UmengDownloadResourceService.getMessageResourceFolder(UmengDownloadResourceService.this.f9228b, this.f9232a);
                File file = new File(messageResourceFolder, str2 + ".tmp");
                File file2 = new File(messageResourceFolder, str2);
                if (file2.exists()) {
                    UmengDownloadResourceService.this.close(null);
                    UmengDownloadResourceService.this.close(null);
                    return true;
                }
                File file3 = new File(messageResourceFolder);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                InputStream inputStreamOpenStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i = inputStreamOpenStream.read(bArr);
                        if (i <= 0) {
                            file.renameTo(file2);
                            UmengDownloadResourceService.this.close(inputStreamOpenStream);
                            UmengDownloadResourceService.this.close(fileOutputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream = inputStreamOpenStream;
                    e = e;
                    e.printStackTrace();
                    UmengDownloadResourceService.this.close(inputStream);
                    UmengDownloadResourceService.this.close(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpenStream;
                    th = th;
                    UmengDownloadResourceService.this.close(inputStream);
                    UmengDownloadResourceService.this.close(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                e.printStackTrace();
                UmengDownloadResourceService.this.close(inputStream);
                UmengDownloadResourceService.this.close(fileOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                UmengDownloadResourceService.this.close(inputStream);
                UmengDownloadResourceService.this.close(fileOutputStream);
                throw th;
            }
        }
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCache() {
        try {
            checkDir(new File(getMessageResourceFolder(this.f9228b, null)), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 86400000L);
        } catch (Throwable unused) {
        }
    }

    public static void checkDir(final File file, long j, final long j2) {
        if (!file.exists() || m8739a(file.getCanonicalFile()) <= j) {
            return;
        }
        if (f9226d == null) {
            f9226d = new Thread(new Runnable() { // from class: com.umeng.message.UmengDownloadResourceService.1
                @Override // java.lang.Runnable
                public void run() {
                    UmengDownloadResourceService.m8743b(file, j2);
                    Thread unused = UmengDownloadResourceService.f9226d = null;
                }
            });
        }
        synchronized (f9226d) {
            f9226d.start();
        }
    }

    /* JADX INFO: renamed from: a */
    private static long m8739a(File file) {
        long length = 0;
        if (file == null || !file.exists() || !file.isDirectory()) {
            return 0L;
        }
        Stack stack = new Stack();
        stack.clear();
        stack.push(file);
        while (!stack.isEmpty()) {
            for (File file2 : ((File) stack.pop()).listFiles()) {
                if (!file2.isDirectory()) {
                    length += file2.length();
                }
            }
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m8743b(File file, long j) {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory() && System.currentTimeMillis() - file2.lastModified() > j) {
                    file2.delete();
                }
            }
        }
    }

    public static String getMessageResourceFolder(Context context, ahf ahfVar) {
        String str = context.getCacheDir() + "/umeng_push/";
        if (ahfVar == null || ahfVar.f975a == null) {
            return str;
        }
        return str + ahfVar.f975a + "/";
    }
}
