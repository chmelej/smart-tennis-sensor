package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public class HttpConnectionImpl implements HttpConnection {
    private HttpResponse response;

    public HttpConnectionImpl(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() {
        return this.response.getEntity().getContent();
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return this.response.getEntity().getContent();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        Header[] allHeaders = this.response.getAllHeaders();
        if (allHeaders == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Header header : allHeaders) {
            ArrayList arrayList = new ArrayList();
            map.put(header.getName(), arrayList);
            String[] strArrSplit = header.getValue().split(",");
            if (strArrSplit != null) {
                for (String str : strArrSplit) {
                    arrayList.add(str.trim());
                }
            }
        }
        return map;
    }
}
