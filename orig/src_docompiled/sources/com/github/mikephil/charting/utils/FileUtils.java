package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split("#");
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
                } else {
                    float[] fArr = new float[strArrSplit.length - 1];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr[i] = Float.parseFloat(strArrSplit[i]);
                    }
                    arrayList.add(new BarEntry(fArr, Integer.parseInt(strArrSplit[strArrSplit.length - 1])));
                }
            }
        } catch (IOException e) {
            Log.e(LOG, e.toString());
        }
        return arrayList;
    }

    public static List<Entry> loadEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (IOException e) {
                    Log.e(LOG, e.toString());
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            bufferedReader = bufferedReader2;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] strArrSplit = line.split("#");
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
                } else {
                    float[] fArr = new float[strArrSplit.length - 1];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr[i] = Float.parseFloat(strArrSplit[i]);
                    }
                    arrayList.add(new BarEntry(fArr, Integer.parseInt(strArrSplit[strArrSplit.length - 1])));
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            Log.e(LOG, e.toString());
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    Log.e(LOG, e4.toString());
                }
            }
            throw th;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return arrayList;
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e(LOG, e.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getVal() + "#" + entry.getXIndex()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e2) {
            Log.e(LOG, e2.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9, types: [float] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:31:0x0065). Please report as a decompilation issue!!! */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        ?? bufferedReader;
        ArrayList arrayList = new ArrayList();
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = r1;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String[] strArrSplit = line.split("#");
                    r1 = Float.parseFloat(strArrSplit[0]);
                    arrayList.add(new BarEntry((float) r1, Integer.parseInt(strArrSplit[1])));
                }
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
            } catch (IOException e2) {
                e = e2;
                r1 = bufferedReader;
                Log.e(LOG, e.toString());
                if (r1 != 0) {
                    r1.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != 0) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        Log.e(LOG, e3.toString());
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            Log.e(LOG, e4.toString());
        }
        return arrayList;
    }
}
