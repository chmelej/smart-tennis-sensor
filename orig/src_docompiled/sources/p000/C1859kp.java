package p000;

import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.p011db.model.VideoDetailTable;
import com.coollang.tennis.p011db.model.VideoTable;
import java.io.File;
import java.util.List;
import org.litepal.crud.DataSupport;

/* JADX INFO: renamed from: kp */
/* JADX INFO: compiled from: VideoTableDao.java */
/* JADX INFO: loaded from: classes.dex */
public class C1859kp {
    /* JADX INFO: renamed from: a */
    public void m10127a(String str, String str2, String str3, String str4, long j, long j2, boolean z, String str5) {
        VideoTable videoTable = new VideoTable();
        videoTable.setCreateTime(str);
        videoTable.setName(str4);
        videoTable.setPicture(str2);
        videoTable.setUrl(str3);
        videoTable.setStartTime(j);
        videoTable.setEndTime(j2);
        videoTable.setSynchroData(z);
        videoTable.setUserId(str5);
        videoTable.save();
        C1900mc.m10475c("VideoTableDao", "addVideo--------isSynchroData=" + z);
    }

    /* JADX INFO: renamed from: a */
    public void m10128a(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).split("file://")[1];
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            DataSupport.deleteAll((Class<?>) VideoTable.class, "url = ?", list.get(i));
            C1900mc.m10475c("VideoTableDao", "deleteVideo-------path=" + str);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10124a(int i, String str) {
        VideoTable videoTable = new VideoTable();
        videoTable.setName(str);
        videoTable.update(i);
    }

    /* JADX INFO: renamed from: a */
    public void m10125a(int i, boolean z) {
        VideoTable videoTable = new VideoTable();
        videoTable.setSynchroData(z);
        videoTable.update(i);
    }

    /* JADX INFO: renamed from: a */
    public List<VideoTable> m10123a() {
        return DataSupport.findAll(VideoTable.class, new long[0]);
    }

    /* JADX INFO: renamed from: a */
    public void m10126a(long j, long j2, String str) {
        List listFind = DataSupport.where("userid = ? And timestamp > ? And timestamp < ?", str, String.valueOf(j), String.valueOf(j2)).find(MyDetailTable.class);
        for (int i = 0; i < listFind.size(); i++) {
            VideoDetailTable videoDetailTable = new VideoDetailTable();
            videoDetailTable.setTimestamp(((MyDetailTable) listFind.get(i)).getTimestamp());
            videoDetailTable.setActionType(((MyDetailTable) listFind.get(i)).getActionType());
            videoDetailTable.setSpeed(((MyDetailTable) listFind.get(i)).getSpeed());
            videoDetailTable.setRadian(((MyDetailTable) listFind.get(i)).getRadian());
            videoDetailTable.setForce(((MyDetailTable) listFind.get(i)).getForce());
            videoDetailTable.setIstarget(((MyDetailTable) listFind.get(i)).getIstarget());
            videoDetailTable.setWhichnum(((MyDetailTable) listFind.get(i)).getWhichnum());
            videoDetailTable.setDay(((MyDetailTable) listFind.get(i)).getSign2());
            videoDetailTable.setUserID(((MyDetailTable) listFind.get(i)).getUserID());
            videoDetailTable.setHandType(((MyDetailTable) listFind.get(i)).getHandType());
            videoDetailTable.save();
        }
    }
}
