package API.PositionNow;


import com.fasterxml.jackson.annotation.JsonProperty;


public class iss_position {

    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;

    public iss_position(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public iss_position(){

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

    @Override
    public String toString() {
        return "Polozenie Stacji ISS " +
                "\n Szerokosc geograficzna: " + latitude + '\'' +
                "\n Długość geograficzna : " + longitude + '\'';
    }
}
