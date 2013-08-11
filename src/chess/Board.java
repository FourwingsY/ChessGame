package chess;

import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pieces.Empty;
import pieces.Pawn;
import pieces.PieceOperations;
import pieces.Position;
import pieces.Piece.Color;

public class Board {
	public static final int ROW_SIZE = 8;
	public static final int COL_SIZE = 8;
	
	private ArrayList<Row> rows;
	
	// Default Setting: Empty Board
	public Board () {
		rows = new ArrayList<Row>();
		for (int i=0; i<ROW_SIZE; i++) {
			Row row = new Row();
			rows.add(row);
		}
	}
	
	public void initialize() {
		for (int i=0; i<ROW_SIZE; i++) {
			Row row = new Row();
			if (i == 0)
				row.initAsBackRow(WHITE);
			if (i == 1)
				row.initAsFrontRow(WHITE);
			if (i == 6)
				row.initAsFrontRow(BLACK);
			if (i == 7)
				row.initAsBackRow(BLACK);
			// set position to initialized pieces
			row.setPositionToPieces(i);
			rows.add(i, row);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		// row 8 is on top, 1 on bottom.
		for (int i=ROW_SIZE-1; i>=0; i--) {
			Row row = rows.get(i);
			result.append(row.toString());
			result.append(StringUtil.newLine());
		}
		return result.toString();
	}
	
	
	// Methods related on Moving Piece
	private PieceOperations getPiece(int col, int row) {
		return rows.get(row).getPiece(col);
	}
	public PieceOperations getPieceOn(Position pos) {
		int col = pos.getCol();
		int row = pos.getRow();
		return this.getPiece(col, row);
	}
	void putPieceOn(PieceOperations move, Position pos) {
		int col = pos.getCol();
		int row = pos.getRow();
		move.setPosition(pos);
		rows.get(row).putPiece(col, move);
	}
	public int movePiece(String strSrc, String strDst) {
		Position src = Position.fromString(strSrc);
		Position dst = Position.fromString(strDst);
		if (!src.isInBoard() || !dst.isInBoard())
			return 1;
		
		PieceOperations move = getPieceOn(src);
		PieceOperations target = getPieceOn(dst);
		
		if (move.isType(Empty.class))
			return 2;
		if (!move.canMoveTo(dst))
			return 3;
		if (target.isSameColorWith(move))
			return 4;
		
		Empty e = new Empty();
		putPieceOn(move, dst);
		putPieceOn(e, src);
		
		return 0;
	}
	
	// Calculate Point
	public double calcPoint(Color color) {
		double point = 0;
		for (int i = 0; i < ROW_SIZE; i++) {
			Row row = rows.get(i);
			point += row.calcPoint(color);
		}
		point -= (double) numOfDuplicatedPawn(color) / 2;
		return point;
	}
	private int numOfDuplicatedPawn(Color color) {
		int[] numOfPawnInCol = new int[8];
		int result = 0;
		for (int c = 0; c < COL_SIZE; c++) {
			for (int r = 0; r < ROW_SIZE; r++) {
				PieceOperations p = getPiece(c, r);
				if (p.isType(Pawn.class) && p.isColor(color))
					numOfPawnInCol[c]++;
			}
			if (numOfPawnInCol[c] > 1)
				result += numOfPawnInCol[c];
		}
		return result;
	}
	
	// return sorted collection of pieces
	public List<PieceOperations> collectPieces(Color color) {
		ArrayList<PieceOperations> pieceCollection = new ArrayList<PieceOperations>();
		for (int r = 0; r < ROW_SIZE; r++) {
			for (int c = 0; c < COL_SIZE; c++) {
				PieceOperations p = getPiece(c, r);
				if (p.isColor(color))
					pieceCollection.add(p);
			}
		}
		Collections.sort(pieceCollection, new Comparator<PieceOperations>() {
		    public int compare(PieceOperations a, PieceOperations b) {
		        if (a.getPoint() < b.getPoint())
		        	return 1;
		        else return -1;
		    }
		});
		return pieceCollection;
	}
}
