package saleClasses;

import javafx.beans.property.SimpleStringProperty;

public class SaleSearch_Table {


    private final SimpleStringProperty tName;
    private final SimpleStringProperty tQuantity;
    private final SimpleStringProperty tBuyPrice;
    private final SimpleStringProperty tPrice;


    public SaleSearch_Table(String tName, String tQuantity, String tBuyPrice, String tPrice){
        this.tName = new SimpleStringProperty(tName);
        this.tPrice = new SimpleStringProperty(tPrice);
        this.tQuantity = new SimpleStringProperty(tQuantity);
        this.tBuyPrice = new SimpleStringProperty(tBuyPrice);
    }

    public String gettQuantity() {
        return tQuantity.get();
    }

    public SimpleStringProperty tQuantityProperty() {
        return tQuantity;
    }

    public void settQuantity(String tQuantity) {
        this.tQuantity.set(tQuantity);
    }

    public String gettBuyPrice() {
        return tBuyPrice.get();
    }

    public SimpleStringProperty tBuyPriceProperty() {
        return tBuyPrice;
    }

    public void settBuyPrice(String tBuyPrice) {
        this.tBuyPrice.set(tBuyPrice);
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
