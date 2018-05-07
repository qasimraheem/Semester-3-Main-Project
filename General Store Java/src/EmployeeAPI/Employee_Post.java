package EmployeeAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Employee_Post {

//    public static void main(String[] args) {
//        try {
//            Employee_Data data=new Employee_Data();
//            data.setUsername("tahseen");
//            data.setPassword("12345678");
//            data.setImage("C:/Users/qasim/Desktop/user_yellow.jpg");
//            Employee_Post.post(data);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

        public static JSONObject post(Employee_Data d) throws IOException, JSONException {
            String query = "http://localhost:8081/post";
//        Data d=new Data();

            System.out.println(d.getUsername()+d.getPassword());
            String json = "{\"UserName\":\""+d.getUsername()+"\",\"Password\":\""+d.getPassword()+"\",\"Image\":\""+d.getImage()+"\"}";
            System.out.println(json);
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            JSONObject jsonObject = new JSONObject(result);


            in.close();
            conn.disconnect();

            return jsonObject;
        }
}
