package chess;

import boardgame.Position;

public class ChessPosition {
	private char columm;
	private int row;

	public ChessPosition(char columm, int row) {
		if (columm < 'a' || columm > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro a instanciar ChessPosition, valores validos s�p de a1 at� h8");
		}
		this.columm = columm;
		this.row = row;
	}

	public char getColumm() {
		return columm;
	}

	public int getRow() {
		return row;
	}
	protected Position toPosition() {
		return new Position(8 - row, columm - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumm()),8 - position.getRow());
	}
	@Override
	public String toString() {
		return "" + columm + row;
	}
}
