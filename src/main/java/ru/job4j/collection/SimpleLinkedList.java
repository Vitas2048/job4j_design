package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount;

    public SimpleLinkedList(){
        lastNode = new Node<E>(firstNode, null, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;

        }
        public E getCurrentEl() {
            return item;
        }

        public void setCurentEl(E item) {
            this.item = item;
        }

        public Node<E> getNextEl() {
            return next;
        }

        public void setNextEl(Node<E> next) {
            this.next = next;
        }

    }
    @Override
    public void add(E value) {
        Node<E> prev = lastNode;
        prev.setCurentEl(value);
        lastNode = new Node<E>(prev, null, null);
        prev.setNextEl(lastNode);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> rsl = firstNode.getNextEl();
        for (int i = 0; i < index; i++) {
            rsl = getNextEl(rsl);
        }
        return rsl.getCurrentEl();
    }

    private Node<E> getNextEl(Node<E> node) {
        return node.getNextEl();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int expectedModCount = modCount;
            int it = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return it < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(it++);
            }
        };
    }
}