/**
 * Created by zhuol on 4/10/2015.
 */
/**
 * Created by zhuol on 4/10/2015.
 */
import java.util.concurrent.ArrayBlockingQueue;

class BlockingQueue implements Runnable{

    private final ArrayBlockingQueue<Trie> queue;

    public BlockingQueue(ArrayBlockingQueue<Trie> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            produce();
        }
    }

    public void produce(){
        try {
            Trie trie = new Trie();
            queue.put(trie);
            System.out.println("Producer:"+trie);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    private final ArrayBlockingQueue<Trie> queue;

    public Consumer(ArrayBlockingQueue<Trie> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            consume();
        }
    }

    public void consume(){
        try {
            Trie trie = queue.take();
            System.out.println("consumer:"+trie);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Client {

    public static void main(String[] args) {
        new Thread(new BlockingQueue(queue)).start();
        new Thread(new BlockingQueue(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    private static int capacity = 10;
    private static ArrayBlockingQueue<Trie> queue = new ArrayBlockingQueue<Trie>(capacity);
}