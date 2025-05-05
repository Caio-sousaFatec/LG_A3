package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack cannot be null");
        }
        this.stack = stack;
    }

    public List<T> sort() throws StackEmptyException {
        List<T> sortedList = new ArrayList<>();

        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }

        Collections.sort(sortedList);

        return sortedList;
    }
}

