package p000;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: lt */
/* JADX INFO: compiled from: BitmapUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1890lt {
    /* JADX INFO: renamed from: a */
    public static Bitmap m10437a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap.getWidth();
        int i = f == 0.0f ? height / 3 : (int) (f * height);
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height - i, width2, i, matrix, false);
            if (bitmapCreateBitmap == null) {
                return null;
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, bitmapCreateBitmap.getHeight(), 1895825407, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.MIRROR));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m10438a(String str, Bitmap bitmap) {
        File file = new File(C1852ki.f10915b + str + ".png");
        File file2 = new File(C1852ki.f10915b);
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file.createNewFile();
        } catch (IOException unused) {
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        try {
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
