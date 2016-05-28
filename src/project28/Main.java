package project28;

import java.util.Random;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner string = new Scanner(System.in);
		GameState gameState = initialize();
		while (true) {
			System.out.println("Please enter your guessed attempt:");
			if (string.hasNextInt()) {
				int guess = string.nextInt();
				System.out.println("DEBUG: entered number is " + guess);
				count++;
				if (guess == number) {
					System.out.println("You've guessed the number using "
							+ count + ((count==1)?" attempt":" attempts"));
					GameState gameState = initialize();
				} else {
					System.out.println((guess > number) ? "Less" : "More");
				}
			} else {
				if (string.hasNext("q")) {
					System.out.println("Break");
					break;					
				}
				else{
					System.out.println("Wrong string: " + string.nextLine());
				}
			}
		}
		System.out.println("End");
		string.close();
	}

	public GameState initialize() {
		Random random = new Random();
		number = random.nextInt(100);
		System.out.println("DEBUG: number is " + number);
		count = 0;
	}
	
	private static class GameState {
		private int number;
		private int count;
		
		
	}

}
