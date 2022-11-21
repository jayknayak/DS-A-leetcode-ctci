package com.StackAndQueue;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Animal> dog = new LinkedList<Animal>();
	LinkedList<Animal> cat = new LinkedList<Animal>();
	LinkedList<Animal> allAnimals = new LinkedList<Animal>();
	public void eneque (Animal animal) {
		if(animal instanceof Dog) {
			dog.add(animal);
		}
		else {
			cat.add(animal);
		}
		allAnimals.add(animal);
	}
	
	public Animal dequeAny() {
		Animal animal=allAnimals.removeFirst();
		if(animal instanceof Dog) {
			return dog.removeFirst();
		}
		else {
			return cat.removeFirst();
		}
	}
	public Animal dequeDog() {
		Animal animal = dog.removeFirst();
		allAnimals.remove(animal);
		return animal;
	}
	public Animal dequeCat() {
		Animal animal = cat.removeFirst();
		allAnimals.remove(animal);
		return animal;
	}
	public void printAnimalQueue() {
		for(int i=0;i<allAnimals.size();i++) {
			System.out.println(allAnimals.get(i).getAnimalName());
		}
	}
	public void printDogQueue() {
		for(int i=0;i<dog.size();i++) {
			System.out.println(dog.get(i).getAnimalName());
		}
	}
	public void printCatQueue() {
		for(int i=0;i<cat.size();i++) {
			System.out.println(cat.get(i).getAnimalName());
		}
	}
}
