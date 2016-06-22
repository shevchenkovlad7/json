package Yahoo;

import Yahoo.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vlad on 03.06.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String request = "http://query.yahooapis.com/v1/public/yql?format=json&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        String result = performRequest(request);
        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result,JSON.class);// получаем обьектное представление Yahoo.JSON-a, передаем нашу стоку и класс


        for (Rate rate : json.query.results.rate) {
            System.out.println(rate.id + "=" + rate.Rate+ " Name"+rate.Name);
        }
   }

    public static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }
    }

