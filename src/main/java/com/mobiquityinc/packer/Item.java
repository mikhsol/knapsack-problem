package com.mobiquityinc.packer;

import com.mobiquityinc.exception.ItemInitException;

public class Item {
    public final int id;
    public final double weight;
    public final double price;
    private final double maxWeight = 100.0;
    private final double minWeight = 0.0;

    public Item(int id, double weight, double price) throws ItemInitException {
        this.id = id;
        if (weight > this.maxWeight || weight < this.minWeight) {
            throw new ItemInitException();
        }
        this.weight = weight;
        this.price = price;

    }
}
