package com.deliveryninja;


import java.lang.reflect.Array;
import java.util.*;

public class CustomList<E> implements List<E> {

    private Object[] backedArray;
    private int size;

    public CustomList() {
        this.backedArray = new Object[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < backedArray.length; i++) {
            if (backedArray[i] != null && backedArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] toBeReturned = new Object[size];
        for (int i = 0; i < size; i++) {
            toBeReturned[i] = backedArray[i];
        }
        return toBeReturned;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        T[] toBeReturned = ts;
        if (ts.length==0) {
            toBeReturned = (T[]) new Object[size];
        }
        for (int i = 0; i < size; i++) {
            toBeReturned[i] = (T) backedArray[i];
        }
        return toBeReturned;
    }

    @Override
    public boolean add(E e) {
        backedArray[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {

        throw new UnsupportedOperationException();

    }

    @Override
    public boolean retainAll(Collection<?> collection) {

        throw new UnsupportedOperationException();

    }

    @Override
    public void clear() {
        backedArray = new Object[10];
        size = 0;
    }

    @Override
    public E get(int i) {
        return (E) backedArray[i];
    }

    @Override
    public E set(int i, E e) {
        E oldRef = (E) backedArray[i];
        backedArray[i] = e;
        return oldRef;
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < backedArray.length; i++) {
            if (o!=null & o.equals(backedArray[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = backedArray.length-1; i >=0 ; i--) {
            if (o!=null && o.equals(backedArray[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return (ListIterator<E>) Arrays.asList(backedArray).listIterator(backedArray.length);
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
       CustomList<E> toBeReturned = new CustomList<>();
        for (int j = i; j < i1 ; j++) {
            toBeReturned.add((E) backedArray[j]);
        }
        return toBeReturned;
    }
}
