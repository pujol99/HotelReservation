package Classes;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private List<Client> clients;
    private List<Reservation> reservations;
    public static int MAX_CAPACITY = 6;
    public static int MIN_CAPACITY = 2;
    private enum RoomType {BASIC, KITCHEN, SUPERIOR};

    private Random rand = new Random();

    public Hotel(int roomSize){
        rooms = new ArrayList<>();
        clients = new ArrayList<>();
        reservations = new ArrayList<>();

        createRooms(roomSize);
    }

    public Room bookRoom(Client client, LocalDate from, LocalDate to){
        //make reservation for client with no reservation
        Room room = getHotelRoom(client.getGroupSize(), from, to, client.isUrgent());
        if(room == null)
            return null;

        Reservation r = new Reservation(from, to, client, room);
        client.setReservation(r);
        r.computePrice();
        reservations.add(r);

        return room;
    }

    public void createRooms(int roomSize){
        for(int i = 0; i < roomSize; i++)
            rooms.add(new Room(rand.nextInt(MAX_CAPACITY-MIN_CAPACITY+1)+2, i, Enums.RoomType.BASIC));

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
        Client c = new Client(capacity, true);
        ContactInfo contactInfo = new ContactInfo(
                "",
                name,
                "",
                "",
                "");
        c.setContactInfo(contactInfo);
        clients.add(c);

        bookRoom(c, LocalDate.now().plusDays(from), LocalDate.now().plusDays(to));
    }

    public void showRooms(){
        for(Room room : rooms){
            System.out.print(room.getRoomNumber());
            System.out.println("\tCapacity: " + room.getCapacity());
            System.out.println("\tBooked now: " + room.isBookedIn(LocalDate.now()));
        }
    }

    public void showBookedRooms(){
        for(Room room : rooms){
            if(room.isBookedIn(LocalDate.now()) == false)
                continue;
            System.out.print(room.getRoomNumber());
            System.out.println("\tCapacity: " + room.getCapacity());
            System.out.println("\tBooked by: " + room.currentClient().getContactInfo().getFullName());
        }
    }

    public String toString(){
        String content = "";
        for(Room room : rooms){
            content += "------------------------------" + "\n";
            content += "\tCapacity: " + room.getCapacity() + " | Id: " + room.getRoomNumber() + "\n";
            content += room.toString(5) + "\n";
        }
        return content;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client c){
        clients.add(c);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
