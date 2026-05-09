package com.umeng.message.protobuffer;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

/* JADX INFO: loaded from: classes.dex */
public final class PushResponse extends Message {
    public static final responseCode DEFAULT_CODE = responseCode.SUCCESS;
    public static final String DEFAULT_DESCRIPTION = "";

    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final responseCode code;

    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String description;

    @ProtoField(tag = 3)
    public final Info info;

    public PushResponse(responseCode responsecode, String str, Info info) {
        this.code = responsecode;
        this.description = str;
        this.info = info;
    }

    private PushResponse(Builder builder) {
        this(builder.code, builder.description, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushResponse)) {
            return false;
        }
        PushResponse pushResponse = (PushResponse) obj;
        return equals(this.code, pushResponse.code) && equals(this.description, pushResponse.description) && equals(this.info, pushResponse.info);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((this.code != null ? this.code.hashCode() : 0) * 37) + (this.description != null ? this.description.hashCode() : 0)) * 37) + (this.info != null ? this.info.hashCode() : 0);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public static final class Builder extends Message.Builder<PushResponse> {
        public responseCode code;
        public String description;
        public Info info;

        public Builder() {
        }

        public Builder(PushResponse pushResponse) {
            super(pushResponse);
            if (pushResponse == null) {
                return;
            }
            this.code = pushResponse.code;
            this.description = pushResponse.description;
            this.info = pushResponse.info;
        }

        public Builder code(responseCode responsecode) {
            this.code = responsecode;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder info(Info info) {
            this.info = info;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public PushResponse build() {
            return new PushResponse(this);
        }
    }

    public enum responseCode implements ProtoEnum {
        SUCCESS(0),
        INVALID_REQUEST(1),
        SERVER_EXCEPTION(2);


        /* JADX INFO: renamed from: a */
        private final int f9259a;

        responseCode(int i) {
            this.f9259a = i;
        }

        @Override // com.squareup.wire.ProtoEnum
        public int getValue() {
            return this.f9259a;
        }
    }

    public static final class Info extends Message {
        public static final String DEFAULT_DEVICETOKENS = "";
        public static final Integer DEFAULT_LAUNCHPOLICY = 0;
        public static final Integer DEFAULT_TAGPOLICY = 0;
        public static final Integer DEFAULT_TAGREMAINCOUNT = 0;
        public static final String DEFAULT_TAGS = "";

        @ProtoField(tag = 3, type = Message.Datatype.STRING)
        public final String deviceTokens;

        @ProtoField(tag = 1, type = Message.Datatype.INT32)
        public final Integer launchPolicy;

        @ProtoField(tag = 2, type = Message.Datatype.INT32)
        public final Integer tagPolicy;

        @ProtoField(tag = 4, type = Message.Datatype.INT32)
        public final Integer tagRemainCount;

        @ProtoField(tag = 5, type = Message.Datatype.STRING)
        public final String tags;

        public Info(Integer num, Integer num2, String str, Integer num3, String str2) {
            this.launchPolicy = num;
            this.tagPolicy = num2;
            this.deviceTokens = str;
            this.tagRemainCount = num3;
            this.tags = str2;
        }

        private Info(Builder builder) {
            this(builder.launchPolicy, builder.tagPolicy, builder.deviceTokens, builder.tagRemainCount, builder.tags);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Info)) {
                return false;
            }
            Info info = (Info) obj;
            return equals(this.launchPolicy, info.launchPolicy) && equals(this.tagPolicy, info.tagPolicy) && equals(this.deviceTokens, info.deviceTokens) && equals(this.tagRemainCount, info.tagRemainCount) && equals(this.tags, info.tags);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = ((((((((this.launchPolicy != null ? this.launchPolicy.hashCode() : 0) * 37) + (this.tagPolicy != null ? this.tagPolicy.hashCode() : 0)) * 37) + (this.deviceTokens != null ? this.deviceTokens.hashCode() : 0)) * 37) + (this.tagRemainCount != null ? this.tagRemainCount.hashCode() : 0)) * 37) + (this.tags != null ? this.tags.hashCode() : 0);
            this.hashCode = iHashCode;
            return iHashCode;
        }

        public static final class Builder extends Message.Builder<Info> {
            public String deviceTokens;
            public Integer launchPolicy;
            public Integer tagPolicy;
            public Integer tagRemainCount;
            public String tags;

            public Builder() {
            }

            public Builder(Info info) {
                super(info);
                if (info == null) {
                    return;
                }
                this.launchPolicy = info.launchPolicy;
                this.tagPolicy = info.tagPolicy;
                this.deviceTokens = info.deviceTokens;
                this.tagRemainCount = info.tagRemainCount;
                this.tags = info.tags;
            }

            public Builder launchPolicy(Integer num) {
                this.launchPolicy = num;
                return this;
            }

            public Builder tagPolicy(Integer num) {
                this.tagPolicy = num;
                return this;
            }

            public Builder deviceTokens(String str) {
                this.deviceTokens = str;
                return this;
            }

            public Builder tagRemainCount(Integer num) {
                this.tagRemainCount = num;
                return this;
            }

            public Builder tags(String str) {
                this.tags = str;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public Info build() {
                return new Info(this);
            }
        }
    }
}
