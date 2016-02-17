public class Deque {

  //make it more like a stack for the first try;
  private int[] dataArray;
  private int size = 0;
  private int pointer = 0;

  public Deque(){
    //Not sure I need anything here.
    dataArray = new int[10];
  }

  public int getSize(){
    return size;
  }

  public void addFirst(int data){
    dataArray[pointer] = data;
    size++;
    checkSize();
    pointer++;
  }

  public int removeFirst(){
    int data = dataArray[pointer];
    size--;
    checkSize();
    pointer--;
    return data;
  }

  public void checkSize(){
    int[] newArray;
    if(size > dataArray.length/2){
      newArray = new int[dataArray.length*2];
      for(int i = 0; i < size; i++){
        newArray[i] = dataArray[i];
      }
      dataArray = newArray;
    }
    if(size < dataArray.length/4){
      newArray = new int[dataArray.length/2];
      for(int i = 0; i < size; i++){
        newArray[i] = dataArray[i];
      }
      dataArray = newArray;
    }

  }

  public static void main(String[] args){

    Deque myDeque = new Deque();

    for(int i = 0; i < Integer.parseInt(args[0]); i++){
      myDeque.addFirst(i);
    }

    int size = myDeque.getSize();
    for(int i = 0; i < size; i++){
      System.out.println(myDeque.removeFirst());
    }

  }


}
