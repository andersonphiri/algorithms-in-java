package com.chitataunga.algorithms.greedy;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class FractionalKnapsackTest {
    
    @Test
    public void shouldComputeCorrectCapacityAndTotalValue() {
        double expectedSum = 1140;
        double[] weights = { 50, 20, 30 };
        int[] values = { 600, 500, 400 };
        double capacity = 70;
        Collection<FractionalKnapsackItem> actual 
                = FractionalKnapsack.collect(capacity, values, weights);
        double actualSum = actual.stream().map(i -> i.value()).reduce(0.00,
                Double::sum);
        double actualCapacity = actual.stream().map(i -> i.weight()).reduce(0.00,
                Double::sum);
        
        assertThat(actualSum).isEqualTo(expectedSum);
        assertThat(actualCapacity).isEqualTo(capacity);
    }
    
}
