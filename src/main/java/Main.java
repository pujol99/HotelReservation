import Classes.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Calendar myCalendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
        Date today = myCalendar.getTime();*/

        Room testRoom = new Room(3, 101);
        Client testClient = new Client(0);

        Reservation reservation = new Reservation(LocalDate.now(), LocalDate.now().plusDays(4), testClient, testRoom);

        System.out.println(testRoom.isBooked(LocalDate.now().plusDays(5)));
    }
}
