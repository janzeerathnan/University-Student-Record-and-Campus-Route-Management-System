/** Binary Search Tree that orders student records by student ID. */
public class StudentBST {
    private Node root;
    private static class Node { Student value; Node left, right; Node(Student value) { this.value = value; } }

    public void insert(Student value) { root = insert(root, value); }
    private Node insert(Node node, Student value) {
        if (node == null) return new Node(value);
        if (value.id.compareToIgnoreCase(node.value.id) < 0) node.left = insert(node.left, value);
        else node.right = insert(node.right, value);
        return node;
    }

    public void delete(String id) { root = delete(root, id); }
    private Node delete(Node node, String id) {
        if (node == null) return null;
        int comparison = id.compareToIgnoreCase(node.value.id);
        if (comparison < 0) node.left = delete(node.left, id);
        else if (comparison > 0) node.right = delete(node.right, id);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = smallest(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value.id);
        }
        return node;
    }
    private Node smallest(Node node) { while (node.left != null) node = node.left; return node; }

    public void displayInOrder() {
        if (root == null) { System.out.println("No student records available."); return; }
        System.out.println("\n--- Students Ordered by ID (BST) ---");
        displayInOrder(root);
    }
    private void displayInOrder(Node node) { if (node != null) { displayInOrder(node.left); System.out.println(node.value); displayInOrder(node.right); } }
}
