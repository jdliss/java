public class LinkedList {
    public Node head;

    public LinkedList() {
        System.out.println("LinkedList constructor called");
    }

    public void insert(String data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else if (this.head.next == null) {
            this.head.next = new Node(data);
        } else {
            insert(data, this.head.next);
        }
    }

    public void insert(String data, Node currentNode) {
        if (currentNode.next == null) {
            currentNode.next = new Node(data);
        } else {
            insert(data, currentNode.next);
        }
    }

    public void print() {
        System.out.println(this.head.data);

        if (this.head.next != null) {
            print(this.head.next);
        }
    }

    public void print(Node currentNode) {
        System.out.println(currentNode.data);

        if (currentNode.next != null) {
            print(currentNode.next);
        }
    }

    public Node find(String input) {
        if (this.head.data == input) {
            return this.head;
        } else {
            return find(input, this.head.next);
        }
    }

    public Node find(String input, Node currentNode) {
        if (currentNode.data == input) {
            return currentNode;
        } else {
            return find(input, currentNode.next);
        }
    }

    public Boolean delete(String input) {
        if (this.head.data == input) {
            this.head = this.head.next;
            return true;
        } else {
            return delete(input, this.head.next);
        }
    }

    public Boolean delete(String input, Node currentNode) {
        if (currentNode.data == input) {
            Node newNode = new Node(input);
            findParent(newNode).next = currentNode.next;
            return true;
        } else {
            return delete(input, currentNode.next);
        }
    }

    public Node findParent(Node node) {
        if (this.head == node) {
            return null;
        } else {
            return findParent(node, this.head);
        }
    }

    public Node findParent(Node node, Node currentNode) {
        if (currentNode.next == node) {
            return currentNode;
        } else if (currentNode.next != null){
            return findParent(node, currentNode.next);
        } else {
            return null;
        }
    }

    public static void main(String []args) {
        LinkedList ll = new LinkedList();

        ll.insert("head node");
        ll.insert("node 1");
        ll.insert("node 2");

        ll.print();

        Node head = ll.find("head node");
        System.out.println("Found: " + head.data);

        Node node1 = ll.find("node 1");
        System.out.println("Found: " + node1.data);

        Node node2 = ll.find("node 2");
        System.out.println("Found: " + node2.data);

        if (ll.delete("head node")) {
            System.out.println("Head node deleted!");
        } else {
            System.out.println("something went wrong");
        }

        if (ll.delete("node 1")) {
            System.out.println("node 1 deleted!");
        } else {
            System.out.println("something went wrong");
        }

        if (ll.delete("node 2")) {
            System.out.println("node 2 deleted!");
        } else {
            System.out.println("something went wrong");
        }
    }
}
