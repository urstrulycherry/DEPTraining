package com.cherry.patterns.structural;

interface IAdapter {
	public void compatible();
}

class AmericanSocket {

	IAdapter a;

	AmericanSocket(IAdapter a) {
		this.a = a;
		a.compatible();
	}
}

class EuropeanSocket implements IAdapter {
	@Override
	public void compatible() {
		System.out.println("European plugs can now be plugged in American Sockets");
	}
}

public class Adapter {
	public static void main(String[] args) {
		new AmericanSocket(new EuropeanSocket());
	}

}
