package com.cherry.principles;

interface OrderInterface {
	public void placeOrder(int orderId);
}

interface OnlinePaymentInterface {
	public void payOnline(int orderId);
}

interface PayInPersonInterface {
	public void payInPerson(int orderId);
}

class OnlineOrder implements OrderInterface, OnlinePaymentInterface {
	@Override
	public void placeOrder(int orderId) {
		payOnline(orderId);
		System.out.println("Order Placed - Online");
	}

	@Override
	public void payOnline(int orderId) {
		System.out.println("Paid Successfully - Online Payment");
	}
}

class InPersonOrder implements OrderInterface, PayInPersonInterface {
	@Override
	public void payInPerson(int orderId) {
		System.out.println("Paid Successfully - In Person");
	}

	@Override
	public void placeOrder(int orderId) {
		payInPerson(orderId);
		System.out.println("Order Placed - In Person");
	}
}

public class InterfaceSeg {
	public static void main(String[] args) {
		OnlineOrder o1 = new OnlineOrder();
		o1.placeOrder(1);

		InPersonOrder o2 = new InPersonOrder();
		o2.placeOrder(2);

	}
}