package com.cherry.principles;

interface Developer {
	void develop();
}

interface IProject {
	void implement(Developer d);
}

class FrontEndDeveloper implements Developer {

	@Override
	public void develop() {
		this.writeJS();
	}

	void writeJS() {
		System.out.println("Front-end");
	}
}

class BackEndDeveloper implements Developer {

	@Override
	public void develop() {
		this.writeJava();
	}

	void writeJava() {
		System.out.println("Java coded");
	}
}

class Project implements IProject {

	@Override
	public void implement(Developer d) {
		d.develop();
	}
}

public class DI {
	public static void main(String[] args) {
		Project p1 = new Project();
		p1.implement(new FrontEndDeveloper());
		p1.implement(new BackEndDeveloper());
	}
}
