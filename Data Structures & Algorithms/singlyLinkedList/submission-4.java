class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
       
    }

    public int get(int index) {
        if (index < 0) {
           // throw new IndexOutOfBoundsException("Index must be non-negative");
            return -1;
        }

        Node current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.data;
            }

            current = current.next;
            i++;
        }

        // throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public boolean remove(int index) {
        if (index < 0) {
            // throw new IndexOutOfBoundsException("Index must be non-negative");
            return false;
        }

        if (head == null) {
            // throw new NoSuchElementException("Cannot remove element: list is empty");
            return false;
        }

        if (index == 0) {
            if (head.next == null) {
                tail = null;
            }
            head = head.next;
            return true;
        }

        Node current = head;
        Node prev = null;
        int i = 0;

        while (i < index && current != null) {
            prev = current;
            current = current.next;
            i++;
        }

        if (current == null) {
            // throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
            return false;
        }

        prev.next = current.next;
        if (current.next == null) {
            tail = prev;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;

        while (current != null) {
            values.add(current.data);
            current = current.next;
        }

        return values;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}