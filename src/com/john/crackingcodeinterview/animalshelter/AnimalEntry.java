package com.john.animalshelter;

public class AnimalEntry {
    private final Animal animal;
    private final long insertedEpochTime;

    public AnimalEntry(Animal animal, long epochTime) {
        this.animal = animal;
        this.insertedEpochTime = epochTime;
    }

    public Animal getAnimal() {
        return animal;
    }

    public long getInsertedEpochTime() {
        return insertedEpochTime;
    }

}
