package GUI.BillAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bill_Post {


//    public static void main(String[] args) {
//        try {
//            Bill_Data data=new Bill_Data();
//            data.setBillid("tahseen");
//            data.setTotalitems("23");
//            data.setTotalprice("2000");
//            data.setDate("3000");
//            List<Bill_ProductData> billProductData = new ArrayList<>();
//            Bill_ProductData[] b=new Bill_ProductData[3];
//            for(int i=0;i<3;i++){
//                b[i]=new Bill_ProductData(""+i,""+i,""+i,""+i);
//                billProductData.add(b[i]);
////                billProductData.set(i),.setName("name"+i));
////                billProductData.get(i).setName("name"+i);
////                billProductData.get(i).setQuantity("quantity"+i);
////                billProductData.get(i).setBuyPrice("buy"+i);
////                billProductData.get(i).setSellPrice("sell"+i);
//            }
//            data.setProductData(billProductData);
//            Bill_Post.post(data);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void call_me2() throws Exception {
//        Bill_Data d=new Bill_Data();
//        d.setBillid("aloo");
//        d.setQuantity("1000");
//        d.setBuyPrice("2000");
//        d.setSellPrice("3000");
//        String data=("{\"Name\":\""+d.getName()+"\",\"Quantity\":\""+d.getQuantity()+"\",\"BuyPrice\":\""+d.getBuyPrice()+"\",\"SellPrice\":\""+d.getSellPrice()+"\"}");
//        System.out.println("data="+data);
//
////        String response = sb.toString();
////        System.out.println(response);
////        JSONObject myResponse = new JSONObject(response.toString());
////        System.out.println("result after Reading JSON Response");
////        System.out.println("origin- "+myResponse.getString("origin"));
////        System.out.println("url- "+myResponse.getString("url"));
////        JSONObject form_data = myResponse.getJSONObject("form");
////        System.out.println("CODE- "+form_data.getString("CODE"));
////        System.out.println("email- "+form_data.getString("email"));
////        System.out.println("message- "+form_data.getString("message"));
////        System.out.println("name"+form_data.getString("name"));
//        }
//
        public static JSONObject post(Bill_Data d) throws IOException, JSONException {
            String query = "http://localhost:8082/post";
//        Data d=new Data();

            System.out.println(d.getTotalitems()+d.getBillid());
            String json = "{\"Id\":\""+d.getBillid()+"\",\"TotalItems\":\""+d.getTotalitems()+"\",\"TotalPrice\":\""+d.getTotalprice()+"\",\"Date\":\""+d.getDate()+"\",\"Product\":[";
            if(d.getProductData().size()==1){
                json=json+"{\"Name\":\""+d.getProductData().get(0).getName()+"\",\"Quantity\":\""+d.getProductData().get(0).getQuantity()+"\",\"BuyPrice\":\""+d.getProductData().get(0).getBuyPrice() +"\",\"SellPrice\":\""+d.getProductData().get(0).getSellPrice()+"\"}]}";
            }else{
                for (int i = 0; i < d.getProductData().size(); i++){
                    json=json+"{\"Name\":\""+d.getProductData().get(i).getName()+"\",\"Quantity\":\""+d.getProductData().get(i).getQuantity()+"\",\"BuyPrice\":\""+d.getProductData().get(i).getBuyPrice() +"\",\"SellPrice\":\""+d.getProductData().get(i).getSellPrice()+"\"}";
                    if(i<d.getProductData().size()-1){
                        json=json+",";
                    }else{
                        json=json+"]}";
                    }
                }

            }

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
