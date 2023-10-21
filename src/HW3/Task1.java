package HW3;

public class Task1 {
    private Node head;
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Нельзя удалить элемент из пустого списка");
        } else {
            head = head.next;
        }
    }
    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }
    public void removeLast() {
        if (head == null) {
            System.out.println("Нельзя удалить элемент из пустого списка");
        } else {
            Node node = head;
            while (node.next != null) {
                if (node.next.next == null) {
                    node.next = null;
                    return;
                }
                node = node.next;
            }
            head = null;
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

    public void print() {
        if (head == null) {
            System.out.println("Список пуст!");
            return;
        }
        Node node = head;
        while (node.next != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println(node.value);
    }

    public void clearList() {
        head = null;
    }
    public void revert() {
        if (head == null) {
            System.out.println("Список пуст! Не могу развернуть");
        } else if (head.next == null) {
            System.out.println("В списке один элемент! Разворот не имеет смысла.");
        } else {
            Node current = head;
            Node previous = null;
            while (current != null) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
        }
    }


    private class Node {
        private int value;
        private Node next;
    }
}
