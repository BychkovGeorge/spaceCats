import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Sender {
    private Integer credits = 18;
    private List<Message> messages;

    public Sender() {
        List<Integer> ids = IntStream.rangeClosed(1, 5).boxed().collect(toList());
        messages = ids.stream().map(id -> new Message(id, ids)).collect(toList());
    }

    public boolean sendToChannel(Channel channel) {
        while (true) {
            System.out.println("=======================================================================");
            credits -= messages.size();
            if (credits < 0) {
                System.out.println("no more money!");
                return false;
            }
            try {
                List<Integer> notReceivedIds = channel.send(new ArrayList<>(messages));
                if (notReceivedIds.isEmpty()) {
                    System.out.println("completed!");
                    return true;
                }
                System.out.println(notReceivedIds);
                messages.removeIf(m -> !notReceivedIds.contains(m.getId()));
            } catch (ReceiveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
