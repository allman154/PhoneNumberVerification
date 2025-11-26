public class StaffMember {
    private String firstName;
    private String lastName;
    // We assume phoneNumber is a STRING to test for validation - 
    // assuming the user was provided a simple text box and could type anything. 
    private String phoneNumber;
    private int idNumber;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public StaffMember() {
    }
    
}
