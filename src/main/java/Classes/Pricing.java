package Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pricing {

    public static double monthPrice(LocalDate day){
        int month = day.getMonth().getValue();
        double price = 0.f;
        switch (month) {
            case 2:
            case 3:
            case 4:
                price = 35;
                break;
            case 5:
            case 9:
                price = 45;
                break;
            case 6:
            case 7:
            case 8:
                price = 60;
                break;
            case 1:
            case 10:
            case 11:
            case 12:
                price = 40;
                break;
        }
        return price;
    }

    public static double capacityPrice(Room room){
        int capacity = room.getCapacity();
        double price = 0.f;
        if(capacity <= Hotel.MIN_CAPACITY + 1)
            price = 0.9;
        else if(capacity >= Hotel.MAX_CAPACITY - 1)
            price = 1.1;
        else
            price = 1.0;
        return price;
    }

    public static double roomTypePrice(Room room){
        double price = 0.f;
        switch (room.getType()){
            case BASIC:
                price = 1.0f;
                break;
            case KITCHEN:
                price = 1.3;
                break;
            case SUPERIOR:
                price = 1.6;
                break;
        }
        return price;
    }

    public static double computeFinalPrice(Reservation reservation){
        double price = 0.f;
        List<LocalDate> days = getDatesBetween(reservation.getFrom(), reservation.getTo());
        for(LocalDate day : days){
            price += monthPrice(day);
        }
        price *= roomTypePrice(reservation.getRoom());
        price *= capacityPrice(reservation.getRoom());
        return price;
    }

    private static List<LocalDate> getDatesBetween(LocalDate from, LocalDate to){
        long numOfDays = ChronoUnit.DAYS.between(from, to);

        List<LocalDate> dates = Stream.iterate(from, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        return dates;
    }
}
