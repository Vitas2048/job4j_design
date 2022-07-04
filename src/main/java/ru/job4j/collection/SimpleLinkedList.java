package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount;

    public SimpleLinkedList() {
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
        Objects.checkIndex(index, size);
        Node<E> rsl = firstNode.getNextEl();
        for (int i = 0; i < index; i++) {
            rsl = rsl.getNextEl();
        }
        return rsl.getCurrentEl();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int expectedModCount = modCount;
            Node<E> it = new Node<>(null, null, firstNode);

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return it.next != null && firstNode.next.item != null
                        && it.next.next.getCurrentEl() != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                it = it.next;
                return it.next.item;
            }
        };
    }
}