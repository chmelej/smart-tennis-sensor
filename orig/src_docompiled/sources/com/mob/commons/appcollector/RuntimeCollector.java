package com.mob.commons.appcollector;

import android.content.Context;
import android.os.Build;
import com.mob.commons.C1541a;
import com.mob.commons.C1549c;
import com.mob.commons.C1550d;
import com.mob.commons.C1553e;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeCollector {

    /* JADX INFO: renamed from: a */
    private static final String f8960a;

    /* JADX INFO: renamed from: b */
    private static RuntimeCollector f8961b;

    /* JADX INFO: renamed from: c */
    private Context f8962c;

    static {
        f8960a = Build.VERSION.SDK_INT >= 16 ? "^u\\d+_a\\d+" : "^app_\\d+";
    }

    public static synchronized void startCollector(Context context, String str) {
        startCollector(context);
    }

    public static synchronized void startCollector(Context context) {
        if (f8961b == null) {
            f8961b = new RuntimeCollector(context);
            f8961b.m8487a();
        }
    }

    private RuntimeCollector(Context context) {
        this.f8962c = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    private void m8487a() {
        Thread thread = new Thread() { // from class: com.mob.commons.appcollector.RuntimeCollector.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C1553e.m8546a(new File(ResHelper.getCacheRoot(RuntimeCollector.this.f8962c), "comm/locks/.rc_lock"), new Runnable() { // from class: com.mob.commons.appcollector.RuntimeCollector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (C1550d.m8530a(RuntimeCollector.this.f8962c, "comm/tags/.rcTag")) {
                            return;
                        }
                        RuntimeCollector.this.m8493b();
                    }
                });
            }
        };
        thread.setPriority(1);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m8493b() {
        Process processExec;
        String str;
        Process processExec2;
        try {
            File file = new File(ResHelper.getCacheRoot(this.f8962c), "comm/dbs/.plst");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            long jM8496c = m8496c();
            C1550d.m8531b(this.f8962c, "comm/tags/.rcTag");
            OutputStream outputStream = null;
            try {
                processExec = Runtime.getRuntime().exec("sh");
                try {
                    outputStream = processExec.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                    MobLog.getInstance().m8622w(th);
                }
            } catch (Throwable th2) {
                th = th2;
                processExec = null;
            }
            C1550d.m8532c(this.f8962c, "comm/tags/.rcTag");
            long j = jM8496c;
            boolean z = true;
            while (true) {
                try {
                    if (C1541a.m8446b(this.f8962c)) {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        long jM8440a = C1541a.m8440a(this.f8962c);
                        outputStream.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"======================\" >> " + absolutePath + "\n").getBytes("ascii"));
                        if (z) {
                            str = "echo \"" + jM8440a + "_0\" >> " + absolutePath + "\n";
                            z = false;
                        } else {
                            str = "echo \"" + jM8440a + "_" + C1541a.m8447c(this.f8962c) + "\" >> " + absolutePath + "\n";
                        }
                        outputStream.write(str.getBytes("ascii"));
                        outputStream.flush();
                        if (jM8440a >= j) {
                            outputStream.write("exit\n".getBytes("ascii"));
                            outputStream.flush();
                            outputStream.close();
                            processExec.waitFor();
                            processExec.destroy();
                            if (m8491a(absolutePath)) {
                                long jM8497d = m8497d();
                                if (jM8497d > 0) {
                                    j = jM8497d;
                                }
                                z = true;
                            }
                            C1550d.m8531b(this.f8962c, "comm/tags/.rcTag");
                            try {
                                processExec2 = Runtime.getRuntime().exec("sh");
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                outputStream = processExec2.getOutputStream();
                            } catch (Throwable th4) {
                                processExec = processExec2;
                                th = th4;
                                MobLog.getInstance().m8622w(th);
                                processExec2 = processExec;
                            }
                            try {
                                C1550d.m8532c(this.f8962c, "comm/tags/.rcTag");
                                processExec = processExec2;
                            } catch (Throwable th5) {
                                processExec = processExec2;
                                th = th5;
                                MobLog.getInstance().m8610d(th);
                            }
                        }
                    }
                    Thread.sleep(C1541a.m8447c(this.f8962c) * 1000);
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    private long m8496c() {
        long jM8440a = C1541a.m8440a(this.f8962c);
        try {
            File file = new File(ResHelper.getCacheRoot(this.f8962c), "comm/dbs/.nulplt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                long j = dataInputStream.readLong();
                dataInputStream.close();
                return j;
            }
            file.createNewFile();
            m8497d();
            return jM8440a + 86400000;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return jM8440a + 86400000;
        }
    }

    /* JADX INFO: renamed from: d */
    private long m8497d() {
        long jM8440a = C1541a.m8440a(this.f8962c) + 86400000;
        try {
            File file = new File(ResHelper.getCacheRoot(this.f8962c), "comm/dbs/.nulplt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(jM8440a);
            dataOutputStream.flush();
            dataOutputStream.close();
            return jM8440a;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return 0L;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m8491a(String str) {
        ArrayList<ArrayList<HashMap<String, String>>> arrayList = new ArrayList<>();
        ArrayList<long[]> arrayList2 = new ArrayList<>();
        m8488a(str, arrayList, arrayList2);
        m8490a(m8485a(m8492a(m8486a(arrayList), arrayList), arrayList2), arrayList2);
        return m8495b(str);
    }

    /* JADX INFO: renamed from: a */
    private void m8488a(String str, ArrayList<ArrayList<HashMap<String, String>>> arrayList, ArrayList<long[]> arrayList2) {
        try {
            HashMap<String, String[]> mapM8498e = m8498e();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "utf-8"));
            String line = bufferedReader.readLine();
            for (int i = 0; i < 7; i++) {
                line = bufferedReader.readLine();
            }
            ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
            while (line != null) {
                if ("======================".equals(line)) {
                    try {
                        String[] strArrSplit = bufferedReader.readLine().split("_");
                        long[] jArr = {Long.valueOf(strArrSplit[0]).longValue(), Long.valueOf(strArrSplit[1]).longValue()};
                        arrayList.add(arrayList3);
                        arrayList2.add(jArr);
                    } catch (Throwable unused) {
                    }
                    arrayList3 = new ArrayList<>();
                    for (int i2 = 0; i2 < 7; i2++) {
                        bufferedReader.readLine();
                    }
                } else if (line.length() > 0) {
                    m8489a(line, mapM8498e, arrayList3);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8489a(String str, HashMap<String, String[]> map, ArrayList<HashMap<String, String>> arrayList) {
        String[] strArr;
        String[] strArrSplit = str.replaceAll(" +", " ").split(" ");
        if (strArrSplit == null || strArrSplit.length < 10) {
            return;
        }
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (!strArrSplit[strArrSplit.length - 2].matches(f8960a) || "top".equals(str2) || (strArr = map.get(str2)) == null) {
            return;
        }
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("pkg", str2);
        map2.put(Const.TableSchema.COLUMN_NAME, strArr[0]);
        map2.put("version", strArr[1]);
        map2.put("pcy", strArrSplit[strArrSplit.length - 3]);
        arrayList.add(map2);
    }

    /* JADX INFO: renamed from: e */
    private HashMap<String, String[]> m8498e() {
        ArrayList<HashMap> arrayList;
        try {
            arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8962c), "getInstalledApp", false);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            arrayList = new ArrayList();
        }
        HashMap<String, String[]> map = new HashMap<>();
        for (HashMap map2 : arrayList) {
            map.put((String) map2.get("pkg"), new String[]{(String) map2.get(Const.TableSchema.COLUMN_NAME), (String) map2.get("version")});
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Integer> m8486a(ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
        HashMap<String, Integer> map = new HashMap<>();
        Iterator<ArrayList<HashMap<String, String>>> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            for (HashMap<String, String> map2 : it.next()) {
                String str = map2.get("pkg") + ":" + map2.get("version");
                if (!map.containsKey(str)) {
                    map.put(str, Integer.valueOf(i));
                    i++;
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, String>[][] m8492a(HashMap<String, Integer> map, ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
        HashMap<String, String>[][] mapArr = (HashMap[][]) Array.newInstance((Class<?>) HashMap.class, map.size(), arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ArrayList<HashMap<String, String>> arrayList2 = arrayList.get(i);
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HashMap<String, String> map2 = arrayList2.get(i2);
                mapArr[map.get(map2.get("pkg") + ":" + map2.get("version")).intValue()][i] = map2;
            }
        }
        return mapArr;
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<HashMap<String, Object>> m8485a(HashMap<String, String>[][] mapArr, ArrayList<long[]> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>(mapArr.length);
        for (HashMap<String, String>[] mapArr2 : mapArr) {
            HashMap<String, Object> map = new HashMap<>();
            long j = 0;
            map.put("runtimes", 0L);
            map.put("fg", 0);
            map.put("bg", 0);
            map.put("empty", 0);
            arrayList2.add(map);
            int length = mapArr2.length - 1;
            while (length >= 0) {
                if (mapArr2[length] != null) {
                    map.put("runtimes", Long.valueOf(((Long) ResHelper.forceCast(map.get("runtimes"), Long.valueOf(j))).longValue() + (length == 0 ? j : arrayList.get(length)[1])));
                    if ("fg".equals(mapArr2[length].get("pcy"))) {
                        map.put("fg", Integer.valueOf(((Integer) ResHelper.forceCast(map.get("fg"), 0)).intValue() + 1));
                    } else if ("bg".equals(mapArr2[length].get("pcy"))) {
                        map.put("bg", Integer.valueOf(((Integer) ResHelper.forceCast(map.get("bg"), 0)).intValue() + 1));
                    } else {
                        map.put("empty", Integer.valueOf(((Integer) ResHelper.forceCast(map.get("empty"), 0)).intValue() + 1));
                    }
                    map.put("pkg", mapArr2[length].get("pkg"));
                    map.put(Const.TableSchema.COLUMN_NAME, mapArr2[length].get(Const.TableSchema.COLUMN_NAME));
                    map.put("version", mapArr2[length].get("version"));
                }
                length--;
                j = 0;
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: a */
    private void m8490a(ArrayList<HashMap<String, Object>> arrayList, ArrayList<long[]> arrayList2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "APP_RUNTIMES");
        map.put("list", arrayList);
        map.put("datatime", Long.valueOf(C1541a.m8440a(this.f8962c)));
        map.put("recordat", Long.valueOf(arrayList2.get(0)[0]));
        long j = 0;
        int i = 1;
        while (i < arrayList2.size()) {
            long j2 = j + arrayList2.get(i)[1];
            i++;
            j = j2;
        }
        map.put("sdk_runtime_len", Long.valueOf(j));
        map.put("top_count", Integer.valueOf(arrayList2.size()));
        C1549c.m8516a(this.f8962c).m8529a(C1541a.m8440a(this.f8962c), map);
    }

    /* JADX INFO: renamed from: b */
    private boolean m8495b(String str) {
        try {
            File file = new File(str);
            file.delete();
            file.createNewFile();
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return false;
        }
    }
}
