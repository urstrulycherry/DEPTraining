package com.cherry.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

class Channel {
	private String name;
	List<Subscriber> subs = new ArrayList<>();

	public Channel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	void subscribe(Subscriber s) {
		subs.add(s);
	}

	void unSubscribe(Subscriber s) {
		subs.remove(subs.indexOf(s));
	}

	public void notifySub(String title) {
		for (Subscriber s : subs) {
			s.update(this, title);
		}
	}

}

class Subscriber {
	private String name;
	List<Channel> channels = new ArrayList<Channel>();

	public Subscriber(String name) {
		super();
		this.name = name;
	}

	void subscribe(Channel c) {
		channels.add(c);
		c.subscribe(this);
	}

	void unsubscribe(Channel c) {
		channels.remove(channels.indexOf(c));
		c.unSubscribe(this);
	}

	void update(Channel c, String s) {
		System.out.println("Hello " + name + ", new video from " + c.getName() + ", Title: " + s);
	}

}

public class Observer {
	public static void main(String[] args) {
		Channel c1 = new Channel("Epam Global");
		Channel c2 = new Channel("Epam India");
		Subscriber s1 = new Subscriber("Charan");
		Subscriber s2 = new Subscriber("Raj");
		Subscriber s3 = new Subscriber("Nithesh");

		s1.subscribe(c1);
		s2.subscribe(c1);

		s1.subscribe(c2);
		s3.subscribe(c2);

		c1.notifySub("Welcome to EPAM Global");
		System.out.println();
		c2.notifySub("A1 to A2 movement");

		s3.unsubscribe(c2);

		System.out.println();
		c2.notifySub("A2 to A3 movement");
	}
}
