/** Custom FIFO queue for student service requests. */
public class ServiceQueue {
    private Node front, rear;
    private static class Node { String value; Node next; Node(String value) { this.value = value; } }
    public void enqueue(String value) { Node node = new Node(value); if (rear == null) front = rear = node; else { rear.next = node; rear = node; } }
    public String dequeue() { if (front == null) return null; String value = front.value; front = front.next; if (front == null) rear = null; return value; }
}
