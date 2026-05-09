package cn.smssdk.gui.layout;

import android.content.Context;
import android.widget.LinearLayout;
import cn.smssdk.gui.CountryListView;
import cn.smssdk.gui.layout.Res;

/* JADX INFO: loaded from: classes.dex */
public class CountryListPageLayout extends BasePageLayout {
    public CountryListPageLayout(Context context) {
        super(context, true);
    }

    @Override // cn.smssdk.gui.layout.BasePageLayout
    protected void onCreateContent(LinearLayout linearLayout) {
        CountryListView countryListView = new CountryListView(this.context);
        countryListView.setId(Res.C0975id.clCountry);
        countryListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        linearLayout.addView(countryListView);
    }
}
