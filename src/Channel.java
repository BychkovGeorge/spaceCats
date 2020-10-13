import java.util.List;
import java.util.Random;

public class Channel {
    private Receiver receiver;

    public Channel(Receiver receiver) {
        this.receiver = receiver;
    }

    public List<Integer> send(List<Message> messages) throws ReceiveException {
        messages.removeIf(m -> isBroken());
        List<Integer> notReceivedIds = receiver.receive(messages);
        if (isBroken()) {
            throw new ReceiveException("channel result error!");
        }
        return notReceivedIds;
    }

    private boolean isBroken() {
        Random r = new Random();
        double random = r.nextDouble();
        return random <= 0.327651345438;
    }


}
