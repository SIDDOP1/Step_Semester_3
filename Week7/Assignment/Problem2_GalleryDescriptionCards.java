public class Problem2_GalleryDescriptionCards {
 static abstract class ArtPiece { private static int next=1; private final String pieceId; ArtPiece(){pieceId="ART-"+(next++);} String getPieceId(){return pieceId;} abstract String describe(); }
 static class Painting extends ArtPiece {private final String title; Painting(String t){title=valid(t);} String describe(){return "Painting: "+title+", framed on canvas";}}
 static class Sculpture extends ArtPiece {private final String title; Sculpture(String t){title=valid(t);} String describe(){return "Sculpture: "+title+", carved from stone";}}
 static String valid(String s){if(s==null||s.trim().isEmpty())throw new IllegalArgumentException("Title required");return s;}
 public static void main(String[]x){System.out.println(new Painting("Sunset Fields").describe());System.out.println(new Sculpture("The Thinker II").describe());}
}