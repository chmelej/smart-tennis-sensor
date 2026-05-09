package com.mob.tools.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.mob.tools.network.KVPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: renamed from: com.mob.tools.utils.R */
/* JADX INFO: loaded from: classes.dex */
public class C1583R {
    public static int dipToPx(Context context, int i) {
        return ResHelper.dipToPx(context, i);
    }

    public static int pxToDip(Context context, int i) {
        return ResHelper.pxToDip(context, i);
    }

    public static int designToDevice(Context context, int i, int i2) {
        return ResHelper.designToDevice(context, i, i2);
    }

    public static int designToDevice(Context context, float f, int i) {
        return ResHelper.designToDevice(context, f, i);
    }

    public static int[] getScreenSize(Context context) {
        return ResHelper.getScreenSize(context);
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static void setResourceProvider(Object obj) {
        ResHelper.setResourceProvider(obj);
    }

    public static int getResId(Context context, String str, String str2) {
        return ResHelper.getResId(context, str, str2);
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, "string", str);
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, "layout", str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, "id", str);
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static String getCacheRoot(Context context) {
        return ResHelper.getCacheRoot(context);
    }

    public static String getCachePath(Context context, String str) {
        return ResHelper.getCachePath(context, str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static void clearCache(Context context) {
        ResHelper.clearCache(context);
    }

    public static void deleteFilesInFolder(File file) {
        ResHelper.deleteFilesInFolder(file);
    }

    public static void deleteFileAndFolder(File file) {
        ResHelper.deleteFileAndFolder(file);
    }

    public static String toWordText(String str, int i) {
        return ResHelper.toWordText(str, i);
    }

    public static int getTextLengthInWord(String str) {
        return ResHelper.getTextLengthInWord(str);
    }

    public static long strToDate(String str) {
        return ResHelper.strToDate(str);
    }

    public static long dateStrToLong(String str) {
        return ResHelper.dateStrToLong(str);
    }

    public static Date longToDate(long j) {
        return ResHelper.longToDate(j);
    }

    public static String longToTime(long j, int i) {
        return ResHelper.longToTime(j, i);
    }

    public static long dateToLong(String str) {
        return ResHelper.dateToLong(str);
    }

    public static int[] covertTimeInYears(long j) {
        return ResHelper.covertTimeInYears(j);
    }

    public static Uri pathToContentUri(Context context, String str) {
        return ResHelper.pathToContentUri(context, str);
    }

    public static String contentUriToPath(Context context, Uri uri) {
        return ResHelper.contentUriToPath(context, uri);
    }

    public static String encodeUrl(Bundle bundle) {
        return ResHelper.encodeUrl(bundle);
    }

    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        return ResHelper.encodeUrl(arrayList);
    }

    public static Bundle urlToBundle(String str) {
        return ResHelper.urlToBundle(str);
    }

    public static Bundle decodeUrl(String str) {
        return ResHelper.decodeUrl(str);
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    public static int parseInt(String str, int i) {
        return ResHelper.parseInt(str, i);
    }

    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    public static long parseLong(String str, int i) {
        return ResHelper.parseLong(str, i);
    }

    public static String toString(Object obj) {
        return ResHelper.toString(obj);
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    public static <T> T forceCast(Object obj, T t) {
        return (T) ResHelper.forceCast(obj, t);
    }

    public static boolean copyFile(String str, String str2) {
        return ResHelper.copyFile(str, str2);
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        ResHelper.copyFile(fileInputStream, fileOutputStream);
    }

    public static long getFileSize(String str) {
        return ResHelper.getFileSize(str);
    }

    public static long getFileSize(File file) {
        return ResHelper.getFileSize(file);
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        return ResHelper.saveObjectToFile(str, obj);
    }

    public static Object readObjectFromFile(String str) {
        return ResHelper.readObjectFromFile(str);
    }
}
