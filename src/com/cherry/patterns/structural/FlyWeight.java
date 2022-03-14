package com.cherry.patterns.structural;

interface IEmp {
	void assignSkill(String skill);

	void task();
}

class Developer implements IEmp {
	private final String JOB;
	private String skill;

	public Developer() {
		System.out.println("Created Developer");
		JOB = "Fix the issue";
	}

	@Override
	public void assignSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public void task() {
		System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
	}

}

class Tester implements IEmp {
	private final String JOB;
	private String skill;

	public Tester() {
		System.out.println("Created Tester");
		JOB = "Test the issue";
	}

	@Override
	public void assignSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public void task() {
		System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
	}

}

class EmpFactory {
	private static IEmp developer, tester;

	static IEmp getEmp(String type) throws Exception {
		if (type.equals("developer"))
			return developer == null ? developer = new Developer() : developer;
		if (type.equals("tester"))
			return tester == null ? tester = new Tester() : developer;
		throw new Exception();
	}
}

public class FlyWeight {
	public static void main(String[] args) throws Exception {
		IEmp dev1 = EmpFactory.getEmp("developer");
		IEmp dev2 = EmpFactory.getEmp("developer");
		dev1.assignSkill("C++");
		dev1.task();
		dev2.assignSkill("java");
		dev2.task();
		System.out.println();
		IEmp tester1 = EmpFactory.getEmp("tester");
		IEmp tester2 = EmpFactory.getEmp("tester");
		tester1.assignSkill("C#");
		tester1.task();
		tester2.assignSkill("ASP.NET");
		tester2.task();
	}

}
