package billClasses;

import javafx.beans.property.SimpleStringProperty;

public class BillDetail_Table {
    private final SimpleStringProperty tName;
    private final SimpleStringProperty tQuantity;
    private final SimpleStringProperty tPrice;


    public BillDetail_Table(String tName, String tQuantity, String tPrice) {
        this.tName = new SimpleStringProperty(tName);
        this.tQuantity = new SimpleStringProperty(tQuantity);
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

    public String gettQuantity() {
        return tQuantity.get();
    }

    public SimpleStringProperty tQuantityProperty() {
        return tQuantity;
    }

    public void settQuantity(String tQuantity) {
        this.tQuantity.set(tQuantity);
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
