package com.deliveryninja;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {

    private Object[] buf;
    private int size = 0;

    public CustomList() {
        this.buf = new Object[16];
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
        for (int i = 0; i < size; i++) {
            Object e = buf[i];
            if ((o == null ? e == null : o.equals(e))) {
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
        Object[] objects = new Object[size];
        if (size > 0) {
            System.arraycopy(buf, 0, objects, 0, size);
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        if (ts.length < size) {
            ts = (T[]) new Object[size];
        }

        if (ts.length > size) {
            for (int i = size; i < ts.length; i++) {
                ts[i] = null;
            }
        }
        System.arraycopy(buf, 0, ts, 0, size);

        return ts;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int at = indexOf(o);
        if (at < 0) {
            return false;
        }
        Object[] newBuf = new Object[buf.length];
        System.arraycopy(buf, 0, newBuf, 0, at);
        System.arraycopy(buf, at + 1, newBuf, at, size - at - 1);
        buf = newBuf;
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }

        if (collection.isEmpty()) {
            return false;
        }

        int requiredCapacity = size + collection.size();
        int capacity = buf.length;
        if (capacity < requiredCapacity) {
            Object[] newbuf = new Object[capacity << 1];
            if (i > 0) {
                System.arraycopy(buf, 0, newbuf, 0, i);
            }
            System.arraycopy(collection.toArray(), 0, newbuf, i, collection.size());
            if (i <= size) {
                System.arraycopy(buf, i, newbuf, i + collection.size(), size - i);
            }
        }
        size += collection.size();
        if (i == size) {
            return addAll(collection);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean anyRemoved = false;
        for (Object o: collection) {
            if (remove(o)) {
                anyRemoved = true;
            };
        }
        return anyRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        buf = new Object[0];
        size = 0;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) buf[i];
    }

    @Override
    public E set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        buf[i] = e;
        return e;
    }

    @Override
    public void add(int i, E e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        int capacity = buf.length;
        if (size == capacity) {
            Object[] newBuf = new Object[buf.length << 1];
            System.arraycopy(buf, 0, newBuf, 0, size);
            buf = newBuf;
        }

        buf[i] = e;
        size++;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int j = i + 1; j < size; j++) {
            buf[j - 1] = buf[j];
        }
        size--;
        return (E) buf[size];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null ? get(i) == null : o.equals(get(i)))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i++) {
            if ((o == null ? get(i) == null : o.equals(get(i)))) {
                return i;
            }
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
        return null;
    }
}
