package GUI.billAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Put{
//    public static void main(String[] args) {
//        try {
//            Data d=new Data();
//            Data up=new Data();
//
//            //old data
//            d.setName("windows_CD");
//            d.setQuantity("1000");
//            d.setSellPrice("2000");
//            d.setBuyPrice("300" +
//                    "0");
//            //new data
//            up.setName("dogy");
//            up.setQuantity("1000");
//            up.setSellPrice("2000");
//            up.setBuyPrice("3000");
//
//
//            Put.put(d,up);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static void call_me2() throws Exception {
        Data d=new Data();
        d.setName("");
        d.setQuantity("");
        d.setBuyPrice("");
        d.setSellPrice("");
        String data=("{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyPrice()+"\",\"SellPrice\":\""+d.getSellPrice()+"\"}");
        System.out.println("data="+data);

//        String response = sb.toString();
//        System.out.println(response);
//        JSONObject myResponse = new JSONObject(response.toString());
//        System.out.println("result after Reading JSON Response");
//        System.out.println("origin- "+myResponse.getString("origin"));
//        System.out.println("url- "+myResponse.getString("url"));
//        JSONObject form_data = myResponse.getJSONObject("form");
//        System.out.println("CODE- "+form_data.getString("CODE"));
//        System.out.println("email- "+form_data.getString("email"));
//        System.out.println("message- "+form_data.getString("message"));
//        System.out.println("name"+form_data.getString("name"));
    }

    public static void put(Data oldData, Data newData) throws IOException, JSONException {
        String query = "http://localhost:8080/update";
        Data d=oldData;
        Data up=newData;
        //        Data d=new Data();
//        d.setName("");
//        d.setQuantity("");
//        d.setBuyPrice("");
//        d.setSellPrice("");
        System.out.println(d.getBuyPrice()+d.getSellPrice());
        String json = "{\"Data\": [{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyPrice()+"\",\"SellPrice\":\""+d.getSellPrice()+"\"},{\"Name\":\""+up.getName()+"\",\"Quantity\":\""+up.getQuantity()+"\",\"BuyPrice\":\""+up.getBuyPrice()+"\",\"SellPrice\":\""+up.getSellPrice()+"\"}]}";
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