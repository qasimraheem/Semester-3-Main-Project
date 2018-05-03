package saleClasses;

import javafx.beans.property.SimpleStringProperty;

public class SaleBill_Table {

    private final SimpleStringProperty tItems;
    private final SimpleStringProperty tPrice;


    public SaleBill_Table(String tItems, String tPrice){
        this.tItems= new SimpleStringProperty(tItems);
        this.tPrice=  new SimpleStringProperty(tPrice);
    }


    public String gettItems() {
        return tItems.get();
    }

    public SimpleStringProperty tItemsProperty() {
        return tItems;
    }

    public void settItems(String tItems) {
        this.tItems.set(tItems);
    }

    public String gettPrice() {
        return tPrice.get();
    }

    public SimpleStringProperty tPriceProperty() {
        return tPrice;
    }

    public void settPrice(String tPrice) {
        this.tPrice.set(tPrice);
    }


}
