package com.cherry.patterns.structural;

class Product {
	public void GetProductDetails() {
		System.out.println("Fetching the Product Details");
	}
}

class Payment {
	public void MakePayment() {
		System.out.println("Payment Done Successfully");
	}
}

class Invoice {
	public void Sendinvoice() {
		System.out.println("Invoice Send Successfully");
	}
}

class Order {
	public void PlaceOrder() {
		System.out.println("Place Order Started");
		Product product = new Product();
		product.GetProductDetails();
		Payment payment = new Payment();
		payment.MakePayment();
		Invoice invoice = new Invoice();
		invoice.Sendinvoice();
		System.out.println("Order Placed Successfully");
	}
}

public class Facade2 {
	public static void main(String[] args) {
		Order order = new Order();
		order.PlaceOrder();
	}
}
