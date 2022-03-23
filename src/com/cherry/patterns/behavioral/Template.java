package com.cherry.patterns.behavioral;

abstract class GameLoaderTemplate {
	public void load() {
		createObjects();
		downloadAdditionalFiles();
		initializeProfiles();
		cleanTempFiles();
	}

	abstract void createObjects();

	abstract void downloadAdditionalFiles();

	abstract void initializeProfiles();

	protected void cleanTempFiles() {
		System.out.println("Cleaning temporary files");
	}
}

class Game1 extends GameLoaderTemplate {
	@Override
	public void createObjects() {
		System.out.println("Loading and Creating Game 1 objects");
	}

	@Override
	public void downloadAdditionalFiles() {
		System.out.println("Downloading Game 1 sounds");
	}

	@Override
	public void initializeProfiles() {
		System.out.println("Loading Game 1 profiles");
	}
}

class Game2 extends GameLoaderTemplate {
	@Override
	public void createObjects() {
		System.out.println("Loading and Creating Game 2 objects");
	}

	@Override
	public void downloadAdditionalFiles() {
		System.out.println("Downloading Game 2 sounds");
	}

	@Override
	public void initializeProfiles() {
		System.out.println("Loading Game 2 profiles");
	}
}

public class Template {
	public static void main(String[] args) {
		GameLoaderTemplate g1 = new Game1();
		g1.load();

		System.out.println();

		GameLoaderTemplate g2 = new Game2();
		g2.load();
	}
}
