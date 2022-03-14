package com.cherry.principles;

import java.util.ArrayList;
import java.util.Random;

class Emp {
	private int id;
	private String name;
	private String address;

	public Emp(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

class NewEmp {
	static Emp addEmp(int id, String name, String address) {
		return new Emp(id, name, address);
	}
}

class Salary {
	static Random rand = new Random();
	static float baseSalary = 45000;

	static float getSalary(Emp e) {
		return baseSalary + rand.nextFloat(20000);
	}
}

public class SingleResponsibility {
	public static void main(String[] args) {
		ArrayList<Emp> emps = new ArrayList<>();
		emps.add(NewEmp.addEmp(1, "Charan", "Hyd"));
		emps.add(NewEmp.addEmp(2, "Cherry", "Hyd"));
		System.out.println("Salary: " + Salary.getSalary(emps.get(0)));
	}
}
