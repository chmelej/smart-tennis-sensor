package cn.smssdk.gui;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SearchEngine {
    private static final String DB_FILE = "smssdk_pydb";
    private static HashMap<String, Object> hanzi2Pinyin;
    private boolean caseSensitive;
    private ArrayList<SearchIndex> index;

    public static void prepare(final Context context, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: cn.smssdk.gui.SearchEngine.1
            /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x006e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:15:0x0063, B:17:0x0067, B:18:0x006c, B:8:0x0013, B:10:0x001d, B:11:0x0026, B:14:0x0054), top: B:26:0x0003, inners: #0 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0054 -> B:23:0x0063). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r3 = this;
                    java.lang.String r0 = "smssdk_pydb"
                    monitor-enter(r0)
                    java.util.HashMap r1 = cn.smssdk.gui.SearchEngine.access$000()     // Catch: java.lang.Throwable -> L6e
                    if (r1 == 0) goto L13
                    java.util.HashMap r1 = cn.smssdk.gui.SearchEngine.access$000()     // Catch: java.lang.Throwable -> L6e
                    int r1 = r1.size()     // Catch: java.lang.Throwable -> L6e
                    if (r1 > 0) goto L63
                L13:
                    android.content.Context r1 = r1     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.lang.String r2 = "smssdk_pydb"
                    int r1 = com.mob.tools.utils.C1583R.getRawRes(r1, r2)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    if (r1 > 0) goto L26
                    java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r1.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    goto L63
                L26:
                    android.content.Context r2 = r1     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.io.InputStream r1 = r2.openRawResource(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r2.close()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    com.mob.tools.utils.Hashon r2 = new com.mob.tools.utils.Hashon     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    r2.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    java.util.HashMap r1 = r2.fromJson(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Throwable -> L6e
                    goto L63
                L53:
                    r1 = move-exception
                    com.mob.tools.log.NLog r2 = cn.smssdk.utils.SMSLog.getInstance()     // Catch: java.lang.Throwable -> L6e
                    r2.m8622w(r1)     // Catch: java.lang.Throwable -> L6e
                    java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6e
                    r1.<init>()     // Catch: java.lang.Throwable -> L6e
                    cn.smssdk.gui.SearchEngine.access$002(r1)     // Catch: java.lang.Throwable -> L6e
                L63:
                    java.lang.Runnable r1 = r2     // Catch: java.lang.Throwable -> L6e
                    if (r1 == 0) goto L6c
                    java.lang.Runnable r1 = r2     // Catch: java.lang.Throwable -> L6e
                    r1.run()     // Catch: java.lang.Throwable -> L6e
                L6c:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
                    return
                L6e:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.smssdk.gui.SearchEngine.RunnableC09691.run():void");
            }
        };
        if (runnable != null) {
            new Thread(runnable2).start();
        } else {
            runnable2.run();
        }
    }

    public void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    public void setIndex(ArrayList<String> arrayList) {
        this.index = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.index.add(new SearchIndex(it.next(), hanzi2Pinyin));
        }
    }

    public ArrayList<String> match(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.index == null) {
            return arrayList;
        }
        for (SearchIndex searchIndex : this.index) {
            if (searchIndex.match(str, this.caseSensitive)) {
                arrayList.add(searchIndex.getText());
            }
        }
        return arrayList;
    }

    static class SearchIndex {
        private String text;
        private ArrayList<String> pinyin = new ArrayList<>();
        private ArrayList<String> firstLatters = new ArrayList<>();

        public SearchIndex(String str, HashMap<String, Object> map) {
            this.text = str;
            createPinyinList(map);
        }

        private void createPinyinList(HashMap<String, Object> map) {
            if (map == null || map.size() <= 0) {
                return;
            }
            char[] charArray = this.text.toCharArray();
            ArrayList<String[]> arrayList = new ArrayList<>();
            for (char c : charArray) {
                ArrayList arrayList2 = (ArrayList) map.get(String.valueOf(c));
                int size = arrayList2 == null ? 0 : arrayList2.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    String str = (String) ((HashMap) arrayList2.get(i)).get("yin");
                    if ("none".equals(str)) {
                        str = "";
                    }
                    strArr[i] = str;
                }
                arrayList.add(strArr);
            }
            HashSet<String> hashSet = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            toPinyinArray("", "", hashSet, hashSet2, arrayList);
            this.pinyin.addAll(hashSet);
            this.firstLatters.addAll(hashSet2);
        }

        private void toPinyinArray(String str, String str2, HashSet<String> hashSet, HashSet<String> hashSet2, ArrayList<String[]> arrayList) {
            if (arrayList.size() > 0) {
                String[] strArr = arrayList.get(0);
                ArrayList<String[]> arrayList2 = new ArrayList<>();
                arrayList2.addAll(arrayList);
                arrayList2.remove(0);
                for (String str3 : strArr) {
                    if (str3.length() > 0) {
                        toPinyinArray(str + str3, str2 + str3.charAt(0), hashSet, hashSet2, arrayList2);
                    } else {
                        toPinyinArray(str, str2, hashSet, hashSet2, arrayList2);
                    }
                }
                return;
            }
            hashSet.add(str);
            hashSet2.add(str2);
        }

        public String getText() {
            return this.text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean match(String str, boolean z) {
            if (str == null || str.trim().length() <= 0) {
                return true;
            }
            if (!z) {
                str = str.toLowerCase();
            }
            if (this.text != null && this.text.toLowerCase().contains(str)) {
                return true;
            }
            Iterator<String> it = this.pinyin.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
            Iterator<String> it2 = this.firstLatters.iterator();
            while (it2.hasNext()) {
                if (it2.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            HashMap map = new HashMap();
            map.put("text", this.text);
            map.put("pinyin", this.pinyin);
            map.put("firstLatters", this.firstLatters);
            return map.toString();
        }
    }
}
