package com.mobiquityinc.packer;

import com.mobiquityinc.exception.KnapsackInitException;

public class Knapsack {
    public double maxWeight = 100.0;
    public final int capacity = 15;

    public Knapsack(double weight) throws KnapsackInitException {
        if (weight < 0 || weight > this.maxWeight) {
            throw new KnapsackInitException();
        }
        this.maxWeight = weight;
    }

    public Knapsack() {}
}
