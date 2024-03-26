package presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);
    void changedOnReservationTable(int oldId, Date orderDate, int tableNo, String name);

}
