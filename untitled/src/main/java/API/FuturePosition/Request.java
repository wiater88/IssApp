package API.FuturePosition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty("altitude")
    private String altitude;

    @JsonProperty("datetime")
    private String dateTime;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("passes")
    private String passes;

    public Request(String altitude, String dateTime, String latitude, String longitude, String passes) {
        this.altitude = altitude;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.passes = passes;
    }

    public Request() {
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPasses() {
        return passes;
    }

    public void setPasses(String passes) {
        this.passes = passes;
    }

    @Override
    public String toString() {
        return "";
    }
}
