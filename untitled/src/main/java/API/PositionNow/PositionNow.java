package API.PositionNow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class PositionNow {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("message")
    private String message;

    @JsonProperty("iss_position")
    iss_position issposition;

    public PositionNow(String timestamp, iss_position issposition, String message) {
        this.timestamp = timestamp;
        this.issposition = issposition;
        this.message = message;
    }
    public PositionNow(){

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public iss_position getIss() {
        return issposition;
    }

    public void setIss(iss_position issposition) {
        this.issposition = issposition;
    }

    @Override
    public String toString() {
        return "Position :" +
                issposition.toString() + "Czas " + this.timestamp;

    }

    public static PositionNow getPosition() throws IOException {
        URL url = new URL("http://api.open-notify.org/iss-now.json");
        ObjectMapper op = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);

        PositionNow p = op.readValue(url, PositionNow.class);
        return p;

    }


}
