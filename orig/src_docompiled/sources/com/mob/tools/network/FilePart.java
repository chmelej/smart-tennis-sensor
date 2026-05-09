package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class FilePart extends HTTPPart {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public void setFile(String str) {
        this.file = new File(str);
    }

    @Override // com.mob.tools.network.HTTPPart
    protected InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    public String toString() {
        return this.file.toString();
    }

    @Override // com.mob.tools.network.HTTPPart
    protected long length() {
        return this.file.length();
    }
}
