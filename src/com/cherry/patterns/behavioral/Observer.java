package com.cherry.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
	void update(Channel c, String s);
}

interface IChannel {
	void subscribe(ISubscriber s);

	void unSubscribe(ISubscriber s);

	void notifySub(String title);
}

class Channel implements IChannel {
	private String name;
	List<ISubscriber> subs = new ArrayList<>();

	public Channel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void subscribe(ISubscriber s) {
		subs.add(s);
	}

	@Override
	public void unSubscribe(ISubscriber s) {
		subs.remove(subs.indexOf(s));
	}

	@Override
	public void notifySub(String title) {
		for (ISubscriber s : subs) {
			s.update(this, title);
		}
	}
}

class Subscriber implements ISubscriber {
	private String name;

	public Subscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(Channel c, String s) {
		System.out.println("Hello " + name + ", new video from " + c.getName() + ", Title: " + s);
	}

}

class PremiumSubscriber implements ISubscriber {
	private String name;

	public PremiumSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(Channel c, String s) {
		System.out.println("Hello " + name + ", new video from " + c.getName() + ", Title: " + s);
	}
}

public class Observer {
	public static void main(String[] args) {
		IChannel c1 = new Channel("Epam Global");
		IChannel c2 = new Channel("Epam India");

		ISubscriber s1 = new Subscriber("Charan");
		ISubscriber s2 = new PremiumSubscriber("Raj");
		ISubscriber s3 = new Subscriber("Nithesh");

		c1.subscribe(s1);
		c2.subscribe(s3);

		c1.notifySub("Welcome to EPAM Global");
		System.out.println();
		c2.notifySub("A1 to A2 movement");
		c2.subscribe(s2);
		System.out.println();
		c2.notifySub("A2 to A3 movement");
	}
}
