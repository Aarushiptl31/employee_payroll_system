import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public static void saveEmployee(employee emp) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("Database not connected!");
                return;
            }

            String query = "INSERT INTO employees(name, role, basicSalary, bonus, deductions, totalSalary) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, emp.name);
            pst.setString(2, emp.role);
            pst.setDouble(3, emp.basic_salary);
            pst.setDouble(4, emp.bonus);
            pst.setDouble(5, emp.deduction);
            pst.setDouble(6, emp.calculateSalary());

            pst.executeUpdate();
            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
