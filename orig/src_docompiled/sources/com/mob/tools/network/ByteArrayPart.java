package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayPart extends HTTPPart {
    private BufferedByteArrayOutputStream buffer;

    public ByteArrayPart append(byte[] bArr) {
        if (this.buffer == null) {
            this.buffer = new BufferedByteArrayOutputStream(bArr.length);
        }
        this.buffer.write(bArr);
        this.buffer.flush();
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    protected InputStream getInputStream() {
        if (this.buffer == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] buffer = this.buffer.getBuffer();
        if (buffer == null || this.buffer.size() <= 0) {
            return new ByteArrayInputStream(new byte[0]);
        }
        return new ByteArrayInputStream(buffer, 0, this.buffer.size());
    }

    public String toString() {
        byte[] buffer;
        if (this.buffer == null || (buffer = this.buffer.getBuffer()) == null) {
            return null;
        }
        return Data.byteToHex(buffer, 0, this.buffer.size());
    }

    @Override // com.mob.tools.network.HTTPPart
    protected long length() {
        if (this.buffer == null) {
            return 0L;
        }
        return this.buffer.size();
    }
}
