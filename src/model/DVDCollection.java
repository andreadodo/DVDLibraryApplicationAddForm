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
        int id = 0;
        if(!dvdLibrary.isEmpty())
            id = dvdLibrary.get(dvdLibrary.size() - 1).getDvdId();
        return id;

    }

    public boolean addDvd(DVDItem newDvd) {
        for (DVDItem dvd: dvdLibrary) {
            if(dvd.getDvdGenre().equals(newDvd.getDvdGenre())
                    && (dvd.getDvdYear() == newDvd.getDvdYear())
                    && dvd.getDvdTitle().equals(newDvd.getDvdTitle()));
                return false;
        }
        dvdLibrary.add(newDvd);
        return true;
    }

    public void delDvd(int id){         //si potrebbe fare anche con dvdLibray.removeIf()
        for (DVDItem dvd: dvdLibrary) {
            if(dvd.getDvdId()==id) {
                dvdLibrary.remove(dvd);
                return;
            }
        }
    }

    public void editDvd(DVDItem dvdEdit) {
        for (int i = 0; i < dvdLibrary.size(); i++) {
            DVDItem dvd = dvdLibrary.get(i);
            if (dvd.getDvdId() == dvdEdit.getDvdId()) {
                dvdLibrary.set(i, dvdEdit);
                return;
            }
        }
    }
}