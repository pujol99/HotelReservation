import Classes.*;
import Utils.*;

public class Main {
    public static void main(String[] args) {

        Hotel myHotel = new Hotel(6);

        myHotel.automateSystem(3, 0, 4, "Alex");
        myHotel.automateSystem(3, 1, 3, "Rick");
        myHotel.automateSystem(3, 5, 7, "John");

        Utils.printnl(myHotel.toString());

        Utils.printnl(myHotel.getClients().get(0).toString());
    }



}
