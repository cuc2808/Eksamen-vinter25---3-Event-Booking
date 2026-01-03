import java.util.Date;

public abstract class Event {

    public String name;
    public Date date;
    public int price;
    public int maxCapacity;
    public int bookedTickets;

    public Event(String name, Date date, int price, int maxCapacity, int bookedTickets) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.maxCapacity = maxCapacity;
        this.bookedTickets = bookedTickets;
    }

    public void addBooking() {

    }

    public boolean isSoldOut() {
        return bookedTickets >= maxCapacity;
    }

    // GETTERs AND SETTERs

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(int bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    //    public String getInfo(String info){
//
//
//    }
}
