import Classes.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hotel myHotel = new Hotel(5);

        myHotel.automateSystem(3, 0, 4, "Alex");
        myHotel.automateSystem(3, 1, 3, "Rick");
        myHotel.automateSystem(3, 5, 7, "John");

        for(Room room : myHotel.getRooms()){
            System.out.println("------------------------------");
            System.out.println("\tCapacity: " + room.getCapacity() + " | Id: " + room.getRoomNumber());
            room.showNextDays(10);

        }
    }



}
