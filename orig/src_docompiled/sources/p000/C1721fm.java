package p000;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

/* JADX INFO: renamed from: fm */
/* JADX INFO: compiled from: ActionBarBackgroundDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1721fm extends Drawable {

    /* JADX INFO: renamed from: a */
    final ActionBarContainer f9806a;

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

    public C1721fm(ActionBarContainer actionBarContainer) {
        this.f9806a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f9806a.f3315d) {
            if (this.f9806a.f3314c != null) {
                this.f9806a.f3314c.draw(canvas);
            }
        } else {
            if (this.f9806a.f3312a != null) {
                this.f9806a.f3312a.draw(canvas);
            }
            if (this.f9806a.f3313b == null || !this.f9806a.f3316e) {
                return;
            }
            this.f9806a.f3313b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f9806a.f3315d) {
            if (this.f9806a.f3314c != null) {
                this.f9806a.f3314c.getOutline(outline);
            }
        } else if (this.f9806a.f3312a != null) {
            this.f9806a.f3312a.getOutline(outline);
        }
    }
}
