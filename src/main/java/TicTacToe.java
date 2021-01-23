import java.util.*;

public class TicTacToe {

        static ArrayList<Integer> playerPostions = new ArrayList<Integer>();
        static ArrayList<Integer> cpuPostions = new ArrayList<Integer>();

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
            while (playerPostions.contains(playerPosition) || cpuPostions.contains(playerPostions)){
                System.out.println("Position taken! Enter a correct Position");
                playerPosition = scanner.nextInt();
            }

            placePiece(gameBoard, playerPosition, "Player");
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            // Do randomization to get the CPU position different than players (Or could try to do some Artificial Intelligence)
            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPostions.contains(cpuPos) || cpuPostions.contains(cpuPos)){
                cpuPos = random.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "CPU");

            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
        //Print final Game board
            printGameBoard(gameBoard);

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
            playerPostions.add(position);
        } else if (user.equals("CPU")){
            symbol = 'O';
            cpuPostions.add(position);
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

    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftColumn);
        winning.add(middleColumn);
        winning.add(rightColumn);
        winning.add(cross1);
        winning.add(cross2);

        for (List l: winning){
            if (playerPostions.containsAll(l)) {
                return "Congratulations you WON!!";
            } else if (cpuPostions.containsAll(l)){
                return "CPU wins, Sorry!:(";
            } else if (playerPostions.size() + cpuPostions.size() == 9){
                return "It's a tie!";
            }
        }

        return "";

    }
}
