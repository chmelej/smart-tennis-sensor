package cn.smssdk.gui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.layout.ContactListPageLayout;
import cn.smssdk.gui.layout.Res;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ContactsPage extends FakeActivity implements TextWatcher, View.OnClickListener {
    private ContactsAdapter adapter;
    private ArrayList<HashMap<String, Object>> contactsInMobile;
    private EditText etSearch;
    private ArrayList<HashMap<String, Object>> friendsInApp;
    private EventHandler handler;
    private ContactItemMaker itemMaker;
    private ContactsListView listView;

    /* JADX INFO: renamed from: pd */
    private Dialog f6064pd;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        if (this.f6064pd != null && this.f6064pd.isShowing()) {
            this.f6064pd.dismiss();
        }
        this.f6064pd = CommonDialog.ProgressDialog(this.activity);
        if (this.f6064pd != null) {
            this.f6064pd.show();
        }
        SearchEngine.prepare(this.activity, new Runnable() { // from class: cn.smssdk.gui.ContactsPage.1
            @Override // java.lang.Runnable
            public void run() {
                ContactsPage.this.afterPrepare();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterPrepare() {
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.2
            @Override // java.lang.Runnable
            public void run() {
                ContactsPage.this.friendsInApp = new ArrayList();
                ContactsPage.this.contactsInMobile = new ArrayList();
                LinearLayout layout = new ContactListPageLayout(ContactsPage.this.activity).getLayout();
                if (layout != null) {
                    ContactsPage.this.activity.setContentView(layout);
                    ContactsPage.this.initView();
                    ContactsPage.this.initData();
                }
            }
        });
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    public void show(Context context) {
        show(context, new DefaultContactViewItem());
    }

    public void show(Context context, ContactItemMaker contactItemMaker) {
        this.itemMaker = contactItemMaker;
        super.show(context, (Intent) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.listView = (ContactsListView) this.activity.findViewById(Res.C0975id.clContact);
        this.activity.findViewById(Res.C0975id.ll_back).setOnClickListener(this);
        this.activity.findViewById(Res.C0975id.ivSearch).setOnClickListener(this);
        this.activity.findViewById(Res.C0975id.iv_clear).setOnClickListener(this);
        TextView textView = (TextView) this.activity.findViewById(Res.C0975id.tv_title);
        int stringRes = C1583R.getStringRes(this.activity, "smssdk_search_contact");
        if (stringRes > 0) {
            textView.setText(stringRes);
        }
        this.etSearch = (EditText) this.activity.findViewById(Res.C0975id.et_put_identify);
        this.etSearch.addTextChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.handler = new EventHandler() { // from class: cn.smssdk.gui.ContactsPage.3
            @Override // cn.smssdk.EventHandler
            public void afterEvent(int i, int i2, Object obj) {
                if (i2 != -1) {
                    ContactsPage.this.runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ContactsPage.this.f6064pd != null && ContactsPage.this.f6064pd.isShowing()) {
                                ContactsPage.this.f6064pd.dismiss();
                            }
                            int stringRes = C1583R.getStringRes(ContactsPage.this.activity, "smssdk_network_error");
                            if (stringRes > 0) {
                                Toast.makeText(ContactsPage.this.activity, stringRes, 0).show();
                            }
                        }
                    });
                    return;
                }
                if (i != 4) {
                    if (i == 6) {
                        ContactsPage.this.friendsInApp = (ArrayList) obj;
                        SMSSDK.getContacts(false);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList == null) {
                    ContactsPage.this.contactsInMobile = new ArrayList();
                } else {
                    ContactsPage.this.contactsInMobile = (ArrayList) arrayList.clone();
                }
                ContactsPage.this.refreshContactList();
            }
        };
        SMSSDK.registerEventHandler(this.handler);
        if (this.friendsInApp != null && this.friendsInApp.size() > 0) {
            SMSSDK.getContacts(false);
        } else {
            SMSSDK.getFriendsInApp();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (keyEvent.getAction() == 0 && this.activity.findViewById(Res.C0975id.llSearch).getVisibility() == 0) {
                    this.activity.findViewById(Res.C0975id.llSearch).setVisibility(8);
                    this.activity.findViewById(Res.C0975id.llTitle).setVisibility(0);
                    this.etSearch.setText("");
                    return true;
                }
            } catch (Exception e) {
                SMSLog.getInstance().m8622w(e);
            }
        }
        return super.onKeyEvent(i, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        SMSSDK.unregisterEventHandler(this.handler);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.adapter != null) {
            this.adapter.search(charSequence.toString());
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            finish();
            return;
        }
        if (id != 117506052) {
            if (id == 117571589) {
                this.etSearch.getText().clear();
            }
        } else {
            this.activity.findViewById(Res.C0975id.llTitle).setVisibility(8);
            this.activity.findViewById(Res.C0975id.llSearch).setVisibility(0);
            this.etSearch.requestFocus();
            this.etSearch.getText().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshContactList() {
        ArrayList<HashMap> arrayList;
        boolean z;
        ArrayList<ContactEntry> arrayList2 = new ArrayList();
        for (HashMap<String, Object> map : this.contactsInMobile) {
            ArrayList arrayList3 = (ArrayList) map.get("phones");
            if (arrayList3 != null && arrayList3.size() > 0) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ContactEntry((String) ((HashMap) it.next()).get("phone"), map));
                }
            }
        }
        ArrayList<HashMap<String, Object>> arrayList4 = new ArrayList<>();
        int size = arrayList2.size();
        Iterator<HashMap<String, Object>> it2 = this.friendsInApp.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HashMap<String, Object> next = it2.next();
            String strValueOf = String.valueOf(next.get("phone"));
            if (strValueOf != null) {
                for (int i = 0; i < size; i++) {
                    ContactEntry contactEntry = (ContactEntry) arrayList2.get(i);
                    if (strValueOf.equals(contactEntry.getKey())) {
                        next.put("contact", contactEntry.getValue());
                        next.put("fia", true);
                        arrayList4.add((HashMap) next.clone());
                    }
                }
            }
        }
        this.friendsInApp = arrayList4;
        HashSet hashSet = new HashSet();
        for (ContactEntry contactEntry2 : arrayList2) {
            String key = contactEntry2.getKey();
            HashMap<String, Object> value = contactEntry2.getValue();
            if (key != null && value != null) {
                Iterator<HashMap<String, Object>> it3 = this.friendsInApp.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (key.equals(String.valueOf(it3.next().get("phone")))) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    hashSet.add(value);
                }
            }
        }
        this.contactsInMobile.clear();
        this.contactsInMobile.addAll(hashSet);
        for (HashMap<String, Object> map2 : this.friendsInApp) {
            HashMap map3 = (HashMap) map2.remove("contact");
            if (map3 != null) {
                String strValueOf2 = String.valueOf(map2.get("phone"));
                if (strValueOf2 != null && (arrayList = (ArrayList) map3.get("phones")) != null && arrayList.size() > 0) {
                    ArrayList arrayList5 = new ArrayList();
                    for (HashMap map4 : arrayList) {
                        if (!strValueOf2.equals((String) map4.get("phone"))) {
                            arrayList5.add(map4);
                        }
                    }
                    map3.put("phones", arrayList5);
                }
                map2.put("displayname", map3.get("displayname"));
            }
        }
        runOnUIThread(new Runnable() { // from class: cn.smssdk.gui.ContactsPage.4
            @Override // java.lang.Runnable
            public void run() {
                if (ContactsPage.this.f6064pd != null && ContactsPage.this.f6064pd.isShowing()) {
                    ContactsPage.this.f6064pd.dismiss();
                }
                ContactsPage.this.adapter = new ContactsAdapter(ContactsPage.this.listView, ContactsPage.this.friendsInApp, ContactsPage.this.contactsInMobile);
                ContactsPage.this.adapter.setContactItemMaker(ContactsPage.this.itemMaker);
                ContactsPage.this.listView.setAdapter(ContactsPage.this.adapter);
            }
        });
    }
}
