public class Problem5_PackageDropOffLog {
 static abstract class DeliveryNote {abstract String confirmDelivery();String confirmDelivery(String signature){if(signature==null||signature.trim().isEmpty())throw new IllegalArgumentException("Signature required");return confirmDelivery()+", signed by "+signature;}}
 static class ParcelNote extends DeliveryNote {private final String trackingId;ParcelNote(String id){trackingId=valid(id);}String confirmDelivery(){return "Parcel "+trackingId+" delivered";}}
 static class LetterNote extends DeliveryNote {private final String trackingId;LetterNote(String id){trackingId=valid(id);}String confirmDelivery(){return "Letter "+trackingId+" delivered";}}
 static String valid(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException();return s;}
 static void logAll(DeliveryNote[] notes){for(DeliveryNote n:notes)if(n!=null)System.out.println(n.confirmDelivery());}
 public static void main(String[]x){DeliveryNote p=new ParcelNote("TRK-1"),l=new LetterNote("TRK-2");logAll(new DeliveryNote[]{p,l});System.out.println(p.confirmDelivery("J. Smith"));}
}