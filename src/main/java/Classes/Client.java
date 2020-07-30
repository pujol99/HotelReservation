package Classes;

import java.time.LocalDate;

public class Client {
    private String[] contactInfo;
    private int id;
    private Reservation reservation;

    public Client(int id){
        this.id = id;
    }

    public String[] getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String[] contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
