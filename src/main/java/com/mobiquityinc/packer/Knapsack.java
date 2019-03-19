package com.mobiquityinc.packer;

import com.mobiquityinc.exception.KnapsackInitException;
import com.mobiquityinc.exception.KnapsackMaxCapacityAchievedException;
import com.mobiquityinc.exception.KnapsackOverweightedException;

import java.util.ArrayList;

public class Knapsack {
    public double maxWeight = 100.0;
    public final int capacity = 15;
    private double weight = 0;
    private ArrayList<Item> items = new ArrayList<>();

    public Knapsack(double weight) throws KnapsackInitException {
        if (weight < 0 || weight > this.maxWeight) {
            throw new KnapsackInitException();
        }
        this.maxWeight = weight;
    }

    public Knapsack() {}

    public int getLength() {
        return this.items.size();
    }

    public void add(Item i)
            throws KnapsackMaxCapacityAchievedException, KnapsackOverweightedException {
        if (this.getLength() > this.capacity) {
            throw new KnapsackMaxCapacityAchievedException();
        }
        if (this.weight + i.weight > this.maxWeight) {
            throw new KnapsackOverweightedException();
        }
        this.weight += i.weight;
        items.add(i);
    }
}
