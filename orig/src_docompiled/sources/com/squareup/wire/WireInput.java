package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes.dex */
final class WireInput {
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private int lastTag;
    public int recursionDepth;
    private final BufferedSource source;
    private int pos = 0;
    private int currentLimit = Integer.MAX_VALUE;

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(j & 1));
    }

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(new Buffer().write(bArr));
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        return new WireInput(new Buffer().write(bArr, i, i2));
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(Okio.buffer(Okio.source(inputStream)));
    }

    public static WireInput newInstance(Source source) {
        return new WireInput(Okio.buffer(source));
    }

    public int readTag() {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readVarint32();
        if (this.lastTag == 0) {
            throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) {
        if (this.lastTag != i) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public String readString() {
        int varint32 = readVarint32();
        this.pos += varint32;
        return this.source.readString(varint32, UTF_8);
    }

    public ByteString readBytes() {
        return readBytes(readVarint32());
    }

    public ByteString readBytes(int i) {
        this.pos += i;
        long j = i;
        this.source.require(j);
        return this.source.readByteString(j);
    }

    public int readVarint32() {
        this.pos++;
        byte b = this.source.readByte();
        if (b >= 0) {
            return b;
        }
        int i = b & 127;
        this.pos++;
        byte b2 = this.source.readByte();
        if (b2 >= 0) {
            return i | (b2 << 7);
        }
        int i2 = i | ((b2 & 127) << 7);
        this.pos++;
        byte b3 = this.source.readByte();
        if (b3 >= 0) {
            return i2 | (b3 << 14);
        }
        int i3 = i2 | ((b3 & 127) << 14);
        this.pos++;
        byte b4 = this.source.readByte();
        if (b4 >= 0) {
            return i3 | (b4 << 21);
        }
        int i4 = i3 | ((b4 & 127) << 21);
        this.pos++;
        byte b5 = this.source.readByte();
        int i5 = i4 | (b5 << 28);
        if (b5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            this.pos++;
            if (this.source.readByte() >= 0) {
                return i5;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public long readVarint64() throws IOException {
        int i = 0;
        long j = 0;
        while (i < 64) {
            this.pos++;
            byte b = this.source.readByte();
            long j2 = j | (((long) (b & 127)) << i);
            if ((b & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public int readFixed32() {
        this.pos += 4;
        return this.source.readIntLe();
    }

    public long readFixed64() {
        this.pos += 8;
        return this.source.readLongLe();
    }

    private WireInput(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public int pushLimit(int i) {
        if (i < 0) {
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        int i2 = i + this.pos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        this.currentLimit = i2;
        return i3;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
    }

    private boolean isAtEnd() {
        if (getPosition() == this.currentLimit) {
            return true;
        }
        return this.source.exhausted();
    }

    public long getPosition() {
        return this.pos;
    }

    public void skipGroup() {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (!skipField(tag));
    }

    private boolean skipField(int i) throws IOException {
        switch (WireType.valueOf(i)) {
            case VARINT:
                readVarint64();
                return false;
            case FIXED32:
                readFixed32();
                return false;
            case FIXED64:
                readFixed64();
                return false;
            case LENGTH_DELIMITED:
                skip(readVarint32());
                return false;
            case START_GROUP:
                skipGroup();
                checkLastTagWas((i & (-8)) | WireType.END_GROUP.value());
                return false;
            case END_GROUP:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void skip(long j) {
        this.pos = (int) (((long) this.pos) + j);
        this.source.skip(j);
    }
}
