package src.model;

import java.util.ArrayList;

/**
 * Created by andrea on 07/02/17.
 */
public class DVDCollection {
    private ArrayList<DVDItem> dvdLibrary = new ArrayList<>();

    public ArrayList<DVDItem> getLibrary() {
        return dvdLibrary;
    }

    private DVDCollection(){
        dvdLibrary.add(new DVDItem("Close Encounters of the Third Kind", 1967, "Sci-Fi"));
        dvdLibrary.add(new DVDItem("Star Wars", 1977, "Sci-Fi"));
        dvdLibrary.add(new DVDItem("Mission To Mars", 2000, "Sci-Fi"));
    }

    private static final DVDCollection dvdCollection = new DVDCollection();

    public static DVDCollection getDvdCollection(){
        return dvdCollection;
    }
}
