public class Matrix {
	int data[][];
	int noRows;
	int noCols;

	public Matrix(int row, int col) {
		this.noRows = row;
		this.noCols = col;
		data = new int[row][col];
	}

	public void addElements(int row, int col, int val) {
		data[row][col] = val;
	}

	public Matrix transpose() {
		Matrix matrix3 = new Matrix(noCols, noRows);
		for (int r = 0; r < noCols; r++) {
			for (int c = 0; c < noRows; c++) {
				matrix3.addElements(r, c, data[c][r]);
			}
			System.out.print("\n");
		}
		return matrix3;
	}

	public void show() {
		for (int r = 0; r < noRows; r++) {
			for (int c = 0; c < noCols; c++) {
				System.out.print(data[r][c] + "\t");
			}
			System.out.print("\n");
		}
	}

	public static void main(String args[]) {
		Matrix matrix = new Matrix(3, 3);
		matrix.addElements(0, 0, 1);
		matrix.addElements(0, 1, 1);
		matrix.addElements(0, 2, 1);
		matrix.show();
		Matrix m2 = matrix.transpose();
		m2.show();
	}
}
