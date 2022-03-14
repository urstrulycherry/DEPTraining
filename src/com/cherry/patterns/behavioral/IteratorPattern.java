package com.cherry.patterns.behavioral;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface IIterator {
	public boolean hasNext();

	public Object next();
}

interface Container {
	public IIterator getIterator();
}

class CollectionOfNames implements Container {
	public String name[] = { "Charan", "Raj", "Nithesh" };

	@Override
	public IIterator getIterator() {
		return new CollectionofNamesIterate();
	}

	private class CollectionofNamesIterate implements IIterator {
		int i;

		@Override
		public boolean hasNext() {
			if (i < name.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return name[i++];
			}
			return null;
		}
	}
}

public class IteratorPattern {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Charan", "Raj", "Nithesh");

		Iterator<String> namesIterator = names.iterator();
		while (namesIterator.hasNext()) {
			System.out.println(namesIterator.next());
		}
		System.out.println();

		CollectionOfNames names1 = new CollectionOfNames();
		IIterator iter = names1.getIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
