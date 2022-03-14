package com.cherry.patterns.behavioral;

interface IRobot {
	void execute();
}

class Receiver {
	public void move() {
		System.out.println("Robot is moving");
	}

	public void poweron() {
		System.out.println("Robot is ON");
	}

	public void poweroff() {
		System.out.println("Robot is OFF");
	}
}

class RobotMove implements IRobot {
	private Receiver receiver;

	RobotMove(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void execute() {
		receiver.move();
		;
	}
}

class RobotOn implements IRobot {
	private Receiver receiver;

	RobotOn(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void execute() {
		receiver.poweron();
	}
}

class RobotOff implements IRobot {
	private Receiver receiver;

	RobotOff(Receiver recv) {
		receiver = recv;
	}

	@Override
	public void execute() {
		receiver.poweroff();
	}
}

class Invoke {
	IRobot r;

	public void executecmd(IRobot r) {
		this.r = r;
		r.execute();
	}
}

public class Command {
	public static void main(String args[]) {
		Receiver rev = new Receiver();
		Invoke invoke = new Invoke();
		RobotMove mv = new RobotMove(rev);
		RobotOn on = new RobotOn(rev);
		RobotOff off = new RobotOff(rev);
		invoke.executecmd(on);
		invoke.executecmd(mv);
		invoke.executecmd(off);
	}
}
