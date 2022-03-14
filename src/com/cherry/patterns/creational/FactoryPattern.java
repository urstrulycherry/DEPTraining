package com.cherry.patterns.creational;

interface IAnimal {
	void Speak();
}

class Cat implements IAnimal {
	@Override
	public void Speak() {
		System.out.println("Meow meow");
	}
}

class Dog implements IAnimal {
	@Override
	public void Speak() {
		System.out.println("Bow bow");
	}
}

abstract class IAnimalFactory {
	abstract IAnimal GetAnimalType(String type) throws Exception;
}

class ConcreteFactory extends IAnimalFactory {
	@Override
	public IAnimal GetAnimalType(String type) throws Exception {
		switch (type) {
		case "Cat":
			return new Cat();
		case "Dog":
			return new Dog();
		default:
			throw new Exception("Animal type : " + type + " cannot be instantiated");
		}
	}
}

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal catType = animalFactory.GetAnimalType("Cat");
		catType.Speak();
		IAnimal DogType = animalFactory.GetAnimalType("Dog");
		DogType.Speak();
		// IAnimal LionType = animalFactory.GetAnimalType("Lion");
		// LionType.Speak();
	}
}