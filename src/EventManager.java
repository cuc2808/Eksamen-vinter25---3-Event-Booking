import java.util.ArrayList;
import java.util.HashMap; //TreeMap did it better!
import java.util.Date;
import java.util.TreeMap;

public class EventManager {

    public TreeMap<String, Event> eventList = new TreeMap<>();
    public ArrayList<Event> events = new ArrayList<>();

    UI ui = new UI();

    public EventManager() {
        loadEvents();
    }

    // ======================================================================================

    public void printSummary() {
        System.out.println("=== Event Overview ===\n");
        eventList.keySet().forEach(String -> {
            if (eventList.get(String) instanceof Concert) {
                String concertName = ((Concert) eventList.get(String)).getName();
                Date concertDate = ((Concert) eventList.get(String)).getDate();
                int price = ((Concert) eventList.get(String)).getPrice();
                int bookedTickets = ((Concert) eventList.get(String)).getBookedTickets();
                int maxCapacity = ((Concert) eventList.get(String)).getMaxCapacity();
                boolean status = ((Concert) eventList.get(String)).isSoldOut();
                String artist = ((Concert) eventList.get(String)).getArtist();
                String genre = ((Concert) eventList.get(String)).getGenre();
                System.out.println("Concert: '" + concertName + "' with " + artist + " [" + genre + "]");
                System.out.println("Date: " + concertDate);
                System.out.println("Price: " + price + " kr.");
                System.out.println("Booked: " + bookedTickets + " / " + maxCapacity + " tickets");
                if (status) {
                    System.out.println("Status: SOLD OUT\n");
                } else {
                    System.out.println("Status: Available\n");
                }

            } else if (eventList.get(String) instanceof WorkShop) {
                String workShopName = ((WorkShop) eventList.get(String)).getName();
                Date workShopDate = ((WorkShop) eventList.get(String)).getDate();
                int price = ((WorkShop) eventList.get(String)).getPrice();
                int bookedTickets = ((WorkShop) eventList.get(String)).getBookedTickets();
                int maxCapacity = ((WorkShop) eventList.get(String)).getMaxCapacity();
                boolean materialsIncluded = ((WorkShop) eventList.get(String)).materialsIncluded();
                boolean status = ((WorkShop) eventList.get(String)).isSoldOut();
                String instructor = ((WorkShop) eventList.get(String)).getInstructor();
                String topic = ((WorkShop) eventList.get(String)).getTopic();
                System.out.println("WorkShop: '" + workShopName + "' with " + instructor + " [" + topic + "]");
                System.out.println("Date: " + workShopDate);
                System.out.println("Price: " + price + " kr.");
                System.out.println("Booked: " + bookedTickets + " / " + maxCapacity + " tickets");
                if (materialsIncluded) {
                    System.out.println("Materials included: Yes");
                } else {
                    System.out.println("Materials included: No");
                }
                if (status) {
                    System.out.println("Status: SOLD OUT\n");
                } else {
                    System.out.println("Status: Available\n");
                }

            }
        });
        getMostPopular();
    }

    // ======================================================================================

    public void createConcertEvent(String name, Date date, int price, int maxCapacity, int bookedTickes, String artist, String genre) {
        Event concert = new Concert(name, date, price, maxCapacity, bookedTickes, artist, genre);
        eventList.put(name, concert);
    }

    public void createWorkShopEvent(String name, Date date, int price, int maxCapacity, int bookedTickes, String instructor, String topic, boolean materials) {
        Event workShop = new WorkShop(name, date, price, maxCapacity, bookedTickes, instructor, topic, materials);
        eventList.put(name, workShop);
    }

    public void loadEvents() {
        createConcertEvent("The emptiness Machine", new Date(126, 1, 20, 20, 30), 399, 2000, 1399, "Linkin Park", "ROCK");
        createConcertEvent("Back in the ol' days", new Date(126, 2, 5, 20, 0), 449, 2000, 2000, "Queen", "POP");
        createWorkShopEvent("How To Draw a PERFECT Circle", new Date(126, 3, 15, 15, 30), 50, 10, 9, "Damian", "Arts & Crafts", false);
        createWorkShopEvent("The 10 principles of Epictetus", new Date(126, 2, 12, 19, 15), 129, 30, 30, "Shaun", "Philosophy, Stoicism", true);
    }

    public void addEvent(String eventName, Event event) {
        eventList.put(eventName, event);
    }

    public void bookTicket(String eventName, int amount) {
        if (!eventList.get(eventName).isSoldOut()) {
            int x = (eventList.get(eventName).maxCapacity - eventList.get(eventName).bookedTickets);
            if (amount <= (eventList.get(eventName).maxCapacity - eventList.get(eventName).bookedTickets)) {
                for (int i = 0; i < amount; i++) {
                    eventList.get(eventName).bookedTickets++;
                }
                System.out.println("Directing to purchase side...");
                ui.sleep(2000);
                System.out.println("Congratulations on your purchase!");
                ui.sleep(2000);
                System.out.println("The booked ticket/s has been sent to your phone number, please show upon arrival.");
                ui.sleep(3000);
            } else {
                System.out.println("That amount of tickets are unavailable.");
                ui.sleep(2000);
            }
        } else {
            System.out.println("No tickets can be booked, the event is sold out.");
            ui.sleep(3000);
        }
    }


    //mmmmmm Java script lookin nice.
    public void getMostPopular() {
        TreeMap<Integer, String> amountBookedList = new TreeMap<>();

        //eventList.values().forEach()
        eventList.keySet().forEach((String) -> {
            amountBookedList.put(eventList.get(String).bookedTickets, String);
        });

        System.out.println("The most popular event is: " + amountBookedList.get(amountBookedList.lastKey()) + " with " + amountBookedList.lastKey() + " tickets sold!");
    }
}
