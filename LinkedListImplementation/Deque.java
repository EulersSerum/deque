

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
                headNode.next = tailNode;
                headNode.previous = null;
                tailNode.previous = headNode;
                tailNode.next = null;
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
                headNode.previous = null;
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
                tailNode.next = null;
                size--;
                return refNode;
        }
        else {
                headNode = null;
                tailNode = null;
                return null;
        }
}

class Node {
Item data;
Node next;
Node previous;
public Node(Item item){
        data = item;
}

}

public static void main(String[] args){
        Deque<String> myDeque = new Deque<String>();

        String[] test1 = {"001", "002", "003", "004"};
        String[] test2 = {"005", "006", "007", "008"};
        String[] test3 = {"009", "010", "011", "012"};
        String[] test4 = {"013", "014", "015", "016"};

        System.out.println("Adding test1 to head.");
        for(int i = 0; i < test1.length; i++){
          myDeque.addFirst(test1[i]);
        }

        System.out.println("Popping 1 element from head.");
        System.out.println(myDeque.removeFirst().data);


        System.out.println("Popping 1 element from tail.");
        System.out.println(myDeque.removeLast().data);

        System.out.println("Adding test2 to head.");
        for(int i = 0; i < test1.length; i++){
          myDeque.addFirst(test2[i]);
        }

        System.out.println("Popping all elements from head");
        for(int i = 0; myDeque.size > 0; i++){
          System.out.println(myDeque.removeFirst().data);
        }

        System.out.println("Adding test3 to head.");
        for(int i = 0; i < test3.length; i++){
          myDeque.addFirst(test3[i]);
        }

        System.out.println("Popping 1 element from tail.");
        System.out.println(myDeque.removeLast().data);
        System.out.println("Popping 1 element from head.");
        System.out.println(myDeque.removeFirst().data);

        System.out.println("Adding test4 to tail.");
        for(int i = 0; i < test4.length; i++){
          myDeque.addLast(test4[i]);
        }

        System.out.println("Popping all elements from tail");
        for(int i = 0; myDeque.size > 0; i++){
          System.out.println(myDeque.removeLast().data);
        }



}

}
