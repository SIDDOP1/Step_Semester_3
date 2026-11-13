public class Problem2_CancelledOrdersCleanup {
    static class Node { int data; Node next; Node(int data){this.data=data;} }
    static Node removeAll(Node head,int code) {
        while(head!=null && head.data==code)head=head.next;
        Node current=head;
        while(current!=null && current.next!=null) {
            if(current.next.data==code)current.next=current.next.next;
            else current=current.next;
        }
        return head;
    }
    static Node fromArray(int[] a) {
        Node head=null,tail=null;
        for(int x:a){Node n=new Node(x);if(head==null)head=n;else tail.next=n;tail=n;}
        return head;
    }
    static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
    public static void main(String[] args) {
        print(removeAll(fromArray(new int[]{5,3,5,8,5}),5));
        print(removeAll(fromArray(new int[]{5,5,5}),5));
    }
}
// Time O(n); additional space O(1). Nodes are unlinked in place.