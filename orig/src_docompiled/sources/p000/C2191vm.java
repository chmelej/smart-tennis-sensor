package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: vm */
/* JADX INFO: compiled from: OpenGlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2191vm {
    /* JADX INFO: renamed from: a */
    public static int m11993a(Context context, String str, boolean z) {
        Bitmap bitmapM11995a;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            if (z) {
                bitmapM11995a = m11994a(context, str);
            } else {
                bitmapM11995a = m11995a(str);
            }
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmapM11995a, 0);
            bitmapM11995a.recycle();
        }
        if (iArr[0] == 0) {
            throw new RuntimeException("Error loading texture.");
        }
        return iArr[0];
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m11994a(Context context, String str) {
        Bitmap bitmapDecodeStream;
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getResources().getAssets().open(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
        } catch (IOException e) {
            e = e;
            bitmapDecodeStream = null;
        }
        try {
            inputStreamOpen.close();
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
        }
        return bitmapDecodeStream;
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m11995a(String str) {
        if (new File(str).exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return null;
    }
}
