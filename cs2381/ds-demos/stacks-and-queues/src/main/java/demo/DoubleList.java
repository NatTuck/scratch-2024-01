package demo;

public class DoubleList<T> {
    Cell<T> head;
    Cell<T> tail;

    DoubleList() {
        head = null;
        tail = null;
    }

    void push(T item) {
        var oldTail = this.tail;
        this.tail = new Cell<T>(tail, item, null);
        if (oldTail == null) {
            this.head = this.tail;
        }
        else {
            oldTail.next = this.tail;
        }
    }

    T shift() {
        T item = head.data;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        }
        return item;
    }
}

class Cell<T> {
    T data;
    Cell<T> prev;
    Cell<T> next;

    Cell(Cell<T> prev, T data, Cell<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
