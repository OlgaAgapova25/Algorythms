package HW3;

public class Task2 {
    private Node head;
    private Node tail;

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
    }

    public void delFirst() {
        if (head == null) {
            System.out.println("Список пуст!");
        } else if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head.next.previous = null;
            head = head.next;
        }
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void delLast() {
        if (tail == null) {
            System.out.println("Список пуст!");
        } else if (tail.previous == null) {
            head = null;
            tail = null;
        } else {
            tail.previous.next = null;
            tail = tail.previous;
        }
    }

    public boolean contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void revert() {
        if (head == null) {
            System.out.println("Список пуст! Не могу развернуть список.");
        } else {
            Node node = head;
            head = tail;
            tail = node;
            node = head;
            while (node != null) {
                Node next = node.next;
                node.next = node.previous;
                node.previous = next;
                node = node.next;
            }
        }
    }

    public void clearList() {
        head = null;
        tail = null;
    }

    public void print() {
        if (head == null) {
            System.out.println("Список пуст!");
        } else {
            Node node = head;
            while (node != tail) {
                System.out.print(node.value + " -> ");
                node = node.next;
            }
            System.out.println(tail.value);
        }
    }

    class Node {
        private int value;
        private Node previous;
        private Node next;

        private Node() {
        }

        private Node(int value) {
            this.value = value;
        }
    }
}
