import java.util.*;

/**
 * Common inputhandler class to handle inputs from the user
 *
 * @author MMZ
 * @version 1.0
 * @since 2018-11-12
 */
public class InputHandler {
    /**
     * Get integer input from user
     *
     * @return int input from user
     */
    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        boolean continueInput;
        int number = 0;

        do {
            continueInput = false;
            try {
                number = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Try again. An integer is required");
                scan.nextLine();
                continueInput = true;
            }
        } while (continueInput);

        scan.nextLine();

        return number;
    }

    /**
     * Get line input from user
     *
     * @return string input
     */
    public static String getLine() {
        Scanner scan = new Scanner(System.in);
        String string, choice;
        Boolean valid1, valid2;
        do {
            valid1 = true;
            string = scan.nextLine();
            if (string.equals("")) {
                System.out.println("Are you sure you want to input an empty string? (Y or N)");
                do {
                    choice = scan.nextLine();
                    if (choice.equals("Y") || choice.equals("y")) {
                        valid2 = true;
                        valid1 = true;
                    } else if (choice.equals("N") || choice.equals("n")) {
                        System.out.println("Please enter the required string again:");
                        valid2 = true;
                        valid1 = false;
                    } else {
                        System.out.println("Please input Y or N.");
                        valid2 = false;
                    }
                } while (!valid2);
            }
        } while (!valid1);

        return string;
    }
}