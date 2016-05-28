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
				gameState.incrementCount();
				//count++;
				if(guess == gameState.getNumber()) {
				//if (guess == number) {
					System.out.println("You've guessed the number using "
							+ count + ((count==1)?" attempt":" attempts"));
					GameState gameState = initialize();
				} else {
					System.out.println((guess > gameState.getNumber()) ? "Less" : "More");
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

	public static GameState initialize() {
		Random random = new Random();
		GameState gameState = new GameState();
		gameState.setNumber(random.nextInt(100));
		//number = random.nextInt(100);
		System.out.println("DEBUG: number is " + gameState.getNumber());
		gameState.setCount(0);
		return gameState;
	}
	
	private static class GameState {
		
		private int number;
		private int count;
		
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public void incrementCount() {
			this.count = count++;
		}
		
		
	}

}
