public class Problem5_SkylineDeliveryFleet {
 static abstract class Drone {final String id;Drone(String id){this.id=valid(id);}abstract String fly();}
 interface Trackable {String getLocation();}
 static class DeliveryDrone extends Drone implements Trackable {DeliveryDrone(String id){super(id);}String fly(){return "Delivery drone "+id+" flying";}public String getLocation(){return "DeliveryDrone "+id+" at coordinates (12, 24)";}}
 static class ScoutDrone extends Drone {ScoutDrone(String id){super(id);}String fly(){return "Scout drone "+id+" scouting";}}
 static class GroundRobot implements Trackable {final String id;GroundRobot(String id){this.id=valid(id);}public String getLocation(){return "GroundRobot "+id+" at warehouse";}}
 static String getLocationIfTrackable(Object o){return o instanceof Trackable?((Trackable)o).getLocation():"Tracking is not available";}
 static String valid(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException();return s;}
 public static void main(String[]x){System.out.println(getLocationIfTrackable(new DeliveryDrone("D1")));System.out.println(getLocationIfTrackable(new ScoutDrone("S1")));System.out.println(getLocationIfTrackable(new GroundRobot("R1")));}
}