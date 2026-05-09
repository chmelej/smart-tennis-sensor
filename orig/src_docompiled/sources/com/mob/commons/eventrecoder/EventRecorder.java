package com.mob.commons.eventrecoder;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.C1553e;
import com.mob.tools.MobLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class EventRecorder {

    /* JADX INFO: renamed from: a */
    private static Context f8995a;

    /* JADX INFO: renamed from: b */
    private static File f8996b;

    /* JADX INFO: renamed from: c */
    private static FileOutputStream f8997c;

    public static final synchronized void prepare(Context context) {
        f8995a = context.getApplicationContext();
        m8551a(new Runnable() { // from class: com.mob.commons.eventrecoder.EventRecorder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File unused = EventRecorder.f8996b = new File(EventRecorder.f8995a.getFilesDir(), ".mrecord");
                    if (!EventRecorder.f8996b.exists()) {
                        EventRecorder.f8996b.createNewFile();
                    }
                    FileOutputStream unused2 = EventRecorder.f8997c = new FileOutputStream(EventRecorder.f8996b, true);
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
        });
    }

    public static final synchronized void addBegin(String str, String str2) {
        m8552a(str + " " + str2 + " 0\n");
    }

    /* JADX INFO: renamed from: a */
    private static final void m8551a(Runnable runnable) {
        C1553e.m8546a(new File(f8995a.getFilesDir(), "comm/locks/.mrlock"), runnable);
    }

    public static final synchronized void addEnd(String str, String str2) {
        m8552a(str + " " + str2 + " 1\n");
    }

    /* JADX INFO: renamed from: a */
    private static final void m8552a(final String str) {
        m8551a(new Runnable() { // from class: com.mob.commons.eventrecoder.EventRecorder.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventRecorder.f8997c.write(str.getBytes("utf-8"));
                    EventRecorder.f8997c.flush();
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
        });
    }

    public static final synchronized String checkRecord(final String str) {
        final LinkedList linkedList = new LinkedList();
        m8551a(new Runnable() { // from class: com.mob.commons.eventrecoder.EventRecorder.3
            @Override // java.lang.Runnable
            public void run() {
                int iIndexOf;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(EventRecorder.f8996b), "utf-8"));
                    for (String line = bufferedReader.readLine(); !TextUtils.isEmpty(line); line = bufferedReader.readLine()) {
                        String[] strArrSplit = line.split(" ");
                        if (str.equals(strArrSplit[0])) {
                            if ("0".equals(strArrSplit[2])) {
                                linkedList.add(strArrSplit[1]);
                            } else if ("1".equals(strArrSplit[2]) && (iIndexOf = linkedList.indexOf(strArrSplit[1])) != -1) {
                                linkedList.remove(iIndexOf);
                            }
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    MobLog.getInstance().m8610d(th);
                }
            }
        });
        if (linkedList.size() <= 0) {
            return null;
        }
        return (String) linkedList.get(0);
    }

    public static final synchronized void clear() {
        m8551a(new Runnable() { // from class: com.mob.commons.eventrecoder.EventRecorder.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventRecorder.f8997c.close();
                    EventRecorder.f8996b.delete();
                    File unused = EventRecorder.f8996b = new File(EventRecorder.f8995a.getFilesDir(), ".mrecord");
                    EventRecorder.f8996b.createNewFile();
                    FileOutputStream unused2 = EventRecorder.f8997c = new FileOutputStream(EventRecorder.f8996b, true);
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
        });
    }
}
