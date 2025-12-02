public class FullTimeEmployee extends employee {

    public FullTimeEmployee(String name, double basicSalary) {
        super(name, "Full-Time", basicSalary);
        this.bonus = basicSalary * 0.10; // 10% bonus
        this.deduction = basicSalary * 0.05; // 5% deduction
    }
}
