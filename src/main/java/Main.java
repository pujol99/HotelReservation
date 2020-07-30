import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calendar myCalendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
        Date today = myCalendar.getTime();
        System.out.println(today.getTime());
    }
}
