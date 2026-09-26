/** Custom singly linked list for student records. */
public class StudentLinkedList {
    private Node head;
    private static class Node { Student value; Node next; Node(Student value) { this.value = value; } }
    public void add(Student value) { Node node = new Node(value); if (head == null) { head = node; return; } Node current = head; while (current.next != null) current = current.next; current.next = node; }
    public Student remove(String id) { Node previous = null, current = head; while (current != null) { if (current.value.id.equalsIgnoreCase(id)) { if (previous == null) head = current.next; else previous.next = current.next; return current.value; } previous = current; current = current.next; } return null; }
    public void display() { if (head == null) { System.out.println("No student records available."); return; } System.out.println("\n--- Student Records (Linked List) ---"); Node current = head; int number = 1; while (current != null) { System.out.println(number++ + ". " + current.value); current = current.next; } }
}
