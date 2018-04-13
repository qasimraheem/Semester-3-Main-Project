package productAPI;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Result{

    @SerializedName("Data")
    @Expose
    private List<Data> data = null;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

}