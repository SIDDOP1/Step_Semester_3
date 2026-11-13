import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
public class Problem3_StudentClubRegistrationManagement {
    static class Student {
        final String rollNumber,name;
        Student(String r,String n){rollNumber=r;name=n;}
        @Override public boolean equals(Object o) {
            if(this==o)return true;if(!(o instanceof Student))return false;
            return Objects.equals(rollNumber,((Student)o).rollNumber);
        }
        @Override public int hashCode(){return Objects.hash(rollNumber);}
    }
    public static void main(String[] args) {
        Set<Student> members=new HashSet<>();Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String op=sc.next();
            if(op.equals("ADD"))System.out.println(members.add(new Student(sc.next(),sc.next()))?"Added":"duplicate rejected");
            else if(op.equals("CONTAINS"))System.out.println("contains: "+members.contains(new Student(sc.next(),sc.next())));
            else System.out.println("Unknown operation: "+op+sc.nextLine());
        }
        System.out.println("member count "+members.size());
    }
}
// Equality and hashing depend only on rollNumber. HashSet operations are O(1) average.