package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatchDataBean {

    @Expose
    public String Date;

    @Expose
    public List<MatchData> MatchList;

    public class MatchData {

        @Expose
        public String AverageForce;

        @Expose
        public String AverageHittime;

        @Expose
        public String Calori;

        @Expose
        public String MatchDuration;

        @Expose
        public String MatchTimes;

        @Expose
        public String MaxSpeed;

        @Expose
        public String StandardRatio;

        public MatchData() {
        }
    }
}
