package cn.smssdk.gui.layout;

import android.content.Context;
import android.widget.LinearLayout;
import cn.smssdk.gui.ContactsListView;
import cn.smssdk.gui.layout.Res;

/* JADX INFO: loaded from: classes.dex */
public class ContactListPageLayout extends BasePageLayout {
    public ContactListPageLayout(Context context) {
        super(context, true);
    }

    @Override // cn.smssdk.gui.layout.BasePageLayout
    protected void onCreateContent(LinearLayout linearLayout) {
        ContactsListView contactsListView = new ContactsListView(this.context);
        contactsListView.setId(Res.C0975id.clContact);
        contactsListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        linearLayout.addView(contactsListView);
    }
}
