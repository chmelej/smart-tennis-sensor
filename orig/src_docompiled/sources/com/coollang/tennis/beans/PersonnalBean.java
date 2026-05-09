package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PersonnalBean {
    public PersonData errDesc;

    @Expose
    public String ret;

    public class PersonData {

        @Expose
        public String Address;

        @Expose
        public String AvgWeekSport;

        @Expose
        public String HeadIcon;

        @Expose
        public String MaxScore;

        @Expose
        public String MaxSpeed;

        @Expose
        public List<Medal> Medals;

        @Expose
        public String Rank;

        @Expose
        public String Sex;

        @Expose
        public String TotalCount;

        @Expose
        public String TotalDuration;

        @Expose
        public String UserID;

        @Expose
        public String UserName;

        public PersonData() {
        }
    }

    public class Medal {

        @Expose
        public String CreateTime;

        @Expose
        public int Medal;

        @Expose
        public String State;

        public Medal() {
        }
    }
}
