import java.util.*;
interface NotificationChannel {String send(String student,String title);}
class EmailChannel implements NotificationChannel {public String send(String s,String t){return "[Email → "+s+"] "+t;}}
class SmsChannel implements NotificationChannel {public String send(String s,String t){return "[SMS → "+s+"] "+t;}}
class AppChannel implements NotificationChannel {public String send(String s,String t){return "[App → "+s+"] "+t;}}
class Student {String name,department;List<NotificationChannel> channels;Student(String n,String d,NotificationChannel... c){name=n;department=d;channels=Arrays.asList(c);}}
class Notice {String title;Set<String> departments;Notice(String t,Set<String>d){if(t==null||t.isBlank()||d==null||d.isEmpty())throw new IllegalArgumentException("Notice needs title and target department");title=t;departments=new HashSet<>(d);}}
class NoticeBoard {List<Student> students=new ArrayList<>();void post(Notice n){System.out.println("Notice '"+n.title+"' posted to "+String.join(", ",n.departments)+".");for(Student s:students)if(n.departments.contains(s.department))for(NotificationChannel c:s.channels)System.out.println(c.send(s.name,n.title));}}
public class Problem5_CampusNoticeBroadcaster {public static void main(String[]x){NoticeBoard b=new NoticeBoard();b.students.add(new Student("Asha","CSE",new EmailChannel(),new AppChannel()));b.students.add(new Student("Ravi","ECE",new SmsChannel()));b.post(new Notice("Lab Closed Tomorrow",Set.of("CSE")));b.post(new Notice("Fee Deadline Extended",Set.of("CSE","ECE")));}}