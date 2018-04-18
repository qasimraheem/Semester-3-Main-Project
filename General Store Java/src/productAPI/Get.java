package productAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import org.json.JSONArray;


//Read more: http://javarevisited.blogspot.com/2013/02/how-to-convert-json-string-to-java-object-jackson-example-tutorial.html#ixzz5BPS9fWNa

public class Get{

//    public static void main(String[] args) {
//        try {
//            List<Data> d = new ArrayList<>();
//            d=Get.get();
//            System.out.println(d.size());
//            for(int i=0;i<d.size();i++)
//                System.out.println(d.get(0).getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static List<Data> get() throws Exception {
        String url = "http://localhost:8080";
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
        Result result = gson.fromJson(response.toString(), Result.class);
        List<Data> d = new ArrayList<>();
        if (result != null){
            JSONArray jsonArray =new JSONArray(result.getData()) ;
            d=result.getData();
            System.out.println(d.get(0).getBuyPrice());
            System.out.println("done");
        }
        return d;




//        JSONObject myResponse = new JSONObject(fir.toString());
//        System.out.println(myResponse);
//        System.out.println("running");
//        System.out.println("result after Reading JSON Response");
//        //System.out.println("Data- "+fir.getString("Data"));
//        System.out.println("Id- "+fir.getString("Id"));
//        System.out.println("Name- "+myResponse.getString("Name"));
//        System.out.println("Symbol- "+myResponse.getString("Symbol"));
//        System.out.println("Rank- "+myResponse.getString("Rank"));

    }




}