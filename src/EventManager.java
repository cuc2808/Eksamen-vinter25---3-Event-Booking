import java.util.ArrayList;
import java.util.HashMap; //TreeMap did it better!
import java.util.Date;
import java.util.TreeMap;

public class EventManager {

    public TreeMap<String, Event> eventList = new TreeMap<>();

    // ======================================================================================

    public void printSummary(){
        System.out.println("=== Event Overview ===");
        eventList.keySet().forEach(String);

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

    public void addEvent(String eventName, Event event) {
        eventList.put(eventName,event);
    }

    public void bookTicket(String eventName) {
        if(!eventList.get(eventName).isSoldOut()) {
            eventList.get(eventName).bookedTickets++;
            System.out.println("Booked ticket/s, document sent to phone number, please show upon arrival.");
        } else {
            System.out.println("No tickets can be booked, the event is sold out.");
        }
    }


    //mmmmmm Java script lookin nice.
    public void getMostPopular(TreeMap<String, Event> list) {
        TreeMap<Integer, String> amountBookedList = new TreeMap<>();

        //eventList.values().forEach()
        eventList.keySet().forEach((String) -> {
            amountBookedList.put(eventList.get(String).bookedTickets, String);
        });

        System.out.println("Den mest populære event er: " + amountBookedList.get(amountBookedList.lastKey()) + " med " + amountBookedList.lastKey() + " tickets solgt!");
    }
}
