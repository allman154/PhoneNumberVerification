public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Phone Number Validation Check for Staff.");
        // Populate Staff Listing.
        Staff staff = new Staff();
        staff.populateStaffInformation();

        // Create new instance of ValidationCheck class to process phone numbers.
        ValidationCheck valCheck = new ValidationCheck();

        //Loop through each staff member and run the validation check, printing the results. 
        for (StaffMember sm : staff.getStaffList()) {
            System.out.println("\nValidating Phone Number for USER: " 
                                + sm.getFirstName() + " " + sm.getLastName() + " - ID: " + sm.getIdNumber());
            ValidationResult validationResult = valCheck.validatePhone(sm.getPhoneNumber());
            System.out.println("Valid: " + validationResult.isVerified());
            System.out.println("Reason: " + validationResult.getResultMessage());
        }
    }
}
