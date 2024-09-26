package FirstTask;

public class IntegerMatrix {
    final private int linesLength;
    final private int columnsLength;
    private int[][] matrix;

    public IntegerMatrix(int[][] mat) {
        if (!isValidMatrix(mat)) {
            throw new IllegalArgumentException("Некорректные данные для матрицы.");
        }
        this.matrix = mat;
        this.linesLength = mat.length;
        this.columnsLength = mat[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) {
                sb.append(value).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean isValidMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return false;
        }
        int rowLength = mat[0].length;
        for (int[] row : mat) {
            if (row.length != rowLength) {
                return false;
            }
        }
        return true;
    }

    public IntegerMatrix multiplication(IntegerMatrix mat) throws IllegalArgumentException {
        if(this.linesLength  != mat.columnsLength){
            throw new IllegalArgumentException("Некорректные данные для умножения.");
        }
        int[][] resultData = new int[this.linesLength][mat.columnsLength];


        for (int i = 0; i < this.linesLength; i++) {
            for (int j = 0; j < mat.columnsLength; j++) {
                for (int k = 0; k < this.columnsLength; k++) {
                    resultData[i][j] += this.matrix[i][k] * mat.matrix[k][j];
                }
            }
        }

        return new IntegerMatrix(resultData);
    }



    public static void main(String[] args) {
        IntegerMatrix firstMatrix = new IntegerMatrix(new int[][] {{1, 2, 3}, {4, 5, 6}});
        IntegerMatrix secondMatrix = new IntegerMatrix(new int[][] {{7, 8}, {9, 10}, {11, 12}});
        
        try {
           System.out.println(firstMatrix.multiplication(secondMatrix).toString());
        }catch (IllegalArgumentException ex){
           System.out.println(ex.getMessage());
        }
    }

}
