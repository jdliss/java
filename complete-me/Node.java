import java.util.HashMap;

class Node {
    public Boolean endOfWord;
    public HashMap<Character, Node> children;

    public Node() {
        this.endOfWord = false;
        this.children = new HashMap<Character, Node>();
    }
}
