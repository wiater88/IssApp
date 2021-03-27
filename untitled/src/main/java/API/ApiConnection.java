package API;

import API.FuturePosition.Message;
import API.FuturePosition.Response;
import API.PeopleInSpace.People;
import API.PeopleInSpace.PeopleInSpace;
import API.PositionNow.PositionNow;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ApiConnection {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public ApiConnection() {
    }

    public void getLocationNow() throws IOException {
        PositionNow positionNow = PositionNow.getPosition();
        timeConverter(positionNow.getTimestamp());
        System.out.println(positionNow.getIss());
    }

    public void getLocationPasses(int lat, int lon) throws IOException {
        URL url1 = new URL("http://api.open-notify.org/iss-pass.json?lat="+lat+"&lon="+lon);
        ObjectMapper op1 = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);

        try {
            Message msg = op1.readValue(url1,Message.class);
            System.out.println("Z pyzycji " + lat + "'' " + lon + "'' - Stacje bedzie widac o nastepujacych porach: \n");
            for (Response reps: msg.getResponseList()) {
                reps.timeConverter(reps.getRiseTime());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPeopleInSpace() throws IOException {
        URL url2 = new URL("http://api.open-notify.org/astros.json");
        ObjectMapper op2 = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);

        PeopleInSpace peopleInSpace = op2.readValue(url2,PeopleInSpace.class);
        System.out.println("Na stacji jest aktualnie : " + peopleInSpace.getNumberPeoplesInSpace() + " ludzi");
        int counter = 1;
        for (People p : peopleInSpace.getPeopleList()){
            System.out.println(counter +".- " + p.getName());
            counter++;
        }
    }

    public void timeConverter (String timestamp){
        Long time = Long.valueOf(timestamp);

        Date date = new Date(time*1000);
        DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        System.out.println("Data: " + df.format(date));
    }

    public void currentSpeed (String lat1, String lat2, String lon1, String lon2, String time1, String time2){
        double dz=12756.274;//srednica Ziemi na rowniku [km]
        //double a,b;
        float lati1 = Float.valueOf(lat1);
        float lati2 = Float.valueOf(lat2);
        float long1 = Float.valueOf(lon1);
        float long2 = Float.valueOf(lon2);


        double a =(long2-long1)*Math.cos(lati1*Math.PI/180);
        double b=(lati2-lati1);
        double wynik = Math.sqrt(a*a+b*b)*Math.PI*dz/360;

        // Link https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lati2 - lati1);
        double lonDistance = Math.toRadians(long2 - long1);
        double a1 = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lati1)) * Math.cos(Math.toRadians(lati2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a1), Math.sqrt(1 - a1));
        double distance = R * c; // convert to meters R * c * 1000



        distance = Math.pow(distance, 2);

        double wynik2 = Math.sqrt(distance);


        //Obliczanie prędkości na podstawie dystatnu oraz odstępu czasu pomiędzy pomiarami
        long times = Long.valueOf(time2) - Long.valueOf(time1); // w minutach
        double speed = (3_600 * wynik2)/times; //

        System.out.printf("\n Prędkość stacji wynosi = %.2f km/h", speed);
        System.out.println("");
        System.out.println("");


    }


}




