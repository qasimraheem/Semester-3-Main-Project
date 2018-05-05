package BillAPI;

import com.google.gson.Gson;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bill_Get {

//    public static void main(String[] args) {
//        try {
//            List<Bill_Data> d = new ArrayList<>();
//            d=Bill_Get.get();
//            System.out.println(d.size());
//            for(int i=0;i<d.size();i++)
//                System.out.println(d.get(0).getBillid());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Bill_Data> get() throws Exception {
        String url = "http://localhost:8082";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println("response="+response);
        System.out.println("response.toString()="+response.toString());
        Gson gson = new Gson();
        Bill_Result result = gson.fromJson(response.toString(), Bill_Result.class);
        List<Bill_Data> d = new ArrayList<>();
        if (result != null){
            JSONArray jsonArray =new JSONArray(result.getData()) ;
            d=result.getData();
            System.out.println(d.get(0).getTotalitems());
            System.out.println("done");
        }
        return d;
    }

}
