public class PartTimeEmployee extends employee {

    public PartTimeEmployee(String name, double basicSalary) {
        super(name, "Part-Time", basicSalary);
        this.bonus = basicSalary * 0.05; // 5% bonus
        this.deduction = basicSalary * 0.02; // 2% deduction
    }
}
