import java.util.Date;

public class Concert extends Event {

    public String artist;
    public String genre;

    public Concert(String name, Date date, int price, int maxCapacity, int bookedTickets, String artist, String genre) {
        super(name, date, price, maxCapacity, bookedTickets);
        this.artist = artist;
        this.genre = genre;
    }


    // GETTERs AND SETTERs

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
