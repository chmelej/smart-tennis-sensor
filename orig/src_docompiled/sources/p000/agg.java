package p000;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: classes.dex */
public class agg extends agi {

    /* JADX INFO: renamed from: a */
    protected InputStream f815a;

    /* JADX INFO: renamed from: b */
    protected OutputStream f816b;

    protected agg() {
        this.f815a = null;
        this.f816b = null;
    }

    public agg(OutputStream outputStream) {
        this.f815a = null;
        this.f816b = null;
        this.f816b = outputStream;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: a */
    public int mo914a(byte[] bArr, int i, int i2) throws agj {
        if (this.f815a == null) {
            throw new agj(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = this.f815a.read(bArr, i, i2);
            if (i3 < 0) {
                throw new agj(4);
            }
            return i3;
        } catch (IOException e) {
            throw new agj(0, e);
        }
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: b */
    public void mo915b(byte[] bArr, int i, int i2) throws agj {
        if (this.f816b == null) {
            throw new agj(1, "Cannot write to null outputStream");
        }
        try {
            this.f816b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new agj(0, e);
        }
    }
}
