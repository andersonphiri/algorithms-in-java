package com.chitataunga.algorithms.greedy;

public class FractionalKnapsackItem {
    private double weight;
    private double value;
    private double unitValue;
    private double percentage;

    private FractionalKnapsackItem(double value, double weight) {
        this.value = value;
        this.weight = weight;
        unitValue =  value / weight;
        percentage = 1;

    }

    public static FractionalKnapsackItem from(double value, double weight) {
        return new FractionalKnapsackItem(value, weight);
    }

    public void take(double percentage) {
        this.percentage = percentage;
    }

    public double average() {
        return this.unitValue;
    }

    public double weight() {
        return this.weight * this.percentage;
    }
    
    public double percent() {
        return this.percentage;
    }

    public double value() {
        return this.value * this.percentage;
    }
}
