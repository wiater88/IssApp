package API;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class ApiConnection {
        private final static String BASE_URL = "http://api.open-notify.org/iss-pass.json?lat=51&lon=25";

        public static void main(String[] args) throws IOException {
            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Call call = client.newCall(request);
            Response response = call.execute();
            System.out.println(response.body().string());
        }


    }


