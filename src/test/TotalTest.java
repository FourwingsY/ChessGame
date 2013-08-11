package test;

import java.util.ArrayList;

import pieces.PieceOperations;
import pieces.Position;
import chess.StringUtil;
import chess.Board;
import junit.framework.TestCase;



public class TotalTest extends TestCase {
	static final String EMPTY_ROW = "........";
	static final String BLACK_ROW = "RNBQKBNR";
	static final String BLACK_PAWN = "PPPPPPPP";
	static final String WHITE_ROW = "rnbqkbnr";
	static final String WHITE_PAWN = "pppppppp";
	
	Board board;
	protected void setUp() throws Exception {
		board = new Board();
		board.initialize();
	}
	public void testSymbol() {
		Position pos = Position.fromString("b2");
		PieceOperations p = board.getPieceOn(pos);
		assertEquals('p', p.getSymbol());
	}
	public void testBoard() {
		StringBuilder expected = new StringBuilder();
		expected.append(BLACK_ROW + StringUtil.newLine());
		expected.append(BLACK_PAWN + StringUtil.newLine());
		expected.append(EMPTY_ROW + StringUtil.newLine());
		expected.append(EMPTY_ROW + StringUtil.newLine());
		expected.append(EMPTY_ROW + StringUtil.newLine());
		expected.append(EMPTY_ROW + StringUtil.newLine());
		expected.append(WHITE_PAWN + StringUtil.newLine());
		expected.append(WHITE_ROW + StringUtil.newLine());
		
		assertEquals(expected.toString(), board.toString());
	}
	
	public void testEmptyMove() {
		Position pos = Position.fromString("b3");
		PieceOperations p = board.getPieceOn(pos);
		assertEquals(new ArrayList<Position>() ,p.getPossibleMoves());
	}
	
	public void testPawnMove() {
		Position pos = Position.fromString("b2");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("b4"));
		possibleMoves.add(Position.fromString("b3"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testPawnMove2() {
		board.movePiece("b2", "b4");
		Position pos = Position.fromString("b4");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("b5"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testRookMove() {
		Position pos = Position.fromString("a1");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("b1"));
		possibleMoves.add(Position.fromString("c1"));
		possibleMoves.add(Position.fromString("d1"));
		possibleMoves.add(Position.fromString("e1"));
		possibleMoves.add(Position.fromString("f1"));
		possibleMoves.add(Position.fromString("g1"));
		possibleMoves.add(Position.fromString("h1"));
		possibleMoves.add(Position.fromString("a2"));
		possibleMoves.add(Position.fromString("a3"));
		possibleMoves.add(Position.fromString("a4"));
		possibleMoves.add(Position.fromString("a5"));
		possibleMoves.add(Position.fromString("a6"));
		possibleMoves.add(Position.fromString("a7"));
		possibleMoves.add(Position.fromString("a8"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testKnightMove() {
		Position pos = Position.fromString("b1");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("d2"));
		possibleMoves.add(Position.fromString("a3"));
		possibleMoves.add(Position.fromString("c3"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testBishopMove() {
		Position pos = Position.fromString("c1");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("b2"));
		possibleMoves.add(Position.fromString("a3"));
		possibleMoves.add(Position.fromString("d2"));
		possibleMoves.add(Position.fromString("e3"));
		possibleMoves.add(Position.fromString("f4"));
		possibleMoves.add(Position.fromString("g5"));
		possibleMoves.add(Position.fromString("h6"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testQueenMove() {
		Position pos = Position.fromString("d1");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("c1"));
		possibleMoves.add(Position.fromString("b1"));
		possibleMoves.add(Position.fromString("a1"));
		possibleMoves.add(Position.fromString("e1"));
		possibleMoves.add(Position.fromString("f1"));
		possibleMoves.add(Position.fromString("g1"));
		possibleMoves.add(Position.fromString("h1"));
		possibleMoves.add(Position.fromString("c2"));
		possibleMoves.add(Position.fromString("b3"));
		possibleMoves.add(Position.fromString("a4"));
		possibleMoves.add(Position.fromString("d2"));
		possibleMoves.add(Position.fromString("d3"));
		possibleMoves.add(Position.fromString("d4"));
		possibleMoves.add(Position.fromString("d5"));
		possibleMoves.add(Position.fromString("d6"));
		possibleMoves.add(Position.fromString("d7"));
		possibleMoves.add(Position.fromString("d8"));
		possibleMoves.add(Position.fromString("e2"));
		possibleMoves.add(Position.fromString("f3"));
		possibleMoves.add(Position.fromString("g4"));
		possibleMoves.add(Position.fromString("h5"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	public void testKingMove() {
		Position pos = Position.fromString("e1");
		PieceOperations p = board.getPieceOn(pos);
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		possibleMoves.add(Position.fromString("d1"));
		possibleMoves.add(Position.fromString("f1"));
		possibleMoves.add(Position.fromString("d2"));
		possibleMoves.add(Position.fromString("e2"));
		possibleMoves.add(Position.fromString("f2"));

		assertEquals(possibleMoves ,p.getPossibleMoves());
	}
	
	public void moveEmpty() {
		int i = board.movePiece("b3", "b4");
		// return value means error. only if i == 0, it works well.
		assertEquals(3, i);
	}
	public void movePawn() {
		int i = board.movePiece("b2", "i4");
		// return value means error. only if i == 0, it works well.
		assertEquals(1, i);
		
		i = board.movePiece("b2", "g4");
		assertEquals(3, i);
	}
	public void moveRook() {
		int i = board.movePiece("a1", "a4");
		// return value means error. only if i == 0, it works well.
		assertEquals(4, i);
	}
}
