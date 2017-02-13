package model;

/**
 * Created by andrea on 07/02/17.
 */
public class DVDItem {
    private String dvdTitle, dvdGenre;
    private int dvdId, dvdYear;

    public DVDItem(int dvdId, String dvdTitle, int dvdYear, String dvdGenre) {
        this.dvdId = dvdId;
        this.dvdTitle = dvdTitle;
        this.dvdYear = dvdYear;
        this.dvdGenre = dvdGenre;
}

    public int getDvdId() {
        return dvdId;
    }
    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }
    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public int getDvdYear() {
        return dvdYear;
    }
    public void setDvdYear(int dvdYear) {
        this.dvdYear = dvdYear;
    }

    public String getDvdGenre() {
        return dvdGenre;
    }
    public void setDvdGenre(String dvdGenre) {
        this.dvdGenre = dvdGenre;
    }
}
