import java.util.*;

public class Receiver {

    Map<Integer, Message> receivedMessages = new HashMap<>();

    public List<Integer> receive(List<Message> messages) throws ReceiveException {
        if (messages.isEmpty()) {
            throw new ReceiveException("messages is empty!");
        }
        messages.stream()
                .peek(m -> System.out.println("received message: " + m))
                .forEach(m -> receivedMessages.put(m.getId(), m));

        List<Integer> allIds = new ArrayList<>(messages.get(0).getIds());

        Set<Integer> receivedIds = receivedMessages.keySet();

        allIds.removeAll(receivedIds);

        return allIds;
    }

}
