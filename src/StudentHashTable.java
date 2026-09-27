/** Chained hash table for efficient student-ID lookup. */
public class StudentHashTable {
    private final Entry[] buckets;
    private static class Entry { Student value; Entry next; Entry(Student value) { this.value = value; } }

    public StudentHashTable(int capacity) { buckets = new Entry[capacity]; }
    private int index(String id) { return (id.toLowerCase().hashCode() & 0x7fffffff) % buckets.length; }
    public void put(Student value) { int i = index(value.id); Entry entry = new Entry(value); entry.next = buckets[i]; buckets[i] = entry; }
    public Student get(String id) { Entry entry = buckets[index(id)]; while (entry != null) { if (entry.value.id.equalsIgnoreCase(id)) return entry.value; entry = entry.next; } return null; }
    public void remove(String id) { int i = index(id); Entry previous = null, current = buckets[i]; while (current != null) { if (current.value.id.equalsIgnoreCase(id)) { if (previous == null) buckets[i] = current.next; else previous.next = current.next; return; } previous = current; current = current.next; } }
}
