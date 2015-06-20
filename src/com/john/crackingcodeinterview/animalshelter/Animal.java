package com.john.animalshelter;

public class Animal {
    private final AnimalType animalType;

    public Animal(AnimalType animalType) {
        this.animalType = animalType;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

}
