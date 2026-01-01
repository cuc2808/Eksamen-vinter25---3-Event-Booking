import java.util.Date;

public class WorkShop extends Event {

    public String instructor;
    public String topic;
    public boolean materials;

    public WorkShop(String name, Date date, int price, int maxCapacity, int bookedTickets, String instructor, String topic, boolean materials) {
        super(name, date, price, maxCapacity, bookedTickets);
        this.instructor = instructor;
        this.topic = topic;
        this.materials = materials;
    }

    // GETTERs AND SETTERs

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isMaterials() {
        return materials;
    }

    public void setMaterials(boolean materials) {
        this.materials = materials;
    }
}
