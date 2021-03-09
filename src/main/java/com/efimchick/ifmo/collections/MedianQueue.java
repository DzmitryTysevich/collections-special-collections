package com.efimchick.ifmo.collections;

import java.util.Collections;
import java.util.LinkedList;

class MedianQueue extends LinkedList<Integer> {
    private final LinkedList<Integer> medianQueue = new LinkedList<>();

    @Override
    public int size() {
        return medianQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
        medianQueue.clear();
    }

    @Override
    public boolean offer(Integer integer) {
        medianQueue.offer(integer);
        rearrangeElements();
        return true;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        return medianQueue.poll();
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return medianQueue.peek();
    }

    private void rearrangeElements() {
        LinkedList<Integer> tempList = new LinkedList<>(medianQueue);
        Collections.sort(tempList);
        clear();
        int initialSize = tempList.size();
        for (int i = 0; i < initialSize; i++) {
            if (isEven(i)) {
                medianQueue.addFirst(tempList.pollLast());
            } else {
                medianQueue.addFirst(tempList.pollFirst());
            }
        }
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}