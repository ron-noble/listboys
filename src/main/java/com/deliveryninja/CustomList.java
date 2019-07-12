package com.deliveryninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {

    private int actualSize = 0;
    private int defaultCapacity = 10;

    private Object[] backingArray = new Object[defaultCapacity];

    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public boolean isEmpty() {
        return actualSize < 1;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.asList(backingArray).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] copyObject = new Object[backingArray.length];
        System.arraycopy(backingArray, 0, copyObject, 0, backingArray.length);
        return copyObject;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) toArray();
    }


    public static void main(String[] args) {
        List thing = new ArrayList(5);

        List sublist = new ArrayList(1);

        thing.addAll(2, sublist);
    }
    @Override
    public boolean add(E e) {
        backingArray[actualSize] = e;
        actualSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {


        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i].equals(o)) {
                backingArray[i] = null;
            }
        }
        int position = 1;
//
//        System.arraycopy(backingArray, position, backingArray, position -1, backingArray.length- position);


        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return collection.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return collection.stream().allMatch(this::add);
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (i >= actualSize) {
            throw new ArrayIndexOutOfBoundsException();
        }


        Object[] incoming = collection.toArray();
        System.arraycopy(incoming, 0, backingArray, i, incoming.length);
        actualSize+=incoming.length;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return collection.stream().allMatch(this::remove);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        backingArray = new Object[defaultCapacity];
        actualSize = 0;

    }

    @Override
    public E get(int i) {
        return (E) backingArray[i];
    }

    @Override
    public E set(int i, E e) {
        E ele = (E) backingArray[i];
        backingArray[i] = e;
        return ele;
    }

    @Override
    public void add(int i, E e) {
        if (i < actualSize) {
            backingArray[i] = e;
            actualSize++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(int i) {
        Object ele = backingArray[i];
        backingArray[i] = null;
        actualSize--;
        return (E) ele;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = backingArray.length; i > 0; i--) {
            if (backingArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return (ListIterator<E>) Arrays.asList(backingArray).listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        ListIterator listIterator = listIterator();
        for (int counter = 0; counter < i; counter++) {
            listIterator.next();
        }
        return listIterator;
    }

    @Override
    public List<E> subList(int i, int i1) {
        int length = i1 - i;
        Object[] copyObject = new Object[length];
        System.arraycopy(backingArray, i, copyObject, 0, length);
        return (List<E>) Arrays.asList(copyObject);
    }
}
