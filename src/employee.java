public class employee {
    protected int id;
    protected String name;
    protected String role;
    protected double basic_salary;
    protected double bonus;
    protected double deduction;

    public employee(String name, String role, double basicSalary) {
        this.name = name;
        this.role = role;
        this.basic_salary = basicSalary;
        this.bonus = 0;
        this.deduction = 0;
    }

    public double calculateSalary() {
        return basic_salary + bonus - deduction;
    }
}