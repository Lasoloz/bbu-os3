package com.lasoloz.ubb.os3.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        new Example().task();
    }

    private void task() {
        Integer[] data = {2, 3, 9, 1};
        printProcessedData(processData(data));
        printProcessedData(processDataLoop(data));
    }

    private List<Integer> processData(Integer[] rawData) {
        return Arrays.stream(rawData)
                .filter(x -> x % 2 == 1)
                .map(x -> x + 2)
                .collect(Collectors.toList());
    }

    private List<Integer> processDataLoop(Integer[] rawData) {
        List<Integer> resultArray = new ArrayList<>();
        for (int i = 0; i < rawData.length; ++i) {
            Integer currentData = rawData[i];
            if (currentData % 2 == 1) {
                resultArray.add(currentData + 2);
            }
        }
        return resultArray;
    }

    private void printProcessedData(List<Integer> processedData) {
        System.out.println("Processed data:");
        processedData.forEach(System.out::println);
    }
}
