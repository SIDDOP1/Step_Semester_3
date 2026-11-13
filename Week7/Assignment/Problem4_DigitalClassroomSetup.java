public class Problem4_DigitalClassroomSetup {
 static abstract class ClassroomDevice {abstract String operate();}
 interface Chargeable {String charge();String charge(int minutes);}
 static class Tablet extends ClassroomDevice implements Chargeable {private final String assetTag;Tablet(String t){if(t==null||t.trim().isEmpty())throw new IllegalArgumentException();assetTag=t;} String operate(){return "Tablet "+assetTag+" displaying lesson";} public String charge(){return assetTag+" charging";} public String charge(int m){if(m<=0)throw new IllegalArgumentException("Minutes must be positive");return assetTag+" charging for "+m+" minutes";}}
 public static void main(String[]x){Tablet t=new Tablet("TAB-5");System.out.println(t.operate());System.out.println(t.charge());System.out.println(t.charge(30));}
}