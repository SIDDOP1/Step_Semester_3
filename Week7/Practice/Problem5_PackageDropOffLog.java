public class Problem5_PackageDropOffLog {
 static abstract class DeliveryNote {abstract String confirmDelivery();String confirmDelivery(String signature){if(signature==null||signature.trim().isEmpty())throw new IllegalArgumentException("Signature required");return confirmDelivery()+" | Signed by: "+signature;}}
 static class ParcelNote extends DeliveryNote {String confirmDelivery(){return "Parcel delivery confirmed";}}
 static class LetterNote extends DeliveryNote {String confirmDelivery(){return "Letter delivery confirmed";}}
 static void logAll(DeliveryNote[] notes){for(DeliveryNote n:notes)if(n!=null)System.out.println(n.confirmDelivery());}
 public static void main(String[]x){DeliveryNote p=new ParcelNote(),l=new LetterNote();logAll(new DeliveryNote[]{p,l});System.out.println(p.confirmDelivery("Asha"));}
}