package ressources;

public class grid {

	private cell grid[][];
	private int l;
	private int h;

	public grid(int largeur, int hauteur) 
	{
		this.l = largeur;
		this.h = hauteur;
		setGrid(this.l, this.h);
	}

	public void setGrid(int lrg, int lng) 
	{
		grid = new cell[lrg][lng];
		for (int i = 0; i <= lrg - 1; i++) 
			{
			for (int y = 0; y <= lng - 1; y++) 
			{
				grid[i][y] = new cell(i, y);
			}
		}
	}

	public void setCellLetter(int parX, int parY, String parLetter) 
	{
		if (grid[parX][parY].getType() == 0) 
		{
			grid[parX][parY].setType(1);
			grid[parX][parY].addLetter(parLetter);
		}
	}

	public void setCellDef(int x, int y, String p_Def, String p_Mot, String p_Def2, String p_Mot2,
			definition.Direction p_Dir, definition.Direction p_Dir2) 
	{
		
		if (checkCell(x, y, p_Dir).length() >= p_Mot.length()) 
		{
			if (p_Def2 == null && p_Mot2 == null) 
			{
				grid[x][y].setType(2);

				if (p_Dir == definition.Direction.HD) 
				{
					for (int i = 0; i < p_Mot.length(); i++) 
					{
						setCellLetter(x, y + 1 + i, (String.valueOf(p_Mot.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.HI) 
				{
					for (int i = 0; i < p_Mot.length(); i++) 
					{
						setCellLetter(x + 1, y + i, (String.valueOf(p_Mot.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.VD) 
				{
					for (int i = 0; i < p_Mot.length(); i++) 
					{
						setCellLetter(x + 1 + i, y, (String.valueOf(p_Mot.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.VI) 
				{
					for (int i = 0; i < p_Mot.length(); i++) 
					{
						setCellLetter(x + i, y + 1, (String.valueOf(p_Mot.charAt(i))));
					}
				}
			} else 
			{

				System.out.println("DEF 2" + p_Mot + " " + p_Mot2);
				grid[x][y].setType(3);
				if (p_Dir == definition.Direction.HD) 
				{
					for (int i = 0; i < p_Mot2.length(); i++) 
					{
						setCellLetter(x, y + 1 + i, (String.valueOf(p_Mot2.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.HI) 
				{
					for (int i = 0; i < p_Mot2.length(); i++) 
					{
						setCellLetter(x + 1, y + i, (String.valueOf(p_Mot2.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.VD) 
				{
					for (int i = 0; i < p_Mot2.length(); i++) 
					{
						setCellLetter(x + 1 + i, y, (String.valueOf(p_Mot2.charAt(i))));
					}
				}
				if (p_Dir == definition.Direction.VI) 
				{
					for (int i = 0; i < p_Mot2.length(); i++) 
					{
						setCellLetter(x + i, y + 1, (String.valueOf(p_Mot2.charAt(i))));
					}
				}

			}
			grid[x][y].addDef(p_Def, p_Mot, p_Def2, p_Mot2, p_Dir);
		}

	}

	public void getCellDef(int x, int y, int idx) 
	{
		grid[x][y].getDef(idx);
	}

	public String getCellLetter(int x, int y) 
	{
		return grid[x][y].getLetter();
	}

	public void setWord(int x, int y, String p_Word, definition.Direction p_Dir) 
	{

	}

	/** CONTROLLERS **/
	public int getGridSize() 
	{
		int ctt = 0;
		for (int i = 0; i < grid.length; i++) 
		{
			for (int y = 0; y < grid.length; y++) 
			{
				ctt++;
			}
		}
		System.out.println(ctt);
		return ctt;
	}

	public void displayGrid() {
		for (int i = 0; i <= l - 1; i++) 
		{
			for (int y = 0; y <= h - 1; y++) 
			{
				if (grid[i][y].getType() == 0) 
				{
					System.out.print(". ");
				} else if (grid[i][y].getType() == 1) 
				{
					System.out.print(grid[i][y].getLetter() + " ");
				} else if (grid[i][y].getType() == 2) 
				{
					System.out.print(grid[i][y].getDef(0));
				} else if (grid[i][y].getType() == 3) 
				{
					System.out.print(grid[i][y].getDef(0));
					System.out.print(grid[i][y].getDef(1));

				}
			}
			System.out.println();
		}
	}

	public void displayGrid2() {
		for (int i = 0; i <= l - 1; i++) 
		{
			for (int y = 0; y <= h - 1; y++) 
			{
				if (grid[i][y].getType() == 0) 
				{
					System.out.print(". ");
				} else if (grid[i][y].getType() == 1) 
				{
					System.out.print(grid[i][y].getLetter() + " ");
				} else if (grid[i][y].getType() == 2) 
				{
					System.out.print("2 ");
				} else if (grid[i][y].getType() == 3) 
				{
					System.out.print("3 ");
				}
			}
			System.out.println();
		}
	}

	public String checkCell(int x, int y, definition.Direction p_Dir) 
	{
		String match = "";
		/** HORIZONTAL DIRECT -- START **/
		if (p_Dir == definition.Direction.HD) 
		{
			for (int i = x + 1; i <= l - 1; i++) 
			{
				if (grid[y][i].getType() == 0) 
				{
					match = match + ".";
				} else if (grid[y][i].getType() == 1) 
				{
					match += getCellLetter(y, i);
				} else if (grid[y][i].getType() == 2 || grid[y][i].getType() == 3) 
				{
					return match;
				}
			}
			return match;
		}
		/** HORIZONTAL DIRECT -- END **/
		/** HORIZONTAL INDIRECT -- START **/
		if (p_Dir == definition.Direction.HI) 
		{
			for (int i = x; i <= l - 1; i++) 
			{
				if (grid[y][i].getType() == 0) 
				{
					match = match + ".";
				} else if (grid[y][i].getType() == 1) 
				{
					match += getCellLetter(y, i);
				} else if (grid[y][i].getType() == 2 || grid[y][i].getType() == 3) 
				{
					return match;
				}
			}
			return match;
		}
		/** HORIZONTAL INDIRECT -- END **/

		/** VERTICAL DIRECT -- START **/
		if (p_Dir == definition.Direction.VD) 
		{
			for (int i = y + 1; i <= h - 1; i++) 
			{
				if (grid[i][x].getType() == 0) 
				{
					match = match + ".";
				} else if (grid[i][x].getType() == 1) 
				{
					match += getCellLetter(i, x);
				} else if (grid[i][x].getType() == 2 || grid[i][x].getType() == 3) 
				{
					return match;
				}
			}
			return match;
		}
		/** VERTICAL DIRECT -- END **/
		/** VERTICAL INDIRECT -- START **/
		if (p_Dir == definition.Direction.VI) 
		{
			for (int i = y; i <= h - 1; i++) 
			{
				if (grid[i][x].getType() == 0) 
				{
					match = match + ".";
				} else if (grid[i][x].getType() == 1) 
				{
					match += getCellLetter(i, x);
				} else if (grid[i][x].getType() == 2 || grid[i][x].getType() == 3) 
				{
					return match;
				}
			}
			return match;
		}
		/** VERTICAL INDIRECT -- END **/

		return match;
	}
}