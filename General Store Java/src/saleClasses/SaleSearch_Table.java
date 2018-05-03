package saleClasses;

import javafx.beans.property.SimpleStringProperty;

public class SaleSearch_Table {


    private final SimpleStringProperty tName;
    private final SimpleStringProperty tPrice;


    public SaleSearch_Table(String tName, String tPrice) {
        this.tName = new SimpleStringProperty(tName);
        this.tPrice = new SimpleStringProperty(tPrice);
    }


    public String gettName() {
        return tName.get();
    }

    public SimpleStringProperty tNameProperty() {
        return tName;
    }

    public void settName(String tName) {
        this.tName.set(tName);
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
