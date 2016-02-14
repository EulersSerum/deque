

public class Deque{

  private Node headNode;
  private Node tailNode;
  private int size;

  public Deque(){
    headNode = null;
    tailNode = null;
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public int size(){
    return size;
  }

  public void addFirst(String item){
    Node newNode = new Node(item);
    newNode.next = headNode;
    if(size > 0) headNode.previous = newNode;
    headNode = newNode;
    size++;
  }

  public void addLast(String item){
    Node newNode = new Node(item);
    newNode.previous = tailNode;
    if(size > 0) tailNode.next = newNode;
    tailNode = newNode;
    size++;
  }

  public Node removeFirst(){
    if(size > 0){
      Node refNode = headNode;
      headNode = headNode.next;
      if(size > 1) headNode.previous = null;
      size--;
      return refNode;
    }
    else return null;

  }

  public Node removeLast(){
      if(size > 0){
      Node refNode = tailNode;
      tailNode = tailNode.previous;
      if(size > 1) tailNode.next = null;
      size--;
      return refNode;
    } else return null;
  }

  class Node{
    String data;
    Node next;
    Node previous;
    public Node(String item){
      data = item;
    }

  }

  public static void main(String[] args){
    Deque myDeque = new Deque();

    System.out.println("Adding args to head.");
    for(int i = 0; i < args.length; i++){
      myDeque.addFirst(args[i]);
    }

    System.out.println("Popping args from tail.");
    int size = myDeque.size();
    for(int i = 0; i < size; i++){
      System.out.println(myDeque.removeLast().data);
    }


  }

}
