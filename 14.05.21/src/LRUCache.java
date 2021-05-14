import java.util.Iterator;

public class LRUCache<T> {
    private static int count=0;
    private final int size;

    private Node<T> head;
    private Node<T> end;

    public LRUCache(int size) {
        this.size = size;
    }

    public void add(T item){
        Node<T> newNode = new Node<>(item);
        if (this.head == null) {
            this.head = newNode;
            this.end = newNode;
            count++;
            return;
        }
        if(checkSize()){
            head=head.next;
        }
        else {
            count++;
        }
        end.next=newNode;
        end=newNode;
    }

    public T getElement(int index){
        if (isEmpty())
            return null;
        if (index < 0 && index>size) {
            return null;
        }
        Node<T> node = loopNodes(index);
        return node.value;
    }

    public void printAll(){
        Node<T> node= this.head;
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    //helper methods
    private Node<T> loopNodes(int index){
        Node<T> node = this.head;
        while (index > 1) {
            node = node.next;
            index--;
        }
        return node;
    }
    private boolean checkSize(){
        if(size==count){
            return true;
        }
        return false;
    }
    private boolean isEmpty(){
        if(this.head==null){
            System.out.println("List is empty!");
            return true;
        }
        return false;
    }
}
