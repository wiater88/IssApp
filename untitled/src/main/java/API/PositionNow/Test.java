package API.PositionNow;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        ObjectMapper op = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);

        PositionNow p = op.readValue(url, PositionNow.class);

    }

    }

