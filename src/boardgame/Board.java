package boardgame;

public class Board {
	private int rows;
	private int columms;
	private Piece[][] pieces;

	public Board(int rows, int columms) {
		if (rows < 1 || columms < 1) {
			throw new BoardException("Erro ao criar o tabuleiro, é necessario que haja uma linha e uma coluna");
		}
		this.rows = rows;
		this.columms = columms;
		pieces = new Piece[rows][columms];
	}

	public int getRows() {
		return rows;
	}

	public int getColumms() {
		return columms;
	}

	public Piece piece(int row, int columm) {
		if(!positionExists(row,columm)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		return pieces[row][columm];
	}

	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumm()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nesta posição " + position);
		}
		pieces[position.getRow()][position.getColumm()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columms;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumm());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no tabuleiro");
		}
		return piece(position) != null;
	}
}
