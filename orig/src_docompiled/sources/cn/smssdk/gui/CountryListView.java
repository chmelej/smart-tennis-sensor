package cn.smssdk.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.smssdk.gui.GroupListView;
import cn.smssdk.gui.layout.SizeHelper;
import com.mob.tools.utils.C1583R;

/* JADX INFO: loaded from: classes.dex */
public class CountryListView extends RelativeLayout implements View.OnTouchListener {
    private CountryAdapter adapter;
    private LinearLayout llScroll;
    private GroupListView lvContries;
    private TextView tvScroll;

    public CountryListView(Context context) {
        super(context);
        init(context);
    }

    public CountryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CountryListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        SizeHelper.prepare(context);
        this.lvContries = new GroupListView(context);
        this.lvContries.setDividerHeight(SizeHelper.fromPxWidth(1));
        int bitmapRes = C1583R.getBitmapRes(context, "smssdk_cl_divider");
        if (bitmapRes > 0) {
            this.lvContries.setDivider(context.getResources().getDrawable(bitmapRes));
        }
        this.adapter = new CountryAdapter(this.lvContries);
        this.lvContries.setAdapter(this.adapter);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int iFromPxWidth = SizeHelper.fromPxWidth(12);
        layoutParams.setMargins(iFromPxWidth, 0, iFromPxWidth, 0);
        addView(this.lvContries, layoutParams);
        this.tvScroll = new TextView(context);
        int colorRes = C1583R.getColorRes(context, "smssdk_white");
        if (colorRes > 0) {
            this.tvScroll.setTextColor(context.getResources().getColor(colorRes));
        }
        int bitmapRes2 = C1583R.getBitmapRes(context, "smssdk_country_group_scroll_down");
        if (bitmapRes2 > 0) {
            this.tvScroll.setBackgroundResource(bitmapRes2);
        }
        this.tvScroll.setTextSize(0, SizeHelper.fromPxWidth(80));
        this.tvScroll.setTypeface(Typeface.DEFAULT);
        this.tvScroll.setVisibility(8);
        this.tvScroll.setGravity(17);
        int iFromPxWidth2 = SizeHelper.fromPxWidth(120);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iFromPxWidth2, iFromPxWidth2);
        layoutParams2.addRule(13);
        addView(this.tvScroll, layoutParams2);
        this.llScroll = new LinearLayout(context);
        int bitmapRes3 = C1583R.getBitmapRes(context, "smssdk_country_group_scroll_up");
        if (bitmapRes3 > 0) {
            this.llScroll.setBackgroundResource(bitmapRes3);
        }
        this.llScroll.setOrientation(1);
        this.llScroll.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = SizeHelper.fromPxWidth(7);
        addView(this.llScroll, layoutParams3);
        initScroll(context);
    }

    private void initScroll(Context context) {
        this.llScroll.removeAllViews();
        SizeHelper.prepare(context);
        int groupCount = this.adapter.getGroupCount();
        int iFromPxWidth = SizeHelper.fromPxWidth(6);
        int iFromPxWidth2 = SizeHelper.fromPxWidth(4);
        for (int i = 0; i < groupCount; i++) {
            TextView textView = new TextView(context);
            textView.setText(this.adapter.getGroupTitle(i));
            textView.setTextSize(0, SizeHelper.fromPxWidth(18));
            textView.setGravity(17);
            textView.setPadding(iFromPxWidth, iFromPxWidth2, iFromPxWidth, iFromPxWidth2);
            this.llScroll.addView(textView);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                int bitmapRes = C1583R.getBitmapRes(view.getContext(), "smssdk_country_group_scroll_down");
                if (bitmapRes > 0) {
                    view.setBackgroundResource(bitmapRes);
                }
                onScroll((ViewGroup) view, motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
            case 3:
                int bitmapRes2 = C1583R.getBitmapRes(view.getContext(), "smssdk_country_group_scroll_up");
                if (bitmapRes2 > 0) {
                    view.setBackgroundResource(bitmapRes2);
                }
                this.tvScroll.setVisibility(8);
                break;
            case 2:
                onScroll((ViewGroup) view, motionEvent.getX(), motionEvent.getY());
                break;
        }
        return true;
    }

    public void onScroll(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView textView = (TextView) viewGroup.getChildAt(i);
            if (f >= textView.getLeft() && f <= textView.getRight() && f2 >= textView.getTop() && f2 <= textView.getBottom()) {
                this.lvContries.setSelection(i);
                this.tvScroll.setVisibility(0);
                this.tvScroll.setText(textView.getText());
                return;
            }
        }
    }

    public void onSearch(String str) {
        this.adapter.search(str);
        this.adapter.notifyDataSetChanged();
        if (this.adapter.getGroupCount() == 0) {
            this.llScroll.setVisibility(8);
        } else {
            this.llScroll.setVisibility(0);
        }
        initScroll(getContext());
    }

    public void setOnItemClickListener(GroupListView.OnItemClickListener onItemClickListener) {
        this.lvContries.setOnItemClickListener(onItemClickListener);
    }

    public String[] getCountry(int i, int i2) {
        return this.adapter.getItem(i, i2);
    }
}
