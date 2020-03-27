package service;
import data.CellArray;
import java.util.Random;

import javax.swing.JFrame;

import data.CellState;
public class GameService {	
	
	//初始化矩阵中所有细胞,随机赋予它们的生死
	public static CellArray initMap(int row,int col ) {
		CellArray cells=new CellArray(row,col);
		for(int  i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				Random r=new Random();
				int a=r.nextInt(4); //在0-3之间随机选一个数
				if(a==1) {
					cells.setCell(i,j,CellState.LIVE.getValue());
				}
				else {
					cells.setCell(i,j,CellState.DEAD.getValue());
					
				}
			}
		}
		return cells;
	}
	
	//判断细胞下一代的生死
	public static CellArray generate(CellArray cells) {
		CellArray nextCells=new CellArray(cells.getRow(),cells.getCol());
	  for(int i=0;i<nextCells.getRow();i++) 
		  for(int j=0;j<nextCells.getCol();j++) {
			  
			  int count=countNumber(cells,i,j);
			 if(count==3) {
				 nextCells.setCell(i, j, CellState.LIVE.getValue());   //活邻居为三 活
			 }
			 else if(count==2&&cells.getCell(i, j)==CellState.LIVE.getValue()) {  //活邻居为二且自己本来就活着 活
				 nextCells.setCell(i, j, CellState.LIVE.getValue());
			 }
			 else {
				 nextCells.setCell(i, j, CellState.DEAD.getValue());  //其他情况 死
			 }
		  }
	  
		
		return  nextCells;
		
	}
	
	
}
