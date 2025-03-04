package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.logging.Logger;

public class Table {

    private static int counter;
    private int no;

    private Collection<Reservation> reservations = new ArrayList<>();

    public int getNo(){
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }



    public Table(){
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
