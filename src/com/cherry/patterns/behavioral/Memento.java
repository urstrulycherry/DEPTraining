package com.cherry.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class Msg {
	private String message;

	public void set(String time) {
		System.out.println("Storing state");
		this.message = time;
	}

	public State saveToMemento() {
		System.out.println("State stored");
		return new State(message);
	}

	public void restoreFromMemento(State state) {
		message = state.getSavedTime();
		System.out.println("State restored: " + message);
	}

	public static class State {
		private final String time;

		public State(String timeToSave) {
			time = timeToSave;
		}

		public String getSavedTime() {
			return time;
		}
	}
}

public class Memento {
	public static void main(String[] args) {

		List<Msg.State> msgStates = new ArrayList<Msg.State>();

		Msg msg = new Msg();

		// time travel and record the eras
		msg.set("Hai");
		msgStates.add(msg.saveToMemento());
		System.out.println();

		msg.set("Hai Charan!");
		msgStates.add(msg.saveToMemento());
		System.out.println();

		msg.set("Hai Charan! how");
		msgStates.add(msg.saveToMemento());
		System.out.println();

		msg.set("Hai Charan! how are you");
		msgStates.add(msg.saveToMemento());
		System.out.println();

		msg.restoreFromMemento(msgStates.get(0));

	}
}
