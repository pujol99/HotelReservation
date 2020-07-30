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
