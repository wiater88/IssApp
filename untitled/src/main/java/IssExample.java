import API.ApiConnection;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class IssExample {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public static void main(String[] args) throws IOException {
        ApiConnection api = new ApiConnection();

        api.getLocationNow();
        api.getLocationPasses(51,44);
        api.getPeopleInSpace();



    }
}