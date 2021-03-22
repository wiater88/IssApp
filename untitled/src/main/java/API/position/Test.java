package API.position;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        ObjectMapper op = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);

        Position p = op.readValue(url,Position.class);
        System.out.println(p);
    }
}
