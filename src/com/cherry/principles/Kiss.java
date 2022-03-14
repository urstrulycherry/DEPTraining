package com.cherry.principles;

import java.security.InvalidKeyException;

/*
 public String weekday1(int day) {
    switch (day){
        case 1:
	return �Monday�; 
        case 2:
	return �Tuesday�;
        case 3:
	return �Wednesday�;
        case 4:
	return �Thursday�;
        case 5:
	return �Friday�;
        case 6:
	return �Saturday�;
        case 7:
	return �Sunday�;
        default:
	throw new InvalidOperationException (�day must be in range 1 to 7�);
    }
}
 */
public class Kiss {
	public static String weekday(int day) throws InvalidKeyException {
		if ((day < 1) || (day > 7)) {
			throw new InvalidKeyException("Day must be in range 1 to 7");
		}

		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		return days[day - 1];
	}

	public static void main(String[] args) throws InvalidKeyException {
		System.out.println(weekday(1));
		System.out.println(weekday(5));
		System.out.println(weekday(8));
	}
}
