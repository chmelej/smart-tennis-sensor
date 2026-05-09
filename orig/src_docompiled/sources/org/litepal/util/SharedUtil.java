package org.litepal.util;

import android.content.SharedPreferences;
import org.litepal.LitePalApplication;

/* JADX INFO: loaded from: classes.dex */
public class SharedUtil {
    private static final String LITEPAL_PREPS = "litepal_prefs";
    private static final String VERSION = "litepal_version";

    public static void updateVersion(int i) {
        SharedPreferences.Editor editorEdit = LitePalApplication.getContext().getSharedPreferences(LITEPAL_PREPS, 0).edit();
        editorEdit.putInt(VERSION, i);
        editorEdit.commit();
    }

    public static int getLastVersion() {
        return LitePalApplication.getContext().getSharedPreferences(LITEPAL_PREPS, 0).getInt(VERSION, 0);
    }
}
