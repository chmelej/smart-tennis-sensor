package cn.smssdk.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.GroupListView;
import cn.smssdk.gui.layout.SizeHelper;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CountryAdapter extends GroupListView.GroupAdapter {
    private ArrayList<ArrayList<String[]>> countries;
    private HashMap<Character, ArrayList<String[]>> rawData;
    private SearchEngine sEngine;
    private ArrayList<String> titles;

    public CountryAdapter(GroupListView groupListView) {
        super(groupListView);
        this.rawData = SMSSDK.getGroupedCountryList();
        initSearchEngine();
        search(null);
    }

    private void initSearchEngine() {
        this.sEngine = new SearchEngine();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<Character, ArrayList<String[]>>> it = this.rawData.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<String[]> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next()[0]);
            }
        }
        this.sEngine.setIndex(arrayList);
    }

    public void search(String str) {
        boolean z;
        ArrayList<String> arrayListMatch = this.sEngine.match(str);
        if (arrayListMatch == null || arrayListMatch.size() <= 0) {
            arrayListMatch = new ArrayList<>();
            z = true;
        } else {
            z = false;
        }
        HashMap map = new HashMap();
        for (String str2 : arrayListMatch) {
            map.put(str2, str2);
        }
        this.titles = new ArrayList<>();
        this.countries = new ArrayList<>();
        for (Map.Entry<Character, ArrayList<String[]>> entry : this.rawData.entrySet()) {
            ArrayList<String[]> value = entry.getValue();
            ArrayList<String[]> arrayList = new ArrayList<>();
            for (String[] strArr : value) {
                if (z || map.containsKey(strArr[0])) {
                    arrayList.add(strArr);
                }
            }
            if (arrayList.size() > 0) {
                this.titles.add(String.valueOf(entry.getKey()));
                this.countries.add(arrayList);
            }
        }
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public int getGroupCount() {
        if (this.titles == null) {
            return 0;
        }
        return this.titles.size();
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public int getCount(int i) {
        ArrayList<String[]> arrayList;
        if (this.countries == null || (arrayList = this.countries.get(i)) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public String getGroupTitle(int i) {
        if (this.titles.size() != 0) {
            return this.titles.get(i).toString();
        }
        return null;
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public String[] getItem(int i, int i2) {
        if (this.countries.size() == 0) {
            return null;
        }
        try {
            return this.countries.get(i).get(i2);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return null;
        }
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public View getTitleView(int i, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            SizeHelper.prepare(viewGroup.getContext());
            TextView textView = new TextView(viewGroup.getContext());
            textView.setTextSize(0, SizeHelper.fromPxWidth(16));
            int colorRes = C1583R.getColorRes(viewGroup.getContext(), "smssdk_lv_title_color");
            if (colorRes > 0) {
                textView.setTextColor(viewGroup.getContext().getResources().getColor(colorRes));
            }
            int iFromPxWidth = SizeHelper.fromPxWidth(14);
            textView.setPadding(0, iFromPxWidth, 0, iFromPxWidth);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(textView);
            View view3 = new View(viewGroup.getContext());
            view3.setBackgroundColor(-1842205);
            linearLayout.addView(view3, new LinearLayout.LayoutParams(-1, 1));
            view2 = linearLayout;
        }
        ((TextView) ((LinearLayout) view2).getChildAt(0)).setText(getGroupTitle(i));
        return view2;
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public void onGroupChange(View view, String str) {
        ((TextView) ((LinearLayout) view).getChildAt(0)).setText(str);
    }

    @Override // cn.smssdk.gui.GroupListView.GroupAdapter
    public View getView(int i, int i2, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setBackgroundColor(-1);
            SizeHelper.prepare(viewGroup.getContext());
            TextView textView = new TextView(viewGroup.getContext());
            int colorRes = C1583R.getColorRes(viewGroup.getContext(), "smssdk_lv_tv_color");
            if (colorRes > 0) {
                textView.setTextColor(viewGroup.getContext().getResources().getColor(colorRes));
            }
            textView.setTextSize(0, SizeHelper.fromPxWidth(24));
            int iFromPxWidth = SizeHelper.fromPxWidth(30);
            textView.setPadding(0, iFromPxWidth, 0, iFromPxWidth);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            view2 = linearLayout;
        }
        String[] item = getItem(i, i2);
        if (item != null) {
            ((TextView) ((LinearLayout) view2).getChildAt(0)).setText(item[0]);
        }
        return view2;
    }
}
