package Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

public class Reservation {
    private LocalDate from, to;
    private Client client;
    private Room room;

    public Reservation(LocalDate from, LocalDate to, Client client, Room room){
        this.from = from;
        this.to = to;
        this.room = room;
        this.client = client;

        for(LocalDate day : getDatesBetween(from, to)){
            room.bookRoom(day, this);
        }

        client.setReservation(this);
    }

    private List<LocalDate> getDatesBetween(LocalDate from, LocalDate to){
        long numOfDays = ChronoUnit.DAYS.between(from, to);

        List<LocalDate> dates = Stream.iterate(from, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        return dates;
    }

    //getters

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }
}
