import java.util.ArrayList;
import java.util.Scanner;

public class Task {

    static class DailyTask {
        int id;
        String name;
        String date;
        String status;

        DailyTask(int id, String name, String date) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.status = "Pending";
        }

        void display() {
            System.out.println("Task ID: " + id);
            System.out.println("Task Name: " + name);
            System.out.println("Date: " + date);
            System.out.println("Status: " + status);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DailyTask> tasks = new ArrayList<>();
        int nextId = 1;
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n=== Task and Daily Activity Management System ===");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    tasks.add(new DailyTask(nextId++, name, date));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (DailyTask task : tasks) {
                            task.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to complete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid task ID.");
                        sc.nextLine();
                        break;
                    }

                    int completeId = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;

                    for (DailyTask task : tasks) {
                        if (task.id == completeId) {
                            task.status = "Completed";
                            System.out.println("Task marked as completed!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid task ID.");
                        sc.nextLine();
                        break;
                    }

                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    boolean deleted = false;

                    for (int i = 0; i < tasks.size(); i++) {
                        if (tasks.get(i).id == deleteId) {
                            tasks.remove(i);
                            System.out.println("Task deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Task not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Enter a number from 1 to 5.");
            }
        }

        sc.close();
    }
}