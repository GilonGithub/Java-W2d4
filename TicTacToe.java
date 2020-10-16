
// (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O). When one player has placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won. A draw (no winner) occurs when all the cells on the grid have been filled with tokens and neither player has achieved a win. Create a program for playing tic-tac-toe.
						
// The program prompts two players to enter an X token and O token alternately. Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue). Here is a sample run: 

import java.util.Scanner;

public class TicTacToe {

    public static char[][] board = new char[3][3];
    public static Scanner input = new Scanner(System.in);
    public static char playerTurn = 'X';
    public static boolean winner = true;
    public static byte player_X, player_O = 0;
    public static boolean draw = false;
    public static byte counter = 0;

    public static void main(String[] args) {

        printBoard();

        while(winnerCheck() && counter != 9) {
            playerTurn(playerTurn);
        }

        

        if(player_X == 1) {
            System.out.println("Player X wins!");
        } else if (counter == 9) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player O wins!");
        }
    }

    public static void printBoard() {

        System.out.println("-------------");
        System.out.println("| "+ board[0][0] +" | "+ board[0][1] +" | "+ board[0][2] +" |");
        System.out.println("-------------");
        System.out.println("| "+ board[1][0] +" | "+ board[1][1] +" | "+ board[1][2] +" |");
        System.out.println("-------------");
        System.out.println("| "+ board[2][0] +" | "+ board[2][1] +" | "+ board[2][2] +" |");
        System.out.println("-------------");
    }

    public static void playerTurn(char player) {

        byte row, col = 0;
        
        while(true) {
            System.out.print("Enter a row (0, 1, or 2) for player " + player + " : ");
            row = input.nextByte();

            System.out.print("Enter a column (0, 1, or 2) for player " + player + " : ");
            col = input.nextByte();

            if(Character.valueOf(board[row][col]) == (char)0) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("\nThe selected cell is already occupied! Try again.\n");
                printBoard();
            }
        }

        printBoard();

        if (player == 'X') {
            playerTurn = 'O';
        } else {
            playerTurn = 'X';
        }

    }

    public static boolean winnerCheck() {

        for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = Character.toString(board[0][0]) + Character.toString(board[0][1]) + Character.toString(board[0][2]); //first row
				break;
			case 1:
				line = Character.toString(board[1][0]) + Character.toString(board[1][1]) + Character.toString(board[1][2]); //second row
				break;
			case 2:
                line = Character.toString(board[2][0]) + Character.toString(board[2][1]) + Character.toString(board[2][2]); //third row
				break;
			case 3:
                line = Character.toString(board[0][0]) + Character.toString(board[1][1]) + Character.toString(board[2][2]); //diagonal from top-left
				break;
			case 4:
                line = Character.toString(board[0][0]) + Character.toString(board[1][0]) + Character.toString(board[2][0]); //first column
				break;
			case 5:
                line = Character.toString(board[0][1]) + Character.toString(board[1][1]) + Character.toString(board[2][1]); //second column
				break;
			case 6:
                line = Character.toString(board[0][2]) + Character.toString(board[1][2]) + Character.toString(board[2][2]); //third column
				break;
			case 7:
                line = Character.toString(board[0][2]) + Character.toString(board[1][1]) + Character.toString(board[2][0]); //diagonal from top-right
				break;
            }
        
			if (line.equals("XXX")) {
				player_X = 1;
			} else if (line.equals("OOO")) {
				player_O = 1;
            }


        }

        counter = 0;

        for(char[] array_1D: board) {
            for(char i: array_1D) {
                if(i != (char)0) {
                    counter++;
                }
            }
        }


        if(player_O <= 0 && player_X <= 0) {
            return true;
        } else if(counter == 9) {
            return false;
        } else {
            return false;
        }
    }
}