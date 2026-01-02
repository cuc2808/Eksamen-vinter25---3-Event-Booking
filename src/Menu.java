public class Menu {

    EventManager manager;
    UI ui;

    public Menu(){
        manager = new EventManager();
        ui = new UI();

    }

    public void startMenu(){
        while(true) {
            System.out.println("Welcome to the EventManger/BookingSide.COM");

            manager.printSummary();

            System.out.println("What would you like to do? Press any of the following numbers.");

            System.out.println("1. Book tickets");
            System.out.println("2. Create events");

            int input = ui.userIntInput();

            if (input == 1) {
                bookingMenu();
            } else if (input == 2) {

            }

        }
    }

    private void bookingMenu() {
        String input;
        int intInput;
        System.out.println("What event would you like to book tickets for?");
        while(true) {
            input = ui.userStringInput();
            if(manager.eventList.containsKey(input) && !manager.eventList.get(input).isSoldOut()) {
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
        while(true) {
            String input = ui.userStringInput();
            if (input.toUpperCase() == "WORKSHOP") {
                System.out.println("Please enter the name of the event:");
                String name = ui.userStringInput();
                System.out.println("Please enter the name of the date:");
                System.out.println("- Year(must be exact year):");
                int year = (ui.userYearInput() - 1900);
                int month = (ui.userMonthInput());
                int day = (ui.userDayInput());
                double time = (ui.userTimeInput());


                manager.createWorkShopEvent(name, date, price, maxCapacity, instructor, topic, materials);

                return;
            } else if (input.toUpperCase() == "CONCERT") {
                manager.createConcertEvent();

                return;
            } else {
                System.out.println("Invalid answer, please try again.");
            }
        }



    }
}
