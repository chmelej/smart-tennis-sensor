package com.coollang.tennis.Custom;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class CommentTextLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private static final String f6204a = "CommentTextLayout";

    /* JADX INFO: renamed from: b */
    private TextView f6205b;

    /* JADX INFO: renamed from: c */
    private TextView f6206c;

    public CommentTextLayout(Context context) {
        this(context, null);
    }

    public CommentTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.layout_comment_text, (ViewGroup) this, true);
        this.f6205b = (TextView) findViewById(R.id.tv_comment);
        this.f6206c = (TextView) findViewById(R.id.tv_extent);
    }

    public void setTextExend(String str) {
        this.f6206c.setText(str);
    }

    public void set_Allshow() {
        this.f6205b.setMaxLines(Integer.MAX_VALUE);
        this.f6206c.setVisibility(8);
        requestLayout();
    }

    public void setCommentText(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6205b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coollang.tennis.Custom.CommentTextLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                String str2;
                TextPaint paint = CommentTextLayout.this.f6205b.getPaint();
                Rect rect = new Rect();
                paint.getTextBounds(CommentTextLayout.this.f6206c.getText().toString(), 0, CommentTextLayout.this.f6206c.getText().length(), rect);
                int iWidth = rect.width();
                paint.getTextBounds(str, 0, str.length(), rect);
                int width = (CommentTextLayout.this.getWidth() - CommentTextLayout.this.getPaddingLeft()) - CommentTextLayout.this.getPaddingRight();
                if (rect.width() / width > CommentTextLayout.this.f6205b.getMaxLines()) {
                    paint.setTextSize(CommentTextLayout.this.f6205b.getTextSize());
                    paint.getTextBounds("...", 0, "...".length(), rect);
                    int maxLines = ((CommentTextLayout.this.f6205b.getMaxLines() * width) - iWidth) - (rect.width() * 3);
                    rect.width();
                    str2 = (String) TextUtils.ellipsize(str, paint, maxLines, TextUtils.TruncateAt.END);
                } else {
                    CommentTextLayout.this.f6206c.setVisibility(8);
                    str2 = str;
                }
                paint.setTextSize(CommentTextLayout.this.f6205b.getTextSize());
                CommentTextLayout.this.f6205b.setText(str2);
            }
        });
    }

    public TextView getmTextExtend() {
        return this.f6206c;
    }
}
