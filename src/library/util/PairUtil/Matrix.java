package library.util.PairUtil;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;

    public Matrix(double[][] dat) {
        this.data = dat;
        this.rows = dat.length;
        this.columns = dat[0].length;
    }

    public Matrix(int nrow, int ncol) {
        this.rows = nrow;
        this.columns = ncol;
        data = new double[nrow][ncol];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getValues() {
        return data;
    }

    public void setValues(double[][] values) {
        this.data = values;
    }

    public void setValueAt(int row, int col, double value) {
        data[row][col] = value;
    }

    public double getValueAt(int row, int col) {
        return data[row][col];
    }

    public boolean isSquare() {
        return rows == columns;
    }

    public int size() {
        if (isSquare())
            return rows;
        return -1;
    }

    public Matrix multiplyByConstant(double constant) {
        Matrix mat = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat.setValueAt(i, j, data[i][j] * constant);
            }
        }
        return mat;
    }

    public Matrix insertColumnWithValue1() {
        Matrix X_ = new Matrix(this.getRows(), this.getColumns() + 1);
        for (int i = 0; i < X_.getRows(); i++) {
            for (int j = 0; j < X_.getColumns(); j++) {
                if (j == 0)
                    X_.setValueAt(i, j, 1.0);
                else
                    X_.setValueAt(i, j, this.getValueAt(i, j - 1));

            }
        }
        return X_;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                s += this.data[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
