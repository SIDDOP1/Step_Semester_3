public class Problem1_MorningWakeUpCircuit {
 interface Ringable { String ring(); }
 static class AlarmClock implements Ringable { private final String time; AlarmClock(String t){time=required(t);} public String ring(){return "Alarm ringing for "+time;} }
 static class Doorbell implements Ringable { private final String location; Doorbell(String l){location=required(l);} public String ring(){return "Doorbell ringing at "+location;} }
 static String required(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException("Value cannot be blank");return s;}
 static void ringAll(Ringable[] devices){for(Ringable d:devices)if(d!=null)System.out.println(d.ring());}
 public static void main(String[]x){Ringable a=new AlarmClock("7:00 AM"),d=new Doorbell("Front Door");ringAll(new Ringable[]{a,d});}
}