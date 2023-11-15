/**
 * Class which contains validation methods
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Validation {
    /**
     * Default constructor which creates the object of the class Validation.
     *
     */
    public Validation() {

    }

    /**
     * To check whether the input is a valid id either a valid option.
     *
     * @param inputString A String to be validated.
     * @return Whether the input string is empty
     *         and if the input is valid as boolean.
     */
    public boolean isValidLocationId(String inputString) {
        if (this.isEmptyInput(inputString))
            return false;
        if ((inputString.matches("[1, 2 ,3, 4, 5, 6, 7, 8, 9]") || inputString.equals("10"))
                || inputString.equalsIgnoreCase("B"))
            return true;
        else {
            System.out.print("\033\143");
            System.out.println("\nInvalid Input ! Please choose 1 - 10 or B!");
            return false;
        }
    }

    /**
     * To check if the area's name satisfies the requirements.
     *
     * @param inputString A String to be validated.
     * @return Whether the input string is empty and
     *         if it satisfies the requirements as boolean.
     */
    public boolean isValidAreaName(String inputString) {
        if (this.isEmptyInput(inputString)) {
            return false;
        } else if (inputString.length() > 16) {
            System.out.print("\033\143");
            System.out.println("\nArea name can't be more than 16 characters!");
            return false;
        } else if (!this.isAlphabic(inputString)) {
            System.out.print("\033\143");
            System.out.println("\nArea name can contain only alphabetic characters\n" +
                    "and please don't contain any space!");
            return false;
        }
        return true;
    }

    /**
     * To check if the input is a valid option or not.
     *
     * @param inputString A String to be validated.
     * @return Whether the input string is empty
     *         and if the input is valid as boolean.
     */
    public boolean isValidOption(String inputString) {
        if (this.isEmptyInput(inputString))
            return false;
        if (inputString.matches("[1, 2 ,3]"))
            return true;
        else {
            System.out.println("\nInvalid Input ! Please choose 1 - 3!");
            return false;
        }
    }

    /**
     * To check if the input is empty or not.
     *
     * @param inputString A String to be validated.
     * @return Whether the input is empty as boolean.
     */
    public boolean isEmptyInput(String inputString) {
        if (inputString == "\n" || inputString.isBlank()) {
            System.out.print("\033\143");
            System.out.println("\nERROR! Your input can't be empty!");
            return true;
        }
        return false;
    }

    /**
     * To check if the input String contains only letter or not.
     *
     * @param inputString A String to be validated.
     * @return Whether the input contains only letter as boolean.
     */
    public boolean isAlphabic(String inputString) {
        for (int index = 0; index < inputString.length(); index++) {
            char currentChar = inputString.charAt(index);
            if (!Character.isLetter(currentChar)) {
                return false;
            }
        }
        return true;
    }

    /**
     * To check if the input String contains only numeric or not.
     *
     * @param inputString A String to be validated.
     * @return Whether the input contains only digit as boolean.
     */
    public boolean isNumeric(String inputString) {
        if (this.isEmptyInput(inputString)) {
            return false;
        }
        // To check if the character of the String is a digit
        for (int index = 0; index < inputString.length(); index++) {
            char currentChar = inputString.charAt(index);
            if (!Character.isDigit(currentChar)) {
                System.out.println("\nInvalid Input ! Please enter number only!");
                return false;
            }
        }
        return true;
    }
}