public class LinkedList<Item>{

  public Node firstNode;

  public LinkedList(){
    firstNode = null;
  }

  public boolean isEmpty(){
    return (firstNode == null);
  }

  public void insertFirst(Item data){
    Node newNode = new Node(data);
    newNode.next = firstNode;
    firstNode = newNode;
  }

  public Node removeFirst(){
    Node nodeRef = firstNode;
    if(!isEmpty()) firstNode = firstNode.next;
    return nodeRef;
  }

  public class Node<Item> {

    Item data;
    Node next;

    public Node(Item item){
      data = item;
    }

  }

  public static void main(String[] args){
    LinkedList myList = new LinkedList();

    if(myList.isEmpty()) System.out.println("It's empty.");
    else System.out.println("Has nodes in it.");

    for(int i = 0; i < args.length; i++){
      myList.insertFirst(Integer.parseInt(args[i]));
    }

    while(!myList.isEmpty()){
      System.out.println(myList.removeFirst().data);
    }

  }

}
