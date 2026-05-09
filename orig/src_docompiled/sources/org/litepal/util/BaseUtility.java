package org.litepal.util;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.litepal.exceptions.DataSupportException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class BaseUtility {
    private BaseUtility() {
    }

    public static String changeCase(String str) {
        if (str == null) {
            return null;
        }
        String cases = LitePalAttr.getInstance().getCases();
        if (Const.LitePal.CASES_KEEP.equals(cases)) {
            return str;
        }
        if (Const.LitePal.CASES_UPPER.equals(cases)) {
            return str.toUpperCase(Locale.US);
        }
        return str.toLowerCase(Locale.US);
    }

    public static boolean containsIgnoreCases(Collection<String> collection, String str) {
        if (collection == null) {
            return false;
        }
        if (str == null) {
            return collection.contains(null);
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            if (str == null) {
                return null;
            }
            return "";
        }
        return String.valueOf(str.substring(0, 1).toUpperCase(Locale.US)) + str.substring(1);
    }

    public static int count(String str, String str2) {
        int i = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        int iIndexOf = str.indexOf(str2);
        while (iIndexOf != -1) {
            i++;
            str = str.substring(iIndexOf + str2.length());
            iIndexOf = str.indexOf(str2);
        }
        return i;
    }

    public static void checkConditionsCorrect(String... strArr) {
        int length;
        if (strArr != null && (length = strArr.length) > 0 && length != count(strArr[0], "?") + 1) {
            throw new DataSupportException(DataSupportException.UPDATE_CONDITIONS_EXCEPTION);
        }
    }

    public static boolean isFieldTypeSupported(String str) {
        return "boolean".equals(str) || "java.lang.Boolean".equals(str) || "float".equals(str) || "java.lang.Float".equals(str) || "double".equals(str) || "java.lang.Double".equals(str) || "int".equals(str) || "java.lang.Integer".equals(str) || "long".equals(str) || "java.lang.Long".equals(str) || "short".equals(str) || "java.lang.Short".equals(str) || "char".equals(str) || "java.lang.Character".equals(str) || "java.lang.String".equals(str) || "java.util.Date".equals(str);
    }
}
