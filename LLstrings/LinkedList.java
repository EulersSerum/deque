public class LinkedList{

  public Node firstNode;

  public LinkedList(){
    firstNode = null;
  }

  public boolean isEmpty(){
    return (firstNode == null);
  }

  public void insertFirst(String data){
    Node newNode = new Node(data);
    newNode.next = firstNode;
    firstNode = newNode;
  }

  public Node removeFirst(){
    Node nodeRef = firstNode;
    if(!isEmpty()) firstNode = firstNode.next();
    return nodeRef;
  }

  public static void main(String[] args){
    LinkedList myList = new LinkedList();

    if(myList.isEmpty()) System.out.println("It's empty.");
    else System.out.println("Has nodes in it.");

  }

}
