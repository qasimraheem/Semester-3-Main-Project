package billClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Bill_Table {
    private final SimpleStringProperty tBillId;
    private final SimpleStringProperty tTotalItems;
    private final SimpleStringProperty tTotalPrice;
    private final SimpleStringProperty tDate;
    ObservableList<BillDetail_Table> Billdetail;

    public Bill_Table(String tBillId, String tTotalItems, String tTotalPrice, String tDate, ObservableList<BillDetail_Table> Billdetail) {
        this.tBillId =  new SimpleStringProperty(tBillId);
        this.tTotalItems =  new SimpleStringProperty(tTotalItems);
        this.tTotalPrice =  new SimpleStringProperty(tTotalPrice);
        this.tDate =  new SimpleStringProperty(tDate);
        this.Billdetail=Billdetail;
    }

    public String gettBillId() {
        return tBillId.get();
    }

    public SimpleStringProperty tBillIdProperty() {
        return tBillId;
    }

    public void settBillId(String tBillId) {
        this.tBillId.set(tBillId);
    }

    public String gettTotalItems() {
        return tTotalItems.get();
    }

    public SimpleStringProperty tTotalItemsProperty() {
        return tTotalItems;
    }

    public void settTotalItems(String tTotalItems) {
        this.tTotalItems.set(tTotalItems);
    }

    public String gettTotalPrice() {
        return tTotalPrice.get();
    }

    public SimpleStringProperty tTotalPriceProperty() {
        return tTotalPrice;
    }

    public void settTotalPrice(String tTotalPrice) {
        this.tTotalPrice.set(tTotalPrice);
    }

    public String gettDate() {
        return tDate.get();
    }

    public SimpleStringProperty tDateProperty() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate.set(tDate);
    }
}
