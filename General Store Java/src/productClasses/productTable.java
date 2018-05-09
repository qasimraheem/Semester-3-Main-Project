package productClasses;

import javafx.beans.property.SimpleStringProperty;

public class productTable {




    private final SimpleStringProperty tQuantity;
    private final SimpleStringProperty tBuyPrice;
    private final SimpleStringProperty tSalePrice;

    public productTable(String tName, String tQuantity, String tBuyPrice, String tSalePrice) {
        this.tName = new SimpleStringProperty(tName);
        this.tQuantity = new SimpleStringProperty(tQuantity);
        this.tBuyPrice = new SimpleStringProperty(tBuyPrice);
        this.tSalePrice = new SimpleStringProperty(tSalePrice);
    }


    private final SimpleStringProperty tName;

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

    public String gettBuyPrice() {
        return tBuyPrice.get();
    }

    public SimpleStringProperty tBuyPriceProperty() {
        return tBuyPrice;
    }

    public void settBuyPrice(String tBuyPrice) {
        this.tBuyPrice.set(tBuyPrice);
    }

    public String gettSalePrice() {
        return tSalePrice.get();
    }

    public SimpleStringProperty tSalePriceProperty() {
        return tSalePrice;
    }

    public void settSalePrice(String tSalePrice) {
        this.tSalePrice.set(tSalePrice);
    }


}
