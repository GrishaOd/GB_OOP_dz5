package presenters;

import models.TableService;
import views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver{

    private  Model model;
    private View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    private void updateChangedReservationTableView(int changedReservationNo){
        view.showChangedReservationTableResult(changedReservationNo);;
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try{
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }

    public void changedOnReservationTable(int oldId, Date orderDate, int tableNo, String name) {
        try{
            int reservationNo = model.changeReservationTable(oldId, orderDate, tableNo, name);
            updateChangedReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateChangedReservationTableView(-1);
        }
    }

}
