package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StringPart extends HTTPPart {

    /* JADX INFO: renamed from: sb */
    private StringBuilder f9021sb = new StringBuilder();

    public StringPart append(String str) {
        this.f9021sb.append(str);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    protected InputStream getInputStream() {
        return new ByteArrayInputStream(this.f9021sb.toString().getBytes("utf-8"));
    }

    public String toString() {
        return this.f9021sb.toString();
    }

    @Override // com.mob.tools.network.HTTPPart
    protected long length() {
        return this.f9021sb.toString().getBytes("utf-8").length;
    }
}
