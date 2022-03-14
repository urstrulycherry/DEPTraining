package com.cherry.patterns.behavioral;

interface MobileAlertState {
	public void alert(MobileState ctx);
}

class MobileState {
	private MobileAlertState currentState;

	public MobileState() {
		currentState = new Ring();
	}

	public void setState(MobileAlertState state) {
		currentState = state;
	}

	public void alert() {
		currentState.alert(this);
	}
}

class Ring implements MobileAlertState {
	@Override
	public void alert(MobileState ctx) {
		System.out.println("Ringing!!!");
	}
}

class Vibration implements MobileAlertState {
	@Override
	public void alert(MobileState ctx) {
		System.out.println("Vibration!!!");
	}
}

class Silent implements MobileAlertState {
	@Override
	public void alert(MobileState ctx) {
		System.out.println("Silent!!!");
	}
}

public class State {
	public static void main(String[] args) {
		MobileState mobile = new MobileState();
		mobile.alert();
		mobile.alert();
		mobile.setState(new Silent());
		mobile.alert();
		mobile.alert();
		mobile.setState(new Vibration());
		mobile.alert();
	}
}
