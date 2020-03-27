
package data;


/**
 * 这是一个细胞类
 * 
 *
 **/
public class CellArray {
	private int [][] cellArray;/*定义细胞矩阵*/
	private int row; /*定义细胞行*/
	private int col; /*定义细胞列*/
	
	public CellArray(int row,int col)/*细胞类构造函数*/
	{
		this.row = row;
		this.col = col;
		cellArray = new int [row][col];
	}

	public int getRow() {
		return row;
	}



	public void setRow( int row) {
		this.row = row;
	}



	public int getCol() {
		return col;
	}



	public void setCol(int col) {
		this.col = col;/*列赋值*/
	}



	public int getCell(int x, int y)
	{
		if(x >= 0 && x <row && y>=0 && y<col)
			return cellArray[x][y];
		return -1;
	}
	
	public void  setCell(int x,int y,int cell) {
		this.cellArray[x][y]=cell;
	}
	
	
	
}
