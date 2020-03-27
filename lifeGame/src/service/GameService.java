package service;
import data.CellArray;
import java.util.Random;

import javax.swing.JFrame;

import data.CellState;
public class GameService {	
	public static int[] temp= {-1,0,1};
	//在程序开始之前，为了让程序能识别细胞的生死，我们定义了temp，赋给其-1,0,1三种状态分别表示遇到边界，生和死，以方便判断细胞的状态

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
	//统计边界中细胞活邻居的个数
	public static int countNumber(CellArray cells,int x,int y) {
		int count = 0;
		 for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                if (CellState.LIVE.getValue() == cells.getCell(x + temp[i], y + temp[j])) {//判断矩阵中活的细胞数目和给出的细胞及周边细胞的数目是否相同
	                    ++count;
	                }
	            }
	        }	
		 if (CellState.LIVE.getValue() == cells.getCell(x, y)) {//如果矩阵中活的细胞数和给出的位置细胞数相同
	            --count;
	        }
		
        return count;
	}
	
	
}
