import Classes.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hotel myHotel = new Hotel(5);

        Client me = new Client(3);
        ContactInfo contactInfo = new ContactInfo(
                "743578357",
                "Alex Pujol Comet",
                "08027",
                "244X");
        me.setContactInfo(contactInfo);

        Client me2 = new Client(3);
        ContactInfo contactInfo2 = new ContactInfo(
                "743578357",
                "Elsa Pujol Comet",
                "08027",
                "244X");
        me2.setContactInfo(contactInfo2);

        Room room = myHotel.bookRoom(me, LocalDate.now(), LocalDate.now().plusDays(3));
        Room room2 = myHotel.bookRoom(me2, LocalDate.now().plusDays(5), LocalDate.now().plusDays(8));

        if(room != null)
            room.showNextDays(10);
    }

}
