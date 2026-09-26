# Student Management & Campus Navigation System

A Java console-based **Data Structures and Algorithms** project that combines student record management with campus route operations. The application is organized as a modular system where different data structures are used to handle unique operational requirements such as CRUD, action tracking, queue processing, ID indexing, and graph traversal.

## 📋 Project Overview

This project was developed as a practical assignment for the DSA course and demonstrates how core data structures can be applied in a real-world management system. It allows users to:

-  Add, update, delete, search, and display student records
-  Maintain a recent action log using a stack
-  Handle service requests in a queue
-  Store and display students in sorted order using a BST
-  Search students by ID using a hash table
-  Model campus locations and roads using an adjacency-list graph
-  Traverse the campus network using BFS

## Core Features

| Feature | Implementation | Purpose |
|---------|---|---|
| **Student CRUD Operations** | Linked List | Add, update, delete, and display student records |
| **Action Tracking** | Stack | Keep a log of recent actions in reverse chronological order |
| **Service Request Management** | Queue | Process requests in FIFO (first-come-first-served) order |
| **Sorted Student Storage** | Binary Search Tree | Maintain students in sorted order by ID |
| **Fast Student Lookup** | Hash Table | Quick search and retrieval by student ID |
| **Campus Network** | Adjacency-List Graph | Represent locations and roads across campus |
| **Route Exploration** | BFS Traversal | Find connections and explore campus pathways |

## System Architecture

### Project Structure

```
├── src/
│   ├── Main.java                 # Console menu and application controller
│   ├── Student.java              # Student record model
│   ├── StudentLinkedList.java     # Linked-list-based student storage
│   ├── ActionStack.java          # Recent action tracking using stack
│   ├── ServiceQueue.java         # Service request queue (FIFO)
│   ├── StudentBST.java           # Binary search tree for sorted records
│   ├── StudentHashTable.java     # Hash table for fast lookup
│   └── CampusGraph.java          # Campus network graph with BFS
├── Explaination.txt               # Beginner-friendly DSA concept guide
├── TEAM_CONTRIBUTIONS.md          # Member file allocation and GitHub workflow
└── README.md                      # Project documentation
```

### Key Classes & Data Structures

- **`Main.java`** — Console menu and application controller
- **`Student.java`** — Student record model
- **`StudentLinkedList.java`** — Linked-list-based student storage and CRUD operations
- **`ActionStack.java`** — Stack for tracking recent actions
- **`ServiceQueue.java`** — Queue for service request management
- **`StudentBST.java`** — Binary search tree for ordered student records by ID
- **`StudentHashTable.java`** — Hash table for fast student lookup by ID
- **`CampusGraph.java`** — Undirected graph with adjacency-list representation and BFS traversal

## Team Information

### Group Members

| Name | Student ID | Role | Responsibilities |
|------|-----------|------|-----------------|
| **Thahiya** | 23DA2-1151 | Linked List & Student CRUD Lead | Student record storage, CRUD operations, and data validation |
| **Ashadha** | 23DA2-0612 | Stack & Queue Specialist | Action tracking and service request queue management |
| **Hamthani** | 23DA2-0871 | BST & Hashing Expert | Student sorting and fast ID-based lookup |
| **Athnan** | 23DA2-0490 | Graph & Traversal Engineer | Campus network modeling and BFS implementation |

## Individual Contributions

### Thahiya — Linked List + Student CRUD
- Created and managed student record collection using a linked list
- Implemented add, update, delete, and display operations
- Integrated CRUD operations with main menu and validation logic
- Ensured data integrity and proper record management

### Ashadha — Stack + Queue
- Implemented stack for tracking recent actions in LIFO order
- Implemented queue for managing service requests in FIFO order
- Structured action and request tracking for operational transparency
- Validated and tested queue/stack operations under various scenarios

### Hamthani — BST + Hashing
- Built binary search tree to maintain students in sorted order by ID
- Implemented hash table for quick student ID-based lookup
- Optimized search operations and data retrieval efficiency
- Balanced performance between insertion and search operations

### Athnan — Graph + BFS
- Designed campus graph with nodes (locations) and edges (roads)
- Implemented adjacency-list graph representation
- Developed BFS algorithm for route exploration
- Enabled campus network visualization and connectivity analysis

For the assigned source files, suggested Git branches, and a step-by-step GitHub push guide, see [TEAM_CONTRIBUTIONS.md](TEAM_CONTRIBUTIONS.md).

##  How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed
- Command line/terminal access

### Compilation

From the project root directory:

```bash
javac -d out src/*.java
```

Or compile individual files:

```bash
javac -d out src/Main.java src/Student.java src/StudentLinkedList.java src/ActionStack.java src/ServiceQueue.java src/StudentBST.java src/StudentHashTable.java src/CampusGraph.java
```

### Execution

```bash
java -cp out Main
```

The application will launch a menu-driven console interface where you can:
1. Manage student records (add, update, delete, search)
2. View recent actions
3. Process service requests
4. Browse sorted student lists
5. Explore campus routes via graph traversal

## Input Validation

The system includes validation for:
- ✓ Empty or null data
- ✓ Duplicate student IDs
- ✓ Invalid marks/grades
- ✓ Missing records
- ✓ Out-of-range values
- ✓ Invalid menu selections

## Learning Outcomes

This project demonstrates practical implementation of:
- **Linked Lists** for dynamic data storage
- **Stacks** for last-in-first-out operations
- **Queues** for first-in-first-out processing
- **Binary Search Trees** for sorted data organization
- **Hash Tables** for efficient lookup operations
- **Graphs** for network representation
- **Graph Traversal** algorithms (BFS)
- **Object-Oriented Design** principles in Java

## Notes

- The menu-driven program is designed for console interaction
- Each data structure solves a distinct problem within the overall system
- The modular design allows independent testing of each component
- This project showcases practical understanding of DSA in Java
- Extensible architecture allows for future enhancements

## Workflow Integration

Each component works together seamlessly:

```
User Input (Main Menu)
    ↓
Student CRUD (LinkedList)
    ↓
Action Log (Stack) + Service Queue
    ↓
Sorted View (BST) + ID Search (Hash Table)
    ↓
Campus Routes (Graph + BFS)
    ↓
Output Display
```

## License

Educational project for SLTC Research University - Department of Information Technology

## Course Information

- **Course:** Data Structures and Algorithms
- **University:** SLTC Research University
- **Department:** Information Technology
- **Semester:** [Current Semester]


For questions or support, contact any team member at the Department of Information Technology.
