public class Problem3_ReverseTheQueue {
    static class Node { int data; Node next; Node(int data){this.data=data;} }
    static Node reverse(Node head) {
        Node previous=null,current=head;
        while(current!=null) {
            Node next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    static Node fromArray(int[] a) {
        Node head=null,tail=null;
        for(int x:a){Node n=new Node(x);if(head==null)head=n;else tail.next=n;tail=n;}
        return head;
    }
    static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
    public static void main(String[] args) {
        print(reverse(fromArray(new int[]{1,2,3,4})));
        print(reverse(fromArray(new int[]{9})));
        print(reverse(null));
    }
}
// Time O(n); additional space O(1). Three references are used and no nodes are created.