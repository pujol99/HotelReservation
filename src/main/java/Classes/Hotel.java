package Classes;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private List<Client> clients;
    private List<Reservation> reservations;
    private Random rand = new Random();
    public static int MAX_CAPACITY = 6;

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
        Room room = getHotelRoom(client.getGroupSize(), from, to, client.isUrgent());
        if(room == null)
            return null;
        client.setReservation(new Reservation(from, to, client, room));
        return room;
    }

    public void createRooms(int roomSize){
        for(int i = 0; i < roomSize; i++)
            rooms.add(new Room(rand.nextInt(4)+2, i));

    }

    public Room getHotelRoom(int capacity, LocalDate from, LocalDate to, boolean urgent){
        for(Room room : rooms){
            if(room.getCapacity() == capacity && room.isFree(from, to))
                return room;
        }
        if(urgent && capacity <= MAX_CAPACITY)
            return getHotelRoom(capacity+1, from, to, true);
        return null;
    }

    public void automateSystem(int capacity, int from, int to, String name){
        Client me = new Client(capacity, true);
        ContactInfo contactInfo = new ContactInfo(
                "",
                name,
                "",
                "");
        me.setContactInfo(contactInfo);

        bookRoom(me, LocalDate.now().plusDays(from), LocalDate.now().plusDays(to));
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
            System.out.println("\tBooked by: " + room.currentClient().getContactInfo().getFullName());
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
