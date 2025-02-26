import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard extends JFrame {
    private static final int SIZE = 8;
    private JPanel[][] squares = new JPanel[SIZE][SIZE];
    private ImageIcon exampleIcon;
    private List<Integer> randIndex;
    public String[][] piecesArray;


    public GameBoard() {
        setTitle("Chess Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

       

        // create your 2d Array to store your image variables and assign positions
        // add your code here
        // this line of code initializes a new 2D Array of Strings the size of 1 row and 2 columns
        // your 2D array must be a minimum of 6 rows x 2 columns
        // you may add a row for every image if you'd like to have every square be a different color/image

        piecesArray = new String[64][3];
        loadRandomPieces();

        //print the contents of your 2D array
        //this is a requirement to show your 2D array is not sorted at the beginning of your program

        for (int i = 0; i < piecesArray.length; i++) {
            for (int j = 0; j < piecesArray[i].length; j++) {
                System.out.println("piecesArray[" + i + "][" + j + "] = " + piecesArray[i][j]);
            }
        }

        exampleIcon = new ImageIcon(piecesArray[0][0]); // Load image file

        initializeBoard();
    }

    public void loadPieces() {
        // Black Pieces Loaded
        piecesArray[0][0]= "blackRook.png"; piecesArray[0][1]= "black Rook"; piecesArray[0][2] = "1";
        piecesArray[1][0] = "blackKnight.png"; piecesArray[1][1] = "black Knight"; piecesArray[1][2] = "2";
        piecesArray[2][0] = "blackBishop.png"; piecesArray[2][1] = "black Bishop"; piecesArray[2][2] = "3";
        piecesArray[3][0] = "blackQueen.png"; piecesArray[3][1] = "black Queen"; piecesArray[3][2] = "4";
        piecesArray[4][0] = "blackKing.png"; piecesArray[4][1] = "black King"; piecesArray[4][2] = "5"; 
        piecesArray[5][0] = "blackBishop.png"; piecesArray[5][1] = "black Bishop"; piecesArray[5][2] = "6";
        piecesArray[6][0] = "blackKnight.png"; piecesArray[6][1] = "black Knight"; piecesArray[6][2] = "7";
        piecesArray[7][0]= "blackRook.png"; piecesArray[7][1]= "black Rook"; piecesArray[7][2] = "8";
        piecesArray[8][0]= "blackPawn.png"; piecesArray[8][1]= "black Pawn"; piecesArray[8][2] = "9";
        piecesArray[9][0] = "blackPawn.png"; piecesArray[9][1] = "black Pawn"; piecesArray[9][2] = "9";
        piecesArray[10][0] = "blackPawn.png"; piecesArray[10][1] = "black Pawn"; piecesArray[10][2] = "9";
        piecesArray[11][0] = "blackPawn.png"; piecesArray[11][1] = "black Pawn"; piecesArray[11][2] = "9";
        piecesArray[12][0] = "blackPawn.png"; piecesArray[12][1] = "black Pawn"; piecesArray[12][2] = "9";
        piecesArray[13][0] = "blackPawn.png"; piecesArray[13][1] = "black Pawn"; piecesArray[13][2] = "9";
        piecesArray[14][0] = "blackPawn.png"; piecesArray[14][1] = "black Pawn"; piecesArray[14][2] = "9";
        piecesArray[15][0] = "blackPawn.png"; piecesArray[15][1] = "black Pawn"; piecesArray[15][2] = "9";

        // Empty Pieces with a value initialized
        piecesArray[16][2] = "10"; piecesArray[17][2] = "10"; piecesArray[18][2] = "10";
        piecesArray[19][2] = "10"; piecesArray[20][2] = "10"; piecesArray[21][2] = "10";
        piecesArray[22][2] = "10"; piecesArray[23][2] = "10"; piecesArray[24][2] = "10";
        piecesArray[25][2] = "10"; piecesArray[26][2] = "10"; piecesArray[27][2] = "10";
        piecesArray[28][2] = "10"; piecesArray[29][2] = "10"; piecesArray[30][2] = "10";
        piecesArray[31][2] = "10"; piecesArray[32][2] = "10"; piecesArray[33][2] = "10";
        piecesArray[34][2] = "10"; piecesArray[35][2] = "10"; piecesArray[36][2] = "10";
        piecesArray[37][2] = "10"; piecesArray[38][2] = "10"; piecesArray[39][2] = "10";
        piecesArray[40][2] = "10"; piecesArray[41][2] = "10"; piecesArray[42][2] = "10";
        piecesArray[43][2] = "10"; piecesArray[44][2] = "10"; piecesArray[45][2] = "10";
        piecesArray[46][2] = "10"; piecesArray[47][2] = "10"; 

        piecesArray[48][0]= "whitePawn.png"; piecesArray[48][1]= "white Pawn"; piecesArray[48][2] = "20"; 
        piecesArray[49][0]= "whitePawn.png"; piecesArray[49][1]= "white Pawn"; piecesArray[49][2] = "20"; 
        piecesArray[50][0]= "whitePawn.png"; piecesArray[50][1]= "white Pawn"; piecesArray[50][2] = "20"; 
        piecesArray[51][0]= "whitePawn.png"; piecesArray[51][1]= "white Pawn"; piecesArray[51][2] = "20"; 
        piecesArray[52][0]= "whitePawn.png"; piecesArray[52][1]= "white Pawn"; piecesArray[52][2] = "20"; 
        piecesArray[53][0]= "whitePawn.png"; piecesArray[53][1]= "white Pawn"; piecesArray[53][2] = "20"; 
        piecesArray[54][0]= "whitePawn.png"; piecesArray[54][1]= "white Pawn"; piecesArray[54][2] = "20"; 
        piecesArray[55][0]= "whitePawn.png"; piecesArray[55][1]= "white Pawn"; piecesArray[55][2] = "20"; 

        piecesArray[56][0]= "whiteRook.png"; piecesArray[56][1]= "white Rook"; piecesArray[56][2] = "21"; 
        piecesArray[57][0] = "whiteKnight.png"; piecesArray[57][1] = "white Knight"; piecesArray[57][2] = "22"; 
        piecesArray[58][0] = "whiteBishop.png"; piecesArray[58][1] = "white Bishop"; piecesArray[58][2] = "23"; 
        piecesArray[59][0] = "whiteQueen.png"; piecesArray[59][1] = "white Queen"; piecesArray[59][2] = "24"; 
        piecesArray[60][0] = "whiteKing.png"; piecesArray[60][1] = "white King"; piecesArray[60][2] = "25"; 
        piecesArray[61][0] = "whiteBishop.png"; piecesArray[61][1] = "white Bishop"; piecesArray[61][2] = "26"; 
        piecesArray[62][0] = "whiteKnight.png"; piecesArray[62][1] = "white Knight"; piecesArray[62][2] = "27"; 
        piecesArray[63][0]= "whiteRook.png"; piecesArray[63][1]= "white Rook"; piecesArray[63][2] = "28";
    }

    public void loadRandomPieces() {
        randIndex = new ArrayList<Integer>();
        for (int i = 0; i < 64; i++) {
            randIndex.add(i);
        }
        Collections.shuffle(randIndex);

        // Black Pieces Loaded
        piecesArray[randIndex.get(0)][0]= "blackRook.png"; piecesArray[randIndex.get(0)][1]= "black Rook"; piecesArray[randIndex.get(0)][2] = "1";
        piecesArray[randIndex.get(1)][0] = "blackKnight.png"; piecesArray[randIndex.get(1)][1] = "black Knight"; piecesArray[randIndex.get(1)][2] = "2";
        piecesArray[randIndex.get(2)][0] = "blackBishop.png"; piecesArray[randIndex.get(2)][1] = "black Bishop"; piecesArray[randIndex.get(2)][2] = "3";
        piecesArray[randIndex.get(3)][0] = "blackQueen.png"; piecesArray[randIndex.get(3)][1] = "black Queen"; piecesArray[randIndex.get(3)][2] = "4";
        piecesArray[randIndex.get(4)][0] = "blackKing.png"; piecesArray[randIndex.get(4)][1] = "black King"; piecesArray[randIndex.get(4)][2] = "5"; 
        piecesArray[randIndex.get(5)][0] = "blackBishop.png"; piecesArray[randIndex.get(5)][1] = "black Bishop"; piecesArray[randIndex.get(5)][2] = "6";
        piecesArray[randIndex.get(6)][0] = "blackKnight.png"; piecesArray[randIndex.get(6)][1] = "black Knight"; piecesArray[randIndex.get(6)][2] = "7";
        piecesArray[randIndex.get(7)][0]= "blackRook.png"; piecesArray[randIndex.get(7)][1]= "black Rook"; piecesArray[randIndex.get(7)][2] = "8";
        piecesArray[randIndex.get(8)][0]= "blackPawn.png"; piecesArray[randIndex.get(8)][1]= "black Pawn"; piecesArray[randIndex.get(8)][2] = "9";
        piecesArray[randIndex.get(9)][0] = "blackPawn.png"; piecesArray[randIndex.get(9)][1] = "black Pawn"; piecesArray[randIndex.get(9)][2] = "9";
        piecesArray[randIndex.get(10)][0] = "blackPawn.png"; piecesArray[randIndex.get(10)][1] = "black Pawn"; piecesArray[randIndex.get(10)][2] = "9";
        piecesArray[randIndex.get(11)][0] = "blackPawn.png"; piecesArray[randIndex.get(11)][1] = "black Pawn"; piecesArray[randIndex.get(11)][2] = "9";
        piecesArray[randIndex.get(12)][0] = "blackPawn.png"; piecesArray[randIndex.get(12)][1] = "black Pawn"; piecesArray[randIndex.get(12)][2] = "9";
        piecesArray[randIndex.get(13)][0] = "blackPawn.png"; piecesArray[randIndex.get(13)][1] = "black Pawn"; piecesArray[randIndex.get(13)][2] = "9";
        piecesArray[randIndex.get(14)][0] = "blackPawn.png"; piecesArray[randIndex.get(14)][1] = "black Pawn"; piecesArray[randIndex.get(14)][2] = "9";
        piecesArray[randIndex.get(15)][0] = "blackPawn.png"; piecesArray[randIndex.get(15)][1] = "black Pawn"; piecesArray[randIndex.get(15)][2] = "9";

        // Empty Pieces with a value initialized
        piecesArray[randIndex.get(16)][2] = "10"; piecesArray[randIndex.get(17)][2] = "10"; piecesArray[randIndex.get(18)][2] = "10";
        piecesArray[randIndex.get(19)][2] = "10"; piecesArray[randIndex.get(20)][2] = "10"; piecesArray[randIndex.get(21)][2] = "10";
        piecesArray[randIndex.get(22)][2] = "10"; piecesArray[randIndex.get(23)][2] = "10"; piecesArray[randIndex.get(24)][2] = "10";
        piecesArray[randIndex.get(25)][2] = "10"; piecesArray[randIndex.get(26)][2] = "10"; piecesArray[randIndex.get(27)][2] = "10";
        piecesArray[randIndex.get(28)][2] = "10"; piecesArray[randIndex.get(29)][2] = "10"; piecesArray[randIndex.get(30)][2] = "10";
        piecesArray[randIndex.get(31)][2] = "10"; piecesArray[randIndex.get(32)][2] = "10"; piecesArray[randIndex.get(33)][2] = "10";
        piecesArray[randIndex.get(34)][2] = "10"; piecesArray[randIndex.get(35)][2] = "10"; piecesArray[randIndex.get(36)][2] = "10";
        piecesArray[randIndex.get(37)][2] = "10"; piecesArray[randIndex.get(38)][2] = "10"; piecesArray[randIndex.get(39)][2] = "10";
        piecesArray[randIndex.get(40)][2] = "10"; piecesArray[randIndex.get(41)][2] = "10"; piecesArray[randIndex.get(42)][2] = "10";
        piecesArray[randIndex.get(43)][2] = "10"; piecesArray[randIndex.get(44)][2] = "10"; piecesArray[randIndex.get(45)][2] = "10";
        piecesArray[randIndex.get(46)][2] = "10"; piecesArray[randIndex.get(47)][2] = "10"; 

        // White Pieces Loaded
        piecesArray[randIndex.get(48)][0]= "whitePawn.png"; piecesArray[randIndex.get(48)][1]= "white Pawn"; piecesArray[randIndex.get(48)][2] = "20"; 
        piecesArray[randIndex.get(49)][0]= "whitePawn.png"; piecesArray[randIndex.get(49)][1]= "white Pawn"; piecesArray[randIndex.get(49)][2] = "20"; 
        piecesArray[randIndex.get(50)][0]= "whitePawn.png"; piecesArray[randIndex.get(50)][1]= "white Pawn"; piecesArray[randIndex.get(50)][2] = "20"; 
        piecesArray[randIndex.get(51)][0]= "whitePawn.png"; piecesArray[randIndex.get(51)][1]= "white Pawn"; piecesArray[randIndex.get(51)][2] = "20"; 
        piecesArray[randIndex.get(52)][0]= "whitePawn.png"; piecesArray[randIndex.get(52)][1]= "white Pawn"; piecesArray[randIndex.get(52)][2] = "20"; 
        piecesArray[randIndex.get(53)][0]= "whitePawn.png"; piecesArray[randIndex.get(53)][1]= "white Pawn"; piecesArray[randIndex.get(53)][2] = "20"; 
        piecesArray[randIndex.get(54)][0]= "whitePawn.png"; piecesArray[randIndex.get(54)][1]= "white Pawn"; piecesArray[randIndex.get(54)][2] = "20"; 
        piecesArray[randIndex.get(55)][0]= "whitePawn.png"; piecesArray[randIndex.get(55)][1]= "white Pawn"; piecesArray[randIndex.get(55)][2] = "20"; 

        piecesArray[randIndex.get(56)][0]= "whiteRook.png"; piecesArray[randIndex.get(56)][1]= "white Rook"; piecesArray[randIndex.get(56)][2] = "21"; 
        piecesArray[randIndex.get(57)][0] = "whiteKnight.png"; piecesArray[randIndex.get(57)][1] = "white Knight"; piecesArray[randIndex.get(57)][2] = "22"; 
        piecesArray[randIndex.get(58)][0] = "whiteBishop.png"; piecesArray[randIndex.get(58)][1] = "white Bishop"; piecesArray[randIndex.get(58)][2] = "23"; 
        piecesArray[randIndex.get(59)][0] = "whiteQueen.png"; piecesArray[randIndex.get(59)][1] = "white Queen"; piecesArray[randIndex.get(59)][2] = "24"; 
        piecesArray[randIndex.get(60)][0] = "whiteKing.png"; piecesArray[randIndex.get(60)][1] = "white King"; piecesArray[randIndex.get(60)][2] = "25"; 
        piecesArray[randIndex.get(61)][0] = "whiteBishop.png"; piecesArray[randIndex.get(61)][1] = "white Bishop"; piecesArray[randIndex.get(61)][2] = "26"; 
        piecesArray[randIndex.get(62)][0] = "whiteKnight.png"; piecesArray[randIndex.get(62)][1] = "white Knight"; piecesArray[randIndex.get(62)][2] = "27"; 
        piecesArray[randIndex.get(63)][0]= "whiteRook.png"; piecesArray[randIndex.get(63)][1]= "white Rook"; piecesArray[randIndex.get(63)][2] = "28";

    }

    private void initializeBoard() {
        int boxIndex = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JPanel(new BorderLayout());

                // creates the checkered pattern with the two colors
                // you can add more colors or take away any you'd like
                
                if ((row+col) % 2 == 0) {
                    squares[row][col].setBackground(new Color(255, 255, 255));
                }
                else {
                    squares[row][col].setBackground(new Color(139, 69, 19)); //lighter green
                }


                // this is where your sorting method will be called 
                // you will use the column 2 values to arrange your images to the board
                // be sure to sort them before you add them onto the board 
                // you will use a loop to add to your 2D Array, below is an example of how to add ONE image to ONE square
                
                // Adding an image to specific positions (e.g., first row)
                if (piecesArray[boxIndex][0] != null) {
                    exampleIcon = new ImageIcon(piecesArray[boxIndex][0]); // Load image file
                    Image scaledImage = exampleIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    JLabel pieceLabel = new JLabel(new ImageIcon(scaledImage));
                    JLabel textLabel = new JLabel(piecesArray[boxIndex][1], SwingConstants.CENTER);
                    squares[row][col].add(pieceLabel, BorderLayout.CENTER);
                    squares[row][col].add(textLabel, BorderLayout.SOUTH);
                }
                
                add(squares[row][col]);
                boxIndex++;
            }
        }
    }


    // add your merge sort method here
    // add a comment to every line of code that describes what the line is accomplishing
    // your mergeSort method does not have to return any value

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}
