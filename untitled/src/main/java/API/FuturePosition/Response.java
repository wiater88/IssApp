package API.FuturePosition;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Response {


    @JsonProperty("duration")
    private String duration;

    @JsonProperty("risetime")
    private String riseTime;


    public Response(String duration, String riseTime) {
        this.duration = duration;
        this.riseTime = riseTime;
    }

    public Response() {
    }

    public void getFutureLocation(int latitude, int longitude) throws MalformedURLException {
        URL url1 = new URL("http://api.open-notify.org/iss-pass.json?lat="+latitude+"&lon="+longitude);
        ObjectMapper op1 = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);

        try {
            Message msg = op1.readValue(url1,Message.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void timeConverter (String timestamp) {
        Long time = Long.valueOf(timestamp);

        Date date1 = new Date(time * 1000);
        Date date = new Date(time * 1000);
        DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        System.out.println("Data: " + df.format(date));
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRiseTime() {
        return riseTime;
    }

    public void setRiseTime(String riseTime) {
        this.riseTime = riseTime;
    }

    @Override
    public String toString() {
        return
                "duration= " + duration + "\n" +
                "riseTime= " + riseTime + "\n" ;

    }
}
