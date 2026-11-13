public class StudentStaticMembersDemo {
    static class Student {
        String name; int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;
        Student(String name, int attendance) { this.name = name; this.attendance = attendance; studentCount++; }
        static void printCollegeInfo() { System.out.println(collegeName); System.out.println(studentCount + " Student objects created"); System.out.println("Students created: " + studentCount); }
    }
    public static void main(String[] args) { new Student("Ravi", 80); new Student("Meera", 90); Student.printCollegeInfo(); }
}
