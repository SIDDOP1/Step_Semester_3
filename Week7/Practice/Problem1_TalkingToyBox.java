public class Problem1_TalkingToyBox {
 static abstract class Toy {private static int next=1001;private final String toyId;Toy(){toyId="TOY-"+next++;}abstract String makeSound();String getToyId(){return toyId;}}
 static class ToyCar extends Toy {final String name;ToyCar(String n){name=valid(n);}String makeSound(){return name+": Vroom vroom!";}}
 static class ToyRobot extends Toy {final String name;ToyRobot(String n){name=valid(n);}String makeSound(){return name+": Beep boop!";}}
 static String valid(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException();return s;}
 public static void main(String[]x){ToyCar c=new ToyCar("Speedster");ToyRobot r=new ToyRobot("Bolt");System.out.println(c.makeSound());System.out.println(r.makeSound());System.out.println(c.getToyId());System.out.println(r.getToyId());}
}