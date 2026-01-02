import java.util.Scanner;

public class UI {


    public String userStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public int userIntInput() {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 0) {
                System.out.println("Invalid tal, prøv venligst igen.");
            } else {
                return userInput;
            }
        }
    }

    public int stringToInt(String string) {

        int integer = -1;

        try {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            integer = integer;
        }
        return integer;
    }

    public int userYearInput() {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 2026) {
                System.out.println("Invalid year, must be 2026 or higher.");
            } else {
                return userInput;
            }
        }
    }

    public int userMonthInput() {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 1 || userInput > 12) {
                System.out.println("Invalid month, must be between 1-12.");
            } else {
                return userInput;
            }
        }
    }

    public int userDayInput() {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 1 || userInput > 28) {
                System.out.println("Invalid month, must be between 1-28. No events may be held close to the end of the month.");
            } else {
                return userInput;
            }
        }
    }

    public double userTimeInput() {
        double userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 0 || userInput > 24) {
                System.out.println("Invalid TimeStamp, must be between 00.00-24.00.");
            } else {
                return userInput;
            }
        }
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
