package cn.smssdk.gui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.smssdk.gui.layout.ContactDetailPageLayout;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailPage extends FakeActivity implements View.OnClickListener {
    private String phoneName = "";
    private ArrayList<String> phoneList = new ArrayList<>();

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        LinearLayout layout = new ContactDetailPageLayout(this.activity).getLayout();
        if (layout != null) {
            this.activity.setContentView(layout);
            this.activity.findViewById(Res.C0975id.ll_back).setOnClickListener(this);
            ((TextView) this.activity.findViewById(Res.C0975id.tv_title)).setText(C1583R.getStringRes(this.activity, "smssdk_contacts_detail"));
            ((TextView) this.activity.findViewById(Res.C0975id.tv_contact_name)).setText(this.phoneName);
            TextView textView = (TextView) this.activity.findViewById(Res.C0975id.tv_contact_phones);
            StringBuilder sb = new StringBuilder();
            for (String str : this.phoneList) {
                sb.append("\n");
                sb.append(str);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
                textView.setText(sb.toString());
            }
            ((TextView) this.activity.findViewById(Res.C0975id.tv_invite_hint)).setText(Html.fromHtml(getContext().getResources().getString(C1583R.getStringRes(this.activity, "smssdk_not_invite"), this.phoneName)));
            this.activity.findViewById(Res.C0975id.btn_invite).setOnClickListener(this);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
    }

    public void setContact(HashMap<String, Object> map) {
        ArrayList arrayList;
        if (map.containsKey("displayname")) {
            this.phoneName = String.valueOf(map.get("displayname"));
        } else if (map.containsKey("phones") && (arrayList = (ArrayList) map.get("phones")) != null && arrayList.size() > 0) {
            this.phoneName = (String) ((HashMap) arrayList.get(0)).get("phone");
        }
        ArrayList arrayList2 = (ArrayList) map.get("phones");
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.phoneList.add((String) ((HashMap) it.next()).get("phone"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 117506049) {
            finish();
        } else if (id == 1881145355) {
            if (this.phoneList.size() > 1) {
                showDialog();
            } else {
                sendMsg(this.phoneList.size() > 0 ? this.phoneList.get(0) : "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        int stringRes = C1583R.getStringRes(this.activity, "smssdk_invite_content");
        if (stringRes > 0) {
            intent.putExtra("sms_body", this.activity.getString(stringRes));
        }
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void showDialog() {
        String[] strArr = (String[]) this.phoneList.toArray(new String[this.phoneList.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        int stringRes = C1583R.getStringRes(this.activity, "smssdk_invite_content");
        if (stringRes > 0) {
            builder.setTitle(stringRes);
        }
        builder.setCancelable(true);
        int stringRes2 = C1583R.getStringRes(this.activity, "smssdk_cancel");
        if (stringRes2 > 0) {
            builder.setNegativeButton(stringRes2, new DialogInterface.OnClickListener() { // from class: cn.smssdk.gui.ContactDetailPage.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: cn.smssdk.gui.ContactDetailPage.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ContactDetailPage.this.sendMsg((String) ContactDetailPage.this.phoneList.get(i));
            }
        });
        builder.create().show();
    }
}
