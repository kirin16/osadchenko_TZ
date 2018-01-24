package artem.com.tz_osdchenko.entity;

/**
 * Created by artem on 24.01.2018.
 */

public class ProjectData {

    private String send;
    private String add;
    private String docs;
    private String dvir;

    public ProjectData(String log, String general, String docs, String dvir) {
        this.send = log;
        this.add = general;
        this.docs = docs;
        this.dvir = dvir;
    }

    public String getSend() {
        return send;
    }

    public String getAdd() {
        return add;
    }

    public String getDocs() {
        return docs;
    }

    public String getDvir() {
        return dvir;
    }

}
