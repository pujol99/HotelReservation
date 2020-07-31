package Classes;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private List<Client> clients;
    private List<Reservation> reservations;
    private Random rand = new Random();

    public Hotel(int roomSize){
        rooms = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();

        createRooms(roomSize);
    }

    public Hotel(){
        rooms = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public Room bookRoom(Client client, LocalDate from, LocalDate to){
        //make reservation for client with no reservation
        Room room = getHotelRoom(client.getGroupSize());
        if(room == null)
            return null;
        client.setReservation(new Reservation(from, to, client, room));
        return room;
    }

    public void createRooms(int roomSize){
        for(int i = 0; i < roomSize; i++)
            rooms.add(new Room(rand.nextInt(4)+2, i));

    }

    public Room getHotelRoom(int capacity){
        for(Room room : rooms){
            if(room.getCapacity() == capacity)
                return room;
        }
        return null;
    }

    public void showRooms(){
        for(Room room : rooms){
            System.out.print(room.getRoomNumber());
            System.out.println("\tCapacity: " + room.getCapacity());
            System.out.println("\tBooked now: " + room.currentlyBooked());
        }
    }

    public void showBookedRooms(){
        for(Room room : rooms){
            if(room.currentlyBooked() == false)
                continue;
            System.out.print(room.getRoomNumber());
            System.out.println("\tCapacity: " + room.getCapacity());
            System.out.println("\tBooked by: " + room.currentClient());
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
