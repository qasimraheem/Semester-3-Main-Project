package GUI.billAPI;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Id")
    @Expose
    private String billId;
    @SerializedName("TotalItems")
    @Expose
    private String totalitems;
    @SerializedName("TotalPrice")
    @Expose
    private String totalprice;
    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Product")
    @Expose
    private List<ProductData> productdata= null;

    public List<ProductData> getData() {
        return productdata;
    }

    public void setData(List<ProductData> productdata) {
        this.productdata = productdata;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return billId;
    }

    public String getQuantity() {
        return totalitems;
    }


    public String getSellPrice() {
        return totalprice;
    }

    public String getBuyPrice() {
        return date;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.billId = name;
    }

    public void setQuantity(String quantity) {
        this.totalitems = quantity;
    }

    public void setBuyPrice(String buyprice) {
        this.totalprice = buyprice;
    }

    public void setSellPrice(String sellprice) {
        this.date = sellprice;
    }



}

