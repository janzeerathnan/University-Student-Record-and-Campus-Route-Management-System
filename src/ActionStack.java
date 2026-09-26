/** Custom stack that stores recent system actions. */
public class ActionStack {
    private Node top;
    private static class Node { String value; Node next; Node(String value) { this.value = value; } }
    public void push(String value) { Node node = new Node(value); node.next = top; top = node; }
    public void display() { if (top == null) { System.out.println("No recent actions."); return; } System.out.println("\n--- Recent Actions (newest first) ---"); Node current = top; int number = 1; while (current != null) { System.out.println(number++ + ". " + current.value); current = current.next; } }
}
