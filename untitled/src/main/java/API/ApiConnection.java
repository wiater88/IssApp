package API;

import API.PositionNow.PositionNow;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;


public class ApiConnection {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public ApiConnection() {
    }

    public void getLocationNow() throws IOException {
        PositionNow positionNow = PositionNow.getPosition();
        System.out.println(positionNow.getIss());
        System.out.println(positionNow.getTimestamp());
    }

    public void getLocationPasses(int lat, int lon) throws IOException {
        String sql = "http://api.open-notify.org/iss-pass.json?lat=" + lat + "&lon=+" + lon;
        Request request = new Request.Builder()
                .url(sql)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    public void getPeopleInSpace() throws IOException {
        String API = "http://api.open-notify.org/astros.json";
        Request request = new Request.Builder()
                .url(API)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }


}




