package model;

/**
 * Created by andrea on 07/02/17.
 */
public class DVDItem {
    private String dvdTitle, dvdGenre;
    private int dvdYear;

    public DVDItem(String dvdTitle, int dvdYear, String dvdGenre) {
        this.dvdTitle = dvdTitle;
        this.dvdYear = dvdYear;
        this.dvdGenre = dvdGenre;
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
