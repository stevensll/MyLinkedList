public class MyLinkedList {
    private int size;
    private Node start,end;  
    public MyLinkedList(){
        size = 0;
        }
    
    public int size(){
        return size;
    }
    public boolean add(String value){
        Node newNode = new Node(value);
        if(size == 0) {
            start = newNode;
            end = newNode;
            size++;
        }
        else{
            end.setNext(newNode);
            newNode.setPrev(end);
            end = newNode;
            size++;
        }
        return true;
    }

    public void add(int index, String value){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        Node valBefore = getNodeAtIndex(index-1);
        Node valCurrent = getNodeAtIndex(index);
        valBefore.setNext(newNode);
        //point before to new node
        newNode.setPrev(valBefore);
        //point new node backwards
        newNode.setNext(valCurrent);
        //point new node forwards
        valCurrent.setPrev(newNode);
        //point after to new node
        size++;
    }
    
    public String get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return getNodeAtIndex(index).getData();
    }

    public String set(int index, String value){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        String old = getNodeAtIndex(index).getData();
        getNodeAtIndex(index).setData(value);
        return old;
    }

    public String toString(){
        String s = "[";
        for(int i  = 0; i< this.size; i++){
            s+=this.get(i);
            if(i!= this.size-1) s+=", ";
            else s+= "]";
        }
        return s;
    }
    // helper method to get a Node at specified index
    private Node getNodeAtIndex(int index){
        Node current = start;
        for (int i = 0; i<index; i++){
          current = current.getNext();  
        }
        return current;
    }
}
