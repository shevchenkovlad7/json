package country;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static Yahoo.Main.performRequest;

/**
 * Created by vlad on 04.06.16.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        String request = "{\n" +
                "    \"name\": \"Vsevolod\",\n" +
                "    \"surname\": \"Ievgiienko\",\n" +
                "    \"phones\": [\"044-256-78-90\", \"066-123-45-67\"],\n" +
                "    \"sites\": [\"http://site1.com\", \"http://site2.com\"],\n" +
                "    \"address\": {\n" +
                "         \"country\": \"UA\",\n" +
                "         \"city\": \"Kyiv\",\n" +
                "         \"street\": \"abcd\"\n" +
                "    }\n" +
                "}";
        String result = request;
        //System.out.println(result.toString());
        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result,JSON.class);




        }




    }
}
