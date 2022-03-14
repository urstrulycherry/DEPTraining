package com.cherry.oops;

/**
 * ! Encapsulation
 */
class Emp {
	private int empId;
	private String name;
	private String address;

	public Emp(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

/**
 * ! Abstraction
 */
interface EmpDetails {
	double salPerDayJSE = 1503.43;
	double salPerDaySSE = 2807.73;

	double getSalary(float days);
}

/**
 * ! Inheritance
 */
class SalaryJSE implements EmpDetails {
	@Override
	public double getSalary(float days) {
		return days * salPerDayJSE;
	}
}

class SalarySSE implements EmpDetails {
	@Override
	public double getSalary(float days) {
		return days * salPerDaySSE;
	}
}

public class Oops {
	static void printSalary(int id, double salary) {
		System.out.println("\n\nSalary for Employee Id " + id + " is " + salary);
	}

	static void printSalary(Emp e, double salary) {// Polymorphism
		System.out.println("\n\nEmp Id:\t\t" + e.getEmpId() + "\nEmp Name:\t" + e.getName() + "\nSalary:\t\t" + salary);
	}

	public static void main(String[] args) {
		Emp e1 = new Emp(1001, "Charan", "Hyd");
		printSalary(e1.getEmpId(), new SalaryJSE().getSalary(24));
		Emp e2 = new Emp(1002, "Cherry", "Chennai");
		printSalary(e2, new SalarySSE().getSalary(24));
	}
}