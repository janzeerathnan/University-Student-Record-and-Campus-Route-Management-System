/** Model representing a university student record. */
public class Student {
    String id, name, programme;
    double marks;
    public Student(String id, String name, String programme, double marks) { this.id = id; this.name = name; this.programme = programme; this.marks = marks; }
    @Override public String toString() { return String.format("ID: %s | Name: %s | Programme: %s | Marks: %.2f", id, name, programme, marks); }
}
