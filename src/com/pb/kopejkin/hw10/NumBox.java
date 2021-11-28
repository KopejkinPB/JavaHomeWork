package com.pb.kopejkin.hw10;


public class NumBox<T extends Number> {
    private final T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void add(T num) {
        try {
            int i = findPlace();
            numbers[findPlace()] = num;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int findPlace() throws Exception {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                return i;
            }
        }

        throw new Exception("Массив переполнен");
    }

    public T get(int i) {
        return numbers[i];
    }

    public int length() {
        int length = 0;
        for (T number : numbers) {
            if (number != null) {
                length++;
            }
        }

        return length;
    }

    public double sum() {
        double result = 0;
        for (T number : numbers) {
            if (number != null) {
                result += new Double(number.toString());
            }
        }

        return result;
    }

    public double average() {
        double average = sum() / length();
        return average;
    }

    public T max() {
        T result = get(0);
        for (T number : numbers) {
            if (result.doubleValue() < number.doubleValue()) {
                result = number;
            }
        }

        return result;
    }
}
