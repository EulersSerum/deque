

public class Deque<Item> {

private Node headNode;
private Node tailNode;
private int size;

public Deque(){
        size = 0;
        headNode = null;
        tailNode = null;
}

public boolean isEmpty(){
        return (size == 0);
}

public int size(){
        return size;
}

public void addFirst(Item item){
        size++;
        //if size is 1 head node is tail node
        if(size == 1) {
                headNode = new Node(item);
                tailNode = headNode;
        } else {
                Node newNode = new Node(item);
                newNode.next = headNode;
                headNode.previous = newNode;
                headNode = newNode;
        }
}

public void addLast(Item item){
        size++;
        if(size == 1) {
                tailNode = new Node(item);
                headNode = tailNode;
        } else{
                Node newNode = new Node(item);
                newNode.previous = tailNode;
                tailNode.next = newNode;
                tailNode = newNode;
        }
}

public Node removeFirst(){
        if(size > 0) {
                Node refNode = headNode;
                headNode = headNode.next;
                size--;
                return refNode;
        }
        else {
                headNode = null;
                tailNode = null;
                return null;
        }

}

public Node removeLast(){
        if(size > 0) {
                Node refNode = tailNode;
                tailNode = tailNode.previous;
                size--;
                return refNode;
        }
        else {
                headNode = null;
                tailNode = null;
                return null;
        }
}

class Node{
Item data;
Node next;
Node previous;
public Node(Item item){
        data = item;
}

}

public static void main(String[] args){
        Deque<String> myDeque = new Deque<String>();

        for(int j = 0; j < 4; j++) {
                System.out.println("Adding args to head.");
                for(int i = 0; i < args.length; i++) {
                        myDeque.addFirst(args[i]+Integer.toString(i));
                }

                System.out.println("Adding args to tail.");
                for(int i = 0; i < args.length; i++) {
                        myDeque.addLast(args[i]+Integer.toString(i));
                }

                if(j%2 == 1) {
                        System.out.println("Popping args from tail.");
                        for(int i = 0; myDeque.size > 0; i++) {
                                System.out.println(myDeque.removeLast().data);
                        }
                }

                if(j%2 != 1) {
                        System.out.println("Popping args from head.");
                        for(int i = 0; myDeque.size > 0; i++) {
                                System.out.println(myDeque.removeFirst().data);
                        }
                }
        }


}

}
