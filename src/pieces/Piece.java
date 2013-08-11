package pieces;

import java.util.List;

public abstract class Piece implements PieceOperations {
	public static enum Color {BLACK, WHITE, NONE};
	
	protected Color color;
	protected Position position;
	
	// Constructor
	public Piece(Color color) {
		this.color = color;
	}
	
	// Boolean method
	boolean isWhite() {
		if (this.color == Color.WHITE)
			return true;
		else return false;
	}
	boolean isBlack() {
		if (this.color == Color.BLACK)
			return true;
		else return false;
	}
	public boolean isColor(Color c) {
		if (this.color == c)
			return true;
		else return false;
	}
	public boolean isSameColorWith(PieceOperations piece) {
		if (this.color == piece.getColor())
			return true;
		else return false;
	}
	public boolean isType(Class<?> c) {
		if (this.getClass() == c)
			return true;
		else return false;
	}
	public boolean canMoveTo(Position pos) {
		List<Position> possibleMoves = this.getPossibleMoves();
		if (possibleMoves.contains(pos))
			return true;
		return false;
	}
	
	// Getters
	abstract public double getPoint();
	abstract public List<Position> getPossibleMoves();
	abstract public char getSymbol();
	
	public Color getColor() {
		return this.color;
	}
	public Position getPosition() {
		return this.position;
	}
	public void setPosition(Position pos) {
		this.position = pos;
	}
}
