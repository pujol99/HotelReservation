package Classes;

import java.time.LocalDate;

public class Reservation {
    private LocalDate from, to;
    private Client client;
    private Room room;
    private double price;

    //Constructor
    public Reservation(LocalDate from, LocalDate to, Client client, Room room){
        this.from = from;
        this.to = to;
        this.room = room;
        this.client = client;

        room.bookRoom(from, to, this);

        client.setReservation(this);
    }

    //Functions
    public double reservationPricing(){
        int days = from.compareTo(to);
        return 0.f;
    }

    public void computePrice(){
        price = Pricing.computeFinalPrice(this);
    }

    public String toString(){
        return "Reservation from: " + client.getContactInfo().getFullName() + "\n" +
        "From: " + from.toString() + " to: " + to.toString() + "\n" +
        "With a price of: " + price + "\n" +
        "For room: " + room.getRoomNumber() + "\n";
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

    public double getPrice(){
        return price;
    }
}
