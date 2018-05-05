package GUI.BillAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bill_ProductData {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Quantity")
    @Expose
    private String quantity;
    @SerializedName("BuyPrice")
    @Expose
    private String buyprice;
    @SerializedName("SellPrice")
    @Expose
    private String sellprice;

    public Bill_ProductData() {
    }
    public Bill_ProductData(String name, String quantity, String buyprice, String sellprice) {
        this.name = name;
        this.quantity = quantity;
        this.buyprice = buyprice;
        this.sellprice = sellprice;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }


    public String getSellPrice() {
        return sellprice;
    }

    public String getBuyPrice() {
        return buyprice;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setBuyPrice(String buyprice) {
        this.buyprice = buyprice;
    }

    public void setSellPrice(String sellprice) {
        this.sellprice = sellprice;
    }



}
