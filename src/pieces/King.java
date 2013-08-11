package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	
	static final char symbol = 'K';
	static final double point = 0;
	
	public King(Color color) {
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
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				
				// nine move - current position
				if (r==0 && c==0)
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
	
}
