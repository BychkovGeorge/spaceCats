import java.util.List;

public class Message {
    Integer id;
    List<Integer> ids;

    public Message(Integer id, List<Integer> ids) {
        this.id = id;
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", ids=" + ids +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getIds() {
        return ids;
    }
}
