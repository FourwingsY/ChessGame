package chess;

import java.util.ArrayList;

import pieces.*;
import pieces.Piece.Color;

public class Row {
	private ArrayList<PieceOperations> pieces;
	
	// Constructor & Initialize methods
	// Default Setting: Empty Row
	Row() {
		pieces = new ArrayList<PieceOperations>();
		for (int i = 0; i<8; i++) {
			pieces.add(new Empty());
		}
	}
	
	void initAsBackRow(Color color) {
		Piece p = new Rook(color);
		pieces.set(0, p);
		p = new Knight(color);
		pieces.set(1, p);
		p = new Bishop(color);
		pieces.set(2, p);
		p = new Queen(color);
		pieces.set(3, p);
		p = new King(color);
		pieces.set(4, p);
		p = new Bishop(color);
		pieces.set(5, p);
		p = new Knight(color);
		pieces.set(6, p);
		p = new Rook(color);
		pieces.set(7, p);
	}
	
	void initAsFrontRow(Color color) {
		for (int i=0; i<8; i++) {
			Piece p = new Pawn(color);
			pieces.set(i,p);
		}
	}
	
	// String method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (PieceOperations p : pieces) {
			sb.append(p.getSymbol());
		}
		return sb.toString();
	}

	// Position method
	void setPositionToPieces(int row) {
		for (PieceOperations p : pieces) {
			int col = pieces.indexOf(p);
			Position pos = new Position(col, row);
			p.setPosition(pos);
		}
	}

	public PieceOperations getPiece(int col) {
		return pieces.get(col);
	}
	public void putPiece(int index, PieceOperations move) {
		if (index >= Board.ROW_SIZE || index < 0) {
			System.out.println("Wrong index!");
			return;
		}
		pieces.set(index, move);
	}
	
	// Point method
	public double calcPoint(Color color) {
		double point = 0;
		for (PieceOperations piece : pieces) {
			if (piece.isColor(color))
				point += piece.getPoint();
		}
		return point;
	}
}
