public class Problem4_TrainCoachesBothWays {
 static class Node{String name;Node prev,next;Node(String n){name=n;}}
 static class Train{
  Node head,tail;
  void addLast(String name){Node n=new Node(name);if(tail==null){head=tail=n;return;}tail.next=n;n.prev=tail;tail=n;}
  boolean remove(String name){Node c=head;while(c!=null&&!c.name.equals(name))c=c.next;if(c==null)return false;if(c.prev!=null)c.prev.next=c.next;else head=c.next;if(c.next!=null)c.next.prev=c.prev;else tail=c.prev;c.prev=c.next=null;return true;}
  void printForward(){for(Node c=head;c!=null;c=c.next){System.out.print(c.name);if(c.next!=null)System.out.print(" <-> ");}System.out.println();}
  void printBackward(){for(Node c=tail;c!=null;c=c.prev){System.out.print(c.name);if(c.prev!=null)System.out.print(" <-> ");}System.out.println();}
 }
 public static void main(String[] args){Train t=new Train();for(String s:new String[]{"Engine","A1","B1","B2","Guard"})t.addLast(s);t.remove("B1");System.out.print("Forward: ");t.printForward();System.out.print("Backward: ");t.printBackward();}
}
// Finding coach O(n); unlinking once found O(1); addLast O(1) using tail.