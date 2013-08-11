package pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

	static final char symbol = 'Q';
	static final double point = 9;
	
	public Queen(Color color) {
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
				
				// go through in each direction
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
