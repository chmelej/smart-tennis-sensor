package com.lidroid.xutils.util;

import android.webkit.MimeTypeMap;

/* JADX INFO: loaded from: classes.dex */
public class MimeTypeUtils {
    private MimeTypeUtils() {
    }

    public static String getMimeType(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf == -1) {
            return "application/octet-stream";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1));
    }
}
