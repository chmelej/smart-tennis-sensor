package p000;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: gx */
/* JADX INFO: compiled from: SuggestionsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1759gx extends ResourceCursorAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private final SearchManager f10098a;

    /* JADX INFO: renamed from: b */
    private final SearchView f10099b;

    /* JADX INFO: renamed from: c */
    private final SearchableInfo f10100c;

    /* JADX INFO: renamed from: d */
    private final Context f10101d;

    /* JADX INFO: renamed from: e */
    private final WeakHashMap<String, Drawable.ConstantState> f10102e;

    /* JADX INFO: renamed from: f */
    private final int f10103f;

    /* JADX INFO: renamed from: g */
    private boolean f10104g;

    /* JADX INFO: renamed from: h */
    private int f10105h;

    /* JADX INFO: renamed from: i */
    private ColorStateList f10106i;

    /* JADX INFO: renamed from: j */
    private int f10107j;

    /* JADX INFO: renamed from: k */
    private int f10108k;

    /* JADX INFO: renamed from: l */
    private int f10109l;

    /* JADX INFO: renamed from: m */
    private int f10110m;

    /* JADX INFO: renamed from: n */
    private int f10111n;

    /* JADX INFO: renamed from: o */
    private int f10112o;

    @Override // android.support.v4.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public ViewOnClickListenerC1759gx(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f10104g = false;
        this.f10105h = 1;
        this.f10107j = -1;
        this.f10108k = -1;
        this.f10109l = -1;
        this.f10110m = -1;
        this.f10111n = -1;
        this.f10112o = -1;
        this.f10098a = (SearchManager) this.mContext.getSystemService("search");
        this.f10099b = searchView;
        this.f10100c = searchableInfo;
        this.f10103f = searchView.getSuggestionCommitIconResId();
        this.f10101d = context;
        this.f10102e = weakHashMap;
    }

    /* JADX INFO: renamed from: a */
    public void m9584a(int i) {
        this.f10105h = i;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f10099b.getVisibility() != 0 || this.f10099b.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursorM9582a = m9582a(this.f10100c, string, 50);
            if (cursorM9582a != null) {
                cursorM9582a.getCount();
                return cursorM9582a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m9572a(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m9572a(getCursor());
    }

    /* JADX INFO: renamed from: a */
    private void m9572a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.f10104g) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f10107j = cursor.getColumnIndex("suggest_text_1");
                this.f10108k = cursor.getColumnIndex("suggest_text_2");
                this.f10109l = cursor.getColumnIndex("suggest_text_2_url");
                this.f10110m = cursor.getColumnIndex("suggest_icon_1");
                this.f10111n = cursor.getColumnIndex("suggest_icon_2");
                this.f10112o = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        viewNewView.setTag(new a(viewNewView));
        ((ImageView) viewNewView.findViewById(R.id.edit_query)).setImageResource(this.f10103f);
        return viewNewView;
    }

    /* JADX INFO: renamed from: gx$a */
    /* JADX INFO: compiled from: SuggestionsAdapter.java */
    static final class a {

        /* JADX INFO: renamed from: a */
        public final TextView f10113a;

        /* JADX INFO: renamed from: b */
        public final TextView f10114b;

        /* JADX INFO: renamed from: c */
        public final ImageView f10115c;

        /* JADX INFO: renamed from: d */
        public final ImageView f10116d;

        /* JADX INFO: renamed from: e */
        public final ImageView f10117e;

        public a(View view) {
            this.f10113a = (TextView) view.findViewById(android.R.id.text1);
            this.f10114b = (TextView) view.findViewById(android.R.id.text2);
            this.f10115c = (ImageView) view.findViewById(android.R.id.icon1);
            this.f10116d = (ImageView) view.findViewById(android.R.id.icon2);
            this.f10117e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence charSequenceM9570a;
        a aVar = (a) view.getTag();
        int i = this.f10112o != -1 ? cursor.getInt(this.f10112o) : 0;
        if (aVar.f10113a != null) {
            m9574a(aVar.f10113a, m9570a(cursor, this.f10107j));
        }
        if (aVar.f10114b != null) {
            String strM9570a = m9570a(cursor, this.f10109l);
            if (strM9570a != null) {
                charSequenceM9570a = m9569a((CharSequence) strM9570a);
            } else {
                charSequenceM9570a = m9570a(cursor, this.f10108k);
            }
            if (TextUtils.isEmpty(charSequenceM9570a)) {
                if (aVar.f10113a != null) {
                    aVar.f10113a.setSingleLine(false);
                    aVar.f10113a.setMaxLines(2);
                }
            } else if (aVar.f10113a != null) {
                aVar.f10113a.setSingleLine(true);
                aVar.f10113a.setMaxLines(1);
            }
            m9574a(aVar.f10114b, charSequenceM9570a);
        }
        if (aVar.f10115c != null) {
            m9573a(aVar.f10115c, m9577b(cursor), 4);
        }
        if (aVar.f10116d != null) {
            m9573a(aVar.f10116d, m9580c(cursor), 8);
        }
        if (this.f10105h == 2 || (this.f10105h == 1 && (i & 1) != 0)) {
            aVar.f10117e.setVisibility(0);
            aVar.f10117e.setTag(aVar.f10113a.getText());
            aVar.f10117e.setOnClickListener(this);
            return;
        }
        aVar.f10117e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f10099b.m4191a((CharSequence) tag);
        }
    }

    /* JADX INFO: renamed from: a */
    private CharSequence m9569a(CharSequence charSequence) {
        if (this.f10106i == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f10106i = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f10106i, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* JADX INFO: renamed from: a */
    private void m9574a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: b */
    private Drawable m9577b(Cursor cursor) {
        if (this.f10110m == -1) {
            return null;
        }
        Drawable drawableM9568a = m9568a(cursor.getString(this.f10110m));
        return drawableM9568a != null ? drawableM9568a : m9581d(cursor);
    }

    /* JADX INFO: renamed from: c */
    private Drawable m9580c(Cursor cursor) {
        if (this.f10111n == -1) {
            return null;
        }
        return m9568a(cursor.getString(this.f10111n));
    }

    /* JADX INFO: renamed from: a */
    private void m9573a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String strM9571a;
        String strM9571a2;
        if (cursor == null) {
            return null;
        }
        String strM9571a3 = m9571a(cursor, "suggest_intent_query");
        if (strM9571a3 != null) {
            return strM9571a3;
        }
        if (this.f10100c.shouldRewriteQueryFromData() && (strM9571a2 = m9571a(cursor, "suggest_intent_data")) != null) {
            return strM9571a2;
        }
        if (!this.f10100c.shouldRewriteQueryFromText() || (strM9571a = m9571a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM9571a;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewNewView = newView(this.mContext, this.mCursor, viewGroup);
            if (viewNewView != null) {
                ((a) viewNewView.getTag()).f10113a.setText(e.toString());
            }
            return viewNewView;
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewNewDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (viewNewDropDownView != null) {
                ((a) viewNewDropDownView.getTag()).f10113a.setText(e.toString());
            }
            return viewNewDropDownView;
        }
    }

    /* JADX INFO: renamed from: a */
    private Drawable m9568a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f10101d.getPackageName() + "/" + i;
            Drawable drawableM9579b = m9579b(str2);
            if (drawableM9579b != null) {
                return drawableM9579b;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f10101d, i);
            m9575a(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableM9579b2 = m9579b(str);
            if (drawableM9579b2 != null) {
                return drawableM9579b2;
            }
            Drawable drawableM9578b = m9578b(Uri.parse(str));
            m9575a(str, drawableM9578b);
            return drawableM9578b;
        }
    }

    /* JADX INFO: renamed from: b */
    private Drawable m9578b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m9583a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f10101d.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m9579b(String str) {
        Drawable.ConstantState constantState = this.f10102e.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* JADX INFO: renamed from: a */
    private void m9575a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f10102e.put(str, drawable.getConstantState());
        }
    }

    /* JADX INFO: renamed from: d */
    private Drawable m9581d(Cursor cursor) {
        Drawable drawableM9567a = m9567a(this.f10100c.getSearchActivity());
        return drawableM9567a != null ? drawableM9567a : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX INFO: renamed from: a */
    private Drawable m9567a(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (this.f10102e.containsKey(strFlattenToShortString)) {
            Drawable.ConstantState constantState = this.f10102e.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f10101d.getResources());
        }
        Drawable drawableM9576b = m9576b(componentName);
        this.f10102e.put(strFlattenToShortString, drawableM9576b != null ? drawableM9576b.getConstantState() : null);
        return drawableM9576b;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m9576b(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m9571a(Cursor cursor, String str) {
        return m9570a(cursor, cursor.getColumnIndex(str));
    }

    /* JADX INFO: renamed from: a */
    private static String m9570a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    Drawable m9583a(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX INFO: renamed from: a */
    Cursor m9582a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }
}
