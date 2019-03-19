package com.mobiquityinc.packer;

import com.mobiquityinc.exception.KnapsackInitException;
import com.mobiquityinc.exception.KnapsackMaxCapacityAchievedException;

import java.util.ArrayList;

public class Knapsack {
    public double maxWeight = 100.0;
    public final int capacity = 15;
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

    public void add(Item i) throws KnapsackMaxCapacityAchievedException {
        if (this.getLength() > capacity) {
            throw new KnapsackMaxCapacityAchievedException();
        }
        items.add(i);
    }
}
