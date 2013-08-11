package pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	static final char symbol = 'P';
	static final double point = 1;
	
	public Pawn(Color color) {
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
		
		Position pos = this.getPosition();
		int col = pos.getCol();
		int row = pos.getRow();
		int r = 0;
		
		if (this.isWhite()) {
			r = 1;
			if (row == 1)
				possibleMoves.add(new Position(col, row+2*r));
		}
		if (this.isBlack()) {
			r = -1;
			if (row == 6)
				possibleMoves.add(new Position(col, row+2*r));
		}
		
		pos = new Position(col, row+r);
		if (pos.isInBoard())
			possibleMoves.add(pos);
		
		return possibleMoves;
	}

}
