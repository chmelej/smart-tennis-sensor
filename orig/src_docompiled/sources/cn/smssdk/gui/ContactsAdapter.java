package cn.smssdk.gui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.smssdk.gui.ContactsListView;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.gui.layout.SizeHelper;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ContactsAdapter extends ContactsListView.GroupAdapter {
    private ArrayList<ArrayList<HashMap<String, Object>>> contacts;
    private ArrayList<HashMap<String, Object>> contactsOutApp;
    private ArrayList<HashMap<String, Object>> friendsInApp;
    private ContactItemMaker itemMaker;
    private SearchEngine sEngine;
    private ArrayList<String> titles;

    public ContactsAdapter(ContactsListView contactsListView, ArrayList<HashMap<String, Object>> arrayList, ArrayList<HashMap<String, Object>> arrayList2) {
        super(contactsListView);
        this.friendsInApp = new ArrayList<>();
        this.contactsOutApp = new ArrayList<>();
        this.friendsInApp = arrayList;
        this.contactsOutApp = arrayList2;
        initSearchEngine();
        search(null);
    }

    private void initSearchEngine() {
        this.sEngine = new SearchEngine();
        ArrayList<String> arrayList = new ArrayList<>();
        for (HashMap<String, Object> map : this.friendsInApp) {
            String strValueOf = map.containsKey("displayname") ? String.valueOf(map.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf)) {
                arrayList.add(strValueOf);
            }
        }
        for (HashMap<String, Object> map2 : this.contactsOutApp) {
            String strValueOf2 = map2.containsKey("displayname") ? String.valueOf(map2.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf2)) {
                arrayList.add(strValueOf2);
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
        HashMap<String, String> map = new HashMap<>();
        for (String str2 : arrayListMatch) {
            map.put(str2, str2);
        }
        this.titles = new ArrayList<>();
        this.contacts = new ArrayList<>();
        if (this.friendsInApp.size() > 0) {
            reSortFia(map, z, this.friendsInApp);
        }
        if (this.contactsOutApp.size() > 0) {
            reSortFoa(map, z, this.contactsOutApp);
        }
    }

    private void reSortFia(HashMap<String, String> map, boolean z, ArrayList<HashMap<String, Object>> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
        for (HashMap<String, Object> map2 : arrayList) {
            String strValueOf = map2.containsKey("displayname") ? String.valueOf(map2.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf) && (z || map.containsKey(strValueOf))) {
                arrayList2.add(map2);
            }
        }
        if (arrayList2.size() > 0) {
            int stringRes = C1583R.getStringRes(this.view.getContext(), "smssdk_contacts_in_app");
            if (stringRes > 0) {
                this.titles.add(this.view.getContext().getResources().getString(stringRes));
            }
            this.contacts.add(arrayList2);
        }
    }

    private void reSortFoa(HashMap<String, String> map, boolean z, ArrayList<HashMap<String, Object>> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
        for (HashMap<String, Object> map2 : arrayList) {
            String strValueOf = map2.containsKey("displayname") ? String.valueOf(map2.get("displayname")) : "";
            if (!TextUtils.isEmpty(strValueOf) && (z || map.containsKey(strValueOf))) {
                arrayList2.add(map2);
            }
        }
        if (arrayList2.size() > 0) {
            int stringRes = C1583R.getStringRes(this.view.getContext(), "smssdk_contacts_out_app");
            if (stringRes > 0) {
                this.titles.add(this.view.getContext().getResources().getString(stringRes));
            }
            this.contacts.add(arrayList2);
        }
    }

    public void setContactItemMaker(ContactItemMaker contactItemMaker) {
        this.itemMaker = contactItemMaker;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public int getGroupCount() {
        if (this.titles == null) {
            return 0;
        }
        return this.titles.size();
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public int getCount(int i) {
        ArrayList<HashMap<String, Object>> arrayList;
        if (this.contacts == null || (arrayList = this.contacts.get(i)) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public String getGroupTitle(int i) {
        if (this.titles.size() > 0) {
            return this.titles.get(i).toString();
        }
        return null;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public HashMap<String, Object> getItem(int i, int i2) {
        if (this.contacts.size() > 0) {
            return this.contacts.get(i).get(i2);
        }
        return null;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public TextView getTitleView(int i, TextView textView, ViewGroup viewGroup) {
        if (textView == null) {
            SizeHelper.prepare(viewGroup.getContext());
            textView = new TextView(viewGroup.getContext());
            textView.setBackgroundColor(-1382162);
            textView.setTextSize(0, SizeHelper.fromPxWidth(25));
            textView.setTextColor(Res.color.smssdk_lv_title_color);
            textView.setPadding(SizeHelper.fromPxWidth(18), 0, 0, 0);
            textView.setWidth(-1);
            textView.setHeight(SizeHelper.fromPxWidth(40));
            textView.setGravity(16);
        }
        String groupTitle = getGroupTitle(i);
        if (!TextUtils.isEmpty(groupTitle)) {
            textView.setText(groupTitle);
        }
        return textView;
    }

    @Override // cn.smssdk.gui.ContactsListView.GroupAdapter
    public View getView(int i, int i2, View view, ViewGroup viewGroup) {
        return this.itemMaker.getView(getItem(i, i2), view, viewGroup);
    }
}
