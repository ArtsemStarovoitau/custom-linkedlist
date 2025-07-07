package by.starovoytov;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addLast("Hello");
        list.addLast("Gradle");
        list.addLast("World!");
        
        System.out.println("List size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        
        list.remove(1);
        System.out.println("Element at index 1 after removal: " + list.get(1));
    }
}