package cn.smssdk.gui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.gui.layout.ContactsListviewItemLayout;
import cn.smssdk.gui.layout.Res;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class DefaultContactViewItem implements ContactItemMaker {
    @Override // cn.smssdk.gui.ContactItemMaker
    public View getView(final HashMap<String, Object> map, View view, final ViewGroup viewGroup) {
        View viewCreate;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            viewCreate = ContactsListviewItemLayout.create(viewGroup.getContext());
            viewHolder.ivContact = (AsyncImageView) viewCreate.findViewById(Res.C0975id.iv_contact);
            viewHolder.tvName = (TextView) viewCreate.findViewById(Res.C0975id.tv_name);
            viewHolder.tvContact = (TextView) viewCreate.findViewById(Res.C0975id.tv_contact);
            viewHolder.btnAdd = (Button) viewCreate.findViewById(Res.C0975id.btn_add);
            viewHolder.f6067bg = viewCreate.findViewById(Res.C0975id.rl_lv_item_bg);
            viewCreate.setTag(viewHolder);
        } else {
            viewCreate = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (map != null) {
            if (map.containsKey("fia")) {
                viewHolder.tvName.setText(String.valueOf(map.get("nickname")));
                viewHolder.tvContact.setVisibility(0);
                String str = (String) map.get("displayname");
                if (TextUtils.isEmpty(str)) {
                    viewHolder.tvContact.setText(String.valueOf(map.get("phone")));
                } else {
                    viewHolder.tvContact.setText(str);
                }
                int stringRes = C1583R.getStringRes(viewGroup.getContext(), "smssdk_add_contact");
                if (stringRes > 0) {
                    viewHolder.btnAdd.setText(stringRes);
                }
            } else {
                String str2 = (String) map.get("displayname");
                if (TextUtils.isEmpty(str2)) {
                    ArrayList arrayList = (ArrayList) map.get("phones");
                    if (arrayList != null && arrayList.size() > 0) {
                        viewHolder.tvName.setText((String) ((HashMap) arrayList.get(0)).get("phone"));
                    }
                } else {
                    viewHolder.tvName.setText(str2);
                }
                viewHolder.tvContact.setVisibility(8);
                int stringRes2 = C1583R.getStringRes(viewGroup.getContext(), "smssdk_invite");
                if (stringRes2 > 0) {
                    viewHolder.btnAdd.setText(stringRes2);
                }
            }
            viewHolder.f6067bg.setBackgroundColor(-1);
            if (map.containsKey("isnew") && Boolean.valueOf(String.valueOf(map.get("isnew"))).booleanValue()) {
                viewHolder.f6067bg.setBackgroundColor(-525057);
            }
            String str3 = map.containsKey("avatar") ? (String) map.get("avatar") : null;
            int bitmapRes = C1583R.getBitmapRes(viewGroup.getContext(), "smssdk_cp_default_avatar");
            if (bitmapRes > 0) {
                viewHolder.ivContact.execute((String) null, bitmapRes);
            }
            if (!TextUtils.isEmpty(str3)) {
                Log.w(String.valueOf(map.get("displayname")) + " icon url ==>> ", str3);
                Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(str3);
                if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
                    viewHolder.ivContact.setImageBitmap(bitmapFromCache);
                } else {
                    viewHolder.ivContact.execute(str3, bitmapRes);
                }
            }
            viewHolder.btnAdd.setOnClickListener(new View.OnClickListener() { // from class: cn.smssdk.gui.DefaultContactViewItem.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (map.containsKey("fia")) {
                        Toast.makeText(viewGroup.getContext(), String.valueOf(map), 0).show();
                        return;
                    }
                    ContactDetailPage contactDetailPage = new ContactDetailPage();
                    contactDetailPage.setContact(map);
                    contactDetailPage.show(viewGroup.getContext(), null);
                }
            });
        }
        return viewCreate;
    }

    public class ViewHolder {

        /* JADX INFO: renamed from: bg */
        public View f6067bg;
        public Button btnAdd;
        public AsyncImageView ivContact;
        public TextView tvContact;
        public TextView tvName;

        public ViewHolder() {
        }
    }
}
