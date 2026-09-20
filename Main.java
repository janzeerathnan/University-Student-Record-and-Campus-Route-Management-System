import java.util.Scanner;

/** Coordinates the separate data-structure classes through the console menu. */
public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentLinkedList students = new StudentLinkedList();
    private final ActionStack actions = new ActionStack();
    private final ServiceQueue requests = new ServiceQueue();
    private final StudentBST studentTree = new StudentBST();
    private final StudentHashTable studentIndex = new StudentHashTable(17);
    private final CampusGraph campus = new CampusGraph();

    public static void main(String[] args) { new Main().run(); }

    private void run() {
        System.out.println("===============================================");
        System.out.println(" University Student & Campus Route Management");
        System.out.println("===============================================");
        boolean running = true;
        while (running) {
            printMenu();
            switch (readInt("Choose an option: ")) {
                case 1: addStudent(); break; case 2: updateStudent(); break;
                case 3: deleteStudent(); break; case 4: students.display(); break;
                case 5: addServiceRequest(); break; case 6: processServiceRequest(); break;
                case 7: actions.display(); break; case 8: studentTree.displayInOrder(); break;
                case 9: searchStudent(); break; case 10: addLocation(); break;
                case 11: removeLocation(); break; case 12: changeConnection(true); break;
                case 13: changeConnection(false); break; case 14: campus.display(); break;
                case 15: traverseCampus(); break;
                case 16: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid menu option. Please enter 1 to 16.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1. Add Student Record                 9. Search Student (Hashing)");
        System.out.println("2. Update Student Record             10. Add Campus Location");
        System.out.println("3. Delete Student Record             11. Remove Campus Location");
        System.out.println("4. Display Records (Linked List)     12. Add Campus Connection");
        System.out.println("5. Add Service Request                13. Remove Campus Connection");
        System.out.println("6. Process Next Service Request       14. Display Campus Network");
        System.out.println("7. Display Recent Actions (Stack)    15. Traverse Campus (BFS)");
        System.out.println("8. Display Students (BST)            16. Exit");
    }

    private void addStudent() {
        String id = readRequired("Student ID: ");
        if (studentIndex.get(id) != null) { System.out.println("A student with that ID already exists."); return; }
        Student student = new Student(id, readRequired("Name: "), readRequired("Programme: "), readMark());
        students.add(student); studentTree.insert(student); studentIndex.put(student);
        actions.push("Added student " + id); System.out.println("Student record added.");
    }

    private void updateStudent() {
        String id = readRequired("Student ID to update: ");
        Student student = studentIndex.get(id);
        if (student == null) { System.out.println("Student not found."); return; }
        System.out.println("Leave a field blank to keep its current value.");
        String name = readLine("Name [" + student.name + "]: ");
        String programme = readLine("Programme [" + student.programme + "]: ");
        String markText = readLine("Marks [" + student.marks + "]: ");
        if (!name.trim().isEmpty()) student.name = name.trim();
        if (!programme.trim().isEmpty()) student.programme = programme.trim();
        if (!markText.trim().isEmpty()) {
            try { double mark = Double.parseDouble(markText.trim()); if (mark >= 0 && mark <= 100) student.marks = mark; else System.out.println("Marks must be between 0 and 100. Marks unchanged."); }
            catch (NumberFormatException e) { System.out.println("Invalid marks. Marks unchanged."); }
        }
        actions.push("Updated student " + id); System.out.println("Student record updated.");
    }

    private void deleteStudent() {
        String id = readRequired("Student ID to delete: ");
        Student removed = students.remove(id);
        if (removed == null) { System.out.println("Student not found."); return; }
        studentTree.delete(id); studentIndex.remove(id); actions.push("Deleted student " + id + " (" + removed.name + ")");
        System.out.println("Student record deleted.");
    }

    private void searchStudent() {
        Student student = studentIndex.get(readRequired("Student ID to search: "));
        System.out.println(student == null ? "Student not found." : "Found: " + student);
    }
    private void addServiceRequest() {
        String request = readRequired("Enter service request: "); requests.enqueue(request);
        actions.push("Added service request: " + request); System.out.println("Request added to the queue.");
    }
    private void processServiceRequest() {
        String request = requests.dequeue();
        if (request == null) System.out.println("There are no pending service requests.");
        else { actions.push("Processed service request: " + request); System.out.println("Processing: " + request); }
    }
    private void addLocation() {
        String location = readRequired("Location name: ");
        if (campus.addLocation(location)) { actions.push("Added location " + location); System.out.println("Location added."); }
        else System.out.println("That location already exists.");
    }
    private void removeLocation() {
        String location = readRequired("Location name to remove: ");
        if (campus.removeLocation(location)) { actions.push("Removed location " + location); System.out.println("Location and its roads removed."); }
        else System.out.println("Location not found.");
    }
    private void changeConnection(boolean add) {
        String first = readRequired("First location: "); String second = readRequired("Second location: ");
        boolean result = add ? campus.addConnection(first, second) : campus.removeConnection(first, second);
        if (result) { actions.push((add ? "Added road: " : "Removed road: ") + first + " - " + second); System.out.println(add ? "Road added." : "Road removed."); }
        else System.out.println(add ? "Cannot add road: both locations must exist, differ, and not already be connected." : "Road not found.");
    }
    private void traverseCampus() {
        String route = campus.bfs(readRequired("Starting location: "));
        System.out.println(route == null ? "Location not found." : "BFS traversal: " + route);
    }
    private String readLine(String prompt) { System.out.print(prompt); return scanner.nextLine(); }
    private String readRequired(String prompt) { while (true) { String value = readLine(prompt).trim(); if (!value.isEmpty()) return value; System.out.println("This field cannot be empty."); } }
    private int readInt(String prompt) { while (true) try { return Integer.parseInt(readLine(prompt).trim()); } catch (NumberFormatException e) { System.out.println("Please enter a whole number."); } }
    private double readMark() { while (true) try { double mark = Double.parseDouble(readLine("Marks (0-100): ").trim()); if (mark >= 0 && mark <= 100) return mark; System.out.println("Marks must be between 0 and 100."); } catch (NumberFormatException e) { System.out.println("Please enter a valid number."); } }
}
