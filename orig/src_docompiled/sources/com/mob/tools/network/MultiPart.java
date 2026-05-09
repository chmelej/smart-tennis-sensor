package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MultiPart extends HTTPPart {
    private ArrayList<HTTPPart> parts = new ArrayList<>();

    public MultiPart append(HTTPPart hTTPPart) {
        this.parts.add(hTTPPart);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    protected InputStream getInputStream() {
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        Iterator<HTTPPart> it = this.parts.iterator();
        while (it.hasNext()) {
            multiPartInputStream.addInputStream(it.next().getInputStream());
        }
        return multiPartInputStream;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<HTTPPart> it = this.parts.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    @Override // com.mob.tools.network.HTTPPart
    protected long length() {
        Iterator<HTTPPart> it = this.parts.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
