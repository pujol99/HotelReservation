package Classes;

import Utils.Utils;

import java.time.LocalDate;
import java.util.*;

public class Client {
    private ContactInfo contactInfo;
    private Reservation reservation;
    private int groupSize;
    private boolean urgent;

    public Client(int groupSize, boolean urgent){
        this.groupSize = groupSize;
        this.urgent = urgent;
    }

    public void cancelBooking(){
        Room room = reservation.getRoom();
        List<LocalDate> days = Utils.getDatesBetween(reservation.getFrom(), reservation.getTo());
        for(LocalDate day : days)
            room.cancelBooking(day);
    }

    public String toString(){
        if (reservation == null)
            return "Client: {" + getContactInfo().getFullName() + ", " + getContactInfo().getPhoneNumber() + "}\n";

        return "Client: " + getContactInfo().getFullName() + "\n" +
                "with reservation: " + reservation.toString() + "\n";
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

    public boolean isUrgent(){
        return urgent;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
