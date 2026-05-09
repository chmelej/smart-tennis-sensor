package com.mob.tools.network;

import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class HTTPPart {
    private OnReadListener listener;
    private long offset;

    protected abstract InputStream getInputStream();

    protected abstract long length();

    public void setOffset(long j) {
        this.offset = j;
    }

    public InputStream toInputStream() {
        ByteCounterInputStream byteCounterInputStream = new ByteCounterInputStream(getInputStream());
        byteCounterInputStream.setOnInputStreamReadListener(this.listener);
        if (this.offset > 0) {
            byteCounterInputStream.skip(this.offset);
        }
        return byteCounterInputStream;
    }

    public Object getInputStreamEntity() {
        InputStream inputStream = toInputStream();
        long length = length() - this.offset;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", inputStream, Long.valueOf(length));
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }
}
