import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Problem2_CampusVehiclePassSystem {
    interface Chargeable { boolean bookChargingBay(); }
    static abstract class Vehicle {
        final String passNumber,owner;
        Vehicle(String p,String o){passNumber=p;owner=o;}
        abstract int passFee(); abstract String type();
    }
    static class Bike extends Vehicle {Bike(String p,String o){super(p,o);}int passFee(){return 300;}String type(){return "Bike";}}
    static class Car extends Vehicle {Car(String p,String o){super(p,o);}int passFee(){return 1000;}String type(){return "Car";}}
    static class EBike extends Vehicle implements Chargeable {EBike(String p,String o){super(p,o);}int passFee(){return 300;}String type(){return "EBike";}public boolean bookChargingBay(){return true;}}
    static class ECar extends Vehicle implements Chargeable {ECar(String p,String o){super(p,o);}int passFee(){return 1000;}String type(){return "ECar";}public boolean bookChargingBay(){return true;}}
    static Vehicle create(String type,String pass,String owner) {
        switch(type) {
            case "Bike":return new Bike(pass,owner);case "Car":return new Car(pass,owner);
            case "EBike":case "E-Bike":return new EBike(pass,owner);
            case "ECar":case "E-Car":return new ECar(pass,owner);
            default:throw new IllegalArgumentException("Unknown vehicle type: "+type);
        }
    }
    public static void main(String[] args) {
        Map<String,Vehicle> vehicles=new HashMap<>();Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String op=sc.next();
            if(op.equals("PASS")) {
                Vehicle v=create(sc.next(),sc.next(),sc.next());vehicles.put(v.passNumber,v);
                System.out.println(v.passNumber+" ("+v.type()+") pass fee "+v.passFee());
            } else if(op.equals("CHARGE")) {
                String pass=sc.next();Vehicle v=vehicles.get(pass);
                if(v==null)System.out.println("Vehicle not found");
                else if(v instanceof Chargeable && ((Chargeable)v).bookChargingBay())System.out.println(pass+" charging bay allotted");
                else System.out.println(pass+" rejected: charging unsupported");
            } else System.out.println("Unknown operation: "+op+sc.nextLine());
        }
    }
}
// HashMap registration/lookup O(1) average. Only electric vehicles implement Chargeable.