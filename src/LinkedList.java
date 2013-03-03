import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    private class Node {
        Item value;
        Node next;
        Node prev;

        public Node(Item value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public Iterator<Item> iterator()  { return new ListIterator();  }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.value;
            current = current.next;
            return item;
        }
    }

    private Node first;
    private int size = 0;

    public void addFirst(Item value) {
        first = new Node(value, first, null);

        if(size > 0)
            first.next.prev = first;

        size++;
    }

    public void addLast(Item value) {
        // if the list is empty, creates and initializes new node and sets to head of the list
        if(first == null) {
            first = new Node(value, null, null);
            size++;
            return;
        }

        // looks up the last node of the list and saves it
        Node x = first;
        while (x.next != null)
            x = x.next;

        // appends the specified value to the end of this list
        x.next = new Node(value, null, x);

        size++;
    }

    public Item remove(int index) {
        if(first == null || index >= size())
            return null;

        Node n = first;

        for(int i = 0; i < index; i++) {
            n = n.next;
        }

        n.prev.next = n.next;
        n.next.prev = n.prev;

        return n.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
