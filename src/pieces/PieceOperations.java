package pieces;

import java.util.List;

import pieces.Piece.Color;


public interface PieceOperations {
	public boolean isColor(Color c);
	public boolean isSameColorWith(PieceOperations move);
	public boolean isType(Class<?> c);
	public boolean canMoveTo(Position pos);
	
	abstract public double getPoint();
	abstract public List<Position> getPossibleMoves();
	public char getSymbol();
	public Color getColor();
	public Position getPosition();
	public void setPosition(Position pos);
}
