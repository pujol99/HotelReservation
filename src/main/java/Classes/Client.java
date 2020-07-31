package Classes;

import java.time.LocalDate;

public class Client {
    private ContactInfo contactInfo;
    private Reservation reservation;
    private int groupSize;

    public Client(int groupSize){
        this.groupSize = groupSize;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getGroupSize(){
        return groupSize;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
