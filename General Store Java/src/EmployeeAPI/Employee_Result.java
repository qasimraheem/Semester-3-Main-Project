package EmployeeAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee_Result {
    @SerializedName("Data")
    @Expose
    private List<Employee_Data> employeeData = null;

    public List<Employee_Data> getData() {
        return employeeData;
    }

    public void setData(List<Employee_Data> employeeData) {
        this.employeeData= employeeData;
    }
}
