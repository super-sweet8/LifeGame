package data;

/**
 * 细胞状�??
 */
public enum CellState {
    DEAD(0),
    LIVE(1);
    private int value;

    CellState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public void  setCell(int x,int y,int cell) {
	this.cellArray[x][y]=cell;
}
