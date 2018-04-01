package com.chillyfacts.com;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import org.json.JSONObject;


//Read more: http://javarevisited.blogspot.com/2013/02/how-to-convert-json-string-to-java-object-jackson-example-tutorial.html#ixzz5BPS9fWNa

public class Send_HTTP_Request2 {
    public static void main(String[] args) {
        try {
            Send_HTTP_Request2.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {
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
        //Read JSON response and print
        //JSONObject myResponse = new JSONObject(response.toString());
        JSONObject fir = new JSONObject(response.toString());
        System.out.println(fir);
        Gson gson = new Gson();
        Result result = gson.fromJson(response.toString(),Result.class);
        if (result != null){
            Data d = result.getData();
            System.out.println(result.getSuccess()+"-"+d.getId() + "-" + d.getName() + "-" + d.getRank() + "-" + d.getSymbol());
            System.out.println("done");
        }






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