import java.util.*;
public class StevenTester {
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        LinkedList<String> list = new LinkedList<String>();
        for(int i = 0; i < 10; i++){
          list.add("" + i);
          test.add("" + i);
        }
        
        System.out.println("add() at end test");
        if (!compare(test, list)) debug(test, list);

        System.out.println("add() at index test");
        try {
          test.add(11, "e");
          System.out.println("add() at index should throw IndexOutOfBounds exception for index < 0 || index > size");
        } catch (IndexOutOfBoundsException e) {
        }
        test.add(0, "-1");
        list.add(0, "-1");
        test.add(11, "11");
        list.add(11, "11");
        test.add(3, "z");
        list.add(3, "z");
        if (!compare(test, list)) debug(test, list);
        
        System.out.println("extend() test");
        MyLinkedList test2 = new MyLinkedList();
        LinkedList<String> list2 = new LinkedList<String>();
        for(int i = 0; i < 10; i++){
          list2.add("" + i);
          test2.add("" + i);
        }
        test.extend(test2);
        list.addAll(list2);
        list2.clear();
        if (!compare(test, list)) debug(test, list);
        if (!compare(test2, list2)) debug(test2, list2);
  
        
        System.out.println("remove() test");
        for(int i = list.size()-1; i >=0; i--){
          list.remove(i);
          test.remove(i);
        }
        if (!compare(test, list)) debug(test, list);

        System.out.println("extend() empty lists tests");
        MyLinkedList e1 = new MyLinkedList();
        MyLinkedList e2 = new MyLinkedList();
        e1.extend(e2);
        System.out.println("should be [] and [], got:" + e1.toString() + " and " + e2.toString());
        e1.add("3");
        e1.extend(e2);
        System.out.println("should be [3] and [], got:" + e1.toString() + " and " + e2.toString());
        e1.remove(0);
        e2.add("3");
        e1.extend(e2);
        System.out.println("should be [3] and [], got:" + e1.toString() + " and " + e2.toString());

        MyLinkedList e4 = new MyLinkedList();
        MyLinkedList e5 = new MyLinkedList();
        e5.add("e");
        e4.extend(e5);
        System.out.println("should be [e] and [], got:" + e4.toString() + " and " + e5.toString());

    }
    public static boolean compare (MyLinkedList t, LinkedList<String> list ){
      return t.toString().equals(list.toString()) && t.size() == list.size();
    }
    public static void debug (MyLinkedList t, LinkedList<String> list ){
      System.out.println("expected " + list.toString() + " size " + list.size());
      System.out.println("got " + t.toString() + " size " + t.size());
    }

}
