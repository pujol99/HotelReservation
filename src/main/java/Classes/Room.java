package Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Room {

    //Variables
    private int capacity;
    private int roomNumber;
    private Map<LocalDate, Reservation> reservations = new HashMap<>();

    //Constructor
    public Room(){}

    public Room(int capacity, int roomNumber){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    //Functions
    public void bookRoom(LocalDate day, Reservation reservation){
        reservations.put(day, reservation);
    }

    public boolean isBooked(LocalDate day){
        return reservations.containsKey(day);
    }

    public void cancelBooking(LocalDate day){
        reservations.remove(day);
    }

    public boolean currentlyBooked(){
        return reservations.containsKey(LocalDate.now());
    }

    public Client currentClient(){
        if(currentlyBooked() == true)
            return reservations.get(LocalDate.now()).getClient();
        return null;
    }

    public void showNextDays(int nDays){
        for(int i = 0; i < nDays; i++){
            LocalDate day = LocalDate.now().plusDays(i);
            System.out.print(day.toString() + ": ");
            if(isBooked(day)){
                System.out.println(reservations.get(day).getClient().getContactInfo().getFullName());
            }else{
                System.out.println("Free");
            }
        }
    }

    public boolean isFree(LocalDate from, LocalDate to){
        List<LocalDate> days = getDatesBetween(from, to);
        for(LocalDate day : days){
            if(isBooked(day))
                return false;
        }
        return true;
    }

    private List<LocalDate> getDatesBetween(LocalDate from, LocalDate to){
        long numOfDays = ChronoUnit.DAYS.between(from, to);

        List<LocalDate> dates = Stream.iterate(from, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        return dates;
    }

    //Getters
    public int getCapacity() {
        return capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Map<LocalDate, Reservation> getReservations() {
        return reservations;
    }
}
