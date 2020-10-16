
// (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O). When one player has placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won. A draw (no winner) occurs when all the cells on the grid have been filled with tokens and neither player has achieved a win. Create a program for playing tic-tac-toe.
						
// The program prompts two players to enter an X token and O token alternately. Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue). Here is a sample run: 

import java.util.Scanner;

public class TicTacToe {

    public static char[][] board = new char[3][3];
    public static Scanner input = new Scanner(System.in);
    public static char player = 'X';

    public static void main(String[] args) {

        printBoard();


        playerTurn(player);

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
        
        System.out.print("Enter a row (0, 1, or 2) for player " + player + " : ");
        row = input.nextByte();

        System.out.print("Enter a column (0, 1, or 2) for player " + player + " : ");
        col = input.nextByte();

        board[row][col] = player;

        printBoard();

        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }

    }
}