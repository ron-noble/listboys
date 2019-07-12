package com.deliveryninja;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CustomList<E> implements List<E> {

    private Object[] es = new Object[0];
    private int tip = 0;

    @Override
    public int size() {
        return es.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.stream(es).anyMatch(a -> o == a);
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(es).map(a -> (E) a).collect(toList()).iterator();
    }

    @Override
    public Object[] toArray() {
        return es;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) Arrays.copyOf(es, 0, ts.getClass());
    }

    @Override
    public boolean add(E e) {
        Object[] newEs = new Object[es.length + 1];
        System.arraycopy(es, 0, newEs, 0, es.length);
        newEs[es.length] = e;
        es = newEs;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        es[indexOf(o)] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return Arrays.asList(es).containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Object[] newEs = new Object[es.length + collection.size()];
        System.arraycopy(es, 0, newEs, 0, es.length);
        es = newEs;
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        es = new Object[0];
    }

    @Override
    public E get(int i) {
        return (E) es[i];
    }

    @Override
    public E set(int i, E e) {
        return null;
    }

    @Override
    public void add(int i, E e) {
        es[i] = e;
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("E");
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < es.length; i++) {
            if (es[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < es.length; i++) {
            if (es[i].equals(o)) {
                lastIndex = i;
            }
        }
        return lastIndex;
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
        Object[] toReturn = new Object[i1-i];
        System.arraycopy(es, i, toReturn, 0, i1-i);
        return (List<E>) Arrays.asList(toReturn);
    }
}
