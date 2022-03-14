package com.cherry.patterns.other;

interface IService {
	void serve();
}

class Service implements IService {
	@Override
	public void serve() {
		System.out.println("Served");
	}
}

class Client {
	IService service;

	// Constructor Injection
	Client(IService service) {
		this.service = service;
	}

	// Setter Injection
	void setter(IService service) {
		this.service = service;
	}

	void start() {
		System.out.println(service.hashCode());
		service.serve();
	}
}

public class DependencyInjection {
	public static void main(String[] args) {
		Service s1 = new Service();
		Client c1 = new Client(s1);
		c1.start();
		c1.start();
		c1.setter(new Service());
		c1.start();
	}
}
