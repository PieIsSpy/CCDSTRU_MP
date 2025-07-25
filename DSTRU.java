import java.util.Scanner;

public class DSTRU
{
	public static void displayChar(int n, char c)
	{
		int i;
		
		for (i = 0; i < n; i++)
			System.out.printf("%c", c);
	}
	
	public static void displayTable(int[][] P)
	{
		int i, j;
		
		displayChar(25, '-');
		System.out.print("\n");
		
		for (i = 0; i < 4; i++)
		{
			System.out.print("|");
			for (j = 0; j < 4; j++)
			{
				displayChar(2, ' ');
				System.out.printf("%d", P[i][j]);
				displayChar(2, ' ');
				System.out.print("|");
			}
			
			System.out.print("\n");
			displayChar(25, '-');
			System.out.print("\n");
		}
	}
	
	public static int getCoordinates(int[][] P, int player, Scanner input)
	{
		int row, col;
		boolean valid;
		int minusPlayer = 0;

		do
		{
			System.out.print("Enter row coordinate: ");
			row = input.nextInt();

			System.out.print("Enter col coordinate: ");
			col = input.nextInt();

			if (row >= 1 && row <= 4 && col >= 1 && col <= 4)
			{
				row--;
				col--;

				if (player == 1 || player == 3)
				{
					if (P[row][col] == 0)
					{
						P[row][col] = player;
						valid = true;
					}
					else
					{
						System.out.println("ERROR: Position Occupied.");
						valid = false;
					}
				}
				else
				{
					if (P[row][col] != 0)
					{
						if (P[row][col] == 1)
						{
							System.out.println("\nUno's position was taken!\n");
							minusPlayer = 1;
						}
						else if (P[row][col] == 3)
						{
							System.out.println("\nTres' position was taken!\n");
							minusPlayer = 3;
						}

						P[row][col] = 0;
						valid = true;
					}
					else
					{
						System.out.println("ERROR: Position Unoccupied.");
						valid = false;
					}
				}
			}
			else
			{
				System.out.println("ERROR: Invalid Input.");
				valid = false;
			}
		} while (valid == false);

		return minusPlayer;
	}

	public static boolean checkRow(int row, int[][] P)
	{
		boolean condition = true;
		int player = P[row][0];
		int j = 1;

		if (player != 0)
		{
			while (j < 4 && condition == true)
			{
				if (player != P[row][j])
					condition = false;

				j++;
			}
		}
		else
			condition = false;

		return condition;
	}

	public static boolean checkDiagonal(int mode, int[][] P)
	{
		boolean condition = true;
		int player;
		int i, j;

		if (mode == 1)
		{
			player = P[0][0];
			i = 1;
			j = 1;

			if (player != 0)
			{
				while (i < 4 && condition == true)
				{
					if (player != P[i][j])
						condition = false;

					i++;
					j++;
				}
			}
			else
				condition = false;
		}
		else
		{
			player = P[0][3];
			i = 1;
			j = 2;

			if (player != 0)
			{
				while (i < 4 && condition == true)
				{
					if (player != P[i][j])
						condition = false;

					i++;
					j--;
				}
			}
			else
				condition = false;
		}

		return condition;
	}

	public static boolean checkWin(int[][] P)
	{
		boolean condition = false;
		// check upper
		condition = checkRow(0, P);

		// check lower
		if (condition == false)
			condition = checkRow(3, P);

		// positive slope
		if (condition == false)
			condition = checkDiagonal(0, P);

		// negative slope
		if (condition == false)
			condition = checkDiagonal(1, P);

		return condition;
	}
	
	public static void main(String[] args)
	{
		int i, j;
		int player = 3;
		int minusPlayer;
		int tiles = 16, uno = 0, tres = 0;
		int[][] P = new int[4][4];
		boolean over = false;
		Scanner input = new Scanner(System.in);
		
		for (i = 0; i < 4; i++)
			for (j = 0; j < 4; j++)
				P[i][j] = 0;
		
		while (over == false)
		{
			displayTable(P);
			
			if (player == 1)
			{
				System.out.println("Uno's turn!\n");
				
				getCoordinates(P, 1, input);
				tiles--;
				uno++;

				System.out.print("\n");
			}
			else if (player == 2)
			{
				System.out.println("Dos' turn!\n");
				
				minusPlayer = getCoordinates(P, 2, input);
				tiles++;

				if (minusPlayer == 1)
					uno--;
				else if (minusPlayer == 3)
					tres--;
			}
			else if (player == 3)
			{
				System.out.println("Tres' turn!\n");

				getCoordinates(P, 3, input);
				tiles--;
				tres++;
				
				System.out.print("\n");
			}

			over = checkWin(P);

			if (over && player == 1 && uno == 4)
			{
				displayTable(P);
				System.out.println("Uno wins!");
			}
			else if (over && player == 3 && tres == 4)
			{
				displayTable(P);
				System.out.println("Tres wins!");
			}
			else if (!over && tiles == 0)
			{
				displayTable(P);
				over = true;
				System.out.println("No more tiles available! Dos wins!");
			}
			else
			{
				over = false;

				if (player == 1)
					player = 2;
				else if (player == 2)
					player = 3;
				else
					player = 1;
			}
		}

		input.close();
	}
}