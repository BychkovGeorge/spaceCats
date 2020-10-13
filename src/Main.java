import java.util.HashMap;
import java.util.Map;

public class Main {

    //я смоделировал алгоритм отправления сообщения 100000 раз и за вероятность взял отношение успехов к общему числу случаев
    //верного ответа получить не удалось :( Но я думаю, что я немного не до конца понял условие, и здесь присутствует какая-то небольшая тонкость, которую я не уловил
    //в целом я уверен, что общая идея моего метода верна

    public static void main(String[] args) {
        Map<Boolean, Integer> counter = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            Sender sender = new Sender();
            Receiver receiver = new Receiver();
            Channel channel = new Channel(receiver);
            counter.merge(sender.sendToChannel(channel), 1, Integer::sum);
        }
        System.out.print((double) counter.get(true) / (counter.get(false) + counter.get(true)));
    }
}
