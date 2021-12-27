import java.util.*;
public class Program2CampbellMarcus {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random myRand = new Random();
		
		//init all vars needed
		int pcrow = myRand.nextInt(3);
		int pccolumn = myRand.nextInt(3);
		int row;
		int column;
		int count = 0;
		int playagain = 0;
		
		//creates board
		char[][] board = new char[3][3];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = ' ';
		//If any player wins, this will turn true
		boolean win = false;
		
		while(!win || playagain == 1) {
			//if the user wants to play again it recreates board
			while (playagain == 1 ){
				for(int i = 0; i < board.length; i++)
					for(int j = 0; j < board.length; j++)
						board[i][j] = ' ';
				//playagain will be 0 so the loop will stop
				playagain = 0;
			}
			boolean key = true;
			//Loop is for valid move
			while(key){
				System.out.println("Where would you like to put your X? Row First, Column Second");
				row = scan.nextInt();
				column  = scan.nextInt();
				//Checks row and column are valid
				if(row <= 2 || column <= 2 ){
					//Checks to see if user input is valid
					if(board[row][column] == ' '){
						board[row][column] = 'X';
						key = false;
						count++;
					}else{
						System.out.println("Invalid move, try again. ");
					}
				} else {
					System.out.print("Invaild Row or Column. Try again");
				}
			}
			
			//checks PC moves
			while (board[pcrow][pccolumn] != ' ' && count < 9){
				pcrow = myRand.nextInt(3);
				pccolumn = myRand.nextInt(3);
			}		
			board[pcrow][pccolumn] = 'O';
			count++;
	
			//Checks if User won
			if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' || 
				board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' ||
				board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X' ||
				board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X' ||
				board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X' ||
				board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X' ||
				board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'||
				board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
				{
					System.out.println("User Wins!");
					win = true;
				}
			//Checks if Computer won
			else if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O' || 
				board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' ||
				board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O' ||
				board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O' ||
				board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O' ||
				board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O' ||
				board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'||
				board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
				{
					System.out.println("Computer Wins!");
					win =true;
				}                                                                 
			else if(board[0][0] != ' ' && board[0][1] != ' ' && board[0][2]!= ' ' && 
					board[1][0] != ' ' && board[1][1] != ' ' && board[1][2]!= ' ' &&
					board[2][0] != ' ' && board[2][1] != ' ' && board[2][2]!= ' ' &&
					board[0][0] != ' ' && board[1][0] != ' ' && board[2][0]!= ' ' &&
					board[0][1] != ' ' && board[1][1] != ' ' && board[2][1]!= ' ' &&
					board[0][2] != ' ' && board[1][2] != ' ' && board[2][2]!= ' ' &&
					board[0][0] != ' ' && board[1][1] != ' ' && board[2][2]!= ' '&&
					board[0][2] != ' ' && board[1][1] != ' ' && board[2][0]!= ' ')
					{                                                          
						System.out.println("Tie");
						win = true;
					}
			
			System.out.println(board[0][0]+"    |  "+board[0][1]+"  | "+board[0][2]);
			System.out.println("-----|-----|-----");
			System.out.println(board[1][0]+"    |  "+board[1][1]+"  | "+board[1][2]);
			System.out.println("-----|-----|-----");
			System.out.println(board[2][0]+"    |  "+board[2][1]+"  | "+board[2][2]);

			while (win == true) {
				System.out.println("Would you like to play again? 1 = yes and 2 = no");
				playagain = scan.nextInt();
				win = false;
			}
			if (playagain == 2) {
				System.exit(0);
			}
		}
	}
}
