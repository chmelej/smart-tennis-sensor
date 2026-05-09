package com.umeng.message.protobuffer;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class PushRequest extends Message {
    public static final String DEFAULT_CHECKSUM = "";
    public static final String DEFAULT_SALT = "";
    public static final String DEFAULT_SIGNATURE = "";
    public static final String DEFAULT_VERSION = "";

    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String checksum;

    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final entityEncodingFormat encryption;

    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final ByteString entity;

    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String salt;

    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer serialNo;

    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String signature;

    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer timestamp;

    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String version;
    public static final Integer DEFAULT_SERIALNO = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final entityEncodingFormat DEFAULT_ENCRYPTION = entityEncodingFormat.JSON;
    public static final ByteString DEFAULT_ENTITY = ByteString.EMPTY;

    public PushRequest(String str, String str2, Integer num, Integer num2, String str3, String str4, entityEncodingFormat entityencodingformat, ByteString byteString) {
        this.version = str;
        this.signature = str2;
        this.serialNo = num;
        this.timestamp = num2;
        this.checksum = str3;
        this.salt = str4;
        this.encryption = entityencodingformat;
        this.entity = byteString;
    }

    private PushRequest(Builder builder) {
        this(builder.version, builder.signature, builder.serialNo, builder.timestamp, builder.checksum, builder.salt, builder.encryption, builder.entity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushRequest)) {
            return false;
        }
        PushRequest pushRequest = (PushRequest) obj;
        return equals(this.version, pushRequest.version) && equals(this.signature, pushRequest.signature) && equals(this.serialNo, pushRequest.serialNo) && equals(this.timestamp, pushRequest.timestamp) && equals(this.checksum, pushRequest.checksum) && equals(this.salt, pushRequest.salt) && equals(this.encryption, pushRequest.encryption) && equals(this.entity, pushRequest.entity);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((((((((((this.version != null ? this.version.hashCode() : 0) * 37) + (this.signature != null ? this.signature.hashCode() : 0)) * 37) + (this.serialNo != null ? this.serialNo.hashCode() : 0)) * 37) + (this.timestamp != null ? this.timestamp.hashCode() : 0)) * 37) + (this.checksum != null ? this.checksum.hashCode() : 0)) * 37) + (this.salt != null ? this.salt.hashCode() : 0)) * 37) + (this.encryption != null ? this.encryption.hashCode() : 0)) * 37) + (this.entity != null ? this.entity.hashCode() : 0);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public static final class Builder extends Message.Builder<PushRequest> {
        public String checksum;
        public entityEncodingFormat encryption;
        public ByteString entity;
        public String salt;
        public Integer serialNo;
        public String signature;
        public Integer timestamp;
        public String version;

        public Builder() {
        }

        public Builder(PushRequest pushRequest) {
            super(pushRequest);
            if (pushRequest == null) {
                return;
            }
            this.version = pushRequest.version;
            this.signature = pushRequest.signature;
            this.serialNo = pushRequest.serialNo;
            this.timestamp = pushRequest.timestamp;
            this.checksum = pushRequest.checksum;
            this.salt = pushRequest.salt;
            this.encryption = pushRequest.encryption;
            this.entity = pushRequest.entity;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder serialNo(Integer num) {
            this.serialNo = num;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder checksum(String str) {
            this.checksum = str;
            return this;
        }

        public Builder salt(String str) {
            this.salt = str;
            return this;
        }

        public Builder encryption(entityEncodingFormat entityencodingformat) {
            this.encryption = entityencodingformat;
            return this;
        }

        public Builder entity(ByteString byteString) {
            this.entity = byteString;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public PushRequest build() {
            return new PushRequest(this);
        }
    }

    public enum entityEncodingFormat implements ProtoEnum {
        JSON(0),
        JSON_AES(1),
        JSON_RSA(2);


        /* JADX INFO: renamed from: a */
        private final int f9257a;

        entityEncodingFormat(int i) {
            this.f9257a = i;
        }

        @Override // com.squareup.wire.ProtoEnum
        public int getValue() {
            return this.f9257a;
        }
    }
}
