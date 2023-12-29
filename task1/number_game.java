package task1;

import java.util.Scanner;
import java.util.Random;

public class number_game {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		int minRange=1;
		int maxRange=100;
		int maxAttempt=10;
		int score=0;
		
		System.out.println("Welcome to the NUMBER GAME...");;
		
		do {
			int targetNumber=r.nextInt(maxRange-minRange+1)+minRange;
			int attempt=0;
			boolean guessCorrectly=false;
			System.out.println("\nGuess the number between "+minRange+"and"+maxRange+".");
			
			while(attempt<maxAttempt) {
				System.out.print("Enter your guess (Atempt "+(attempt+1)+"):");
				int userGuess=sc.nextInt();
				attempt++;
				if(userGuess==targetNumber) {
					guessCorrectly=true;
					System.out.println("Congratulations! You Guessed the correct number in "+attempt+" attempts");
					break;
				}
				else if(userGuess<targetNumber) {
					System.out.println("Too low! try Again");
				}else {
					System.out.println("Too high! try Again");
				}
			}
			if(!guessCorrectly) {
				System.out.println("Sorry! you've reached the maximum number of atempts. The correct number was : "+targetNumber);
			}else {
				score++;
			}
			System.out.print("Do you want to play again? (yes/no): ");
		}
		while(sc.next().equalsIgnoreCase("yes"));
		
		System.out.println("Game over. Your final score is : "+score);
		sc.close();
	}

}
