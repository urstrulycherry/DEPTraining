package com.cherry.patterns.creational;

class Computer {
	private String graphicsCard;
	private String monitors;
	private String processor;
	private String ram;

	private Computer(Builder builder) {
		this.graphicsCard = builder.graphicsCard;
		this.monitors = builder.monitors;
		this.processor = builder.processor;
		this.ram = builder.ram;
	}

	@Override
	public String toString() {
		return "Computer [graphicsCard=" + graphicsCard + ", monitors=" + monitors + ", processor=" + processor
				+ ", ram=" + ram + "]";
	}

	public String getGraphicsCard() {
		return this.graphicsCard;
	}

	public String getMonitors() {
		return this.monitors;
	}

	public String getProcessor() {
		return this.processor;
	}

	public String getRam() {
		return this.ram;
	}

	public static class Builder {
		private String graphicsCard;
		private String monitors;
		private String processor;
		private String ram;

		public Builder(String p) {
			this.processor = p;
		}

		public Builder graphicsCard(String g) {
			this.graphicsCard = g;
			return this;
		}

		public Builder monitors(String mg) {
			this.monitors = mg;
			return this;
		}

		public Builder ram(String ram) {
			this.ram = ram;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}
}

public class BuilderPattern {
	public static void main(String[] args) {

		Computer headlessComputer = new Computer.Builder("intel-i5").graphicsCard("GTX-960").ram("16GB").build();
		Computer gamingPC = new Computer.Builder("intel-i7").graphicsCard("RTX-3080").monitors("acer-s7").ram("32GB")
				.build();
		System.out.println(headlessComputer);
		System.out.println(gamingPC);
	}
}
