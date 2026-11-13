public class Problem4_TrainCoachesBothWays {
    static class Node { String name; Node prev,next; Node(String name){this.name=name;} }
    static class Train {
        Node head,tail;
        void addLast(String name) {
            Node n=new Node(name);
            if(head==null){head=tail=n;return;}
            tail.next=n;n.prev=tail;tail=n;
        }
        boolean remove(String name) {
            Node c=head;
            while(c!=null && !c.name.equals(name))c=c.next;
            if(c==null)return false;
            if(c.prev!=null)c.prev.next=c.next;else head=c.next;
            if(c.next!=null)c.next.prev=c.prev;else tail=c.prev;
            c.prev=c.next=null;
            return true;
        }
        void printForward() {
            System.out.print("Forward: ");
            for(Node c=head;c!=null;c=c.next){if(c!=head)System.out.print(" <-> ");System.out.print(c.name);}
            System.out.println();
        }
        void printBackward() {
            System.out.print("Backward: ");
            for(Node c=tail;c!=null;c=c.prev){if(c!=tail)System.out.print(" <-> ");System.out.print(c.name);}
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Train t=new Train();
        for(String s:new String[]{"Engine","A1","B1","B2","Guard"})t.addLast(s);
        t.remove("B1");t.printForward();t.printBackward();
    }
}
// addLast O(1) with tail; finding coach O(n); unlink after finding O(1); print O(n).