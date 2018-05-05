package EmployeeAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Employee_Put {

    public static void main(String[] args) {

        try {
            Employee_Data d=new Employee_Data();
            Employee_Data up=new Employee_Data();

            //old data
            d.setUsername("tahseen");
            d.setPassword("12345678");
            d.setImage("C:/Users/qasim/Desktop/user_yellow.jpg");

            //new data
            up.setUsername("qasim");
            up.setPassword("13936");
            up.setImage("C:/Users/qasim/Desktop/b.jpg");


            Employee_Put.put(d,up);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void call_me2() throws Exception {
            Employee_Data d=new Employee_Data();
            d.setUsername("");
            d.setPassword("");
            d.setImage("");

            String data=("{\"UserName\":\""+d.getUsername()+"\",\"Password\":\""+d.getPassword()+"\",\"Image\":\""+d.getImage()+"\"}");
            System.out.println("data="+data);

        }

        public static void put(Employee_Data oldData, Employee_Data newData) throws IOException, JSONException {
            String query = "http://localhost:8081/update";
            Employee_Data d=oldData;
            Employee_Data up=newData;

            System.out.println(d.getUsername()+d.getPassword());

            String json = "{\"Data\": [{\"UserName\":\""+d.getUsername()+"\",\"Password\":\""+d.getPassword()+"\",\"Image\":\""+d.getImage()+"\"},{\"UserName\":\""+up.getUsername()+"\",\"Password\":\""+up.getPassword()+"\",\"Image\":\""+up.getImage()+"\"}]}";

            System.out.println(json);
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("PUT");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            JSONObject jsonObject = new JSONObject(result);


            in.close();
            conn.disconnect();

            //return jsonObject;
        }
}
