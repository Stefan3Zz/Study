import Utils.AddressUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

/**
 * Created by 15714 on 2018/12/4.
 */
public class test {

    public static void main(String[] args) throws IOException {
        Gson gson =new Gson();
        String s=gson.toJson(AddressUtils.readJsonfrom(), AddressUtils.Country.class);
      AddressUtils.Country country=gson.fromJson(s, AddressUtils.Country.class);
        System.out.println(country);
        System.out.println(s);

    }
}
