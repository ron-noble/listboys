package com.deliveryninja;

import java.lang.reflect.Array;
import java.util.*;

public class CustomList<E> implements List<E> {

    private int size = 0;
    private static int initialCapacity = 10;
    private Object[] data;

    @Override
    public int size() {
        return size;
    }

    CustomList() {
        this(initialCapacity);
    }

    CustomList(int capacity){
       data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            return false;

        for (int e = 0; e < size; e++) {
            if (data[e].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        int tsSize = ts.length;

        for(int i = 0; i < tsSize; i++) {
            ts[i] = (T) get(i);
        }

        return ts;
    }

    @Override
    public boolean add(E e) {
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {

        for(Object obj: collection) {
            boolean contains = contains(obj);
            if(!contains)
                return false;
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
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
        data = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public E get(int i) {
        return (E) data[i];
    }

    @Override
    public E set(int i, E e) {
        E e1 = get(i);
        data[i] = e;
        return e1;
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

        for (int index  = 0; index < size; index ++) {
            if(get(index).equals(o))
                return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        for (int index  = size -1; index >= 0; index --) {
            if(get(index).equals(o))
                return index;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        List customList = null;
        int capacity = i1 - i;
        if(i >= 0 && (i1 -1) < size && i1 > i && capacity > 0){
            customList = new CustomList(capacity);

            for(int index = i ;index < i1; index ++){
                customList.add(get(index));
            }
        }
        return customList;
    }
}
