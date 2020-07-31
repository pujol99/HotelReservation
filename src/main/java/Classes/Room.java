package Classes;

import java.time.LocalDate;
import java.util.*;

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
