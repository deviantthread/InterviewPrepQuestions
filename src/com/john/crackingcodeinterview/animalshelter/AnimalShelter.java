package com.john.animalshelter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

public class AnimalShelter {
    Map<AnimalType, Queue<AnimalEntry>> animals = new HashMap<AnimalType, Queue<AnimalEntry>>();

    public AnimalShelter(AnimalType... supportedAnimalTypes) {
        for (AnimalType animalType : supportedAnimalTypes) {
            animals.put(animalType, new LinkedList<AnimalEntry>());
        }
    }

    public Animal dequeueAny() {
        List<Queue<AnimalEntry>> queuesWithAnimals = findQueuesWithAnimals();
        if (queuesWithAnimals.isEmpty()) {
            throw new NoSuchElementException("no animals!");
        }

        Queue<AnimalEntry> queueWithOldestAnimal = findQueueWithOldestAnimal(queuesWithAnimals);
        return queueWithOldestAnimal.remove().getAnimal();
    }

    private List<Queue<AnimalEntry>> findQueuesWithAnimals() {
        List<Queue<AnimalEntry>> queuesWithAnimals = new LinkedList<Queue<AnimalEntry>>();
        for (Queue<AnimalEntry> animalQueue : animals.values()) {
            if (!animalQueue.isEmpty()) {
                queuesWithAnimals.add(animalQueue);
            }
        }
        return queuesWithAnimals;
    }

    private Queue<AnimalEntry> findQueueWithOldestAnimal(List<Queue<AnimalEntry>> queuesWithAnimals) {
        Queue<AnimalEntry> queueWithOldestAnimal = queuesWithAnimals.get(0);
        for (Queue<AnimalEntry> animalQueue : queuesWithAnimals) {
            if (animalQueue.peek().getInsertedEpochTime() > queueWithOldestAnimal.peek().getInsertedEpochTime()) {
                queueWithOldestAnimal = animalQueue;
            }
        }

        return queueWithOldestAnimal;
    }

    public Animal dequeueCat() {
        return dequeueAnimal(AnimalType.CAT);
    }

    public Animal dequeueDog() {
        return dequeueAnimal(AnimalType.DOG);
    }

    public Animal dequeueAnimal(AnimalType animalType) {
        verifyAnimalTypeSupported(animalType);

        return dequeueAnimal(animals.get(animalType));
    }

    private Animal dequeueAnimal(Queue<AnimalEntry> animalQueue) {
        if (animalQueue.isEmpty()) {
            throw new NoSuchElementException("no animal here");
        }

        return animalQueue.remove().getAnimal();
    }

    public void enqueueAnimal(Animal animal) {
        verifyAnimalTypeSupported(animal.getAnimalType());

        AnimalEntry entry = new AnimalEntry(animal, System.currentTimeMillis());
        animals.get(animal.getAnimalType()).add(entry);
    }

    private void verifyAnimalTypeSupported(AnimalType animalType) {
        if (!animals.containsKey(animalType)) {
            throw new NoSuchElementException("animal type not supported:" + animalType);
        }
    }

}
