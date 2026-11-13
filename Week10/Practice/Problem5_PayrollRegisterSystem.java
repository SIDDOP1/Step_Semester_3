import java.util.ArrayList;
import java.util.List;
public class Problem5_PayrollRegisterSystem {
    static class Payslip {
        final String name,type;final long pay;
        Payslip(String n,String t,long p){name=n;type=t;pay=p;}
        public String toString(){return "Payslip[name="+name+", type="+type+", pay="+pay+"]";}
    }
    static Payslip fullTime(String n,long salary){return new Payslip(n,"FullTime",salary);}
    static Payslip partTime(String n,long hours,long rate){return new Payslip(n,"PartTime",Math.multiplyExact(hours,rate));}
    static Payslip intern(String n,long stipend){return new Payslip(n,"Intern",stipend);}
    static void printPayroll(List<Payslip> slips) {
        long total=0;Payslip top=null;
        for(Payslip p:slips){System.out.println(p);total=Math.addExact(total,p.pay);if(top==null||p.pay>top.pay)top=p;}
        System.out.println("Total "+total);if(top!=null)System.out.println("top earner "+top.name);
    }
    public static void main(String[] args) {
        List<Payslip> staff=new ArrayList<>();staff.add(fullTime("Asha",50000));staff.add(partTime("Ravi",80,300));staff.add(intern("Neha",15000));printPayroll(staff);
    }
}
// Payslip creation and top-earner calculation O(n); payslip storage O(n).