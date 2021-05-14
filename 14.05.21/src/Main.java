public class Main {
    public static void main(String[] args) {
        LRUCache<String> s= new LRUCache<>(5);
        s.add("Seynur1");
        s.add("Seynur2");
        s.add("Seynur3");
        s.add("Seynur4");
        s.add("Seynur5");
        s.add("Seynur6");
        s.printAll();
    }
}
