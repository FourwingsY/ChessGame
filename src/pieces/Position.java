package pieces;

import chess.Board;

public class Position {
	private int col;
	private int row;
	
	/* 
	 * sequence of col, row
	 * may confuse you.
	 * but in chess,
	 * we usually say "B4" or "E7"
	 * to mention pieces position
	 * in sequence of col-row
	 */
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	
	
	public String toString() {
		char col = (char) ('a' + this.col);
		char row = (char) ('1' + this.row);
		char[] chararr = {col, row};
		return new String(chararr);
	}
	public static Position fromString(String pos) {
		char[] chararr = pos.toCharArray();
		int col = chararr[0] - 'a';
		int row = chararr[1] - '1';
		return new Position(col, row);
	}
	
	public boolean isInBoard() {
		if (col < 0 || col >= Board.COL_SIZE)
			return false;
		if (row < 0 || row >= Board.ROW_SIZE)
			return false;
		else return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
