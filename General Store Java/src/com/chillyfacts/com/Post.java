package com.chillyfacts.com;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.*;





public class Post{
    public static void main(String[] args) {
        try {
            Post.uploadToServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void call_me2() throws Exception {
        Data d=new Data();
        d.setName("aloo");
        d.setQuantity("1000");
        d.setBuyprice("2000");
        d.setSellprice("3000");
        String data=("{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyprice()+"\",\"SellPrice\":\""+d.getSellprice()+"\"}");
        System.out.println("data="+data);



//
//
//
//
//
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

    private static JSONObject uploadToServer() throws IOException, JSONException {
        String query = "http://localhost:8080/post";
        Data d=new Data();
        d.setName("aloo");
        d.setQuantity("1000");
        d.setBuyprice("2000");
        d.setSellprice("3000");
        String json = "{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyprice()+"\",\"SellPrice\":\""+d.getSellprice()+"\"}";

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