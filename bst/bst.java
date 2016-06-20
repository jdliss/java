class BST {
    public Node root;

    public BST(String name, int score) {
        this.root = new Node(name, score);
    }

    public void insert(String name, int score) {
        if (this.root.score > score) {
            if (this.root.lchild == null) {
                this.root.lchild = new Node(name, score);
            } else {
                insert(name, score, this.root.lchild);
            }
        } else {
            if (this.root.rchild == null) {
                this.root.rchild = new Node(name, score);
            } else {
                insert(name, score, this.root.rchild);
            }
        }
    }

    public void insert(String name, int score, Node currentNode) {
        if (currentNode.score > score) {
            if (currentNode.lchild == null) {
                currentNode.lchild = new Node(name, score);
            } else {
                insert(name, score, currentNode.lchild);
            }
        } else {
            if (currentNode.rchild == null) {
                currentNode.rchild = new Node(name, score);
            } else {
                insert(name, score, currentNode.rchild);
            }
        }
    }

    public Node find(String name, int score) {
        if (this.root.name == name && this.root.score == score) {
            return this.root;
        } else {
            if (this.root.score < score) {
                if (this.root.rchild == null) {
                    return null;
                } else {
                    return find(name, score, this.root.rchild);
                }
            } else {
                if (this.root.lchild == null) {
                    return null;
                } else {
                    return find(name, score, this.root.lchild);
                }
            }
        }
    }

    public Node find(String name, int score, Node currentNode) {
        if (currentNode.name == name && currentNode.score == score) {
            return currentNode;
        } else {
            if (currentNode.score < score ) {
                return currentNode.rchild == null ? null : find(name, score, currentNode.rchild);
            } else {
                return currentNode.lchild == null ? null : find(name, score, currentNode.lchild);
            }
        }
    }

    public Node update(String name, int score, String newName) {
        Node node = find(name, score);
        node.name = newName;
        return node;
    }

    public static void main(String []args) {
        BST bst = new BST("root node", 50);

        bst.insert("node 1", 60);
        bst.insert("node 2", 40);

        System.out.println(bst.root.name);
        System.out.println(bst.root.rchild.name);
        System.out.println(bst.root.lchild.name);

        Node root = bst.find("root node", 50);
        System.out.println("Name: " + root.name + ", Score: " + root.score);

        Node node1 = bst.find("node 1", 60);
        System.out.println("Name: " + node1.name + ", Score: " + node1.score);

        Node node2 = bst.find("node 2", 40);
        System.out.println("Name: " + node2.name + ", Score: " + node2.score);

        Node updated = bst.update("root node", 50, "new root node");
        System.out.println("Updated Node: " + updated.name);
    }
}

