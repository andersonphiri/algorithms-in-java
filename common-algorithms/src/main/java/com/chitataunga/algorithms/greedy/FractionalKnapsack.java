package com.chitataunga.algorithms.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class FractionalKnapsack {
    public static Collection<FractionalKnapsackItem>
            collect(double capacity, int[] values, final double[] weights) {
        LinkedList<FractionalKnapsackItem> result = new LinkedList<>();
        FractionalKnapsackItem[] items = new FractionalKnapsackItem[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = FractionalKnapsackItem.from(values[i], weights[i]);
        }
        sortByAverageWeight(items);
        consumeValue(capacity, items, result);
        return result;
    }

    static void sortByAverageWeight(FractionalKnapsackItem[] items) {
        Arrays.sort(items,
        (left, right) -> Double.valueOf(right.average()).compareTo(left.average()));
    }

    static void consumeValue(double knapSackSize,
        FractionalKnapsackItem[] sortedItems,
            Queue<FractionalKnapsackItem> refResult) {
        
        for (var item : sortedItems) {
            if (knapSackSize == 0) {
                return;
            }
            double toTake = 1;
            if (item.weight() > knapSackSize) {
                toTake = knapSackSize/item.weight();
            }
            item.take(toTake);
            refResult.add(item);
            knapSackSize = knapSackSize - item.weight();
        }    
    }
}
