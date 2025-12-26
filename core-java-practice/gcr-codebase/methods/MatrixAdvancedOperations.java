public class MatrixAdvancedOperations {
    // Create random matrix
    public static double[][] randomMatrix(int r, int c) {
        double[][] m = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m[i][j] = (int)(Math.random() * 9 + 1); 
        return m;
    }

    public static double[][] transpose(double[][] m) {
        double[][] t = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                t[j][i] = m[i][j];
        return t;
    }

    // Determinant of 2x2 matrix
    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    // Determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        return new double[][] {
            {  m[1][1]/det, -m[0][1]/det },
            { -m[1][0]/det,  m[0][0]/det }
        };
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] adj = new double[3][3];

        adj[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        adj[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        adj[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);

        adj[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        adj[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);

        adj[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        adj[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);
        adj[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        double[][] adjT = transpose(adj);
        double[][] inv = new double[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] = Math.round((adjT[i][j] / det) * 100.0) / 100.0;
        return inv;
    }

    // Display matrix
    public static void display(double[][] m) {
        if (m == null) {
            System.out.println("Inverse not possible");
            return;
        }
        for (double[] row : m) {
            for (double v : row)
                System.out.print(v + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("2x2 Matrix:");
        double[][] m2 = randomMatrix(2, 2);
        display(m2);

        System.out.println("\nTranspose:");
        display(transpose(m2));

        System.out.println("\nDeterminant: " + determinant2x2(m2));

        System.out.println("\nInverse:");
        display(inverse2x2(m2));

        System.out.println("\n----------------------------");

        System.out.println("\n3x3 Matrix:");
        double[][] m3 = randomMatrix(3, 3);
        display(m3);

        System.out.println("\nTranspose:");
        display(transpose(m3));

        System.out.println("\nDeterminant: " + determinant3x3(m3));

        System.out.println("\nInverse:");
        display(inverse3x3(m3));
    }
}
