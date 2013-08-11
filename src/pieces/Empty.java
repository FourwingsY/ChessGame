package pieces;

import java.util.ArrayList;
import java.util.List;

public class Empty extends Piece {
	
	static final char symbol = '.';
	static final double point = 0;
	
	public Empty() {
		super(Color.NONE);
	}
	
	@Override
	public double getPoint() {
		return point;
	}
	public char getSymbol() {
		return symbol;
	}

	@Override
	public List<Position> getPossibleMoves() {
		return new ArrayList<Position>();
	}

}
