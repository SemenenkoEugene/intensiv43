package ru.aston.my_arraylist;

import java.util.Arrays;

/**
 * Написать свой кастомный ArrayList, обязательно реализовать следующие методы:
 * - add(int index, E element)
 * - addAll(Collection<? extends E> c)
 * - clear()
 * - get(int index)
 * - isEmpty()
 * - remove(int index)
 * - remove(Object o)
 * - sort(Comparator<? super E> c)
 *
 * @param <T>
 */
public class MyArrayList<T> {
    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <=0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public void add(int index, T element) {
        checkCapacity();
        if (index >= 0 && index < list.length) {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = element;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException("The index goes outside the array");
        }

    }

    private void checkCapacity() {
        if (size == capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = list[i];
            }
            list = newArray;
            capacity *= 2;
        }
    }

    public T get(int index) {
        if (index >= 0 && index < list.length) {
            return list[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("The index goes outside the array");
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
               "list=" + Arrays.toString(list) +
               ", size=" + size +
               '}';
    }
}
