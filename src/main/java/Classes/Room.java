package Classes;

import java.time.LocalDate;
import java.util.*;

public class Room {

    //Variables
    private int capacity;
    private int roomNumber;
    private Map<LocalDate, Reservation> reservations;

    //Constructor
    public Room(){}

    public Room(int capacity, int roomNumber){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    //Functions
    public void bookRoom(LocalDate day){

    }

    //Getters/Setters



}
