package Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import org.json.JSONArray;
import java.util.Map;
import java.util.LinkedHashMap;
import java.net.URLEncoder;

//Read more: http://javarevisited.blogspot.com/2013/02/how-to-convert-json-string-to-java-object-jackson-example-tutorial.html#ixzz5BPS9fWNa

public class Search{

    public static void main(String[] args) {
        try {
            Data d=new Data();
            List<Data> res = new ArrayList<>();
            d.setName("apples");
            res = Search.search(d);
            System.out.println(res.get(0).getName()+res.get(0).getQuantity());
            System.out.println(res.get(1).getName()+res.get(1).getQuantity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  List<Data> search(Data searchdata) throws Exception {

        System.out.println(searchdata.getName());
        Map <String,Object> params = new LinkedHashMap<>();
        StringBuilder postData = new StringBuilder();
        if (searchdata.getName() != ""&& searchdata.getQuantity()!="" && searchdata.getBuyPrice()!="" && searchdata.getSellPrice()!=""){

            params.put("name", searchdata.getName());
            params.put("quantity", searchdata.getQuantity());
            params.put("buyprice", searchdata.getBuyPrice());
            params.put("sellprice", searchdata.getSellPrice());

        }else if (searchdata.getQuantity()!="" && searchdata.getBuyPrice()!="" && searchdata.getSellPrice()!=""){

            params.put("quantity", searchdata.getQuantity());
            params.put("buyprice", searchdata.getBuyPrice());
            params.put("sellprice", searchdata.getSellPrice());

        }else if (searchdata.getName() != "" && searchdata.getBuyPrice()!="" && searchdata.getSellPrice()!=""){

            params.put("name", searchdata.getName());
            params.put("buyprice", searchdata.getBuyPrice());
            params.put("sellprice", searchdata.getSellPrice());

        }else if (searchdata.getName() != ""&& searchdata.getQuantity()!="" && searchdata.getSellPrice()!=""){

            params.put("name", searchdata.getName());
            params.put("quantity", searchdata.getQuantity());
            params.put("sellprice", searchdata.getSellPrice());

        }else if (searchdata.getName() != ""&& searchdata.getQuantity()!="" && searchdata.getBuyPrice()!=""){

            params.put("name", searchdata.getName());
            params.put("quantity", searchdata.getQuantity());
            params.put("buyprice", searchdata.getBuyPrice());

        }else if ( searchdata.getBuyPrice()!="" && searchdata.getSellPrice()!=""){

            params.put("buyprice", searchdata.getBuyPrice());
            params.put("sellprice", searchdata.getSellPrice());

        }else if (searchdata.getQuantity()!="" && searchdata.getSellPrice()!=""){


            params.put("quantity", searchdata.getQuantity());
            params.put("sellprice", searchdata.getSellPrice());

        }else if ( searchdata.getQuantity()!="" && searchdata.getBuyPrice()!=""){

            params.put("quantity", searchdata.getQuantity());
            params.put("buyprice", searchdata.getBuyPrice());

        }else if (searchdata.getName() != "" && searchdata.getSellPrice()!=""){
            params.put("name", searchdata.getName());
            params.put("sellprice", searchdata.getSellPrice());
        }else if (searchdata.getName() != ""&& searchdata.getBuyPrice()!="" && searchdata.getSellPrice()!=""){

            params.put("name", searchdata.getName());
            params.put("buyprice", searchdata.getBuyPrice());

        }else if (searchdata.getName() != ""&& searchdata.getQuantity()!=""){

            params.put("name", searchdata.getName());
            params.put("quantity", searchdata.getQuantity());
        }else if (searchdata.getName() != null){
            System.out.println("hahahhahahhahahah");

            params.put("name", searchdata.getName());

        }else if ( searchdata.getQuantity()!=""){

            params.put("quantity", searchdata.getQuantity());

        }else if ( searchdata.getBuyPrice()!="" ){

            params.put("buyprice", searchdata.getBuyPrice());

        }else if (searchdata.getSellPrice()!=""){
            params.put("sellprice", searchdata.getSellPrice());

        }else{
            
        }



        for (Map.Entry <String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        String url = "http://localhost:8080/search?"+postData;
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