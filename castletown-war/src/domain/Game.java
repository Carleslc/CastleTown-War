package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

	/**
	 * @param args
	 */
	static BufferedReader br;
	static ArrayList<Player> players;


	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		initPlayers();
		boolean isGameOver = false;
		//int roundNumber = 0;
		System.out.println("Let the game begin!");
		while(!isGameOver){
			for(int i = 0; i < players.size(); ++i){
				
			}
		}
		
	}
	
	public static void initPlayers(){
		System.out.println("Welcome to CastleTown War!");
		boolean ready = false;
		int nOfPlayers = 0;
		int nOfHumanPlayers = 0;
		while(!ready){
			System.out.println("How many players will this game have?");
			nOfPlayers = askForInt();	
			System.out.println("¿How many of those are going to be human?");
			nOfHumanPlayers = askForInt();	
			if(nOfPlayers < nOfHumanPlayers){
				System.out.println("The number of players can't be less than the number of HUMAN players!");
			}
			else
				ready = true;
		}
		for(int i = 0; i < nOfPlayers; ++i){
			if(nOfHumanPlayers > 0){
				players.add(new HumanPlayer());
				--nOfHumanPlayers;
			}
			else
				players.add(new AIPlayer());
		}
	}
	
	static int askForInt(){
		boolean success = false;
		int ret = -1;
		while(!success){
			try {
				ret = Integer.parseInt(br.readLine());
				success = true;
			} catch (NumberFormatException e) {
				System.out.println("Introduce a valid integer");
			} catch (IOException e) {
				System.out.println("IO Exception while reading integer");
			}
		}
		return ret;
	}

}
