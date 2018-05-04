package GUI.billAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductData {

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


