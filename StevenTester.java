import java.util.LinkedList;

public class StevenTester {
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        if(test.size() != 0) System.out.println("LinkedList constructed with size different than 0");
        System.out.println(test.toString() + "| should return []");
        System.out.println("ADD AT END TESTS");
        test.add("3");
        System.out.println(test.toString() + "| should return [3]");
        test.add("4");
        System.out.println(test.toString() + "| should return [3,3]");
        System.out.println("ADD AT INDEX TESTS");
     

    }
}
