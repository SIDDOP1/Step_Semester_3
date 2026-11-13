import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Problem1_BankAccountWithdrawalSystem {
    static abstract class Account {
        final String id; long balance;
        Account(String id,long balance){this.id=id;this.balance=balance;}
        abstract long minimumAllowedBalance();
        String withdraw(long amount) {
            if(amount<=0)return id+" rejected: amount must be positive";
            if(balance-amount<minimumAllowedBalance())
                return id+(this instanceof Savings?" rejected: minimum balance 1000":" rejected: overdraft limit 5000");
            balance-=amount;return id+" balance "+balance;
        }
    }
    static class Savings extends Account { Savings(String i,long b){super(i,b);} long minimumAllowedBalance(){return 1000;} }
    static class Current extends Account { Current(String i,long b){super(i,b);} long minimumAllowedBalance(){return -5000;} }
    public static void main(String[] args) {
        Map<String,Account> accounts=new HashMap<>();Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String op=sc.next();
            if(op.equals("Savings")||op.equals("Current")) {
                String id=sc.next();long balance=sc.nextLong();
                accounts.put(id,op.equals("Savings")?new Savings(id,balance):new Current(id,balance));
            } else if(op.equals("WITHDRAW")) {
                String id=sc.next();long amount=sc.nextLong();Account a=accounts.get(id);
                System.out.println(a==null?"Account not found":a.withdraw(amount));
            } else {System.out.println("Unknown operation: "+op+sc.nextLine());}
        }
    }
}
// Account lookup is O(1) average using HashMap; storage O(number of accounts).