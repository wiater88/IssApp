package UserGUI;

import API.ApiConnection;

import java.io.IOException;
import java.util.Scanner;

public class GUI {

    Scanner scanner;

    public GUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        ApiConnection api = new ApiConnection();
        System.out.println("Witaj urzykowniku w Aplikacji do sledzenia stacji kosmicznej ISS");
        while(true){
            System.out.println("Wybierz jedna z ponizszych opcji : " +
                    "\n 1. - Akualne polozenie stacji ISS" +
                    "\n 2. - Polozenie stacji wg pozycji geograficznej" +
                    "\n 3. - Akutalny stan zalogi na stacji ISS" +
                    "\n q. - Nacisnij q alby przerwac dzialanie");
            String anwser = scanner.nextLine();
            if (anwser.equals("q")){
                System.out.println("Do szybkiego zobaczenia kosmiczny odkrywco");
                break;

            }
            if (anwser.equals("1")){
                System.out.println("aktualne poloznie stacji to : ");
                api.getLocationNow();
            }
            if (anwser.equals("2")){
                System.out.println("stacje z x , y bedzie widac ");

            }
            if (anwser.equals("3")){
                System.out.println("na stacji akutalnie znajduje sie : ");
                api.getPeopleInSpace();
            }


        }

    }
}
