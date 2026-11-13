public class Problem3_OrchestraWarmUpRoutine {
 static abstract class Instrument {Instrument(){}abstract String play();}
 static class StringInstrument extends Instrument {StringInstrument(){super();}String play(){return "Strumming the strings";}}
 static class Violin extends StringInstrument {Violin(){super();}@Override String play(){return super.play()+", with a bow drawn across four strings";}}
 public static void main(String[]x){System.out.println(new StringInstrument().play());System.out.println(new Violin().play());}
}