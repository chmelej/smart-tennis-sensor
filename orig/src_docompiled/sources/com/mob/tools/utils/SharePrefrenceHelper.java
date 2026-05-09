package com.mob.tools.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class SharePrefrenceHelper {
    private Context context;
    private SharedPreferences prefrence;

    public SharePrefrenceHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    public void open(String str) {
        open(str, 0);
    }

    public void open(String str, int i) {
        this.prefrence = this.context.getSharedPreferences(str + "_" + i, 0);
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public String getString(String str) {
        return this.prefrence.getString(str, "");
    }

    public void putBoolean(String str, Boolean bool) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.putBoolean(str, bool.booleanValue());
        editorEdit.commit();
    }

    public boolean getBoolean(String str) {
        return this.prefrence.getBoolean(str, false);
    }

    public void putLong(String str, Long l) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.putLong(str, l.longValue());
        editorEdit.commit();
    }

    public long getLong(String str) {
        return this.prefrence.getLong(str, 0L);
    }

    public void putInt(String str, Integer num) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.putInt(str, num.intValue());
        editorEdit.commit();
    }

    public int getInt(String str) {
        return this.prefrence.getInt(str, 0);
    }

    public void putFloat(String str, Float f) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.putFloat(str, f.floatValue());
        editorEdit.commit();
    }

    public float getFloat(String str) {
        return this.prefrence.getFloat(str, 0.0f);
    }

    public void put(String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            putString(str, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    public Object get(String str) {
        try {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string, 2)));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public void remove(String str) {
        SharedPreferences.Editor editorEdit = this.prefrence.edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }
}
