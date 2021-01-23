import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', ' ', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPosition = scanner.nextInt();

            placePiece(gameBoard, playerPosition, "Player");
            // Do randomization to get the CPU position different than players (Or could try to do some Artificial Intelligence)
            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            placePiece(gameBoard, cpuPos, "CPU");

            printGameBoard(gameBoard);
        }
    }

    public static void printGameBoard(char[][] gameBoard){
        // Below prints out gameboard
        for (char[] row: gameBoard){
            for (char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user){

        char symbol = ' ';

        if (user.equals("Player")){
            symbol = 'X';
        } else if (user.equals("CPU")){
            symbol = 'O';
        }

        switch (position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }
}
