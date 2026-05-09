package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.coollang.tennis.R;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class KCalendar extends ViewFlipper implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a */
    public static final int f8375a = Color.parseColor("#ffffff");

    /* JADX INFO: renamed from: b */
    public static final int f8376b = Color.parseColor("#aa7b7a80");

    /* JADX INFO: renamed from: c */
    public static final int f8377c = Color.parseColor("#aa564b4b");

    /* JADX INFO: renamed from: d */
    public static final int f8378d = Color.parseColor("#ffcccccc");

    /* JADX INFO: renamed from: e */
    public static final int f8379e = Color.parseColor("#ff008000");

    /* JADX INFO: renamed from: f */
    public static final int f8380f = Color.parseColor("#ffffff");

    /* JADX INFO: renamed from: g */
    public static final int f8381g = Color.parseColor("#ffffff");

    /* JADX INFO: renamed from: A */
    private Map<String, Integer> f8382A;

    /* JADX INFO: renamed from: B */
    private Map<String, Integer> f8383B;

    /* JADX INFO: renamed from: C */
    private InterfaceC1341c f8384C;

    /* JADX INFO: renamed from: h */
    private GestureDetector f8385h;

    /* JADX INFO: renamed from: i */
    private Animation f8386i;

    /* JADX INFO: renamed from: j */
    private Animation f8387j;

    /* JADX INFO: renamed from: k */
    private Animation f8388k;

    /* JADX INFO: renamed from: l */
    private Animation f8389l;

    /* JADX INFO: renamed from: m */
    private int f8390m;

    /* JADX INFO: renamed from: n */
    private int f8391n;

    /* JADX INFO: renamed from: o */
    private String[][] f8392o;

    /* JADX INFO: renamed from: p */
    private float f8393p;

    /* JADX INFO: renamed from: q */
    private InterfaceC1339a f8394q;

    /* JADX INFO: renamed from: r */
    private InterfaceC1340b f8395r;

    /* JADX INFO: renamed from: s */
    private String[] f8396s;

    /* JADX INFO: renamed from: t */
    private int f8397t;

    /* JADX INFO: renamed from: u */
    private int f8398u;

    /* JADX INFO: renamed from: v */
    private Date f8399v;

    /* JADX INFO: renamed from: w */
    private Date f8400w;

    /* JADX INFO: renamed from: x */
    private LinearLayout f8401x;

    /* JADX INFO: renamed from: y */
    private LinearLayout f8402y;

    /* JADX INFO: renamed from: z */
    private LinearLayout f8403z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.KCalendar$a */
    public interface InterfaceC1339a {
        /* JADX INFO: renamed from: a */
        void mo7443a(int i, int i2, String str);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.KCalendar$b */
    public interface InterfaceC1340b {
        /* JADX INFO: renamed from: a */
        void mo7444a(int i, int i2);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.KCalendar$c */
    public interface InterfaceC1341c {
        /* JADX INFO: renamed from: a */
        void mo7445a();

        /* JADX INFO: renamed from: b */
        void mo7446b();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void setClickableDay(String[] strArr) {
    }

    public KCalendar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8390m = 6;
        this.f8391n = 7;
        this.f8392o = (String[][]) Array.newInstance((Class<?>) String.class, 6, 7);
        this.f8396s = new String[]{C1914mm.m10557b(R.string.sunday), C1914mm.m10557b(R.string.monday), C1914mm.m10557b(R.string.tuesday), C1914mm.m10557b(R.string.wednesday), C1914mm.m10557b(R.string.thursday), C1914mm.m10557b(R.string.firday), C1914mm.m10557b(R.string.saturday)};
        this.f8399v = new Date();
        this.f8382A = new HashMap();
        this.f8383B = new HashMap();
        m8160d();
    }

    public KCalendar(Context context) {
        super(context);
        this.f8390m = 6;
        this.f8391n = 7;
        this.f8392o = (String[][]) Array.newInstance((Class<?>) String.class, 6, 7);
        this.f8396s = new String[]{C1914mm.m10557b(R.string.sunday), C1914mm.m10557b(R.string.monday), C1914mm.m10557b(R.string.tuesday), C1914mm.m10557b(R.string.wednesday), C1914mm.m10557b(R.string.thursday), C1914mm.m10557b(R.string.firday), C1914mm.m10557b(R.string.saturday)};
        this.f8399v = new Date();
        this.f8382A = new HashMap();
        this.f8383B = new HashMap();
        m8160d();
    }

    /* JADX INFO: renamed from: d */
    private void m8160d() {
        setBackgroundColor(f8381g);
        this.f8385h = new GestureDetector(this);
        this.f8386i = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_in);
        this.f8387j = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_out);
        this.f8388k = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_in);
        this.f8389l = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_out);
        this.f8386i.setDuration(400L);
        this.f8387j.setDuration(400L);
        this.f8388k.setDuration(400L);
        this.f8389l.setDuration(400L);
        this.f8401x = new LinearLayout(getContext());
        this.f8401x.setOrientation(1);
        this.f8401x.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f8402y = new LinearLayout(getContext());
        this.f8402y.setOrientation(1);
        this.f8402y.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f8403z = this.f8401x;
        addView(this.f8401x);
        addView(this.f8402y);
        m8154a(this.f8401x);
        m8154a(this.f8402y);
        this.f8397t = this.f8399v.getYear() + 1900;
        this.f8398u = this.f8399v.getMonth();
        this.f8400w = new Date(this.f8397t - 1900, this.f8398u, 1);
        m8161e();
    }

    /* JADX INFO: renamed from: a */
    private void m8154a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setBackgroundColor(f8375a);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        this.f8393p = getResources().getDimension(R.dimen.historyscore_tb);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout.addView(linearLayout2);
        for (int i = 0; i < this.f8391n; i++) {
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setText(this.f8396s[i]);
            textView.setTextColor(f8376b);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            textView.setTextSize(12.0f);
            linearLayout2.addView(textView);
        }
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        view.setBackgroundColor(Color.parseColor("#667c7b80"));
        linearLayout.addView(view);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 7.0f));
        linearLayout.addView(linearLayout3);
        for (int i2 = 0; i2 < this.f8390m; i2++) {
            LinearLayout linearLayout4 = new LinearLayout(getContext());
            linearLayout4.setOrientation(0);
            linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            linearLayout3.addView(linearLayout4);
            for (int i3 = 0; i3 < this.f8391n; i3++) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                relativeLayout.setBackgroundColor(f8381g);
                linearLayout4.addView(relativeLayout);
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.widget.KCalendar.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ViewGroup viewGroup = (ViewGroup) view2.getParent();
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                i5 = 0;
                                break;
                            } else if (view2.equals(viewGroup.getChildAt(i5))) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= viewGroup2.getChildCount()) {
                                break;
                            }
                            if (viewGroup.equals(viewGroup2.getChildAt(i6))) {
                                i4 = i6;
                                break;
                            }
                            i6++;
                        }
                        if (KCalendar.this.f8394q != null) {
                            KCalendar.this.f8394q.mo7443a(i4, i5, KCalendar.this.f8392o[i4][i5]);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m8161e() {
        TextView textView;
        int year;
        TextView textView2;
        int day = this.f8400w.getDay();
        int iM8156b = m8156b(this.f8400w.getYear(), this.f8400w.getMonth());
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        while (i3 < this.f8390m) {
            int i6 = i5;
            int i7 = i4;
            int i8 = 0;
            while (i8 < this.f8391n) {
                int month = 11;
                int i9 = -2;
                int i10 = 17;
                if (i3 == 0 && i8 == 0 && day != 0) {
                    if (this.f8400w.getMonth() == 0) {
                        year = this.f8400w.getYear() - i;
                    } else {
                        year = this.f8400w.getYear();
                        month = this.f8400w.getMonth() - i;
                    }
                    int iM8156b2 = (m8156b(year, month) - day) + i;
                    int i11 = 0;
                    while (i11 < day) {
                        int i12 = iM8156b2 + i11;
                        RelativeLayout relativeLayoutM8158c = m8158c(i2, i11);
                        relativeLayoutM8158c.setGravity(i10);
                        if (relativeLayoutM8158c.getChildCount() > 0) {
                            textView2 = (TextView) relativeLayoutM8158c.getChildAt(i2);
                        } else {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i9, i9);
                            textView2 = new TextView(getContext());
                            textView2.setLayoutParams(layoutParams);
                            textView2.setGravity(i10);
                            relativeLayoutM8158c.addView(textView2);
                        }
                        textView2.setTextSize(14.0f);
                        textView2.setText(Integer.toString(i12));
                        textView2.setTextColor(f8378d);
                        textView2.setVisibility(4);
                        this.f8392o[0][i11] = m8153a(new Date(year, month, i12));
                        if (this.f8383B.get(this.f8392o[0][i11]) == null) {
                            textView2.setBackgroundColor(0);
                        }
                        m8155a(relativeLayoutM8158c, 0, i11);
                        i11++;
                        i2 = 0;
                        i9 = -2;
                        i10 = 17;
                    }
                    i8 = day - 1;
                } else {
                    RelativeLayout relativeLayoutM8158c2 = m8158c(i3, i8);
                    relativeLayoutM8158c2.setGravity(17);
                    if (relativeLayoutM8158c2.getChildCount() > 0) {
                        textView = (TextView) relativeLayoutM8158c2.getChildAt(0);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        textView = new TextView(getContext());
                        textView.setLayoutParams(layoutParams2);
                        textView.setGravity(17);
                        relativeLayoutM8158c2.addView(textView);
                    }
                    if (i7 <= iM8156b) {
                        this.f8392o[i3][i8] = m8153a(new Date(this.f8400w.getYear(), this.f8400w.getMonth(), i7));
                        textView.setText(Integer.toString(i7));
                        textView.setVisibility(0);
                        if (this.f8399v.getDate() == i7 && this.f8399v.getMonth() == this.f8400w.getMonth() && this.f8399v.getYear() == this.f8400w.getYear()) {
                            textView.setText(C1914mm.m10557b(R.string.today));
                            textView.setTextSize(0, C1914mm.m10554a().getResources().getDimension(R.dimen.train_his_today_size));
                            textView.setTextColor(f8376b);
                            textView.setBackgroundColor(0);
                        } else {
                            textView.setTextSize(14.0f);
                            textView.setTextColor(f8377c);
                            textView.setBackgroundColor(0);
                        }
                        m8155a(relativeLayoutM8158c2, i3, i8);
                        if (this.f8383B.get(this.f8392o[i3][i8]) != null) {
                            textView.setTextColor(-1);
                            textView.setBackgroundResource(this.f8383B.get(this.f8392o[i3][i8]).intValue());
                        }
                        i7++;
                    } else {
                        if (this.f8400w.getMonth() == 11) {
                            this.f8392o[i3][i8] = m8153a(new Date(this.f8400w.getYear() + 1, 0, i6));
                        } else {
                            this.f8392o[i3][i8] = m8153a(new Date(this.f8400w.getYear(), this.f8400w.getMonth() + 1, i6));
                        }
                        textView.setTextSize(14.0f);
                        textView.setText(Integer.toString(i6));
                        textView.setTextColor(f8378d);
                        textView.setVisibility(4);
                        if (this.f8383B.get(this.f8392o[i3][i8]) != null) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            textView.setBackgroundColor(0);
                        }
                        m8155a(relativeLayoutM8158c2, i3, i8);
                        i6++;
                        i = 1;
                        i8 += i;
                    }
                }
                i = 1;
                i2 = 0;
                i8 += i;
            }
            i3++;
            i4 = i7;
            i5 = i6;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8163a(int i, int i2) {
        this.f8397t = i;
        this.f8398u = i2 - 1;
        this.f8400w = new Date(this.f8397t - 1900, this.f8398u, 1);
        m8161e();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m8162a() {
        if (this.f8403z == this.f8401x) {
            this.f8403z = this.f8402y;
        } else {
            this.f8403z = this.f8401x;
        }
        setInAnimation(this.f8386i);
        setOutAnimation(this.f8387j);
        if (this.f8398u == 11) {
            this.f8397t++;
            this.f8398u = 0;
        } else {
            this.f8398u++;
        }
        this.f8400w = new Date(this.f8397t - 1900, this.f8398u, 1);
        m8161e();
        showNext();
        if (this.f8395r != null) {
            this.f8395r.mo7444a(this.f8397t, this.f8398u + 1);
        }
        if (this.f8384C != null) {
            this.f8384C.mo7445a();
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m8165b() {
        if (this.f8403z == this.f8401x) {
            this.f8403z = this.f8402y;
        } else {
            this.f8403z = this.f8401x;
        }
        setInAnimation(this.f8388k);
        setOutAnimation(this.f8389l);
        if (this.f8398u == 0) {
            this.f8397t--;
            this.f8398u = 11;
        } else {
            this.f8398u--;
        }
        this.f8400w = new Date(this.f8397t - 1900, this.f8398u, 1);
        m8161e();
        showPrevious();
        if (this.f8395r != null) {
            this.f8395r.mo7444a(this.f8397t, this.f8398u + 1);
        }
        if (this.f8384C != null) {
            this.f8384C.mo7446b();
        }
    }

    public int getCalendarYear() {
        return this.f8400w.getYear() + 1900;
    }

    public int getCalendarMonth() {
        return this.f8400w.getMonth() + 1;
    }

    /* JADX INFO: renamed from: a */
    public void m8164a(List<String> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f8382A.put(list.get(i2), Integer.valueOf(i));
        }
        m8161e();
    }

    public void setCalendarDayBgColor(Date date, int i) {
        setCalendarDayBgColor(m8153a(date), i);
    }

    public void setCalendarDayBgColor(String str, int i) {
        this.f8383B.put(str, Integer.valueOf(i));
        m8161e();
    }

    public void setCalendarDaysBgColor(List<String> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f8383B.put(list.get(i2), Integer.valueOf(i));
        }
        m8161e();
    }

    public void setCalendarDayBgColor(String[] strArr, int i) {
        for (String str : strArr) {
            this.f8383B.put(str, Integer.valueOf(i));
        }
        m8161e();
    }

    /* JADX INFO: renamed from: c */
    public void m8166c() {
        this.f8383B.clear();
        m8161e();
    }

    /* JADX INFO: renamed from: a */
    private void m8155a(RelativeLayout relativeLayout, int i, int i2) {
        TextView textView;
        if (relativeLayout.getChildCount() > 0) {
            textView = (TextView) relativeLayout.getChildAt(0);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            TextView textView2 = new TextView(getContext());
            textView2.setLayoutParams(layoutParams);
            textView2.setGravity(17);
            relativeLayout.addView(textView2);
            textView = textView2;
        }
        int childCount = relativeLayout.getChildCount();
        if (this.f8382A.get(this.f8392o[i][i2]) == null) {
            if (childCount > 1) {
                relativeLayout.removeView(relativeLayout.getChildAt(1));
            }
        } else if (childCount < 2) {
            textView.setTextColor(-1);
            textView.setBackgroundResource(this.f8382A.get(this.f8392o[i][i2]).intValue());
        }
    }

    /* JADX INFO: renamed from: b */
    private int m8156b(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, i + 1900);
        calendar.set(2, i2);
        return calendar.getActualMaximum(5);
    }

    /* JADX INFO: renamed from: c */
    private RelativeLayout m8158c(int i, int i2) {
        return (RelativeLayout) ((LinearLayout) ((LinearLayout) this.f8403z.getChildAt(2)).getChildAt(i)).getChildAt(i2);
    }

    /* JADX INFO: renamed from: a */
    private String m8153a(Date date) {
        return m8159d(date.getYear() + 1900, 4) + "-" + m8159d(date.getMonth() + 1, 2) + "-" + m8159d(date.getDate(), 2);
    }

    /* JADX INFO: renamed from: d */
    private static String m8159d(int i, int i2) {
        if (i2 == 2) {
            if (i < 10) {
                return "0" + i;
            }
        } else if (i2 == 4) {
            if (i < 10) {
                return "000" + i;
            }
            if (i < 100 && i > 10) {
                return "00" + i;
            }
            if (i < 1000 && i > 100) {
                return "0" + i;
            }
        }
        return "" + i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f8385h == null || !this.f8385h.onTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f8385h.onTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent.getX() - motionEvent2.getX() > 20.0f) {
            m8162a();
            return false;
        }
        if (motionEvent.getX() - motionEvent2.getX() >= -20.0f) {
            return false;
        }
        m8165b();
        return false;
    }

    public InterfaceC1339a getOnCalendarClickListener() {
        return this.f8394q;
    }

    public void setOnCalendarClickListener(InterfaceC1339a interfaceC1339a) {
        this.f8394q = interfaceC1339a;
    }

    public InterfaceC1340b getOnCalendarDateChangedListener() {
        return this.f8395r;
    }

    public void setOnCalendarDateChangedListener(InterfaceC1340b interfaceC1340b) {
        this.f8395r = interfaceC1340b;
    }

    public Date getThisday() {
        return this.f8399v;
    }

    public void setThisday(Date date) {
        this.f8399v = date;
    }

    public Map<String, Integer> getDayBgColorMap() {
        return this.f8383B;
    }

    public void setDayBgColorMap(Map<String, Integer> map) {
        this.f8383B = map;
    }

    public void setOnMonthChangeListener(InterfaceC1341c interfaceC1341c) {
        this.f8384C = interfaceC1341c;
    }
}
