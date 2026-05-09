package com.coollang.tennis.beans;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SportDetailBean {

    @Expose
    public errDesc errDesc;

    public class errDesc {

        @Expose
        public String AvgSpeed;
        public List<Object> AvgTypeSpeedData;

        @Expose
        public String BackHandPercent;

        @Expose
        public String Caroline;

        @Expose
        public String Date;

        @Expose
        public String Duration;

        @Expose
        public String DurationPercent;

        @Expose
        public String EveryMinuteHit;

        @Expose
        public String ForeHandPercent;

        @Expose
        public String HitPercent;

        @Expose
        public String MaxSpeed;
        public List<Object> MaxTypeSpeedData;

        @Expose
        public List<ReportInfo> ReportInfo;

        @Expose
        public String SpeedPercent;

        @Expose
        public int TotalScore;

        @Expose
        public TypeCount TypeCount;

        @Expose
        public String UpdateTime;

        @Expose
        public String UserID;

        public errDesc() {
        }

        public class TypeCount {

            @Expose
            public String FaQiu;

            @Expose
            public String GaoYa;

            @Expose
            public String JieJi;

            @Expose
            public String PingJi;

            @Expose
            public String XuanQiu;

            @Expose
            public String XueQiu;

            public TypeCount() {
            }
        }

        public class ReportInfo {

            @Expose
            public String Describe;

            @Expose
            public String Title;

            @Expose
            public String Unit;

            @Expose
            public String Value;

            public ReportInfo() {
            }
        }
    }

    public static class DetailDeserilizer implements JsonDeserializer<SportDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public SportDetailBean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            JsonElement jsonElement2;
            JsonElement jsonElement3;
            SportDetailBean sportDetailBean = (SportDetailBean) new Gson().fromJson(jsonElement, SportDetailBean.class);
            JsonObject asJsonObject = jsonElement.getAsJsonObject().get("errDesc").getAsJsonObject();
            if (asJsonObject.has("MaxTypeSpeed") && (jsonElement3 = asJsonObject.get("MaxTypeSpeed")) != null && !jsonElement3.isJsonNull()) {
                if (jsonElement3.isJsonArray()) {
                    sportDetailBean.errDesc.MaxTypeSpeedData = (List) new Gson().fromJson(jsonElement3, new TypeToken<ArrayList<Object>>() { // from class: com.coollang.tennis.beans.SportDetailBean.DetailDeserilizer.1
                    }.getType());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("0");
                    for (int i = 0; i < 6; i++) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("0");
                        arrayList2.add("0");
                        arrayList.add(arrayList2);
                    }
                    sportDetailBean.errDesc.MaxTypeSpeedData = arrayList;
                }
            }
            if (asJsonObject.has("AvgTypeSpeed") && (jsonElement2 = asJsonObject.get("AvgTypeSpeed")) != null && !jsonElement2.isJsonNull()) {
                if (jsonElement2.isJsonArray()) {
                    sportDetailBean.errDesc.AvgTypeSpeedData = (List) new Gson().fromJson(jsonElement2, new TypeToken<ArrayList<Object>>() { // from class: com.coollang.tennis.beans.SportDetailBean.DetailDeserilizer.2
                    }.getType());
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add("0");
                    for (int i2 = 0; i2 < 6; i2++) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add("0");
                        arrayList4.add("0");
                        arrayList3.add(arrayList4);
                    }
                    sportDetailBean.errDesc.AvgTypeSpeedData = arrayList3;
                }
            }
            return sportDetailBean;
        }
    }
}
