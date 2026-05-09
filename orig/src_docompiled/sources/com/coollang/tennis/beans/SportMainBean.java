package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SportMainBean implements Serializable {

    @Expose
    public data data;

    @Expose
    public String date;

    public class data implements Serializable {

        @Expose
        public String CarolineTotal;

        @Expose
        public String MaxSpeed;

        @Expose
        public String QuantityTotal;

        @Expose
        public String Session;

        @Expose
        public String SportDate;

        @Expose
        public String SportDuration;

        @Expose
        public SportTypeAmount SportTypeAmount;

        public data() {
        }

        public class SportTypeAmount implements Serializable {

            @Expose
            public String CutTimes;

            @Expose
            public String DriveTimes;

            @Expose
            public String EmptyTimes;

            @Expose
            public String HighFarTimes;

            @Expose
            public String ParryTimes;

            @Expose
            public String PickTimes;

            @Expose
            public String SmashTimes;

            public SportTypeAmount() {
            }
        }
    }
}
