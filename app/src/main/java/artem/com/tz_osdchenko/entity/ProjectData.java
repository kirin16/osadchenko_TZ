package artem.com.tz_osdchenko.entity;

/**
 * Created by artem on 24.01.2018.
 */

public class ProjectData {

    private String nameLog;
    private String nameGeneral;
    private String nameDocs;
    private String nameDvir;

    public ProjectData(String log, String general, String nameDocs, String nameDvir) {
        this.nameLog = log;
        this.nameGeneral = general;
        this.nameDocs = nameDocs;
        this.nameDvir = nameDvir;
    }

    public String getLog() {
        return nameLog;
    }

    public String getGeneral() {
        return nameGeneral;
    }

    public String getDocs() {
        return nameDocs;
    }

    public String getDvir() {
        return nameDvir;
    }

}
