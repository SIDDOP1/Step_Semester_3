public class EmployeeConstructorDemo {
    static class Employee {
        String empId, empName; double salary; boolean isIntern;
        Employee(String empId, String empName, double salary) { this.empId = empId; this.empName = empName; this.salary = salary; this.isIntern = false; }
        Employee(String empId, String empName) { this(empId, empName, 0); this.isIntern = true; }
        void printProfile() { System.out.printf("%s | %s | Rs %.1f | Intern: %s%n", empId, empName, salary, isIntern); }
    }
    public static void main(String[] args) { new Employee("E-101", "Divya", 65000).printProfile(); new Employee("E-102", "Arjun").printProfile(); }
}
