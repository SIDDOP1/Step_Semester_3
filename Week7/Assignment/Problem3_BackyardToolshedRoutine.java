public class Problem3_BackyardToolshedRoutine {
 static abstract class GardenTool {GardenTool(){} abstract String use();}
 static class CuttingTool extends GardenTool {CuttingTool(){super();} String use(){return "Using the tool in the garden, blade sharpened first";}}
 static class Pruner extends CuttingTool {Pruner(){super();} @Override String use(){return super.use()+", then trimming branches precisely";}}
 public static void main(String[]x){System.out.println(new CuttingTool().use());System.out.println(new Pruner().use());}
}