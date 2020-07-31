package Classes;

public class Client {
    private ContactInfo contactInfo;
    private Reservation reservation;
    private int groupSize;
    private boolean urgent;

    public Client(int groupSize, boolean urgent){
        this.groupSize = groupSize;
        this.urgent = urgent;
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
        this.reservation.computePrice();
    }
}
