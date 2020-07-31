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

        Room room = myHotel.bookRoom(me, LocalDate.now(), LocalDate.now().plusDays(3));
        if(room != null){
            System.out.println(room.currentClient().getContactInfo().getFullName());
        }
    }
}
