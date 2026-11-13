import java.time.*;
interface LeavePolicy {boolean eligible(long days);}
class FullTimePolicy implements LeavePolicy {public boolean eligible(long d){return d>0&&d<=30;}}
class PartTimePolicy implements LeavePolicy {public boolean eligible(long d){return d>0&&d<=10;}}
class ContractorPolicy implements LeavePolicy {public boolean eligible(long d){return d>0&&d<=5;}}
class Employee {String name;LeavePolicy policy;Employee(String n,LeavePolicy p){name=n;policy=p;}}
class LeaveRequest {enum Status{PENDING,APPROVED,REJECTED}private Status status=Status.PENDING;Employee employee;LocalDate start,end;LeaveRequest(Employee e,LocalDate s,LocalDate d){if(!d.isAfter(s)&&!d.equals(s))throw new IllegalArgumentException();employee=e;start=s;end=d;}void review(boolean approve){if(status!=Status.PENDING)throw new IllegalStateException("Cannot change leave request status from "+status);long days=ChronoUnit.DAYS.between(start,end)+1;if(!employee.policy.eligible(days))approve=false;status=approve?Status.APPROVED:Status.REJECTED;}Status status(){return status;}}
public class Problem2_EmployeeLeaveWorkflow {public static void main(String[]x){Employee e=new Employee("John",new FullTimePolicy());LeaveRequest r=new LeaveRequest(e,LocalDate.of(2026,1,1),LocalDate.of(2026,1,5));r.review(true);System.out.println(r.status());try{r.review(false);}catch(Exception ex){System.out.println(ex.getMessage());}}}