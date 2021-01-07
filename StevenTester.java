public class StevenTester {
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        test.add("1"); 
        System.out.println(test.get(0));
        test.add("2"); 
        System.out.println(test.get(0));
        test.add("3"); 
        System.out.println(test.get(0));
        System.out.println(test.toString());
    }
}
