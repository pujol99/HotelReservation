package Classes;

public class ContactInfo {
    private String phoneNumber;
    private String fullName;
    private String direction;
    private String identification;

    public ContactInfo(String phoneNumber, String fullName, String direction, String identification) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.direction = direction;
        this.identification = identification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
