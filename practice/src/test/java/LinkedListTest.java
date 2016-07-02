import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    LinkedList list = new LinkedList("head node");

    @Test
    public void testHeadNode() {
        assertEquals("head node", list.head.data);
    }
}
