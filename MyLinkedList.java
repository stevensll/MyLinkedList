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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if (size == 0){
          add(value);
        } else {
            Node newNode = new Node(value);
            Node valBefore = getNodeAtIndex(index-1);
            Node valCurrent = getNodeAtIndex(index);
            if (index == 0){
                start = newNode;
                newNode.setNext(valCurrent);
                valCurrent.setPrev(newNode);
                size++;
            } else if (index == size){
                end = newNode;
                newNode.setPrev(valBefore);
                valBefore.setNext(newNode);
                size++;
            } else {
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
        }
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
        if (size == 0) s = "[]";
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

    public String toStringReversed() {
        String s ="[";
        if (size == 0) s = "[]";
        else {
            for (int i = size-1; i >= 0; i--){
                s+=get(i);
                if(i!=0) s+=", ";
                else s+= "]";
            }
        }
        return s;
    }

    public String remove(int index){
        if (index  < 0 || index  >= size()) throw new IndexOutOfBoundsException();
        String s = getNodeAtIndex(index).getData();
        // size = 1 case
        if (size == 1 ){
            start.setNext(null);
            end.setPrev(null);
            size --;
        } else {
            // removing from head case
            if(index == 0){
                getNodeAtIndex(index+1).setPrev(null);
                start = getNodeAtIndex(index+1);
                size --;
            // removing from tail case
            } else if (index == size-1) {
                getNodeAtIndex(index-1).setNext(null);
                end = getNodeAtIndex(index-1);
                size --;
            // middle
            } else {
                getNodeAtIndex(index-1).setNext(getNodeAtIndex(index+1));
                getNodeAtIndex(index+1).setPrev(getNodeAtIndex(index-1));
                size --;
            }
        }
        
        return s;
    }
    /*
    *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
    *@postcondition: The size of other is reduced to 0.
    *@postcondition: The size of this is now the combined sizes of both original lists.
    SHOULD BE CONSTANT RUN TIME.
    */
    public void extend(MyLinkedList other){
        if (other.size == 0){
            return;
        } else if(this.size == 0){
            this.start = other.start;
            this.end = other.start;
        }
            this.end.setNext(other.start);
            other.start.setPrev(this.end);
            this.end = other.end;
            
            this.size += other.size();
            other.size = 0;
            other.start = null;
            other.end = null; 
    }
}
