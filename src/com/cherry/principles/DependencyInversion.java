package com.cherry.principles;

import java.util.ArrayList;

interface Product {

	void seeReviews();

	void getSample();

}

class Book implements Product {

	@Override
	public void seeReviews() {
		System.out.println("Print some reviews");
	}

	@Override
	public void getSample() {
		System.out.println("View Sample Book");
	}
}

class DVD implements Product {

	@Override
	public void seeReviews() {
		System.out.println("Print some reviews");
	}

	@Override
	public void getSample() {
		System.out.println("Play sample video");
	}
}

class Shelf {

	ArrayList<Product> products;

	void addProduct(Product product) {
		if (products == null)
			products = new ArrayList<>();
		products.add(product);
	}

	void viewShelf() {
		System.out.println("Print all available Book names and DVD names");
	}
}

public class DependencyInversion {
	public static void main(String[] args) {
		Shelf userShelf1 = new Shelf();
		userShelf1.addProduct(new Book());
		userShelf1.addProduct(new DVD());
		userShelf1.viewShelf();
	}
}
