package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: kc */
/* JADX INFO: compiled from: FloatDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1846kc extends Drawable {

    /* JADX INFO: renamed from: a */
    private Context f10876a;

    /* JADX INFO: renamed from: b */
    private Drawable f10877b;

    /* JADX INFO: renamed from: c */
    private Paint f10878c = new Paint();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public C1846kc(Context context) {
        this.f10878c.setARGB(200, 50, 50, 50);
        this.f10878c.setStrokeWidth(1.0f);
        this.f10878c.setStyle(Paint.Style.STROKE);
        this.f10878c.setAntiAlias(true);
        this.f10878c.setColor(-1);
        this.f10876a = context;
        m10083a();
    }

    /* JADX INFO: renamed from: a */
    private void m10083a() {
        this.f10877b = this.f10876a.getResources().getDrawable(R.drawable.clip_point);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = getBounds().left;
        int i2 = getBounds().top;
        int i3 = getBounds().right;
        int i4 = getBounds().bottom;
        canvas.drawRect(new Rect((this.f10877b.getIntrinsicWidth() / 2) + i, (this.f10877b.getIntrinsicHeight() / 2) + i2, i3 - (this.f10877b.getIntrinsicWidth() / 2), i4 - (this.f10877b.getIntrinsicHeight() / 2)), this.f10878c);
        this.f10877b.setBounds(i, i2, this.f10877b.getIntrinsicWidth() + i, this.f10877b.getIntrinsicHeight() + i2);
        this.f10877b.draw(canvas);
        this.f10877b.setBounds(i3 - this.f10877b.getIntrinsicWidth(), i2, i3, this.f10877b.getIntrinsicHeight() + i2);
        this.f10877b.draw(canvas);
        this.f10877b.setBounds(i, i4 - this.f10877b.getIntrinsicHeight(), this.f10877b.getIntrinsicWidth() + i, i4);
        this.f10877b.draw(canvas);
        this.f10877b.setBounds(i3 - this.f10877b.getIntrinsicWidth(), i4 - this.f10877b.getIntrinsicHeight(), i3, i4);
        this.f10877b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(new Rect(rect.left - (this.f10877b.getIntrinsicWidth() / 2), rect.top - (this.f10877b.getIntrinsicHeight() / 2), rect.right + (this.f10877b.getIntrinsicWidth() / 2), rect.bottom + (this.f10877b.getIntrinsicHeight() / 2)));
    }
}
