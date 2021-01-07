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

    }
    
    public String get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        String v = "";
        for(int i = 0; i<size; i++){
            if(i == index){
                v = current.getData();
            }
            else current = current.getNext();
        }
        return v;
    }

    public String set(int index, String value){
        return null;

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
    //Any helper method that returns a Node object MUST BE PRIVATE!
}
