public class Problem4_SmartKitchenAssistant {
 static abstract class KitchenTool {private int speedLevel=1;abstract String prepare();public int getSpeedLevel(){return speedLevel;}public void setSpeedLevel(int n){if(n<1||n>5)throw new IllegalArgumentException("Speed must be 1-5");speedLevel=n;}}
 interface Washable {String clean();}
 static class Blender extends KitchenTool implements Washable {String prepare(){return "Blender preparing ingredients at speed "+getSpeedLevel();}public String clean(){return "Blender cleaned";}}
 public static void main(String[]x){Blender b=new Blender();b.setSpeedLevel(3);System.out.println(b.prepare());System.out.println(b.clean());}
}