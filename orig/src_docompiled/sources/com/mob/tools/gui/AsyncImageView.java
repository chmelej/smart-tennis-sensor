package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class AsyncImageView extends ImageView implements Handler.Callback, BitmapProcessor.BitmapCallback {
    private static final int MSG_IMG_GOT = 1;
    private static final Random RND = new Random();
    private Bitmap defaultBm;
    private int defaultRes;
    private boolean lastReqIsOk;
    private Path path;
    private float[] rect;
    private boolean scaleToCrop;
    private String url;

    public AsyncImageView(Context context) {
        super(context);
        init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        if (isInEditMode()) {
            setBackgroundColor(-16777216);
        } else {
            BitmapProcessor.prepare(context);
        }
    }

    public void setRound(float f) {
        setRound(f, f, f, f);
    }

    public void setRound(float f, float f2, float f3, float f4) {
        this.rect = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public void setScaleToCropCenter(boolean z) {
        this.scaleToCrop = z;
    }

    public void execute(String str, int i) {
        if (this.lastReqIsOk && str != null && str.equals(this.url)) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = str;
        this.defaultRes = i;
        if (TextUtils.isEmpty(str)) {
            setImageResource(i);
            return;
        }
        Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(str);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            setBitmap(bitmapFromCache);
            return;
        }
        if (i > 0) {
            setImageResource(i);
        }
        BitmapProcessor.process(str, this);
    }

    public void execute(String str, Bitmap bitmap) {
        if (this.lastReqIsOk && str != null && str.equals(this.url)) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = str;
        this.defaultBm = bitmap;
        if (TextUtils.isEmpty(str)) {
            setImageBitmap(bitmap);
            return;
        }
        Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(str);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            setBitmap(bitmapFromCache);
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            setImageBitmap(bitmap);
        }
        BitmapProcessor.process(str, this);
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        setImageBitmap(bitmap);
    }

    public void onImageGot(String str, Bitmap bitmap) {
        if (str == null || str.trim().length() <= 0 || !str.equals(this.url)) {
            bitmap = null;
        }
        if (bitmap != null && this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        Message message = new Message();
        message.what = 1;
        message.obj = new Object[]{str, bitmap};
        UIHandler.sendMessageDelayed(message, RND.nextInt(300), this);
        UIHandler.sendMessage(message, this);
    }

    private Bitmap goCrop(Bitmap bitmap) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return bitmap;
        }
        int[] size = getSize();
        if (size[0] == 0 || size[1] == 0) {
            return bitmap;
        }
        float f = (size[1] * width) / size[0];
        if (f == height) {
            return bitmap;
        }
        int[] iArr = new int[4];
        if (f < height) {
            iArr[1] = (int) ((height - f) / 2.0f);
            iArr[3] = iArr[1];
        } else {
            iArr[0] = (int) ((width - ((size[0] * height) / size[1])) / 2.0f);
            iArr[2] = iArr[0];
        }
        try {
            return BitmapHelper.cropBitmap(bitmap, iArr[0], iArr[1], iArr[2], iArr[3]);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return bitmap;
        }
    }

    private int[] getSize() {
        ViewGroup.LayoutParams layoutParams;
        int width = getWidth();
        int height = getHeight();
        if ((width == 0 || height == 0) && (layoutParams = getLayoutParams()) != null) {
            width = layoutParams.width;
            height = layoutParams.height;
        }
        if (width == 0 || height == 0) {
            measure(0, 0);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        return new int[]{width, height};
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            Object obj = ((Object[]) message.obj)[0];
            Object obj2 = ((Object[]) message.obj)[1];
            if (obj2 != null && obj != null && obj.equals(this.url)) {
                setImageBitmap((Bitmap) obj2);
                this.lastReqIsOk = true;
            } else if (this.defaultBm != null && !this.defaultBm.isRecycled()) {
                setImageBitmap(this.defaultBm);
            } else {
                setImageResource(this.defaultRes);
            }
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, width, height), this.rect, Path.Direction.CW);
            }
            canvas.clipPath(this.path);
        }
        super.onDraw(canvas);
    }
}
