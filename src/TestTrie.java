/**
 * Created by zhuol on 4/9/2015.
 */
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
    }
}