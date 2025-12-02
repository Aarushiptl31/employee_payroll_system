import java.sql.*;


public class Database {

    private final String URL = "jdbc:mysql://localhost:3306/payroll";
    private final String USER = "root";
    private final String PASSWORD = "aarushi@31";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Insert employee into database
    public void insertEmployee(employee emp) {
        String sql = "INSERT INTO employees(name, role, salary) VALUES(?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.name);
            stmt.setString(2, emp.role);
            stmt.setDouble(3, emp.calculateSalary());

            stmt.executeUpdate();
            System.out.println("Employee Added to DB!");

        } catch (Exception e) {
            System.out.println("Insert Failed: " + e.getMessage());
        }
    }

    // Fetch all employees
    public void fetchEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID | Name | role | Salary");
            System.out.println("----------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("role") + " | " +
                    rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            System.out.println("Fetch Failed: " + e.getMessage());
        }
    }

}
