public class ValidationCheck {

    public ValidationCheck() {
    }

    /**
     * Run through validation checks to determine if the phone number is valid or
     * not.
     * 
     * @param phoneNumber
     * @return
     */
    public ValidationResult validatePhone(String phoneNumber) {
        ValidationResult result = new ValidationResult();

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            result.setResultMessage("No phone number present");
            result.setVerified(false);

            return result;
        }
        // remove non-digits/chars
        String strippedPhone = phoneNumber.replaceAll("[()\\s.-]", "");

        // check that the number lenth is 10
        if (strippedPhone.length() != 10) {
            result.setResultMessage("Phone number is too long.");
            result.setVerified(false);
            return result;
        }

        // Verify that each character is a digit.
        for (char c : strippedPhone.toCharArray()) {
            // if the character we're looking at is not a digit - isVerified = false
            if (!Character.isDigit(c)) {
                result.setResultMessage("Phone number does NOT contain only digits.");
                result.setVerified(false);

                return result;
            }
        }

        result.setResultMessage("Phone Number is Valid");
        result.setVerified(true);
        return result;
    }

}
