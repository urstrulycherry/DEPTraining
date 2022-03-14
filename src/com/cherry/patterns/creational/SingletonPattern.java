package com.cherry.patterns.creational;

final class EpamHyd {
	private static EpamHyd instance = null;;

	private EpamHyd() {
	}

	private String address = "Salarpuria Sattva Knowledge City, Hyderabad";

	synchronized public static EpamHyd getInstance() {
		if (instance == null) {
			instance = new EpamHyd();
			System.out.println("New instance created for EpamHyd");
		}
		return instance;
	}

	public String getAddress() {
		return address;
	}
}

final class EpamBgl {
	private static volatile EpamBgl instance = null;;

	private EpamBgl() {
	}

	private String address = "Smartworks Global Technology Park, Bengaluru";

	public static EpamBgl getInstance() {
		if (instance == null) { // one time
			synchronized (EpamBgl.class) {
				if (instance == null) { // Two time
					instance = new EpamBgl();
					System.out.println("New instance created for EpamBgl");
				}
			}
		}
		return instance;
	}

	public String getAddress() {
		return address;
	}
}

public class SingletonPattern {
	public static void main(String[] args) {
		System.out.println();
		EpamHyd epamHyd = EpamHyd.getInstance();
		EpamHyd epamHyd2 = EpamHyd.getInstance();
		EpamHyd epamHyd3 = EpamHyd.getInstance();
		System.out.println(epamHyd.hashCode() + " --- " + epamHyd.getAddress());
		System.out.println(epamHyd2.hashCode() + " --- " + epamHyd2.getAddress());
		System.out.println(epamHyd3.hashCode() + " --- " + epamHyd3.getAddress());

		System.out.println();

		EpamBgl epamBlg = EpamBgl.getInstance();
		EpamBgl epamBlg2 = EpamBgl.getInstance();
		EpamBgl epamBlg3 = EpamBgl.getInstance();
		System.out.println(epamBlg.hashCode() + " --- " + epamBlg.getAddress());
		System.out.println(epamBlg2.hashCode() + " --- " + epamBlg2.getAddress());
		System.out.println(epamBlg3.hashCode() + " --- " + epamBlg3.getAddress());
		System.out.println();
	}
}