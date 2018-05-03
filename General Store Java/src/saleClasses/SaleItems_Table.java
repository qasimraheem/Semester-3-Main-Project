package saleClasses;

import javafx.beans.property.SimpleStringProperty;

import javafx.scene.control.Button;
import javafx.scene.control.*;

public class SaleItems_Table {
    private final SimpleStringProperty tID;
    private final SimpleStringProperty tName;
    private final SimpleStringProperty tQuantity;
    private final SimpleStringProperty tPrice;
    private final SimpleStringProperty tPriceX;



    public SaleItems_Table(String tID, String tName, String tQuantity, String tPrice, String tPriceX) {
        this.tID = new SimpleStringProperty(tID);
        this.tName = new SimpleStringProperty(tName);
        this.tQuantity = new SimpleStringProperty(tQuantity);
        this.tPrice = new SimpleStringProperty(tPrice);
        this.tPriceX = new SimpleStringProperty(tPriceX);
    }


    public String gettID() {
        return tID.get();
    }

    public SimpleStringProperty tIDProperty() {
        return tID;
    }

    public void settID(String tID) {
        this.tID.set(tID);
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

    public String gettPriceX() {
        return tPriceX.get();
    }

    public SimpleStringProperty tPriceXProperty() {
        return tPriceX;
    }

    public void settPriceX(String tPriceX) {
        this.tPriceX.set(tPriceX);
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


}
