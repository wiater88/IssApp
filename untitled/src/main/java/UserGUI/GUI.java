package UserGUI;

import API.ApiConnection;
import API.PositionNow.PositionNow;

import java.io.IOException;
import java.util.Scanner;

public class GUI {

    Scanner scanner;

    public GUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        ApiConnection api = new ApiConnection();
        PositionNow positionNow1 = PositionNow.getPosition();
        System.out.println("Witaj urzykowniku w Aplikacji do sledzenia stacji kosmicznej ISS");
        while(true){
            System.out.println("");
            System.out.println("Wybierz jedna z ponizszych opcji : " +
                    "\n 1. - Akualne polozenie stacji ISS" +
                    "\n 2. - Polozenie stacji wg pozycji geograficznej" +
                    "\n 3. - Akutalny stan zalogi na stacji ISS" +
                    "\n q. - Nacisnij q alby przerwac dzialanie");
            System.out.println("");
            String anwser = scanner.nextLine();
            if (anwser.equals("q")){
                System.out.println("Do szybkiego zobaczenia kosmiczny odkrywco");
                break;

            }
            if (anwser.equals("1")){
                System.out.println("aktualne poloznie stacji to : ");
                PositionNow positionNow2 = PositionNow.getPosition();
                api.getLocationNow();
                api.currentSpeed(positionNow1.getIss().getLatitude(),positionNow2.getIss().getLatitude(),positionNow1.getIss().getLongitude(),positionNow2.getIss().getLongitude(),positionNow1.getTimestamp(),positionNow2.getTimestamp());

            }
            if (anwser.equals("2")){
                System.out.println("Podaj szerokosc geograficzna: ");
                int latitude = Integer.valueOf(scanner.nextLine());
                System.out.println("Podaj dlugosc geograficzna");
                int longitude = Integer.valueOf(scanner.nextLine());
                api.getLocationPasses(latitude,longitude);


            }
            if (anwser.equals("3")){

                api.getPeopleInSpace();
            }


        }

    }
}
