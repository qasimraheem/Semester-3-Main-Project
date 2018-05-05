package GUI.BillAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bill_Result {
    @SerializedName("Data")
    @Expose
    private List<Bill_Data> billData = null;

    public List<Bill_Data> getData() {
        return billData;
    }

    public void setData(List<Bill_Data> billData) {
        this.billData= billData;
    }
}
