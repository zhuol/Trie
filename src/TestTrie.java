/**
 * Created by zhuol on 4/9/2015.
 */
import static java.lang.System.*;

public class TestTrie {
    public static void main(String[] args) {
        Trie T = new Trie();

        T.insert("google");
        T.insert("goblet");
        T.insert("yahoo");
        T.insert("");
        // T.insert("go");

        T.search("google");
        T.search("goblets");
        T.search("go");
        T.search("blah");
        T.search("");

        Thread t=Thread.currentThread();
        out.println(t);
        t.setName("Fuckit");
        out.println(t);
        try {
            for(int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}