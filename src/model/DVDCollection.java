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

    private DVDCollection(){}

    private static final DVDCollection dvdCollection = new DVDCollection();

    public static DVDCollection getDvdCollection(){
        return dvdCollection;
    }

    public void addDvd(DVDItem dvd){
        dvdLibrary.add(dvd);
    }
}