package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

	static final char symbol = 'N';
	static final double point = 2.5;
	
	public Knight(Color color) {
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
		
		// for eight direction
		for (int r = -2; r <= 2; r++) {
			for (int c = -2; c <= 2; c++) {
				
				// Knight's move: (|2|,|1|) or (|1|,|2|)
				if (abs(r)+abs(c) != 3)
					continue;
				
				Position pos = this.getPosition();
				int col = pos.getCol() + c;
				int row = pos.getRow() + r;
				pos = new Position(col, row);
				
				if (pos.isInBoard())
					possibleMoves.add(pos);
			}
		}
		return possibleMoves;
	}
	
	private int abs(int n) {
		if (n < 0)
			return -n;
		else return n;
	}
	
}
