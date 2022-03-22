package com.cherry.patterns.structural;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface Robot {
	void showMe(String color);
}

class FixedSizeRobot implements Robot {
	private final String robotTypeCreated;

	FixedSizeRobot() {
		robotTypeCreated = "A robot with a fixed size created";
		System.out.print(robotTypeCreated);
	}

	@Override
	public void showMe(String color) {
		System.out.print(" with " + " blue (default) color");
	}
}

class LargeRobot implements Robot {
	private final String robotTypeCreated;

	public LargeRobot() {
		robotTypeCreated = "A large robot created";
		System.out.print(robotTypeCreated);
	}

	@Override
	public void showMe(String color) {
		System.out.print(" with " + color + " color");
	}
}

class SmallRobot implements Robot {
	private final String robotTypeCreated;

	SmallRobot() {
		robotTypeCreated = "A small robot created";
		System.out.print(robotTypeCreated);
	}

	@Override
	public void showMe(String color) {
		System.out.print(" with " + color + " color");
	}
}

class RobotFactory {
	static Map<String, Robot> robotFactory = new HashMap<String, Robot>();

	int totalObjectsCreated() {
		return robotFactory.size();
	}

	static synchronized Robot getRobotFromFactory(String robotType) throws Exception {
		Robot robotCategory = robotFactory.get(robotType);
		if (robotCategory == null) {
			switch (robotType) {
			case "small":
				System.out.println("We do not have Small Robot at present. So we are creating a small robot now.");
				robotCategory = new SmallRobot();
				break;
			case "large":
				System.out.println("We do not have Large Robot at present. So we are creating a large robot now.");
				robotCategory = new LargeRobot();
				break;
			case "fixed":
				System.out.println("We do not have fixed size at present. So we are creating a fixed size robot now.");
				robotCategory = new FixedSizeRobot();
				break;
			}
			robotFactory.put(robotType, robotCategory);
		} else {
			System.out.print("\n\tUsing existing " + robotType + " robot and coloring it");
		}
		return robotCategory;
	}
}

public class FlyweightPatternExample {
	public static void main(String[] args) throws Exception {
		RobotFactory robotFactory = new RobotFactory();
		System.out.println("*** Flyweight Pattern Example ***");
		System.out.println();
		Robot myRobot;
		for (int i = 0; i < 3; i++) {
			myRobot = RobotFactory.getRobotFromFactory("small");
			myRobot.showMe(getRandomColor());
		}
		int numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\nTill now, total no of distinct robot objects created: " + numOfDistinctRobots);
		for (int i = 0; i < 5; i++) {
			myRobot = RobotFactory.getRobotFromFactory("large");
			myRobot.showMe(getRandomColor());
		}
		numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\nTill now, total no of distinct robot objects created: " + numOfDistinctRobots);
		for (int i = 0; i < 4; i++) {
			myRobot = RobotFactory.getRobotFromFactory("fixed");
			myRobot.showMe(getRandomColor());
		}
		numOfDistinctRobots = robotFactory.totalObjectsCreated();
		System.out.println("\nTill now, total no of distinct robot objects created: " + numOfDistinctRobots);
	}

	static String getRandomColor() {
		if (new Random().nextInt() % 2 == 0) {
			return "red";
		} else {
			return "green";
		}
	}
}