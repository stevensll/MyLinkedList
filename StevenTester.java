
public class StevenTester {
    public static void main(String[] args) {

        MyLinkedList test = new MyLinkedList();
        if(test.size() != 0) System.out.println("LinkedList constructed with size different than 0");
        // System.out.println(test.toString() + "| should return []");
        // System.out.println("ADD AT END TESTS");
        test.add("3");
        // System.out.println(test.toString() + "| should return [3]");
        test.add("4");
        test.add("5");
        test.add("6");
        test.add("7");
        test.add("8");
        // System.out.println(test.toString() + "| should return [3,3]");
        // System.out.println("ADD AT INDEX TESTS");
        // System.out.println(test.toStringReversed());

        //passed Mr. K's basic tester
        /*
        test.remove(2);
        System.out.println(test.toString());
        test.remove(0);
        System.out.println(test.toString());
        test.remove(3);
        System.out.println(test.toString());
        test.remove(0);
        test.remove(0);
        test.remove(0);
        System.out.println(test.toString());
        */
        MyLinkedList a = new MyLinkedList();
        MyLinkedList b = new MyLinkedList();
        for(int i = 0; i < 10; i++){
          if(i < 5){
            a.add(i+"");
          }else{
            b.add(i+"");
          }
        }
        System.out.println();
        System.out.println("A:"+a+a.size());
        System.out.println("B:"+b+b.size());
    
        a.extend(b);
        System.out.println("A:"+a+a.size());
        System.out.println("B:"+b+b.size());
        System.out.println("A reversed:"+a.toStringReversed()+a.size());
        System.out.println("B reversed:"+b.toStringReversed()+b.size());        
    }
}
