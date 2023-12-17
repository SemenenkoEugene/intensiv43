package ru.aston.my_arraylist;

import java.util.*;

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


    public void add(int index, T element) throws ClassCastException {
        checkCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        T[] newArray = (T[]) new Object[size + 1];
        System.arraycopy(list, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(list, index, newArray, index + 1, size - index);

        list = newArray;
        size++;
    }

    private void checkCapacity() {
        if (size == capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];
            if (size >= 0)
                System.arraycopy(list, 0, newArray, 0, size);
            list = newArray;
            capacity *= 2;
        }
    }

    public void addAll(Collection<? extends T> c) {
        for (T item : c) {
            if (size == list.length) {
                list = Arrays.copyOf(list, list.length * 2);
            }
            list[size] = item;
            size++;
        }
    }

    public void clear() {
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        return list[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
            size--;
        }
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void sort(Comparator<? super T> c) {
        T[] temp = (T[]) new Object[size];
        mergeSort(0, size - 1, temp, c);
    }

    private void mergeSort(int low, int high, T[] temp, Comparator<? super T> c) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid, temp, c);
            mergeSort(mid + 1, high, temp, c);
            merge(low, mid, high, temp, c);
        }
    }

    private void merge(int low, int mid, int high, T[] temp, Comparator<? super T> c) {
        if (high + 1 - low >= 0)
            System.arraycopy(list, low, temp, low, high + 1 - low);

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (c.compare(temp[i], temp[j]) <= 0) {
                list[k] = temp[i];
                i++;
            } else {
                list[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            list[k] = temp[i];
            k++;
            i++;
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }


}
