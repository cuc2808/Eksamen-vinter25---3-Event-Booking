import java.util.Date;

public class Menu {

    EventManager manager;
    UI ui;

    public Menu() {
        manager = new EventManager();
        ui = new UI();

    }

    public void startMenu() {
        while (true) {
            System.out.println("Welcome to the EventManger/BookingSide.COM");

            manager.printSummary();

            System.out.println("What would you like to do? Press any of the following numbers.");

            System.out.println("1. Book tickets");
            System.out.println("2. Create events");
            System.out.println("3. Close application");

            int input = ui.userIntInput();

            if (input == 1) {
                bookingMenu();
            } else if (input == 2) {
                createMenu();
            } else if (input == 3) {
                System.out.println("Closing application...");
                ui.sleep(2000);
                return;
            }

        }
    }

    private void bookingMenu() {
        String input;
        int intInput;
        System.out.println("What event would you like to book tickets for?");
        while (true) {
            input = ui.userStringInput();
            if (manager.eventList.containsKey(input) && !manager.eventList.get(input).isSoldOut()) {
                int i = (manager.eventList.get(input).maxCapacity - manager.eventList.get(input).bookedTickets);
                System.out.println("There is " + i + " tickets left for this event.");
                System.out.println("How many tickets would you like to book?");
                intInput = ui.userIntInput();
                manager.bookTicket(input, intInput);

                return;
            } else if (manager.eventList.containsKey(input) && manager.eventList.get(input).isSoldOut()) {
                System.out.println("This event is sold out. No tickets can be booked.");
                ui.sleep(2000);

                return;
            }
            System.out.println("Invalid name. Try again.");
        }
    }

    public void createMenu() {
        System.out.println("Hello our dear welcome creator! :D");
        System.out.println("Please fill the information below as asked.");
        System.out.println("Is it a WorkShop or a Concert?");
        while (true) {
            String input = ui.userStringInput();
            if (input.toUpperCase().equals("WORKSHOP")) {
                System.out.println("Please enter the name of the event:");
                String name = ui.userStringInput();
                System.out.println("The following date must be quite precise to be used in countdowns.");
                System.out.println("Please follow the instructions:");
                System.out.println("- Type a Year(2026 and up):");
                int year = (ui.userYearInput() - 1900);
                System.out.println("- Type a Month(from 1-12");
                int month = (ui.userMonthInput());
                System.out.println("- Type a Day(from 1-28");
                int day = (ui.userDayInput());
                System.out.println("- Type the Hour(From 024");
                int hour = (ui.userHourInput());
                System.out.println("- Type the Minute(From 0-60");
                int minute = (ui.userMinuteInput());
                Date date = new Date(year, month, day, hour, minute);
                System.out.println("Now, how many people can attend the WorkShop?");
                int maxCapacity = ui.userIntInput();
                System.out.println("What's the price for a ticket:");
                int price = ui.userIntInput();
                System.out.println("What's the instructor's name?");
                String instructor = ui.userStringInput();
                System.out.println("Topic:");
                String topic = ui.userStringInput();
                System.out.println("Are the materials included for this WorkShop? (Y/N");
                boolean materials = ui.userBooleanInput();

                manager.createWorkShopEvent(name, date, price, maxCapacity, 0, instructor, topic, materials);
                return;

            } else if (input.toUpperCase().equals("CONCERT")) {
                //manager.createConcertEvent();
                System.out.println("Please enter the name of the event:");
                String name = ui.userStringInput();
                System.out.println("The following date must be quite precise to be used in countdowns.");
                System.out.println("Please follow the instructions:");
                System.out.println("- Type a Year(2026 and up):");
                int year = (ui.userYearInput() - 1900);
                System.out.println("- Type a Month(from 1-12)");
                int month = (ui.userMonthInput());
                System.out.println("- Type a Day(from 1-28)");
                int day = (ui.userDayInput());
                System.out.println("- Type the Hour(From 0-24)");
                int hour = (ui.userHourInput());
                System.out.println("- Type the Minute(From 0-60)");
                int minute = (ui.userMinuteInput());
                Date date = new Date(year, month, day, hour, minute);
                System.out.println("Now, how many people can attend the concert?");
                int maxCapacity = ui.userIntInput();
                System.out.println("What's the price for a ticket:");
                int price = ui.userIntInput();
                System.out.println("What's the artist's name?");
                String artist = ui.userStringInput();
                System.out.println("genre of music:");
                String genre = ui.userStringInput();

                manager.createConcertEvent(name, date, price, maxCapacity, 0, artist, genre);
                return;


            } else {
                System.out.println("Invalid answer, please try again.");
            }
        }


    }
}
