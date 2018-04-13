package productAPI;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import org.json.*;





public class Delete{
    public static void main(String[] args) {
        try {
            Data d=new Data();
            d.setName("tahseen");
            d.setQuantity("1000");
            d.setBuyPrice("2000");
            d.setSellPrice("3000");
            Delete.delete(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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

    private static JSONObject delete(Data delete) throws IOException, JSONException {
        String query = "http://localhost:8080/remove";
        Data d = delete;

        //        Data d=new Data();
//        d.setName("");
//        d.setQuantity("");
//        d.setBuyPrice("");
//        d.setSellPrice("");
        System.out.println(d.getBuyPrice()+d.getSellPrice());
        String json = "{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyPrice()+"\",\"SellPrice\":\""+d.getSellPrice()+"\"}";
        System.out.println(json);
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("DELETE");

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