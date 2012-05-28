package utils;

import java.util.Random;

public class Utils {
	static final Random RANDOM = new Random();
	public static int getRandomNumber(int max) {
		return RANDOM.nextInt(max);
	}
	
	public static void main(String[] args) {
		for (int i = 20; i >= 1; i--) {
			Random r = new Random();
			System.out.println(r.nextInt(20));
		}
	}
}
