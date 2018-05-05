package BillAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bill_Data {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Id")
    @Expose
    private String billid;
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
    private List<Bill_ProductData> billProductData= null;

    public List<Bill_ProductData> getProductData() {
        return billProductData;
    }

    public void setProductData(List<Bill_ProductData> billProductData) {
        this.billProductData= billProductData;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

