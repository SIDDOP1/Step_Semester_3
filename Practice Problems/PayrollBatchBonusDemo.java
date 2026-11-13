public class PayrollBatchBonusDemo {
    static class Employee {
        String empId; double salary;
        Employee(String empId, double salary) { this.empId = empId; this.salary = salary; }
        void raiseSalary(double salary) { this.salary += salary; }
    }
    public static void main(String[] args) {
        Employee[] team = {new Employee("E-101", 40000), new Employee("E-102", 55000), new Employee("E-103", 62000), new Employee("E-104", 48000)};
        for (Employee employee : team) { employee.raiseSalary(5000); System.out.printf("%s | Final Salary: Rs %.1f%n", employee.empId, employee.salary); }
    }
}
