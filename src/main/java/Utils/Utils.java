package Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static List<LocalDate> getDatesBetween(LocalDate from, LocalDate to){
        long numOfDays = ChronoUnit.DAYS.between(from, to);

        List<LocalDate> dates = Stream.iterate(from, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        return dates;
    }
}
