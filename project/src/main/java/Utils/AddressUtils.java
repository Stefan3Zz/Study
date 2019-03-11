package Utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by 15714 on 2018/12/4.
 */
public class AddressUtils {
    private static String readAll(BufferedReader rd) throws IOException {
       StringBuilder sb=new StringBuilder();
       String line;
       while ((line=rd.readLine())!=null){
           sb.append(line);
       }
       return sb.toString();
   }

    public static Country readJsonfrom() throws IOException {
       final String IP="220.181.51.125";
        Country country=new Country();
        InputStream is=new URL("https://api.map.baidu.com/location/ip?ak=UQvnP10qVYoleucLRlIsr5D1V7tGAe2C&ip="+IP).openStream();
      try {
          BufferedReader rd=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText=readAll(rd);
          JsonObject obj= new JsonParser().parse(jsonText).getAsJsonObject();
          String province=obj.get("content").getAsJsonObject().get("address_detail").getAsJsonObject().get("province").getAsString();
          String city=obj.get("content").getAsJsonObject().get("address_detail").getAsJsonObject().get("city").getAsString();
          String district=obj.get("content").getAsJsonObject().get("address_detail").getAsJsonObject().get("district").getAsString();
          country.setCity(city);
          country.setProvince(province);
          country.setDistrict(district);
          return country;
      }finally {
          is.close();
      }
    }

    public static class Country{
        private String province;
        private String city;
        private String district;

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

}
