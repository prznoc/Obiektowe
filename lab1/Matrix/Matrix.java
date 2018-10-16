public class Matrix{
	public int row;
	public int col;
	public double [][] data;
	
    public Matrix(int a, int b) {
        this.row = a;
        this.col = b;
        this.data = new double[a][b];
    }

    public Matrix(double[][] tabela) {
        this.row = tabela.length;
        this.col = tabela[0].length;
        data = new double[row][col];
        for (int i = 0; i < this.row; i++)
            for (int j = 0; j < this.col; j++)
                    this.data[i][j] = tabela[i][j];
		
    }

	public Matrix add(Matrix m2){
		if (this.row != m2.row || this.col != m2.col) throw new RuntimeException("Illegal matrix dimensions.");
		Matrix m3 = new Matrix (this.row, this.col);
		for (int i = 0; i < this.row; i++)
            for (int j = 0; j < this.col; j++)
                    m3.data[i][j] = this.data[i][j]+m2.data[i][j];
		return m3;
	}

	Matrix mul(Matrix m2){
			if (this.col !=m2.row) throw new RuntimeException("Illegal matrix dimensions.");
			Matrix m3 = new Matrix(this.row, m2.col);
			double liczba;
			for (int i = 0; i<m3.row; ++i ){
				for (int j = 0; j<m3.col; ++j){
					liczba = 0;
					for (int k = 0; k<col; ++k){
						liczba = liczba + this.data[i][k]*m2.data[k][j];
					}
					m3.data[i][j] = liczba;
				}
			}
			return m3;
	}
}
