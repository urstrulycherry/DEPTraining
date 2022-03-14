package com.cherry.patterns.behavioral;

import java.util.Date;

class ChatRoom {

	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "]\t:\t" + message);
	}
}

class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}

public class Mediator {
	public static void main(String[] args) {
		User charan = new User("Charan");
		charan.sendMessage("Hai Cherry");
		User cherry = new User("Cherry");
		cherry.sendMessage("Hello");
	}
}
