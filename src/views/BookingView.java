package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private Collection<ViewObserver> observers;

    public void showTables(Collection<Table> tables){
        for (Table table : tables){
            System.out.println(table);
        }
    }


    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик забронирован. Номер брони: #%d\n", reservationNo);
        }
        else{
            System.out.println("произошла ошибка при попытке забронировать столик.\nПовторите попытку");
        }
    }

    public void showChangedReservationTableResult(int changedReservationNo) {
        if (changedReservationNo > 0){
            System.out.printf("Столик перезабронирован. Новый номер брони: #%d\n", changedReservationNo);
        }
        else{
            System.out.println("Произошла ошибка при попытке перезабронировать столик.\nПовторите попытку");
        }
    }

    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.onReservationTable(orderDate, tableNo, name);
            }
        }
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.changedOnReservationTable(oldReservation, reservationDate, tableNo, name);
            }
        }
    }

}
