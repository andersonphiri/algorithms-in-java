package com.chitataunga.algorithms.greedy;

public class FractionalKnapsackItem {
    private double weight;
    private double value;
    private double averageUnitValue;
    private double percentage;

    private FractionalKnapsackItem(double value, double weight) {
        this.value = value;
        this.weight = weight;
        averageUnitValue = weight / value;
        percentage = 1;

    }

    public static FractionalKnapsackItem from(double value, double weight) {
        return new FractionalKnapsackItem(value, weight);
    }

    public void take(double percentage) {
        this.percentage = percentage;
    }

    public double average() {
        return this.averageUnitValue;
    }

    public double weight() {
        return this.weight * this.percentage;
    }

    public double value() {
        return this.value;
    }
}
