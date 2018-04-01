package com.chillyfacts.com;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result{

    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("Data")
    @Expose
    private Data data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}