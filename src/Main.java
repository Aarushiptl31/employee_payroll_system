import java.util.Scanner;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database(); // Your DB class

        while (true) {
            System.out.println("\n===== PAYROLL SYSTEM =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    FullTimeEmployee ft = new FullTimeEmployee(name, salary);
                    db.insertEmployee(ft);

                    System.out.println("Full-Time Employee Added!");
                }

                case 2 -> {
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    PartTimeEmployee pt = new PartTimeEmployee(name, salary);
                    db.insertEmployee(pt);

                    System.out.println("Part-Time Employee Added!");
                }

                case 3 -> {
                    System.out.println("\n--- Employee Records ---");
                    db.fetchEmployees();
                }
                case 4 -> {
                    searchEmployee(db.getConnection(), sc);
                }


                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid Choice!");
            }
        }
    }
    public static void searchEmployee(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Employee Details ---");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Type: " + rs.getString("role"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("⚠ Employee Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }
    }
}
