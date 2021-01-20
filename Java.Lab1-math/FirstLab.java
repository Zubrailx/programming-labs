public class FirstLab {
    public static void main(String[] args) {
        final int COLS = 7;
        final int ROWS = 18;
        int[] d = new int[COLS];
        int count = 0;
        for (int i = 17; i >= 5; i -= 2) {                              // Ввод чисел от 17 до 5
            d[count] = i;
            count++;
        }
        double[] x = new double[ROWS];
        for (int i = 0; i < ROWS; i++) {                             // Ввод случайных чисел
            x[i] = Math.random() * 27 - 13;
        }
        double[][] d2 = new double[COLS][ROWS];
        for (int i = 0; i < COLS; i++) {                               //Выполение выбранных мат.операций
            for (int j = 0; j < ROWS; j++) {                         //И занесение результатов в матрицу
                if (d[i] == 9) {
                    d2[i][j] = Math.cbrt(Math.pow((0.5 - Math.pow((2 * x[j]), 3)), 2));
                } else if (d[i] == 7 || d[i] == 11 || d[i] == 17) {
                    d2[i][j] = Math.cbrt(Math.atan(0.2 * (x[j] + 0.5) / 27));
                } else {
                    d2[i][j] = Math.pow(3.0 + Math.cbrt(x[j]), 2);
                }
            }
        }
        for (int i = 0; i < COLS; i++) {                                   // Вывод матрицы
            for (int j = 0; j < ROWS; j++) {
                System.out.printf("%12.5f", d2[i][j]);
            }
            System.out.println();
        }
    }
}
