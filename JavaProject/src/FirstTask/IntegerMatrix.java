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

        int sum = 0;
        final int linesL = this.linesLength;
        final int matColumnsL = mat.columnsLength;
        final int columnsL = this.columnsLength;
        for (int i = 0; i < linesL; i++) {
            for (int j = 0; j < matColumnsL; j++) {
                for (int k = 0; k < columnsL; k++) {
                    sum += this.matrix[i][k] * mat.matrix[k][j];
                }

                resultData[i][j] = sum;
                sum = 0;
            }
        }

        return new IntegerMatrix(resultData);
    }








    public static void main(String[] args) {
        IntegerMatrix firstMatrix = new IntegerMatrix(new int[][] {{0,0,1,0}, {0,0,0,1}, {0,1,0,0}, {1,0,0,0}});
        IntegerMatrix secondMatrix = new IntegerMatrix(new int[][] {{1,1,1,0}, {1,1,0,1}, {0,1,1,1},{1,0,1,1}});
        try {


            System.out.println(firstMatrix.multiplication(secondMatrix).toString());
        }catch (IllegalArgumentException ex){
           System.out.println(ex.getMessage());
        }
        firstMatrix = null;
        secondMatrix = null;
    }

}
