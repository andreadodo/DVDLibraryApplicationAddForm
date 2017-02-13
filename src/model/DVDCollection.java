package model;

import java.util.ArrayList;

/**
 * Created by andrea on 07/02/17.
 */
public class DVDCollection {
    private ArrayList<DVDItem> dvdLibrary = new ArrayList<>();

    public ArrayList<DVDItem> getLibrary() {
        return dvdLibrary;
    }

    private DVDCollection() {
    }

    private static final DVDCollection dvdCollection = new DVDCollection();

    public static DVDCollection getDvdCollection() {
        return dvdCollection;
    }

    public DVDItem getDvd(int id) {
        for (DVDItem dvd: dvdLibrary) {
            if(dvd.getDvdId()==id)
                return dvd;
            }
        return null;
    }

    public int getLastId() {
        int id = -1;
        if(!dvdLibrary.isEmpty())
            id = dvdLibrary.get(dvdLibrary.size() - 1).getDvdId();
        return id;

    }

    public void addDvd(DVDItem dvd) {
        delDvd(dvd.getDvdId());
        dvdLibrary.add(dvd);
    }

    public void delDvd(int id){         //si potrebbe fare anche con dvdLibray.removeIf()
        for (DVDItem dvd: dvdLibrary) {
            if(dvd.getDvdId()==id) {
                dvdLibrary.remove(dvd);
                return;
            }
        }
    }
}