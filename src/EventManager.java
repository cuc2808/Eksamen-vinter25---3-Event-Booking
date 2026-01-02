import java.util.ArrayList;
import java.util.HashMap; //TreeMap did it better!
import java.util.Date;
import java.util.TreeMap;

public class EventManager {

    public TreeMap<String, Event> eventList = new TreeMap<>();
    public ArrayList<Event> events = new ArrayList<>();

    // ======================================================================================

    public void printSummary(){
        System.out.println("=== Event Overview ===\n");
        eventList.keySet().forEach(String -> {
            if(eventList.get(String) instanceof Concert){
                String concertName = ((Concert) eventList.get(String)).getName();
                Date concertDate = ((Concert) eventList.get(String)).getDate();
                int price = ((Concert) eventList.get(String)).getPrice();
                int bookedTickets = ((Concert) eventList.get(String)).getBookedTickets();
                int maxCapacity = ((Concert) eventList.get(String)).getMaxCapacity();
                boolean status = ((Concert) eventList.get(String)).isSoldOut();
                String artist = ((Concert) eventList.get(String)).getArtist();
                String genre = ((Concert) eventList.get(String)).getGenre();
                System.out.println("Concert: " + concertName + " with " + artist + " [" + genre + "]");
                System.out.println("Date: " + concertDate);
                System.out.println("Price: " + price + " kr.");
                System.out.println("Booked: " + bookedTickets + "/" + maxCapacity + "tickets");
                if(status) {
                    System.out.println("Status: SOLD OUT" );
                } else {
                    System.out.println("Status: Available" );
                }
            }
        });

    }

    // ======================================================================================

    public void createConcertEvent(String name, Date date, int price, int maxCapacity, int bookedTickes, String artist, String genre) {
        Event concert = new Concert(name, date, price, maxCapacity, bookedTickes, artist, genre);
        eventList.put(name, concert);
        events.add(concert);
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
