package com.cherry.principles;

/*
class Dog{  
    public void eatFood() {  
        System.out.println("Eat Food");  
    }  
    public void woof() {  
        System.out.println("Dog Woof! ");  
    }  
}  
class Cat{  
    public void eatFood() {  
        System.out.println("Eat Food");  
    }  
    public void meow() {  
        System.out.println("Cat Meow!");  
    }  
}  

*/

class Animal {
	public void eatFood() {
		System.out.println("Eat food");
	}

	public void sound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("Dog woof");
	}
}

class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("Cat meow");
	}
}

public class Dry {
	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal dog = new Dog();
		cat.eatFood();
		cat.sound();
		dog.eatFood();
		dog.sound();
	}
}
