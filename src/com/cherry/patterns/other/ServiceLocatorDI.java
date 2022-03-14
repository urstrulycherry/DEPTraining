package com.cherry.patterns.other;

interface IServiceSL {
	void serve();
}

class ServiceSL implements IServiceSL {
	public ServiceSL() {
		System.out.println("s1 created");
	}

	@Override
	public void serve() {
		System.out.println("Served");

	}
}

class Service2 implements IServiceSL {
	public Service2() {
		System.out.println("S2 created");
	}

	@Override
	public void serve() {
		System.out.println("Served 2");
	}
}

class ServiceLocater {
	static IServiceSL service, s2;

	public static IServiceSL getService(String s) {
		if (s.equals("s1")) {
			if (service == null)
				service = new ServiceSL();
			return service;
		} else {
			if (s2 == null)
				s2 = new Service2();
			return s2;
		}
	}

}

class ClientSL {
	IServiceSL service;

	ClientSL(String s2) {
		service = ServiceLocater.getService(s2);
	}

	void start() {
		System.out.println(service.hashCode());
		service.serve();
	}
}

public class ServiceLocatorDI {
	public static void main(String[] args) {
		ClientSL c1 = new ClientSL("s1");
		ClientSL c2 = new ClientSL("s2");
		c2.start();
		c1.start();
		c1.start();
		c1.start();
	}
}
