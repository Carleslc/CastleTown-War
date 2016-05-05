package domain.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
	
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Ask for an integer number on console
	 * @return the integer read
	 */
	public static int nextInt() {
		return nextIntMinimum(Integer.MIN_VALUE);
	}

	/**
	 * Ask for an integer number with a minimum value on console
	 * @param minValue the smallest value for the integer introduced is considered correct
	 * @return the integer <code>i</code> read where <code>i >= <b>minValue</b></code>
	 */
	public static int nextIntMinimum(int minValue) {
		boolean success = false;
		int ret = 0;
		while (!success) {
			try {
				ret = in.nextInt();
				in.nextLine(); // reads an ENTER key and avoids read problems after a nextInt() call
				if (ret < minValue)
					System.out.println("Introduce a number >= " + minValue);
				else
					success = true;
			} catch (InputMismatchException e) {
				System.out.println("Introduce a valid integer");
			} catch (IllegalStateException e) {
				in = new Scanner(System.in);
			}
		}
		return ret;
	}
	
	/**
	 * Call this method when you have finished using console input in order to avoid I/O problems.
	 */
	public static void close() {
		in.close();
	}
}
