package pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

	static final char symbol = 'B';
	static final double point = 3;
	
	public Bishop (Color color) {
		super(color);
	}
	
	@Override
	public double getPoint() {
		return point;
	}
	public char getSymbol() {
		if (this.isWhite())
			return Character.toLowerCase(symbol);
		else return symbol;
	}

	@Override
	public List<Position> getPossibleMoves() {
		if (this.position == null)
			return new ArrayList<Position>();
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				
				// get just diagonal direction (i, j)
				if (r==0 || c==0)
				 	continue;
				
				Position pos = this.getPosition();
				int col = pos.getCol() + c;
				int row = pos.getRow() + r;
				pos = new Position(col, row);
				
				// go through in diagonal direction
				while (pos.isInBoard()) {
					possibleMoves.add(pos);
					col += c;
					row += r;
					pos = new Position(col, row);
				}
			}
		}
		return possibleMoves;
	}

}
