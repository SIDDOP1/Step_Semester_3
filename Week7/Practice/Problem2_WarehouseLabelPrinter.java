public class Problem2_WarehouseLabelPrinter {
 interface Printable {String printLabel();}
 static class PackageBox implements Printable {final String trackingId;PackageBox(String id){trackingId=valid(id);}public String printLabel(){return "Package label: "+trackingId;}}
 static class Invoice implements Printable {final String invoiceNumber;Invoice(String n){invoiceNumber=valid(n);}public String printLabel(){return "Invoice label: "+invoiceNumber;}}
 static void printAll(Printable[] items){for(Printable p:items)if(p!=null)System.out.println(p.printLabel());}
 static String valid(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException();return s;}
 public static void main(String[]x){printAll(new Printable[]{new PackageBox("TRK-88"),new Invoice("INV-42")});}
}