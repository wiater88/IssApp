package API.position;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {

    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("message")
    private String message;
    @JsonProperty("iss_position")
    iss_position issposition;

    public Position(long timestamp, iss_position issposition,String message) {
        this.timestamp = timestamp;
        this.issposition = issposition;
        this.message = message;
    }
    public Position (){

    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
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
        return "Position{" +
                "timestamp=" + timestamp +
                ", issposition=" + issposition +
                '}';
    }
}
