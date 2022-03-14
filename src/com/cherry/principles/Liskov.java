package com.cherry.principles;

class User {
	int userId;
	String name;
	String email;
	String address;

	public User(int userId, String name, String email, String address) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.address = address;
	}

}

class Delivery {
	User user;
	int orderId;
}

class OfflineDelivery extends Delivery {
	String getDeliveryLocation() {
		return user.address;
	}
}

class OnlineDelivery extends Delivery {
	String getUserEmail() {
		return user.email;
	}
}

public class Liskov {
	public static void main(String[] args) {
		User u1 = new User(1, "Charan", "gcharannetha@gmail.com", "Hyd");
		OfflineDelivery d1 = new OfflineDelivery();
		OnlineDelivery d2 = new OnlineDelivery();
		d1.orderId = 1;
		d1.user = u1;
		System.out.println("Order Id: " + d1.orderId + "\n" + "Delivery Loc: " + d1.getDeliveryLocation());

		d2.orderId = 2;
		d2.user = u1;
		d2.getUserEmail();
		System.out.println("\n\nOrder Id: " + d2.orderId + "\n" + "Mail To: " + d2.getUserEmail());
	}
}
