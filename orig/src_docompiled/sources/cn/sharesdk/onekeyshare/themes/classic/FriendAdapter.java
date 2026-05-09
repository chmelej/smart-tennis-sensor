package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    private FriendListPage activity;
    private int curPage;
    private ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount;
    private Platform platform;
    private float ratio;

    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public long getItemId(int i) {
        return i;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.pageCount = 15;
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap<>();
        this.follows = new ArrayList<>();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    public void setRatio(float f) {
        this.ratio = f;
        ListView listView = getListView();
        if (f < 1.0f) {
            f = 1.0f;
        }
        listView.setDividerHeight((int) f);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
        platform.setPlatformActionListener(this);
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, null);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        final FollowersResult followers = parseFollowers(this.platform.getName(), map, this.map);
        if (followers == null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
            return;
        }
        this.hasNext = followers.hasNextPage;
        if (followers.list == null || followers.list.size() <= 0) {
            return;
        }
        this.curPage++;
        Message message = new Message();
        message.what = 1;
        message.obj = followers.list;
        UIHandler.sendMessage(message, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message2) {
                if (FriendAdapter.this.curPage <= 0) {
                    FriendAdapter.this.follows.clear();
                }
                FriendAdapter.this.follows.addAll(followers.list);
                FriendAdapter.this.notifyDataSetChanged();
                return false;
            }
        });
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> map, HashMap<String, Boolean> map2) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        ArrayList<Following> arrayList = new ArrayList<>();
        if ("SinaWeibo".equals(str)) {
            for (HashMap map3 : (ArrayList) map.get("users")) {
                String strValueOf = String.valueOf(map3.get("id"));
                if (!map2.containsKey(strValueOf)) {
                    Following following = new Following();
                    following.uid = strValueOf;
                    following.screenName = String.valueOf(map3.get(Const.TableSchema.COLUMN_NAME));
                    following.description = String.valueOf(map3.get("description"));
                    following.icon = String.valueOf(map3.get("profile_image_url"));
                    following.atName = following.screenName;
                    map2.put(following.uid, true);
                    arrayList.add(following);
                }
            }
            if (((Integer) map.get("total_number")).intValue() > map2.size()) {
                zContainsKey = true;
            }
        } else if ("TencentWeibo".equals(str)) {
            zContainsKey = ((Integer) map.get("hasnext")).intValue() == 0;
            for (HashMap map4 : (ArrayList) map.get("info")) {
                String strValueOf2 = String.valueOf(map4.get(Const.TableSchema.COLUMN_NAME));
                if (!map2.containsKey(strValueOf2)) {
                    Following following2 = new Following();
                    following2.screenName = String.valueOf(map4.get("nick"));
                    following2.uid = strValueOf2;
                    following2.atName = strValueOf2;
                    Iterator it = ((ArrayList) map4.get("tweet")).iterator();
                    if (it.hasNext()) {
                        following2.description = String.valueOf(((HashMap) it.next()).get("text"));
                    }
                    following2.icon = String.valueOf(map4.get("head")) + "/100";
                    map2.put(following2.uid, true);
                    arrayList.add(following2);
                }
            }
        } else if ("Facebook".equals(str)) {
            for (HashMap map5 : (ArrayList) map.get("data")) {
                String strValueOf3 = String.valueOf(map5.get("id"));
                if (!map2.containsKey(strValueOf3)) {
                    Following following3 = new Following();
                    following3.uid = strValueOf3;
                    following3.atName = "[" + strValueOf3 + "]";
                    following3.screenName = String.valueOf(map5.get(Const.TableSchema.COLUMN_NAME));
                    HashMap map6 = (HashMap) map5.get("picture");
                    if (map6 != null) {
                        following3.icon = String.valueOf(((HashMap) map6.get("data")).get("url"));
                    }
                    map2.put(following3.uid, true);
                    arrayList.add(following3);
                }
            }
            zContainsKey = ((HashMap) map.get("paging")).containsKey("next");
        } else if ("Twitter".equals(str)) {
            for (HashMap map7 : (ArrayList) map.get("users")) {
                String strValueOf4 = String.valueOf(map7.get("screen_name"));
                if (!map2.containsKey(strValueOf4)) {
                    Following following4 = new Following();
                    following4.uid = strValueOf4;
                    following4.atName = strValueOf4;
                    following4.screenName = String.valueOf(map7.get(Const.TableSchema.COLUMN_NAME));
                    following4.description = String.valueOf(map7.get("description"));
                    following4.icon = String.valueOf(map7.get("profile_image_url"));
                    map2.put(following4.uid, true);
                    arrayList.add(following4);
                }
            }
        }
        FollowersResult followersResult = new FollowersResult();
        followersResult.list = arrayList;
        followersResult.hasNextPage = zContainsKey;
        return followersResult;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
        th.printStackTrace();
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                FriendAdapter.this.activity.finish();
                return false;
            }
        });
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public Following getItem(int i) {
        return this.follows.get(i);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public int getCount() {
        if (this.follows == null) {
            return 0;
        }
        return this.follows.size();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onPullDown(int i) {
        this.llHeader.onPullDown(i);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onReversed() {
        this.llHeader.reverse();
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FriendListItem(viewGroup.getContext(), this.ratio);
        }
        ((FriendListItem) view).update(getItem(i), isFling());
        if (i == getCount() - 1) {
            next();
        }
        return view;
    }

    static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getFooterView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }
}
